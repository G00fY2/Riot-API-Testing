package com.g00fy2.riotapi.api;

import java.util.Map;
import java.util.Set;

import com.g00fy2.riotapi.exception.ApiException;
import com.g00fy2.riotapi.pojo.game.*;

public class GameAPI extends RiotAPI{

	final static String apiVersion = "/v1.3";
	final static String apiCategory = "/game/by-summoner/";

	public GameAPI(final Map<String, String> apiValues) throws ApiException {
		super(apiValues, apiVersion, apiCategory);
	}

	// return a object List with all champions
	public Set<Game> getGames(long summonerID) throws ApiException{			
		Class<Games> classOf = Games.class;
		String urlPath = buildUrlPath() + Long.toString(summonerID) + "/recent";
		String urlQuery = getUrlQuery();
		
		return getObjectFromJsonUrl(urlPath, urlQuery, classOf).games;
	}

}
