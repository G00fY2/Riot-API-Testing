package api_category;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import com.google.gson.Gson;

public abstract class RiotAPI {

	protected String baseURL;
	protected String urlSuffix;
	protected Gson gson;

	public RiotAPI(String protocol, String baseURL, String urlSuffix, String region, String apiVersion, String category){
		this.baseURL = baseURL.replace("{region}",region);
		this.baseURL = this.baseURL.replace("{apiVersion}","v"+apiVersion);
		this.baseURL = this.baseURL.replace("{category}",category);
		this.baseURL = protocol+this.baseURL;
		this.urlSuffix = urlSuffix;
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
	
	protected <T> T getObjectFromJsonUrl(String rawUrl,  Type typeOf) throws Exception{
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
	
	//method previous been used to get JSON as String
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

	public URL encodeURL(String rawUrl) throws Exception{
		URL url = new URL(rawUrl);
		URI uri = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef());
		url = uri.toURL();
		
		return url;
	}

}
