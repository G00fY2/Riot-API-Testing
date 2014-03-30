package api_category;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import api_pojo.SummonersBy;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class SummonerAPI {
	
	private String staticData;
	private String region;
	private String apiVersion;
	
	public SummonerAPI(String staticData, String region, String apiVersion){
		this.staticData = staticData;
		this.region = region;
		this.apiVersion = apiVersion;
	}

		public Map<String, SummonersBy> getSummonersByNames(String protocol, String baseURL, String urlSuffix, String summonerNames) throws Exception{			
		
		// sets the base URL with variables from class
		baseURL = replaceURL(protocol, baseURL);
		String url = baseURL+"/by-name/"+summonerNames+urlSuffix;

		URL obj = new URL(url);
		HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
		conn.setRequestMethod("GET");
 
		int responseCode = conn.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);
		
		Gson gson = new Gson();
		BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		//System.out.println(reader.readLine());
		Map<String, SummonersBy>  summoners = gson.fromJson(reader, new TypeToken<Map<String, SummonersBy>>(){}.getType());
		reader.close(); // close BufferedReader AND InputStreamReader
		conn.disconnect();
		
		return summoners;
		}
		
		public Map<Integer, SummonersBy> getSummonersByIDs(String protocol, String baseURL, String urlSuffix, String summonerIDs) throws Exception{			
			
		// sets the base URL with variables from class
		baseURL = replaceURL(protocol, baseURL);
		String url = baseURL+"/"+summonerIDs+urlSuffix;

		URL obj = new URL(url);
		HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
		conn.setRequestMethod("GET");
 
		int responseCode = conn.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);
		
		Gson gson = new Gson();
		BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		//System.out.println(reader.readLine());
		Map<Integer, SummonersBy>  summoners = gson.fromJson(reader, new TypeToken<Map<Integer, SummonersBy>>(){}.getType());
		reader.close(); // close BufferedReader AND InputStreamReader
		conn.disconnect();
		
		return summoners;
		}
		
		
		private String replaceURL(String protocol, String baseURL){
			baseURL = baseURL.replace("{staticData}",staticData);
			baseURL = baseURL.replace("{region}",region);
			baseURL = baseURL.replace("{apiVersion}","v"+apiVersion);
			baseURL = baseURL.replace("{category}","summoner");
			baseURL = baseURL.replace("//","/");
			baseURL = protocol+baseURL;		
			return baseURL;
		}
}
