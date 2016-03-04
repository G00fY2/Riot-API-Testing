package com.g00fy2.pojo.stats;

import java.util.List;

public class ChampionsStats {
	public List<ChampionStats> champions; //Collection of aggregated stats summarized by champion
	public long modifyDate;//Date stats were last modified specified as epoch milliseconds
	public long summonerId; //Summoner ID

}
