package be.shykuzo.kataskinapi;

import org.bukkit.plugin.java.JavaPlugin;

import be.shykuzo.kataskinapi.listeners.PlayerJoin;
import be.shykuzo.kataskinapi.listeners.PlayerQuit;

public class Main extends JavaPlugin {

	private static Main instance;
	
		// -------------------- \\
	
	@Override
	public void onEnable() {
		instance = this;
		
		saveDefaultConfig();
		getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
		getServer().getPluginManager().registerEvents(new PlayerQuit(), this);
	}
	
		// -------------------- \\
	
	public static Main getInstance() {
		return instance;
	}
	
}
