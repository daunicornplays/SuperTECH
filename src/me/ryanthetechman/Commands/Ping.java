package me.ryanthetechman.Commands;

import me.ryanthetechman.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.util.Iterator;

import static org.bukkit.ChatColor.GOLD;
import static org.bukkit.ChatColor.GREEN;
import static org.bukkit.ChatColor.RED;

public class Ping implements CommandExecutor {
    Main plugin;

    public Ping(Main passedPlugin) {
        this.plugin = passedPlugin;
    }


    public boolean onCommand(CommandSender sender, Command command, String cmdLabel, String[] args) {
        Player p = (Player) sender;
        if (args.length == 0) {
            if(sender instanceof Player){
                int ping = ((CraftPlayer) p).getHandle().ping;
                if(ping <= 75){p.sendMessage(GOLD + "Your Ping Is:\n" + ping + "\nReally Good!");}
                if(ping > 75 && ping <=125){p.sendMessage(ChatColor.GREEN + "Your Ping Is:\n" + ping);}
                if(ping > 125 && ping <=250){p.sendMessage(ChatColor.YELLOW + "Your Ping Is:\n" + ping);}
                if(ping > 250 && ping <=425){p.sendMessage(ChatColor.RED + "Your Ping Is:\n" + ping);}
                if(ping > 425){p.sendMessage(ChatColor.DARK_RED + "Your Ping Is:\n" + ping);}
                return true;
            }
            else{
                sender.sendMessage("You Must Be a Player To Run /ping");
                return false;
            }
        }
        if(args.length == 1) {
            boolean playerFound = false;
            Iterator findp = Bukkit.getServer().getOnlinePlayers().iterator();
            while (findp.hasNext()) {
                Player reciver = (Player) findp.next();
                if (reciver.getName().equalsIgnoreCase(args[0])) {
                    int ping = ((CraftPlayer) reciver).getHandle().ping;
                    if(ping <= 75){p.sendMessage(GOLD + args[0] +"'s Ping Is:\n" + ping + "\nReally Good!");}
                    if(ping > 75 && ping <=125){p.sendMessage(GREEN + args[0] +"'s Ping Is:\n" + ping);}
                    if(ping > 125 && ping <=250){p.sendMessage(ChatColor.YELLOW + args[0] +"'s Ping Is:\n" + ping);}
                    if(ping > 250 && ping <=425){p.sendMessage(RED + args[0] +"'s Ping Is:\n" + ping);}
                    if(ping > 425){p.sendMessage(ChatColor.WHITE + args[0] +"'s Ping Is:\n" + ping);}
                    playerFound = true;
                    break;
                }
            }
            if (!playerFound) {
                p.sendMessage(RED + "The player " + args[0] + " was not found!");
                return false;
            }
        }
        return false;
    }
}