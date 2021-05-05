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
	Color getBoardColor();
	Color getPitColor();
	Shape getPitShape();
	Dimension getPitDimension();
	Dimension getStoreDimension();
	Font getTextFont();
	
	void draw(Graphics g, int width, int height);
	
	void fill(Graphics g, int width, int height);
}