package me.ryanthetechman.Chat.AntiMemes;

import me.ryanthetechman.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.Random;
@SuppressWarnings("all")
public class BlockMemes implements Listener {
    Main plugin;

    public BlockMemes(Main plugin) {
        this.plugin = plugin;

}
    ChatColor color1;
    @EventHandler
    public void BlockMemes(AsyncPlayerChatEvent e) {
        Player p = (Player)e;
        for (Player pl : Bukkit.getOnlinePlayers()) {
            if (e.getMessage().contains("succ") || e.getMessage().contains("doge")) {
                e.setCancelled(true);

                final int[] colors = new Random().ints(1, 16).distinct().limit(19).toArray();
                getColor1(colors);
                p.sendMessage(color1 + "supsss");
                getColor2(colors);
                getColor3(colors);
                getColor4(colors);
                getColor5(colors);
                getColor6(colors);
                getColor7(colors);
                getColor8(colors);
                getColor9(colors);
                getColor10(colors);
                getColor11(colors);
                getColor12(colors);
                getColor13(colors);
                getColor14(colors);
                getColor15(colors);
                getColor16(colors);
                getColor17(colors);
                getColor18(colors);
                getColor19(colors);
                MSG(p);
                //p.sendMessage("§CS§Et§Ao§Bp§9 §DT§Cr§Ey§Ai§Bn§9g§D §CT§Eo§A §BB§9e§D §CA§E §AM§Be§9m§De§Cl§Eo§Ar§Bd§9!");
            }}}

            private void getColor1 ( int[] colors){
                ChatColor color1 = null;
                switch (colors[0]) {
                    default:
                    case 1:
                        color1 = ChatColor.AQUA;
                        break;
                    case 2:
                        color1 = ChatColor.BLACK;
                        break;
                    case 3:
                        color1 = ChatColor.BLUE;
                        break;
                    case 4:
                        color1 = ChatColor.DARK_AQUA;
                        break;
                    case 5:
                        color1 = ChatColor.DARK_BLUE;
                        break;
                    case 6:
                        color1 = ChatColor.DARK_GRAY;
                        break;
                    case 7:
                        color1 = ChatColor.DARK_GREEN;
                        break;
                    case 8:
                        color1 = ChatColor.DARK_PURPLE;
                        break;
                    case 9:
                        color1 = ChatColor.DARK_RED;
                        break;
                    case 10:
                        color1 = ChatColor.GOLD;
                        break;
                    case 11:
                        color1 = ChatColor.GRAY;
                        break;
                    case 12:
                        color1 = ChatColor.GREEN;
                        break;
                    case 13:
                        color1 = ChatColor.LIGHT_PURPLE;
                        break;
                    case 14:
                        color1 = ChatColor.RED;
                        break;
                    case 15:
                        color1 = ChatColor.YELLOW;
                        break;
                    case 16:
                        color1 = ChatColor.WHITE;
                        break;

                }
            }
            private void getColor2 ( int[] colors){
                ChatColor color = null;
                switch (colors[0]) {
                    default:
                    case 1:
                        color = ChatColor.AQUA;
                        break;
                    case 2:
                        color = ChatColor.BLACK;
                        break;
                    case 3:
                        color = ChatColor.BLUE;
                        break;
                    case 4:
                        color = ChatColor.DARK_AQUA;
                        break;
                    case 5:
                        color = ChatColor.DARK_BLUE;
                        break;
                    case 6:
                        color = ChatColor.DARK_GRAY;
                        break;
                    case 7:
                        color = ChatColor.DARK_GREEN;
                        break;
                    case 8:
                        color = ChatColor.DARK_PURPLE;
                        break;
                    case 9:
                        color = ChatColor.DARK_RED;
                        break;
                    case 10:
                        color = ChatColor.GOLD;
                        break;
                    case 11:
                        color = ChatColor.GRAY;
                        break;
                    case 12:
                        color = ChatColor.GREEN;
                        break;
                    case 13:
                        color = ChatColor.LIGHT_PURPLE;
                        break;
                    case 14:
                        color = ChatColor.RED;
                        break;
                    case 15:
                        color = ChatColor.YELLOW;
                        break;
                    case 16:
                        color = ChatColor.WHITE;
                        break;

                }
            }
            private void getColor3 ( int[] colors){
                ChatColor color = null;
                switch (colors[0]) {
                    default:
                    case 1:
                        color = ChatColor.AQUA;
                        break;
                    case 2:
                        color = ChatColor.BLACK;
                        break;
                    case 3:
                        color = ChatColor.BLUE;
                        break;
                    case 4:
                        color = ChatColor.DARK_AQUA;
                        break;
                    case 5:
                        color = ChatColor.DARK_BLUE;
                        break;
                    case 6:
                        color = ChatColor.DARK_GRAY;
                        break;
                    case 7:
                        color = ChatColor.DARK_GREEN;
                        break;
                    case 8:
                        color = ChatColor.DARK_PURPLE;
                        break;
                    case 9:
                        color = ChatColor.DARK_RED;
                        break;
                    case 10:
                        color = ChatColor.GOLD;
                        break;
                    case 11:
                        color = ChatColor.GRAY;
                        break;
                    case 12:
                        color = ChatColor.GREEN;
                        break;
                    case 13:
                        color = ChatColor.LIGHT_PURPLE;
                        break;
                    case 14:
                        color = ChatColor.RED;
                        break;
                    case 15:
                        color = ChatColor.YELLOW;
                        break;
                    case 16:
                        color = ChatColor.WHITE;
                        break;

                }
            }
            private void getColor4 ( int[] colors){
                ChatColor color = null;
                switch (colors[0]) {
                    default:
                    case 1:
                        color = ChatColor.AQUA;
                        break;
                    case 2:
                        color = ChatColor.BLACK;
                        break;
                    case 3:
                        color = ChatColor.BLUE;
                        break;
                    case 4:
                        color = ChatColor.DARK_AQUA;
                        break;
                    case 5:
                        color = ChatColor.DARK_BLUE;
                        break;
                    case 6:
                        color = ChatColor.DARK_GRAY;
                        break;
                    case 7:
                        color = ChatColor.DARK_GREEN;
                        break;
                    case 8:
                        color = ChatColor.DARK_PURPLE;
                        break;
                    case 9:
                        color = ChatColor.DARK_RED;
                        break;
                    case 10:
                        color = ChatColor.GOLD;
                        break;
                    case 11:
                        color = ChatColor.GRAY;
                        break;
                    case 12:
                        color = ChatColor.GREEN;
                        break;
                    case 13:
                        color = ChatColor.LIGHT_PURPLE;
                        break;
                    case 14:
                        color = ChatColor.RED;
                        break;
                    case 15:
                        color = ChatColor.YELLOW;
                        break;
                    case 16:
                        color = ChatColor.WHITE;
                        break;

                }
            }
            private void getColor5 ( int[] colors){
                ChatColor color = null;
                switch (colors[0]) {
                    default:
                    case 1:
                        color = ChatColor.AQUA;
                        break;
                    case 2:
                        color = ChatColor.BLACK;
                        break;
                    case 3:
                        color = ChatColor.BLUE;
                        break;
                    case 4:
                        color = ChatColor.DARK_AQUA;
                        break;
                    case 5:
                        color = ChatColor.DARK_BLUE;
                        break;
                    case 6:
                        color = ChatColor.DARK_GRAY;
                        break;
                    case 7:
                        color = ChatColor.DARK_GREEN;
                        break;
                    case 8:
                        color = ChatColor.DARK_PURPLE;
                        break;
                    case 9:
                        color = ChatColor.DARK_RED;
                        break;
                    case 10:
                        color = ChatColor.GOLD;
                        break;
                    case 11:
                        color = ChatColor.GRAY;
                        break;
                    case 12:
                        color = ChatColor.GREEN;
                        break;
                    case 13:
                        color = ChatColor.LIGHT_PURPLE;
                        break;
                    case 14:
                        color = ChatColor.RED;
                        break;
                    case 15:
                        color = ChatColor.YELLOW;
                        break;
                    case 16:
                        color = ChatColor.WHITE;
                        break;

                }
            }
            private void getColor6 ( int[] colors){
                ChatColor color = null;
                switch (colors[0]) {
                    default:
                    case 1:
                        color = ChatColor.AQUA;
                        break;
                    case 2:
                        color = ChatColor.BLACK;
                        break;
                    case 3:
                        color = ChatColor.BLUE;
                        break;
                    case 4:
                        color = ChatColor.DARK_AQUA;
                        break;
                    case 5:
                        color = ChatColor.DARK_BLUE;
                        break;
                    case 6:
                        color = ChatColor.DARK_GRAY;
                        break;
                    case 7:
                        color = ChatColor.DARK_GREEN;
                        break;
                    case 8:
                        color = ChatColor.DARK_PURPLE;
                        break;
                    case 9:
                        color = ChatColor.DARK_RED;
                        break;
                    case 10:
                        color = ChatColor.GOLD;
                        break;
                    case 11:
                        color = ChatColor.GRAY;
                        break;
                    case 12:
                        color = ChatColor.GREEN;
                        break;
                    case 13:
                        color = ChatColor.LIGHT_PURPLE;
                        break;
                    case 14:
                        color = ChatColor.RED;
                        break;
                    case 15:
                        color = ChatColor.YELLOW;
                        break;
                    case 16:
                        color = ChatColor.WHITE;
                        break;

                }
            }
            private void getColor7 ( int[] colors){
                ChatColor color = null;
                switch (colors[0]) {
                    default:
                    case 1:
                        color = ChatColor.AQUA;
                        break;
                    case 2:
                        color = ChatColor.BLACK;
                        break;
                    case 3:
                        color = ChatColor.BLUE;
                        break;
                    case 4:
                        color = ChatColor.DARK_AQUA;
                        break;
                    case 5:
                        color = ChatColor.DARK_BLUE;
                        break;
                    case 6:
                        color = ChatColor.DARK_GRAY;
                        break;
                    case 7:
                        color = ChatColor.DARK_GREEN;
                        break;
                    case 8:
                        color = ChatColor.DARK_PURPLE;
                        break;
                    case 9:
                        color = ChatColor.DARK_RED;
                        break;
                    case 10:
                        color = ChatColor.GOLD;
                        break;
                    case 11:
                        color = ChatColor.GRAY;
                        break;
                    case 12:
                        color = ChatColor.GREEN;
                        break;
                    case 13:
                        color = ChatColor.LIGHT_PURPLE;
                        break;
                    case 14:
                        color = ChatColor.RED;
                        break;
                    case 15:
                        color = ChatColor.YELLOW;
                        break;
                    case 16:
                        color = ChatColor.WHITE;
                        break;

                }
            }
            private void getColor8 ( int[] colors){
                ChatColor color = null;
                switch (colors[0]) {
                    default:
                    case 1:
                        color = ChatColor.AQUA;
                        break;
                    case 2:
                        color = ChatColor.BLACK;
                        break;
                    case 3:
                        color = ChatColor.BLUE;
                        break;
                    case 4:
                        color = ChatColor.DARK_AQUA;
                        break;
                    case 5:
                        color = ChatColor.DARK_BLUE;
                        break;
                    case 6:
                        color = ChatColor.DARK_GRAY;
                        break;
                    case 7:
                        color = ChatColor.DARK_GREEN;
                        break;
                    case 8:
                        color = ChatColor.DARK_PURPLE;
                        break;
                    case 9:
                        color = ChatColor.DARK_RED;
                        break;
                    case 10:
                        color = ChatColor.GOLD;
                        break;
                    case 11:
                        color = ChatColor.GRAY;
                        break;
                    case 12:
                        color = ChatColor.GREEN;
                        break;
                    case 13:
                        color = ChatColor.LIGHT_PURPLE;
                        break;
                    case 14:
                        color = ChatColor.RED;
                        break;
                    case 15:
                        color = ChatColor.YELLOW;
                        break;
                    case 16:
                        color = ChatColor.WHITE;
                        break;

                }
            }
            private void getColor9 ( int[] colors){
                ChatColor color = null;
                switch (colors[0]) {
                    default:
                    case 1:
                        color = ChatColor.AQUA;
                        break;
                    case 2:
                        color = ChatColor.BLACK;
                        break;
                    case 3:
                        color = ChatColor.BLUE;
                        break;
                    case 4:
                        color = ChatColor.DARK_AQUA;
                        break;
                    case 5:
                        color = ChatColor.DARK_BLUE;
                        break;
                    case 6:
                        color = ChatColor.DARK_GRAY;
                        break;
                    case 7:
                        color = ChatColor.DARK_GREEN;
                        break;
                    case 8:
                        color = ChatColor.DARK_PURPLE;
                        break;
                    case 9:
                        color = ChatColor.DARK_RED;
                        break;
                    case 10:
                        color = ChatColor.GOLD;
                        break;
                    case 11:
                        color = ChatColor.GRAY;
                        break;
                    case 12:
                        color = ChatColor.GREEN;
                        break;
                    case 13:
                        color = ChatColor.LIGHT_PURPLE;
                        break;
                    case 14:
                        color = ChatColor.RED;
                        break;
                    case 15:
                        color = ChatColor.YELLOW;
                        break;
                    case 16:
                        color = ChatColor.WHITE;
                        break;

                }
            }
            private void getColor10 ( int[] colors){
                ChatColor color = null;
                switch (colors[0]) {
                    default:
                    case 1:
                        color = ChatColor.AQUA;
                        break;
                    case 2:
                        color = ChatColor.BLACK;
                        break;
                    case 3:
                        color = ChatColor.BLUE;
                        break;
                    case 4:
                        color = ChatColor.DARK_AQUA;
                        break;
                    case 5:
                        color = ChatColor.DARK_BLUE;
                        break;
                    case 6:
                        color = ChatColor.DARK_GRAY;
                        break;
                    case 7:
                        color = ChatColor.DARK_GREEN;
                        break;
                    case 8:
                        color = ChatColor.DARK_PURPLE;
                        break;
                    case 9:
                        color = ChatColor.DARK_RED;
                        break;
                    case 10:
                        color = ChatColor.GOLD;
                        break;
                    case 11:
                        color = ChatColor.GRAY;
                        break;
                    case 12:
                        color = ChatColor.GREEN;
                        break;
                    case 13:
                        color = ChatColor.LIGHT_PURPLE;
                        break;
                    case 14:
                        color = ChatColor.RED;
                        break;
                    case 15:
                        color = ChatColor.YELLOW;
                        break;
                    case 16:
                        color = ChatColor.WHITE;
                        break;

                }
            }
            private void getColor11 ( int[] colors){
                ChatColor color = null;
                switch (colors[0]) {
                    default:
                    case 1:
                        color = ChatColor.AQUA;
                        break;
                    case 2:
                        color = ChatColor.BLACK;
                        break;
                    case 3:
                        color = ChatColor.BLUE;
                        break;
                    case 4:
                        color = ChatColor.DARK_AQUA;
                        break;
                    case 5:
                        color = ChatColor.DARK_BLUE;
                        break;
                    case 6:
                        color = ChatColor.DARK_GRAY;
                        break;
                    case 7:
                        color = ChatColor.DARK_GREEN;
                        break;
                    case 8:
                        color = ChatColor.DARK_PURPLE;
                        break;
                    case 9:
                        color = ChatColor.DARK_RED;
                        break;
                    case 10:
                        color = ChatColor.GOLD;
                        break;
                    case 11:
                        color = ChatColor.GRAY;
                        break;
                    case 12:
                        color = ChatColor.GREEN;
                        break;
                    case 13:
                        color = ChatColor.LIGHT_PURPLE;
                        break;
                    case 14:
                        color = ChatColor.RED;
                        break;
                    case 15:
                        color = ChatColor.YELLOW;
                        break;
                    case 16:
                        color = ChatColor.WHITE;
                        break;

                }
            }
            private void getColor12 ( int[] colors){
                ChatColor color = null;
                switch (colors[0]) {
                    default:
                    case 1:
                        color = ChatColor.AQUA;
                        break;
                    case 2:
                        color = ChatColor.BLACK;
                        break;
                    case 3:
                        color = ChatColor.BLUE;
                        break;
                    case 4:
                        color = ChatColor.DARK_AQUA;
                        break;
                    case 5:
                        color = ChatColor.DARK_BLUE;
                        break;
                    case 6:
                        color = ChatColor.DARK_GRAY;
                        break;
                    case 7:
                        color = ChatColor.DARK_GREEN;
                        break;
                    case 8:
                        color = ChatColor.DARK_PURPLE;
                        break;
                    case 9:
                        color = ChatColor.DARK_RED;
                        break;
                    case 10:
                        color = ChatColor.GOLD;
                        break;
                    case 11:
                        color = ChatColor.GRAY;
                        break;
                    case 12:
                        color = ChatColor.GREEN;
                        break;
                    case 13:
                        color = ChatColor.LIGHT_PURPLE;
                        break;
                    case 14:
                        color = ChatColor.RED;
                        break;
                    case 15:
                        color = ChatColor.YELLOW;
                        break;
                    case 16:
                        color = ChatColor.WHITE;
                        break;

                }
            }
            private void getColor13 ( int[] colors){
                ChatColor color = null;
                switch (colors[0]) {
                    default:
                    case 1:
                        color = ChatColor.AQUA;
                        break;
                    case 2:
                        color = ChatColor.BLACK;
                        break;
                    case 3:
                        color = ChatColor.BLUE;
                        break;
                    case 4:
                        color = ChatColor.DARK_AQUA;
                        break;
                    case 5:
                        color = ChatColor.DARK_BLUE;
                        break;
                    case 6:
                        color = ChatColor.DARK_GRAY;
                        break;
                    case 7:
                        color = ChatColor.DARK_GREEN;
                        break;
                    case 8:
                        color = ChatColor.DARK_PURPLE;
                        break;
                    case 9:
                        color = ChatColor.DARK_RED;
                        break;
                    case 10:
                        color = ChatColor.GOLD;
                        break;
                    case 11:
                        color = ChatColor.GRAY;
                        break;
                    case 12:
                        color = ChatColor.GREEN;
                        break;
                    case 13:
                        color = ChatColor.LIGHT_PURPLE;
                        break;
                    case 14:
                        color = ChatColor.RED;
                        break;
                    case 15:
                        color = ChatColor.YELLOW;
                        break;
                    case 16:
                        color = ChatColor.WHITE;
                        break;

                }
            }
            private void getColor14 ( int[] colors){
                ChatColor color = null;
                switch (colors[0]) {
                    default:
                    case 1:
                        color = ChatColor.AQUA;
                        break;
                    case 2:
                        color = ChatColor.BLACK;
                        break;
                    case 3:
                        color = ChatColor.BLUE;
                        break;
                    case 4:
                        color = ChatColor.DARK_AQUA;
                        break;
                    case 5:
                        color = ChatColor.DARK_BLUE;
                        break;
                    case 6:
                        color = ChatColor.DARK_GRAY;
                        break;
                    case 7:
                        color = ChatColor.DARK_GREEN;
                        break;
                    case 8:
                        color = ChatColor.DARK_PURPLE;
                        break;
                    case 9:
                        color = ChatColor.DARK_RED;
                        break;
                    case 10:
                        color = ChatColor.GOLD;
                        break;
                    case 11:
                        color = ChatColor.GRAY;
                        break;
                    case 12:
                        color = ChatColor.GREEN;
                        break;
                    case 13:
                        color = ChatColor.LIGHT_PURPLE;
                        break;
                    case 14:
                        color = ChatColor.RED;
                        break;
                    case 15:
                        color = ChatColor.YELLOW;
                        break;
                    case 16:
                        color = ChatColor.WHITE;
                        break;

                }
            }
            private void getColor15 ( int[] colors){
                ChatColor color = null;
                switch (colors[0]) {
                    default:
                    case 1:
                        color = ChatColor.AQUA;
                        break;
                    case 2:
                        color = ChatColor.BLACK;
                        break;
                    case 3:
                        color = ChatColor.BLUE;
                        break;
                    case 4:
                        color = ChatColor.DARK_AQUA;
                        break;
                    case 5:
                        color = ChatColor.DARK_BLUE;
                        break;
                    case 6:
                        color = ChatColor.DARK_GRAY;
                        break;
                    case 7:
                        color = ChatColor.DARK_GREEN;
                        break;
                    case 8:
                        color = ChatColor.DARK_PURPLE;
                        break;
                    case 9:
                        color = ChatColor.DARK_RED;
                        break;
                    case 10:
                        color = ChatColor.GOLD;
                        break;
                    case 11:
                        color = ChatColor.GRAY;
                        break;
                    case 12:
                        color = ChatColor.GREEN;
                        break;
                    case 13:
                        color = ChatColor.LIGHT_PURPLE;
                        break;
                    case 14:
                        color = ChatColor.RED;
                        break;
                    case 15:
                        color = ChatColor.YELLOW;
                        break;
                    case 16:
                        color = ChatColor.WHITE;
                        break;

                }
            }
            private void getColor16 ( int[] colors){
                ChatColor color = null;
                switch (colors[0]) {
                    default:
                    case 1:
                        color = ChatColor.AQUA;
                        break;
                    case 2:
                        color = ChatColor.BLACK;
                        break;
                    case 3:
                        color = ChatColor.BLUE;
                        break;
                    case 4:
                        color = ChatColor.DARK_AQUA;
                        break;
                    case 5:
                        color = ChatColor.DARK_BLUE;
                        break;
                    case 6:
                        color = ChatColor.DARK_GRAY;
                        break;
                    case 7:
                        color = ChatColor.DARK_GREEN;
                        break;
                    case 8:
                        color = ChatColor.DARK_PURPLE;
                        break;
                    case 9:
                        color = ChatColor.DARK_RED;
                        break;
                    case 10:
                        color = ChatColor.GOLD;
                        break;
                    case 11:
                        color = ChatColor.GRAY;
                        break;
                    case 12:
                        color = ChatColor.GREEN;
                        break;
                    case 13:
                        color = ChatColor.LIGHT_PURPLE;
                        break;
                    case 14:
                        color = ChatColor.RED;
                        break;
                    case 15:
                        color = ChatColor.YELLOW;
                        break;
                    case 16:
                        color = ChatColor.WHITE;
                        break;

                }
            }
            private void getColor17 ( int[] colors){
                ChatColor color = null;
                switch (colors[0]) {
                    default:
                    case 1:
                        color = ChatColor.AQUA;
                        break;
                    case 2:
                        color = ChatColor.BLACK;
                        break;
                    case 3:
                        color = ChatColor.BLUE;
                        break;
                    case 4:
                        color = ChatColor.DARK_AQUA;
                        break;
                    case 5:
                        color = ChatColor.DARK_BLUE;
                        break;
                    case 6:
                        color = ChatColor.DARK_GRAY;
                        break;
                    case 7:
                        color = ChatColor.DARK_GREEN;
                        break;
                    case 8:
                        color = ChatColor.DARK_PURPLE;
                        break;
                    case 9:
                        color = ChatColor.DARK_RED;
                        break;
                    case 10:
                        color = ChatColor.GOLD;
                        break;
                    case 11:
                        color = ChatColor.GRAY;
                        break;
                    case 12:
                        color = ChatColor.GREEN;
                        break;
                    case 13:
                        color = ChatColor.LIGHT_PURPLE;
                        break;
                    case 14:
                        color = ChatColor.RED;
                        break;
                    case 15:
                        color = ChatColor.YELLOW;
                        break;
                    case 16:
                        color = ChatColor.WHITE;
                        break;

                }
            }
            private void getColor18 ( int[] colors){
                ChatColor color = null;
                switch (colors[0]) {
                    default:
                    case 1:
                        color = ChatColor.AQUA;
                        break;
                    case 2:
                        color = ChatColor.BLACK;
                        break;
                    case 3:
                        color = ChatColor.BLUE;
                        break;
                    case 4:
                        color = ChatColor.DARK_AQUA;
                        break;
                    case 5:
                        color = ChatColor.DARK_BLUE;
                        break;
                    case 6:
                        color = ChatColor.DARK_GRAY;
                        break;
                    case 7:
                        color = ChatColor.DARK_GREEN;
                        break;
                    case 8:
                        color = ChatColor.DARK_PURPLE;
                        break;
                    case 9:
                        color = ChatColor.DARK_RED;
                        break;
                    case 10:
                        color = ChatColor.GOLD;
                        break;
                    case 11:
                        color = ChatColor.GRAY;
                        break;
                    case 12:
                        color = ChatColor.GREEN;
                        break;
                    case 13:
                        color = ChatColor.LIGHT_PURPLE;
                        break;
                    case 14:
                        color = ChatColor.RED;
                        break;
                    case 15:
                        color = ChatColor.YELLOW;
                        break;
                    case 16:
                        color = ChatColor.WHITE;
                        break;

                }
            }
            private void getColor19 ( int[] colors){
                ChatColor color = null;
                switch (colors[0]) {
                    default:
                    case 1:
                        color = ChatColor.AQUA;
                        break;
                    case 2:
                        color = ChatColor.BLACK;
                        break;
                    case 3:
                        color = ChatColor.BLUE;
                        break;
                    case 4:
                        color = ChatColor.DARK_AQUA;
                        break;
                    case 5:
                        color = ChatColor.DARK_BLUE;
                        break;
                    case 6:
                        color = ChatColor.DARK_GRAY;
                        break;
                    case 7:
                        color = ChatColor.DARK_GREEN;
                        break;
                    case 8:
                        color = ChatColor.DARK_PURPLE;
                        break;
                    case 9:
                        color = ChatColor.DARK_RED;
                        break;
                    case 10:
                        color = ChatColor.GOLD;
                        break;
                    case 11:
                        color = ChatColor.GRAY;
                        break;
                    case 12:
                        color = ChatColor.GREEN;
                        break;
                    case 13:
                        color = ChatColor.LIGHT_PURPLE;
                        break;
                    case 14:
                        color = ChatColor.RED;
                        break;
                    case 15:
                        color = ChatColor.YELLOW;
                        break;
                    case 16:
                        color = ChatColor.WHITE;
                        break;

                }
            }

            private void MSG (Player p){
                p.sendMessage(color1 + "sa");
            }
        }
