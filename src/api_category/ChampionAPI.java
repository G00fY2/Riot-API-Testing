package api_category;

import java.util.List;

import pojo_champion.Champion;
import pojo_champion.Champions;

public class ChampionAPI extends RiotAPI {

	final static String category = "champion";

	public ChampionAPI(String protocol, String urlPath, String urlQuery, String region, String apiVersion) {
		super(protocol, urlPath, urlQuery, region, apiVersion, category);
	}

	// Retrieve all champions
	public List<Champion> getChampions() throws Exception {
		Class<Champions> classOf =  Champions.class;
		String url = urlPath + urlQuery;

		return getObjectFromJsonUrl(url, classOf).champions;
	}

	// Retrieve champion by ID
	public Champion getChampionByID(int championID) throws Exception {
		Class<Champion> classOf =  Champion.class;
		String url = urlPath + "/" + championID + urlQuery;

		return getObjectFromJsonUrl(url, classOf);
	}

}
