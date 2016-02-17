package api_category;

import java.lang.reflect.Type;
import java.util.Map;

import pojo_summoner.MasteryPages;
import pojo_summoner.RunePages;
import pojo_summoner.SummonersBy;

import com.google.gson.reflect.TypeToken;

public class SummonerAPI extends RiotAPI {

	final static String category = "summoner";
	
	final static String apiVersion = "1.4";
	public SummonerAPI(final Map<String, String> apiValues) {
		super(apiValues, apiVersion, category);
	}

	// Get summoner objects mapped by standardized summoner name for a given list of summoner names
	public Map<String, SummonersBy> getSummonersByNames(String summonerNames) throws Exception {
		Type typeOf = new TypeToken<Map<String, SummonersBy>>(){}.getType();
		String rawUrl = getUrlBase() + "/by-name/" + ((summonerNames.toLowerCase()).replaceAll("\\s", "")) + getUrlSuffix();
		
		return getObjectFromJsonUrl(rawUrl, typeOf);
	}

	// Get summoner objects mapped by summoner ID for a given list of summoner IDs
	public Map<Integer, SummonersBy> getSummonersByIDs(String summonerIDs) throws Exception {
		Type typeOf = new TypeToken<Map<Integer, SummonersBy>>(){}.getType();
		String rawUrl = getUrlBase() + "/" + summonerIDs + getUrlSuffix();
		
		return getObjectFromJsonUrl(rawUrl, typeOf);
	}

	// Get mastery pages mapped by summoner ID for a given list of summoner IDs
	public Map<String, MasteryPages> getSummonersMasteries(String summonerIDs) throws Exception {
		Type typeOf = new TypeToken<Map<String, MasteryPages>>(){}.getType();
		String rawUrl = getUrlBase() + "/" + summonerIDs + "/masteries" + getUrlSuffix();

		return getObjectFromJsonUrl(rawUrl, typeOf);
	}

	// Get summoner names mapped by summoner ID for a given list of summoner IDs
	public Map<String, String> getSummonersNames(String summonerIDs) throws Exception {
		Type typeOf = new TypeToken<Map<String, String>>(){}.getType();
		String rawUrl = getUrlBase() + "/" + summonerIDs + getUrlSuffix();
		
		return getObjectFromJsonUrl(rawUrl, typeOf);
	}

	// Get rune pages mapped by summoner ID for a given list of summoner IDs
	public Map<String, RunePages> getSummonersRunes(String summonerIDs) throws Exception {
		Type typeOf = new TypeToken<Map<String, RunePages>>(){}.getType();
		String rawUrl = getUrlBase() + "/" + summonerIDs + "/runes" + getUrlSuffix();
		
		return getObjectFromJsonUrl(rawUrl, typeOf);
	}

}
