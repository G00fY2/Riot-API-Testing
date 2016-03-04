package com.g00fy2.riotapi.pojo.stats;

public class PlayerStatSummary {
	public AggregatedStats aggregatedStats; //Aggregated stats
	public int losses; //Number of losses for this queue type. Returned for ranked queue types only
	long modifyDate; //Date stats were last modified specified as epoch milliseconds
	public String playerStatSummaryType; //Player stats summary type
	public int wins; //Number of wins for this queue type

}
