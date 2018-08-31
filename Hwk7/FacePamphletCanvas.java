/*
 * File: FacePamphletCanvas.java
 * -----------------------------
 * This class represents the canvas on which the profiles in the social
 * network are displayed.  NOTE: This class does NOT need to update the
 * display when the window is resized.
 */


import acm.graphics.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.util.*;

public class FacePamphletCanvas extends GCanvas 
					implements FacePamphletConstants {
	
	/** 
	 * Constructor
	 * This method takes care of any initialization needed for 
	 * the display
	 */
	public FacePamphletCanvas() {
		// You fill this in
	}

	
	/** 
	 * This method displays a message string near the bottom of the 
	 * canvas.  Every time this method is called, the previously 
	 * displayed message (if any) is replaced by the new message text 
	 * passed in.
	 */
	public void showMessage(String msg) {
		// Remove a message that is already there
		if(getElementAt(getWidth()/2, getHeight()-BOTTOM_MESSAGE_MARGIN)!=null){
			remove(getElementAt(getWidth()/2, getHeight()-BOTTOM_MESSAGE_MARGIN));
		}
		
		// Create a new label and place it at the bottom of the screen in the middle
		GLabel label = new GLabel(msg);
		label.setFont(MESSAGE_FONT);
		add(label, (getWidth()-label.getWidth())/2, getHeight()-BOTTOM_MESSAGE_MARGIN);
		
	}
	
	
	/** 
	 * This method displays the given profile on the canvas.  The 
	 * canvas is first cleared of all existing items (including 
	 * messages displayed near the bottom of the screen) and then the 
	 * given profile is displayed.  The profile display includes the 
	 * name of the user from the profile, the corresponding image 
	 * (or an indication that an image does not exist), the status of
	 * the user, and a list of the user's friends in the social network.
	 */
	public void displayProfile(FacePamphletProfile profile) {
		removeAll();
		showName(profile);
		showImage(profile);
		showStatus(profile);
		showFriends(profile);
	}
	
	
	// Private method to show a profile name
	private void showName(FacePamphletProfile profile){
		name = new GLabel (profile.getName());
		name.setFont(PROFILE_NAME_FONT);
		name.setColor(Color.BLUE);
		
		double x = LEFT_MARGIN;
		double y = TOP_MARGIN + name.getAscent();
		add(name, x, y);
	}
	
	
	// Private method to show a profile picture
	private void showImage(FacePamphletProfile profile){
		GImage image = profile.getImage();
		
		if (image==null){
			GRect rect = new GRect(IMAGE_WIDTH, IMAGE_HEIGHT);
			add(rect, LEFT_MARGIN, TOP_MARGIN + IMAGE_MARGIN + name.getAscent());
			
			GLabel noImageLabel = new GLabel("No Image");
			noImageLabel.setFont(PROFILE_IMAGE_FONT);
			
			double noImageLabelX = rect.getX() + IMAGE_WIDTH/2 - noImageLabel.getWidth()/2;
			double noImageLabelY = rect.getY() + IMAGE_HEIGHT/2 + noImageLabel.getAscent()/2;
			add(noImageLabel, noImageLabelX, noImageLabelY);
		}
		
		if(image!=null){
			image.setSize(IMAGE_WIDTH, IMAGE_HEIGHT);
			add(image, LEFT_MARGIN, TOP_MARGIN + IMAGE_MARGIN + name.getAscent());
		}
	}
	
	
	// Private method to show profile status
	private void showStatus(FacePamphletProfile profile){
		if (profile.getStatus()!=null && profile.getStatus()!=""){
			GLabel status = new GLabel(profile.getName() + " is " + profile.getStatus());
			status.setFont(PROFILE_STATUS_FONT);
			add(status, LEFT_MARGIN, 
				TOP_MARGIN + name.getAscent() + IMAGE_MARGIN + IMAGE_HEIGHT + STATUS_MARGIN + status.getAscent());
		}
	}
	
	
	// Private method to show friend list
	private void showFriends(FacePamphletProfile profile){
		
		// Show "Friends" label at top of friend list:
		GLabel friendLabel = new GLabel("Friends:");
		friendLabel.setFont(PROFILE_FRIEND_LABEL_FONT);
		add(friendLabel, FRIENDS_X_COORDINATE, TOP_MARGIN + IMAGE_MARGIN);
		
		// Show a list of friends
		showFriendList(profile);
	}
	
	// Private method used inside a method directly above to show a list of all friends
	private void showFriendList(FacePamphletProfile profile){
		double y = TOP_MARGIN + IMAGE_MARGIN + FRIENDS_Y_SPACING;
		//ArrayList<String> friends = profile.returnFriendArrayList();
		
		Iterator<String> itr = profile.getFriends();
		while (itr.hasNext()){
			GLabel friendName = new GLabel(itr.next());
			friendName.setFont(PROFILE_FRIEND_FONT);
			add(friendName, FRIENDS_X_COORDINATE, y);
			y+=FRIENDS_Y_SPACING;
		}
	}

	
	
	public void componentResized (ComponentEvent e) {/*update();*/}
	public void componentHidden (ComponentEvent e) { }
	public void componentMoved (ComponentEvent e) { }
	public void componentShown (ComponentEvent e) { }

	
	// ========== PRIVATE INSTANCE VARIABLES ========== //

	private GLabel name;

}
