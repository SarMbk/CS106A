import acm.graphics.*;
import acm.program.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;



public class InteractiveDrawFace extends GraphicsProgram {
	
	public void init(){
		
		// Button to clear display
		add(new JButton("clear"), SOUTH);
		
		// Check box to display front or back of face
		check = new JCheckBox("Front");
		check.setSelected(true);
		add(check, SOUTH);
		
		initRadioButtons();
		
		initColorChooser();
		
		addMouseListeners();
		
		addActionListeners();	
	}
	
	
	
	
	// ========== PRIVATE METHODS ========== //
		
	// Initializes radio buttons
	private void initRadioButtons(){
		ButtonGroup sizeBG = new ButtonGroup();
		
		// Initialize radio buttons
		smRB = new JRadioButton("small");
		mdRB = new JRadioButton("med");
		lgRB = new JRadioButton("large");
		
		// Add all radio buttons to button group
		sizeBG.add(smRB);
		sizeBG.add(mdRB);
		sizeBG.add(lgRB);
		
		// Set initial radio button selection to medium by default
		mdRB.setSelected(true);
		
		// Add all radio buttons to control panel
		add(smRB, SOUTH);
		add(mdRB, SOUTH);
		add(lgRB, SOUTH);		
	}
	
	
	
	
	// Initializes the color choosing drop down list
	private void initColorChooser(){
		// Create drop down list with color options
		pickColor = new JComboBox();
		
		// Add items to the drop down list
		pickColor.addItem("red");
		pickColor.addItem("black");
		pickColor.addItem("blue");
		pickColor.addItem("green");
		
		// Do not allow user to type in his own input into the drop down list
		pickColor.setEditable(false);
		
		// Set default color selection
		pickColor.setSelectedItem("black");
		
		// Create label with separating spaces for color box
		add(new JLabel(" Color"), SOUTH);
		
		// Add drop down list to the control bar
		add(pickColor, SOUTH);
	}
	
	
	
	
	// Draws face whenever the mouse is clicked
	public void mouseClicked(MouseEvent e){
		GObject obj;
		
		double dia = getDiamSize();
		
		if (check.isSelected()){
			obj = new GFace(dia, dia);
		} else {
			obj = new GOval(dia, dia);
		}
		
		obj.setColor(getCurrentColor());
		add(obj, e.getX(), e.getY());
		
	}
	
	
	
	
	// Returns diameter size according to the selected radio button option
	private double getDiamSize(){
		double size = 0;
		
		if(smRB.isSelected()){
			size = SMALL_DIA;
		}
		if(lgRB.isSelected()){
			size = LARGE_DIA;
		}
		if(mdRB.isSelected()){
			size = MEDIUM_DIA;
		}
		
		return size;
	}
	
	
	
	
	// Returns color object corresponding to combo box choice
	private Color getCurrentColor(){
		
		String name = (String)pickColor.getSelectedItem();
		
		if (name.equals("red")){
			return Color.RED;
		}
		if (name.equals("green")){
			return Color.GREEN;
		}
		if (name.equals("blue")){
			return Color.BLUE;
		}
		else return Color.BLACK;	
	}
	
	
	
	
	// Clears screen whenever the clear button is pressed
	public void actionPerformed(ActionEvent e){
		if (e.getActionCommand().equals("clear")){
			removeAll();
		}	
	}
	
	
	
	
	// ========== PRIVATE CONSTANTS =========== //
	
	private static final double SMALL_DIA = 20;
	private static final double MEDIUM_DIA = 40;
	private static final double LARGE_DIA = 60;
	
	
	
	
	// ========== PRIVATE INSTANCE VARIABLES ========== //
	
	private JCheckBox check;
	private JRadioButton smRB;
	private JRadioButton mdRB;
	private JRadioButton lgRB;
	private JComboBox pickColor;
}
