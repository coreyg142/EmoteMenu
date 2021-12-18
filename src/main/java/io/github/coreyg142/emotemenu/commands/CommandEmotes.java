package io.github.coreyg142.emotemenu.commands;

import io.github.coreyg142.emotemenu.util.Emote;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.checkerframework.checker.nullness.qual.NonNull;


public class CommandEmotes implements CommandExecutor {

	private final TextComponent space = new TextComponent(" ");

	/**
	 * Executes the given command, returning its success.
	 * <br>
	 * If false is returned, then the "usage" plugin.yml entry for this command
	 * (if defined) will be sent to the player.
	 *
	 * @param sender  Source of the command
	 * @param command Command which was executed
	 * @param label   Alias of the command which was used
	 * @param args    Passed command arguments
	 * @return true if a valid command, otherwise false
	 */
	@Override
	public boolean onCommand(@NonNull CommandSender sender, @NonNull Command command, @NonNull String label, @NonNull String[] args) {

		if(!(sender instanceof Player)) return false;

		sender.spigot().sendMessage(getMenu());

		return true;
	}

	public BaseComponent[] getMenu(){
		BaseComponent[] output = new BaseComponent[Emote.calcComponentSize()];

		output[0] = new TextComponent("Available Emotes\n");
		output[0].setColor(ChatColor.DARK_PURPLE);
		output[0].setUnderlined(true);
		output[0].setBold(true);

		output[1] = new TextComponent("Twitch\n");
		output[1].setColor(ChatColor.BLUE);

		int index = 2;
		for(Emote e : Emote.TWITCH_EMOTES){
			TextComponent emote = new TextComponent(e.getCODE());
			emote.setClickEvent(new ClickEvent(ClickEvent.Action.COPY_TO_CLIPBOARD, e.getCODE()));
			emote.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder()
					.append(e.getCODE())
					.append(" ")
					.append(e.getNAME())
					.append("\nClick to copy")
					.color(ChatColor.YELLOW)
					.create()));

			output[index++] = space;
			output[index++] = emote;
		}

		return output;
	}
}
