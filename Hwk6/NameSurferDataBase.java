import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import acm.util.ErrorException;




/*
 * File: NameSurferDataBase.java
 * -----------------------------
 * This class keeps track of the complete database of names.
 * The constructor reads in the database from a file, and
 * the only public method makes it possible to look up a
 * name and get back the corresponding NameSurferEntry.
 * Names are matched independent of case, so that "Eric"
 * and "ERIC" are the same names.
 */




public class NameSurferDataBase implements NameSurferConstants {
	


	
// ========== CONSTRUCTOR ========== //	
	
/**
 * Creates a new NameSurferDataBase and initializes it using the
 * data in the specified file.  The constructor throws an error
 * exception if the requested file does not exist or if an error
 * occurs as the file is being read.
 */
	// First, we need to do what is called "construct a class". That is: what types of data will an object of this class contain?
	// When you create a NameSurferDataBase object with a filename as an parameter, it will take that filename and open a text file
	// with that name then it will read all the text into a HashMap that we initiated as a private variable.
	// the HashmMap maps the string values of name to NameSurferEntry objects.
	// NameSurferEntry object is a data structure that contains a String (name) and and ArrayList of integers (rank each decade)
	public NameSurferDataBase(String filename) {
		try {
			BufferedReader rd = new BufferedReader(new FileReader(filename));
			while(true){
				String line = rd.readLine();
				if (line == null) {break;}
				NameSurferEntry entry = parseLine(line);
				nameData.put(entry.getName(), entry);	
			}
			rd.close();	
		} catch (IOException ex) {
			throw new ErrorException(ex);
		}	
	}

	

	
// ========== PRIVATE METHODS ========== //	
	
	// Private method that takes in a line and returns a NameSurferEntry object.
	private NameSurferEntry parseLine(String line){
		
		// Get the part of the line which contains only ranks for each decade
		// The numbers follow after the first space
		String rankString = line.substring(line.indexOf(" ")+1);
		
		scanner = new Scanner(rankString);
		ArrayList<Integer>ranks = new ArrayList<Integer>();
		while (scanner.hasNextInt()) {
		    ranks.add(scanner.nextInt());
		}
		
		// Get the part of the line which contains only the letters having the name
		String name = line.substring(0, line.indexOf(" "));
		
		return (new NameSurferEntry(name.toUpperCase(), ranks));
	}
	
	

	
// ========== PUBLIC METHODS ========== //
	
/**
 * Returns the NameSurferEntry associated with this name, if one
 * exists.  If the name does not appear in the database, this
 * method returns null.
 */
	public NameSurferEntry findEntry(String name) {
		// All names are converted to upper case so that the program was case insensitive
		String nameUpper = name.toUpperCase();
		
		// If there is such a name in the database then return a NameSurferEntry object mapped to that name (String value)
		if(nameData.containsKey(nameUpper)){return nameData.get(nameUpper);}
		else {return null;}
	}
	
	

	
// ========== PRIVATE INSTANCE VARIABLES ========== //

// Each NameSurferDatabase object contains within itself a HashMap which will contain a keyset of strings corresponding to names
// and a value set of NameSurferEntry object which will represent name usage data.
private HashMap <String, NameSurferEntry> nameData = new HashMap <String, NameSurferEntry>();

// Scanner needed to find integers in a string
private Scanner scanner;

}

