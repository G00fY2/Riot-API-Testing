package com.g00fy2.riotapi;

import java.util.Arrays;
import java.util.Calendar;
import java.util.regex.Pattern;

import com.g00fy2.riotapi.exception.IllegalApiParameterException;

public class ApiUtils {
	public static final String[] regions = new String[] {"br","eune","euw","kr","lan","las","na","oce","ru","tr"};
	public static final String[] gameQueueType = new String[] {"RANKED_SOLO_5x5","RANKED_TEAM_3x3","RANKED_TEAM_5x5"};
	public static final String[] platformID = new String[] {"BR1","EUN1","EUW1","KR","LA1","LA2","NA1","OC1","RU","TR1"};
	public static final int currentYear = Calendar.getInstance().get(Calendar.YEAR);
	
	
	public static boolean isValidRegion( String region ) throws IllegalApiParameterException{
		region.toLowerCase().trim();
		
		if ( Arrays.asList(regions).contains(region) )
			return true;
		else
			throw new IllegalApiParameterException(region + " is not a valid region.");		
	}
	
	public static boolean isValidGameType( String gameType ) throws IllegalApiParameterException{
		gameType.toLowerCase().trim();
		
		if ( Arrays.asList(regions).contains(gameType) )
			return true;
		else
			throw new IllegalApiParameterException(gameType + " is not a valid game type.");		
	}
	
	public static boolean isCommaSeparatedIntegerList( String list ) throws IllegalApiParameterException{
		list.replaceAll("\\s+","");
		
		if ( Pattern.matches( "(\\d+((,\\d+)*|,*))+", list ) ) // one number and 0-n numbers with only 1 comma seperated, multiple comma at the end allowed
			return true;
		else
			throw new IllegalApiParameterException(list + " is not a Comma-separated list.");		
	}

	public static boolean isValidGameQueueType( String queueTypes ) throws IllegalApiParameterException{
		queueTypes.toUpperCase().trim();
		
		if ( Arrays.asList(gameQueueType).contains(queueTypes) )
			return true;
		else
			throw new IllegalApiParameterException(queueTypes + " is not a valid game queue type.");		
	}
	
	public static boolean isValidSeason( String season ) throws IllegalApiParameterException{
		season.toUpperCase().trim();
		
		if ( season.equals("SEASON3") ){
			return true;
		}
		for (int i=2014; i <= currentYear; i++ ){ //only seasons from 2014 -> current year are valid
			if ( season.equals("SEASON" + i) ){
				return true;
			}
		}
		throw new IllegalApiParameterException(season + " is not a valid season.");		
	}
	
	public static boolean isValidPlatformID( String platformId ) throws IllegalApiParameterException{
		platformId.toUpperCase().trim();
		
		if ( Arrays.asList(platformID).contains(platformId) )
			return true;
		else
			throw new IllegalApiParameterException(platformId + " is not a valid platform ID.");		
	}
	

}
