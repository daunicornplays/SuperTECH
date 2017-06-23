package me.ryanthetechman.TabCompleters;

import com.google.common.collect.Lists;
import me.ryanthetechman.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.Arrays;
import java.util.List;

public class PlayersCompleter implements TabCompleter {
    Main plugin;

    public PlayersCompleter() {

    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String cl, String[] args) {

        List<String> a1 = Arrays.asList("show", "hide");

        List<String> clists = Lists.newArrayList();
        if (cl.equalsIgnoreCase("players")) {
            if (args.length == 1) {
                for (String a : a1) {
                    if (a.startsWith(args[0]))
                        clists.add(a);
                }
                return clists;
            }
        }

        return null;
    }
}