import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * 
 * A specific style to give the Mancala Board. 
 * Implements the BoardStyle interface.
 *
 */
public class BoardStyleA implements BoardStyle
{
	private static final Color BOARD_COLOR = Color.GRAY;
	private static final Color PIT_COLOR = Color.DARK_GRAY;
	private static final Font BOARD_FONT = new Font(Font.SANS_SERIF, Font.ITALIC, 12);
	
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

	@Override
	public Color getPitColor() {
		return PIT_COLOR;
	}

	@Override
	public Shape getPitShape() {
		return new Rectangle2D.Double(0, 0, 10, 10);
	}

	@Override
	public Dimension getPitDimension() {
		return new Dimension(100, 100);
	}

	@Override
	public void draw(Graphics g, int width, int height) {
		g.drawRect(0, 0, width, height);
	}

	@Override
	public void fill(Graphics g, int width, int height) {
		g.fillRect(0, 0, width, height);
	}

	@Override
	public Dimension getStoreDimension() {
		return new Dimension(100, 201);
	}
}
