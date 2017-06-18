package me.ryanthetechman.Commands.Tpo;

import java.util.Iterator;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.ryanthetechman.Main;
@SuppressWarnings("all")
public class Tpo implements CommandExecutor, Listener {
	public Tpo(Main main) {
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		Player p = (Player) sender;
		if (((sender instanceof Player))
				&& (((cmd.getName().equalsIgnoreCase("tpo")) && (p.hasPermission("supertech.all")))
						|| (p.hasPermission("supertech.tpo")))) {
			int length = args.length;
			if (length == 0) {
				p.sendMessage(ChatColor.RED + "Please Enter a Player Name To Teleport To!");
				p.sendMessage(ChatColor.RED + "/tpo [Player Name] <Player Name>");
			}
			if (length == 1) {
				boolean player1Found = false;
				boolean player2Found = false;
				
				Iterator var9 = Bukkit.getServer().getOnlinePlayers().iterator();
				while (var9.hasNext()) {
					Player p1 = (Player) var9.next();
					if (p1.getName().equalsIgnoreCase(args[0])) {
						if (p1.isFlying()) {
							p.setAllowFlight(true);
							p.setFlying(true);
						}
						p.teleport(p1);
						p.setVelocity(p1.getVelocity());
						if (p1.getName() == p.getName()) {
							player2Found = true;
						}
						if (!player2Found) {
							p.sendMessage(ChatColor.GREEN + "You have teleported to " + ChatColor.GOLD + args[0]);
						}
						if (player2Found) {
							p.sendMessage(ChatColor.GREEN + "You have teleported to " + ChatColor.GOLD + "Yourself!");
						}
						player1Found = true;
					}
				}
				if (!player1Found) {
					p.sendMessage(ChatColor.RED + "The player " + args[0] + " was not found!");
				}
			} else if (length == 2) {
				boolean player1Found = false;
				boolean player2Found = false;
				boolean SelfTP = false;
				Player p1 = p.getServer().getPlayer(args[0]);
				Iterator var11 = Bukkit.getServer().getOnlinePlayers().iterator();
				while (var11.hasNext()) {
					Player player1 = (Player) var11.next();
					if (player1.getName().equalsIgnoreCase(args[0])) {
						player1Found = true;
						break;
					}
				}
				if (!player1Found) {
					p.sendMessage(ChatColor.RED + "The player " + ChatColor.GOLD + args[0] + ChatColor.RED
							+ " was not found!");
				}
				Player p2 = p.getServer().getPlayer(args[1]);
				Iterator var16 = Bukkit.getServer().getOnlinePlayers().iterator();
				while (var16.hasNext()) {
					Player player2 = (Player) var16.next();
					if (player2.getName().equalsIgnoreCase(args[1])) {
						player2Found = true;
						break;
					}
				}
				if (!player2Found) {
					p.sendMessage(ChatColor.RED + "The player " + ChatColor.GOLD + args[1] + ChatColor.RED
							+ " was not found!");
				}
				if ((p2.getName() == p.getName()) && (p1.getName() == p.getName())) {
					SelfTP = true;
				}
				Location p2Loc = p2.getLocation();
				if ((player1Found) && (player2Found)) {
					p1.teleport(p2Loc);
					if (!SelfTP) {
						p.sendMessage(ChatColor.GREEN + "You have teleported " + ChatColor.GOLD + args[0]
								+ ChatColor.GREEN + " to " + ChatColor.GOLD + args[1]);
					}
					if (SelfTP) {
						p.sendMessage(ChatColor.GREEN + "You have teleported to " + ChatColor.GOLD + "Yourself!");
					}
				}
			} else {
				p.sendMessage(ChatColor.RED + "Incorrect arguments");
			}
			return true;
		}
		return false;
	}
}
