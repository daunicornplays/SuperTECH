package me.ryanthetechman.Commands;

import me.ryanthetechman.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import static org.bukkit.ChatColor.*;

public class PlayersHideAndShow implements CommandExecutor, Listener {

    Main plugin;

    public PlayersHideAndShow(Main passedPlugin) {
        this.plugin = passedPlugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        Player p = (Player) sender;
        if(sender instanceof Player){
            if(args[0].equalsIgnoreCase("hide") || args[0].equalsIgnoreCase("show")) {
                if(args[0].equalsIgnoreCase("show")){
                    if(plugin.hideandshow.getConfig().getString("showPlayersFor." + p.getName()) == null || plugin.hideandshow.getConfig().getString("showPlayersFor." + p.getName()) == ""){
                        plugin.hideandshow.getConfig().set("showPlayersFor." + p.getName(), true);
                        plugin.hideandshow.saveConfig();
                        showAllPlayers(p);
                    }
                    if(plugin.hideandshow.getConfig().getBoolean("showPlayersFor." + p.getName())) {
                        p.sendMessage(RED + "You All Ready Have All Players Shown!");
                    }
                    else {
                        plugin.hideandshow.getConfig().set("showPlayersFor." + p.getName(), true);
                        plugin.hideandshow.saveConfig();
                        showAllPlayers(p);
                    }
                }
                if(args[0].equalsIgnoreCase("hide")){
                    if(plugin.hideandshow.getConfig().getString("showPlayersFor." + p.getName()) == null || plugin.hideandshow.getConfig().getString("showPlayersFor." + p.getName()) == ""){
                        plugin.hideandshow.getConfig().set("showPlayersFor." + p.getName(), false);
                        plugin.hideandshow.saveConfig();
                        hideAllPlayers(p);
                    }
                    if(!(plugin.hideandshow.getConfig().getBoolean("showPlayersFor." + p.getName()))) {
                        p.sendMessage(RED + "You All Ready Have All Players Hidden!");
                    }

                    else{
                        plugin.hideandshow.getConfig().set("showPlayersFor." + p.getName(), false);
                        plugin.hideandshow.saveConfig();
                        hideAllPlayers(p);
                    }
                }
                return true;
            }
            else{
                p.sendMessage(RED+ args[0] + " Is Not Something You Can Do!");
                return false;
            }
        }
        else{
            p.sendMessage(RED + "You Must Be A Player To Run This Command!");
            return false;
        }
    }

    public void hideAllPlayers(Player player){
        for(Player p : Bukkit.getOnlinePlayers())
            player.hidePlayer(p);
        player.sendMessage(GREEN + "All Players Are Now Hidden From Your View!");
    }

    public void showAllPlayers(Player player){
        for(Player p : Bukkit.getOnlinePlayers())
            player.showPlayer(p);
        player.sendMessage(GREEN + "All Players Are Now Visible!");
    }
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e){
        for(Player p : Bukkit.getOnlinePlayers())
            e.getPlayer().showPlayer(p);
    }
    }
