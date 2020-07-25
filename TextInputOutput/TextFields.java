package text_fields;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TextFields {

	public static void main(String[] args) {

		NameFrame frame = new NameFrame();
		frame.addWindowListener((new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		}));

	}

}

class NameFrame extends JFrame implements ActionListener {

	private JTextField givenName;
	private JTextField familyName;
	private JTextField fullName;

	public NameFrame() {
		super("Text Fields");

		// Organize content pane
		JPanel pane = (JPanel) getContentPane();
		pane.setLayout(new BorderLayout());

		// Create fields for I/O
		givenName = new JTextField(10);
		familyName = new JTextField(10);
		fullName = new JTextField(10);
		fullName.setEditable(false);

		// Add labelled input fields to display
		JPanel inFieldPane = new JPanel();

		inFieldPane.setLayout(new GridLayout(2, 2));

		inFieldPane.add(new JLabel("Given Name"));
		inFieldPane.add(givenName);
		givenName.addActionListener(this);

		inFieldPane.add(new JLabel("Family Name"));
		inFieldPane.add(familyName);
		familyName.addActionListener(this);

		pane.add(inFieldPane, BorderLayout.NORTH);

		// Add submission button
		JPanel submitPane = new JPanel();

		submitPane.setLayout(new FlowLayout());

		submitPane.add(new JLabel("Press Button to Enter Name"));
		JButton submitButton = new JButton("Submit");
		submitButton.addActionListener(this);
		submitPane.add(submitButton);

		pane.add(submitPane, BorderLayout.CENTER);

		// Add Output fields
		JPanel outFieldPane = new JPanel();

		outFieldPane.setLayout(new GridLayout(1, 2));

		outFieldPane.add(new JLabel("Full Name"));
		outFieldPane.add(fullName);
		pane.add(outFieldPane, BorderLayout.SOUTH);

		// Display the final product
		pack();
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {

		// Display full name if and only if button was pushed
		if (e.getActionCommand().equals("Submit")) {
			String fullString = familyName.getText().trim() + ",  " + givenName.getText().trim();
			fullName.setText(fullString);
		}
	}
}
