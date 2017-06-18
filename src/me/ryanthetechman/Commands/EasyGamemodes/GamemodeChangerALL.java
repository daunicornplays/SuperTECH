package me.ryanthetechman.Commands.EasyGamemodes;

import me.ryanthetechman.Main;
import static org.bukkit.ChatColor.*;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamemodeChangerALL implements CommandExecutor {
    Main plugin;

    public GamemodeChangerALL(Main passedPlugin) {
        this.plugin = passedPlugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if ((sender instanceof Player) && plugin.config.getConfig().getBoolean("EasyGamemodes.Enabled")) {
            if (args.length == 0) {
                p.sendMessage(RED + "Please Enter a Valid Gamemode " + GOLD +"[0, 1, 2, 3, S, C, A, SP]");
                return false;
            }
            if (args.length == 1) {
                if(args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("s")|| args[0].equalsIgnoreCase("survival")){
                    p.setGameMode(GameMode.SURVIVAL);
                    p.sendMessage(GREEN + "You Are Now In Gamemode " + GOLD + "Survival" + GREEN + "!");
                    return true;
                }
                if(args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("c")|| args[0].equalsIgnoreCase("creative")){
                    p.setGameMode(GameMode.CREATIVE);
                    p.sendMessage(GREEN + "You Are Now In Gamemode " + GOLD + "Creative" + GREEN + "!");
                    return true;
                }
                if(args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("a")|| args[0].equalsIgnoreCase("adventure")){
                    p.setGameMode(GameMode.ADVENTURE);
                    p.sendMessage(GREEN + "You Are Now In Gamemode " + GOLD + "Adventure" + GREEN + "!");
                    return true;
                }
                if(args[0].equalsIgnoreCase("3") || args[0].equalsIgnoreCase("sp")|| args[0].equalsIgnoreCase("spectator")){
                    p.setGameMode(GameMode.SPECTATOR);
                    p.sendMessage(GREEN + "You Are Now In Gamemode " + GOLD + "Spectator" + GREEN + "!");
                    return true;
                }
            }
        }
        else{
            p.sendMessage(RED + "EasyGamemodes Are Not Enabled in The Config for " + GOLD + "SuperTech!");
            return false;
        }
        return false;
    }
}
