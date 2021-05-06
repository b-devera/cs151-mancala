
public class GameLogic {
	private final MancalaModel model;
	private int[] currentPits;
	private int[] previousPits;
	private boolean turnDone; //we can use this boolean to track when a turn has finished
	private boolean activeMove;
	private boolean canUndo;
	
	private String gameState;
	
	public GameLogic(MancalaModel model) {
		this.model = model;
		currentPits = model.getPits();
		previousPits = model.getPits();
		turnDone = false;
		canUndo = false;
		activeMove = true;
	}
	
	/*
	 * Checks if the number of stones in each pit and decides if the game is over.
	 * @return true if the each pit (besides the stores) is 0
	 */
	public boolean gameOver() {
		boolean done = false;
		int zeroCount = 0;
		
		// iterates through the pits and checks if the index of the pits is 0
		for (int i = 0; i < 6; i++) {
			if (model.pits[i] == 0 && model.pits[i + 7] == 0)
				zeroCount++;
		}
		
		// if all pits are empty, set done to true
		if (zeroCount == 6)
			done = true;
		return done;
	}
	
	/*
	 * Implements a player move by "moving" the stones when a player chooses a pit
	 * and updates the mancala with the current state after moving.
	 * @param pit the pit position chosen by the player
	 */
	public void playerMoved(int pit)
	{
		if(!activeMove) //will be used to check if play is in an active state; i.e. a player has not moved yet or a player undid a move
			return;
		
		previousPits = currentPits.clone(); //stores the mancala state before moving the stones
		int pitPickupPosition = pit;
		int nextPit = pitPickupPosition + 1;
		int stonePickupCount = currentPits[pitPickupPosition];
		
		currentPits[pitPickupPosition] = 0; //"picks up" the stones from the pit
		
		while(stonePickupCount > 0)
		{
			currentPits[nextPit] += 1;
			
			if(nextPit == 13)
				nextPit = 0;
			else
				nextPit++;
			
			stonePickupCount--;
		}
		
		
		for (int i = 0; i < 14; i++)
		{
			model.update(i, currentPits[i]); //updates the manacala with the state after moving
		}
		
		activeMove = false;
		canUndo = true;
	}
	
	/*
	 * Undoes a player move if available; returning the mancala to the previous state
	 */
	public void undoMove()
	{
		if(!canUndo)
			return;
		
		currentPits = previousPits;
		for(int i = 0; i < 14; i++)
			model.update(i, currentPits[i]);
		
		canUndo = false;
		activeMove = true;
	}
	
	/*
	 * Reports if the player can currently use the undo method
	 * @return true if the current player can perform an undo
	 */
	public boolean canUndo()
	{
		return canUndo;
	}
}
