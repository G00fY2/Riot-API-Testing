package api_category;

import java.util.Map;

import pojo_current.CurrentGameInfo;

public class CurrentGameAPI extends RiotAPI {

	final static String apiVersion = ""; //v1.0
	final static String apiCategory = "/observer-mode/rest/consumer/getSpectatorGameInfo";
	
	public CurrentGameAPI(final Map<String, String> apiValues) {
		super(apiValues, apiVersion, apiCategory);
	}

	// Retrieve all champions
	public CurrentGameInfo getCurrentGameInfo(String platformId, long summonerId) throws Exception {
		Class<CurrentGameInfo> classOf =  CurrentGameInfo.class;
		String urlPath = apiCategory + "/" + platformId + "/" + Long.toString(summonerId);
		String urlQuery = getUrlQuery();
		
		return getObjectFromJsonUrl(urlPath, urlQuery, classOf);
	}

}
