import java.awt.*;

/**
 * 
 * A specific style to give the Mancala Board. 
 * Implements the BoardStyle interface.
 *
 */
public class BoardStyleA implements BoardStyle
{
	private static final Color SOME_COLOR = Color.black;
	private static final Font SOME_FONT = new Font(Font.SANS_SERIF, Font.ITALIC, 12);
	
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
