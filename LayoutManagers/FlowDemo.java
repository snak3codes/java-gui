package flow_layout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FlowDemo {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Flow Layout");
		frame.addWindowListener(
				(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						System.exit(0);
					}
				})
			);
		frame.setSize(400, 100);
		JPanel pane = (JPanel) frame.getContentPane();
		pane.setLayout(new FlowLayout());
		pane.add(new JButton("A"));
		pane.add(new JButton("B"));
		pane.add(new JButton("C"));
		pane.add(new JButton("D"));
		pane.add(new JButton("E"));
		
		frame.setVisible(true);
		
		
	}

}
