import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;

public class MancalaTest {
	public static void main(String[] args) {
		int[] initialPitValues = { 3, 4 };
		// need to add JButtons to decide the initial number of stones in each pit
		MancalaModel model = new MancalaModel(4);
		BoardStyle initialStyle = new BoardStyleB();
		MancalaFrame mancalaFrame = new MancalaFrame(model, initialStyle);
		model.attach(mancalaFrame);
		System.out.println("Initial pit values: " + Arrays.toString(model.pits));
	}
}
