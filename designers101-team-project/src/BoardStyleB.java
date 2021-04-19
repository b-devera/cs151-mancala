import java.awt.*;

/**
 * 
 * A specific style to give the Mancala Board.
 * Implements the BoardStyle interface.
 *
 */
public class BoardStyleB implements BoardStyle
{
	private static final Color SOME_COLOR = Color.blue;
	private static final Font SOME_FONT = new Font(Font.SERIF, Font.BOLD, 12);
	
	/**
	 * Gets the color to be used throughout the board.
	 */
	public Color getColor() 
	{
		return SOME_COLOR;
		
	}

	/**
	 * Gets the font to use for the text on the board.
	 */
	public Font getTextFont()
	{
		return SOME_FONT;
		
	}
}