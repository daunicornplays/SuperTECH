package me.ryanthetechman.Commands.EasyGamemodes.Individual;

import me.ryanthetechman.Main;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import static org.bukkit.ChatColor.*;

public class GMC implements CommandExecutor{
    Main plugin;

    public GMC(Main passedPlugin) {
        this.plugin = passedPlugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if ((sender instanceof Player) && plugin.config.getConfig().getBoolean("EasyGamemodes.Individual.CreativeEnabled") == true) {
            if(p.hasPermission("supertech.gamemode.Individual.GMC")){
                p.setGameMode(GameMode.CREATIVE);
                p.sendMessage(GREEN + "You Are Now In Gamemode " + GOLD + "Creative" + GREEN + "!");
                return true;
            }
        }
        return false;
    }}