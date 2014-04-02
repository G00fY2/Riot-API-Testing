package api_category;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

import pojo_summoner.MasteryPages;
import pojo_summoner.RunePages;
import pojo_summoner.SummonersBy;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class SummonerAPI {
	
	private String baseURL;
	private String urlSuffix;
	private Gson gson;
	
	public SummonerAPI(String protocol, String baseURL, String urlSuffix, String region, String apiVersion){
		this.baseURL = baseURL.replace("{region}",region);
		this.baseURL = this.baseURL.replace("{apiVersion}","v"+apiVersion);
		this.baseURL = this.baseURL.replace("{category}","summoner");
		this.baseURL = protocol+this.baseURL;
		this.urlSuffix = urlSuffix;
		gson = new Gson();
	}
		
		// response object contains the summoner objects mapped by the standardized summoner name (lower case without spaces)
		public Map<String, SummonersBy> getSummonersByNames(String summonerNames) throws Exception{			
		
		String url = (baseURL+"/by-name/"+((summonerNames.toLowerCase()).replaceAll("\\s+",""))+urlSuffix);

		URL obj = new URL(url);
		HttpsURLConnection conn = (HttpsURLConnection) obj.openConnection();
		conn.setRequestMethod("GET");
 
		int responseCode = conn.getResponseCode();
		System.out.println("Sending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);
				
		BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		//System.out.println(reader.readLine());
		Map<String, SummonersBy>  summoners = gson.fromJson(reader, new TypeToken<Map<String, SummonersBy>>(){}.getType());
		reader.close(); // close BufferedReader AND InputStreamReader
		conn.disconnect();
		
		return summoners;
		}
		
		
		// response object contains the summoner objects mapped by the summoner id
		public Map<Integer, SummonersBy> getSummonersByIDs(String summonerIDs) throws Exception{			
			
		String url = baseURL+"/"+summonerIDs+urlSuffix;

		URL obj = new URL(url);
		HttpsURLConnection conn = (HttpsURLConnection) obj.openConnection();
		conn.setRequestMethod("GET");
 
		int responseCode = conn.getResponseCode();
		System.out.println("Sending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		//System.out.println(reader.readLine());
		Map<Integer, SummonersBy>  summoners = gson.fromJson(reader, new TypeToken<Map<Integer, SummonersBy>>(){}.getType());
		reader.close(); // close BufferedReader AND InputStreamReader
		conn.disconnect();
		
		return summoners;
		}
		
		
		// response object contains the summoner name mapped by the summoner id
		public Map<Integer, String> getSummonersNames(String summonerIDs) throws Exception{			
			
		String url = baseURL+"/"+summonerIDs+urlSuffix;

		URL obj = new URL(url);
		HttpsURLConnection conn = (HttpsURLConnection) obj.openConnection();
		conn.setRequestMethod("GET");
 
		int responseCode = conn.getResponseCode();
		System.out.println("Sending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		//System.out.println(reader.readLine());
		Map<Integer, String>  summoners = gson.fromJson(reader, new TypeToken<Map<Integer, String>>(){}.getType());
		reader.close(); // close BufferedReader AND InputStreamReader
		conn.disconnect();
		
		return summoners;
		}
		
		
		// response object contains the summoner matery pages mapped by the summoner id
		public Map<String, MasteryPages> getSummonersMasteries(String summonerIDs) throws Exception{			
			
		String url = baseURL+"/"+summonerIDs+"/masteries"+urlSuffix;

		URL obj = new URL(url);
		HttpsURLConnection conn = (HttpsURLConnection) obj.openConnection();
		conn.setRequestMethod("GET");
 
		int responseCode = conn.getResponseCode();
		System.out.println("Sending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		//System.out.println(reader.readLine());
		Map<String, MasteryPages>  summoners = gson.fromJson(reader, new TypeToken<Map<String, MasteryPages>>(){}.getType());
		reader.close(); // close BufferedReader AND InputStreamReader
		conn.disconnect();
		
		return summoners;
		}
		
		
		// response object contains the summoner matery pages mapped by the summoner id
		public Map<String, RunePages> getSummonersRunes(String summonerIDs) throws Exception{			
			
		String url = baseURL+"/"+summonerIDs+"/runes"+urlSuffix;

		URL obj = new URL(url);
		HttpsURLConnection conn = (HttpsURLConnection) obj.openConnection();
		conn.setRequestMethod("GET");
 
		int responseCode = conn.getResponseCode();
		System.out.println("Sending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		//System.out.println(reader.readLine());
		Map<String, RunePages>  summoners = gson.fromJson(reader, new TypeToken<Map<String, RunePages>>(){}.getType());
		reader.close(); // close BufferedReader AND InputStreamReader
		conn.disconnect();
		
		return summoners;
		}
		
}
