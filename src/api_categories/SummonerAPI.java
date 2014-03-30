package api_categories;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import api_pojo.SummonerByName;

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

		public SummonerByName getSummonerByName(String protocol, String baseURL, String urlSuffix, String summonerName) throws Exception{			
		
		baseURL = replaceURL(protocol, baseURL);
		String url = baseURL+"/by-name/"+summonerName+urlSuffix;

		URL obj = new URL(url);
		System.out.println(url);
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
		
		return newSummoner.get(summonerName);
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
