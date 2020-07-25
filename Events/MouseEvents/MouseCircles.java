package mouse_events;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseCircles {

	public static void main(String[] args) {
		CircleFrame frame = new CircleFrame();
		CircleFrame2 frame2 = new CircleFrame2();
		CircleFrame3 frame3 = new CircleFrame3();
		
		handleExit(frame);
		handleExit(frame2);
		handleExit(frame3);
	}

	/*
	 * Here the anonymous inner class extends the WindowAdapter class which contains
	 * trivial versions of all seven method required to implement the WindowListener
	 * interface. The only one of these methods that we want to override is 
	 * windowClosing which we rewrite so that it executes the statement
	 * System.exit(0), causing the program to halt.
	 */
	public static void handleExit(JFrame frame) {
		frame.addWindowListener((new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		}));
	}

}

// The implements clause promises that the CircleFrame class contains all the methods
// of the MouseListener interface
class CircleFrame extends JFrame implements MouseListener {

	private int x; // X-coordinate of the centre of the circular regions drawn
	private int y; // Y-coordinate of the centre of the circular regions drawn
	private static final int RADIUS = 10;

	public CircleFrame() {
		super("Mouse Droppings");
		// We want the region to listen to events occurring within itself!
		addMouseListener(this); // Add current component object to the list of mouse listeners
		setSize(400, 400);
		setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) { // Obtains the coordinates of the location of a mouse click
		x = e.getX();
		y = e.getY();
		repaint(); // Ask Java to schedule the component for painting
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void paint(Graphics g) { // Draws a filled circular region with radius RADIUS
		g.setColor(Color.blue);
		g.fillOval(x - RADIUS, y - RADIUS, 2 * RADIUS, 2 * RADIUS);
	}

}

class CircleFrame2 extends JFrame {

	private int x;
	private int y;
	private static final int RADIUS = 10;

	public CircleFrame2() {
		super("Mouse Droppings 2");
		addMouseListener(new ClickHandler());
		setSize(400, 400);
		setVisible(true);
	}

	/*
	 * We no longer have the clause implements MouseListener in the header of either
	 * of our classes. This is because the implementation of MouseListener is done
	 * in the MouseAdapter class. The constructor of the CircleFrame2 class has been
	 * changed; it now calls the constructor of the ClickHandler class to create a
	 * new ClickHandler object and then puts that object on the mouse listener's
	 * list of objects to be informed of mouse events
	 * 
	 */
	class ClickHandler extends MouseAdapter { // Inside class to control x and y

		public void mouseClicked(MouseEvent e) {
			x = e.getX();
			y = e.getY();
			repaint();
		}
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(Color.blue);
		g.fillOval(x - RADIUS, y - RADIUS, 2 * RADIUS, 2 * RADIUS);
	}
}

class CircleFrame3 extends JFrame {

	private int x;
	private int y;
	private static final int RADIUS = 10;

	public CircleFrame3() {
		super("Mouse Droppings 3");
		/*
		 * We interpret the argument of the call to the addMouseListener method as
		 * follows: "Construct an object of the class that extends the class
		 * MouseAdapter and give it a mouseClicked method that overrides the one 
		 * that exists in MouseAdapter."
		 */
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				x = e.getX();
				y = e.getY();
				repaint();
			}
		});
		setSize(400, 400);
		setVisible(true);
	}

	public void paint(Graphics g) {
		g.setColor(Color.blue);
		g.fillOval(x - RADIUS, y - RADIUS, 2 * RADIUS, 2 * RADIUS);
	}
}
