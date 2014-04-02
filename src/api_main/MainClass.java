package api_main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.Map;
import java.util.Set;

import pojo_champion.*;
import pojo_game.*;
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
		String baseURL = "prod.api.pvp.net/api/lol/{region}/{apiVersion}/{category}";
		String urlSuffix = "?api_key="+apiKey;
		String region = "euw";
		String apiVersionSumm = "1.3";
		String apiVersionChamp = "1.1";
		String apiVersionGame = "1.3";
		String apiVersionStats = "1.3";
		
		/* 
		 * test summoner API
		 * */
		SummonerAPI summAPI = new SummonerAPI(protocol, baseURL, urlSuffix, region, apiVersionSumm);

		Map<String, SummonersBy> summByName = summAPI.getSummonersByNames("g00fy2");
		System.out.println(summByName.get("g00fy2").id);
		System.out.println("- - - - -SummonerAPI-Summoner- - - -");
		// MasteryPages
		Map<String, MasteryPages> summMasteries = summAPI.getSummonersMasteries("22573844");
		System.out.println(summMasteries.get("22573844").pages.iterator().next().name);
		System.out.println("- - - - -SummonerAPI-Masteries- - - -");
		Map<String, RunePages> summRunes = summAPI.getSummonersRunes("22573844");
		// iterate through RunePages
		for(RunePage page : summRunes.get("22573844").pages){
			System.out.println(page.slots.iterator().next().rune.description);
			System.out.println("- - - - -SummonerAPI-Runes- - - -");
			break;
		}	
		/*
		 * test champion API
		 */
		ChampionAPI champAPI = new ChampionAPI(protocol, baseURL, urlSuffix, region, apiVersionChamp);	
		List<Champion> champions = champAPI.getChampions();
		System.out.println(champions.get(0).name);
		System.out.println("- - - - -ChampionAPI- - - - -");
		// test champion API with Jackson parser
		ChampionAPIJackson champAPIJack = new ChampionAPIJackson(protocol, baseURL, urlSuffix, region, apiVersionChamp);
		List<Champion> championsJack = champAPIJack.getJackChampions();
		System.out.println(championsJack.get(1).name);
		System.out.println("- - - - -ChampionAPIJack- - - - -");
		/*
		 * test game API
		 */
		GameAPI gameAPI = new GameAPI(protocol, baseURL, urlSuffix, region, apiVersionGame);
		Set<Game> games = gameAPI.getGames(22573844);
		System.out.println(games.iterator().next().stats.level);
		System.out.println("- - - - -GameAPI- - - - -");
		/*
		 * test stats API
		 */
		StatsAPI statsAPI = new StatsAPI(protocol, baseURL, urlSuffix, region, apiVersionStats);
		ChampionsStats championStats = statsAPI.getRanked(22573844, 4);
		System.out.println(championStats.champions.get(0).stats.totalDamageDealt);
		System.out.println("- - - - -StatsAPI-Ranked- - - -");
		PlayerStatSummaries playerStats = statsAPI.getSummary(22573844, 4);
		System.out.println(playerStats.playerStatSummaries.get(0).playerStatSummaryType);
		System.out.println("- - - - -StatsAPI-Summary- - - -");
	}

}
