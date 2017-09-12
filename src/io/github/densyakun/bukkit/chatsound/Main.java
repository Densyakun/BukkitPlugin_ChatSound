package io.github.densyakun.bukkit.chatsound;

import java.util.Iterator;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings("deprecation")
public class Main extends JavaPlugin implements Listener {
	/**
	 * 1.9非対応
	 */
	Sound sound = Sound.NOTE_PIANO;
	float volume = 1.0f;
	float pitch = 12.0f;
	
	@Override
	public void onEnable() {
		saveDefaultConfig();
		Sound a = Sound.valueOf(getConfig().getString("sound", "NOTE_PIANO"));
		if (a != null) {
			sound = a;
		}
		volume = (float) getConfig().getDouble("volume", volume);
		pitch = (float) getConfig().getDouble("pitch", pitch);
		
		getServer().getPluginManager().registerEvents(this, this);
	}
	
	@EventHandler
	public void PlayerChat(PlayerChatEvent e) {
		Iterator<? extends Player> players = getServer().getOnlinePlayers().iterator();
		while (players.hasNext()) {
			Player p = players.next();
			p.playSound(p.getLocation(), sound, 1, 12);
		}
	}
}
