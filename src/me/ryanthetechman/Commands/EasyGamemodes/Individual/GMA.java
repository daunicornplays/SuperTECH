package me.ryanthetechman.Commands.EasyGamemodes.Individual;

import me.ryanthetechman.Main;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import static org.bukkit.ChatColor.*;

public class GMA implements CommandExecutor{
    Main plugin;

    public GMA(Main passedPlugin) {
        this.plugin = passedPlugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if ((sender instanceof Player) && plugin.config.getConfig().getBoolean("EasyGamemodes.Individual.AdventureEnabled") == true) {
            if(p.hasPermission("supertech.gamemode.Individual.GMA")){//EVERY CMD BROKE in SUPER TECH
                p.setGameMode(GameMode.ADVENTURE);
                p.sendMessage(GREEN + "You Are Now In Gamemode " + GOLD + "Adventure" + GREEN + "!");
                return true;
            }
        }
        return false;
    }}