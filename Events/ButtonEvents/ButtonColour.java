package button_events;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ButtonColour {

	public static void main(String[] args) {
		ColorApp();
		TriColorApp();
		BrightnessApp();
	}

	public static void ColorApp() {
		ColourFrame colourFrame = new ColourFrame();
		handleExit(colourFrame);
	}

	public static void TriColorApp() {
		TriColourFrame triFrame = new TriColourFrame();
		handleExit(triFrame);
	}

	public static void BrightnessApp() {
		BrightnessFrame brightFrame = new BrightnessFrame();
		handleExit(brightFrame);

	}

	public static void handleExit(JFrame frame) {
		frame.addWindowListener((new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		}));
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
		pane.setBackground((new Color(strength(), strength(), strength())));

	}

	public static int strength() {
		return (int) (256 * Math.random());
	}
}

class TriColourFrame extends JFrame implements ActionListener {

	private JPanel pane;

	public TriColourFrame() {
		super("Tricolour Buttons");

		JButton redButton = new JButton("red");
		redButton.addActionListener(this);
		JButton greenButton = new JButton("green");
		greenButton.addActionListener(this);
		JButton blueButton = new JButton("blue");
		blueButton.addActionListener(this);

		pane = (JPanel) getContentPane();
		pane.setLayout(new FlowLayout());
		pane.add(redButton);
		pane.add(greenButton);
		pane.add(blueButton);

		setSize(300, 100);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("red"))
			pane.setBackground(Color.red);
		else if (e.getActionCommand().equals("green"))
			pane.setBackground(Color.green);
		else if (e.getActionCommand().equals("blue"))
			pane.setBackground(Color.blue);
		else
			pane.setBackground(Color.black);
	}
}

class BrightnessFrame extends JFrame implements ActionListener {

	private JPanel pane;

	public BrightnessFrame() {
		super("Brightness Buttons");

		JButton yesButton = new JButton("Yes");
		yesButton.addActionListener(this);
		JButton noButton = new JButton("No");
		noButton.addActionListener(this);

		pane = (JPanel) getContentPane();
		pane.setLayout(new FlowLayout());
		pane.add(yesButton);
		pane.add(noButton);

		setSize(300, 100);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Yes"))
			pane.setBackground(Color.white);
		else if (e.getActionCommand().equals("No"))
			pane.setBackground(Color.black);
		else
			pane.setBackground(Color.gray);
	}
}
