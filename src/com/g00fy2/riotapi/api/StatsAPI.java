package com.g00fy2.riotapi.api;

import java.util.Map;

import com.g00fy2.riotapi.ApiUtils;
import com.g00fy2.riotapi.exception.ApiException;
import com.g00fy2.riotapi.pojo.stats.*;

public class StatsAPI extends RiotAPI{

	final static String apiVersion = "/v1.3";
	final static String apiCategory = "/stats/by-summoner/";

	public StatsAPI(final Map<String, String> apiValues) throws ApiException {
		super(apiValues, apiVersion, apiCategory);
	}

	public ChampionsStats getRanked(long summonerID, String season) throws ApiException{			
		Class<ChampionsStats> classOf = ChampionsStats.class;
		String urlPath = buildUrlPath() + Long.toString(summonerID) +"/ranked";
		String urlQuery = "season=" + ApiUtils.validSeason(season) + "&" + getUrlQuery();
		
		return getObjectFromJsonUrl(urlPath, urlQuery, classOf);
	}

	public PlayerStatSummaries getSummary(long summonerID, String season) throws ApiException{			
		Class<PlayerStatSummaries> classOf = PlayerStatSummaries.class;
		String urlPath = buildUrlPath() + Long.toString(summonerID) + "/summary";
		String urlQuery = "season=" + ApiUtils.validSeason(season) + "&" + getUrlQuery();
		
		return getObjectFromJsonUrl(urlPath, urlQuery, classOf);
	}
	
	public PlayerStatSummaries getSummary(long summonerID) throws ApiException{			
		Class<PlayerStatSummaries> classOf = PlayerStatSummaries.class;
		String urlPath = buildUrlPath() + Long.toString(summonerID) + "/summary";
		String urlQuery = getUrlQuery();
		
		return getObjectFromJsonUrl(urlPath, urlQuery, classOf);
	}

}
