import java.awt.*;

/**
 * 
 * Interface for styling of a Mancala Board 
 *
 */
public interface BoardStyle 
{
	Color getBoardColor(); // Gets the color of the board
	Color getPitColor(); // Gets the color of the pit button
	Shape getPitShape(); // Gets the shape of the 
	Dimension getPitDimension(); // Gets the dimensions of the pit button
	Dimension getStoreDimension(); // Gets the dimension of the store
	Font getTextFont(); // Gets the text font of the stone values in the pit
	
	/**
	 * Draws the specified pit or store
	 * @param g the graphics
	 * @param width the width
	 * @param height the height
	 */
	void draw(Graphics g, int width, int height);
	
	void fill(Graphics g, int width, int height);
}