package com.g00fy2.riotapi.pojo.champion;

public class Champion {
	
	public Boolean active; // Indicates if the champion is active
	public Boolean botEnabled; // Bot enabled flag (for custom games).
	public Boolean botMmEnabled; // Bot Match Made enabled flag (for Co-op vs. AI games)
	public Boolean freeToPlay; // Indicates if the champion is free to play. Free to play champions are rotated periodically
	public long id; // Champion ID
	public Boolean rankedPlayEnabled; // Ranked play enabled flag

}
