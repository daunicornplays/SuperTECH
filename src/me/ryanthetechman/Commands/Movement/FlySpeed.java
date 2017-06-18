package me.ryanthetechman.Commands.Movement;

import me.ryanthetechman.Main;
import static org.bukkit.ChatColor.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class FlySpeed implements CommandExecutor {
	Main plugin;

	public FlySpeed(Main passedPlugin) {
		this.plugin = passedPlugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		Player player = (Player) sender;
		if ((sender instanceof Player) && plugin.movement.getConfig().getBoolean("FlySpeed.Enabled")) {
			if (args.length == 0) {
				player.sendMessage(RED + "Please Enter a Number Between " + GOLD +"[-10 and 10]");
				return false;
			}
			if (args.length == 1) {
				int speed = 1;
				try {
					speed = Integer.parseInt(args[0]);
				} catch (NumberFormatException e) {
					player.sendMessage(RED + "Only integer values are allowed here Ex: -2,-1,0,1,2,3...");
					return true;
				}
				if (player.hasPermission("supertech.flyspeed.10")) {
					if ((speed < -10) || (speed > 10)) {
						player.sendMessage(RED + "Speed can't be less than -10 or more than 10");
					} else {
						player.setFlySpeed(speed / 10.0F);
						player.sendMessage(GREEN + "Flyspeed set to " + GOLD+ speed);
					}
					return true;
				}
				if (player.hasPermission("supertech.flyspeed.9")) {
					if ((speed <= 9) && (speed >= -9)) {
						player.setFlySpeed(speed / 10.0F);
                        player.sendMessage(GREEN + "Flyspeed set to " + GOLD+ speed);
					} else {
						player.sendMessage(RED + "You don't have permission to use /FlySpeed");
					}
					return true;
				}
				if (player.hasPermission("supertech.flyspeed.8")) {
					if ((speed <= 8) && (speed >= -8)) {
						player.setFlySpeed(speed / 10.0F);
                        player.sendMessage(GREEN + "Flyspeed set to " + GOLD+ speed);
					} else {
                        player.sendMessage(RED + "You don't have permission to use /FlySpeed");
					}
					return true;
				}
				if (player.hasPermission("supertech.flyspeed.7")) {
					if ((speed <= 7) && (speed >= -7)) {
						player.setFlySpeed(speed / 10.0F);
                        player.sendMessage(GREEN + "Flyspeed set to " + GOLD+ speed);
					} else {
                        player.sendMessage(RED + "You don't have permission to use /FlySpeed");
					}
					return true;
				}
				if (player.hasPermission("supertech.flyspeed.6")) {
					if ((speed <= 6) && (speed >= -6)) {
						player.setFlySpeed(speed / 10.0F);
                        player.sendMessage(GREEN + "Flyspeed set to " + GOLD+ speed);
					} else {
                        player.sendMessage(RED + "You don't have permission to use /FlySpeed");
					}
					return true;
				}
				if (player.hasPermission("supertech.flyspeed.5")) {
					if ((speed <= 5) && (speed >= -5)) {
						player.setFlySpeed(speed / 10.0F);
                        player.sendMessage(GREEN + "Flyspeed set to " + GOLD+ speed);
					} else {
                        player.sendMessage(RED + "You don't have permission to use /FlySpeed");
					}
					return true;
				}
				if (player.hasPermission("supertech.flyspeed.4")) {
					if ((speed <= 4) && (speed >= -4)) {
						player.setFlySpeed(speed / 10.0F);
                        player.sendMessage(GREEN + "Flyspeed set to " + GOLD+ speed);
					} else {
                        player.sendMessage(RED + "You don't have permission to use /FlySpeed");
					}
					return true;
				}
				if (player.hasPermission("supertech.flyspeed.3")) {
					if ((speed <= 3) && (speed >= -3)) {
						player.setFlySpeed(speed / 10.0F);
                        player.sendMessage(GREEN + "Flyspeed set to " + GOLD+ speed);
					} else {
                        player.sendMessage(RED + "You don't have permission to use /FlySpeed");
					}
					return true;
				}
				if (player.hasPermission("supertech.flyspeed.2")) {
					if ((speed <= 2) && (speed >= -2)) {
						player.setFlySpeed(speed / 10.0F);
                        player.sendMessage(GREEN + "Flyspeed set to " + GOLD+ speed);
					} else {
						player.sendMessage("You don't have permission to do that");
					}
					return true;
				}
                player.sendMessage(RED + "You don't have permission to use /FlySpeed");

				return true;
			}
		}

		return false;
	}
}
