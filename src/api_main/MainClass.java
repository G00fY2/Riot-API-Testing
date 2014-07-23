package api_main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.Map;
import java.util.Set;

import pojo_champion.*;
import pojo_game.*;
import pojo_league.League;
import pojo_stats.*;
import pojo_summoner.*;
import api_category.*;


public class MainClass {

	public static void main(String[] args) throws Exception {

		String apiFile = "F:\\workspace\\apikey.txt";
		String apiKey = "";

		// read API Key from first line of local textfile (temporary solution)
		BufferedReader br = new BufferedReader(new FileReader(apiFile));
		apiKey = br.readLine();
		br.close();

		String protocol = "https://";
		String baseURL = "{region}.api.pvp.net/api/lol/{region}/{apiVersion}/{category}";
		String urlSuffix = "?api_key="+apiKey;
		String region = "euw";
		String apiVersionChampion = "1.2";
		String apiVersionGame = "1.3";
		String apiVersionLeague = "2.4";
		//String apiVersionStaticData = "1.2";
		String apiVersionStats = "1.3";
		String apiVersionSummoner = "1.4";
		//String apiVersionTeam = "2.3";

		//TODO: For Android use JSONObject?
		long startTime = System.currentTimeMillis();
		/* 
		 * test summoner API
		 * */
		SummonerAPI summAPI = new SummonerAPI(protocol, baseURL, urlSuffix, region, apiVersionSummoner);

		Map<String, SummonersBy> summByName = summAPI.getSummonersByNames("g00fy2");
		System.out.println("- - - - -SummonerAPI-Summoner- - - -");
		System.out.println(summByName.get("g00fy2").id);
		// MasteryPages
		Map<String, MasteryPages> summMasteries = summAPI.getSummonersMasteries("22573844");
		System.out.println("- - - - -SummonerAPI-Masteries- - - -");
		System.out.println(summMasteries.get("22573844").pages.iterator().next().name);
		Map<String, RunePages> summRunes = summAPI.getSummonersRunes("22573844");
		// iterate through RunePages
		for(RunePage page : summRunes.get("22573844").pages){
			System.out.println("- - - - -SummonerAPI-Runes- - - -");
			System.out.println(page.slots.iterator().next().runeId);
			break;
		}	
		/*
		 * test champion API
		 */
		ChampionAPI champAPI = new ChampionAPI(protocol, baseURL, urlSuffix, region, apiVersionChampion);	
		List<Champion> champions = champAPI.getChampions();
		System.out.println("- - - - -ChampionAPI- - - - -");
		System.out.println(champions.get(0).id);
		Champion champion = champAPI.getChampionByID(2);
		System.out.println(champion.freeToPlay.toString());
		/*
		 * test game API
		 */
		GameAPI gameAPI = new GameAPI(protocol, baseURL, urlSuffix, region, apiVersionGame);
		Set<Game> games = gameAPI.getGames(22573844);
		System.out.println("- - - - -GameAPI- - - - -");
		System.out.println(games.iterator().next().stats.level);
		/*
		 * test stats API
		 */
		StatsAPI statsAPI = new StatsAPI(protocol, baseURL, urlSuffix, region, apiVersionStats);
		ChampionsStats championStats = statsAPI.getRanked(22573844, 4);
		System.out.println("- - - - -StatsAPI-Ranked- - - -");
		System.out.println(championStats.champions.get(0).stats.totalDamageDealt);
		PlayerStatSummaries playerStats = statsAPI.getSummary(22573844, 4);
		System.out.println("- - - - -StatsAPI-Summary- - - -");
		System.out.println(playerStats.playerStatSummaries.get(0).playerStatSummaryType);
		/* 
		 * test league API
		 * */
		LeagueAPI leagueAPI = new LeagueAPI(protocol, baseURL, urlSuffix, region, apiVersionLeague);

		Map<String, List<League>> league = leagueAPI.getLeague("22573844");
		System.out.println("- - - - -LaegueAPI-- - - -");
		System.out.println(league.get("22573844").get(0).entries.get(21).playerOrTeamName);
		Map<String, List<League>> leagueEntry = leagueAPI.getLeagueSingleEntry("22573844");
		System.out.println("- - - - -LaegueAPI-SingleEntry-- - - -");
		System.out.println(leagueEntry.get("22573844").get(0).entries.get(0).leaguePoints);
		
		long stopTime = System.currentTimeMillis();
	    System.out.println("EXECUTION TIME: " + (stopTime - startTime) + " msec");
		
		Thread.sleep(10000); // temporary workaround to avoid API rate limit

		League leagueChallegner = leagueAPI.getLeagueChallenger("RANKED_SOLO_5x5");
		System.out.println("- - - - -LaegueAPI-SingleEntry-- - - -");
		System.out.println(leagueChallegner.name);
		

	}

}
