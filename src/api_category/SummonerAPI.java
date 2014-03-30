package api_category;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import pojo_summoner.MasteryPages;
import pojo_summoner.RunePages;
import pojo_summoner.SummonersBy;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class SummonerAPI {
	
	private String region;
	private String apiVersion;
	
	public SummonerAPI(String region, String apiVersion){
		this.region = region;
		this.apiVersion = apiVersion;
	}
	
	
		// response object contains the summoner objects mapped by the standardized summoner name (lower case without spaces)
		public Map<String, SummonersBy> getSummonersByNames(String protocol, String baseURL, String urlSuffix, String summonerNames) throws Exception{			
		
		// sets the base URL with variables from class
		baseURL = replaceURL(protocol, baseURL);
		String url = baseURL+"/by-name/"+summonerNames+urlSuffix;

		URL obj = new URL(url);
		HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
		conn.setRequestMethod("GET");
 
		int responseCode = conn.getResponseCode();
		System.out.println("Sending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);
		
		Gson gson = new Gson();
		BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		//System.out.println(reader.readLine());
		Map<String, SummonersBy>  summoners = gson.fromJson(reader, new TypeToken<Map<String, SummonersBy>>(){}.getType());
		reader.close(); // close BufferedReader AND InputStreamReader
		conn.disconnect();
		
		return summoners;
		}
		
		
		// response object contains the summoner objects mapped by the summoner id
		public Map<Integer, SummonersBy> getSummonersByIDs(String protocol, String baseURL, String urlSuffix, String summonerIDs) throws Exception{			
			
		// sets the base URL with variables from class
		baseURL = replaceURL(protocol, baseURL);
		String url = baseURL+"/"+summonerIDs+urlSuffix;

		URL obj = new URL(url);
		HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
		conn.setRequestMethod("GET");
 
		int responseCode = conn.getResponseCode();
		System.out.println("Sending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);
		
		Gson gson = new Gson();
		BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		//System.out.println(reader.readLine());
		Map<Integer, SummonersBy>  summoners = gson.fromJson(reader, new TypeToken<Map<Integer, SummonersBy>>(){}.getType());
		reader.close(); // close BufferedReader AND InputStreamReader
		conn.disconnect();
		
		return summoners;
		}
		
		
		// response object contains the summoner name mapped by the summoner id
		public Map<Integer, String> getSummonersNames(String protocol, String baseURL, String urlSuffix, String summonerIDs) throws Exception{			
			
		// sets the base URL with variables from class
		baseURL = replaceURL(protocol, baseURL);
		String url = baseURL+"/"+summonerIDs+urlSuffix;

		URL obj = new URL(url);
		HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
		conn.setRequestMethod("GET");
 
		int responseCode = conn.getResponseCode();
		System.out.println("Sending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);
		
		Gson gson = new Gson();
		BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		//System.out.println(reader.readLine());
		Map<Integer, String>  summoners = gson.fromJson(reader, new TypeToken<Map<Integer, String>>(){}.getType());
		reader.close(); // close BufferedReader AND InputStreamReader
		conn.disconnect();
		
		return summoners;
		}
		
		
		// response object contains the summoner matery pages mapped by the summoner id
		public Map<String, MasteryPages> getSummonersMasteries(String protocol, String baseURL, String urlSuffix, String summonerIDs) throws Exception{			
			
		// sets the base URL with variables from class
		baseURL = replaceURL(protocol, baseURL);
		String url = baseURL+"/"+summonerIDs+"/masteries"+urlSuffix;

		URL obj = new URL(url);
		HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
		conn.setRequestMethod("GET");
 
		int responseCode = conn.getResponseCode();
		System.out.println("Sending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);
		
		Gson gson = new Gson();
		BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		//System.out.println(reader.readLine());
		Map<String, MasteryPages>  summoners = gson.fromJson(reader, new TypeToken<Map<String, MasteryPages>>(){}.getType());
		reader.close(); // close BufferedReader AND InputStreamReader
		conn.disconnect();
		
		return summoners;
		}
		
		
		// response object contains the summoner matery pages mapped by the summoner id
		public Map<String, RunePages> getSummonersRunes(String protocol, String baseURL, String urlSuffix, String summonerIDs) throws Exception{			
			
		// sets the base URL with variables from class
		baseURL = replaceURL(protocol, baseURL);
		String url = baseURL+"/"+summonerIDs+"/runes"+urlSuffix;

		URL obj = new URL(url);
		HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
		conn.setRequestMethod("GET");
 
		int responseCode = conn.getResponseCode();
		System.out.println("Sending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);
		
		Gson gson = new Gson();
		BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		//System.out.println(reader.readLine());
		Map<String, RunePages>  summoners = gson.fromJson(reader, new TypeToken<Map<String, RunePages>>(){}.getType());
		reader.close(); // close BufferedReader AND InputStreamReader
		conn.disconnect();
		
		return summoners;
		}
		
		
		// function to build the final url
		private String replaceURL(String protocol, String baseURL){
			baseURL = baseURL.replace("{region}",region);
			baseURL = baseURL.replace("{apiVersion}","v"+apiVersion);
			baseURL = baseURL.replace("{category}","summoner");
			baseURL = protocol+baseURL;		
			return baseURL;
		}
}
