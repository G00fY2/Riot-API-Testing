package api_category;

import java.util.Set;

import pojo_game.Game;
import pojo_game.Games;

public class GameAPI extends RiotAPI{

	final static String category = "game/by-summoner/{summonerId}/recent";

	public GameAPI(String protocol, String urlBase, String urlSuffix, String region, String apiVersion){
		super(protocol, urlBase, urlSuffix, region, apiVersion, category);
	}

	// return a object List with all champions
	public Set<Game> getGames(long summonerID) throws Exception{			
		Class<Games> classOf = Games.class;
		String url = urlBase.replace("{summonerId}", Long.toString(summonerID))+urlSuffix;
		
		return getObjectFromJsonUrl(url, classOf).games;
	}

}
