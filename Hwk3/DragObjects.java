import java.awt.event.*;
import acm.graphics.*;
import acm.program.*;
import acm.util.RandomGenerator;

public class DragObjects extends GraphicsProgram {
	
	private static final double W = 60;
	private static final double H = 60;
	
	public void run () {
		GRect rect = new GRect (100, 100, 150, 150);
		rect.setFilled(true);
		add (rect);
		
		GOval oval = new GOval (200, 200, 100, 100);
		oval.setFilled(true);
		add (oval);
		
		coords = new GLabel (" ");
		coords.setFont("TimesNewRoman-36");
		add(coords, 50, 50);
		
		addMouseListeners();
		addKeyListeners();
	}
	
	public void mousePressed (MouseEvent e) {
		last = new GPoint (e.getPoint());
		gobj = getElementAt (last);
	}
	
	public void mouseDragged (MouseEvent e) {
		if (gobj!=null) {
			gobj.move(e.getX()-last.getX(), e.getY()-last.getY());
			last = new GPoint (e.getPoint());
		}
	}
	
	public void mouseClicked (MouseEvent e) {
		if (gobj==null) {
			GFace face = new GFace (W,H);
			add (face, e.getX()-W/2, e.getY()-H/2);	
		}
	}
	
	public void mouseMoved (MouseEvent e) {
		coords.setLabel("( " + e.getX() + " ; " + e.getY() + " )");
	}
	
	public void keyTyped(KeyEvent e) {
		
		if (gobj!=null) {
			gobj.setColor(rgen.nextColor());
		}
	}
	
	
	private GPoint last;
	private GObject gobj;
	private GLabel coords;
	RandomGenerator rgen = RandomGenerator.getInstance();
}
