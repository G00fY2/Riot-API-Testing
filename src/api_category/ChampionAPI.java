package api_category;

import java.util.List;

import pojo_champion.Champion;
import pojo_champion.Champions;

public class ChampionAPI extends RiotAPI {

	final static String category = "champion";

	public ChampionAPI(String protocol, String baseURL, String urlSuffix, String region, String apiVersion) {
		super(protocol, baseURL, urlSuffix, region, apiVersion, category);
	}

	// Retrieve all champions
	public List<Champion> getChampions() throws Exception {
		Class<Champions> classOf =  Champions.class;
		String url = baseURL + urlSuffix;

		return getObjectFromJsonUrl(url, classOf).champions;
	}

	// Retrieve champion by ID
	public Champion getChampionByID(int championID) throws Exception {
		Class<Champion> classOf =  Champion.class;
		String url = baseURL + "/" + championID + urlSuffix;

		return getObjectFromJsonUrl(url, classOf);
	}

}
