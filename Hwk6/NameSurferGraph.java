/*
 * File: NameSurferGraph.java
 * ---------------------------
 * This class represents the canvas on which the graph of
 * names is drawn. This class is responsible for updating
 * (redrawing) the graphs whenever the list of entries changes or the window is resized.
 */

import acm.graphics.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;

public class NameSurferGraph extends GCanvas implements NameSurferConstants, ComponentListener {


// ========== PUBLIC METHODS ========== //
	/**
	* Creates a new NameSurferGraph object that displays the data.
	*/
	public NameSurferGraph() {
		addComponentListener(this);
	}
	
	
	/**
	* Clears the list of name surfer entries stored inside this class.
	*/
	public void clear() {
		namesPlottedArrayList.clear();
	}
	

	/**
	* Adds a new NameSurferEntry to the list of entries on the display.
	* Note that this method does not actually draw the graph, but
	* simply stores the entry; the graph is drawn by calling update.
	*/
	public void addEntry(NameSurferEntry entry) {
		if (entry!=null){
			namesPlottedArrayList.add(entry);
		}
	}
	
	
	/**
	* Updates the display image by deleting all the graphical objects
	* from the canvas and then reassembling the display according to
	* the list of entries. Your application must call update after
	* calling either clear or addEntry; update is also called whenever
	* the size of the canvas changes.
	*/
	public void update() {
		removeAll();
		addGrid();
		addDecadeLabels();
		plotAllEntries();
	}
	
	
// ========== PRIVATE METHODS ========== //
	
	
	/**
	 * Creates vertical grid lines based on the width and height of canvas
	 */
	private void addGrid(){
		double space = getWidth()/NDECADES;
		double x = 0.0;
		int nLines = 0;
		
		// Add vertical grid lines
		while (nLines<NDECADES){
			GLine line = new GLine(x, 0, x, getHeight());
			x+=space;
			nLines+=1;
			add(line);
		}
		
		// Add horizontal margin line at bottom
		add(new GLine (0, getHeight()-GRAPH_MARGIN_SIZE, getWidth(),getHeight()-GRAPH_MARGIN_SIZE));
		
		// Add horizontal margin line at top
		add(new GLine (0, GRAPH_MARGIN_SIZE, getWidth(), GRAPH_MARGIN_SIZE));		
	}
	
	
	/**
	 * Creates a series of labels representing decades next to each vertical grid line
	 */
	private void addDecadeLabels(){
		double space = getWidth()/NDECADES;
		double x = getWidth()/(NDECADES*10);
		int nLabels = 0;
		int currDecade = STARTING_DECADE;
		while (nLabels<NDECADES){
			GLabel label = new GLabel(Integer.toString(currDecade));
			add(label, x, getHeight() - GRAPH_MARGIN_SIZE + 1.2*label.getAscent());
			x+=space;
			nLabels+=1;
			currDecade+=10;		
		}	
	}
	
	
	/**
	 * Loops through the whole ArrayList of names entered and plots them
	 */
	private void plotAllEntries(){
		if(!namesPlottedArrayList.isEmpty()){
			for (int i=0; i<namesPlottedArrayList.size(); i++){
				plotEntry(namesPlottedArrayList.get(i), i);
			}	
		}
	}
	
	
	/**
	 * Plots a graph of name popularity for a given name with name labels and ranks for each decade
	 */
	private void plotEntry(NameSurferEntry entry, int colorTracker){
		
		double space = getWidth()/NDECADES;		
		double x0=0;
		GLabel nameRank; 
		int rank=0;
		int rankNext;
		
		for (int i=0; i<NDECADES; i++ ){
			
			// Get ranks for a name for each decade. We will use these variables to plot lines and place name labels
			rank = entry.getRank(STARTING_DECADE+i*10);	
			if (i==NDECADES-1) break;
			rankNext = entry.getRank(STARTING_DECADE+(i+1)*10);
			
			// Add the plot line and manage line colors
			GLine line = new GLine( x0+i*space  ,  plotY(rank)  ,  x0+(i+1)*space  ,  plotY(rankNext) );
			if (colorTracker%4==0){line.setColor(Color.RED);}
			if (colorTracker%4==1){line.setColor(Color.BLUE);}
			if (colorTracker%4==2){line.setColor(Color.GREEN);}
			if (colorTracker%4==3){line.setColor(Color.MAGENTA);}
			add(line);	
			
			// Add names and rank labels
			if(rank!=0){nameRank = new GLabel(entry.getName() + "," + entry.getRank(STARTING_DECADE+i*10));}
			else{nameRank = new GLabel(entry.getName() + "*");}
			nameRank.setFont("Calibri-10");
			add(nameRank, x0+i*space  ,  plotY(rank) - 0.2*nameRank.getAscent());
			// This method has an obob			
		}
		
		// Fix the OBOB by adding the last name label outside of the for loop
		if(rank!=0){nameRank = new GLabel(entry.getName() + "," + entry.getRank(STARTING_DECADE+(NDECADES-1)*10));}
		else{nameRank = new GLabel(entry.getName() + "*");}
		nameRank.setFont("Calibri-10");
		add(nameRank, x0+(NDECADES-1)*space  ,  plotY(rank) - 0.2*nameRank.getAscent());
	}
	
	
	/**
	 * Accepts a rank of a NameSurferEntry for a particular decade and returns a Y coordinate of a point to be 
	 * plotted on the graph. Used in the private plot entry method to shorten the notation of different coordinates.
	 * @param rank
	 * @return
	 */
	private double plotY(int rank){
		if (rank==0){return getHeight()-GRAPH_MARGIN_SIZE;}
		return rank*(getHeight()-2*GRAPH_MARGIN_SIZE)/MAX_RANK + GRAPH_MARGIN_SIZE;	
	}
	
	
	
	
// ========== IMPLEMENTATION OF THE COMPONENT LISTENER INTERFACE ========== //
	
	public void componentHidden(ComponentEvent e) { }
	public void componentMoved(ComponentEvent e) { }
	public void componentResized(ComponentEvent e) { update(); }
	public void componentShown(ComponentEvent e) { }
	
	
	
// ========== PRIVATE INSTANCE VARIABLES ========== //
		
	// A NameSurferGraph object shall contain an ArrayList of names plotted. We only need this to make sure that when a new name
	// is added, the previous plots had the same color as before. 
	// HashMap does not guarantee order so we ensure color constancy of the plot
	// by looking at the index of the name in the ArrayList (See private method plotEntry(NameSurferEntry entry, int colorTracker)
	private ArrayList<NameSurferEntry> namesPlottedArrayList = new ArrayList<NameSurferEntry>();
}
