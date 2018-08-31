/*
 * File: HangmanLexicon.java
 * -------------------------
 * This file contains a stub implementation of the HangmanLexicon
 * class that you will re-implement for Part III of the assignment.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import acm.util.*;


public class HangmanLexicon {

	
	
	
	
// This is a method for reading text files
	public BufferedReader openFile() { 
	BufferedReader rd = null;
	while (rd == null){
		try {rd = new BufferedReader(new FileReader("HangmanLexicon.txt"));} 
		catch (IOException ex) {}
	}
	return rd;
	}

	
	
	
	
	
/** Returns the number of words in the lexicon. */
	public int getWordCount() {
		ArrayList<String> lexicon = makeLexiconArray();
		int wordCount = lexicon.size();
		return wordCount;
	}
	
	
	
	

	
// Method for reading the text file line by line and reading the words into an array	
	public ArrayList<String> makeLexiconArray(){
		
		// Initiate ArrayList to read words into
		ArrayList<String> lexicon = new ArrayList<String>();
		
		// Open HangmanLexicon.txt
		BufferedReader rd = openFile();
		
		// Read lines and add them to wordList word line by line
		try {
			// Keep reading the lines while the lines are not null
			while (true){
				String line = rd.readLine();
				if (line == null) {break;}
				lexicon.add(line);
			}
			rd.close();
		}
		catch (IOException ex) { // catch statement is needed if the file disappears while the computer is working on it
			throw new ErrorException(ex);
		}
		return lexicon;
	}
		
	
	
	

/** Returns the word at the specified index. */
	public String getWord(int index) {
		ArrayList<String> lexicon = makeLexiconArray();
		String wordToGuess = lexicon.get(index);
		return wordToGuess;
	}
	
	
	
	
}
