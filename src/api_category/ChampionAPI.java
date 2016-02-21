package api_category;

import java.util.List;
import java.util.Map;

import pojo_champion.Champion;
import pojo_champion.Champions;

public class ChampionAPI extends RiotAPI {

	final static String apiVersion = "/v1.2";
	final static String apiCategory = "/champion";

	public ChampionAPI(final Map<String, String> apiValues) {
		super(apiValues, apiVersion, apiCategory);
	}

	// Retrieve all champions
	public List<Champion> getChampions() throws Exception {
		Class<Champions> classOf =  Champions.class;
		String urlPath = buildUrlPath();
		String urlQuery = getUrlQuery();
		
		return getObjectFromJsonUrl(urlPath, urlQuery, classOf).champions;
	}

	// Retrieve champion by ID
	public Champion getChampionByID(int championID) throws Exception {
		Class<Champion> classOf =  Champion.class;
		String urlPath = buildUrlPath() + "/" + championID;
		String urlQuery = getUrlQuery();
		
		return getObjectFromJsonUrl(urlPath, urlQuery, classOf);
	}

}
