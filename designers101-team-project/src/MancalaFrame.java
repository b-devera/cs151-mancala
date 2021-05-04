import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

public class MancalaFrame extends JFrame implements ChangeListener {
	private MancalaModel mancalaModel;
	private GameLogic logic;
	private int[] pits;
	
	private static final int ICON_WIDTH = 600;
	private static final int ICON_HEIGHT = 400;
	
	public MancalaFrame(MancalaModel mancalaModel) {
		this.mancalaModel = mancalaModel;
		pits = mancalaModel.getPits();
		logic = new GameLogic(mancalaModel);
		
		setTitle("Designers101 Mancala Game!");
		setSize(ICON_WIDTH, ICON_HEIGHT);
		
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
						mancalaModel.setStyle(new BoardStyleA());
					}
				});
		
		//Creates button for styleB and sets the style when pressed
		JButton styleButtonB = new JButton("Style B");
		styleButtonB.addActionListener(new
				ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{
						mancalaModel.setStyle(new BoardStyleB());
					}
				});
		
		stylePanel.add(styleChoiceLabel);
		stylePanel.add(styleButtonA);
		stylePanel.add(styleButtonB);
		
		//Below code for boardArea sets a basic game board for example display
		boardArea.setText(boardArea.getText() + "---------------------------------------------------------\n");
		boardArea.setText(boardArea.getText() + "|      |  B6  |  B5  |  B4  |  B3  |  B2  |  B1  |      |\n");
		boardArea.setText(boardArea.getText() + "|      |   4  |   4  |   4  |   4  |   4  |   4  |      |\n");
		boardArea.setText(boardArea.getText() + "|  B   |-----------------------------------------|  A   |\n");
		boardArea.setText(boardArea.getText() + "|  0   |-----------------------------------------|  0   |\n");
		boardArea.setText(boardArea.getText() + "|      |  A1  |  A2  |  A3  |  A4  |  A5  |  A6  |      |\n");
		boardArea.setText(boardArea.getText() + "|      |   4  |   4  |   4  |   4  |   4  |   4  |      |\n");
		boardArea.setText(boardArea.getText() + "---------------------------------------------------------\n");
		
		add(titlePanel, BorderLayout.CENTER);
		add(stylePanel, BorderLayout.NORTH);
		add(boardArea, BorderLayout.SOUTH);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
		pits = mancalaModel.getPits();
		repaint();
	}

}
