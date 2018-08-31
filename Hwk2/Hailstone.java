/*
 * File: Hailstone.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the Hailstone problem.
 */

import acm.program.*;

public class Hailstone extends ConsoleProgram {
	public void run() {
		int n = readInt ("Enter a positive integer:  ");
		int count = 0;
		
		while (n!=1) {
			if (n%2==0) {
				n=n/2;
				println(2*n + "  is even, so take half:  " + n);
			}
			else{
				n=n*3+1;
				println((n-1)/3 + "  is odd so I make 3n+1:  " + n);
			}
			count++;
			
		}
		
		println("the process took "+count+" iterations to converge.");
		
	}
}

