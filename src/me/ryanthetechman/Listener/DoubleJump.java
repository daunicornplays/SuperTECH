package me.ryanthetechman.Listener;


import me.ryanthetechman.Main;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;

public class DoubleJump implements Listener{
    Main plugin;

    public DoubleJump(Main passedPlugin) {
        this.plugin = passedPlugin;
    }
    int DoubleJumpY;
    int DoubleJumpX;

    Player p;

    @EventHandler
    public void onPlayerToggleFlight(PlayerToggleFlightEvent event) {
        Player player = event.getPlayer();
        boolean DJBoolean = plugin.doublejump.getConfig().getBoolean("Enabled");
        if ((player.getGameMode() != GameMode.CREATIVE) && (player.hasPermission("supertech.doublejump"))
                && (DJBoolean))// Yo sah DJBoolean, Gimme a beat. He is giving me a beat on MC xD
        {
            event.setCancelled(true);
            player.setAllowFlight(false);
            player.setFlying(false);//>
            DoubleJumpX = plugin.doublejump.getConfig().getInt("PowerValues.X");
            DoubleJumpY = plugin.doublejump.getConfig().getInt("PowerValues.Y");
            {player.setVelocity(player.getLocation().getDirection().multiply(DoubleJumpX).setY(DoubleJumpY));}
        }

    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        boolean DJBoolean = plugin.doublejump.getConfig().getBoolean("Enabled");
        if ((player.getGameMode() != GameMode.CREATIVE) && (DJBoolean)
                && (player.getLocation().subtract(0.0D, 1.0D, 0.0D).getBlock().getType() != Material.AIR)
                && (!player.isFlying()) && (player.hasPermission("supertech.doublejump"))) {
            player.setAllowFlight(true);
        }
    }
}
