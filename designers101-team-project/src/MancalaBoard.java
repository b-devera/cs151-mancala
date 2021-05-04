import java.util.ArrayList;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MancalaBoard {
	ArrayList<Integer> pits;
	ArrayList<ChangeListener> listeners;
	
	public MancalaBoard(ArrayList<Integer> p) {
		pits = p;
		listeners = new ArrayList<ChangeListener>();
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Integer> getPits() {
		return (ArrayList<Integer>) (pits.clone());
	}
	
	public void attach(ChangeListener c) {
		listeners.add(c);
	}
	
	public void update(int location, int value) {
		pits.set(location, new Integer(value));
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
