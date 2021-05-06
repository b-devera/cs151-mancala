import java.awt.BorderLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class OptionDialog {
	private JComboBox<String[]> boardStyleMenu;
	private int initialStone;
	
	/**
	 * Shows the inital setup dialog where the player can choose board styles and number of stones in each pit
	 */
	public void showInitialDialog() {
		JPanel initialScreen = new JPanel(new BorderLayout());
		
		JLabel boardStyleLabel = new JLabel("Select board style: ");
		
		String[] boardStyles = {"Board Style A", "Board Style B"};
        boardStyleMenu = new JComboBox(boardStyles);
        
        JLabel initialStoneLabel = new JLabel("Select the number of stones per pit: ");
        
        initialScreen.add(boardStyleLabel, BorderLayout.NORTH);
        initialScreen.add(boardStyleMenu, BorderLayout.CENTER);
        initialScreen.add(initialStoneLabel, BorderLayout.SOUTH);
        
		String[] initialStoneValues = {"3", "4"};
		initialStone = JOptionPane.showOptionDialog(null, initialScreen, "Designers101 Mancala Game!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, initialStoneValues, initialStoneValues[1]);
	}
	
	/**
	 * Gets the combo box for the different board styles
	 * @return boardStyleMenu the board style menu
	 */
	public JComboBox<String[]> getBoardStyleMenu() {
		return boardStyleMenu;
	}
	
	/**
	 * Gets the stone number selected from the option dialog
	 * @return initialStone the selected stone number
	 */
	public int getInitialStones() {
		return initialStone;
	}
}
