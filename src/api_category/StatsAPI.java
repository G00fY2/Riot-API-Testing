package api_category;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

import pojo_stats.ChampionsStats;
import pojo_stats.PlayerStatSummaries;

import com.google.gson.Gson;

public class StatsAPI {
	
	private String baseURL;
	private String urlSuffix;
	private Gson gson;
	
	public StatsAPI(String protocol, String baseURL, String urlSuffix, String region, String apiVersion){
		this.baseURL = baseURL.replace("{region}",region);
		this.baseURL = this.baseURL.replace("{apiVersion}","v"+apiVersion);
		this.baseURL = this.baseURL.replace("{category}","stats/by-summoner/{summonerId}");
		this.baseURL = protocol+this.baseURL;
		this.urlSuffix = urlSuffix;
		gson = new Gson();
	}
		
		public ChampionsStats getRanked(long summonerID, int season) throws Exception{			
		
		String url = baseURL.replace("{summonerId}", Long.toString(summonerID))+"/ranked"+urlSuffix.replace("?", "?season=SEASON"+season+"&");

		URL obj = new URL(url);
		HttpsURLConnection conn = (HttpsURLConnection) obj.openConnection();
		conn.setRequestMethod("GET");
 
		int responseCode = conn.getResponseCode();
		System.out.println("Sending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		//System.out.println(reader.readLine());
		ChampionsStats championStats = gson.fromJson(reader, ChampionsStats.class);
		reader.close(); // close BufferedReader AND InputStreamReader
		conn.disconnect();
		
		return championStats;
		}
		
		
		public PlayerStatSummaries getSummary(long summonerID, int season) throws Exception{			
		
			String url = baseURL.replace("{summonerId}", Long.toString(summonerID))+"/summary"+urlSuffix.replace("?", "?season=SEASON"+season+"&");

		URL obj = new URL(url);
		HttpsURLConnection conn = (HttpsURLConnection) obj.openConnection();
		conn.setRequestMethod("GET");
 
		int responseCode = conn.getResponseCode();
		System.out.println("Sending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		//System.out.println(reader.readLine());
		PlayerStatSummaries playerStats = gson.fromJson(reader, PlayerStatSummaries.class);
		reader.close(); // close BufferedReader AND InputStreamReader
		conn.disconnect();
		
		return playerStats;
		}

}
