package api_category;

import pojo_stats.ChampionsStats;
import pojo_stats.PlayerStatSummaries;

public class StatsAPI extends RiotAPI{

	final static String category = "stats/by-summoner/{summonerId}";

	public StatsAPI(String protocol, String urlPath, String urlQuery, String region, String apiVersion){
		super(protocol,urlPath, urlQuery, region, apiVersion, category);
	}

	public ChampionsStats getRanked(long summonerID, int season) throws Exception{			
		Class<ChampionsStats> classOf = ChampionsStats.class;
		String url = urlPath.replace("{summonerId}", Long.toString(summonerID))+"/ranked"+urlQuery.replace("?", "?season=SEASON"+season+"&");
		
		return getObjectFromJsonUrl(url, classOf);
	}

	public PlayerStatSummaries getSummary(long summonerID, int season) throws Exception{			
		Class<PlayerStatSummaries> classOf = PlayerStatSummaries.class;
		String url = urlPath.replace("{summonerId}", Long.toString(summonerID))+"/summary"+urlQuery.replace("?", "?season=SEASON"+season+"&");
		
		return getObjectFromJsonUrl(url, classOf);
	}

}
