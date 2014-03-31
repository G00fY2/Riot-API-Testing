package api_main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.Map;
import java.util.Set;

import pojo_champion.*;
import pojo_game.*;
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
		
		
		// test summoner API
		SummonerAPI summAPI = new SummonerAPI(protocol, baseURL, urlSuffix, region, apiVersionSumm);
		Map<String, SummonersBy> summByName = summAPI.getSummonersByNames("g00fy2");
		Map<String, MasteryPages> summMasteries = summAPI.getSummonersMasteries("22573844");
		Map<String, RunePages> summRunes = summAPI.getSummonersRunes("22573844");
		
		// test champion API
		ChampionAPI champAPI = new ChampionAPI(protocol, baseURL, urlSuffix, region, apiVersionChamp);
		List<Champion> champions = champAPI.getChampions();
			
		
		// just some test output
		System.out.println(summByName.get("g00fy2").id);
		// MasteryPages
		 System.out.println(summMasteries.get("22573844").pages.iterator().next().name);
		// iterate through RunePages
		for(RunePage page : summRunes.get("22573844").pages){
			System.out.println(page.slots.iterator().next().rune.description);
			break;
		}
		System.out.println(champions.get(0).name);
		
		// test game API
		GameAPI gameAPI = new GameAPI(protocol, baseURL, urlSuffix, region, apiVersionGame);
		Set<Game> games = gameAPI.getGames(22573844);
		System.out.println(games.iterator().next().stats.level);
	}

}
