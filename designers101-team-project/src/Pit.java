import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Pit extends JButton implements ChangeListener {
	private int pitPosition;
	private Color pitColor;
	
	public Pit(int pitPosition, Color pitColor, Dimension d) {
		this.pitPosition = pitPosition;
		this.pitColor = pitColor;
		setPreferredSize(d);
		setContentAreaFilled(false);
	}
	
	public int getPosition() {
		return pitPosition;
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
		MancalaModel m = (MancalaModel) e.getSource();
	}

}
