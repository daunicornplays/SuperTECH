package me.ryanthetechman.Listener;

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

	Plugin plugin;

	public JumpPads(Plugin plugin) {
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
			if (e.getTo().getBlock().getRelative(0, 0, 0).getType() == Material.STONE_PLATE
					&& e.getTo().getBlock().getRelative(0, -1, 0).getType() == Material.REDSTONE_BLOCK
					&& e.getTo().getBlock().getRelative(1, -1, 0).getType() == Material.REDSTONE_BLOCK
					&& e.getTo().getBlock().getRelative(0, -1, -1).getType() == Material.REDSTONE_BLOCK
					&& e.getTo().getBlock().getRelative(0, -1, 1).getType() == Material.REDSTONE_BLOCK
					&& e.getTo().getBlock().getRelative(-1, -1, -1).getType() == Material.REDSTONE_BLOCK
					&& e.getTo().getBlock().getRelative(1, -1, 1).getType() == Material.REDSTONE_BLOCK
					&& e.getTo().getBlock().getRelative(-1, -1, 0).getType() == Material.REDSTONE_BLOCK) {
				e.getPlayer().setVelocity(e.getPlayer().getLocation().getDirection().multiply(4));
				e.getPlayer().setVelocity(
						new Vector(e.getPlayer().getVelocity().getX(), 1.0D, e.getPlayer().getVelocity().getZ()));
				jumpers.add(e.getPlayer());
			}
			if (isOnGold && e.getTo().getBlock().getRelative(0, 0, 0).getType() == Material.GOLD_PLATE
					&& e.getTo().getBlock().getRelative(0, -1, 0).getType() == Material.REDSTONE_BLOCK
					&& e.getTo().getBlock().getRelative(1, -1, 0).getType() == Material.REDSTONE_BLOCK
					&& e.getTo().getBlock().getRelative(0, -1, -1).getType() == Material.REDSTONE_BLOCK
					&& e.getTo().getBlock().getRelative(0, -1, 1).getType() == Material.REDSTONE_BLOCK
					&& e.getTo().getBlock().getRelative(-1, -1, -1).getType() == Material.REDSTONE_BLOCK
					&& e.getTo().getBlock().getRelative(1, -1, 1).getType() == Material.REDSTONE_BLOCK
					&& e.getTo().getBlock().getRelative(-1, -1, 0).getType() == Material.REDSTONE_BLOCK) {
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
