package api_category;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import pojo_stats.ChampionsStats;
import pojo_stats.PlayerStatSummaries;

public class StatsAPI extends RiotAPI{

	final static String category = "stats/by-summoner/{summonerId}";

	public StatsAPI(String protocol, String baseURL, String urlSuffix, String region, String apiVersion){
		super(protocol, baseURL, urlSuffix, region, apiVersion, category);
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
		PlayerStatSummaries playerStats = gson.fromJson(reader, PlayerStatSummaries.class);
		reader.close(); // close BufferedReader AND InputStreamReader
		conn.disconnect();

		return playerStats;
	}

}
