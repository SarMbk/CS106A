import acm.program.*;
import acm.graphics.*;


public class GTextBox extends GCompound {
	
	// Text box dimension constants
	private static final double BOX_WIDTH = 120;
    private static final double BOX_HEIGHT = 50;
    
    // Private instance variables
    private GRect rect;
    private GLabel text;
    
    // Constructor (adds a box with text in the middle of the screen)
    public GTextBox(String labelText){
    	rect = new GRect (BOX_WIDTH, BOX_HEIGHT);
    	text = new GLabel(labelText);
		add(rect,0,0);
		add(text, (BOX_WIDTH-text.getWidth())/2, (BOX_HEIGHT+text.getAscent())/2);
    }

}
