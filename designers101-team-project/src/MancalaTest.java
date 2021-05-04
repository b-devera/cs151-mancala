import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class MancalaTest {
	public static void main(String[] args) {
		int[] pits = new int[14];
		
		MancalaModel model = new MancalaModel(pits);
		MancalaFrame mancalaFrame = new MancalaFrame(model);
		model.attach(mancalaFrame);
	}
}
