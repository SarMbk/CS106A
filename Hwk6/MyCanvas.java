import acm.graphics.*;
import java.awt.event.*;


public class MyCanvas extends GCanvas
			implements ComponentListener{
	
	public MyCanvas(){
		addComponentListener(this);
		rect = new GRect(BOX_WIDTH, BOX_HEIGHT);
		rect.setFilled(true);
		
	}
	
	public void update(){
		removeAll();
		add(rect, (getWidth()-BOX_WIDTH)/2, (getHeight()-BOX_HEIGHT)/2);
	}

	
	
	public void componentResized (ComponentEvent e) {update();}
	public void componentHidden (ComponentEvent e) { }
	public void componentMoved (ComponentEvent e) { }
	public void componentShown (ComponentEvent e) { }
	
	
	
	private static final double BOX_WIDTH = 100.0;
	private static final double BOX_HEIGHT = 100.0;
	
	
	private GRect rect;
}
