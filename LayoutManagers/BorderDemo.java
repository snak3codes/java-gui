package border_layout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BorderDemo {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Border Layout");
		frame.addWindowListener(
				(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						System.exit(0);
					}
				})
			);
		frame.setSize(300, 200);
		JPanel pane = (JPanel) frame.getContentPane();
		pane.add(new JButton("Center"), BorderLayout.CENTER);
		pane.add(new JButton("West"), BorderLayout.WEST);
		pane.add(new JButton("East"), BorderLayout.EAST);
		pane.add(new JButton("North"), BorderLayout.NORTH);
		pane.add(new JButton("South"), BorderLayout.SOUTH);
		frame.setVisible(true);
	}

}
