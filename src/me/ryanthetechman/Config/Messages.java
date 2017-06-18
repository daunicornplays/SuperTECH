package me.ryanthetechman.Config;

import me.ryanthetechman.Main;
import org.bukkit.ChatColor;

public class Messages {

	Main plugin;

	public Messages(Main passedPlugin) {
		this.plugin = passedPlugin;
	}

	private void setMessage(String name, String message) {
		// Message
		plugin.messages.getConfig().set(name, ChatColor.translateAlternateColorCodes('&', message));
		plugin.messages.saveConfig();
		return;
	}

	public void Message(String name, String message) {
		setMessage(name, ChatColor.translateAlternateColorCodes('&', message));
		return;
	}

}
