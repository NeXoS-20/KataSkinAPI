package be.shykuzo.kataskinapi.listeners;

import java.io.File;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit implements Listener {

	@EventHandler
	public void onQuit(PlayerQuitEvent event) {
		File skinFile = new File(String.format("/plugins/SkinsRestorer/Skins/%s.skin", event.getPlayer().getName()));
		
		if(skinFile.exists()) { skinFile.delete(); }
	}
	
}
