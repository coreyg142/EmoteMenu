package io.github.coreyg142.emotemenu;

import io.github.coreyg142.emotemenu.commands.CommandEmotes;
import io.github.coreyg142.emotemenu.util.Emote;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;


public final class EmoteMenu extends JavaPlugin {


	@Override
	public void onEnable() {
		// Plugin startup logic

		Emote.populateTwitchEmotes();
		Objects.requireNonNull(this.getCommand("emotes")).setExecutor(new CommandEmotes());
		getLogger().info("Emote menu is initialized!");
	}

	@Override
	public void onDisable() {
		// Plugin shutdown logic
	}

}
