package com.g00fy2.riotapi.api;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import com.g00fy2.riotapi.ApiUtils;
import com.g00fy2.riotapi.exception.ApiException;
import com.g00fy2.riotapi.pojo.league.League;

import com.google.gson.reflect.TypeToken;

public class LeagueAPI extends RiotAPI {

	final static String apiVersion = "/v2.5";
	final static String apiCategory = "/league";

	public LeagueAPI(final Map<String, String> apiValues) throws ApiException {
		super(apiValues, apiVersion, apiCategory);
	}

	public Map<String, List<League>> getLeague(String summonerIDs) throws ApiException {
		Type typeOf = new TypeToken<Map<String, List<League>>>(){}.getType();
		String urlPath = buildUrlPath() + "/by-summoner/" + ApiUtils.commaSeparatedIntegerList(summonerIDs, 10);
		String urlQuery = getUrlQuery();
				
		return getObjectFromJsonUrl(urlPath, urlQuery, typeOf);
	}

	public Map<String, List<League>> getLeagueSingleEntry(String summonerIDs) throws ApiException {
		Type typeOf = new TypeToken<Map<String, List<League>>>(){}.getType();
		String urlPath = buildUrlPath() + "/by-summoner/" + ApiUtils.commaSeparatedIntegerList(summonerIDs, 10) + "/entry";
		String urlQuery = getUrlQuery();
				
		return getObjectFromJsonUrl(urlPath, urlQuery, typeOf);
	}

	public Map<String, List<League>> getLeagueTeam(String teamIDs) throws ApiException {
		Type typeOf = new TypeToken<Map<String, List<League>>>(){}.getType();
		String urlPath = buildUrlPath() + "/by-team/" + ApiUtils.commaSeparatedIntegerList(teamIDs, 10);
		String urlQuery = getUrlQuery();
				
		return getObjectFromJsonUrl(urlPath, urlQuery, typeOf);
	}

	public Map<String, List<League>> getLeagueTeamSingleEntry(String teamIDs) throws ApiException {
		Type typeOf = new TypeToken<Map<String, List<League>>>(){}.getType();
		String urlPath = buildUrlPath() + "/by-team/" + ApiUtils.commaSeparatedIntegerList(teamIDs, 10) + "/entry";
		String urlQuery = getUrlQuery();
				
		return getObjectFromJsonUrl(urlPath, urlQuery, typeOf);
	}

	public League getLeagueChallenger(String gameType) throws ApiException {
		Class<League> classOf = League.class;
		String urlPath = buildUrlPath() + "/challenger";
		String urlQuery = getUrlQuery() + "&type=" + ApiUtils.validGameQueueType(gameType);
				
		return getObjectFromJsonUrl(urlPath, urlQuery, classOf);
	}
	
	public League getLeagueMaster(String gameType) throws ApiException {
		Class<League> classOf = League.class;
		String urlPath = buildUrlPath() + "/master";
		String urlQuery = getUrlQuery() + "&type=" + ApiUtils.validGameQueueType(gameType);
				
		return getObjectFromJsonUrl(urlPath, urlQuery, classOf);
	}

}
