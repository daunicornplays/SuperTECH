package me.ryanthetechman.Listener;

import me.ryanthetechman.Main;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.util.BlockIterator;

import java.util.HashMap;
import java.util.Random;

@SuppressWarnings("deprecation")
public class SmiteBow implements Listener{

    Main plugin;

    public SmiteBow(Main plugin) {
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
                        (((Player)a.getShooter()).getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.AQUA + "Lightning Bow"))) {
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
        if (player.hasPermission("supertech.smite.bow")) {
            Arrow a = (Arrow)event.getEntity();
            if (shooterLoc.containsKey(a.getShooter().toString())) {
            hitBlock.getWorld().strikeLightning(hitBlock.getLocation());
                hitBlock.getWorld().playEffect(hitBlock.getLocation(), Effect.ENDERDRAGON_SHOOT, hitBlock.getTypeId());
                event.getEntity().remove();
        }
            else{
                lBowArrows.clear();
                shooterLoc.clear();
            }
        }

    }
    }
