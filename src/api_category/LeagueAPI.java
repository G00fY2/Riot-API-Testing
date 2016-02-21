package api_category;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import pojo_league.League;

import com.google.gson.reflect.TypeToken;

public class LeagueAPI extends RiotAPI {

	final static String apiVersion = "/v2.5";
	final static String apiCategory = "/league";

	public LeagueAPI(final Map<String, String> apiValues) {
		super(apiValues, apiVersion, apiCategory);
	}

	public Map<String, List<League>> getLeague(String summonerIDs) throws Exception {
		Type typeOf = new TypeToken<Map<String, List<League>>>(){}.getType();
		String urlPath = buildUrlPath() + "/by-summoner/" + summonerIDs;
		String urlQuery = getUrlQuery();
				
		return getObjectFromJsonUrl(urlPath, urlQuery, typeOf);
	}

	public Map<String, List<League>> getLeagueSingleEntry(String summonerIDs) throws Exception {
		Type typeOf = new TypeToken<Map<String, List<League>>>(){}.getType();
		String urlPath = buildUrlPath() + "/by-summoner/" + summonerIDs + "/entry";
		String urlQuery = getUrlQuery();
				
		return getObjectFromJsonUrl(urlPath, urlQuery, typeOf);
	}

	public Map<String, List<League>> getLeagueTeam(String teamIDs) throws Exception {
		Type typeOf = new TypeToken<Map<String, List<League>>>(){}.getType();
		String urlPath = buildUrlPath() + "/by-team/" + teamIDs;
		String urlQuery = getUrlQuery();
				
		return getObjectFromJsonUrl(urlPath, urlQuery, typeOf);
	}

	public Map<String, List<League>> getLeagueTeamSingleEntry(String teamIDs) throws Exception {
		Type typeOf = new TypeToken<Map<String, List<League>>>(){}.getType();
		String urlPath = buildUrlPath() + "/by-team/" + teamIDs + "/entry";
		String urlQuery = getUrlQuery();
				
		return getObjectFromJsonUrl(urlPath, urlQuery, typeOf);
	}

	public League getLeagueChallenger(String gameType) throws Exception {
		Class<League> classOf = League.class;
		String urlPath = buildUrlPath() + "/challenger";
		// possible game types: "RANKED_SOLO_5x5", "RANKED_TEAM_3x3", "RANKED_TEAM_5x5"
		String urlQuery = getUrlQuery() + "&type=" + gameType;
				
		return getObjectFromJsonUrl(urlPath, urlQuery, classOf);
	}

}
