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
	
	public MancalaFrame(MancalaModel mancalaModel, BoardStyle style) {
		this.mancalaModel = mancalaModel;
		pits = mancalaModel.getPits();
		logic = new GameLogic(mancalaModel);
		
		//TitlePanel titlePanel = new TitlePanel();
		//titlePanel.setBackground(Color.GRAY);
		
		JPanel stylePanel = new JPanel();
		JLabel styleChoiceLabel = new JLabel("Choose Board Style:");
		
		//Creates button for styleA and sets the style when pressed
		JButton styleButtonA = new JButton("Style A");
		styleButtonA.addActionListener(new
				ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{
						mancalaModel.setStyle(new BoardStyleA());
						repaint();
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
						repaint();
					}
				});
		
		stylePanel.add(styleChoiceLabel);
		stylePanel.add(styleButtonA);
		stylePanel.add(styleButtonB);
		
		JPanel firstRow = new JPanel();
        firstRow.setLayout(new GridLayout(1, 6));

        JPanel playerAStore = new JPanel();

        JPanel secondRow = new JPanel();
        secondRow.setLayout(new GridLayout(1, 6));

        JPanel playerBStore = new JPanel();
        
        Pit pit;
        
        for (int i = 0; i < 6; i++) {
        	pit = new Pit(i, style.getPitShape(), style.getPitColor(), style.getPitDimension());
        	// add action listener
        	mancalaModel.attach(pit);
        	secondRow.add(pit);
        }
        
        pit = new Pit(6, style.getPitShape(), style.getPitColor(), style.getStoreDimension());
        pit.setEnabled(false);
        playerAStore.add(pit);
        mancalaModel.attach(pit);
		
        for (int i = 12; i > 6; i--) {
        	pit = new Pit(i, style.getPitShape(), style.getPitColor(), style.getPitDimension());
        	// add action listener
        	mancalaModel.attach(pit);
        	firstRow.add(pit);
        }
        
        pit = new Pit(13, style.getPitShape(), style.getPitColor(), style.getStoreDimension());
        pit.setEnabled(false);
        playerBStore.add(pit);
        mancalaModel.attach(pit);
		
		//Below code for boardArea sets a basic game board for example display
		//boardArea.setText(boardArea.getText() + "---------------------------------------------------------\n");
		//boardArea.setText(boardArea.getText() + "|      |  B6  |  B5  |  B4  |  B3  |  B2  |  B1  |      |\n");
		//boardArea.setText(boardArea.getText() + "|      |   4  |   4  |   4  |   4  |   4  |   4  |      |\n");
		//boardArea.setText(boardArea.getText() + "|  B   |-----------------------------------------|  A   |\n");
		//boardArea.setText(boardArea.getText() + "|  0   |-----------------------------------------|  0   |\n");
		//boardArea.setText(boardArea.getText() + "|      |  A1  |  A2  |  A3  |  A4  |  A5  |  A6  |      |\n");
		//boardArea.setText(boardArea.getText() + "|      |   4  |   4  |   4  |   4  |   4  |   4  |      |\n");
		//boardArea.setText(boardArea.getText() + "---------------------------------------------------------\n");
		
		//add(titlePanel, BorderLayout.CENTER);
        JPanel rowPanel = new JPanel();
        rowPanel.setLayout(new GridLayout(2, 1));
        rowPanel.add(firstRow);
        rowPanel.add(secondRow);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(playerBStore, BorderLayout.WEST);
        mainPanel.add(rowPanel, BorderLayout.CENTER);
        mainPanel.add(playerAStore, BorderLayout.EAST);
        
        JFrame frame = new JFrame();
        frame.setTitle("Designers101 Mancala Game!");
        frame.setLayout(new BorderLayout());
		frame.add(stylePanel, BorderLayout.NORTH);
		frame.add(mainPanel, BorderLayout.CENTER);
		//add(boardArea, BorderLayout.SOUTH);
		frame.getContentPane().setBackground(style.getBoardColor());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
		pits = mancalaModel.getPits();
		repaint();
	}

}
