package api_category;

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

}
