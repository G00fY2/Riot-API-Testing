package api_category;

import java.util.Map;

import pojo_stats.ChampionsStats;
import pojo_stats.PlayerStatSummaries;

public class StatsAPI extends RiotAPI{

	final static String apiVersion = "1.3";
	final static String category = "stats/by-summoner/{summonerId}";

	public StatsAPI(final Map<String, String> apiValues) {
		super(apiValues, apiVersion, category);
	}

	public ChampionsStats getRanked(long summonerID, int season) throws Exception{			
		Class<ChampionsStats> classOf = ChampionsStats.class;
		String rawUrl = getUrlBase().replace("{summonerId}", Long.toString(summonerID))+"/ranked"+getUrlSuffix().replace("?", "?season=SEASON"+season+"&");
		
		return getObjectFromJsonUrl(rawUrl, classOf);
	}

	public PlayerStatSummaries getSummary(long summonerID, int season) throws Exception{			
		Class<PlayerStatSummaries> classOf = PlayerStatSummaries.class;
		String rawUrl = getUrlBase().replace("{summonerId}", Long.toString(summonerID))+"/summary"+getUrlSuffix().replace("?", "?season=SEASON"+season+"&");
		
		return getObjectFromJsonUrl(rawUrl, classOf);
	}

}
