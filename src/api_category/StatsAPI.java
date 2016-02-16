package api_category;

import pojo_stats.ChampionsStats;
import pojo_stats.PlayerStatSummaries;

public class StatsAPI extends RiotAPI{

	final static String category = "stats/by-summoner/{summonerId}";

	public StatsAPI(String protocol, String urlBase, String urlSuffix, String region, String apiVersion){
		super(protocol,urlBase, urlSuffix, region, apiVersion, category);
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
