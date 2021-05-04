
public class GameLogic {
	private final MancalaModel model;
	private int[] currentPits;
	private int[] previousPits;
	
	public GameLogic(MancalaModel model) {
		this.model = model;
		currentPits = model.getPits();
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
}
