package pojo_champion;

public class Champion {
	
	public Boolean active; // Indicates if the champion is active
	public int attackRank; // Champion attack rank
	public Boolean botEnabled; // Bot enabled flag (for custom games).
	public Boolean botMmEnabled; // Bot Match Made enabled flag (for Co-op vs. AI games)
	public int defenseRank; // Champion defense rank
	public int difficultyRank; // Champion difficulty rank
	public Boolean freeToPlay; // Indicates if the champion is free to play. Free to play champions are rotated periodically
	public long id; // Champion ID
	public int magicRank; // Champion magic rank
	public String name; // Champion name
	public Boolean rankedPlayEnabled; // Ranked play enabled flag

}
