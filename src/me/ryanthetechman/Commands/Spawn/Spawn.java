package me.ryanthetechman.Commands.Spawn;

import static org.bukkit.ChatColor.*;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.ryanthetechman.Main;

import java.util.Iterator;

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
            if (p.hasPermission("superech.spawn.others") && args.length >= 1) {
                if (args.length > 1) {
                    if (args.length == 1) {
                        boolean playerFound = false;
                        Iterator findp = Bukkit.getServer().getOnlinePlayers().iterator();
                        while (findp.hasNext()) {
                            Player reciver = (Player) findp.next();
                            if (reciver.getName().equalsIgnoreCase(args[0])) {

                                double x = plugin.spawn.getConfig().getDouble("Spawn.X");
                                double y = plugin.spawn.getConfig().getDouble("Spawn.Y");
                                double z = plugin.spawn.getConfig().getDouble("Spawn.Z");
                                float yaw = (float) plugin.spawn.getConfig().getInt("Spawn.Yaw");
                                float pitch = (float) plugin.spawn.getConfig().getInt("Spawn.Pitch");
                                if (y == 0) {
                                    p.sendMessage(RED + "The Admin's Seem To Have To Set A Spawn Yet...");
                                    return true;
                                } else {

                                    reciver.teleport(new Location(p.getWorld(), x, y, z, yaw, pitch));
                                    reciver.sendMessage(GREEN + "You Have Teleported To Spawn!");
                                    if (plugin.spawn.getConfig().getBoolean("Spawn.Particles")) {
                                        plugin.spawn.reloadConfig();
                                        reciver.getPlayer().getWorld().playEffect(
                                                new Location(p.getWorld(), x, y, z, (float) yaw, (float) pitch),
                                                Effect.DRAGON_BREATH, 100);

                                    }
                                }

                                p.sendMessage(GREEN + "You have teleported " + GOLD + args[0]
                                        + GREEN + " To Spawn!");
                                playerFound = true;
                                break;
                            }
                        }
                        if (!playerFound) {
                            p.sendMessage(RED + "The player " + args[0] + " was not found!");
                        }
                    }

                    if (args.length == 2) {
                        if (args[1].equalsIgnoreCase("-h")) {
                            boolean playerFound = false;
                            Iterator findp = Bukkit.getServer().getOnlinePlayers().iterator();
                            while (findp.hasNext()) {
                                Player reciver = (Player) findp.next();
                                if (reciver.getName().equalsIgnoreCase(args[0])) {

                                    double x = plugin.spawn.getConfig().getDouble("Spawn.X");
                                    double y = plugin.spawn.getConfig().getDouble("Spawn.Y");
                                    double z = plugin.spawn.getConfig().getDouble("Spawn.Z");
                                    float yaw = (float) plugin.spawn.getConfig().getInt("Spawn.Yaw");
                                    float pitch = (float) plugin.spawn.getConfig().getInt("Spawn.Pitch");
                                    if (y == 0) {
                                        p.sendMessage(RED + "The Admin's Seem To Have To Set A Spawn Yet...");
                                        return true;
                                    } else {

                                        reciver.teleport(new Location(p.getWorld(), x, y, z, yaw, pitch));
                                        if (plugin.spawn.getConfig().getBoolean("Spawn.Particles")) {
                                            plugin.spawn.reloadConfig();
                                            reciver.getPlayer().getWorld().playEffect(
                                                    new Location(p.getWorld(), x, y, z, (float) yaw, (float) pitch),
                                                    Effect.DRAGON_BREATH, 100);

                                        }
                                    }

                                    p.sendMessage(GREEN + "You have teleported " + GOLD + args[0]
                                            + GREEN + " To Spawn With -h!");
                                    playerFound = true;
                                    break;
                                }
                            }
                            if (!playerFound) {
                                p.sendMessage(RED + "The player " + args[0] + " was not found!");
                            }
                        } else if (args[1].equalsIgnoreCase("-o")) {
                            boolean playerFound = false;
                            Iterator findp = Bukkit.getServer().getOnlinePlayers().iterator();
                            while (findp.hasNext()) {
                                Player reciver = (Player) findp.next();
                                if (reciver.getName().equalsIgnoreCase(args[0])) {

                                    double x = plugin.spawn.getConfig().getDouble("Spawn.X");
                                    double y = plugin.spawn.getConfig().getDouble("Spawn.Y");
                                    double z = plugin.spawn.getConfig().getDouble("Spawn.Z");
                                    float yaw = (float) plugin.spawn.getConfig().getInt("Spawn.Yaw");
                                    float pitch = (float) plugin.spawn.getConfig().getInt("Spawn.Pitch");
                                    if (y == 0) {
                                        p.sendMessage(RED + "The Admin's Seem To Have To Set A Spawn Yet...");
                                        return true;
                                    } else {

                                        reciver.teleport(new Location(p.getWorld(), x, y, z, yaw, pitch));
                                        reciver.sendMessage(GREEN + "You Have Teleported To Spawn!");
                                        if (plugin.spawn.getConfig().getBoolean("Spawn.Particles")) {
                                            plugin.spawn.reloadConfig();
                                            reciver.getPlayer().getWorld().playEffect(
                                                    new Location(p.getWorld(), x, y, z, (float) yaw, (float) pitch),
                                                    Effect.DRAGON_BREATH, 100);

                                        }
                                    }

                                    p.sendMessage(GREEN + "You have teleported " + GOLD + args[0]
                                            + GREEN + " To Spawn With -o!");
                                    playerFound = true;
                                    break;
                                }
                            }
                            if (!playerFound) {
                                p.sendMessage(RED + "The player " + args[0] + " was not found!");
                            }
                        }
                    }
                    if (args.length == 3) {
                        if ((args[1].equalsIgnoreCase("-h") ||
                                args[2].equalsIgnoreCase("-h")) && (args[1].equalsIgnoreCase("-o") ||
                                args[2].equalsIgnoreCase("-o"))) {
                            boolean playerFound = false;
                            Iterator findp = Bukkit.getServer().getOnlinePlayers().iterator();
                            while (findp.hasNext()) {
                                Player reciver = (Player) findp.next();
                                if (reciver.getName().equalsIgnoreCase(args[0])) {

                                    double x = plugin.spawn.getConfig().getDouble("Spawn.X");
                                    double y = plugin.spawn.getConfig().getDouble("Spawn.Y");
                                    double z = plugin.spawn.getConfig().getDouble("Spawn.Z");
                                    float yaw = (float) plugin.spawn.getConfig().getInt("Spawn.Yaw");
                                    float pitch = (float) plugin.spawn.getConfig().getInt("Spawn.Pitch");
                                    if (y == 0) {
                                        p.sendMessage(RED + "The Admin's Seem To Have To Set A Spawn Yet...");
                                        return true;
                                    } else {

                                        reciver.teleport(new Location(p.getWorld(), x, y, z, yaw, pitch));
                                        if (plugin.spawn.getConfig().getBoolean("Spawn.Particles")) {
                                            plugin.spawn.reloadConfig();
                                            reciver.getPlayer().getWorld().playEffect(
                                                    new Location(p.getWorld(), x, y, z, (float) yaw, (float) pitch),
                                                    Effect.DRAGON_BREATH, 100);

                                        }
                                    }

                                    p.sendMessage(GREEN + "You have teleported " + GOLD + args[0]
                                            + GREEN + " To Spawn With -o & -h!");
                                    playerFound = true;
                                    break;
                                }
                            }
                            if (!playerFound) {
                                p.sendMessage(RED + "The player " + args[0] + " was not found!");
                            }
                        }

                    }
                }
            }

            if (p.hasPermission("supertech.cooldown.override")) {

                if (args.length == 0) {

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
                }}
            } else {
                p.sendMessage(RED + "You Must Be A Player To Run This Command!");
            }
            return true;

    }
}
