import acm.graphics.*;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class MusicShopDisplay extends GCanvas 
			implements ComponentListener{
	
	// ========== CONSTRUCTOR ========== //
	public MusicShopDisplay(){
		addComponentListener(this);
		lastAlbum = null;
	}
	
	
	
	
	// ========== METHODS ========== //
	
	// Display album name, band name and number in stock if it's in the inventory
	// otherwise just clear the display
	public void displayInventory (Album album){
		removeAll();
		lastAlbum = album;
		if (album!=null){
			int numStocked = album.getNumStock();
			add(new GLabel("Album: [" + album.getAlbumName() + "] by [" + album.getBandName() + "]" ), 10,
					(getHeight()-BAR_HEIGHT)/2 - SPACER);
			
			// Display squares indicating how many inventory
			double nextX = SPACER;
			for (int i=0; i<numStocked; i++) {
				double barLength = (getWidth()/(double)MAX_INVENTORY) - SPACER;
				GRect rect = new GRect (nextX, (getHeight()-BAR_HEIGHT)/2, barLength, BAR_HEIGHT);
				rect.setFilled(true);
				add(rect);
				nextX+= barLength + SPACER;	
			}
			
			GLabel label = new GLabel(numStocked + " in stock");
			add(label, 10, (getHeight()+BAR_HEIGHT)/2 + SPACER + label.getAscent());
		}	
	}
	
	
	
	
	// Whenever we need to update display, continue to show the last album
	public void update(){
		displayInventory(lastAlbum);
	}
	
	
	
	
	// ========== COMPONENT LISTENERS ========== //
	public void componentResized (ComponentEvent e) {update();}
	public void componentHidden (ComponentEvent e) { }
	public void componentMoved (ComponentEvent e) { }
	public void componentShown (ComponentEvent e) { }
	
	
	
	
	// ========== CONSTANTS ========== //
	private static final double BAR_HEIGHT = 15;
	private static final double BAR_WIDTH = 10;
	private static final double SPACER = 4;
	private static final int MAX_INVENTORY = 50;
	
	
	
	
	// ========== PRIVATE INSTANCE VARIABLES ========== //
	private Album lastAlbum;

}
