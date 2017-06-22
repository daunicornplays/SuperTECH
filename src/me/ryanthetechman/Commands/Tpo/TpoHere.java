package me.ryanthetechman.Commands.Tpo;

import java.util.Iterator;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
@SuppressWarnings("all")
public class TpoHere implements CommandExecutor, Listener {
	public boolean onCommand(CommandSender sender, Command cmd, String commandLablel, String[] args) {
		Player p = (Player) sender;
		if ((sender instanceof Player)) {
			if ((cmd.getName().equalsIgnoreCase("tpohere")) && (p.hasPermission("supertech.tpohere"))) {
				int length = args.length;
				if (length == 0) {
					p.sendMessage(ChatColor.RED + "Please Enter a Player Name So We Can Teleport Them To You!");
					p.sendMessage(ChatColor.RED + "/tpohere [Player Name] <Player Name>");
				}
				if (length == 1) {
                    if (args[0].equalsIgnoreCase("all")) {
                        for (Player pl : Bukkit.getOnlinePlayers()) {
                            pl.teleport(p.getLocation());
                        }
                    }
                    else
                        {
                    boolean playerFound = false;
                    Iterator var8 = Bukkit.getServer().getOnlinePlayers().iterator();
                    while (var8.hasNext()) {
                        Player reciver = (Player) var8.next();
                        if (reciver.getName().equalsIgnoreCase(args[0])) {
                            reciver.teleport(p.getLocation());
                            p.sendMessage(ChatColor.GREEN + "You have teleported " + ChatColor.GOLD + args[0]
                                    + ChatColor.GREEN + " To You!");
                            playerFound = true;
                            break;
                        }
                    }
                    if (!playerFound) {
                        p.sendMessage(ChatColor.RED + "The player " + args[0] + " was not found!");
                    }
                }
				}
				else {
					p.sendMessage(ChatColor.RED + "Incorrect arguments");
				}
				return true;
			}
		}
		return false;
	}
}
