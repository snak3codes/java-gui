package button_events;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ButtonColour {

	public static void main(String[] args) {
		ColourFrame frame = new ColourFrame();
		frame.addWindowListener(
				(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						System.exit(0);
					}
				})
			);
	}

}

class ColourFrame extends JFrame implements ActionListener {
	
	private JPanel pane;
	
	public ColourFrame() {
		super("Button Events");
		
		JButton colourButton = new JButton("Change Colour");
		colourButton.addActionListener(this);
		
		pane = (JPanel) getContentPane();
		pane.setLayout(new FlowLayout());
		pane.add(colourButton);
		
		setSize(300, 100);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		pane.setBackground(
				(new Color(strength(), strength(), strength())));
	}
	
	public static int strength() {
		return (int)(256 * Math.random());
	}
}
