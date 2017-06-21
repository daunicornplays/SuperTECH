package me.ryanthetechman.Commands;

import me.ryanthetechman.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.Color.*;

public class FakeLogin implements CommandExecutor{
    Main plugin;


    public FakeLogin(Main passedPlugin) {
        this.plugin = passedPlugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if(args[0].equalsIgnoreCase("join")){
            if(p.hasPermission("supertech.fake.join")){
                String message = "&e"+ args[1] + " joined the game&e";
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', message));
            }
            else{
                p.sendMessage(RED + "You Do Not Have Perms To Run /fake.");
            }
        }
        if(args[0].equalsIgnoreCase("leave")){
            if(p.hasPermission("supertech.fake.leave")){
                String message = "&e"+ args[1] + " left the game&e";
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', message));
            }
            else{
                p.sendMessage(RED + "You Do Not Have Perms To Run /fake.");
            }
        }
        else{
            p.sendMessage(RED + "Invalid Use Of Command /fake\nPlease Use:\n/fake [join, leave] [username]");
        }
        return false;
    }
}
