import java.awt.*;

/**
 * 
 * Interface for styling of a Mancala Board 
 *
 */
public interface BoardStyle 
{
	//Below are examples of different ways we can change the style
	//of the board. Another example would be to change pit shape.
	Color getColor();
	Font getTextFont();
}