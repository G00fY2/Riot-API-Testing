package com.g00fy2.riotapi.api;

import java.util.List;
import java.util.Map;

import com.g00fy2.riotapi.exception.ApiException;
import com.g00fy2.riotapi.pojo.champion.*;

public class ChampionAPI extends RiotAPI {

	final static String apiVersion = "/v1.2";
	final static String apiCategory = "/champion";

	public ChampionAPI(final Map<String, String> apiValues) throws ApiException {
		super(apiValues, apiVersion, apiCategory);
	}

	// Retrieve all champions
	public List<Champion> getChampions() throws ApiException {
		Class<Champions> classOf =  Champions.class;
		String urlPath = buildUrlPath();
		String urlQuery = getUrlQuery();
		
		return getObjectFromJsonUrl(urlPath, urlQuery, classOf).champions;
	}

	// Retrieve champion by ID
	public Champion getChampionByID(int championID) throws ApiException {
		Class<Champion> classOf =  Champion.class;
		String urlPath = buildUrlPath() + "/" + championID;
		String urlQuery = getUrlQuery();
		
		return getObjectFromJsonUrl(urlPath, urlQuery, classOf);
	}

}
