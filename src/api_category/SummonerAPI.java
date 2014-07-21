package api_category;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

import pojo_summoner.MasteryPages;
import pojo_summoner.RunePages;
import pojo_summoner.SummonersBy;

import com.google.gson.reflect.TypeToken;

public class SummonerAPI extends RiotAPI {

	public SummonerAPI(String protocol, String baseURL, String urlSuffix, String region, String apiVersion) {
		super(protocol, baseURL, urlSuffix, region, apiVersion, "summoner");
	}

	// Get summoner objects mapped by standardized summoner name for a given
	// list of summoner names
	public Map<String, SummonersBy> getSummonersByNames(String summonerNames)
			throws Exception {

		String url = baseURL + "/by-name/"
				+ ((summonerNames.toLowerCase()).replaceAll("\\s+", ""))
				+ urlSuffix;

		URL obj = new URL(url);
		HttpsURLConnection conn = (HttpsURLConnection) obj.openConnection();
		conn.setRequestMethod("GET");

		int responseCode = conn.getResponseCode();
		System.out.println("Sending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		Map<String, SummonersBy> summoners = gson.fromJson(reader, new TypeToken<Map<String, SummonersBy>>(){}.getType());
		reader.close(); // close BufferedReader AND InputStreamReader
		conn.disconnect();

		return summoners;
	}

	// Get summoner objects mapped by summoner ID for a given list of summoner
	// IDs
	public Map<Integer, SummonersBy> getSummonersByIDs(String summonerIDs)
			throws Exception {

		String url = baseURL + "/" + summonerIDs + urlSuffix;

		URL obj = new URL(url);
		HttpsURLConnection conn = (HttpsURLConnection) obj.openConnection();
		conn.setRequestMethod("GET");

		int responseCode = conn.getResponseCode();
		System.out.println("Sending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		Map<Integer, SummonersBy> summoners = gson.fromJson(reader, new TypeToken<Map<Integer, SummonersBy>>(){}.getType());
		reader.close(); // close BufferedReader AND InputStreamReader
		conn.disconnect();

		return summoners;
	}

	// Get mastery pages mapped by summoner ID for a given list of summoner IDs
	public Map<String, MasteryPages> getSummonersMasteries(String summonerIDs)
			throws Exception {

		String url = baseURL + "/" + summonerIDs + "/masteries" + urlSuffix;

		URL obj = new URL(url);
		HttpsURLConnection conn = (HttpsURLConnection) obj.openConnection();
		conn.setRequestMethod("GET");

		int responseCode = conn.getResponseCode();
		System.out.println("Sending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		Map<String, MasteryPages> summoners = gson.fromJson(reader, new TypeToken<Map<String, MasteryPages>>(){}.getType());
		reader.close(); // close BufferedReader AND InputStreamReader
		conn.disconnect();

		return summoners;
	}

	// Get summoner names mapped by summoner ID for a given list of summoner IDs
	public Map<String, String> getSummonersNames(String summonerIDs)
			throws Exception {

		String url = baseURL + "/" + summonerIDs + urlSuffix;

		URL obj = new URL(url);
		HttpsURLConnection conn = (HttpsURLConnection) obj.openConnection();
		conn.setRequestMethod("GET");

		int responseCode = conn.getResponseCode();
		System.out.println("Sending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		Map<String, String> summoners = gson.fromJson(reader, new TypeToken<Map<String, String>>(){}.getType());
		reader.close(); // close BufferedReader AND InputStreamReader
		conn.disconnect();

		return summoners;
	}

	// Get rune pages mapped by summoner ID for a given list of summoner IDs
	public Map<String, RunePages> getSummonersRunes(String summonerIDs)
			throws Exception {

		String url = baseURL + "/" + summonerIDs + "/runes" + urlSuffix;

		URL obj = new URL(url);
		HttpsURLConnection conn = (HttpsURLConnection) obj.openConnection();
		conn.setRequestMethod("GET");

		int responseCode = conn.getResponseCode();
		System.out.println("Sending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		Map<String, RunePages> summoners = gson.fromJson(reader, new TypeToken<Map<String, RunePages>>(){}.getType());
		reader.close(); // close BufferedReader AND InputStreamReader
		conn.disconnect();

		return summoners;
	}

}
