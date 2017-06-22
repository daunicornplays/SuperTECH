package me.ryanthetechman.Commands;

import me.ryanthetechman.Main;
import mkremins.fanciful.FancyMessage;
import net.minecraft.server.v1_12_R1.Packet;
import net.minecraft.server.v1_12_R1.PacketPlayOutWorldParticles;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class BlockDenied implements Listener,CommandExecutor {

    Main plugin;

    public BlockDenied(Main passedPlugin) {
        this.plugin = passedPlugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        if(plugin.blockbreak.getConfig().getString("AllowBreak." + e.getPlayer().getName()) == null || plugin.blockbreak.getConfig().getString("AllowBreak." + e.getPlayer().getName()) == ""){
            plugin.blockbreak.getConfig().set("AllowBreak." + e.getPlayer().getName(), false);
        }
    }

    @EventHandler
    public void onBlockBreakEvent(BlockBreakEvent e) {
        if(!e.getPlayer().hasPermission("supertech.blocks.break") || !plugin.blockbreak.getConfig().getBoolean("AllowBreak." + e.getPlayer().getName())) {
            e.setCancelled(true);
            if(e.getPlayer().isOp()){
               // new FancyMessage(ChatColor.YELLOW + "You Can't Break Blocks! Allow Your Self To Do So By Typing /toggleBlockBreak OR Click On This Text!").command("/toggleblockbreak").send(e.getPlayer());
            }
        }
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if(args.length == 0){
            if(p.hasPermission("supertech.blocks.break")){
            if(plugin.blockbreak.getConfig().getBoolean("AllowBreak." + p.getName())){
            plugin.blockbreak.getConfig().set("AllowBreak." + p.getName(), false);
            p.sendMessage(ChatColor.GREEN + "You Can Now" + ChatColor.RED + " NOT " + ChatColor.GREEN + "Break Blocks!");
            return true;
        }
            if(!plugin.blockbreak.getConfig().getBoolean("AllowBreak." + p.getName())){
                plugin.blockbreak.getConfig().set("AllowBreak." + p.getName(), true);
                p.sendMessage(ChatColor.GREEN + "You Can Now Break Blocks!");
                return true;
            }
            else{
                plugin.blockbreak.getConfig().set("AllowBreak." + p.getName(), true);
                p.sendMessage(ChatColor.GREEN + "You Can Now Break Blocks!");
            }
            }

        }

        return false;
    }
}
