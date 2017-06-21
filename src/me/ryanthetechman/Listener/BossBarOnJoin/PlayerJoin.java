package me.ryanthetechman.Listener.BossBarOnJoin;

import me.ryanthetechman.Utilities.Wait;
import net.md_5.bungee.api.chat.TextComponent;
import static org.bukkit.ChatColor.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

@SuppressWarnings("all")
public class PlayerJoin implements Listener {
	private final Plugin plugin;
	{
		Plugin plugin;
	}

	public PlayerJoin(Plugin passedPlugin) {
		this.plugin = passedPlugin;
	}
	
	  @EventHandler public void onPlayerJoin(PlayerJoinEvent event){
	   /* Player p = (Player) event;
	    BossBar bossBar1 = BossBarAPI.addBar(p, new TextComponent(AQUA + "Welcome, " + p.getName() + "To The Server!"),
                BossBarAPI.Color.BLUE, BossBarAPI.Style.NOTCHED_20, 1.0F, 1,2);
          Wait.SECONDS(1);
          BossBar bossBar2 = BossBarAPI.addBar(p, new TextComponent(AQUA + "Welcome, " + p.getName() + "To The Server!"),
                  BossBarAPI.Color.GREEN, BossBarAPI.Style.NOTCHED_20, 1.0F, 1,2);
          Wait.SECONDS(1);
          BossBar bossBar3 = BossBarAPI.addBar(p, new TextComponent(AQUA + "Welcome, " + p.getName() + "To The Server!"),
                  BossBarAPI.Color.PINK, BossBarAPI.Style.NOTCHED_20, 1.0F, 1,2);
          Wait.SECONDS(1);
          BossBar bossBar4 = BossBarAPI.addBar(p, new TextComponent(AQUA + "Welcome, " + p.getName() + "To The Server!"),
                  BossBarAPI.Color.PURPLE, BossBarAPI.Style.NOTCHED_20, 1.0F, 1,2);
          Wait.SECONDS(1);
          BossBar bossBar5 = BossBarAPI.addBar(p, new TextComponent(AQUA + "Welcome, " + p.getName() + "To The Server!"),
                  BossBarAPI.Color.RED, BossBarAPI.Style.NOTCHED_20, 1.0F, 1,2);
          Wait.SECONDS(1);
          BossBar bossBar6 = BossBarAPI.addBar(p, new TextComponent(AQUA + "Welcome, " + p.getName() + "To The Server!"),
                  BossBarAPI.Color.WHITE, BossBarAPI.Style.NOTCHED_20, 1.0F, 1,2);
          Wait.SECONDS(1);
          BossBar bossBar7 = BossBarAPI.addBar(p, new TextComponent(AQUA + "Welcome, " + p.getName() + "To The Server!"),
                  BossBarAPI.Color.YELLOW, BossBarAPI.Style.NOTCHED_20, 1.0F, 1,2);
*/
      }
	 
}
