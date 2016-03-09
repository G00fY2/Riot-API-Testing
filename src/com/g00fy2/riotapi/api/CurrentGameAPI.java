package com.g00fy2.riotapi.api;

import java.util.Map;

import com.g00fy2.riotapi.ApiUtils;
import com.g00fy2.riotapi.exception.ApiException;
import com.g00fy2.riotapi.pojo.current.*;

public class CurrentGameAPI extends RiotAPI {

	final static String apiVersion = ""; //v1.0
	final static String apiCategory = "/observer-mode/rest/consumer/getSpectatorGameInfo";
	
	public CurrentGameAPI(final Map<String, String> apiValues) throws ApiException {
		super(apiValues, apiVersion, apiCategory);
	}

	// Retrieve all champions
	public CurrentGameInfo getCurrentGameInfo(String platformId, long summonerId) throws ApiException {
		Class<CurrentGameInfo> classOf =  CurrentGameInfo.class;
		String urlPath = apiCategory + "/" + ApiUtils.validPlatformID(platformId) + "/" + Long.toString(summonerId);
		String urlQuery = getUrlQuery();
		
		return getObjectFromJsonUrl(urlPath, urlQuery, classOf);
	}

}
