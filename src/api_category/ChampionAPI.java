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

		String url = baseURL + urlSuffix;
		Champions champions = gson.fromJson(getJsonFromUrl(url), Champions.class);
		closeJsonFromUrl();
		
		return champions.champions;
	}

	// Retrieve champion by ID
	public Champion getChampionByID(int championID) throws Exception {

		String url = baseURL + "/" + championID + urlSuffix;
		Champion champion = gson.fromJson(getJsonFromUrl(url), Champion.class);
		closeJsonFromUrl();
		
		return champion;
	}

}
