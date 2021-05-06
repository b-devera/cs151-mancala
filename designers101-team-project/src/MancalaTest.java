import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;

public class MancalaTest {
	public static void main(String[] args) {
		OptionDialog options = new OptionDialog();
		options.showInitialDialog();
		
		MancalaModel model = new MancalaModel(options.getInitialStones() == 0 ? 3 : 4); // creates model with either 3 or 4 stones in each pit
		MancalaFrame mancalaFrame = new MancalaFrame(model, options.getBoardStyleMenu().getSelectedItem().equals("Board Style A") ? 
				model.setStyle(new BoardStyleA()) : model.setStyle(new BoardStyleB())); // sets the style depending on the option chosen in the combo box
		model.attach(mancalaFrame);
		System.out.println("Initial pit values: " + Arrays.toString(model.pits));
	}
}
