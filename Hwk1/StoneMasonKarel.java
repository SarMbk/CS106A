/*
 * File: StoneMasonKarel.java
 * --------------------------
 * The StoneMasonKarel subclass as it appears here does nothing.
 * When you finish writing it, it should solve the "repair the quad"
 * problem from Assignment 1.  In addition to editing the program,
 * you should be sure to edit this comment so that it no longer
 * indicates that the program does nothing.
 */

import stanford.karel.*;

public class StoneMasonKarel extends SuperKarel {

	public void run () {
		//while front is clear makes him go on until it hits the wall
		while (frontIsClear()){
			turnLeft();    
			buildColumn();
			getDown();
			moveFourAvenuesIfYouCan();
		}
		//This last one removes the OBOB
		turnLeft();
		buildColumn();
		getDown();		
	}	

	
	//this makes him put beepers in blank spots till it hits the top
	private void buildColumn() {
		while (frontIsClear()) {
			if (noBeepersPresent()) {
				putBeeper();
				move();
			}
			else{
				move();
			}	
		}
		//this fixes the OBOB
		if (noBeepersPresent()) {
			putBeeper();
		}
	}
	
	
	//turn around and go back down to ground level
	private void getDown() {
		turnAround();
		hitWall();
		turnLeft();
	}
	
	
	//self explanatory
	private void hitWall() {
		while (frontIsClear()) {
			move();
		}
	}
	
	
	//if there is space ahead move four times
	private void moveFourAvenuesIfYouCan() {
		for (int i = 0; i < 4; i++) {
			if (frontIsClear()) {
				move();
			}
		}
	}
	
	
	
	}

			


