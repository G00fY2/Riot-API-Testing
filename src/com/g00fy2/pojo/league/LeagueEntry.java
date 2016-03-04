package com.g00fy2.pojo.league;

public class LeagueEntry {
	
	public String division; // The league division of the participant.
	public Boolean	isFreshBlood; // Specifies if the participant is fresh blood.
	public Boolean isHotStreak; // Specifies if the participant is on a hot streak.
	public Boolean	isInactive; // Specifies if the participant is inactive.
	public Boolean isVeteran; // Specifies if the participant is a veteran.
	public int leaguePoints; // The league points of the participant.
	public MiniSeries miniSeries; // Mini series data for the participant. Only present if the participant is currently in a mini series.
	public String playerOrTeamId; // The ID of the participant (i.e., summoner or team) represented by this entry.
	public String playerOrTeamName; // The name of the the participant (i.e., summoner or team) represented by this entry.
	public int wins; // The number of wins for the participant.

}
