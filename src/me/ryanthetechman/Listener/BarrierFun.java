package me.ryanthetechman.Listener;

import org.bukkit.Material;
import org.bukkit.entity.Fireball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;

public class BarrierFun implements Listener {

	Plugin plugin;

	public BarrierFun(Plugin plugin) {
		this.plugin = plugin;
	}

	/*
	 * boolean playerSneaking=false;
	 * 
	 * @EventHandler public void isPlayerSneaking(PlayerToggleSneakEvent e){
	 * Player player = e.getPlayer(); if(player.isSneaking()) { boolean
	 * playerSneaking = true; } else { boolean playerSneaking = false; return;}
	 * }
	 */

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		if (((e.getPlayer().hasPermission("supertech.all"))) || (e.getPlayer().hasPermission("supertech.BarrierFun"))) {
			if (!(e.getAction() == Action.RIGHT_CLICK_AIR))
				return;

			if (!(e.getItem().getType() == Material.BARRIER))
				return;

			Fireball f = e.getPlayer().launchProjectile(Fireball.class);
			f.setIsIncendiary(false);
			f.setYield(0);

		}
	}
}