
import acm.graphics.*;
import acm.program.*;
import java.awt.*;



public class Face extends GraphicsProgram {
	
	private static final int HEAD_WIDTH = 240;
	private static final int HEAD_HEIGHT = 400;
	private static final int EYE_RADIUS = 25;
	private static final int MOUTH_WIDTH = 140;
	private static final int MOUTH_HEIGHT = 50;
	
	public void run() {
		GRect rectFace = new GRect(520, 100, HEAD_WIDTH, HEAD_HEIGHT);
		rectFace.setFilled(true);
		rectFace.setFillColor(Color.gray);
		add(rectFace);
		
		GOval eye1 = new GOval (570, 200, 2*EYE_RADIUS, 2*EYE_RADIUS);
		eye1.setFilled(true);
		eye1.setColor(Color.yellow);
		eye1.setFillColor(Color.yellow);
		add(eye1);
		
		GOval eye2 = new GOval (660, 200, 2*EYE_RADIUS, 2*EYE_RADIUS);
		eye2.setFilled(true);
		eye2.setColor(Color.yellow);
		eye2.setFillColor(Color.yellow);
		add(eye2);
		
		GRect rectMouth = new GRect (570, 380, MOUTH_WIDTH, MOUTH_HEIGHT);
		rectMouth.setFilled(true);
		rectMouth.setFillColor(Color.RED);
		add(rectMouth);
	}
}
