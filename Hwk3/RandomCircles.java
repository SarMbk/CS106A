import java.awt.Color;

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

public class RandomCircles extends GraphicsProgram {
	
	//	Defining static variables
	private static final int MIN_RADIUS=5;
	private static final int MAX_RADIUS=50;
	private static final int NUM_CIRCLES=10;
	
	
	//	defining the run method
	public void run() {
		for(int i = 0; i<NUM_CIRCLES; i++) {
			int diameter=rgen.nextInt(2*MIN_RADIUS, 2*MAX_RADIUS);
			int maxX=getWidth()-diameter;
			int maxY=getHeight()-diameter;
			int x = rgen.nextInt(0,maxX);
			int y = rgen.nextInt(0,maxY);
			Color randColor = rgen.nextColor();
			GOval oval = new GOval(x,y,diameter, diameter);
			oval.setColor(randColor);
			oval.setFilled(true);
			oval.setFillColor(randColor);
			add(oval);
			pause(100);
		}		
	}
	
	//	defining private instance variables
	private RandomGenerator rgen = RandomGenerator.getInstance();

}
