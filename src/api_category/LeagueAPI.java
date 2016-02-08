package api_category;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import pojo_league.League;

import com.google.gson.reflect.TypeToken;

public class LeagueAPI extends RiotAPI {

	final static String category = "league";

	public LeagueAPI(String protocol, String urlPath, String urlQuery, String region, String apiVersion) {
		super(protocol, urlPath, urlQuery, region, apiVersion, category);
	}

	public Map<String, List<League>> getLeague(String summonerIDs) throws Exception {
		Type typeOf = new TypeToken<Map<String, List<League>>>(){}.getType();
		String url = urlPath + "/by-summoner/" + summonerIDs + urlQuery;
		
		return getObjectFromJsonUrl(url, typeOf);
	}

	public Map<String, List<League>> getLeagueSingleEntry(String summonerIDs) throws Exception {
		Type typeOf = new TypeToken<Map<String, List<League>>>(){}.getType();
		String url = urlPath + "/by-summoner/" + summonerIDs + "/entry" + urlQuery;
		
		return getObjectFromJsonUrl(url, typeOf);
	}

	public Map<String, List<League>> getLeagueTeam(String teamIDs) throws Exception {
		Type typeOf = new TypeToken<Map<String, List<League>>>(){}.getType();
		String url = urlPath + "/by-team/" + teamIDs + urlQuery;
		
		return getObjectFromJsonUrl(url, typeOf);
	}

	public Map<String, List<League>> getLeagueTeamSingleEntry(String teamIDs) throws Exception {
		Type typeOf = new TypeToken<Map<String, List<League>>>(){}.getType();
		String url = urlPath + "/by-team/" + teamIDs + "/entry" + urlQuery;
		
		return getObjectFromJsonUrl(url, typeOf);
	}

	public League getLeagueChallenger(String gameType) throws Exception {
		Class<League> classOf = League.class;
		String url = urlPath + "/challenger" + urlQuery + "&type=" + gameType;
		// possible game types: "RANKED_SOLO_5x5", "RANKED_TEAM_3x3", "RANKED_TEAM_5x5"
		return getObjectFromJsonUrl(url, classOf);
	}

}
