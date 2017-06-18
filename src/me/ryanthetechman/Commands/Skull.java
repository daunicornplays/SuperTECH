package me.ryanthetechman.Commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.Plugin;

public class Skull implements CommandExecutor {
	Plugin plugin;


	public Skull(Plugin passedPlugin) {
		this.plugin = passedPlugin;
	}

	public boolean onCommand(CommandSender sender, Command command, String cmdLabel, String[] args) {
		Player player = (Player) sender;
		int length = args.length;
		if (length == 0) {
			ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());

			SkullMeta meta = (SkullMeta) skull.getItemMeta();
			meta.setOwner(player.getPlayer().getName());
			meta.setDisplayName(ChatColor.GREEN + player.getPlayer().getName() + "'s Head!");
			skull.setItemMeta(meta);
			player.getPlayer().getInventory().addItem(new ItemStack[] { skull });
			player.sendMessage(ChatColor.GREEN + "Your head fell off. It's in your inventory.");
		} else if (length == 1) {
			ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());

			SkullMeta meta = (SkullMeta) skull.getItemMeta();
			meta.setOwner(args[0]);
			meta.setDisplayName(ChatColor.GREEN + args[0] + "'s Head!");
			skull.setItemMeta(meta);
			player.getPlayer().getInventory().addItem(new ItemStack[] { skull });
			player.sendMessage(
					ChatColor.GREEN + "The player, " + args[0] + ", head has fallen off. Now it's in your inventory.");
		} else {
			player.sendMessage(ChatColor.RED + "Incorrect arguments");
		}

		return false;
	}
}
