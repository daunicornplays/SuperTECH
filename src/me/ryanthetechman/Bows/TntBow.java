package me.ryanthetechman.Bows;

import me.ryanthetechman.Main;
import me.ryanthetechman.Utilities.Wait;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.util.BlockIterator;

import java.util.HashMap;
@SuppressWarnings("deprecation")
public class TntBow implements Listener {

    Main plugin;

    public TntBow(Main plugin) {
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
                        (((Player)a.getShooter()).getItemInHand().getItemMeta().getDisplayName().equals(""+ChatColor.RED + ChatColor.BOLD + "Tnt Bow"))) {
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
        if (player.hasPermission("supertech.bow.tnt")) {
            Arrow a = (Arrow)event.getEntity();
            if (shooterLoc.containsKey(a.getShooter().toString())) {
                //hitBlock.getLocation().getWorld().spawnEntity(hitBlock.getLocation().add(0.0D, 5.0D, 0.0D), EntityType.PRIMED_TNT).setVelocity(a.getLocation().getDirection().multiply(0D).setY(1.95D));
                Entity tnt = hitBlock.getLocation().getWorld().spawnEntity(hitBlock.getLocation().add(0.0D, 1.3D, 0.0D), EntityType.PRIMED_TNT);
                TNTPrimed tnt2 = (TNTPrimed) tnt;
                tnt2.setVelocity(a.getLocation().getDirection().multiply(0D).setY(5D));
                hitBlock.getWorld().playEffect(hitBlock.getLocation(), Effect.ENDERDRAGON_SHOOT, hitBlock.getTypeId());
                event.getEntity().remove();
                if(!(tnt2.getLocation().add(0D,1D,0D).getBlock().getType() == Material.AIR) ||
                        !(tnt2.getLocation().add(0D,2D,0D).getBlock().getType() == Material.AIR) ||
                        !(tnt2.getLocation().add(0D,3D,0D).getBlock().getType() == Material.AIR) ||
                        !(tnt2.getLocation().add(0D,4D,0D).getBlock().getType() == Material.AIR) ||
                        !(tnt2.getLocation().add(0D,5D,0D).getBlock().getType() == Material.AIR) ||
                        !(tnt2.getLocation().add(0D,6D,0D).getBlock().getType() == Material.AIR) ||
                        !(tnt2.getLocation().add(0D,7D,0D).getBlock().getType() == Material.AIR) ||
                        !(tnt2.getLocation().add(0D,8D,0D).getBlock().getType() == Material.AIR) ||
                        !(tnt2.getLocation().add(0D,9D,0D).getBlock().getType() == Material.AIR)){
                    tnt2.setFuseTicks(0);
                }
                else{
                    tnt2.setFuseTicks(170);
                }
                /*if(tnt2.getVelocity().getY() <= 4.99D){
                    player.sendMessage("false");
                    tnt2.setFuseTicks(0);
                }
                else{
                    player.sendMessage("true");
                    tnt2.setFuseTicks(170);
                }*/
            }
            else{
                lBowArrows.clear();
                shooterLoc.clear();
            }
        }

    }
}
