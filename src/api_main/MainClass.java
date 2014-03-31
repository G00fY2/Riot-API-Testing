package api_main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.Map;

import pojo_champion.Champion;
import pojo_summoner.MasteryPages;
import pojo_summoner.RunePages;
import pojo_summoner.SummonersBy;
import api_category.ChampionAPI;
import api_category.SummonerAPI;


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

		SummonerAPI summAPI = new SummonerAPI(protocol, baseURL, urlSuffix, region, apiVersionSumm);
		Map<String, SummonersBy> summByName = summAPI.getSummonersByNames("g00fy2");
		Map<String, MasteryPages> summMasteries = summAPI.getSummonersMasteries("22573844");
		Map<String, RunePages> summRunes = summAPI.getSummonersRunes("22573844");
		
		ChampionAPI champAPI = new ChampionAPI(protocol, baseURL, urlSuffix, region, apiVersionChamp);
		List<Champion> champions = champAPI.getChampions();
			
		// just some test output
		System.out.println(summByName.get("g00fy2").id);
		System.out.println(summMasteries.get("22573844").pages.get(0).name);
		System.out.println(summRunes.get("22573844").pages.get(0).slots.get(0).rune.description);
		System.out.println(champions.get(0).name);
	}



}
