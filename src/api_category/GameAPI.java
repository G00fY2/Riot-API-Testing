package api_category;

import java.util.Map;
import java.util.Set;

import pojo_game.Game;
import pojo_game.Games;

public class GameAPI extends RiotAPI{

	final static String apiVersion = "/v1.3";
	final static String apiCategory = "/game/by-summoner/";

	public GameAPI(final Map<String, String> apiValues) {
		super(apiValues, apiVersion, apiCategory);
	}

	// return a object List with all champions
	public Set<Game> getGames(long summonerID) throws Exception{			
		Class<Games> classOf = Games.class;
		String urlPath = buildUrlPath() + Long.toString(summonerID) + "/recent";
		String urlQuery = getUrlQuery();
		
		return getObjectFromJsonUrl(urlPath, urlQuery, classOf).games;
	}

}
