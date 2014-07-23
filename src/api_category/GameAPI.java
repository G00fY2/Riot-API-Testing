package api_category;

import java.util.Set;

import pojo_game.Game;
import pojo_game.Games;

public class GameAPI extends RiotAPI{

	final static String category = "game/by-summoner/{summonerId}/recent";

	public GameAPI(String protocol, String baseURL, String urlSuffix, String region, String apiVersion){
		super(protocol, baseURL, urlSuffix, region, apiVersion, category);
	}

	// return a object List with all champions
	public Set<Game> getGames(long summonerID) throws Exception{			

		String url = baseURL.replace("{summonerId}", Long.toString(summonerID))+urlSuffix;
		Games games = gson.fromJson(getJsonFromUrl(url), Games.class);
		
		return games.games;
	}

}
