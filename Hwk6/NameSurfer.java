/*
 * File: NameSurfer.java
 * ---------------------
 * When it is finished, this program will implements the viewer for
 * the baby-name database described in the assignment handout.
 */

import acm.program.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.*;

public class NameSurfer extends Program implements NameSurferConstants {

	
// For export as Jar file
	public static void main (String[] args){
		new NameSurfer().start(args);
	}
	
	
	
// ========== METHOD: INIT ========== //
	/**
	 * This method initiates all the interactor buttons
	 */
	public void init() {
		
		// Name Label
		add(new JLabel("Name: "), SOUTH);
		
		// Name text entry field
		nameFld = new JTextField(20);
		add(nameFld, SOUTH);
		
		// Graph button
		graphBtn = new JButton(GRAPH);
		add(graphBtn, SOUTH);
		
		// Clear button
		clrBtn = new JButton(CLR);
		add(clrBtn, SOUTH);
		
		// Graph GCanvas
		// This is an object of class NameSurferGraph (extends GCanvas) that we defined as a separate file.
		// graph is a private variable
		graph = new NameSurferGraph();
		add(graph);
		
		// This is necessary to make the buttons interactive
		addActionListeners();
	}

	
	
	
	
// ========== METHOD: ACTIONPERFORMED(ACTIONEVENT E) ========== //
/**
 * This class is responsible for detecting when the buttons are
 * clicked, and the operations to perform when the buttons are clicked
 */
	public void actionPerformed(ActionEvent e) {
		
		// if the Graph button is pressed
		if(e.getSource()==graphBtn){
			if(nameFld.getText()!=null){
				// find the name that was entered in the text box in the database and add its plot to the graph object
				graph.addEntry(dataBase.findEntry(nameFld.getText()));
				// then update the graph object on the screen
				graph.update();
			}
		}
		
		if(e.getSource()==clrBtn){
			// remove all the plots from the graph object
			graph.clear();
			// then update the graph object on the screen
			graph.update();
		}	
	}
	
	
	
	
// ========== PRIVATE INSTANCE VARIABLES ========== //
	
	// Private variables for interactor buttons
	private JTextField nameFld;
	private JButton graphBtn;
	private JButton clrBtn;
	
	// Private variable for the graph object
	private NameSurferGraph graph;
	
	// Database object that reads the data text file. See NameSurferDataBase.java class for more info
	private NameSurferDataBase dataBase = new NameSurferDataBase(NAMES_DATA_FILE);
}
