package mouse_events;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseCircles {

	public static void main(String[] args) {
		CircleFrame frame = new CircleFrame();
		handleExit(frame);
	}
	
	public static void handleExit(JFrame frame) {
		frame.addWindowListener(
				(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						System.exit(0);
					}
				})
			);
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
	
	public void paint (Graphics g) { // Draws a filled circular region with radius RADIUS
		g.setColor(Color.blue);
		g.fillOval(x-RADIUS, y-RADIUS, 2*RADIUS, 2*RADIUS);
	}
	
}
