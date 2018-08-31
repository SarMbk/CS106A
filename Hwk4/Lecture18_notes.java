import acm.graphics.GLabel;
import acm.program.*;
import java.util.*;
import java.io.*;
import acm.util.*;


public class Lecture18_notes extends ConsoleProgram {
	
	public void run(){
		int numScores = readInt("Enter the number of scores: ");
		scores = new int[2][numScores];
		
		String str = readLine("?");
		boolean result = str.equals("hello");
		if (result){
			println("works");
		} else {
			println("b/s");
		}
		
		//Multidimensional arrays
		initScores();
		println("scores[0] before increment: ");
		printList(scores[0]);
		
		incrementScoreList(scores[0]);
		println("scores[0] after increment: ");
		printList(scores[0]);
		
		
		
		//Arraylists
		initScores2(numScores);
		println("scoresArrayList[0] before increment: ");
		printArrayList(scores2);
		
		incrementScoreList2();
		println("scores[0] after increment: ");
		printArrayList(scores2);
		
		
	}
	
	
	// Multidimensional array methods
	private void initScores(){
		for(int i=0; i<scores.length; i++){
			for (int j=0; j<scores[0].length; j++){
				scores[i][i]=0;
			}		
		}
	}
	
	private void printList(int list[]){
		for (int i=0; i<list.length; i++){
			println(list[i]);
		}
	}
	
	private void incrementScoreList(int list[]){
		for (int i=0; i<list.length; i++){
			list[i]+=1;
		}
	}
	
	
	
	//Arraylist methods
	private void initScores2(int numScores){
		for(int i=0; i<numScores; i++){
			scores2.add(0);
		}
	}
	
	private void incrementScoreList2(){
		for (int i=0; i<scores2.size(); i++){
			scores2.set(i, scores2.get(i)+1);
		}
	}
	
	
	private void printArrayList(ArrayList list){
		for (int i=0; i<list.size();i++){
			println(list.get(i));
		}
	}
	
	
	private int[][] scores;
	ArrayList<Integer> scores2 = new ArrayList<Integer>();
	
	
	

}
