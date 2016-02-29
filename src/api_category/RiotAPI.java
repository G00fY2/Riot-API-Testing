package api_category;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URL;
import java.util.Arrays;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

import com.google.gson.Gson;

public abstract class RiotAPI {
	
	private String urlHost;
	private String urlPath;
	private String urlQuery;
	private String region;
	private String apiVersion;
	private String apiCategory;
	private Gson gson;

	public RiotAPI(final Map<String, String> apiValues, final String apiVersion, final String apiCategory){
		urlHost = apiValues.get("urlHost");
		urlPath = apiValues.get("urlPath");
		urlQuery = "api_key=" + apiValues.get("apiKey");
		setRegion(apiValues.get("region"));	
		this.apiVersion = apiVersion;
		this.apiCategory = apiCategory;
		gson = new Gson();
	}
	
	protected <T> T getObjectFromJsonUrl(String urlPath, String urlQuery, Class<T> classOf) throws Exception{
		URL obj = encodeUrl(urlPath, urlQuery);
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
	
	protected <T> T getObjectFromJsonUrl(String urlPath, String urlQuery, Type typeOf) throws Exception{
		URL obj = encodeUrl(urlPath, urlQuery);
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

	
	private URL encodeUrl(String urlPath, String urlQuery) throws Exception{
		URI uri = new URI("https", null, region+urlHost, -1, urlPath , urlQuery, null);
		return uri.toURL();
	}
	
	public void setRegion(String region){
		region.trim().toLowerCase();
		final String[] regions = new String[] {"br","eune","euw","kr","lan","las","na","oce","ru","tr"};
		if (Arrays.asList(regions).contains(region)){
			this.region = region;
		}
	}	
	
	protected String buildUrlPath(){
		return urlPath + region + apiVersion + apiCategory;
	}
	
	public String getRegion(){
		return region;
	}
	protected String getUrlQuery(){
		return urlQuery;
	}


}
