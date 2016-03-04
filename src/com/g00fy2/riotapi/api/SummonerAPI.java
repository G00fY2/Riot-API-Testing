package com.g00fy2.riotapi.api;

import java.lang.reflect.Type;
import java.util.Map;

import com.g00fy2.riotapi.exception.ApiException;
import com.g00fy2.riotapi.pojo.summoner.*;

import com.google.gson.reflect.TypeToken;

public class SummonerAPI extends RiotAPI {

	final static String apiVersion = "/v1.4";
	final static String apiCategory = "/summoner";
	
	public SummonerAPI(final Map<String, String> apiValues) {
		super(apiValues, apiVersion, apiCategory);
	}

	// Get summoner objects mapped by standardized summoner name for a given list of summoner names
	public Map<String, SummonersBy> getSummonersByNames(String summonerNames) throws ApiException {
		Type typeOf = new TypeToken<Map<String, SummonersBy>>(){}.getType();
		String urlPath = buildUrlPath() + "/by-name/" + ((summonerNames.toLowerCase()).replaceAll("\\s", ""));
		String urlQuery = getUrlQuery();
		
		return getObjectFromJsonUrl(urlPath, urlQuery, typeOf);
	}

	// Get summoner objects mapped by summoner ID for a given list of summoner IDs
	public Map<Integer, SummonersBy> getSummonersByIDs(String summonerIDs) throws ApiException {
		Type typeOf = new TypeToken<Map<Integer, SummonersBy>>(){}.getType();
		String urlPath = buildUrlPath() + "/" + summonerIDs;
		String urlQuery = getUrlQuery();
		
		return getObjectFromJsonUrl(urlPath, urlQuery, typeOf);
	}

	// Get mastery pages mapped by summoner ID for a given list of summoner IDs
	public Map<String, MasteryPages> getSummonersMasteries(String summonerIDs) throws ApiException {
		Type typeOf = new TypeToken<Map<String, MasteryPages>>(){}.getType();
		String urlPath = buildUrlPath() + "/" + summonerIDs + "/masteries";
		String urlQuery = getUrlQuery();
		
		return getObjectFromJsonUrl(urlPath, urlQuery, typeOf);
	}

	// Get summoner names mapped by summoner ID for a given list of summoner IDs
	public Map<String, String> getSummonersNames(String summonerIDs) throws ApiException {
		Type typeOf = new TypeToken<Map<String, String>>(){}.getType();
		String urlPath = buildUrlPath() + "/" + summonerIDs;
		String urlQuery = getUrlQuery();
		
		return getObjectFromJsonUrl(urlPath, urlQuery, typeOf);
	}

	// Get rune pages mapped by summoner ID for a given list of summoner IDs
	public Map<String, RunePages> getSummonersRunes(String summonerIDs) throws ApiException {
		Type typeOf = new TypeToken<Map<String, RunePages>>(){}.getType();
		String urlPath = buildUrlPath() + "/" + summonerIDs + "/runes";
		String urlQuery = getUrlQuery();
		
		return getObjectFromJsonUrl(urlPath, urlQuery, typeOf);
	}

}
