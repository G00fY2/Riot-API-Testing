package api_main;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;

import summoner_pojo.MasteryPages;
import summoner_pojo.SummonersBy;
import api_category.RunePages;
import api_category.SummonerAPI;


public class MainClass {
	
	public static void main(String[] args) throws Exception {
		
		String apiFile = "F:\\workspace\\apikey.txt";
		String apiKey = null;
		
		// read API Key from first line of local textfile (temporary solution)
		BufferedReader br = new BufferedReader(new FileReader(apiFile));
		apiKey = br.readLine();
		br.close();
		
		String protocol = "https://";
		String baseURL = "prod.api.pvp.net/api/lol/{staticData}/{region}/{apiVersion}/{category}";
		String urlSuffix = "?api_key="+apiKey;
		String staticData = "";
		String region = "euw";
		String apiVersion = "1.3";

		SummonerAPI summAPI = new SummonerAPI(staticData, region, apiVersion);		
		Map<String, MasteryPages> summMasteries = summAPI.getSummonersMasteries(protocol, baseURL, urlSuffix, "30509866");
		Map<String, RunePages> summRunes = summAPI.getSummonersRunes(protocol, baseURL, urlSuffix, "30509866");
		Map<String, SummonersBy> summByName = summAPI.getSummonersByNames(protocol, baseURL, urlSuffix, "kingkalle22");
		
		System.out.println(summMasteries.get("30509866").pages.get(0).id);
		System.out.println(summByName.get("kingkalle22").id);
		System.out.println(summRunes.get("30509866").pages.get(0).slots.get(0).rune.description);
	}



}
