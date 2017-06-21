package me.ryanthetechman.Commands;

import me.ryanthetechman.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockDenied implements Listener {

    Main plugin;

    public BlockDenied(Main passedPlugin) {
        this.plugin = passedPlugin;
    }
    @EventHandler
    public void onBlockBreakEvent(BlockBreakEvent e) {
        if(!(e.getPlayer().hasPermission("supertech.blocks.break"))) {
            e.setCancelled(true);
        }
    }

}
