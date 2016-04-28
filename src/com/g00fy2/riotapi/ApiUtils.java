package com.g00fy2.riotapi;

import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.g00fy2.riotapi.exception.IllegalApiParameterException;

public class ApiUtils {
	private static final String[] regions = new String[] {"br","eune","euw","kr","lan","las","na","oce","ru","tr"};
	private static final String[] gameQueueType = new String[] {"RANKED_SOLO_5x5","RANKED_TEAM_3x3","RANKED_TEAM_5x5"};
	private static final String[] platformID = new String[] {"BR1","EUN1","EUW1","KR","LA1","LA2","NA1","OC1","RU","TR1"};
	private static final int currentYear = Calendar.getInstance().get(Calendar.YEAR);
	private static final Map<Integer, String> httpErrors = new HashMap<Integer, String>();
	static {	// "static initializer"
		httpErrors.put(400,	"Bad request");
		httpErrors.put(401,	"Unauthorized");
		httpErrors.put(403,	"Forbidden");
		httpErrors.put(404,	"Not Found");
		httpErrors.put(429,	"Rate limit exceeded");
		httpErrors.put(500,	"Internal server error");
		httpErrors.put(503,	"Service unavailable");
	}
	
	
	public static String commaSeparatedIntegerList( String list, int maxValues ) throws IllegalApiParameterException{
		if (list == null || list.isEmpty())
			throw new IllegalApiParameterException("No comma-separated list.");	
		
		list = list.replaceAll("\\s+","");
		int count = 0;
		Pattern pattern = Pattern.compile("(\\d+((,\\d+)*|,*))+"); // one number and 0-n numbers with only 1 comma seperated, multiple comma at the end allowed
		Matcher matcher = pattern.matcher(list);
		
		if ( matcher.matches() ) {	// is string a comma-separated list of numbers 		
			pattern = Pattern.compile("(\\d+|\\d+,)");
			matcher = pattern.matcher(list);	
			
			while ( matcher.find() ) {	// count number of values 
				count++;
			}
			if (count > maxValues) {
				throw new IllegalApiParameterException(list + " Maximum " + maxValues + " values limit exceeded (" + count + ")" );
			}
			
			return list;
		}
		else
			throw new IllegalApiParameterException(list + " is not a comma-separated list.");		
	}
	
	
	public static String commaSeparatedNameList( String list, int maxValues ) throws IllegalApiParameterException{
		if (list == null || list.isEmpty())
			throw new IllegalApiParameterException("No comma-separated list.");

		list = list.replaceAll("\\s+","");
		int count = 0;
		Pattern pattern = Pattern.compile("([\\w._°]{3,16}+((,[\\w._°]{3,16}+)*|,*))+", Pattern.UNICODE_CHARACTER_CLASS); // 3-16 characters, multiple comma at the end allowed
		Matcher matcher = pattern.matcher(list);
		
		if ( matcher.matches() ) {	// is string a comma-separated list of word characters
			pattern = Pattern.compile("([\\w._°]{3,16}+|[\\w._°]{3,16},)", Pattern.UNICODE_CHARACTER_CLASS);
			matcher = pattern.matcher(list);	
			
			while ( matcher.find() ) {	// count number of values 
				count++;
			}
			if (count > maxValues) {
				throw new IllegalApiParameterException(list + " maximum " + maxValues + " values limit exceeded (" + count + ")" );
			}
			
			return list;
		}
		else
			throw new IllegalApiParameterException(list + " is not a comma-separated list.");		
	}
	
	
	public static String validGameQueueType( String queueType ) throws IllegalApiParameterException{
		queueType = queueType.trim();
		
		if ( Arrays.asList(gameQueueType).contains(queueType) )
			return queueType;
		else
			throw new IllegalApiParameterException(queueType + " is not a valid game queue type.");		
	}
	
	
	public static String validPlatformID( String platformId ) throws IllegalApiParameterException{
		platformId = platformId.toUpperCase().trim();
		
		if ( Arrays.asList(platformID).contains(platformId) )
			return platformId;
		else
			throw new IllegalApiParameterException(platformId + " is not a valid platform ID.");		
	}
	
	
	public static String validRegion( String region ) throws IllegalApiParameterException{
		region = region.toLowerCase().trim();
		
		if ( Arrays.asList(regions).contains(region) )
			return region;
		else
			throw new IllegalApiParameterException(region + " is not a valid region.");		
	}
	
	
	public static String validSeason( String season ) throws IllegalApiParameterException{
		season = season.toUpperCase().trim();
		
		if ( season.equals("SEASON3") ){
			return season;
		}
		for (int i=2014; i <= currentYear; i++ ){ //only seasons from 2014 -> current year are valid
			if ( season.equals("SEASON" + i) ){
				return season;
			}
		}
		throw new IllegalApiParameterException(season + " is not a valid season.");		
	}
	
	
	public static String getHttpError( int code ){
		String reason = "Unkown";
				
		if (httpErrors.get(code) != null){
			reason = httpErrors.get(code);
		}
				
		return reason;		
	}
	

}
