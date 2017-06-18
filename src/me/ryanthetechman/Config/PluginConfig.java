package me.ryanthetechman.Config;

import java.io.File;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class PluginConfig {
	Plugin plugin;
	private File file;
	private FileConfiguration config;

	public PluginConfig(Plugin plugin, String name, boolean copy) {
		this.plugin = plugin;
		this.file = new File(plugin.getDataFolder(), name + ".yml");
		if (copy) {
			plugin.saveResource(this.file.getName(), true);
		} else {
			try {
				this.file.createNewFile();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		reloadConfig();
	}

	public FileConfiguration getConfig() {
		return this.config;
	}

	public void reloadConfig() {
		this.config = YamlConfiguration.loadConfiguration(this.file);
	}

	public void saveConfig() {
		try {
			this.config.save(this.file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
