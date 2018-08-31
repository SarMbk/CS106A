import acm.graphics.*;
import acm.program.*;
import java.util.*;
import java.io.*;
import acm.util.*;
import java.awt.event.*;



public class Lecture17_GraphicNumbers extends GraphicsProgram {
	
	private static final double START_X = 50;
	private static final double START_Y = 100;
	
	
	public void run (){
		addMouseListeners();
	}
	
	
	public void mouseClicked(MouseEvent e){
		//Create a new label
		GLabel label = new GLabel ("#" + labels.size());
		label.setFont("Courier-18");
		
		//Move all existing labels down one row
		double dy = label.getHeight();
		for(int i = 0; i<labels.size(); i++){
			labels.get(i).move(0,dy);
		}
		
		add(label,START_X, START_Y);
		labels.add(label);
			
	}
	
	private ArrayList <GLabel> labels = new ArrayList<GLabel>();
}
