
/**
 * Stores information about the player
 * @author Berlun Devera
 *
 */
public class Player {
	private String playerName;
	
	/**
	 * Constructor for the Player class
	 * @param playerName the name of the player
	 */
	public Player(String playerName) { this.playerName = playerName; }
	
	/**
	 * Gets the name of the player
	 * @return player name
	 */
	public String getName() { return playerName; }
	
	/**
	 * Changes the name of the player
	 * @param playerName the name of the player
	 */
	public void setName(String playerName) { this.playerName = playerName; }
	
}
