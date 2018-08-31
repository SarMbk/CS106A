import acm.program.*;
import acm.util.ErrorException;

import java.util.*;
import java.io.*;

public class Histogram extends ConsoleProgram {
	
	public void run(){
		
		// Initiate an ArrayList which will store all the text as strings from the text file
		ArrayList<String> fileOpened = new ArrayList<String>();
		
		// Open the file
		BufferedReader rd = openFile("Enter name of file report a score histogram from: ");
		
		//Extract all the lines of text into ArrayList
		fileOpened = extractFile(rd);
		
		// Read and sort all scores by their ranges
		int[] sortedScores=sortScores(fileOpened);
		
		//print all score range histograms
		printHistogram(sortedScores);
		
		printArrayList(fileOpened);
		
	}
	
	
	
	private void printHistogram(int[] sortedScoreArr){
		for (int i=0; i<sortedScoreArr.length; i++){
			String scoresBar="";
			for(int j=0; j<sortedScoreArr[i]; j++){
				scoresBar+="* ";
			}
			if (i==0)			{scoresBar ="range 00 - 09 : " + scoresBar;}
			if (i==10)			{scoresBar ="          100 : " + scoresBar;} 
			if (i>0 && i<10)	{scoresBar ="range " + Integer.toString(i*10) + " - "
										+ Integer.toString(i*10+9) + " : " + scoresBar;}
			
			println(scoresBar);
		}
	}
	
	
	
	private int[] sortScores(ArrayList list){
		int[] sortedScores = new int [11];
		for (int i=0; i<list.size(); i++){
			int score = Integer.parseInt((String) list.get(i));
			sortedScores[score/10]++;
		}
		return sortedScores;
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
		BufferedReader reader=rd;
		
		try {
			while (true){
				String line = reader.readLine();
				if (line == null) {break;}
				fileArray.add(line);
			}
			reader.close();
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


