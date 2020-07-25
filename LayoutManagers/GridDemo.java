package grid_layout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GridDemo {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Grid Layout");
		frame.addWindowListener(
				(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						System.exit(0);
					}
				})
			);
		frame.setSize(200, 100);
		JPanel pane = (JPanel) frame.getContentPane();
		pane.setLayout(new GridLayout(3, 2)); // Grid should have 3 rows and 2 columns
		// NOTE: (3, 0) and (3, 10) would have produced the same result (columns irrelevant)
		
		// Components are placed in a row major order
		pane.add(new JButton("A"));
		pane.add(new JButton("B"));
		pane.add(new JButton("C"));
		pane.add(new JButton("D"));
		pane.add(new JButton("E"));
		frame.setVisible(true);
		
	}
	

}
