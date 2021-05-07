import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

import javax.swing.JButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * PitButton is the button that can be pressed to play Mancala
 * @author Berlun Devera, Brandon Russell, Sweta Pradhan
 *
 */
public class PitButton extends JButton implements ChangeListener {
	private int pitPosition;
	private Color pitColor;
	private Shape pitShape;
	
	
	/**
	 * Constructor class for PitButton
	 * @param pitPosition the position of the pit
	 * @param pitShape the shape of the pit
	 * @param pitColor the color of the pit
	 * @param d the dimensions of the pit
	 */
	public PitButton(int pitPosition, Shape pitShape, Color pitColor, Dimension d) {
		this.pitPosition = pitPosition;
		this.pitColor = pitColor;
		this.pitShape = pitShape;
		setPreferredSize(d);
		setContentAreaFilled(false);
	}
	
	/**
	 * Gets the pit position.
	 * @return the pit position
	 */
	public int getPosition() {
		return pitPosition;
	}
	
	/**
	 * Paints the pit button with the specified dimensions and color.
	 */
	protected void paintComponent(Graphics g) {
		setBackground(pitColor);
		
		if(getModel().isArmed())
			g.setColor(Color.LIGHT_GRAY);
		else
			g.setColor(getBackground());
		
		if (pitShape.equals(new Rectangle2D.Double(0, 0, 10, 10)))
			g.fillRect(0, 0, getSize().width - 1, getSize().height - 1);
		else
			g.fillRoundRect(0, 0, getSize().width, getSize().height - 1, 30, 30);
		
		super.paintComponent(g);
	}
	
	/**
	 * Changes the text of the pit when the pit button is pressed.
	 */
	@Override
	public void stateChanged(ChangeEvent e) {
		MancalaModel m = (MancalaModel) e.getSource();
		setText(Integer.toString(m.getPits()[pitPosition]));
	}

}
