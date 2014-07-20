package api_category;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

import pojo_league.League;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class LeagueAPI {
	
	private String baseURL;
	private String urlSuffix;
	private Gson gson;
	
	public LeagueAPI(String protocol, String baseURL, String urlSuffix, String region, String apiVersion){
		this.baseURL = baseURL.replace("{region}",region);
		this.baseURL = this.baseURL.replace("{apiVersion}","v"+apiVersion);
		this.baseURL = this.baseURL.replace("{category}","league");
		this.baseURL = protocol+this.baseURL;
		this.urlSuffix = urlSuffix;
		gson = new Gson();
	}
		

	public Map<String, List<League>> getLeague(String summonerIDs) throws Exception{			
		
		String url = baseURL+ "/by-summoner/"+summonerIDs+urlSuffix;

		URL obj = new URL(url);
		HttpsURLConnection conn = (HttpsURLConnection) obj.openConnection();
		conn.setRequestMethod("GET");
 
		int responseCode = conn.getResponseCode();
		System.out.println("Sending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		//System.out.println(reader.readLine());
		Map<String, List<League>>  league = gson.fromJson(reader, new TypeToken<Map<String, List<League>>>(){}.getType());
		reader.close(); // close BufferedReader AND InputStreamReader
		conn.disconnect();
		
		return league;
		}
	
	
	public Map<String, List<League>> getLeagueSingleEntry(String summonerIDs) throws Exception{			
		
		String url = baseURL+ "/by-summoner/"+summonerIDs+"/entry"+urlSuffix;

		URL obj = new URL(url);
		HttpsURLConnection conn = (HttpsURLConnection) obj.openConnection();
		conn.setRequestMethod("GET");
 
		int responseCode = conn.getResponseCode();
		System.out.println("Sending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		//System.out.println(reader.readLine());
		Map<String, List<League>>  league = gson.fromJson(reader, new TypeToken<Map<String, List<League>>>(){}.getType());
		reader.close(); // close BufferedReader AND InputStreamReader
		conn.disconnect();
		
		return league;
		}
	
	
	public Map<String, List<League>> getLeagueTeam(String teamIDs) throws Exception{			
		
		String url = baseURL+ "/by-team/"+teamIDs+urlSuffix;

		URL obj = new URL(url);
		HttpsURLConnection conn = (HttpsURLConnection) obj.openConnection();
		conn.setRequestMethod("GET");
 
		int responseCode = conn.getResponseCode();
		System.out.println("Sending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		//System.out.println(reader.readLine());
		Map<String, List<League>>  league = gson.fromJson(reader, new TypeToken<Map<String, List<League>>>(){}.getType());
		reader.close(); // close BufferedReader AND InputStreamReader
		conn.disconnect();
		
		return league;
		}
	
	
	public Map<String, List<League>> getLeagueTeamSingleEntry(String teamIDs) throws Exception{			
		
		String url = baseURL+ "/by-team/"+teamIDs+"/entry"+urlSuffix;

		URL obj = new URL(url);
		HttpsURLConnection conn = (HttpsURLConnection) obj.openConnection();
		conn.setRequestMethod("GET");
 
		int responseCode = conn.getResponseCode();
		System.out.println("Sending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		//System.out.println(reader.readLine());
		Map<String, List<League>>  league = gson.fromJson(reader, new TypeToken<Map<String, List<League>>>(){}.getType());
		reader.close(); // close BufferedReader AND InputStreamReader
		conn.disconnect();
		
		return league;
		}
	
	public League getLeagueChallenger(String gameType) throws Exception{			
		
		// possible game types: "RANKED_SOLO_5x5", "RANKED_TEAM_3x3", "RANKED_TEAM_5x5"
		String url = baseURL+ "/challenger"+urlSuffix;
		url = url.replace("?api", "?type="+gameType+"&api");

		URL obj = new URL(url);
		HttpsURLConnection conn = (HttpsURLConnection) obj.openConnection();
		conn.setRequestMethod("GET");
 
		int responseCode = conn.getResponseCode();
		System.out.println("Sending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		//System.out.println(reader.readLine());
		League league = gson.fromJson(reader, League.class);
		reader.close(); // close BufferedReader AND InputStreamReader
		conn.disconnect();
		
		return league;
		}

}
