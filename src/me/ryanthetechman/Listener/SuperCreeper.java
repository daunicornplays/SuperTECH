package me.ryanthetechman.Listener;

import org.bukkit.Material;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.plugin.Plugin;

public class SuperCreeper implements Listener {
	Plugin plugin;

	public SuperCreeper(Plugin plugin) {
		this.plugin = plugin;
	}

	@EventHandler(priority = EventPriority.HIGH)
	public void onCreeperExplode(EntityExplodeEvent event) {
		Entity e = event.getEntity();
		if ((e instanceof Creeper)) {
			Creeper creeper = (Creeper) e;
			if (creeper.isPowered()) {
				creeper.getLocation().getWorld().spawnEntity(creeper.getLocation().add(0.0D, 0.0D, 0.0D),
						EntityType.PRIMED_TNT);
				creeper.getLocation().subtract(0.0D, 1.0D, 0.0D).getBlock().setType(Material.TNT);
				creeper.getLocation().subtract(1.0D, 1.0D, 0.0D).getBlock().setType(Material.TNT);
				creeper.getLocation().subtract(-1.0D, 1.0D, 0.0D).getBlock().setType(Material.TNT);
				creeper.getLocation().subtract(0.0D, 1.0D, 1.0D).getBlock().setType(Material.TNT);
				creeper.getLocation().subtract(0.0D, 1.0D, -1.0D).getBlock().setType(Material.TNT);
				creeper.getLocation().subtract(1.0D, 1.0D, 1.0D).getBlock().setType(Material.TNT);
				creeper.getLocation().subtract(-1.0D, 1.0D, -1.0D).getBlock().setType(Material.TNT);
				creeper.getLocation().subtract(1.0D, 1.0D, -1.0D).getBlock().setType(Material.TNT);
				creeper.getLocation().subtract(-1.0D, 1.0D, 1.0D).getBlock().setType(Material.TNT);
				creeper.getLocation().add(0.0D, 1.0D, 0.0D).getBlock().setType(Material.TNT);
				creeper.getLocation().add(1.0D, 1.0D, 0.0D).getBlock().setType(Material.TNT);
				creeper.getLocation().add(-1.0D, 1.0D, 0.0D).getBlock().setType(Material.TNT);
				creeper.getLocation().add(0.0D, 1.0D, 1.0D).getBlock().setType(Material.TNT);
				creeper.getLocation().add(0.0D, 1.0D, -1.0D).getBlock().setType(Material.TNT);
				creeper.getLocation().add(1.0D, 1.0D, 1.0D).getBlock().setType(Material.TNT);
				creeper.getLocation().add(-1.0D, 1.0D, -1.0D).getBlock().setType(Material.TNT);
				creeper.getLocation().add(1.0D, 1.0D, -1.0D).getBlock().setType(Material.TNT);
				creeper.getLocation().add(-1.0D, 1.0D, 1.0D).getBlock().setType(Material.TNT);
			}
		}
	}
}
