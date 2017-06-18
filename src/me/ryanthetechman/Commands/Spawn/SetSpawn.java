package me.ryanthetechman.Commands.Spawn;

import static org.bukkit.ChatColor.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.ryanthetechman.Main;

public class SetSpawn implements CommandExecutor, Listener {

	Main plugin;

	public SetSpawn(Main passedPlugin) {
		this.plugin = passedPlugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (p.hasPermission("supertech.setspawn")) {
			if (args.length == 0) {
				if (sender instanceof Player) {

					double X = Math.round(p.getLocation().getX() * 100) / 100.0d;
					double Y = Math.round(p.getLocation().getY() * 100) / 100.0d;
					double Z = Math.round(p.getLocation().getZ() * 100) / 100.0d;
					double Yaw = Math.round(p.getLocation().getYaw() * 100) / 100.0d;
					double Pitch = Math.round(p.getLocation().getPitch() * 100) / 100.0d;

					this.plugin.spawn.getConfig().set("Spawn.X", X);
					this.plugin.spawn.getConfig().set("Spawn.Y", Y);
					this.plugin.spawn.getConfig().set("Spawn.Z", Z);
					this.plugin.spawn.getConfig().set("Spawn.Pitch", Pitch);
					this.plugin.spawn.getConfig().set("Spawn.Yaw", Yaw);
					plugin.spawn.saveConfig();
					plugin.spawn.reloadConfig();

					p.sendMessage(GREEN + "You Have Set Spawn To:");
					p.sendMessage(GOLD + "X: " + GREEN + this.plugin.spawn.getConfig().get("Spawn.X"));
					p.sendMessage(GOLD + "Y: " + GREEN + this.plugin.spawn.getConfig().get("Spawn.Y"));
					p.sendMessage(GOLD + "Z: " + GREEN + this.plugin.spawn.getConfig().get("Spawn.Z"));
					p.sendMessage(GOLD + "Pitch: " + GREEN + this.plugin.spawn.getConfig().get("Spawn.Pitch"));
					p.sendMessage(GOLD + "Yaw: " + GREEN + this.plugin.spawn.getConfig().get("Spawn.Yaw"));
				} else {
					p.sendMessage(RED + "You Must Be A Player To Run This Command!");
				}
			}
		}
		return false;
	}
}
