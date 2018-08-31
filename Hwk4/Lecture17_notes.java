import acm.graphics.GLabel;
import acm.program.*;
import java.util.*;
import java.io.*;
import acm.util.*;


public class Lecture17_notes extends ConsoleProgram {
	
	public void run(){
		
		// Defining Matrices:
		int[][] myMatrix = new int[2][3];
		
		myMatrix[0][0] = 5;
		
		for (int i=0; i<2; i++){
			for (int j = 0; j<3; j++){
				myMatrix[i][j]=1;
			}
		}

		
		// ArrayLists
		
		ArrayList<String> sList = new ArrayList<String>();
		
		readlist(sList);
		printArrayList(sList);
		
		readlist(sList);
		printArrayList(sList);
		
		/*
		 * Arraylists can only hold objects
		 * int boolean double char - are primitive types and therefore cannot be stored in an arraylist
		 * For this there is a way around.
		 * for every primitive type there is a corresponding class type:
		 * Integer, Boolean, Double, Character.
		 */
		
		ArrayList<Integer> intList = new ArrayList<Integer>();
		int x = 6;
		intList.add(x);
		printArrayList(intList);
		int z = intList.get(0);
		println(z);
		
		
		// Initiate an array of 4 GLabel objects
		GLabel[] labels = new GLabel[4];
		
		
		// Initiate an arraylist of GLabel objects
		ArrayList <GLabel> g1 = new ArrayList<GLabel>();
		
	}
	
	
	
	private void readlist(ArrayList list){
		while(true){
			String line = readLine("Enter an element of an arrayList: ");
			if (line.equals("")) break;
			list.add(line);
		}	
	}
	
	
	
	private void printArrayList(ArrayList list){
		println("List contains "+ list.size() + " elements: ");
		for (int i=0; i<list.size(); i++){
			println(i + ": " + list.get(i));
			}
	}
	
	
	
}

	
	
	

