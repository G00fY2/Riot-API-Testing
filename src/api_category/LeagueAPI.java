package api_category;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import pojo_league.League;

import com.google.gson.reflect.TypeToken;

public class LeagueAPI extends RiotAPI {

	final static String category = "league";

	public LeagueAPI(String protocol, String urlBase, String urlSuffix, String region, String apiVersion) {
		super(protocol, urlBase, urlSuffix, region, apiVersion, category);
	}

	public Map<String, List<League>> getLeague(String summonerIDs) throws Exception {
		Type typeOf = new TypeToken<Map<String, List<League>>>(){}.getType();
		String rawUrl = getUrlBase() + "/by-summoner/" + summonerIDs + getUrlSuffix();
		
		return getObjectFromJsonUrl(rawUrl, typeOf);
	}

	public Map<String, List<League>> getLeagueSingleEntry(String summonerIDs) throws Exception {
		Type typeOf = new TypeToken<Map<String, List<League>>>(){}.getType();
		String rawUrl = getUrlBase() + "/by-summoner/" + summonerIDs + "/entry" + getUrlSuffix();
		
		return getObjectFromJsonUrl(rawUrl, typeOf);
	}

	public Map<String, List<League>> getLeagueTeam(String teamIDs) throws Exception {
		Type typeOf = new TypeToken<Map<String, List<League>>>(){}.getType();
		String rawUrl = getUrlBase() + "/by-team/" + teamIDs + getUrlSuffix();
		
		return getObjectFromJsonUrl(rawUrl, typeOf);
	}

	public Map<String, List<League>> getLeagueTeamSingleEntry(String teamIDs) throws Exception {
		Type typeOf = new TypeToken<Map<String, List<League>>>(){}.getType();
		String rawUrl = getUrlBase() + "/by-team/" + teamIDs + "/entry" + getUrlSuffix();
		
		return getObjectFromJsonUrl(rawUrl, typeOf);
	}

	public League getLeagueChallenger(String gameType) throws Exception {
		Class<League> classOf = League.class;
		String rawUrl = getUrlBase() + "/challenger" + getUrlSuffix() + "&type=" + gameType;
		// possible game types: "RANKED_SOLO_5x5", "RANKED_TEAM_3x3", "RANKED_TEAM_5x5"
		return getObjectFromJsonUrl(rawUrl, classOf);
	}

}
