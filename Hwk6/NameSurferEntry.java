/*
 * File: NameSurferEntry.java
 * --------------------------
 * This class represents a single entry in the database.  Each
 * NameSurferEntry contains a name and a list giving the popularity
 * of that name for each decade stretching back to 1900.
 */

import java.util.*;

public class NameSurferEntry implements NameSurferConstants {

	
	
	
// ========== CONSTRUCTOR ========== //
	
/**
 * Creates a new NameSurferEntry from a data line as it appears
 * in the data file.  Each line begins with the name, which is
 * followed by integers giving the rank of that name for each
 * decade.
 */
	
	// a NameSurferEntry element will have two objects inside.
	// 1. A string containing a name
	// 2. An arrayList of integers that will store the ranks on name popularity for each decade
	public NameSurferEntry(String name, ArrayList <Integer> popularity ) {
		entryName = name;
		ranks = popularity;
	}

	
	
	
// ========== PUBLIC METHODS ========== //

/**
 * Returns the name associated with this entry.
 */
	public String getName() {return entryName;}
	
	
	
	
/**
* Returns an ArrayList containing the name ranks for all given decades of a NameSurferEntry
 */
	public ArrayList<Integer> getAllRanks(){return ranks;}	

	
	
	
/**
 * Returns the rank associated with an entry for a particular
 * decade.  The decade value is an integer e.g. 1910, 1920, 1930 etc.
 * If decade is not in the database, returns -1 (this way its easy to debug). 
 * The earliest decade is 1900 which is given by the constant START_DECADE.  
 * If a name does not appear in a decade, the rank value is 0.
 */
	public int getRank(int decade) {
		// Convert decade to the element index in the ranks ArrayList
		int i = (decade - STARTING_DECADE)/10;
		
		if (i <0){return -1;}
		if (i>ranks.size()-1){return -1;} 
		else {return ranks.get(i);}
	}

	
	

/**
 * Returns a string that makes it easy to see the value of a
 * NameSurferEntry.
 */
	public String toString() {
		String result = entryName + " " + (Arrays.toString(ranks.toArray()));;
		return result;
	}
	
	
	
	
	
// ========== PRIVATE INSTANCE VARIABLES ========== //
	private String entryName;
	private ArrayList <Integer> ranks;	
}

