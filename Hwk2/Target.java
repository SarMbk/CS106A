/*
 * File: Target.java
 * Name: 
 * Section Leader: 
 * -----------------
 * This file is the starter file for the Target problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Target extends GraphicsProgram {
	public void run() {
		int d1 = getWidth()/2;
		int d2 = getWidth()/3;
		int d3 = getWidth()/6;
		
		int x1 = (getWidth()-d1)/2;
		int y1 = (getHeight()-d1)/2;
		
		GOval biggest = new GOval(x1,y1,d1,d1);
		biggest.setColor(Color.RED);
		biggest.setFilled(true);
		biggest.setFillColor(Color.RED);
		add(biggest);
		
		
		
		int x2 = (getWidth()-d2)/2;
		int y2 = (getHeight()-d2)/2;
		
		GOval mid = new GOval(x2,y2,d2,d2);
		mid.setColor(Color.WHITE);
		mid.setFilled(true);
		mid.setFillColor(Color.WHITE);
		add(mid);
		
		
		
		int x3 = (getWidth()-d3)/2;
		int y3 = (getHeight()-d3)/2;
		
		GOval smallest = new GOval(x3,y3,d3,d3);
		smallest.setColor(Color.RED);
		smallest.setFilled(true);
		smallest.setFillColor(Color.RED);
		add(smallest);
	}
}
