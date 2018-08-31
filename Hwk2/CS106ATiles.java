/*
 * File: CS106ATiles.java
 * Name: 
 * Section Leader: 
 * ----------------------
 * This file is the starter file for the CS106ATiles problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class CS106ATiles extends GraphicsProgram {
	
	// Amount of space (in pixels) between tiles 
	private static final int TILE_SPACE = 20;

	public void run() {
		int x;
		x=9%2;
		
		
		GLabel greetings = new GLabel ("Hello World" +x);
		greetings.setLocation(0,40);
		greetings.move(200,0);
		greetings.setFont("TimesNewRoman-ITALIC-36");
		greetings.setColor(Color.BLACK);
		add(greetings);
		
		GRect rectangle = new GRect(200, 40, 60, 39);
		rectangle.setColor(Color.CYAN);
		rectangle.setFilled(true);
		rectangle.setFillColor(Color.RED);
		add(rectangle);
		getWidth();
		GOval oval = new GOval(100,100,60,60);
		add(oval);
		
		GLine line = new GLine (200, 200, 300, 300);
		add(line);
		
	}
}



/*Hello World Program
public class CS106ATiles extends GraphicsProgram {
	
	// Amount of space (in pixels) between tiles 
	private static final int TILE_SPACE = 20;

	public void run() {
		GLabel label = new GLabel ("Hello World", 100, 75);
		label.setFont("TimesNewRoman-36");
		label.setColor(Color.BLACK);
		add(label);
		
	}
}
*/


/* A program that Ads two numbers
public class CS106ATiles extends ConsoleProgram {
	
	// Amount of space (in pixels) between tiles 
	private static final int TILE_SPACE = 20;

	public void run() {
		println("This program ads two numbers");
		int firstNumber = readInt("enter the first number: ");
		int secondNumber = readInt ("enter the second number: ");
		int total = firstNumber + secondNumber;
		println("the total is " + total +".");
		
	}
}
*/

