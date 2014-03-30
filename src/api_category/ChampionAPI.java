package api_category;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import pojo_champion.Champion;
import pojo_champion.Champions;

import com.google.gson.Gson;

public class ChampionAPI {
	
	private String region;
	private String apiVersion;
	
	public ChampionAPI(String region, String apiVersion){
		this.region = region;
		this.apiVersion = apiVersion;
	}
	
		// return a object List with all champions
		public List<Champion> getChampions(String protocol, String baseURL, String urlSuffix) throws Exception{			
		
		// sets the base URL with variables from class
		baseURL = replaceURL(protocol, baseURL);
		String url = baseURL+urlSuffix;

		URL obj = new URL(url);
		HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
		conn.setRequestMethod("GET");
 
		int responseCode = conn.getResponseCode();
		System.out.println("Sending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);
		
		Gson gson = new Gson();
		BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		//System.out.println(reader.readLine());
		Champions champions = gson.fromJson(reader, Champions.class);
		reader.close(); // close BufferedReader AND InputStreamReader
		conn.disconnect();
		
		return champions.champions;
		}
		
		// function to build the final url
		private String replaceURL(String protocol, String baseURL){
			baseURL = baseURL.replace("{region}",region);
			baseURL = baseURL.replace("{apiVersion}","v"+apiVersion);
			baseURL = baseURL.replace("{category}","champion");
			baseURL = protocol+baseURL;		
			return baseURL;
		}
}
