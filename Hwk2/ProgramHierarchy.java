import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class ProgramHierarchy extends GraphicsProgram {
	
	//	declare a constant by which the boxes are bigger than text
	private static final int WIGGLE_RM = 6;
	
	public void run() {
		
		
		// TOP BOX
		GLabel text = new GLabel("Program");
		text.setFont("Calibri-24");
		
		
		
		//	declare shorter variables for screen resolution for convenience
		double w = getWidth();
		double h = getHeight();
		
		//	declare a variable for Program text label length
		double textLength = text.getWidth();
		
		//	declare a variable for Program text label ht
		double textHt = text.getAscent();
		
		//	declare a variable for width of box around program label dependent on text width
		double boxLength = textLength + 2*WIGGLE_RM;
		
		//	declare a variable for height of box dependent upon text height
		double BoxHt = textHt + 2*WIGGLE_RM;
				
		
		//	declare a variable for starting point coordinates of the program label
		double x0Text = (w-textLength)/2;
		
		// 	declare variables for top corner coordinates of the box around the program label 	
		double x0Box = (x0Text - WIGGLE_RM);
		double y0Box = (h/3 - BoxHt+WIGGLE_RM);
		
		//	define all coordinates of the top text and box
		text.setLocation(x0Text,h/3);
		add(text);
		
		//	define box
		GRect box = new GRect(x0Box, y0Box, boxLength,BoxHt);
		add(box);
		
		
		
		
		
		
		
		// BOTTOM MIDDLE BOX
		
		//	define common y coordinate for bottom boxes
		y0Box = (y0Box+4*BoxHt);
		
		//	change text label 
		text = new GLabel("Console Program");
		text.setFont("Calibri-24");	
		
		//	change the variable for Console Program text label length
		textLength = text.getWidth();
				
		//	change the variable for width of box around program label dependent on text width
		boxLength = textLength + 2*WIGGLE_RM;
				
		//	declare a variable for starting point coordinates of the program label
		x0Text = (w/2 - 0.5*textLength);
		
		// 	declare variables for top corner coordinates of the box around the program label 	
		x0Box = (x0Text - WIGGLE_RM);
		
		//	define all coordinates of the top text and box
		text.setLocation(x0Text,(y0Box + WIGGLE_RM + textHt));
		add(text);
		
		//	define box
		box = new GRect(x0Box, y0Box, boxLength,BoxHt);
		add(box);
		
		//line
		GLine line1 = new GLine (w/2, h/3 + WIGGLE_RM, w/2, y0Box);
		add(line1);
		
		
		
		
		
		
		//	GRAPHICS PROGRAM BOX, BOTTOM LEFT
		text = new GLabel("Graphics Program");
		text.setFont("Calibri-24");
		
		
		//	declare a variable for Graphics Program text label length
		textLength = text.getWidth();
		
		//	declare a variable for width of box around program label dependent on text width
		boxLength = textLength + 2*WIGGLE_RM;
					
		
		//	declare a variable for starting point coordinates of the Graphics Program label
		x0Text = (20);
		
		// 	declare variables for top corner coordinates of the boxes around the program label 	
		x0Box = (x0Text - WIGGLE_RM);
		
		
		//	define all coordinates of text and box
		text.setLocation(x0Text,(y0Box + WIGGLE_RM + textHt));
		add(text);
		
		//	define box
		box = new GRect(x0Box, y0Box, boxLength,BoxHt);
		add(box);
		
		//	line
		GLine line2 = new GLine (w/2, h/3 + WIGGLE_RM, x0Box+0.5*boxLength, y0Box);
		add(line2);
		
		
		
		
		
		//	DIALOG PROGRAM BOX, BOTTOM RIGHT
		text = new GLabel("Dialog Program");
		text.setFont("Calibri-24");
		
		
		//	declare a variable for Dialog Program text label length
		textLength = text.getWidth();
		
		
		//	declare a variable for width of box around program label dependent on text width
		boxLength = textLength + 2*WIGGLE_RM;
				
		//	declare a variable for starting point coordinates of the text label
		x0Text = (w - 20 - boxLength + WIGGLE_RM);
		
		// 	declare variables for top corner coordinates of the box around the program label 	
		x0Box = (x0Text - WIGGLE_RM);
		
		//	define all coordinates of the top text and box
		text.setLocation(x0Text,(y0Box + WIGGLE_RM + textHt));
		add(text);
		
		//	define box
		box = new GRect(x0Box, y0Box, boxLength,BoxHt);
		add(box);
		
		//	line
		GLine line3 = new GLine (w/2, h/3 + WIGGLE_RM, x0Box+0.5*boxLength, y0Box);
		add(line3);	

	}
}
