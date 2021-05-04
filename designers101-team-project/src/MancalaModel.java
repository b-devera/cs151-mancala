import java.util.ArrayList;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MancalaModel {
	int[] pits;
	ArrayList<ChangeListener> listeners;
	
	public MancalaModel(int[] p) {
		pits = p;
		listeners = new ArrayList<ChangeListener>();
	}
	
	public int[] getPits() {
		return (int[]) (pits.clone());
	}
	
	public void attach(ChangeListener c) {
		listeners.add(c);
		c.stateChanged(new ChangeEvent(this));
	}
	
	public void update(int location, int value) {
		pits[location] = value;
		for (ChangeListener l: listeners) {
			l.stateChanged(new ChangeEvent(this));
		}
	}
	
	/**
	 * Sets the game board up according to the given style.
	 * @param someStyle a Board Style to give the game board
	 */
	public void setStyle(BoardStyle someStyle)
	{
		BoardStyle styleToUse = someStyle;
	}
}
