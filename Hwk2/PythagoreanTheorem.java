/*
 * File: PythagoreanTheorem.java
 * Name: 
 * Section Leader: 
 * -----------------------------
 * This file is the starter file for the PythagoreanTheorem problem.
 */

import acm.program.*;

public class PythagoreanTheorem extends ConsoleProgram {
	public void run() {
		int a=readInt("Enter an int: ");
		int b=readInt("Enter another int: ");
		double c=Math.sqrt((double)(a*a+b*b));
		println("c= " + c);
	}
}
