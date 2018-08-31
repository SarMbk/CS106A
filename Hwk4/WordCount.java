/*
 * Opens a named text file and counts the number of words lines and characters in it.
 * 
 */

import acm.program.*;
import acm.util.ErrorException;

import java.util.*;
import java.io.*;

public class WordCount extends ConsoleProgram {
	
	public void run(){
		
		// Initiate an ArrayList which will store all the text as strings from the text file
		ArrayList<String> fileOpened = new ArrayList<String>();
		
		// Open the file
		BufferedReader rd = openFile("Enter name of file to count words from: ");
		
		//Extract all the lines of text into ArrayList
		fileOpened = extractFile(rd);
		
		println("Lines: "+ fileOpened.size());
		println("Words: " + countWords(fileOpened));
		println("Characters: " + countChars(fileOpened));
		
		
		printArrayList(fileOpened);
	}
	
	
	
	//Method for counting words from an arrayList
	private int countWords(ArrayList list){
		int count=0;
		for (int i=0; i<list.size(); i++){
			String line = (String) list.get(i);
			count+=getNumWordsInLine(line);	
		}
		return count;
	}
	
	
	
	//Method for counting characters from an ArrayList
	private int countChars(ArrayList list){
		int count=0;
		for (int i=0; i<list.size(); i++){
			String line = (String) list.get(i);
			for (int j=0; j<line.length(); j++){
					count++;
			}
		}
		return count;
	}
	
	
	
	//Method for counting number of words in a line
	private int getNumWordsInLine(String line){
		int count=0;
		boolean wordFlag = false;
		for (int i=0; i<line.length(); i++){
			if (Character.isLetterOrDigit(line.charAt(i))){
				wordFlag = true;
			}
			if (!Character.isLetterOrDigit(line.charAt(i)) && wordFlag){
				count++;
				wordFlag = false;
			}
			if (wordFlag && i==line.length()-1){
				count++;
				wordFlag = false;
			}
		}	
		return count;
	}
	
	
	
	//Method for printing ArrayList; every element on a new line
	private void printArrayList(ArrayList list){
		for (int i=0; i<list.size();i++){
			println(list.get(i));
		}
	}
	
	
	
	//Method for getting text from a buffered reader file into an ArrayList
	private ArrayList<String> extractFile(BufferedReader rd){
		ArrayList<String> fileArray = new ArrayList<String>();
		
		try {
			while (true){
				String line = rd.readLine();
				if (line == null) {break;}
				fileArray.add(line);
			}
			rd.close();
		}
		catch (IOException ex) {
			throw new ErrorException(ex);
		}
		return fileArray;
	}

	
	
	// Method for opening a text file
	public BufferedReader openFile(String prompt) { 
		BufferedReader rd = null;
		while (rd == null){
			try {
				String filename = readLine(prompt);
				rd = new BufferedReader(new FileReader(filename));
			} catch (IOException ex) {
				println ("File under such name does not exist");
			}
		}
		return rd;
	}
	
	
	
}


