package com.g00fy2.riotapi.pojo.current;

import java.util.List;

public class CurrentGameInfo {
	
	public List<BannedChampion> bannedChampions; // Banned champion information
	public long gameId;	// The ID of the game
	public long gameLength;	// The amount of time in seconds that has passed since the game started
	public String gameMode;	// The game mode (Legal values: CLASSIC, ODIN, ARAM, TUTORIAL, ONEFORALL, ASCENSION, FIRSTBLOOD, KINGPORO)
	public long gameQueueConfigId;	// The queue type (queue types are documented on the Game Constants page)
	public long gameStartTime;	// The game start time represented in epoch milliseconds
	public String gameType;	// The game type (Legal values: CUSTOM_GAME, MATCHED_GAME, TUTORIAL_GAME)
	public long mapId;	// The ID of the map
	public Observer observers;	// The observer information
	public List<CurrentGameParticipant> participants;	// The participant information
	public String platformId;	// The ID of the platform on which the game is being played
}
