import acm.program.*;
import java.awt.event.*;



public class ClickForFace extends GraphicsProgram {
	
	private static final double W = 60;
	private static final double H = 60;
	
	
	public void run() {
		addMouseListeners();
	}
	
	
	public void mouseClicked (MouseEvent e) {
		GFace face = new GFace (W,H);
		add (face, e.getX()-W/2, e.getY()-H/2);	
	}
	

	
}
