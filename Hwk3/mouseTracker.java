import java.awt.event.*;
import acm.graphics.*;
import acm.program.*;



public class mouseTracker extends GraphicsProgram {
		
	public void run() {
		coords = new GLabel (" ");
		coords.setFont("TimesNewRoman-36");
		add(coords, 50, 50);
		
		addMouseListeners();
	}
	
	public void mouseMoved (MouseEvent e) {
		coords.setLabel("( " + e.getX() + " ; " + e.getY() + " )");
	}
	
	private GLabel coords;
	
}