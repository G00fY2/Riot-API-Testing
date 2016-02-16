package api_category;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import com.google.gson.Gson;

public abstract class RiotAPI {
	
	private String protocol;
	private String urlBase;
	private String urlSuffix;
	private String region;
	private String apiVersion;
	private String category;
	private Gson gson;

	public RiotAPI(String protocol, String urlBase, String urlSuffix, String region, String apiVersion, String category){
		this.protocol = protocol;
		this.urlBase = urlBase.replace("{region}",region).replace("{apiVersion}","v"+apiVersion).replace("{category}",category);
		this.urlSuffix = urlSuffix;
		this.region = region;
		this.apiVersion = apiVersion;
		this.category = category;
		gson = new Gson();
	}
	
	protected <T> T getObjectFromJsonUrl(String rawUrl, Class<T> classOf) throws Exception{
		URL obj = encodeURL(rawUrl);
		HttpsURLConnection conn = (HttpsURLConnection) obj.openConnection();
		conn.setRequestMethod("GET");
		int responseCode = conn.getResponseCode();

		BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));		
		
		System.out.println("Sending 'GET' request to URL : " + obj.toString());
		System.out.println("Response Code : " + responseCode);

		T object = gson.fromJson(reader, classOf);
		reader.close();
		conn.disconnect();
		
		return object;
	}
	
	protected <T> T getObjectFromJsonUrl(String rawUrl, Type typeOf) throws Exception{
		URL obj = encodeURL(rawUrl);
		HttpsURLConnection conn = (HttpsURLConnection) obj.openConnection();
		conn.setRequestMethod("GET");
		int responseCode = conn.getResponseCode();

		BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));		
		
		System.out.println("Sending 'GET' request to URL : " + obj.toString());
		System.out.println("Response Code : " + responseCode);

		T object = gson.fromJson(reader, typeOf);
		reader.close();
		conn.disconnect();
		
		return object;
	}
	
	//method previous been used to return JSON as String
	protected String getJsonStringFromUrl(String rawUrl) throws Exception{
		URL obj = encodeURL(rawUrl);
		HttpsURLConnection conn = (HttpsURLConnection) obj.openConnection();
		conn.setRequestMethod("GET");
		int responseCode = conn.getResponseCode();

		BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));		
		StringBuilder builder = new StringBuilder();
		String jsonString = "";
		
		while ((jsonString = reader.readLine()) != null) {
		    builder.append(jsonString);
		}
		reader.close();
		conn.disconnect();
		jsonString = builder.toString();
		
		System.out.println("Sending 'GET' request to URL : " + obj.toString());
		System.out.println("Response Code : " + responseCode);
		System.out.println("Content lenght : " + jsonString.length());

		return jsonString;
	}

	private URL encodeURL(String rawUrl) throws Exception{
		URL url = new URL(protocol+rawUrl);
		URI uri = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef());
		
		return uri.toURL();
	}
	
	protected String getUrlBase(){
		return urlBase;
	}
	protected String getUrlSuffix(){
		return urlSuffix;
	}
	public String getRegion(){
		return region;
	}
	protected String getApiVersion(){
		return apiVersion;
	}
	protected String getCategory(){
		return category;
	}

}
