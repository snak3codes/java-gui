/*
 * Drawing Text in Java
 * @author: snak3codes
 */
 
 package drawing_text;

// Tells the compiler we will be using certain classes in other packages
/*import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Font;*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUIGreet {

	// main function
	public static void main(String[] args) {

		JFrame frame = new JFrame("Graphical Greeting");
		/*
		 * Creates the windows by constructing a JFrame object that we have called
		 * frame. A JFrame object acts as a top-level container for other objects. The
		 * string argument of the JFrame constructor defines the window title
		 */

		/*
		 * Causes the program to terminate when the window defined by frame is closed
		 * Required import: WindowEvent
		 */
		frame.addWindowListener((new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		}));

		frame.setSize(400, 100); // Sets the dimensions of the window that will be displayed

		/*
		 * In order to manage the contents of a window, frames delegate the
		 * responsibility to a content pane, an object that is automatically associated
		 * with each frame. NOTE: The getContentPane method returns a reference to a
		 * Container object; we can cast this to a JPanel object reference because
		 * JPanel is a subclass of JComponent which is a subclass of Container
		 */
		JPanel pane = (JPanel) frame.getContentPane();

		pane.add(new Greeting()); // Construct a new Greeting object and add it to the pane of the window

		frame.setVisible(true); // Required to enable us to see the image
	}

} // end of main

@SuppressWarnings("serial")
/*
 * The class Greeting is defined to be a subclass of the class JComponent, in
 * order to use its paint method
 */
class Greeting extends JComponent {

	public Greeting() {
		// Calls the repaint method which in turn calls the paint method to draw the
		// image
		repaint();
	}

	// Overrides the paint method of the JComponent class so that it will paint
	// whatever we want on our component
	@Override
	public void paint(Graphics g) {
		// Creates a new Font object
		Font monoFont = new Font("Serif", Font.BOLD + Font.ITALIC, 40);
		// Apply the font to a Graphics object
		g.setFont(monoFont);
		// Draws the contents of the string "Hello, world"
		g.drawString("Hello, world", 100, 50);
	}
}
