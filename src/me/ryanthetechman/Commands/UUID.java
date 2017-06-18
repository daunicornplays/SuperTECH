package me.ryanthetechman.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class UUID implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	Player player = (Player) sender;
		if (args.length == 1) {
			getName(args[1]);

		}

		return false;
	}

	public void getName(String uuid) {
		//public String = (player) Bukkit.getPlayer(uuid).getName();
	}
}
