package me.ryanthetechman.Commands;

import me.ryanthetechman.Main;
import org.apache.commons.lang.ObjectUtils;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Smite implements CommandExecutor{
    Main plugin;

    public Smite(Main passedPlugin) {
        this.plugin = passedPlugin;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
       /* World world = p.getWorld();
        if(p.hasPermission("supertech.smite")){
        if (args.length == 0) {
            Block targetBlock = p.getTargetBlock(null, 10);
            Location location = targetblock.getLocation();
            world.strikeLightning(location);
            world.createExplosion(location, 2.0F);
        }
        }
        else {
            p.sendMessage(ChatColor.RED + "You Do Not have Enough Permissions For This!");
        }
        if (args.length == 1) {
            if (p.getServer().getPlayer(args[0]) != null) {
                Player targetplayer = p.getServer().getPlayer(args[0]);
                Location location = targetplayer.getLocation();
                world.strikeLightning(location);
                p.sendMessage(ChatColor.GRAY + "Smiting Player" + targetplayer.getDisplayName());
            } else {
                p.sendMessage(ChatColor.RED + "Error: That Player Is Offline.");
            }
        } else if (args.length > 1) {
            p.sendMessage(ChatColor.RED + "Error: Too Many Arguments!");
       } */
        return false;
    }
}
