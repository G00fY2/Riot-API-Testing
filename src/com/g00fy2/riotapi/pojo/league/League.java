package com.g00fy2.riotapi.pojo.league;

import java.util.List;

public class League {
	
	public List<LeagueEntry> entries;
	public String name; // This name is an internal place-holder name only. Display and localization of names in the game client are handled client-side.
	public String participantId; // Specifies the relevant participant that is a member of this league (i.e., a requested summoner ID, a requested team ID, or the ID of a team to which one of the requested summoners belongs). Only present when full league is requested so that participant's entry can be identified. Not present when individual entry is requested.
	public String queue; // The league's queue type. (legal values: RANKED_SOLO_5x5, RANKED_TEAM_3x3, RANKED_TEAM_5x5)
	public String tier; // The league's tier. (legal values: CHALLENGER, DIAMOND, PLATINUM, GOLD, SILVER, BRONZE)

}
