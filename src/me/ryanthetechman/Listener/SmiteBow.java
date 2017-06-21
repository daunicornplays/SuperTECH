package me.ryanthetechman.Listener;

import me.ryanthetechman.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.util.BlockIterator;
@SuppressWarnings("deprecation")
public class SmiteBow implements Listener{

    Main plugin;

    public SmiteBow(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onBowFire(EntityShootBowEvent event)
    {

        if ((event.getEntity() instanceof Player))
        {
            Player player = (Player)event.getEntity();
            if (!player.hasPermission("supertech.smite.bow"))
            {
                player.sendMessage(ChatColor.RED + "You don't have permission to do that!");
                event.setCancelled(true);
                return;
            }
                if (event.getBow().getEnchantmentLevel(Enchantment.ARROW_FIRE) == 52)
                {
                    event.setCancelled(true);
                    (player.launchProjectile(Snowball.class)).setVelocity(event.getProjectile().getVelocity().multiply(1.5D));
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);

                }
                else
                {}

        }
    }
    public interface Entity{

    }

    @EventHandler
    public void onSnowballHit(ProjectileHitEvent event)
    {
        if(event.getEntity(Snowball)){
        BlockIterator iterator = new BlockIterator(event.getEntity().getWorld(), event.getEntity().getLocation().toVector(), event.getEntity().getVelocity().normalize(), 0.0D, 4);
        Block hitBlock = null;
        while (iterator.hasNext())
        {
            hitBlock = iterator.next();
            if (hitBlock.getTypeId() != 0) {
                break;
            }
        }
        hitBlock.getWorld().playEffect(hitBlock.getLocation(), Effect.STEP_SOUND, hitBlock.getTypeId());
        Player player = (Player)event.getEntity().getShooter();
        if (player.hasPermission("supertech.smite.bow")) {
            hitBlock.getWorld().strikeLightning(hitBlock.getLocation());
        }
    }
    else{}
    }
}
