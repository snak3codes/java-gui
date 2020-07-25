package simple_calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleCalculator {

	public static void main(String[] args) {
		CalculatorFrame frame = new CalculatorFrame();
		frame.addWindowListener((new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		}));
	}

}

class CalculatorFrame extends JFrame implements ActionListener {

	private JTextField firstValue;
	private JTextField secondValue;
	private JTextField resultValue;

	public CalculatorFrame() {

		JPanel pane = (JPanel) getContentPane();
		pane.setLayout(new BorderLayout());

		firstValue = new JTextField(10);
		secondValue = new JTextField(10);
		resultValue = new JTextField(10);
		resultValue.setEditable(false);

		JPanel inFieldPane = new JPanel();

		inFieldPane.setLayout(new GridLayout(3, 2));

		inFieldPane.add(new JLabel("First Value"));
		inFieldPane.add(firstValue);
		firstValue.addActionListener(this);

		inFieldPane.add(new JLabel("Second Value"));
		inFieldPane.add(secondValue);
		secondValue.addActionListener(this);

		inFieldPane.add(new JLabel("Result"));
		inFieldPane.add(resultValue);

		pane.add(inFieldPane, BorderLayout.NORTH);

		// Add Clear Button
		JPanel clearField = new JPanel();

		clearField.setLayout(new FlowLayout());

		JButton clearButton = new JButton("Clear");
		clearField.add(clearButton);
		clearButton.addActionListener(this);

		pane.add(clearField, BorderLayout.CENTER);

		// Add Operator Buttons
		JPanel operatorField = new JPanel();

		operatorField.setLayout(new FlowLayout());

		// Create buttons
		JButton addButton = new JButton("+");
		addButton.addActionListener(this);
		JButton subtractButton = new JButton("-");
		subtractButton.addActionListener(this);
		JButton multiplyButton = new JButton("*");
		multiplyButton.addActionListener(this);
		JButton divideButton = new JButton("/");
		divideButton.addActionListener(this);

		operatorField.add(addButton);
		operatorField.add(subtractButton);
		operatorField.add(multiplyButton);
		operatorField.add(divideButton);

		pane.add(operatorField, BorderLayout.SOUTH);

		pack();
		setSize(330, 172);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("Clear")) {
			firstValue.setText("");
			secondValue.setText("");
			resultValue.setText("");
		}

		double result = 0;

		if (e.getActionCommand().equals("+")) {
			result = Double.parseDouble(firstValue.getText().trim()) + Double.parseDouble(secondValue.getText().trim());
			resultValue.setText(String.valueOf(result));
		} else if (e.getActionCommand().equals("-")) {
			result = Double.parseDouble(firstValue.getText().trim()) - Double.parseDouble(secondValue.getText().trim());
			resultValue.setText(String.valueOf(result));
		} else if (e.getActionCommand().equals("*")) {
			result = Double.parseDouble(firstValue.getText().trim()) * Double.parseDouble(secondValue.getText().trim());
			resultValue.setText(String.valueOf(result));
		} else if (e.getActionCommand().equals("/")) {
			result = Double.parseDouble(firstValue.getText().trim()) / Double.parseDouble(secondValue.getText().trim());
			resultValue.setText(String.valueOf(result));
		}

	}
}
