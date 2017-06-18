package me.ryanthetechman.Commands;

import java.io.File;
import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.Plugin;

public class afk implements Listener, CommandExecutor {

	Plugin plugin;

	public afk(Plugin passedPlugin) {
		this.plugin = passedPlugin;
	}

	public static afk m;
	public boolean isAFK;
	private CommandSender p;

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("afk")) {
			if (getStatus()) {
				setStatus(false);
				player.sendMessage(" You are no longer in AFK mode!");
			} else {
				setStatus(true);
				player.sendMessage(" You are now in AFK mode!");
			}
		}
		return false;
	}

	public static afk getInstance() {
		return m;
	}

	public static void setStatus(boolean status) {
		File ordner = new File("plugins//AFK");
		File file = new File("plugins//AFK//Status.yml");
		if (!ordner.exists()) {
			ordner.mkdir();
		}
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);

		cfg.set("Status", Boolean.valueOf(status));
		try {
			cfg.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static boolean getStatus() {
		File ordner = new File("plugins//AFK");
		File file = new File("plugins//AFK//Status.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		if (!ordner.exists()) {
			ordner.mkdir();
		}
		if (!file.exists()) {
			try {
				file.createNewFile();
				cfg.set("Status", Boolean.valueOf(false));
				cfg.save(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		boolean status = cfg.getBoolean("Status");

		return status;
	}

	@EventHandler
	public void onAFKMove(PlayerMoveEvent e) {
		Player player = e.getPlayer();
		if (this.isAFK) {
			this.isAFK = false;
			player.sendMessage(" AFK Disabled");
		}
	}

	@EventHandler
	public void onAFKInteract(PlayerInteractEvent e) {
		Player player = e.getPlayer();
		if (this.isAFK) {
			this.isAFK = false;
			player.sendMessage(" AFK Enabled");
		}
	}

	public void onCommand(String[] args) {
		if ((args[0].equalsIgnoreCase("/")) || (args[0].equalsIgnoreCase("/help"))) {
			this.p.sendMessage("Help AFK:");
		}
		this.p.sendMessage("If /AFK has been used and you move, the AFK mode switches off");
		this.p.sendMessage("/AFK mode is activated");
		this.p.sendMessage("/Unafk-AFK mode disabled");
	}
}
