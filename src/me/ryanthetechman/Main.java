package me.ryanthetechman;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import me.ryanthetechman.BanGUI.BanGuiMain;
import me.ryanthetechman.Chat.AntiMemes.BlockMemes;
import me.ryanthetechman.Commands.*;
import me.ryanthetechman.Commands.EasyGamemodes.GamemodeChangerALL;
import me.ryanthetechman.Commands.EasyGamemodes.Individual.GMA;
import me.ryanthetechman.Commands.EasyGamemodes.Individual.GMC;
import me.ryanthetechman.Commands.EasyGamemodes.Individual.GMS;
import me.ryanthetechman.Commands.EasyGamemodes.Individual.GMSP;
import me.ryanthetechman.Commands.echest;
import me.ryanthetechman.Commands.Movement.FlySpeed;
import me.ryanthetechman.Commands.Movement.WalkSpeed;
import me.ryanthetechman.Commands.Spawn.SetSpawn;
import me.ryanthetechman.Commands.Spawn.Spawn;
import me.ryanthetechman.Commands.Tpo.Tpo;
import me.ryanthetechman.Commands.Tpo.TpoHere;
import me.ryanthetechman.Config.PluginConfig;
import me.ryanthetechman.Listener.*;
import me.ryanthetechman.Listener.BossBarOnJoin.PlayerJoin;
import me.ryanthetechman.Listener.HomingFireballs.FireballShoot;
import me.ryanthetechman.TabCompleters.PlayersCompleter;
import me.ryanthetechman.TabCompleters.SuperTechCompleter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {


    public PluginConfig spawn = new PluginConfig(this, "spawn", false);
    public PluginConfig teleport = new PluginConfig(this, "teleport", false);
    public PluginConfig blockbreak = new PluginConfig(this, "blockbreak", false);
    public PluginConfig hideandshow = new PluginConfig(this, "hideandshow", false);
    public PluginConfig doublejump = new PluginConfig(this, "doublejump", false);
    public PluginConfig movement = new PluginConfig(this, "movement", false);
    public PluginConfig jumppads = new PluginConfig(this, "jumppads", false);
	public PluginConfig config = new PluginConfig(this, "config", true);
	public PluginConfig messages = new PluginConfig(this, "messages", true);

    @Override
    public void onDisable(){
        messages.saveConfig();
        messages.reloadConfig();
        config.saveConfig();
        config.reloadConfig();
        spawn.saveConfig();
        spawn.reloadConfig();
        doublejump.saveConfig();
        doublejump.reloadConfig();
		movement.saveConfig();
		movement.reloadConfig();
        hideandshow.saveConfig();
        hideandshow.reloadConfig();
        blockbreak.saveConfig();
        blockbreak.reloadConfig();
        teleport.saveConfig();
        teleport.reloadConfig();
        jumppads.saveConfig();
        jumppads.reloadConfig();
    }

    @Override
	public void onEnable() {
        messages.reloadConfig();
        messages.saveConfig();
        config.reloadConfig();
        config.saveConfig();
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new SuperCreeper(this), this);
		pm.registerEvents(new JumpPads(this), this);
		pm.registerEvents(new BarrierFun(this), this);
		pm.registerEvents(new BanGuiMain(this), this);
		pm.registerEvents(new onChat(this), this);
		pm.registerEvents(new FireballShoot(this), this);
		CommandExecutors();
		TabCompleter();
		ConfigSetup();
	}

    private void ConfigSetup() {
        DoubleJumpSetUp();
        Movement();
        SpawnSetUp();
        BlockBreakSetup();
        JumpPadsSetup();
    }

    private void JumpPadsSetup() {
        if(jumppads.getConfig().getString("BlockToUse") == null || jumppads.getConfig().getString("BlockToUse") == ""){
            jumppads.getConfig().set("BlockToUse", "REDSTONE_BLOCK");
        }
        if(jumppads.getConfig().getString("Activator.Normal") == null || jumppads.getConfig().getString("Activator.Normal") == ""){
            jumppads.getConfig().set("Activator.Normal", "STONE_PLATE");
        }
        if(jumppads.getConfig().getString("Activator.Boosted") == null || jumppads.getConfig().getString("Activator.Boosted") == ""){
            jumppads.getConfig().set("Activator.Boosted", "GOLD_PLATE");
        }
    }

    private void BlockBreakSetup() {
        if(spawn.getConfig().getString("Spawn.Particles") == null || spawn.getConfig().getString("Spawn.Particles") == ""){
            spawn.getConfig().set("Spawn.Particles", true);
        }
    }


    private void Movement() {
        FlySpeedSetup();
        WalkSpeedSetup();
    }

    private void SpawnSetUp() {
        if(spawn.getConfig().getString("Spawn.Particles") == null || spawn.getConfig().getString("Spawn.Particles") == ""){
            spawn.getConfig().set("Spawn.Particles", true);
        }
    }

    private void WalkSpeedSetup() {
        if(this.movement.getConfig().getString("WalkSpeed.Enabled") == null ||
                this.movement.getConfig().getString("WalkSpeed.Enabled") == ""){
            this.movement.getConfig().set("WalkSpeed.Enabled", true);
        }
    }

    private void FlySpeedSetup() {
        if(this.movement.getConfig().getString("Flyspeed.Enabled") == null ||
                this.movement.getConfig().getString("FlySpeed.Enabled") == ""){
            this.movement.getConfig().set("FlySpeed.Enabled", true);
        }
    }

    private void DoubleJumpSetUp() {
        if(this.doublejump.getConfig().getString("Enabled") == null ||
                this.doublejump.getConfig().getString("Enabled") == ""){
            this.doublejump.getConfig().set("Enabled", true);
        }
        if (this.doublejump.getConfig().getString("PowerValues.X") == "" ||
                this.doublejump.getConfig().getString("PowerValues.Y") == "" ||
                this.doublejump.getConfig().getString("PowerValues.X") == null ||
                this.doublejump.getConfig().getString("PowerValues.Y") == null){

            this.doublejump.getConfig().set("PowerValues.X", 3);
            this.doublejump.getConfig().set("PowerValues.Y", 1);
            this.doublejump.saveConfig();
            this.doublejump.reloadConfig();
        }
    }

    private void CommandExecutors() {
		Tpo tpo = new Tpo(this);
		Spawn spawn = new Spawn(this);
		TpoHere tpohere = new TpoHere();
		afk afk = new afk(this);
		Skull skull = new Skull(this);
		SetSpawn setspawn = new SetSpawn(this);
		FlySpeed flyspeed = new FlySpeed(this);
		WalkSpeed walkspeed = new WalkSpeed(this);
        GamemodeChangerALL gamemodechangerall = new GamemodeChangerALL(this);
        GMC gmc = new GMC(this);
        GMS gms = new GMS(this);
        GMA gma = new GMA(this);
        GMSP gmsp = new GMSP(this);
		DoubleJump doublejump = new DoubleJump(this);
        Bacon bacon = new Bacon(this);
        PlayersHideAndShow hideandshow = new PlayersHideAndShow(this);
        RandomFireworks randomfireworks = new RandomFireworks(this);
        echest echest = new echest(this);
        workbench workbench = new workbench(this);
        FakeLogin fakelogin = new FakeLogin(this);
        BlockDenied blockDenied = new BlockDenied(this);
        SmiteBow smitebow = new SmiteBow(this);
        //BlockMemes blockmemes = new BlockMemes(this);
        Ping ping = new Ping(this);
        getCommand("ping").setExecutor(ping);
        getCommand("toggleblockbreak").setExecutor(blockDenied);
        getCommand("echest").setExecutor(echest);
        getCommand("workbench").setExecutor(workbench);
        getCommand("wbench").setExecutor(workbench);
        getCommand("enderchest").setExecutor(echest);
        getCommand("fake").setExecutor(fakelogin);
        getCommand("randomfirework").setExecutor(randomfireworks);
        getCommand("rfirework").setExecutor(randomfireworks);
        getCommand("firework").setExecutor(randomfireworks);
        getCommand("players").setExecutor(hideandshow);
        getCommand("player").setExecutor(hideandshow);
        getCommand("bacon").setExecutor(bacon);
        getCommand("gms").setExecutor(gms);
        getCommand("gma").setExecutor(gma);
        getCommand("gmsp").setExecutor(gmsp);
		getCommand("walkspeed").setExecutor(walkspeed);
        getCommand("gm").setExecutor(gamemodechangerall);
		getCommand("wspeed").setExecutor(walkspeed);
		getCommand("fspeed").setExecutor(flyspeed);
		getCommand("flyspeed").setExecutor(flyspeed);
		getCommand("tpo").setExecutor(tpo);
		getCommand("tpohere").setExecutor(tpohere);
		getCommand("skull").setExecutor(skull);
		getCommand("afk").setExecutor(afk);
		getCommand("spawn").setExecutor(spawn);
		getCommand("supertech").setExecutor(new SuperTech(this));
		getCommand("setspawn").setExecutor(new SetSpawn(this));
		getServer().getPluginManager().registerEvents(doublejump, this);
        getServer().getPluginManager().registerEvents(tpo, this);
		getServer().getPluginManager().registerEvents(tpohere, this);
		getServer().getPluginManager().registerEvents(new PlayerJoin(this), this);
		getServer().getPluginManager().registerEvents(afk, this);
		getServer().getPluginManager().registerEvents(spawn, this);
		getServer().getPluginManager().registerEvents(setspawn, this);
        getServer().getPluginManager().registerEvents(hideandshow, this);
        getServer().getPluginManager().registerEvents(blockDenied, this);
        getServer().getPluginManager().registerEvents(smitebow, this);
       // getServer().getPluginManager().registerEvents(blockmemes, this);
	}

	private void TabCompleter() {
		getCommand("supertech").setTabCompleter(new SuperTechCompleter());
        getCommand("players").setTabCompleter(new PlayersCompleter());
        getCommand("player").setTabCompleter(new PlayersCompleter());
		//getCommand("example").setTabCompleter(new SuperTechCompleter())

	}



	public static HashMap<String, String> messageData = new HashMap<String, String>();

	public void MessageSetup() {
		File f = new File(getDataFolder() + File.separator + "messages.yml");
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		FileConfiguration config = YamlConfiguration.loadConfiguration(f);
		for (String message : config.getConfigurationSection("").getKeys(false)) {
			messageData.put(message, config.getString(message));

		}
	}


	private void setMessage(String name, String message) {
		messages.getConfig().set(name, ChatColor.translateAlternateColorCodes('&', message));
		messages.saveConfig();
		return;
	}

	public void Message(String path, String message) {
		setMessage(path, ChatColor.translateAlternateColorCodes('&', message));
		return;
	}
}
