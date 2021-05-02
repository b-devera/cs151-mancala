import java.awt.*;
import java.awt.font.*;
import java.awt.geom.Rectangle2D;
import javax.swing.*;

/**
 * 
 * A panel for displaying the game title and designer names
 * (In Development)
 */
class TitlePanel extends JPanel
{
	public void paintComponent(Graphics g)
	{
		
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		String titleLine1 = "Designers101 Mancala Game! (In Development)";
		String titleLine2 = "Designed by Berlun Devera, Brandon Russell, and Sweta Pradhan";
		
		//Configuring the first title line
		Font font = new Font("Serif", Font.BOLD, 24);
		g2.setFont(font);
		
		//Measures the message size
		FontRenderContext titleContext = g2.getFontRenderContext();
		Rectangle2D titleBounds = font.getStringBounds(titleLine1, titleContext);
		
		double baseX = (getWidth() - titleBounds.getWidth())/2;
		double y = (getHeight() - titleBounds.getHeight())/2;
		
		double ascentLeading = -titleBounds.getY();
		double baseY = y - ascentLeading;
		
		//Configuring the second title line
		Font font2 = new Font("Serif", Font.BOLD, 12);
		g2.setFont(font2);
		
		//Measures the message size
		FontRenderContext title2Context = g2.getFontRenderContext();
		Rectangle2D title2Bounds = font.getStringBounds(titleLine2, title2Context);
		
		double baseX2 = (getWidth() - title2Bounds.getWidth())/2 + titleBounds.getWidth()/2;
		double y2 = (getHeight() - title2Bounds.getHeight())/2 +25;
		
		double ascentLeading2 = -title2Bounds.getY();
		double baseY2 = y2 - ascentLeading2;
		
		g2.setColor(Color.LIGHT_GRAY);
		g2.drawString(titleLine1, (int) baseX, (int) baseY);
		g2.drawString(titleLine2, (int) baseX2, (int) baseY2);
	}
}