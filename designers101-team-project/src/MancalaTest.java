import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class MancalaTest {
	public static void main(String[] args) {
		ArrayList<Integer> pits = new ArrayList<Integer>();
		
		pits.add(new Integer(4));
		pits.add(new Integer(4));
		pits.add(new Integer(4));
		pits.add(new Integer(4));
		pits.add(new Integer(4));
		pits.add(new Integer(4));
		pits.add(new Integer(0));
		pits.add(new Integer(4));
		pits.add(new Integer(4));
		pits.add(new Integer(4));
		pits.add(new Integer(4));
		pits.add(new Integer(4));
		pits.add(new Integer(4));
		pits.add(new Integer(0));
		
		MancalaBoard model = new MancalaBoard(pits);
		MancalaFrame mancalaFrame = new MancalaFrame(model);
		model.attach(mancalaFrame);
	}
}
