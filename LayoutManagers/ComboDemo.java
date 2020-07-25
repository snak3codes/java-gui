package layout_combo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class ComboDemo {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Combo Layout");
		frame.addWindowListener(
				(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						System.exit(0);
					}
				})
			);
		
		frame.setSize(600, 250);
		
		JPanel pane = (JPanel) frame.getContentPane();
		pane.setLayout(new GridLayout(2, 2));
		pane.add(new JButton("A"));
		
		JPanel borderPane = new JPanel();
		borderPane.setLayout(new BorderLayout());
		borderPane.add(new JButton("B-Center"), BorderLayout.CENTER);
		borderPane.add(new JButton("B-West"), BorderLayout.WEST);
		borderPane.add(new JButton("B-East"), BorderLayout.EAST);
		borderPane.add(new JButton("B-North"), BorderLayout.NORTH);
		borderPane.add(new JButton("B-South"), BorderLayout.SOUTH);
		
		pane.add(borderPane);
		
		JPanel flowPane = new JPanel();
		flowPane.setLayout(new FlowLayout());
		flowPane.add(new JButton("C-1"));
		flowPane.add(new JButton("C-2"));
		flowPane.add(new JButton("C-3"));
		flowPane.add(new JButton("C-4"));
		flowPane.add(new JButton("C-5"));
		flowPane.add(new JButton("C-6"));
		flowPane.add(new JButton("C-7"));
		
		pane.add(flowPane);
		
		pane.add(new JButton("D"));
		
		frame.setVisible(true);
		
	}

}
