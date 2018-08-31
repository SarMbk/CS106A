/*
 * File: MidpointFindingKarel.java
 * -------------------------------
 * When you finish writing it, the MidpointFindingKarel class should
 * leave a beeper on the corner closest to the center of 1st Street
 * (or either of the two central corners if 1st Street has an even
 * number of corners).  Karel can put down additional beepers as it
 * looks for the midpoint, but must pick them up again before it
 * stops.  The world may be of any size, but you are allowed to
 * assume that it is at least as tall as it is wide.
 */

/*
 * Initial Conditions: 
 * 		No beepers in the world
 * 		Karel starts at the bottom left corner
 */

import stanford.karel.*;

public class MidpointFindingKarel extends SuperKarel {
	public void run() {
		makeRowOfBeepers();
		turnAround();
		goToOppositeEndOfBeeperLine();
		removeBeepersFromEdges();	
		stepOnASpotWiThBeeper();
		faceEast();	
	} 
	

	/*	Makes a row of beepers on all avenues except the first and the last
	 */	
	private void makeRowOfBeepers() {
		while(frontIsClear()) {
			move();
			putBeeper();
		}
		pickBeeper();
	}
	
	
	/*	Turns around and goes to opposite end of beepers
	 * 	Ends up standing on a beeper on the opposite side
	 * 	And facing towards the line of beepers
	 */
	private void goToOppositeEndOfBeeperLine() {
		move();
		while (beepersPresent() && frontIsClear()) {
			move();
		}
		turnAround();
		move();
	}
	
	
	/*	Checks if there is a beeper where he's currently standing
	 *	if yes: checks if there is a beeper right in front
	 *		if yes: he comes back to the original spot 
	 *		and picks a beeper from there
	 *	Then goes to opposite end.
	 */
	private void removeBeepersFromEdges() {
		while (beepersPresent()) {
			ifBeepersInFront_PickEdgeBeeper();
			goToOppositeEndOfBeeperLine();		
		}
	}
	
	/*	Keeps moving till it finds a beeper
	 */
	private void stepOnASpotWiThBeeper() {
		while(noBeepersPresent() && frontIsClear()) {
			move();
		}
	}
	

	private void ifBeepersInFront_PickEdgeBeeper() {
		move();
			if (beepersPresent()) {
				comeBackASpot();
				pickBeeper();
			}
	}
	

	private void comeBackASpot() {
		turnAround();
		move();
		turnAround();
	}
	
	
	private void faceEast() {
		while (notFacingEast()) {
			turnLeft();
		}
	}
	
	
}


	
