package me.ryanthetechman.Commands;

import me.ryanthetechman.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockDenied implements CommandExecutor, Listener {

    Main plugin;

    public BlockDenied(Main passedPlugin) {
        this.plugin = passedPlugin;
    }

    public boolean onCommand(CommandSender sender, Command command, String cmdLabel, String[] args) {
        Player p = (Player) sender;
        if(args.length==0){

        }
        return false;
}
    public void onBlockBreakEvent(BlockBreakEvent e) {
        Player p = (Player) e;
        e.setCancelled(true);

    }

}
