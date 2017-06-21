package me.ryanthetechman.Commands;

import me.ryanthetechman.Main;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Iterator;

import static org.bukkit.ChatColor.*;

public class echest implements CommandExecutor{
    Main plugin;

    public echest(Main passedPlugin) {
        this.plugin = passedPlugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p = (Player) sender;
        if (sender instanceof Player){
            if(args.length ==0) {
                if(p.hasPermission("supertech.echest")){
            p.openInventory(p.getEnderChest());
        }
           else{
                    p.sendMessage(RED + "You Do Not Have Perms To Run This Command!");
                }
            }

        if(args.length == 1){
            if(p.hasPermission("supertech.echest.others")){
            boolean playerFound = false;
            Iterator findp = Bukkit.getServer().getOnlinePlayers().iterator();
            while (findp.hasNext()) {
                Player reciver = (Player) findp.next();
                if (reciver.getName().equalsIgnoreCase(args[0])) {
                    p.openInventory(reciver.getEnderChest());
                    p.sendMessage(GREEN + "You are viewing " + GOLD + args[0] + "'s "
                            + GREEN + " Ender Chest!");
                    playerFound = true;
                    break;
                }
            }
            if (!playerFound) {
                p.sendMessage(RED + "The player " + args[0] + " was not found!");
            }
            }
            else{
                p.sendMessage(RED + "You Do Not Have Perms To Run This Command!");
            }
        }
        }
        else{
            p.sendMessage(RED + "You Must Be a Player To Run This Command!");
        }
        return false;
}
}
