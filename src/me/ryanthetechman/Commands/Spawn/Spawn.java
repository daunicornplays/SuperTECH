package me.ryanthetechman.Commands.Spawn;

import static org.bukkit.ChatColor.GREEN;
import static org.bukkit.ChatColor.RED;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.ryanthetechman.Main;

public class Spawn implements CommandExecutor, Listener {
    CancelListener cl;
    Main plugin;
    Player p, t;


    public Spawn(Main passedPlugin) {
        this.plugin = passedPlugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        p = (Player) sender;
        if (sender instanceof Player) {
            if (p.hasPermission("supertech.cooldown.override")) {

                if (args.length > 0) {
                    t = Bukkit.getServer().getPlayer(args[0]);
                }

                if (p.hasPermission("supertech.spawn")) {

                    double x = plugin.spawn.getConfig().getDouble("Spawn.X");
                    double y = plugin.spawn.getConfig().getDouble("Spawn.Y");
                    double z = plugin.spawn.getConfig().getDouble("Spawn.Z");
                    float yaw = (float) plugin.spawn.getConfig().getInt("Spawn.Yaw");
                    float pitch = (float) plugin.spawn.getConfig().getInt("Spawn.Pitch");

                    if (y == 0) {
                        p.sendMessage(RED + "The Admin's Seem To Have To Set A Spawn Yet...");
                        return true;
                    } else {

                        p.teleport(new Location(p.getWorld(), x, y, z, yaw, pitch));
                        p.sendMessage(GREEN + "You Have Teleported To Spawn!");
                        if (plugin.spawn.getConfig().getBoolean("Spawn.Particles")) {
                            plugin.spawn.reloadConfig();
                            p.getPlayer().getWorld().playEffect(
                                    new Location(p.getWorld(), x, y, z, (float) yaw, (float) pitch),
                                    Effect.DRAGON_BREATH, 100);

                        }
                    }
                }
            } else {
                plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

                    @Override
                    public void run() {

                        p = (Player) sender;
                        if (args.length > 0) {
                            t = Bukkit.getServer().getPlayer(args[0]);
                        }

                        if (p.hasPermission("supertech.spawn")) {
                            double x = plugin.spawn.getConfig().getDouble("Spawn.X");
                            double y = plugin.spawn.getConfig().getDouble("Spawn.Y");
                            double z = plugin.spawn.getConfig().getDouble("Spawn.Z");
                            float yaw = (float) plugin.spawn.getConfig().getInt("Spawn.Yaw");
                            float pitch = (float) plugin.spawn.getConfig().getInt("Spawn.Pitch");

                            if (y == 0) {
                                p.sendMessage(RED + "The Admin's Seem To Have To Set A Spawn Yet...");
                                return;
                            } else {

                                p.teleport(new Location(p.getWorld(), x, y, z, yaw, pitch));
                                p.sendMessage(GREEN + "You Have Teleported To Spawn!");
                                if (plugin.spawn.getConfig().getBoolean("Spawn.Particles")) {
                                    plugin.spawn.reloadConfig();
                                    p.getPlayer().getWorld().playEffect(
                                            new Location(p.getWorld(), x, y, z, (float) yaw, (float) pitch),
                                            Effect.DRAGON_BREATH, 100);

                                }
                            }
                        }
                    }
                }, 3 * 20);
            }
        } else {
            p.sendMessage(RED + "You Must Be A Player To Run This Command!");
        }
        return true;
    }
}
