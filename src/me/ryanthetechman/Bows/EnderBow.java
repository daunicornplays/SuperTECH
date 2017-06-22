package me.ryanthetechman.Bows;

import me.ryanthetechman.Main;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.util.BlockIterator;

import java.util.HashMap;

@SuppressWarnings("deprecation")
public class EnderBow implements Listener {

    Main plugin;

    public EnderBow(Main plugin) {
        this.plugin = plugin;
    }
    HashMap<String, Integer> lBowArrows = new HashMap();
    HashMap<String, Location> shooterLoc = new HashMap();

    @EventHandler
    public void onLaunch(ProjectileLaunchEvent e)
    {
        if ((e.getEntity() instanceof Arrow))
        {
            Arrow a = (Arrow)e.getEntity();
            if ((a.getShooter() instanceof Player))
            {
                Location l = ((Player)a.getShooter()).getLocation();
                if ((((Player)a.getShooter()).getItemInHand().getItemMeta().getDisplayName() != null) &&
                        (((Player)a.getShooter()).getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.LIGHT_PURPLE + "Ender Bow"))) {

                    lBowArrows.put(a.getShooter().toString(), Integer.valueOf(a.getEntityId()));
                    shooterLoc.put(a.getShooter().toString(), l);
                }
                else{
                    lBowArrows.clear();
                    shooterLoc.clear();
                }
            }
        }}

    @EventHandler
    public void onHit(ProjectileHitEvent event)
    {

        BlockIterator iterator = new BlockIterator(event.getEntity().getWorld(), event.getEntity().getLocation().toVector(), event.getEntity().getVelocity().normalize(), 0.0D, 4);
        Block hitBlock = null;
        while (iterator.hasNext())
        {
            hitBlock = iterator.next();
            if (hitBlock.getTypeId() != 0) {
                break;
            }
        }

        Player player = (Player)event.getEntity().getShooter();
        if (player.hasPermission("supertech.bow.ender")) {
            Arrow a = (Arrow)event.getEntity();
            if (shooterLoc.containsKey(a.getShooter().toString())) {
                player.teleport(a.getLocation().add(0D, 1D, 0D));
                event.getEntity().remove();
            }
            else{
                lBowArrows.clear();
                shooterLoc.clear();
            }
        }

    }
}
