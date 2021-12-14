package io.github.coreyg142.emotemenu.util;

import io.github.coreyg142.emotemenu.EmoteMenu;

import java.util.ArrayList;
import java.util.List;

public class Emote {

	public enum Source {
		TWITCH,
		DISCORD
	}

    private final String NAME;
	private final String CODE;
	private final Source SOURCE;
	public static ArrayList<Emote> TWITCH_EMOTES;

	public Emote(String name, String code, Source source){
		this.NAME = name;
		this.CODE = code;
		this.SOURCE = source;
	}

	public String getNAME() {
		return NAME;
	}

	public String getCODE() {
		return CODE;
	}

	public Source getSOURCE() {
		return SOURCE;
	}

	public static int calcComponentSize(){
		return ((TWITCH_EMOTES.size() * 2) + 2);
	}

	public static boolean populateTwitchEmotes(List<String> emotesList){
		TWITCH_EMOTES = new ArrayList<>();
		for(String s : emotesList){
			s = s.replaceAll("\\s", "");
			String[] split = s.split(",");
			try{
				TWITCH_EMOTES.add(new Emote(split[0], split[1], Source.valueOf(split[2])));
			}catch (Exception e){
				EmoteMenu.logger.severe("Failed reading emotes from config file, are they in the right format?");
				return false;
			}
		}
//		TWITCH_EMOTES.add(new Emote("rudeBonk", "\ue000", Source.TWITCH));
//		TWITCH_EMOTES.add(new Emote("rudeCrime", "\ue001", Source.TWITCH));
//		TWITCH_EMOTES.add(new Emote("rudeDude", "\ue002", Source.TWITCH));
//		TWITCH_EMOTES.add(new Emote("rudeElle", "\ue003", Source.TWITCH));
//		TWITCH_EMOTES.add(new Emote("rudeEvil", "\ue004", Source.TWITCH));
//		TWITCH_EMOTES.add(new Emote("rudeRip", "\ue005", Source.TWITCH));
//
//		TWITCH_EMOTES.add(new Emote("rudeHi", "\ue006", Source.TWITCH));
//		TWITCH_EMOTES.add(new Emote("rudeHmm", "\ue007", Source.TWITCH));
//		TWITCH_EMOTES.add(new Emote("rudeHuh", "\ue008", Source.TWITCH));
//		TWITCH_EMOTES.add(new Emote("rudeHype", "\ue009", Source.TWITCH));
//		TWITCH_EMOTES.add(new Emote("rudeIdea", "\ue00A", Source.TWITCH));
//		TWITCH_EMOTES.add(new Emote("rudeShook", "\ue00B", Source.TWITCH));
//
//		TWITCH_EMOTES.add(new Emote("rudeJerry", "\ue00C", Source.TWITCH));
//		TWITCH_EMOTES.add(new Emote("rudeLove", "\ue00D", Source.TWITCH));
//		TWITCH_EMOTES.add(new Emote("rudeLUL", "\ue00E", Source.TWITCH));
//		TWITCH_EMOTES.add(new Emote("rudeNom", "\ue00F", Source.TWITCH));
//		TWITCH_EMOTES.add(new Emote("rudeOhno", "\ue010", Source.TWITCH));
//		TWITCH_EMOTES.add(new Emote("rudeThump", "\ue011", Source.TWITCH));
//
//		TWITCH_EMOTES.add(new Emote("rudeOmega", "\ue012", Source.TWITCH));
//		TWITCH_EMOTES.add(new Emote("rudeOmg", "\ue013", Source.TWITCH));
//		TWITCH_EMOTES.add(new Emote("rudeOri", "\ue014", Source.TWITCH));
//		TWITCH_EMOTES.add(new Emote("rudeOrier", "\ue015", Source.TWITCH));
//		TWITCH_EMOTES.add(new Emote("rudeOriest", "\ue016", Source.TWITCH));
//		TWITCH_EMOTES.add(new Emote("rudeWoah", "\ue017", Source.TWITCH));
//
//		TWITCH_EMOTES.add(new Emote("rudeOrimega", "\ue018", Source.TWITCH));
//		TWITCH_EMOTES.add(new Emote("rudePeek", "\ue019", Source.TWITCH));
//		TWITCH_EMOTES.add(new Emote("rudePls", "\ue01A", Source.TWITCH));
//		TWITCH_EMOTES.add(new Emote("rudePolice", "\ue01B", Source.TWITCH));
//		TWITCH_EMOTES.add(new Emote("rudeQueen", "\ue01C", Source.TWITCH));
//		TWITCH_EMOTES.add(new Emote("rudeZzz", "\ue01D", Source.TWITCH));

		return true;
	}
}
