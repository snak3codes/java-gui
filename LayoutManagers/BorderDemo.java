package border_layout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BorderDemo {

	public static void main(String[] args) {
		demoEllipse();
		demoMethod();
	}

	public static void demoMethod() {
		JFrame frame = new JFrame("Border Layout");
		frame.setLocationRelativeTo(null);
		frame.addWindowListener((new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		}));
		frame.setSize(300, 200);
		JPanel pane = (JPanel) frame.getContentPane();
		pane.add(new JButton("Center"), BorderLayout.CENTER);
		pane.add(new JButton("West"), BorderLayout.WEST);
		pane.add(new JButton("East"), BorderLayout.EAST);
		pane.add(new JButton("North"), BorderLayout.NORTH);
		pane.add(new JButton("South"), BorderLayout.SOUTH);
		frame.setVisible(true);
	}

	public static void demoEllipse() {
		JFrame frame = new JFrame("Graphics & Buttons");
		frame.addWindowListener((new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		}));
		frame.setSize(200, 200);
		JPanel pane = (JPanel) frame.getContentPane();
		pane.add(new Picture(), BorderLayout.CENTER);
		pane.add(new JButton("Start"), BorderLayout.NORTH);
		pane.add(new JButton("Stop"), BorderLayout.SOUTH);
		frame.setVisible(true);
	}
}

class Picture extends JComponent {
	public Picture() {
		repaint();
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(Color.blue);
		g.fillOval(getWidth() / 4, getHeight() / 4, getWidth() / 2, getHeight() / 2);
	}
}
