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
	
	private String baseURL;
	private String urlSuffix;
	private Gson gson;
	
	public ChampionAPI(String protocol, String baseURL, String urlSuffix, String region, String apiVersion){
		this.baseURL = baseURL.replace("{region}",region);
		this.baseURL = this.baseURL.replace("{apiVersion}","v"+apiVersion);
		this.baseURL = this.baseURL.replace("{category}","champion");
		this.baseURL = protocol+this.baseURL;
		this.urlSuffix = urlSuffix;
		gson = new Gson();
	}
		
		// return a object List with all champions
		public List<Champion> getChampions() throws Exception{			
		
		String url = baseURL+urlSuffix;

		URL obj = new URL(url);
		HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
		conn.setRequestMethod("GET");
 
		int responseCode = conn.getResponseCode();
		System.out.println("Sending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		//System.out.println(reader.readLine());
		Champions champions = gson.fromJson(reader, Champions.class);
		reader.close(); // close BufferedReader AND InputStreamReader
		conn.disconnect();
		
		return champions.champions;
		}

}
