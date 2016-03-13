package com.g00fy2.riotapi.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

import com.g00fy2.riotapi.ApiUtils;
import com.g00fy2.riotapi.exception.*;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

public abstract class RiotAPI {
	
	private String urlHost;
	private String urlPath;
	private String urlQuery;
	private String region;
	private String apiVersion;
	private String apiCategory;
	private Gson gson;

	public RiotAPI(final Map<String, String> apiValues, final String apiVersion, final String apiCategory) throws ApiException{
		urlHost = apiValues.get("urlHost");
		urlPath = apiValues.get("urlPath");
		urlQuery = "api_key=" + apiValues.get("apiKey");
		setRegion(apiValues.get("region"));	
		this.apiVersion = apiVersion;
		this.apiCategory = apiCategory;
		gson = new Gson();
	}
	
	protected <T> T getObjectFromJsonUrl(String urlPath, String urlQuery, Class<T> classOf) throws ApiException{
		
		HttpsURLConnection conn = establishHttpsConn(urlPath, urlQuery);
		
		try ( BufferedReader reader = new BufferedReader( new InputStreamReader(conn.getInputStream() ) ) )
		{
			T object = gson.fromJson(reader, classOf);
				
			return object;			
		}
		catch (JsonSyntaxException e)
		{
			throw new GsonException("No valid JSON representation for an object of type.");
		}
		catch (JsonIOException e)
		{
			throw new GsonException("Failed reading from the Reader.");
		}
		catch (IOException e)
		{
			throw new ApiException("Unable to get data from URL.");
		}
	}

	
	protected <T> T getObjectFromJsonUrl(String urlPath, String urlQuery, Type typeOf) throws ApiException{
		
		HttpsURLConnection conn = establishHttpsConn(urlPath, urlQuery);
		
		try ( BufferedReader reader = new BufferedReader( new InputStreamReader(conn.getInputStream() ) ) )
		{
			T object = gson.fromJson(reader, typeOf);
				
			return object;			
		}
		catch (JsonSyntaxException e)
		{
			throw new GsonException("No valid JSON representation for an object of type.");
		}
		catch (JsonIOException e)
		{
			throw new GsonException("Failed reading from the Reader.");
		}
		catch (IOException e)
		{
			throw new ApiException("Unable to get data from URL.");
		}
	}	

	
	private HttpsURLConnection establishHttpsConn(String urlPath, String urlQuery) throws ApiException{
		int responseCode = 0;
		
		try
	    {
			URI uri = new URI("https", null, region+urlHost, -1, urlPath , urlQuery, null);
			URL obj = uri.toURL();
			HttpsURLConnection conn = (HttpsURLConnection) obj.openConnection();
			conn.setRequestMethod("GET");
					
			responseCode = conn.getResponseCode();

			System.out.println("DEBUG : Sending 'GET' request to URL : " + obj.toString());
			
			if (responseCode != 200){
				throw new ResponseErrorException(responseCode);
			}
					
			return conn;
	    }
		catch (URISyntaxException e)
		{
			throw new ApiException("Invalid URI Syntax.");
		}
		catch (MalformedURLException e)
		{
			throw new ApiException("Malformed URL.");
		}
		catch (IOException e)
		{
			throw new ApiException("Could not connect to server.");
		}
	}
	
	protected String buildUrlPath(){
		return urlPath + region + apiVersion + apiCategory;
	}
	
	public void setRegion(String region) throws IllegalApiParameterException{
		this.region = ApiUtils.validRegion(region);
	}	
	
	public String getRegion(){
		return region;
	}
	
	protected String getUrlQuery(){
		return urlQuery;
	}


}
