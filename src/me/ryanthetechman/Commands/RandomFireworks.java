package me.ryanthetechman.Commands;

import java.util.Random;

import me.ryanthetechman.Main;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.meta.FireworkMeta;

public class RandomFireworks implements CommandExecutor, Listener{

    Main plugin;
    public RandomFireworks(Main passedPlugin) {this.plugin = passedPlugin;}

        public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        Player p = (Player)sender;
            if(args.length == 0){
                shootFirework(p);
                return true;
            }
            if (args[0].equalsIgnoreCase("all")){
            shootFireworkAll();
            return true;
        }
        return false;
        }
        private void shootFirework(Player player) {

                Firework fw = (Firework) player.getWorld().spawn(player.getLocation(), Firework.class);
                FireworkMeta fwm = fw.getFireworkMeta();
                Random r = new Random();
                Type type = null;
                int fType = r.nextInt(5) + 1;
                switch (fType){
                    default:
                    case 1:
                        type = Type.BALL;
                        break;
                    case 2:
                        type = Type.BALL_LARGE;
                        break;
                    case 3:
                        type = Type.BURST;
                        break;
                    case 4:
                        type = Type.CREEPER;
                        break;
                    case 5:
                        type = Type.STAR;
                }
                int c1i = r.nextInt(17) + 1;
                int c2i = r.nextInt(17) + 1;
                Color c1 = getColor(c1i);
                Color c2 = getColor(c2i);
                FireworkEffect effect = FireworkEffect.builder().flicker(r.nextBoolean()).withColor(c1).withFade(c2).with(type).trail(r.nextBoolean()).build();

                fwm.addEffect(effect);
                int power = r.nextInt(2) + 1;
                fwm.setPower(power);
                fw.setFireworkMeta(fwm);

        }

        public Color getColor(int c){
            switch (c){
                default:
                case 1:
                    return Color.AQUA;
                case 2:
                    return Color.BLACK;
                case 3:
                    return Color.BLUE;
                case 4:
                    return Color.FUCHSIA;
                case 5:
                    return Color.GRAY;
                case 6:
                    return Color.GREEN;
                case 7:
                    return Color.LIME;
                case 8:
                    return Color.MAROON;
                case 9:
                    return Color.NAVY;
                case 10:
                    return Color.OLIVE;
                case 11:
                    return Color.ORANGE;
                case 12:
                    return Color.PURPLE;
                case 13:
                    return Color.RED;
                case 14:
                    return Color.SILVER;
                case 15:
                    return Color.TEAL;
                case 16:
                    return Color.WHITE;
                case 17:
                    return Color.YELLOW;
            }
        }
    private void shootFireworkAll() {

        for (Player player : Bukkit.getOnlinePlayers()){
            Firework fw = (Firework) player.getWorld().spawn(player.getLocation(), Firework.class);
            FireworkMeta fwm = fw.getFireworkMeta();
            Random r = new Random();
            Type type = null;
            int fType = r.nextInt(5) + 1;
            switch (fType){
                default:
                case 1:
                    type = Type.BALL;
                    break;
                case 2:
                    type = Type.BALL_LARGE;
                    break;
                case 3:
                    type = Type.BURST;
                    break;
                case 4:
                    type = Type.CREEPER;
                    break;
                case 5:
                    type = Type.STAR;
            }
            int c1i = r.nextInt(17) + 1;
            int c2i = r.nextInt(17) + 1;
            Color c1 = getColor(c1i);
            Color c2 = getColor(c2i);
            FireworkEffect effect = FireworkEffect.builder().flicker(r.nextBoolean()).withColor(c1).withFade(c2).with(type).trail(r.nextBoolean()).build();

            fwm.addEffect(effect);
            int power = r.nextInt(2) + 1;
            fwm.setPower(power);
            fw.setFireworkMeta(fwm);
        }

    }


}
