package api_category;

import java.util.Set;

import pojo_game.Game;
import pojo_game.Games;

public class GameAPI extends RiotAPI{

	final static String category = "game/by-summoner/{summonerId}/recent";

	public GameAPI(String protocol, String urlPath, String urlQuery, String region, String apiVersion){
		super(protocol, urlPath, urlQuery, region, apiVersion, category);
	}

	// return a object List with all champions
	public Set<Game> getGames(long summonerID) throws Exception{			
		Class<Games> classOf = Games.class;
		String url = urlPath.replace("{summonerId}", Long.toString(summonerID))+urlQuery;
		
		return getObjectFromJsonUrl(url, classOf).games;
	}

}
