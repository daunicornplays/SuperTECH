package me.ryanthetechman.Commands.GiveItems;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class SmiteBow implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        ItemStack lBow = new ItemStack(Material.BOW, 1);
        ItemMeta lBowMeta = lBow.getItemMeta();
        lBowMeta.setDisplayName(ChatColor.AQUA + "Lightning Bow");
        lBowMeta.setLore(Arrays.asList(new String[] { ChatColor.GRAY + "Shoot a player 20+ blocks away", ChatColor.GRAY + "to strike them with lightning!" }));

        lBow.setItemMeta(lBowMeta);

        Player p = (Player)sender;
        if (args.length == 2){
            if(args[1].equalsIgnoreCase("LightningBow")){
                if (p.hasPermission("customitem.command.lightningbow"))
                {
                    p.getInventory().addItem(new ItemStack[] { lBow });
                    p.sendMessage(ChatColor.AQUA + "You have been given a Lightning Bow");
                }

            else {
                p.sendMessage(ChatColor.RED + "I'm not sure what a " + "\"" + args[0] + "\"" + " is.");
            }
            }
        }


        return false;
    }
}
