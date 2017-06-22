package me.ryanthetechman.Listener;

import me.ryanthetechman.Main;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

import java.util.ArrayList;

public class JumpPads implements Listener {

	Main plugin;

	public JumpPads(Main plugin) {
		this.plugin = plugin;
	}

	private ArrayList<Player> jumpers = new ArrayList<Player>();

	public boolean isOnGold = false;

	public void isOnGold(Player p) {

		if (p.getLocation().getBlock().getRelative(0, 0, 0).getType() == Material.GOLD_PLATE) {
			isOnGold = true;
			return;
		} else {
			isOnGold = false;
			return;
		}
	}

	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		isOnGold(e.getPlayer());
		if (((e.getPlayer().hasPermission("supertech.all"))) || (e.getPlayer().hasPermission("supertech.JumpPads"))) {
            String block = plugin.jumppads.getConfig().getString("BlockToUse");
            String normal = plugin.jumppads.getConfig().getString("Activator.Normal");
            String boosted = plugin.jumppads.getConfig().getString("Activator.Boosted");

			if (e.getTo().getBlock().getRelative(0, 0, 0).equals(normal)
					&& e.getTo().getBlock().getRelative(0, -1, 0).equals(block)
					&& e.getTo().getBlock().getRelative(1, -1, 0).equals(block)
					&& e.getTo().getBlock().getRelative(0, -1, -1).equals(block)
					&& e.getTo().getBlock().getRelative(0, -1, 1).equals(block)
					&& e.getTo().getBlock().getRelative(-1, -1, -1).equals(block)
					&& e.getTo().getBlock().getRelative(1, -1, 1).equals(block)
					&& e.getTo().getBlock().getRelative(-1, -1, 0).equals(block)) {
				e.getPlayer().setVelocity(e.getPlayer().getLocation().getDirection().multiply(4));
				e.getPlayer().setVelocity(
						new Vector(e.getPlayer().getVelocity().getX(), 1.0D, e.getPlayer().getVelocity().getZ()));
				jumpers.add(e.getPlayer());
			}
			if (isOnGold && e.getTo().getBlock().getRelative(0, 0, 0).equals(boosted)
					&& e.getTo().getBlock().getRelative(0, -1, 0).equals(block)
					&& e.getTo().getBlock().getRelative(1, -1, 0).equals(block)
					&& e.getTo().getBlock().getRelative(0, -1, -1).equals(block)
					&& e.getTo().getBlock().getRelative(0, -1, 1).equals(block)
					&& e.getTo().getBlock().getRelative(-1, -1, -1).equals(block)
					&& e.getTo().getBlock().getRelative(1, -1, 1).equals(block)
					&& e.getTo().getBlock().getRelative(-1, -1, 0).equals(block)) {
				e.getPlayer().setVelocity(e.getPlayer().getLocation().getDirection().multiply(5)); //
				e.getPlayer().setVelocity(
						new Vector(e.getPlayer().getVelocity().getX(), 3.0D, e.getPlayer().getVelocity().getZ()));
				jumpers.add(e.getPlayer());
			}
		}
	}

	@EventHandler
	public void onPlayerDamage(EntityDamageEvent e) {
		if (e.getEntity() instanceof Player) {
			Player p = (Player) e.getEntity();
			if (e.getCause() == EntityDamageEvent.DamageCause.FALL && jumpers.contains(p)) {
				e.setDamage(0.0);
				jumpers.remove(p);
			}
		}
	}
}
