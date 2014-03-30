package api_main;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import api_pojo.SummonerByName;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


public class Request {
	
	static void sendGet(String baseURL, String region,String apiVersion, String apiKey, String summonerName) throws Exception{			
		
		String url = "https://prod.api.pvp.net/api/lol/euw/v1.3/summoner/by-name/{summonerNames}?api_key="+apiKey;
		url = url.replace("{summonerNames}",summonerName);
		URL obj = new URL(url);
			
		HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
		conn.setRequestMethod("GET");
 
		int responseCode = conn.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);
		
		Gson gson = new Gson();
		BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		//System.out.println(reader.readLine());
		Map<String, SummonerByName>  newSummoner = gson.fromJson(reader, new TypeToken<Map<String, SummonerByName>>(){}.getType());
		
		System.out.println("ID: "+newSummoner.get(summonerName).id);
	}

}
