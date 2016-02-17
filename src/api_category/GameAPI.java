package api_category;

import java.util.Map;
import java.util.Set;

import pojo_game.Game;
import pojo_game.Games;

public class GameAPI extends RiotAPI{

	final static String apiVersion = "1.3";
	final static String category = "game/by-summoner/{summonerId}/recent";

	public GameAPI(final Map<String, String> apiValues) {
		super(apiValues, apiVersion, category);
	}

	// return a object List with all champions
	public Set<Game> getGames(long summonerID) throws Exception{			
		Class<Games> classOf = Games.class;
		String rawUrl = getUrlBase().replace("{summonerId}", Long.toString(summonerID))+getUrlSuffix();
		
		return getObjectFromJsonUrl(rawUrl, classOf).games;
	}

}
