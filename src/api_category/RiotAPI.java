package api_category;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import com.google.gson.Gson;

public abstract class RiotAPI {

	protected String baseURL;
	protected String urlSuffix;
	protected Gson gson;	
	protected BufferedReader reader;
	protected HttpsURLConnection conn;

	public RiotAPI(String protocol, String baseURL, String urlSuffix, String region, String apiVersion, String category){
		this.baseURL = baseURL.replace("{region}",region);
		this.baseURL = this.baseURL.replace("{apiVersion}","v"+apiVersion);
		this.baseURL = this.baseURL.replace("{category}",category);
		this.baseURL = protocol+this.baseURL;
		this.urlSuffix = urlSuffix;
		gson = new Gson();
	}

	protected BufferedReader getJsonFromUrl(String rawUrl) throws Exception{
		URL obj = encodeURL(rawUrl);
		conn = (HttpsURLConnection) obj.openConnection();
		conn.setRequestMethod("GET");

		int responseCode = conn.getResponseCode();
		System.out.println("Sending 'GET' request to URL : " + obj.toString());
		System.out.println("Response Code : " + responseCode);

		reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));		

		return reader;
	}

	public URL encodeURL(String rawUrl) throws Exception{
		URL url = new URL(rawUrl);
		URI uri = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef());
		url = uri.toURL();
		
		return url;
	}
	
	protected void closeJsonFromUrl() throws Exception{
		if (reader != null){
			reader.close(); // close BufferedReader AND InputStreamReader
		}
		if (conn != null){
			conn.disconnect();
		}
	}

}