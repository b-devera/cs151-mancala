import java.awt.*;
import java.awt.geom.RoundRectangle2D;

/**
 * 
 * A specific style to give the Mancala Board.
 * Implements the BoardStyle interface.
 *
 */
public class BoardStyleB implements BoardStyle
{
	private static final Color BOARD_COLOR = Color.CYAN;
	private static final Color PIT_COLOR = Color.PINK;
	private static final Font BOARD_FONT = new Font(Font.SERIF, Font.BOLD, 12);
	
	/**
	 * Gets the color to be used throughout the board.
	 */
	public Color getBoardColor() 
	{
		return BOARD_COLOR;
		
	}

	/**
	 * Gets the font to use for the text on the board.
	 */
	public Font getTextFont()
	{
		return BOARD_FONT;
		
	}

	/**
	 * Gets the pit color.
	 */
	@Override
	public Color getPitColor() {
		return PIT_COLOR;
	}

	/**
	 * Gets the pit shape.
	 */
	@Override
	public Shape getPitShape() {
		return new RoundRectangle2D.Double(0, 0, 10, 10, 30, 30);
	}

	/**
	 * Gets the pit dimension.
	 */
	@Override
	public Dimension getPitDimension() {
		return new Dimension(100, 100);
	}

	/**
	 * Draws the pit or store.
	 */
	@Override
	public void draw(Graphics g, int width, int height) {
		g.drawRoundRect(0, 0, width, height, 30, 30);
	}

	/**
	 * Fills the pit or store.
	 */
	@Override
	public void fill(Graphics g, int width, int height) {
		g.fillRoundRect(0, 0, width, height, 30, 30);
	}

	/**
	 * Gets the store dimension.
	 */
	@Override
	public Dimension getStoreDimension() {
		return new Dimension(100, 201);
	}
}