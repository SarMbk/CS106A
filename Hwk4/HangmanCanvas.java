/*
 * File: HangmanCanvas.java
 * ------------------------
 * This file keeps track of the Hangman display.
 */

import java.awt.Color;

import acm.graphics.*;

public class HangmanCanvas extends GCanvas {

	
	
/** Resets the display so that only the scaffold appears */
	public void reset() {
		removeAll();
		addScaffold();
	}

	
	
/**
 * Updates the word on the screen to correspond to the current
 * state of the game.  The argument string shows what letters have
 * been guessed so far; unguessed letters are indicated by hyphens.
 */
	public void displayWord(String word) {
		
		// This conditional statement removes the current GLabel
		if (getElementAt(WIP_X, WIP_Y)!= null) {
			GObject prevLabel = getElementAt(WIP_X, WIP_Y);
			remove(prevLabel);
		}
				
		
		GLabel wordInProgress = new GLabel (word, WIP_X, WIP_Y);
		wordInProgress.setFont("TimesNewRoman-24");
		wordInProgress.setColor(Color.BLACK);
		add(wordInProgress);
	}

/**
 * Updates the display to correspond to an incorrect guess by the
 * user.  Calling this method causes the next body part to appear
 * on the scaffold and adds the letter to the list of incorrect
 * guesses that appears at the bottom of the window.
 */
	public void noteIncorrectGuess(String wrongGuesses) {
		// This conditional statement removes the current GLabel
		if (getElementAt(WG_X, WG_Y)!= null) {
			GObject prevLabel = getElementAt(WG_X, WG_Y);
			remove(prevLabel);
		}
		
		GLabel incorrectGuesses = new GLabel (wrongGuesses, WG_X, WG_Y);
		incorrectGuesses.setFont("TimesNewRoman-12");
		incorrectGuesses.setColor(Color.BLACK);
		add(incorrectGuesses);
	}
	
	
	
/* Defining additional public methods that have to do with adding objects to the canvas*/
	
	// Method for adding a body part to canvas depending on how many lives u have left
	public void addBodyPart(int lives){
		switch (lives) {
		case 8:
			break;
		case 7:
			addHead();
			break;
		case 6:
			addBody();
			break;
		case 5:
			addLeftArm();
			break;
		case 4:
			addRightArm();
			break;
		case 3:
			addLeftLeg();
			break;
		case 2:
			addRightLeg();
			break;
		case 1:
			addLeftFoot();
			break;
		case 0:
			addRightFoot();
			break;
		}		
	}
	
	
	
	// Method for adding a scaffold
	public void addScaffold(){
		GLine scaffoldPole = new GLine 
		(getWidth()/2-BEAM_LENGTH/2, SCAFFOLD_BOTTOM_Y,getWidth()/2-BEAM_LENGTH/2, SCAFFOLD_BOTTOM_Y-SCAFFOLD_HEIGHT);
		
		GLine scaffoldBeam = new GLine 
		(getWidth()/2-BEAM_LENGTH/2, SCAFFOLD_BOTTOM_Y-SCAFFOLD_HEIGHT, getWidth()/2+BEAM_LENGTH/2, SCAFFOLD_BOTTOM_Y - SCAFFOLD_HEIGHT);
		
		GLine rope = new GLine 
		(getWidth()/2+BEAM_LENGTH/2, SCAFFOLD_BOTTOM_Y-SCAFFOLD_HEIGHT ,getWidth()/2+BEAM_LENGTH/2, SCAFFOLD_BOTTOM_Y-SCAFFOLD_HEIGHT+ROPE_LENGTH);
		
		add(scaffoldPole);
		add(scaffoldBeam);
		add(rope);
	}
	
	
	
	// Methods for adding body parts
	public void addHead(){
		GOval head = new GOval 
		(getWidth()/2+BEAM_LENGTH/2-HEAD_RADIUS, SCAFFOLD_BOTTOM_Y-SCAFFOLD_HEIGHT+ROPE_LENGTH, 2*HEAD_RADIUS, 2*HEAD_RADIUS);
		add(head);
	}
	
	

	public void addBody(){
		GLine body = new GLine
		(getWidth()/2+BEAM_LENGTH/2, SCAFFOLD_BOTTOM_Y-SCAFFOLD_HEIGHT+ROPE_LENGTH+2*HEAD_RADIUS, 
		 getWidth()/2+BEAM_LENGTH/2, SCAFFOLD_BOTTOM_Y-SCAFFOLD_HEIGHT+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH);
		add(body);
	}
	
	

	public void addLeftArm(){
		GLine arm = new GLine
		(getWidth()/2+BEAM_LENGTH/2, SCAFFOLD_BOTTOM_Y-SCAFFOLD_HEIGHT+ROPE_LENGTH+2*HEAD_RADIUS+ARM_OFFSET_FROM_HEAD, 
		 getWidth()/2+BEAM_LENGTH/2-UPPER_ARM_LENGTH, SCAFFOLD_BOTTOM_Y-SCAFFOLD_HEIGHT+ROPE_LENGTH+2*HEAD_RADIUS+ARM_OFFSET_FROM_HEAD);
		
		GLine forearm = new GLine
		(getWidth()/2+BEAM_LENGTH/2-UPPER_ARM_LENGTH, SCAFFOLD_BOTTOM_Y-SCAFFOLD_HEIGHT+ROPE_LENGTH+2*HEAD_RADIUS+ARM_OFFSET_FROM_HEAD,
	     getWidth()/2+BEAM_LENGTH/2-UPPER_ARM_LENGTH, SCAFFOLD_BOTTOM_Y-SCAFFOLD_HEIGHT+ROPE_LENGTH+2*HEAD_RADIUS+ARM_OFFSET_FROM_HEAD+LOWER_ARM_LENGTH);
		
		add(arm);
		add(forearm);
	}
	
	
	
	public void addRightArm(){
		GLine arm = new GLine
		(getWidth()/2+BEAM_LENGTH/2, SCAFFOLD_BOTTOM_Y-SCAFFOLD_HEIGHT+ROPE_LENGTH+2*HEAD_RADIUS+ARM_OFFSET_FROM_HEAD, 
		 getWidth()/2+BEAM_LENGTH/2+UPPER_ARM_LENGTH, SCAFFOLD_BOTTOM_Y-SCAFFOLD_HEIGHT+ROPE_LENGTH+2*HEAD_RADIUS+ARM_OFFSET_FROM_HEAD);
		
		GLine forearm = new GLine
		(getWidth()/2+BEAM_LENGTH/2+UPPER_ARM_LENGTH, SCAFFOLD_BOTTOM_Y-SCAFFOLD_HEIGHT+ROPE_LENGTH+2*HEAD_RADIUS+ARM_OFFSET_FROM_HEAD,
	     getWidth()/2+BEAM_LENGTH/2+UPPER_ARM_LENGTH, SCAFFOLD_BOTTOM_Y-SCAFFOLD_HEIGHT+ROPE_LENGTH+2*HEAD_RADIUS+ARM_OFFSET_FROM_HEAD+LOWER_ARM_LENGTH);
		
		add(arm);
		add(forearm);
	}
	
	
	
	public void addLeftLeg(){
		GLine hip = new GLine
		(getWidth()/2+BEAM_LENGTH/2, SCAFFOLD_BOTTOM_Y-SCAFFOLD_HEIGHT+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH, 
		 getWidth()/2+BEAM_LENGTH/2-HIP_WIDTH, SCAFFOLD_BOTTOM_Y-SCAFFOLD_HEIGHT+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH);
		
		GLine leg = new GLine
		(getWidth()/2+BEAM_LENGTH/2-HIP_WIDTH, SCAFFOLD_BOTTOM_Y-SCAFFOLD_HEIGHT+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH, 
		 getWidth()/2+BEAM_LENGTH/2-HIP_WIDTH, SCAFFOLD_BOTTOM_Y-SCAFFOLD_HEIGHT+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH+LEG_LENGTH);
		
		add(hip);
		add(leg);
	}
	
	
	
	public void addRightLeg(){
		GLine hip = new GLine
		(getWidth()/2+BEAM_LENGTH/2, SCAFFOLD_BOTTOM_Y-SCAFFOLD_HEIGHT+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH, 
		 getWidth()/2+BEAM_LENGTH/2+HIP_WIDTH, SCAFFOLD_BOTTOM_Y-SCAFFOLD_HEIGHT+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH);
		
		GLine leg = new GLine
		(getWidth()/2+BEAM_LENGTH/2+HIP_WIDTH, SCAFFOLD_BOTTOM_Y-SCAFFOLD_HEIGHT+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH, 
		 getWidth()/2+BEAM_LENGTH/2+HIP_WIDTH, SCAFFOLD_BOTTOM_Y-SCAFFOLD_HEIGHT+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH+LEG_LENGTH);
		
		add(hip);
		add(leg);
	}
	
	
	
	public void addLeftFoot(){
		GLine foot = new GLine
		(getWidth()/2+BEAM_LENGTH/2-HIP_WIDTH, SCAFFOLD_BOTTOM_Y-SCAFFOLD_HEIGHT+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH+LEG_LENGTH,  
		 getWidth()/2+BEAM_LENGTH/2-HIP_WIDTH-FOOT_LENGTH, SCAFFOLD_BOTTOM_Y-SCAFFOLD_HEIGHT+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH+LEG_LENGTH);
		
		add(foot);
	}
	
	
	
	public void addRightFoot(){
		GLine foot = new GLine
		(getWidth()/2+BEAM_LENGTH/2+HIP_WIDTH, SCAFFOLD_BOTTOM_Y-SCAFFOLD_HEIGHT+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH+LEG_LENGTH,  
		 getWidth()/2+BEAM_LENGTH/2+HIP_WIDTH+FOOT_LENGTH, SCAFFOLD_BOTTOM_Y-SCAFFOLD_HEIGHT+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH+LEG_LENGTH);
		
		add(foot);
	}
	
	
	
/* Constants for the simple version of the picture (in pixels) */
	private static final int SCAFFOLD_HEIGHT = 360;
	private static final int SCAFFOLD_BOTTOM_Y = 400;
	private static final int BEAM_LENGTH = 144;
	private static final int ROPE_LENGTH = 18;
	private static final int HEAD_RADIUS = 36;
	private static final int BODY_LENGTH = 144;
	private static final int ARM_OFFSET_FROM_HEAD = 28;
	private static final int UPPER_ARM_LENGTH = 72;
	private static final int LOWER_ARM_LENGTH = 44;
	private static final int HIP_WIDTH = 36;
	private static final int LEG_LENGTH = 108;
	private static final int FOOT_LENGTH = 28;
	

/* Constants for x and y location of wordInProgress on canvas */
	// WIP STANDS FOR WORD IN PROGRESS
	public static final int WIP_X=75;
	public static final int WIP_Y=450;

/* Constants for x and y location of incorrect guesses displayed on canvas */
	// WG STANDS FOR WRONG GUESS
	public static final int WG_X=75;
	public static final int WG_Y=480;
}
