
//==================IMPLEMENTING USER INTERFACES==========================//

import acm.program.*;
import acmx.export.javax.swing.JCheckBox;

import java.util.*;

// Libraries needed for user interface implementation
import java.awt.event.*;
import javax.swing.*;

//


public class Lecture20_notes extends ConsoleProgram {
	
	// In interactive programs, we typically call the main method init, not run
	public void init(){
		
		// Implementing a button
		JButton button = new JButton("hi");
		
		// Adding button to the interface at the bottom region
		add(button, NORTH);
		
		// Adding and initializing a button in one line
		add(new JButton("CS106A"), SOUTH);
		add(new JButton("Basket Weaving 101"), WEST);
		
		// Implementing checkboxes. It is initialized at the bottom as an instance variable
		check = new JCheckBox("Front");
		// When program begins the checkbox can be set to selected or unselected
		check.setSelected(true);
		add(check, SOUTH);
		
		// How to check whether a checkbox is selected:
		boolean p = check.isSelected();
		//This returns true if checkbox is selected and false if not
		
		// How to implement radiobutons
		sm = new JRadioButton("small");
		md = new JRadioButton("med");
		lg = new JRadioButton("large");
		
		// How to implement group of radiobuttons to make sure they don't conflict with each other
		// Buttongroups are better off as local variables
		ButtonGroup size = new ButtonGroup();
		size.add(sm);
		size.add(md);
		size.add(lg);
		
		// Set one radiobutton selected
		md.setSelected(true);
		
		// add radiobuttons to the interface
		add(sm, SOUTH);
		add(md, SOUTH);
		add(lg, SOUTH);
		
		// How to implement a combobox (dropdown list). They are better of as private variables. So they are declared at the bottom
		pick = new JComboBox();
		
		// Adding items to the dropdown menu
		pick.addItem("Red");
		pick.addItem("Black");
		pick.addItem("Blue");
		pick.addItem("Green");
		
		// This makes sure that the user can't type in his own value into the dropdown menu
		pick.setEditable(false);
		
		// This sets the initial selected default value for the dropdown list
		pick.setSelectedItem("Black");
		
		// Adding dropdown menu to screen
		add(pick, SOUTH);
		
		
		
		getMouseListeners();
		
		
		// Action listeners go after you initialize everything
		addActionListeners();
		
	}
	
	
	// This method gets called when buttons get cicked
	public void actionPerformed(ActionEvent e){
		
		// cmd stand for command
		// if I click on button "hi", cmd will have value "hi" in it
		// if I click on button "Test", cmd will have value "test" in it
		// this way I keep track of which button is clicked
		String cmd = e.getActionCommand();
		
		if (cmd.equals("hi")){
			println("hello");
		}
		
		if (cmd.equals("CS106A")){
			println("This is the best course I ever took, god bless CS106A");
		}
		
		if(cmd.equals("Basket Weaving 101")){
			println("Not so much");
		}
	}

	
	
	// Checkboxes are better off as instance variables, because you can check their state at any point in the program
	private JCheckBox check;
	private JRadioButton sm;
	private JRadioButton md;
	private JRadioButton lg;
	private JComboBox pick;
}
