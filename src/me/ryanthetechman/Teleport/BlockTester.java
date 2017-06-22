package me.ryanthetechman.Teleport;

import me.ryanthetechman.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class BlockTester implements Listener{

    Main plugin;

    public BlockTester(Main passedPlugin) {
        this.plugin = passedPlugin;
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e){
        Player p = (Player)e;


            }


}
