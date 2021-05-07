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
		
		JButton endTurnButton = new JButton("End Turn");;
		endTurnButton.setEnabled(false); //disabled until first move made
		
		JButton undoButton = new JButton("Undo");
		undoButton.setEnabled(false);//disabled until first move made
		
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
        	final int position = i;
        	pit.addActionListener(new
        			ActionListener()
        			{
        				public void actionPerformed(ActionEvent event)
        				{
        					logic.playerMove(position);
        					if(logic.getPlayerMoved() && logic.getUndoAmount() != 0)
        					{
        						undoButton.setEnabled(true);//activates undo button after player has made a move
        						endTurnButton.setEnabled(true); //activates end turn button after player has made a move
        					}
        					else if(logic.getPlayerMoved())
        						endTurnButton.setEnabled(true); //activates end turn button after player has made a move
        				}
        			});
        	
        	mancalaModel.attach(pit);
        	secondRow.add(pit);
        }
        
        pit = new Pit(6, style.getPitShape(), style.getPitColor(), style.getStoreDimension());
        pit.setEnabled(false);
        playerAStore.add(pit);
        mancalaModel.attach(pit);
		
        for (int i = 12; i > 6; i--) {
        	pit = new Pit(i, style.getPitShape(), style.getPitColor(), style.getPitDimension());
        	final int position = i;
        	pit.addActionListener(new
        			ActionListener()
        			{
        				public void actionPerformed(ActionEvent event)
        				{
        					logic.playerMove(position);
        					if(logic.getPlayerMoved() && logic.getUndoAmount() != 0)
        					{
        						undoButton.setEnabled(true);//activates undo button after player has made a move
        						endTurnButton.setEnabled(true); //activates end turn button after player has made a move
        					}
        					else if(logic.getPlayerMoved())
        						endTurnButton.setEnabled(true); //activates end turn button after player has made a move
        				}
        			});
        	//pit.setEnabled(false);
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
        
        JPanel pitPanelB = new JPanel(new GridLayout(1, 6));
        String[] pitNamesB = {"B", "B6", "B5", "B4", "B3", "B2", "B1"};
        for (int i = 0; i < pitNamesB.length; i++) {
        	JLabel l = new JLabel(pitNamesB[i]);
        	pitPanelB.add(l, 1, i);
        }
        
        JPanel pitPanelA = new JPanel(new GridLayout(1, 6));
        String[] pitNamesA = {"A6", "A5", "A4", "A3", "A2", "A1", "A"};
        for (int i = 0; i < pitNamesA.length; i++) {
        	JLabel l = new JLabel(pitNamesA[i]);
        	pitPanelA.add(l, 1, i);
        }
        
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(pitPanelB, BorderLayout.NORTH);
        mainPanel.add(playerBStore, BorderLayout.WEST);
        mainPanel.add(rowPanel, BorderLayout.CENTER);
        mainPanel.add(playerAStore, BorderLayout.EAST);
        mainPanel.add(pitPanelA, BorderLayout.SOUTH);
        
        // added bottom panel consisting of the current player turn and an undo button
        JPanel bottomPanel = new JPanel();
        JLabel playerTurn = new JLabel("Current Turn: Player " + logic.getCurrentPlayerTurn()); // still needs to make it update to switch between players
        
        JLabel turnAmount = new JLabel("Turn " + logic.getAmountOfTurns());
        
        JLabel undoTries = new JLabel("Undos Left: " + logic.getUndoAmount());
        
        endTurnButton.addActionListener(new 
        		ActionListener()
        		{
		        	public void actionPerformed(ActionEvent event)
					{
		        		System.out.println("Pits in turn " + logic.getAmountOfTurns() + ": " + Arrays.toString(pits));
		        		logic.endTurn();
		        		playerTurn.setText("Current Turn: Player " + logic.getCurrentPlayerTurn());
		        		turnAmount.setText("Turn " + logic.getAmountOfTurns());
		        		undoTries.setText("Undos Left: " + logic.getUndoAmount());
		        		undoButton.setEnabled(false); //disables undo button, if enabled, until next player moves
		        		endTurnButton.setEnabled(false); //disables at end of turn
					}
        		});
        
        
    	undoButton.addActionListener(new
    			ActionListener()
    			{
    				public void actionPerformed(ActionEvent event)
    				{
    					if(logic.canUndo())
    						logic.undoMove();
    					undoTries.setText("Undos Left: " + logic.getUndoAmount());
    					undoButton.setEnabled(false);//disables undo button until next move made
    					endTurnButton.setEnabled(false); //disables end turn button if player undoes their move
    				}
    			});
        
        bottomPanel.add(playerTurn);
        bottomPanel.add(endTurnButton);
        bottomPanel.add(turnAmount);
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
