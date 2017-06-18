package me.ryanthetechman.Listener;

import me.ryanthetechman.Main;
import mkremins.fanciful.FancyMessage;
import org.bukkit.Bukkit;
import static org.bukkit.ChatColor.*;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

@SuppressWarnings("deprecation")
public class onChat implements Listener {
	Main plugin;

	public onChat(Main plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void CBot(AsyncPlayerChatEvent e) {
		for (Player pl : Bukkit.getOnlinePlayers()) {// K
			if (!e.getPlayer().hasPermission("supertech.staffchat") && e.getMessage().startsWith("@")) {
				plugin.Message("staffchat.nopermmessage", "&cNO PERMS BOI");
				e.getPlayer().sendMessage(plugin.messages.getConfig().getString("staffchat.nopermmessage"));
				e.setCancelled(true);
				return;
			}
			if (pl.hasPermission("supertech.staffchat.see")) {
				if (e.getMessage().startsWith("@" + e.getMessage().replaceFirst("@", ""))) {
					if (e.getMessage().contentEquals("@")) {
						e.setCancelled(true);
						e.getPlayer().sendMessage(RED + "Please supply a message");
						return;
					}
					e.getMessage().replaceFirst("@", "");
					e.setCancelled(true);
					new FancyMessage(GOLD + "StaffChat: ").then(AQUA + e.getMessage().replaceFirst("@", ""))
							.tooltip(GREEN + e.getPlayer().getName() + " \n" + YELLOW + BOLD + "X: " + RESET + YELLOW
									+ (int) e.getPlayer().getLocation().getX() + "\n" + YELLOW + BOLD + "Y: " + RESET
									+ YELLOW + (int) e.getPlayer().getLocation().getY() + "\n" + YELLOW + BOLD + "Z: "
									+ RESET + YELLOW + (int) e.getPlayer().getLocation().getZ())
							.suggest("@" + e.getPlayer().getName() + " ").send(pl);// I believe so OPEN FANCY MESSAGE!
				}
			} //
			else if (!(pl.hasPermission("supertech.staffchat.see"))) {// k
				// e.getPlayer().sendMessage("§CY§Eo§Au§B §9D§Do§Cn§E'§At§B §9H§Da§Cv§Ee§A §BP§9e§Dr§Cm§Es§A §BM§9y§D §CB§EO§AI§B!");
			}
		}
		String item1 = e.getPlayer().getItemInHand().getType().toString().trim();
		String item = ("" + item1.charAt(0)).toUpperCase() + item1.substring(1).toLowerCase().replace("_", " ");

		// K<<<<<<<<<
		if (e.getMessage().contains("[item]") || e.getMessage().contains("[i]")) {
			e.setMessage(e.getMessage().replace("[item]", e.getPlayer().getItemInHand().getAmount() + "x " + item)
					.replace("[i]", e.getPlayer().getItemInHand().getAmount() + "x " + item));
		}
	}
}
