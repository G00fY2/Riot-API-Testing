package pojo_game;

import java.util.List;

public class Game {
	public int championId; //Champion ID associated with game
	public long createDate; //Date that end game data was recorded, specified as epoch milliseconds
	public List<Player>	fellowPlayers; //Other players associated with the game
	public long gameId; //Game ID
	public String gameMode; //Game mode (legal values: CLASSIC, ODIN, ARAM, TUTORIAL, ONEFORALL, FIRSTBLOOD)
	public String gameType; //Game type (legal values: CUSTOM_GAME, MATCHED_GAME, TUTORIAL_GAME)
	public Boolean invalid; //Invalid flag
	public int level; //Level
	public int mapId; //Map ID
	public int spell1; //ID of first summoner spell
	public int spell2; //ID of second summoner spell
	public RawStats stats; //Statistics associated with the game for this summoner
	public String subType; //Game sub-type (legal values: NONE, NORMAL, BOT, RANKED_SOLO_5x5, RANKED_PREMADE_3x3, RANKED_PREMADE_5x5, ODIN_UNRANKED, RANKED_TEAM_3x3, RANKED_TEAM_5x5, NORMAL_3x3, BOT_3x3, ARAM_UNRANKED_5x5, ONEFORALL_5x5, FIRSTBLOOD_1x1, FIRSTBLOOD_2x2, SR_6x6)
	public int teamId; //Team ID associated with game. Team ID 100 is blue team. Team ID 200 is purple team
}
