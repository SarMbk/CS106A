/*
 * File: FindRange.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the FindRange problem.
 */

import acm.program.*;

public class FindRange extends ConsoleProgram {
	
	private static final int SENTINEL = 0;
	
	
	public void run() {
		int max = 0;
		int min = 0;
		int input = 1;
		int counter = 0;
		
		
		
		
		while (input!=SENTINEL){
			input = readInt ("Enter an int: ");
			if (input>max) {
				max = input;
				if (counter==0){
					min = input;
				}
				counter++;
			} 
			if (input<min && input!=SENTINEL) {
				min = input;
				if (counter==0){
					max = input;
				}
				counter++;
			}		
		}
		
		
		
		
		if (counter==0){
			println("Sentinel value was entered immediately, no values to report");
			} 
		else {
			if (counter==1) {	
				if(max!=0){
					min=max;
				}
				if(min!=0){
					max=min;
				}	
			}
			println(counter);
			println("min = "+min);
			println("max = "+max);
		}
	}
}
