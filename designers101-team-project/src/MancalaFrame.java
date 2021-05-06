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
	
	/**
	 * Constructor for the MancalaFrame class
	 * @param mancalaModel the model used to attach to the frame
	 * @param style the BoardStyle chosen
	 */
	public MancalaFrame(MancalaModel mancalaModel, BoardStyle style) {
		this.mancalaModel = mancalaModel;
		pits = mancalaModel.getPits();
		logic = new GameLogic(mancalaModel);
		
		TitlePanel titlePanel = new TitlePanel();
		titlePanel.setBackground(Color.GRAY);
		
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
		
        JPanel rowPanel = new JPanel();
        rowPanel.setLayout(new GridLayout(2, 1));
        rowPanel.add(firstRow);
        rowPanel.add(secondRow);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(titlePanel);
        mainPanel.add(playerBStore, BorderLayout.WEST);
        mainPanel.add(rowPanel, BorderLayout.CENTER);
        mainPanel.add(playerAStore, BorderLayout.EAST);
        
        // added bottom panel consisting of the current player turn and an undo button
        JPanel bottomPanel = new JPanel();
        JLabel playerTurn = new JLabel("Current Turn: Player 1"); // still needs to make it update to switch between players
        JButton undoButton = new JButton("Undo");
        JLabel undoTries = new JLabel("Undos Left: 3");
        bottomPanel.add(playerTurn);
        bottomPanel.add(undoButton);
        bottomPanel.add(undoTries);
        
        JFrame frame = new JFrame();
        frame.setTitle("Designers101 Mancala Game!");
        frame.setLayout(new BorderLayout());
		frame.add(mainPanel, BorderLayout.CENTER);
		frame.add(bottomPanel, BorderLayout.SOUTH);
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
