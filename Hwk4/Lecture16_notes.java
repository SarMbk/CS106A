import acm.program.*;
import java.util.*;
import java.io.*;
import acm.util.*;

public class Lecture16_notes extends ConsoleProgram {
	
	private static final int SENTINEL = -1;
	private static final int MAX_SIZE = 5;

	public void run() {
		
		/*
		//Arrays
		// This is a little program to keep track of students' scores on midterms
		int[] mid = new int [MAX_SIZE];
		int numScores = 0;
		while(true) {
			int score = readInt("Enter a student's midterm score: ");
			if (score == SENTINEL) {break;}
			mid[numScores++] = score; 
			// note! numScores++ returns current value of numScores;
			// i.e. if numScores=0; then numScore++ will return 0;
			// and will set numScores to 1 only after returning 0;	
			println(Arrays.toString(mid));
		}
		
		//Actual size of array is how big you've declared it to be
		//Effective size is how much of it you are using
		*/
		
		//This is a better program to track students' scores on midterms
		int maxLength = readInt("Enter number of students in your class: ");
		int[] midtermScores = new int [maxLength];
		int numActualScores = 0;
		
		for(int i=0; i<maxLength; i++){
			midtermScores[i]=readInt("Enter a student's score: ");
			if (midtermScores[i]==SENTINEL){break;}
			numActualScores++;
		}
		
		
		int[] exampleArray = new int [10];
		readArray(exampleArray);
		println (Arrays.toString(exampleArray));
		println("Average = " + arrayAverage(exampleArray, 10));
		
		
		arraySwapElements(exampleArray, 0,1);
		println (Arrays.toString(exampleArray));
		
		// This is how to declare an array with values already in it
		int[] exampleArray2 = {1,2,3,4,5};

		
		// post increment x++ returns 6 first and new x is incremented by one so x=7 
		int x = 6;
		println(x++);
		println(x);
		
		
		// pre increment ++y returns an incremented value already and new y is also incremented
		int y = 1;
		println(++y);
		println(y);
		
	}
	
	
	
	// How to define methods with arrays
	private void readArray(int[] arr){
		for (int i=0; i<arr.length; i++){
			arr[i] = readInt("?");
		}
	}
	
	
	private double arrayAverage(int[] arr, int effectiveSize){
		double average = 0;
		for (int i = 0; i<arr.length; i++) {
			average+=arr[i];
		}
		average = average/effectiveSize;
		return average;
	}
	
	private void arraySwapElements(int[] arr, int pos1, int pos2){
		int temp = arr[pos1];
		arr[pos1] = arr[pos2];
		arr[pos2] = temp;
	}

	
	
}
