package api_category;

import java.util.List;
import java.util.Map;

import pojo_league.League;

import com.google.gson.reflect.TypeToken;

public class LeagueAPI extends RiotAPI {

	final static String category = "league";

	public LeagueAPI(String protocol, String baseURL, String urlSuffix, String region, String apiVersion) {
		super(protocol, baseURL, urlSuffix, region, apiVersion, category);
	}

	public Map<String, List<League>> getLeague(String summonerIDs) throws Exception {

		String url = baseURL + "/by-summoner/" + summonerIDs + urlSuffix;
		Map<String, List<League>> league = gson.fromJson(getJsonFromUrl(url), new TypeToken<Map<String, List<League>>>(){}.getType());

		return league;
	}

	public Map<String, List<League>> getLeagueSingleEntry(String summonerIDs) throws Exception {

		String url = baseURL + "/by-summoner/" + summonerIDs + "/entry" + urlSuffix;
		Map<String, List<League>> league = gson.fromJson(getJsonFromUrl(url), new TypeToken<Map<String, List<League>>>(){}.getType());

		return league;
	}

	public Map<String, List<League>> getLeagueTeam(String teamIDs) throws Exception {

		String url = baseURL + "/by-team/" + teamIDs + urlSuffix;
		Map<String, List<League>> league = gson.fromJson(getJsonFromUrl(url), new TypeToken<Map<String, List<League>>>(){}.getType());

		return league;
	}

	public Map<String, List<League>> getLeagueTeamSingleEntry(String teamIDs) throws Exception {

		String url = baseURL + "/by-team/" + teamIDs + "/entry" + urlSuffix;
		Map<String, List<League>> league = gson.fromJson(getJsonFromUrl(url), new TypeToken<Map<String, List<League>>>(){}.getType());

		return league;
	}

	public League getLeagueChallenger(String gameType) throws Exception {

		// possible game types: "RANKED_SOLO_5x5", "RANKED_TEAM_3x3", "RANKED_TEAM_5x5"
		String url = baseURL + "/challenger" + urlSuffix;
		url = url.replace("?api", "?type=" + gameType + "&api");
		League league = gson.fromJson(getJsonFromUrl(url), League.class);

		return league;
	}

}
