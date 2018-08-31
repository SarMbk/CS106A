import acm.program.*;
import java.util.*;
import java.io.*;
import acm.util.*;

public class Lecture15_notes extends ConsoleProgram {
	
	// This is a method for reading text files
	// The parameter is a string prompt which is something like "Please type name of file that you want to open"
	public BufferedReader openFile(String prompt) { 
		// Creates an object of class buffered reader and sets it to null
		BufferedReader rd = null;
		// While rd is null, opens a file under a name that a user has entered
		while (rd == null){
			try {
				String filename = readLine(prompt);
				rd = new BufferedReader(new FileReader(filename));
			// If file under such name doesn't exist, it will throw an exception
			} catch (IOException ex) {
				//In case exception is thrown, you tell the computer to print the following statement
				println ("File under such name does not exist");
			}
			//Because rd is still equal to null, the computer will ask you input a filename again.
		}
		return rd;
	}
	
	
	
	
	public void run () {
		//Prompt the user to enter file name
		BufferedReader rd = openFile("Please, enter filename to open: ");
		
		try {
			// Keep printing the lines while the lines are not null
			while (true){
				String line = rd.readLine();
				if (line == null) {break;}
				println("Read Line: [" + line + "]");
			}
			rd.close();
		}catch (IOException ex) { // catch statement is needed if the file disappears while the computer is working on it
			throw new ErrorException(ex);
		}
	}
	
	
	
}