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

	Sound sound = null;
	float volume = 1.0f;
	float pitch = 2.0f;

	@Override
	public void onEnable() {
		saveDefaultConfig();
		Sound a = Sound.valueOf(getConfig().getString("sound", ""));
		if (a != null)
			sound = a;
		volume = (float) getConfig().getDouble("volume", volume);
		pitch = (float) getConfig().getDouble("pitch", pitch);

		getServer().getPluginManager().registerEvents(this, this);
	}

	@EventHandler
	public void PlayerChat(PlayerChatEvent e) {
		if (sound != null) {
			Iterator<? extends Player> players = getServer().getOnlinePlayers().iterator();
			while (players.hasNext()) {
				Player p = players.next();
				p.playSound(p.getLocation(), sound, volume, pitch);
			}
		}
	}
}
