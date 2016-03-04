package com.g00fy2.riotapi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.g00fy2.riotapi.pojo.champion.*;
import com.g00fy2.riotapi.pojo.current.*;
import com.g00fy2.riotapi.pojo.game.*;
import com.g00fy2.riotapi.pojo.league.League;
import com.g00fy2.riotapi.pojo.stats.*;
import com.g00fy2.riotapi.pojo.summoner.*;
import com.g00fy2.riotapi.api.*;


public class MainClass {

	public static void main(String[] args) throws Exception {

		String apiFile = "D:\\workspace\\apikey.txt";
		String apiKey = "";

		// read API Key from first line of local textfile (temporary solution)
		BufferedReader br = new BufferedReader(new FileReader(apiFile));
		apiKey = br.readLine();
		br.close();
		
		Map<String, String> apiValues = new HashMap<String, String>();	
		apiValues.put("urlHost", ".api.pvp.net");
		apiValues.put("urlPath", "/api/lol/");
		apiValues.put("apiKey", apiKey);
		apiValues.put("region", "euw");

		//TODO: For Android use JSONObject?
		long startTime = System.currentTimeMillis();
		/* 
		 * test summoner API
		 * */
		System.out.println("---------SummonerAPI---------");
		SummonerAPI summAPI = new SummonerAPI(apiValues);
		
		System.out.println("- - - - -SummonerAPI-Summoner- - - -");
		Map<String, SummonersBy> summByName = summAPI.getSummonersByNames("hi im g00fy");
		System.out.println(summByName.get("hiimg00fy").id); //name in all lower case and with spaces removed!
		System.out.println("- - - - -SummonerAPI-Masteries- - - -"); // MasteryPages
		Map<String, MasteryPages> summMasteries = summAPI.getSummonersMasteries("22573844");
		System.out.println(summMasteries.get("22573844").pages.iterator().next().name);
		System.out.println("- - - - -SummonerAPI-Runes- - - -");
		Map<String, RunePages> summRunes = summAPI.getSummonersRunes("22573844");
		for(RunePage page : summRunes.get("22573844").pages){ // iterate through RunePages
			System.out.println(page.slots.iterator().next().runeId);
			break;
		}	
		/*
		 * test champion API
		 */
		System.out.println("---------ChampionAPI---------");
		ChampionAPI champAPI = new ChampionAPI(apiValues);
		
		System.out.println("- - - - -ChampionAPI-Champions- - - - -");
		List<Champion> champions = champAPI.getChampions();
		System.out.println(champions.get(0).id);
		System.out.println("- - - - -ChampionAPI-ChampionByID- - - - -");
		Champion champion = champAPI.getChampionByID(2);
		System.out.println(champion.freeToPlay.toString());
		/*
		 * test game API
		 */
		System.out.println("---------GameAPI---------");
		GameAPI gameAPI = new GameAPI(apiValues);
		
		System.out.println("- - - - -GameAPI-GetGame- - - - -");
		Set<Game> games = gameAPI.getGames(22573844);
		System.out.println(games.iterator().next().stats.level);
		/*
		 * test stats API
		 */
		System.out.println("---------StatsAPI---------");
		StatsAPI statsAPI = new StatsAPI(apiValues);
		
		System.out.println("- - - - -StatsAPI-Ranked- - - -");
		ChampionsStats championStats = statsAPI.getRanked(22573844, 4);
		System.out.println(championStats.champions.get(0).stats.totalDamageDealt);
		System.out.println("- - - - -StatsAPI-Summary- - - -");
		PlayerStatSummaries playerStats = statsAPI.getSummary(22573844, 4);
		System.out.println(playerStats.playerStatSummaries.get(0).playerStatSummaryType);
		/* 
		 * test league API
		 * */
		System.out.println("---------LaegueAPI---------");
		LeagueAPI leagueAPI = new LeagueAPI(apiValues);
		
		System.out.println("- - - - -LaegueAPI-GetLeague-- - - -");
		Map<String, List<League>> league = leagueAPI.getLeague("22573844");
		System.out.println(league.get("22573844").get(0).entries.get(21).playerOrTeamName);
		System.out.println("- - - - -LaegueAPI-SingleEntry-- - - -");
		Map<String, List<League>> leagueEntry = leagueAPI.getLeagueSingleEntry("22573844");
		System.out.println(leagueEntry.get("22573844").get(0).entries.get(0).leaguePoints);
		
		long stopTime = System.currentTimeMillis();
	    System.out.println("EXECUTION TIME: " + (stopTime - startTime) + " msec");
		
		Thread.sleep(10000); // temporary workaround to avoid API rate limit

		System.out.println("- - - - -LaegueAPI-SingleEntry-- - - -");
		League leagueChallegner = leagueAPI.getLeagueChallenger("RANKED_SOLO_5x5");
		System.out.println(leagueChallegner.name);	
		/*
		 * test CurrentGameInfo
		 */
		System.out.println("---------CurrentGameInfo---------");
		CurrentGameAPI currentGameAPI = new CurrentGameAPI(apiValues);
		
		System.out.println("- - - - -CurrentGameInfo-GetCurrentGameInfo- - - - -");
		CurrentGameInfo currentGame = currentGameAPI.getCurrentGameInfo("EUW1",19264473);
		System.out.println(Long.toString(currentGame.gameId));
		

	}

}
