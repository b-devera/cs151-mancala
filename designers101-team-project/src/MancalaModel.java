import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * MancalaModel is the model part of the MVC pattern
 * @author Berlun Devera, Brandon Russell, Sweta Pradhan
 *
 */
public class MancalaModel {
	int[] pits;
	ArrayList<ChangeListener> listeners;
	
	/**
	 * Constructor for the Model class of our Mancala game
	 * @param initialStones the amount of stones in each pit chosen by the player (3 or 4)
	 */
	public MancalaModel(int initialStones) {
		pits = new int[14];
		for (int i = 0; i < 6; i++) {
			pits[i] = initialStones;
			pits[i + 7] = initialStones;
		}
		listeners = new ArrayList<ChangeListener>();
		System.out.println("Initial pit values: " + Arrays.toString(pits));
	}
	
	/**
	 * Gets the array of pits and clones them
	 * @return the array of pits
	 */
	public int[] getPits() {
		return (int[]) (pits.clone());
	}
	
	/**
	 * Attaches the ChangeListener into the ArrayList of ChangeListeners
	 * @param c the ChangeListener
	 */
	public void attach(ChangeListener c) {
		listeners.add(c);
		c.stateChanged(new ChangeEvent(this));
	}
	
	/**
	 * Updates the location of a pit with the specified amount of stones
	 * @param location the location of the pit
	 * @param value the amount of stones
	 */
	public void update(int location, int value) {
		pits[location] = value;
		for (ChangeListener l: listeners) {
			l.stateChanged(new ChangeEvent(this));
		}
	}
	
	/**
	 * Sets the game board up according to the given style.
	 * @param someStyle a Board Style to give the game board
	 * @return someStyle the BoardStyle of the Mancala board
	 */
	public BoardStyle setStyle(BoardStyle someStyle)
	{
		return someStyle;
	}
}
