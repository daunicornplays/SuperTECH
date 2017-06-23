package me.ryanthetechman.TabCompleters;

import com.google.common.collect.Lists;
import me.ryanthetechman.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.Arrays;
import java.util.List;

public class SuperTechCompleter implements TabCompleter {
    Main plugin;

    public SuperTechCompleter() {

    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String cl, String[] args) {
        List<String> a1 = Arrays.asList("reload", "config", "give"); // to add more, add "1", "2","3" for more list
        List<String> give = Arrays.asList( "lightningbow", "tntbow", "enderbow");
        List<String> reload = Arrays.asList("main", "messages", "doublejump", "movement", "hideandshow");
        // /\ Copy and paste that but change a few things
        // /e the name and what gets returned so if you had /supertech msg send
        // then you would do the above one and one under and add is as
        // args.length > 2
        // You'll need a new tabcompleter for each command or
        List<String> clists = Lists.newArrayList();
        if (cl.equalsIgnoreCase("supertech") || cl.equalsIgnoreCase("st")) {
            if (args.length == 1) {
                for (String a : a1) {
                    if (a.startsWith(args[0]))
                        clists.add(a);// if i do /ST give it will show else if i do /ST reload it will show else if i do /ST
                }
                return clists;
            } // but how is this defining the vars? because it will just do tis i only want
            if (args.length == 2) {
                for (String a : reload) {
                    if (a.startsWith(args[1]) && args[0].equalsIgnoreCase("reload")) clists.add(a);
                }
                for (String a : give) {
                    if (a.startsWith(args[1]) && args[0].equalsIgnoreCase("give")) clists.add(a);
                }
                return clists;
            }
        }

        return null;
    }
}
