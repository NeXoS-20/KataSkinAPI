package be.shykuzo.kataskinapi.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import be.shykuzo.kataskinapi.Main;
import net.skinsrestorer.api.PlayerWrapper;
import net.skinsrestorer.api.SkinVariant;
import net.skinsrestorer.api.SkinsRestorerAPI;
import net.skinsrestorer.api.exception.SkinRequestException;

public class PlayerJoin implements Listener {
		
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		applySkin(event.getPlayer());
	}
	
		// -------------------- \\
	
	private void applySkin(Player player) {		
		if (Bukkit.getPluginManager().getPlugin("SkinsRestorer") != null) {
			Bukkit.getLogger().info("Le plugin 'SkinsRestorer' a été détecté, les skins peuvent être appliqués !");

            try {
            	SkinsRestorerAPI.getApi().applySkin(
            			new PlayerWrapper(player),
            			SkinsRestorerAPI.getApi().genSkinUrl(
            					Main.getInstance().getConfig().getString("API").replace("{PLAYER_NAME}", player.getName()),
            					SkinVariant.CLASSIC
            			)
            	);
  			} catch (SkinRequestException exception) {
				exception.printStackTrace();
			}

            Bukkit.getLogger().info(String.format("Le skin de %s a été mis à jour avec succès !", player.getName()));
        } else {
            Bukkit.getLogger().severe("Le plugin 'SkinsRestorer' n'a pas été détecté, veuillez l'installer !");
            Main.getInstance().getServer().getPluginManager().disablePlugin(Main.getInstance());
        }
		
	}
	
}
