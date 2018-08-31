/* 
 * File: FacePamphlet.java
 * -----------------------
 * When it is finished, this program will implement a basic social network
 * management system.
 */

import acm.program.*;
import acm.graphics.*;
import acm.util.*;
import java.awt.event.*;
import java.util.Iterator;

import javax.swing.*;

public class FacePamphlet extends Program 
					implements FacePamphletConstants {


	// For exporting to JAR file
	public static void main (String[] args){
		new FacePamphlet().start(args);
	}
	
	
	// ========== METHOD: INIT ========== //
	/**
	 * This method has the responsibility for initializing the 
	 * interactors in the application, and taking care of any other 
	 * initialization that needs to be performed.
	 */
	public void init() {
		
		// Name label
		add(new JLabel("Name: "), NORTH);
		
		//Name text field
		nameFld = new JTextField(TEXT_FIELD_SIZE);
		add(nameFld, NORTH);
		
		// Add friend button
		addBtn = new JButton("Add");
		add(addBtn, NORTH);
		
		// Delete button
		delBtn = new JButton("Delete");
		add(delBtn, NORTH);
		
		// Lookup button
		lookupBtn = new JButton("Lookup");
		add(lookupBtn, NORTH);	
		
		// Change status text field
		statusFld = new JTextField(TEXT_FIELD_SIZE);
		add(statusFld, WEST);
		
		// Change status button
		statusBtn = new JButton("Change Status");
		add(statusBtn, WEST);
		
		// Empty space under the change status button
		add(new JLabel(EMPTY_LABEL_TEXT), WEST);
		
		// Change picture text field
		picFld = new JTextField(TEXT_FIELD_SIZE);
		add(picFld, WEST);
		
		// Change picture button
		picBtn = new JButton("Change Picture");
		add(picBtn, WEST);
		
		// Empty space under the change picture button
		add(new JLabel(EMPTY_LABEL_TEXT), WEST);
		
		// Add a friend text field
		friendFld = new JTextField(TEXT_FIELD_SIZE);
		add(friendFld, WEST);
		
		// Add a friend button
		friendBtn = new JButton("Add Friend");
		add(friendBtn, WEST);
		
		// Initialize canvas
		canvas = new FacePamphletCanvas();
		add(canvas);
		
		
		
		// Action listeners go after you initialize everything
		addActionListeners();
    }
    
  
	
	
	// ========== METHOD: ACTIONPERFORMED(ACTIONEVENT E) ========== //
    /**
     * This class is responsible for detecting when the buttons are
     * clicked or interactors are used, so you will have to add code
     * to respond to these actions.
     */
    public void actionPerformed(ActionEvent e) {
    	
    	// If Add button is clicked or a name is entered, a new profile is created;
		if(e.getSource()==addBtn || e.getSource()==nameFld){
			
			// if such profile already exists show it on the screen and make it current
			if (database.containsProfile(nameFld.getText())){
				canvas.displayProfile(database.getProfile(nameFld.getText()));
				canvas.showMessage("FacePamphlet profile under such name already exists");
				current = database.getProfile(nameFld.getText());	
			}
			
			// if not make a new profile
			if (!database.containsProfile(nameFld.getText())){
				FacePamphletProfile profile = new FacePamphletProfile(nameFld.getText());
				database.addProfile(profile);
				current = profile;
				canvas.displayProfile(profile);
				canvas.showMessage("New profile was added for " + profile.getName());	
			}
		}
		
		
		// If Delete button is clicked;
		if(e.getSource()==delBtn){
			
			if(database.containsProfile(nameFld.getText())){
				
				current = database.getProfile(nameFld.getText());
				
				// Remove the deleted profile name from all the friend lists
				Iterator<String> itr = current.getFriends();
				while (itr.hasNext()){
					FacePamphletProfile friendProfile = database.getProfile(itr.next());
					friendProfile.removeFriend(current.getName());
				}
				
				
				// Remove the deleted profile from the database and show appropriate messages on the screen
				database.deleteProfile(nameFld.getText());
				canvas.removeAll();
				canvas.showMessage(nameFld.getText() + "s profile was deleted");
				current = null;	
			}
		}
		
		
		// If Lookup button is pressed;
		if(e.getSource()==lookupBtn){
			current = database.getProfile(nameFld.getText());
			canvas.displayProfile(current);
		}
		
		
		// If Change Picture button is pressed;
		if(e.getSource()==picBtn){		
			GImage image = null;
	        try {image = new GImage(picFld.getText());} 
	        catch (ErrorException ex) {
	        	if(image == null){canvas.showMessage("No image file under such name was found");}
	        }
	        
	        if (image!=null){
		        current.setImage(image);
		        canvas.displayProfile(current);
		        canvas.showMessage(current.getName() + "'s profile picture was changed");
	        }
		}
		
		
		// If Change Status button is pressed;
		if(e.getSource()==statusBtn){
			current.setStatus(statusFld.getText());
			canvas.displayProfile(current);
			canvas.showMessage(current.getName() + "'s profile status was changed");
		}
		
		
		// If Add Friend Button is pressed;
		if(e.getSource()==friendBtn){
			
			// two conditionals:
			// 1. Such profile exists in the database
			// 2. The profile you want to add to friends is not your own profile
			if(database.containsProfile(friendFld.getText())  &&  database.getProfile(friendFld.getText())!=current){
				
				// Add friend to your profile
				current.addFriend(friendFld.getText());
				
				// Add yourself to your friends profile
				database.getProfile(friendFld.getText()).addFriend(current.getName());
				
				// Update canvas
				canvas.displayProfile(current);
				
				// Display appropriate message
				canvas.showMessage(friendFld.getText() + " was added to your friend list");
			}
			
			// If no such profile exists
			if(!database.containsProfile(friendFld.getText())){
				canvas.showMessage("There is no profile under name " + friendFld.getText());
			}
			
			// if you are trying to add your own profile to friends
			if(database.getProfile(friendFld.getText())==current){
				canvas.showMessage("You cannot add your own profile to friends");
			}
			
		}
		
	}
    
    
    
    
    // ========== PRIVATE INSTANCE VARIABLES ========== //
	
 	// Private variables for interactor buttons
    
    // text fields
 	private JTextField nameFld;
 	private JTextField statusFld;
 	private JTextField picFld;
 	private JTextField friendFld;

 	// buttons
 	private JButton delBtn; // delete button
 	private JButton addBtn; // add profile button
 	private JButton lookupBtn; // lookup up a name button
 	private JButton statusBtn; // change status button
 	private JButton picBtn; // change picture button
 	private JButton friendBtn; // add a friend button
 	
 	
 	// Private variable for database of all profiles
 	private FacePamphletDatabase database = new FacePamphletDatabase();
 	
 	
 	// Canvas
 	private FacePamphletCanvas canvas;
 	
 	
 	// Keeping track of the profile currently in view
 	private FacePamphletProfile current;





}
