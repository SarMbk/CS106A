/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;
/*Initial conditions: Karel starts at the bottom left corner
the world is clear of beepers*/

	public class CheckerboardKarel extends SuperKarel 
	{	
		public void run () {
			findFreePath();
			makeRowCheckered();
			makeRowsAboveCheckered();		
		}
		
		
		// Keep turning left until you see the front is clear
		private void findFreePath() {
			while (frontIsBlocked()) {
				turnLeft();
			}
		}
		
		
		/* while there is space ahead: move a space, check if there is another space.
		 * if there is, then put a beeper and move a space.
		 * it will keep repeating till it hits the wall. */
		private void makeRowCheckered() {
			while (frontIsClear()) {
				move();
				if (frontIsClear()) {
					putBeeper(); move();
				}
			}
		ensureNoObobsAndComeBack (); //see right below
			}	
			
		
		/* For the makeRowCheckered to work with both odd and even numbers of alleys
		 * Come back one spot, check if there is  no beeper
		 * if there is no beeper then turn around, 
		 * move one spot and put a beeper on the last avenue 
		 * if there is a beeper just come back to the start of row */
		private void ensureNoObobsAndComeBack () {
			turnAround();
			move();
			if (noBeepersPresent()) {
				turnAround();
				move();
				putBeeper();
				turnAround();
				hitWallnTurn();
			}
				else {
				hitWallnTurn();
				}
		}

	
		//move to wall and turn around
		private void hitWallnTurn() {
			while(frontIsClear()) {
				move();
			}
			turnAround();
		}
		
		
		/*you always make a row checkered and come back to the leftmost avenue
		 * it keeps repeating while there is space above
		 * so if you started a row with an empty spot, the row above should start 
		 * with a beeper and vice versa. So it checks if there is a beeper on its initial
		 * spot. If there is, he moves up and starts a row with an empty space.
		 * if there isn't he just moves up a row and makes row checkered */
		private void makeRowsAboveCheckered () {
			while (leftIsClear()){
				if (noBeepersPresent()) {
					repositionToRowAbove(); 
					putBeeper();
					move();
					makeRowCheckered ();
				}
				else{
					repositionToRowAbove(); 
					makeRowCheckered ();
				}
			}
		}
		
		
		//Just move up one row and face right
		private void repositionToRowAbove() {
			turnLeft();
			move();
			turnRight();
		}
		}
	