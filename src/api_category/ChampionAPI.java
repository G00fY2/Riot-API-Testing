package api_category;

import java.util.List;

import pojo_champion.Champion;
import pojo_champion.Champions;

public class ChampionAPI extends RiotAPI {

	final static String category = "champion";

	public ChampionAPI(String protocol, String urlBase, String urlSuffix, String region, String apiVersion) {
		super(protocol, urlBase, urlSuffix, region, apiVersion, category);
	}

	// Retrieve all champions
	public List<Champion> getChampions() throws Exception {
		Class<Champions> classOf =  Champions.class;
		String rawUrl = getUrlBase() + getUrlSuffix();

		return getObjectFromJsonUrl(rawUrl, classOf).champions;
	}

	// Retrieve champion by ID
	public Champion getChampionByID(int championID) throws Exception {
		Class<Champion> classOf =  Champion.class;
		String rawUrl = getUrlBase() + "/" + championID + getUrlSuffix();

		return getObjectFromJsonUrl(rawUrl, classOf);
	}

}
