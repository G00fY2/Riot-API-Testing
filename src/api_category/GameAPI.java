package api_category;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;

import pojo_game.Game;
import pojo_game.Games;

import com.google.gson.Gson;

public class GameAPI {
	
	private String baseURL;
	private String urlSuffix;
	private Gson gson;
	
	public GameAPI(String protocol, String baseURL, String urlSuffix, String region, String apiVersion){
		this.baseURL = baseURL.replace("{region}",region);
		this.baseURL = this.baseURL.replace("{apiVersion}","v"+apiVersion);
		this.baseURL = this.baseURL.replace("{category}","game/by-summoner/{summonerId}/recent");
		this.baseURL = protocol+this.baseURL;
		this.urlSuffix = urlSuffix;
		gson = new Gson();
	}
		
		// return a object List with all champions
		public Set<Game> getGames(long summonerID) throws Exception{			
		
		String url = baseURL.replace("{summonerId}", Long.toString(summonerID))+urlSuffix;

		URL obj = new URL(url);
		HttpsURLConnection conn = (HttpsURLConnection) obj.openConnection();
		conn.setRequestMethod("GET");
 
		int responseCode = conn.getResponseCode();
		System.out.println("Sending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		//System.out.println(reader.readLine());
		Games games = gson.fromJson(reader, Games.class);
		reader.close(); // close BufferedReader AND InputStreamReader
		conn.disconnect();
		
		return games.games;
		}

}
