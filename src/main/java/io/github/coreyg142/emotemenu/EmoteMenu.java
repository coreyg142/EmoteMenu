package io.github.coreyg142.emotemenu;

import io.github.coreyg142.emotemenu.commands.CommandEmotes;
import io.github.coreyg142.emotemenu.util.Emote;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

public final class EmoteMenu extends JavaPlugin {

	public static Logger logger;

	@Override
	public void onEnable() {
		// Plugin startup logic
		this.saveDefaultConfig();
		logger = getLogger();

		List<String> emotes = this.getConfig().getStringList("TwitchEmotes");
		boolean success = Emote.populateTwitchEmotes(emotes);

		if(!success) {
			getLogger().severe("Failed to initialize plugin.");
			return;
		}

		getLogger().info(String.format("Loaded %d emotes", Emote.TWITCH_EMOTES.size()));
		Objects.requireNonNull(this.getCommand("emotes")).setExecutor(new CommandEmotes());
		getLogger().info("Emote menu is initialized!");

	}

	@Override
	public void onDisable() {
		// Plugin shutdown logic
	}

}
