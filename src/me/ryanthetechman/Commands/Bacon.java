package me.ryanthetechman.Commands;

import me.ryanthetechman.Main;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import static org.bukkit.entity.EntityType.*;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Iterator;

public class Bacon implements CommandExecutor {
    Main plugin;
    Entity e;
    ArrayList<Entity> entityList;

    public Bacon(Main passedPlugin) {
        this.plugin = passedPlugin;
    }

    public boolean onCommand(CommandSender sender, Command command, String cmdLabel, String[] args) {
        Player p = (Player) sender;

        if (sender instanceof Player) {
            int a;
            World w = Bukkit.getWorld(p.getWorld().getName());
            p.sendMessage("WELP");//try it xD

            Iterator<Entity> iter = w.getEntities().iterator();
            Entity ent = iter.next();
            while (iter.hasNext()) {

                switch (ent.getType())
                {
                    case PIG:
                        a = ent.getWorld().getEntities().size();
                        ent.remove();

                        p.sendMessage("Killed " + a + " Pigs");
                        break;
                }
            }

        }

        return false;
    }

}


