package api_main;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;

import api_category.SummonerAPI;
import api_pojo.SummonersBy;


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
		Map<Integer, SummonersBy> summByID = summAPI.getSummonersByIDs(protocol, baseURL, urlSuffix, "30509866");
		Map<String, SummonersBy> summByName = summAPI.getSummonersByNames(protocol, baseURL, urlSuffix, "kingkalle22");
		
		System.out.println(summByID.get(30509866).name);
		System.out.println(summByName.get("kingkalle22").id);
	}



}
