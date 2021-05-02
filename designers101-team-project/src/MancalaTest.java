import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MancalaTest {
	public static void main(String[] args) {
		MancalaBoard mancalaBoard = new MancalaBoard();
		Player[] players = new Player[2];
		mancalaBoard.printExampleBoard();
		
		//All code below configures initial game screen (In Development)
		JFrame frame = new JFrame();
		frame.setTitle("Designers101 Mancala Game!");
		frame.setSize(600, 400);
		
		TitlePanel titlePanel = new TitlePanel();
		titlePanel.setBackground(Color.BLUE);
		
		JPanel stylePanel = new JPanel();
		
		JLabel styleChoiceLabel = new JLabel("Choose Board Style:");
		
		JTextPane boardArea = new JTextPane();
		boardArea.setEditable(false);
		
		//Creates button for styleA and sets the style when pressed
		JButton styleButtonA = new JButton("Style A");
		styleButtonA.addActionListener(new
				ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{
						mancalaBoard.setStyle(new BoardStyleA());
					}
				});
		
		//Creates button for styleB and sets the style when pressed
		JButton styleButtonB = new JButton("Style B");
		styleButtonB.addActionListener(new
				ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{
						mancalaBoard.setStyle(new BoardStyleB());
					}
				});
		
		stylePanel.add(styleChoiceLabel);
		stylePanel.add(styleButtonA);
		stylePanel.add(styleButtonB);
		
		//Below code for boardArea sets a basic game board for example display
		boardArea.setText("---------------------------------------------------------\n");
		boardArea.setText(boardArea.getText() + "|      |  B6  |  B5  |  B4  |  B3  |  B2  |  B1  |      |\n");
		boardArea.setText(boardArea.getText() + "|      |   4  |   4  |   4  |   4  |   4  |   4  |      |\n");
		boardArea.setText(boardArea.getText() + "|  B   |-----------------------------------------|  A   |\n");
		boardArea.setText(boardArea.getText() + "|  0   |-----------------------------------------|  0   |\n");
		boardArea.setText(boardArea.getText() + "|      |  A1  |  A2  |  A3  |  A4  |  A5  |  A6  |      |\n");
		boardArea.setText(boardArea.getText() + "|      |   4  |   4  |   4  |   4  |   4  |   4  |      |\n");
		boardArea.setText(boardArea.getText() + "---------------------------------------------------------\n");
		
		frame.add(titlePanel, BorderLayout.CENTER);
		frame.add(stylePanel, BorderLayout.NORTH);
		frame.add(boardArea, BorderLayout.SOUTH);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
