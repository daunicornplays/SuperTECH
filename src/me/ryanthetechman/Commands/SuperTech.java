package me.ryanthetechman.Commands;

import me.ryanthetechman.Commands.Movement.WalkSpeed;
import me.ryanthetechman.Main;
import mkremins.fanciful.FancyMessage;
import static org.bukkit.ChatColor.*;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.Iterator;

public class SuperTech implements CommandExecutor {
    String s2;
    Main plugin;

    public SuperTech(Main passedPlugin) {
        this.plugin = passedPlugin;
    }


    public boolean onCommand(CommandSender sender, Command command, String cmdLabel, String[] args) {
        Player p = (Player) sender;
        if (args.length == 0) {
            String Separator = GREEN + " | " + GOLD;
            p.sendMessage(LIGHT_PURPLE + "----------------------------------------------------");
            p.sendMessage(GOLD + "Here is a list of commands you can run:");
            p.sendMessage(GOLD + "/tpo" + Separator + "/tpohere" + Separator + "/supertech reload" + Separator
                    + "/spawn" + Separator + "/setspawn");
            p.sendMessage(LIGHT_PURPLE + "----------------------------------------------------");
            return true;
        }
        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("reload")) {

                if (!(plugin.config.getConfig().getBoolean("WalkSpeed.Enabled"))) {
                    for (Player player : Bukkit.getOnlinePlayers()) {
                        player.setWalkSpeed(1 / 10.0F);
                    }
                }

                if (!(plugin.doublejump.getConfig().getBoolean("Enabled"))) {
                    for (Player player : Bukkit.getOnlinePlayers()) {
                        if (player.getGameMode() != GameMode.CREATIVE || player.getGameMode() != GameMode.SPECTATOR) {
                            player.setAllowFlight(false);
                            player.setFlying(false);
                        }
                    }
                }
               else p.sendMessage(GREEN + "SuperTech Config Has Been Reloaded!");
            }
        }
        if (args[0].equalsIgnoreCase("config")) {
            p.sendMessage(GREEN + "Highlight Over a Section To Expand!");
            p.sendMessage(GREEN + "Here Is The Config Data:");
            new FancyMessage(GOLD + "DoubleJump").tooltip(
                    GOLD + "Enabled: " + GREEN + plugin.doublejump.getConfig().getString("Enabled") + "\n" +
                            GOLD + "Power X: " + GREEN + plugin.doublejump.getConfig().getString("PowerValues.X") + "\n" +
                            GOLD + "Power Y: " + GREEN + plugin.doublejump.getConfig().getString("PowerValues.Y")).send(sender);
            new FancyMessage(GOLD + "Spawn").tooltip(
                    GOLD + "Location: \n    " + GOLD + "X: " + GREEN + plugin.spawn.getConfig().getString("Spawn.X") + "\n" +
                            GOLD + "    Y: " + GREEN + plugin.spawn.getConfig().getString("Spawn.Y") + "\n" +
                            GOLD + "    Z: " + GREEN + plugin.spawn.getConfig().getString("Spawn.Z") + "\n" +
                            GOLD + "Particles: " + GREEN + plugin.spawn.getConfig().getString("Spawn.Particles")).send(sender);
            new FancyMessage(GOLD + "Movement").tooltip(
                    GOLD + "FlySpeedEnabled: " + GREEN + plugin.movement.getConfig().getString("FlySpeed.Enabled") + "\n" +
                            GOLD + "Your FlySpeed: " + GREEN + p.getFlySpeed() * 10.0F + "\n\n" +
                            GOLD + "WalkSpeedEnabled: " + GREEN + plugin.movement.getConfig().getString("WalkSpeed.Enabled") + "\n" +
                            GOLD + "Your WalkSpeed: " + GREEN + p.getWalkSpeed() * 10.0F).send(sender);
            new FancyMessage(GOLD + "HideAndShow:").tooltip(
                    GOLD + "PlayersShown: " + GREEN + plugin.hideandshow.getConfig().getString("showPlayersFor." + p.getName())).send(sender);
            return true;
        }
        if (args[0].equalsIgnoreCase("reload")) {

            if (args.length == 1) {
                //DoubleJumpConfig(((Player) sender).getPlayer());
                plugin.doublejump.reloadConfig();
                plugin.movement.reloadConfig();
                plugin.messages.reloadConfig();
                plugin.config.reloadConfig();
                plugin.hideandshow.reloadConfig();
                plugin.jumppads.reloadConfig();
                plugin.jumppads.reloadConfig();
                if (!(plugin.config.getConfig().getBoolean("FlySpeed.Enabled"))) {
                    for (Player player : Bukkit.getOnlinePlayers()) {
                        player.setFlySpeed(1 / 10.0F);
                    }
                }
                if (!(plugin.config.getConfig().getBoolean("WalkSpeed.Enabled"))) {
                    for (Player player : Bukkit.getOnlinePlayers()) {
                        player.setWalkSpeed(1 / 10.0F);
                    }
                }
            }

           else if (args.length == 2) {

                if (args[1].equalsIgnoreCase("main")) {
                    plugin.config.reloadConfig();
                    p.sendMessage(GREEN + "You Have Reloaded The Main Config!");
                    return true;
                }
                if (args[1].equalsIgnoreCase("doublejump")) {
                    plugin.doublejump.reloadConfig();
                    p.sendMessage(GREEN + "You Have Reloaded The DoubleJump Config!");
                    return true;
                }
                if (args[1].equalsIgnoreCase("movement")) {
                    plugin.movement.reloadConfig();
                    p.sendMessage(GREEN + "You Have Reloaded The Movement Config!");
                    return true;
                }
                if (args[1].equalsIgnoreCase("messages")) {
                    plugin.messages.reloadConfig();
                    p.sendMessage(GREEN + "You Have Reloaded The Messages Config!");
                    return true;
                }
                if (args[1].equalsIgnoreCase("hideandshow")) {
                    plugin.hideandshow.reloadConfig();
                    p.sendMessage(GREEN + "You Have Reloaded The HideAndShow Config!");
                    return true;
                }

                else {
                    p.sendMessage(RED + "That is Not a Valid Name For a Config in Super Tech!");
                    p.sendMessage(GREEN + "Here Is a List of Configs For Super Tech \n" +
                            GOLD + "Click a Name to Get The Command!");
                    new FancyMessage(GOLD + "Main").suggest("/supertech reload Main").send(sender);
                    new FancyMessage(GOLD + "DoubleJump").suggest("/supertech reload DoubleJump").send(sender);
                    new FancyMessage(GOLD + "Movement").suggest("/supertech reload Movement").send(sender);
                    new FancyMessage(GOLD + "Messages").suggest("/supertech reload Messages").send(sender);
                    new FancyMessage(GOLD + "HideAndShow").suggest("/supertech reload HideAndShow").send(sender);
                    return true;
                }
            }


        }
        if(args[0].equalsIgnoreCase("give")){
            if (args.length == 1){
                p.sendMessage(ChatColor.RED + "Please Enter The Item Name\nEx: /supertech give [item]");
            }

            if (args.length == 2){
                if(args[1].equalsIgnoreCase("LightningBow")){
                    ItemStack lBow = new ItemStack(Material.BOW, 1);
                    ItemMeta lBowMeta = lBow.getItemMeta();
                    lBowMeta.setDisplayName(ChatColor.AQUA + "Lightning Bow");
                    lBowMeta.setLore(Arrays.asList(new String[] { ChatColor.GRAY + "Strike something with lightning!" }));

                    lBow.setItemMeta(lBowMeta);
                    if (p.hasPermission("supertech.give.lightningbow"))
                    {
                        p.getInventory().addItem(new ItemStack[] { lBow });
                        new FancyMessage(WHITE + "Given " + ChatColor.AQUA + "[" + args[1].toLowerCase() + "]" +
                                ChatColor.WHITE + " * 1 to " + p.getName()).tooltip(AQUA + "LightningBow " + WHITE + "(#0000)\n" + DARK_GRAY + "supertech:LightningBow").send(sender);
                    }

                    else {
                        p.sendMessage(ChatColor.WHITE + "There is no such item with name supertech:" + args[1].toLowerCase());
                    }
                }
                if(args[1].equalsIgnoreCase("TntBow")){
                    ItemStack lBow = new ItemStack(Material.BOW, 1);
                    ItemMeta lBowMeta = lBow.getItemMeta();
                    lBowMeta.setDisplayName(ChatColor.RED + "Tnt Bow");
                    lBowMeta.setLore(Arrays.asList(new String[] { ChatColor.GRAY + "Make Anything Explode!" }));

                    lBow.setItemMeta(lBowMeta);
                    if (p.hasPermission("supertech.give.explodingbow"))
                    {
                        p.getInventory().addItem(new ItemStack[] { lBow });
                        new FancyMessage(WHITE + "Given " + ChatColor.AQUA + "[" + args[1].toLowerCase() + "]" +
                                ChatColor.WHITE + " * 1 to " + p.getName()).tooltip(AQUA + "TntBow " + WHITE + "(#0000)\n" + DARK_GRAY + "supertech:TntBow").send(sender);
                    }

                    else {
                        p.sendMessage(ChatColor.WHITE + "There is no such item with name supertech:" + args[1].toLowerCase());
                    }
                }
                if(args[1].equalsIgnoreCase("EnderBow")){
                    ItemStack lBow = new ItemStack(Material.BOW, 1);
                    ItemMeta lBowMeta = lBow.getItemMeta();
                    lBowMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Ender Bow");
                    lBowMeta.setLore(Arrays.asList(new String[] { ChatColor.GRAY + "Allows You To Teleport!" }));

                    lBow.setItemMeta(lBowMeta);
                    if (p.hasPermission("supertech.give.enderbow"))
                    {
                        p.getInventory().addItem(new ItemStack[] { lBow });
                        new FancyMessage(WHITE + "Given " + ChatColor.AQUA + "[" + args[1].toLowerCase() + "]" +
                                ChatColor.WHITE + " * 1 to " + p.getName()).tooltip(AQUA + "EnderBow " + WHITE + "(#0000)\n" + DARK_GRAY + "supertech:EnderBow").send(sender);
                    }

                    else {
                        p.sendMessage(ChatColor.WHITE + "There is no such item with name supertech:" + args[1].toLowerCase());
                    }
                }
            }
            if (args.length == 3){
                if(args[2].matches("^-?\\d+$")){
                    int args2 = Integer.parseInt(args[2]);
                    ItemStack lBow = new ItemStack(Material.BOW, args2);
                    ItemMeta lBowMeta = lBow.getItemMeta();
                    lBowMeta.setDisplayName(ChatColor.AQUA + "Lightning Bow");
                    lBowMeta.setLore(Arrays.asList(new String[] { ChatColor.GRAY + "Strike something with lightning!" }));

                    lBow.setItemMeta(lBowMeta);
                    if (p.hasPermission("supertech.give.lightningbow"))
                    {
                        p.getInventory().addItem(new ItemStack[] { lBow });
                        new FancyMessage(WHITE + "Given " + ChatColor.AQUA + "[" + args[1].toLowerCase() + "]" +
                                ChatColor.WHITE + " * " + args2 +  " to " + p.getName()).tooltip(AQUA + "LightningBow " + WHITE + "(#0000)\n" + DARK_GRAY + "supertech:LightningBow").send(sender);
                    }

                    else {
                        p.sendMessage(ChatColor.WHITE + "There is no such item with name supertech:" + args[1].toLowerCase());
                    }
                }
                else if(args[1].equalsIgnoreCase("LightningBow")){
                    boolean playerFound = false;
                    Iterator findp = Bukkit.getServer().getOnlinePlayers().iterator();
                    while (findp.hasNext()) {
                        Player reciver = (Player) findp.next();
                        if (reciver.getName().equalsIgnoreCase(args[2])) {
                            ItemStack lBow = new ItemStack(Material.BOW, 1);
                            ItemMeta lBowMeta = lBow.getItemMeta();
                            lBowMeta.setDisplayName(ChatColor.AQUA + "Lightning Bow");
                            lBowMeta.setLore(Arrays.asList(new String[] { ChatColor.GRAY + "Strike something with lightning!" }));

                            lBow.setItemMeta(lBowMeta);
                            if (p.hasPermission("supertech.give.lightningbow"))
                            {
                                reciver.getInventory().addItem(new ItemStack[] { lBow });
                                new FancyMessage(WHITE + "Given " + ChatColor.AQUA + "[" + args[1].toLowerCase() + "]" +
                                        ChatColor.WHITE + " * 1 to " + p.getName()).tooltip(AQUA + "LightningBow " + WHITE + "(#0000)\n" + DARK_GRAY + "supertech:LightningBow").send(sender);
                            }

                            else {
                                p.sendMessage(ChatColor.WHITE + "There is no such item with name supertech:" + args[1].toLowerCase());
                            }
                            playerFound = true;
                            break;
                        }
                    }
                    if (!playerFound) {
                        p.sendMessage(RED + "The player " + args[2] + " was not found!");
                        return false;
                    }
                }
            }
        }
        return false;
    }


}
