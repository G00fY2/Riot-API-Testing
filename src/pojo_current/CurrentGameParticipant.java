package pojo_current;

import java.util.List;

public class CurrentGameParticipant {
	public boolean bot;	// Flag indicating whether or not this participant is a bot
	public long championId;	// The ID of the champion played by this participant
	public List<Mastery> masteries;	// The masteries used by this participant
	public long profileIconId; 	// The ID of the profile icon used by this participant
	public List<Rune> runes;	// The runes used by this participant
	public long spell1Id;	// The ID of the first summoner spell used by this participant
	public long spell2Id;	// The ID of the second summoner spell used by this participant
	public long summonerId;	// The summoner ID of this participant
	public String summonerName;	// The summoner name of this participant
	public long teamId;	// The team ID of this participant, indicating the participant's team
}
