package api_category;

import java.util.Map;

import pojo_summoner.MasteryPages;
import pojo_summoner.RunePages;
import pojo_summoner.SummonersBy;

import com.google.gson.reflect.TypeToken;

public class SummonerAPI extends RiotAPI {

	public SummonerAPI(String protocol, String baseURL, String urlSuffix, String region, String apiVersion) {
		super(protocol, baseURL, urlSuffix, region, apiVersion, "summoner");
	}

	// Get summoner objects mapped by standardized summoner name for a given list of summoner names
	public Map<String, SummonersBy> getSummonersByNames(String summonerNames) throws Exception {

		String url = baseURL + "/by-name/" + ((summonerNames.toLowerCase()).replaceAll("\\s+", "")) + urlSuffix;
		Map<String, SummonersBy> summoners = gson.fromJson(getJsonFromUrl(url), new TypeToken<Map<String, SummonersBy>>(){}.getType());
		closeJsonFromUrl();
		
		return summoners;
	}

	// Get summoner objects mapped by summoner ID for a given list of summoner IDs
	public Map<Integer, SummonersBy> getSummonersByIDs(String summonerIDs) throws Exception {

		String url = baseURL + "/" + summonerIDs + urlSuffix;
		Map<Integer, SummonersBy> summoners = gson.fromJson(getJsonFromUrl(url), new TypeToken<Map<Integer, SummonersBy>>(){}.getType());
		closeJsonFromUrl();
		
		return summoners;
	}

	// Get mastery pages mapped by summoner ID for a given list of summoner IDs
	public Map<String, MasteryPages> getSummonersMasteries(String summonerIDs) throws Exception {

		String url = baseURL + "/" + summonerIDs + "/masteries" + urlSuffix;
		Map<String, MasteryPages> summoners = gson.fromJson(getJsonFromUrl(url), new TypeToken<Map<String, MasteryPages>>(){}.getType());
		closeJsonFromUrl();
		
		return summoners;
	}

	// Get summoner names mapped by summoner ID for a given list of summoner IDs
	public Map<String, String> getSummonersNames(String summonerIDs) throws Exception {

		String url = baseURL + "/" + summonerIDs + urlSuffix;
		Map<String, String> summoners = gson.fromJson(getJsonFromUrl(url), new TypeToken<Map<String, String>>(){}.getType());
		closeJsonFromUrl();
		
		return summoners;
	}

	// Get rune pages mapped by summoner ID for a given list of summoner IDs
	public Map<String, RunePages> getSummonersRunes(String summonerIDs) throws Exception {

		String url = baseURL + "/" + summonerIDs + "/runes" + urlSuffix;
		Map<String, RunePages> summoners = gson.fromJson(getJsonFromUrl(url), new TypeToken<Map<String, RunePages>>(){}.getType());
		closeJsonFromUrl();
		
		return summoners;
	}

}
