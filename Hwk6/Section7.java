import acm.gui.*;
import acm.program.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import acm.graphics.*;


public class Section7 extends GraphicsProgram {
	
	
	// ========== INIT METHOD ========== //
	public void init(){
		
		// Initializing the HashMap
		objectsOnScreen = new HashMap<String, GTextBox>(); 
		
		
		// Initializing interactors at the bottom of the screen
		
		// Name text label at the bottom conrol panel
		add(new JLabel("Name  "), SOUTH);
		
		// Text field
		tf = new JTextField(20); 
		add(tf, SOUTH);
		
		// Add button
		addBtn = new JButton(ADD);
		add(addBtn, SOUTH);
		
		// Remove button
		rmvBtn = new JButton(REMOVE);
		add(rmvBtn, SOUTH);
		
		// Clear button
		clrBtn = new JButton(CLEAR);
		add(clrBtn, SOUTH);	
	
		addMouseListeners();
		addActionListeners();
		
	}
	
	
	
	
	// ========== PRIVATE METHODS ========== //
	
	// Mouse Listeners //
	public void mouseDragged (MouseEvent e) {
		if (gobj!=null) {
			gobj.move(e.getX()-last.getX(), e.getY()-last.getY());
			last = new GPoint (e.getPoint());
		}
	}
	
	public void mousePressed (MouseEvent e) {
		last = new GPoint (e.getPoint());
		gobj = getElementAt (last);
	}
	
	
	// Action Listeners //
	public void actionPerformed (ActionEvent e){
		
		// If add button is pressed
		if (e.getSource()==addBtn){
			if(tf.getText()!=null){
				GTextBox box = new GTextBox(tf.getText());
				add(box, (getWidth()-box.getWidth())/2, (getHeight()-box.getHeight())/2);
				objectsOnScreen.put(tf.getText(), box);
			}
		}
		
		// If remove button is pressed
		if(e.getSource()==rmvBtn){
			if(tf.getText()!=null){
				remove(objectsOnScreen.get(tf.getText()));
				objectsOnScreen.remove(tf.getText());
			}
		}
		
		// If clear button is pressed
		if(e.getSource()==clrBtn){
			// Iterate over the hashMap keys and remove all objects in the hashMap and on the canvas
			Iterator<String> it = objectsOnScreen.keySet().iterator(); 
			while (it.hasNext()) {
				remove(objectsOnScreen.get(it.next()));
			}
			objectsOnScreen.clear();
		}
		

	}
	
	
	
	// ========== CONSTANTS ========== //
	
	// Constant strings used for interactors
	private static final String NAME = "Name";
	private static final String ADD = "Add";
	private static final String REMOVE = "Remove";
	private static final String CLEAR = "Clear";
	
	
	
	// ========== PRIVATE INSTANCE VARIABLES ========== //
	
	// For Buttons
	private JTextField tf;
	private JButton addBtn;
	private JButton rmvBtn;
	private JButton clrBtn;
	
	// For on canvas objects
	private GObject gobj;
	private GPoint last;
	
	// Text box dimensions
	private static final double BOX_WIDTH = 120;
    private static final double BOX_HEIGHT = 50;
    
    // HashMap to keep track of objects added/removed to/from screen
    private HashMap<String, GTextBox> objectsOnScreen;

	

}
