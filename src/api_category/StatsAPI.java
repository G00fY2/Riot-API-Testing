package api_category;

import pojo_stats.ChampionsStats;
import pojo_stats.PlayerStatSummaries;

public class StatsAPI extends RiotAPI{

	final static String category = "stats/by-summoner/{summonerId}";

	public StatsAPI(String protocol, String baseURL, String urlSuffix, String region, String apiVersion){
		super(protocol, baseURL, urlSuffix, region, apiVersion, category);
	}

	public ChampionsStats getRanked(long summonerID, int season) throws Exception{			

		String url = baseURL.replace("{summonerId}", Long.toString(summonerID))+"/ranked"+urlSuffix.replace("?", "?season=SEASON"+season+"&");
		ChampionsStats championStats = gson.fromJson(getJsonFromUrl(url), ChampionsStats.class);
		
		return championStats;
	}

	public PlayerStatSummaries getSummary(long summonerID, int season) throws Exception{			

		String url = baseURL.replace("{summonerId}", Long.toString(summonerID))+"/summary"+urlSuffix.replace("?", "?season=SEASON"+season+"&");
		PlayerStatSummaries playerStats = gson.fromJson(getJsonFromUrl(url), PlayerStatSummaries.class);
		
		return playerStats;
	}

}
