package me.ryanthetechman.Commands;

import me.ryanthetechman.Commands.Movement.WalkSpeed;
import me.ryanthetechman.Main;
import mkremins.fanciful.FancyMessage;
import static org.bukkit.ChatColor.*;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SuperTech implements CommandExecutor {
    String s2;
    Main plugin;

    public SuperTech(Main passedPlugin) {
        this.plugin = passedPlugin;
    }


    public boolean onCommand(CommandSender sender, Command command, String cmdLabel, String[] args) {
        Player p = (Player) sender;
        if (args.length == 0) {
            String Separator = GREEN + " | " + GOLD;
            p.sendMessage(LIGHT_PURPLE + "----------------------------------------------------");
            p.sendMessage(GOLD + "Here is a list of commands you can run:");
            p.sendMessage(GOLD + "/tpo" + Separator + "/tpohere" + Separator + "/supertech reload" + Separator
                    + "/spawn" + Separator + "/setspawn");
            p.sendMessage(LIGHT_PURPLE + "----------------------------------------------------");
            return true;
        }
        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("reload")) {

                if (!(plugin.config.getConfig().getBoolean("WalkSpeed.Enabled"))) {
                    for (Player player : Bukkit.getOnlinePlayers()) {
                        player.setWalkSpeed(1 / 10.0F);
                    }
                }

                if (!(plugin.doublejump.getConfig().getBoolean("Enabled"))) {
                    for (Player player : Bukkit.getOnlinePlayers()) {
                        if (player.getGameMode() != GameMode.CREATIVE || player.getGameMode() != GameMode.SPECTATOR) {
                            player.setAllowFlight(false);
                            player.setFlying(false);
                        }
                    }
                }
               else p.sendMessage(GREEN + "SuperTech Config Has Been Reloaded!");
            }
        }
        if (args[0].equalsIgnoreCase("config")) {
            p.sendMessage(GREEN + "Highlight Over a Section To Expand!");
            p.sendMessage(GREEN + "Here Is The Config Data:");
            new FancyMessage(GOLD + "DoubleJump").tooltip(
                    GOLD + "Enabled: " + GREEN + plugin.doublejump.getConfig().getString("Enabled") + "\n" +
                            GOLD + "Power X: " + GREEN + plugin.doublejump.getConfig().getString("PowerValues.X") + "\n" +
                            GOLD + "Power Y: " + GREEN + plugin.doublejump.getConfig().getString("PowerValues.Y")).send(sender);
            new FancyMessage(GOLD + "Spawn").tooltip(
                    GOLD + "Location: \n    " + GOLD + "X: " + GREEN + plugin.spawn.getConfig().getString("Spawn.X") + "\n" +
                            GOLD + "    Y: " + GREEN + plugin.spawn.getConfig().getString("Spawn.Y") + "\n" +
                            GOLD + "    Z: " + GREEN + plugin.spawn.getConfig().getString("Spawn.Z") + "\n" +
                            GOLD + "Particles: " + GREEN + plugin.spawn.getConfig().getString("Spawn.Particles")).send(sender);
            new FancyMessage(GOLD + "Movement").tooltip(
                    GOLD + "FlySpeedEnabled: " + GREEN + plugin.config.getConfig().getString("FlySpeed.Enabled") + "\n" +
                            GOLD + "Your FlySpeed: " + GREEN + p.getFlySpeed() * 10.0F + "\n\n" +
                            GOLD + "WalkSpeedEnabled: " + GREEN + plugin.config.getConfig().getString("WalkSpeed.Enabled") + "\n" +
                            GOLD + "Your WalkSpeed: " + GREEN + p.getWalkSpeed() * 10.0F).send(sender);
            return true;
        }
        if (args[0].equalsIgnoreCase("reload")) {

            if (args.length == 1) {
                //DoubleJumpConfig(((Player) sender).getPlayer());
                plugin.doublejump.reloadConfig();
                plugin.movement.reloadConfig();
                plugin.messages.reloadConfig();
                plugin.config.reloadConfig();
                if (!(plugin.config.getConfig().getBoolean("FlySpeed.Enabled"))) {
                    for (Player player : Bukkit.getOnlinePlayers()) {
                        player.setFlySpeed(1 / 10.0F);
                    }
                }
                if (!(plugin.config.getConfig().getBoolean("WalkSpeed.Enabled"))) {
                    for (Player player : Bukkit.getOnlinePlayers()) {
                        player.setWalkSpeed(1 / 10.0F);
                    }
                }
            }

           else if (args.length == 2) {

                if (args[1].equalsIgnoreCase("main")) {
                    plugin.config.reloadConfig();
                    p.sendMessage(GREEN + "You Have Reloaded The Main Config!");
                    return true;//read logs
                }
                if (args[1].equalsIgnoreCase("doublejump")) {
                    plugin.doublejump.reloadConfig();
                    p.sendMessage(GREEN + "You Have Reloaded The DoubleJump Config!");
                    return true;
                }
                if (args[1].equalsIgnoreCase("movement")) {
                    plugin.movement.reloadConfig();
                    p.sendMessage(GREEN + "You Have Reloaded The Movement Config!");
                    return true;
                }
                if (args[1].equalsIgnoreCase("messages")) {
                    plugin.messages.reloadConfig();
                    p.sendMessage(GREEN + "You Have Reloaded The Messages Config!");
                    return true;
                }

                else {
                    p.sendMessage(RED + "That is Not a Valid Name For a Config in Super Tech!");
                    p.sendMessage(GREEN + "Here Is a List of Configs For Super Tech \n" +
                            GOLD + "Click a Name to Get The Command!");
                    new FancyMessage(GOLD + "Main").suggest("/supertech reload Main").send(sender);
                    new FancyMessage(GOLD + "DoubleJump").suggest("/supertech reload DoubleJump").send(sender);
                    new FancyMessage(GOLD + "Movement").suggest("/supertech reload Movement").send(sender);
                    new FancyMessage(GOLD + "Messages").suggest("/supertech reload Messages").send(sender);
                    return true;
                }
            }


        }
        return false;
    }

    private void DoubleJumpConfig(Player p) {
		/*boolean DJBooleanOld = this.plugin.getConfig().getBoolean("DoubleJumpEnabled");
		int DoubleJumpXOld = this.plugin.getConfig().getInt("DoubleJumpX");
		int DoubleJumpYOld = this.plugin.getConfig().getInt("DoubleJumpY");
		this.plugin.config.reloadConfig();
		boolean DJBooleanNew = this.plugin.getConfig().getBoolean("DoubleJumpEnabled");
		int DoubleJumpXNew = this.plugin.getConfig().getInt("DoubleJumpX");
		int DoubleJumpYNew = this.plugin.getConfig().getInt("DoubleJumpY");
		boolean DoubleJumpXIsNumber = true;
		boolean DoubleJumpYIsNumber = true;
		boolean changed = false;
		boolean DJEnabled = false;
		if (((!DJBooleanNew) && (DoubleJumpXOld != DoubleJumpXNew)) || (DoubleJumpYOld != DoubleJumpYNew)) {
			p.sendMessage(ChatColor.GOLD + "DoubleJump is " + ChatColor.RED + "NOT " + ChatColor.GOLD + "Enabled!");
		}
		if (DoubleJumpXNew <= 0) {
			p.sendMessage(ChatColor.GOLD + "DoubleJumpX = " + ChatColor.RED + " Invalid Number!" + ChatColor.GREEN
					+ " Must be a Number Above 0!");
			DoubleJumpXIsNumber = false;
		}
		if (DoubleJumpYNew <= 0) {
			p.sendMessage(ChatColor.GOLD + "DoubleJumpY = " + ChatColor.RED + " Invalid Number!" + ChatColor.GREEN
					+ " Must be a Number Above 0!");
			DoubleJumpYIsNumber = false;
		}
		if (DJBooleanNew) {
			DJEnabled = true;
		} else {
			DJEnabled = false;
		}
		if (DJBooleanOld != DJBooleanNew) {
			if (DJEnabled) {
				p.sendMessage(ChatColor.GOLD + "DoubleJump has been " + ChatColor.GREEN + "Enabled!");
			} else {
				p.sendMessage(ChatColor.GOLD + "DoubleJump has been " + ChatColor.RED + "Disabled!");
			}
			changed = true;
		}
		if (DoubleJumpXOld != DoubleJumpXNew) {
			if (!DoubleJumpXIsNumber) {
				p.sendMessage(ChatColor.GOLD + "DoubleJumpX = " + ChatColor.RED + "Invalid Number" + ChatColor.GOLD
						+ " Changed To " + ChatColor.GREEN + DoubleJumpXNew);
			} else {
				p.sendMessage(ChatColor.GOLD + "DoubleJumpX = " + ChatColor.RED + DoubleJumpXOld + ChatColor.GOLD
						+ " Changed To " + ChatColor.GREEN + DoubleJumpXNew);
			}
			changed = true;
		}
		if (DoubleJumpYOld != DoubleJumpYNew) {
			if (!DoubleJumpYIsNumber) {
				p.sendMessage(ChatColor.GOLD + "DoubleJumpY = " + ChatColor.RED + "Invalid Number" + ChatColor.GOLD
						+ " Changed To " + ChatColor.GREEN + DoubleJumpYNew);
			} else {
				p.sendMessage(ChatColor.GOLD + "DoubleJumpY = " + ChatColor.RED + DoubleJumpYOld + ChatColor.GOLD
						+ " Changed To " + ChatColor.GREEN + DoubleJumpYNew);
			}
			changed = true;
		}
		if (!changed) {
			p.sendMessage(ChatColor.RED + "Nothing Changed!");
		}
		return;*/
    }


}
