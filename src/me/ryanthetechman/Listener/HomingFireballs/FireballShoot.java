package me.ryanthetechman.Listener.HomingFireballs;

import java.util.HashMap;

import me.ryanthetechman.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

public class FireballShoot implements Listener {
	private HashMap<Player, Entity> fireballShooter = new HashMap<Player, Entity>();

	public FireballShoot(Main plugin) {
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
			public void run() {
				for (Player p : FireballShoot.this.fireballShooter.keySet()) {
					Entity f = (Entity) FireballShoot.this.fireballShooter.get(p);
					if ((f.isDead()) || (p.getLocation().distance(f.getLocation()) > 80.0D)) {
						f.remove();
						FireballShoot.this.fireballShooter.remove(p);
						return;
					}
					Vector v = p.getLocation().getDirection();
					f.setVelocity(v);
				}
			}
		}, 0L, 1L);
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void shootFireball(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (((e.getPlayer().hasPermission("supertech.all")))
				|| (e.getPlayer().hasPermission("supertech.HomingFireball"))) {
			if (p.getItemInHand().getType() == Material.BLAZE_ROD) {
				Location loc = p.getLocation();
				Entity f = loc.getWorld().spawnEntity(loc.add(loc.getDirection()), EntityType.FIREBALL);
				f.setVelocity(loc.getDirection().multiply(1));
				this.fireballShooter.put(p, f);
			}
		}
	}
}
