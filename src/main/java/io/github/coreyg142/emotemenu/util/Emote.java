package io.github.coreyg142.emotemenu.util;

import io.github.coreyg142.emotemenu.EmoteMenu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Emote implements Comparable<Emote>{


	@Override
	public int compareTo(Emote o) {
		return this.NAME.compareTo(o.NAME);
	}

	public enum Source {
		TWITCH,
		BTTV,
		OTHER
	}

    private final String NAME;
	private final String CODE;
	private final Source SOURCE;
	public static ArrayList<Emote> TWITCH_EMOTES;
	public static ArrayList<Emote> BTTV_EMOTES;
	public static ArrayList<Emote> OTHER_EMOTES;

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

	public static int getNumEmotes(){
		return TWITCH_EMOTES.size() + BTTV_EMOTES.size() + OTHER_EMOTES.size();
	}

	public static int calcComponentSize(){
		return ((TWITCH_EMOTES.size() * 2) + 2) + ((BTTV_EMOTES.size() * 2) + 1) + ((OTHER_EMOTES.size() * 2) + 1);
	}

	public static void populateEmotes(List<String> emotesList, Source source){
		ArrayList<Emote> emoteList = new ArrayList<>();
		for(String s : emotesList){
			s = s.replaceAll("\\s", "");
			String[] split = s.split(",");
			try{
				if(split.length != 3) throw new IndexOutOfBoundsException();
				emoteList.add(new Emote(split[0], split[1], Source.valueOf(split[2])));
			}catch (Exception e){
				EmoteMenu.logger.warning("Failed reading an emote from config file, are they in the right format?");
				//Ignoring improper format
			}
		}
		Collections.sort(emoteList);
		switch(source){
			case BTTV:
				BTTV_EMOTES = emoteList;
				break;
			case TWITCH:
				TWITCH_EMOTES = emoteList;
				break;
			case OTHER:
				OTHER_EMOTES = emoteList;
				break;
		}

	}

}
