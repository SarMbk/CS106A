/*
 * File: Yahtzee.java
 * ------------------
 * This program will eventually play the Yahtzee game.
 */

import java.util.ArrayList;
import acm.io.*;
import acm.program.*;
import acm.util.*;




public class Yahtzee extends GraphicsProgram implements YahtzeeConstants {
	
	
	
	public static void main(String[] args) {
		new Yahtzee().start(args);
	}
	
	
	
	public void run() {
		IODialog dialog = getDialog();
		nPlayers = dialog.readInt("Enter number of players");
		playerNames = new String[nPlayers];
		for (int i = 1; i <= nPlayers; i++) {
			playerNames[i-1] = dialog.readLine("Enter name for player " + i);
		}
		display = new YahtzeeDisplay(getGCanvas(), playerNames);
		playGame();
	}


//==========================================PRIVATE METHODS================================================//
	
	private void playGame() {
		
		initTrackers();
		
		while(doesArrayContain(cuBoard, false)){
			for (int i=1; i<=nPlayers; i++) {
				
				
			
				// Set initial roll to all zeros
				int[] dice = {0,0,0,0,0};
				
				for (int j=1; j<=MAX_N_ROLLS; j++){
					
				
					if (j==1){
						display.printMessage(playerNames[plr(i)] + "'s turn! Click 'ROLL DICE' button to roll dice.");
						display.waitForPlayerToClickRoll(i);
						dice = rollFirstDice(dice);
						//dice = {6,6,6,6,6};
						display.displayDice(dice);	
					}
				
					if (j>1){
						display.printMessage("Select the dice you wish to re-roll and click 'ROLL AGAIN'");						
						display.waitForPlayerToSelectDice();
						//dice = {6,6,6,6,6};
						dice=rollDice(dice);
						display.displayDice(dice);
					}	
				}
			
				updateScoreCard(i, dice);
			}
		}
		
		// Determine what is the maximum score
		int winnerScore = findMaxScore(scoreBoard);
		
		// Determine the index number of the player or players who have the highest score (or scores)
		int[] winnerIndices = indexOfWinners(scoreBoard, winnerScore);
		
		// Compose and display a string declaring the winner's name and print it out
		String winnerDeclaration = declareWinner(winnerIndices);
		
		display.printMessage(winnerDeclaration);
		
	}
	
	

	
	/**Method that accepts a 2d int[][] type array representing the scoreboard as a parameter, 
	 * and returns an int representing the max total score value. Works for this game only. Not usable outside of this game.
	 * must accept the scoreBoard 2d array as a parameter.
	 * */
	private int findMaxScore(int[][] scoreBoard) {
		
		// initialize a 1d array where all total scores for all players will be copied
		int[] totalScores = new int [nPlayers];
		
		// Copy all total score values from the score-board 2d array to this 1D array
		for (int i=1; i<=nPlayers; i++){
			totalScores[plr(i)] = scoreBoard[plr(i)][cgry(TOTAL)];
		}
		
		// find the maximum score in this 1D array
	    int maxScore = totalScores[plr(1)]; 
	    for(int i=1;i <= nPlayers;i++){ 
	      if(totalScores[plr(i)] > maxScore){ 
	         maxScore = totalScores[plr(i)]; 
	      } 
	    }
	    
		return maxScore;
	}
	
	
	
	
	/**	Method that accepts the 2d scoreBoard array and an int type parameter representing the max score.
	 * 	returns a 1d int[] type array containing the indexes of all players that have this score
	 * 	e.g. if there are 4 players and the total score at the end of game is [117, 100, 117, 117]
	 * 	calling the method like this: indexofWinners (scoreboard, 117)
	 * 	will return [0,2,3] 
	 * */
	private int[] indexOfWinners(int [][] scoreBoard, int maxScore) {
		
		// initialize a 1d array where all total scores for all players will be copied
		int[] totalScores = new int [nPlayers];
		
		// Copy all total score values from the score-board 2d array to this 1D array
		for (int i=1; i<=nPlayers; i++){
			totalScores[plr(i)] = scoreBoard[plr(i)][cgry(TOTAL)];
		}
		
		// Create an ArrayList that will store indices of the max value
	    ArrayList<Integer> indices = new ArrayList<Integer>();
	    for (int i = 1; i <= nPlayers; i++) {
	        if (totalScores[plr(i)]==maxScore) {
	            indices.add(plr(i));
	        }
	    }
	    
	    // ArrayList<Integer> to int[] conversion
	    int[] result = new int[indices.size()];
	    for (int i = 0; i < indices.size(); i++) {
	        result[i] = indices.get(i);
	    }
	    return result;
	}
	
	
	
	
	/** Method that accepts an array of indices of winners and makes a String type sentence which spells out
	 * 	the winner(s) of the game. This method is needed to create a string and use in display.printMessage 
	 * 	at the end of the game. Parameter winnerIndices is gotten by using the method indexOfWinners.
	 */
	private String declareWinner(int[] winnerIndices){
		
		String winnerDeclaration;
		
		if (winnerIndices.length==1){
			winnerDeclaration = "The Game is Finished. Congratulations " + playerNames[winnerIndices[0]] + "! You won!";
		} else {
			winnerDeclaration = "Congratulations ";
			for (int i=0; i<winnerIndices.length; i++){			
				if (i == winnerIndices.length -1) {
					winnerDeclaration+=	"and " + playerNames[winnerIndices[i]] + 
										"! There is a draw between the " 
										+ winnerIndices.length + " of you!";
				} else {
					winnerDeclaration+= playerNames[winnerIndices[i]] + ", ";
				}	
			}
		}
		return winnerDeclaration;
	}
	
	
	
	
	/** Method that accepts an int representing the player index (e.g. 1,2,3 or 4 but not 0!) and an int[] array representing the dice.
	 *  Updates the score board for that player.*/
	private void updateScoreCard(int playerIndex, int[] dice){		
		
		// create a flag that will tell us when to break out of the following while loop
		boolean flag = true;
		
		while (flag){
			
			// ask the player to select the category
			display.printMessage("Select a category for this roll");	
			int category = display.waitForPlayerToSelectCategory();
			
			
			// if the dice contains the selected category
			if(checkCategory(dice,category)){
				// if the selected category hasn't been used before
				if (cuBoard[plr(playerIndex)][cgry(category)]==false){
					// update the score card based on the selection
					display.updateScorecard(category, playerIndex, countPoints(dice, category));
					
					// mark the category for this player as used so he could not use it again in the next turn
					cuBoard[plr(playerIndex)][cgry(category)]=true;
					
					// update the scores in the internal scoreBoard
					scoreBoard[plr(playerIndex)][cgry(category)] = countPoints(dice, category);
					
					// change the flag to break out of the loop
					flag = false;
					
					
				} else {
					display.printMessage("YOU CANNOT SELECT THE SAME CATEGORY TWICE");					
				}
			}
			
			// Similarly to above, except if the dice does not contain the selected category, give the player zero points for
			// that category
			if (!checkCategory(dice, category)){
				if(cuBoard[plr(playerIndex)][cgry(category)]==false){
					display.updateScorecard(category, playerIndex, countPoints(dice, category));
					cuBoard[plr(playerIndex)][cgry(category)]=true;
					flag = false;
				} else {
					display.printMessage("YOU CANNOT SELECT THE SAME CATEGORY TWICE");
				}
			}	
		}
		
		// update all totals in the internal score tracking matrix (scoreBoard)
		updateTotals(playerIndex);
		
		// update all upper and lower score on the display
		display.updateScorecard(UPPER_SCORE, playerIndex, scoreBoard[plr(playerIndex)][cgry(UPPER_SCORE)]);
		display.updateScorecard(LOWER_SCORE, playerIndex, scoreBoard[plr(playerIndex)][cgry(LOWER_SCORE)]);

		// if there are bonus points show bonus points on display
		if (scoreBoard[plr(playerIndex)][cgry(UPPER_BONUS)]>0){
			display.updateScorecard(UPPER_BONUS, playerIndex, BONUS_POINTS);
		}
		
		// update the total score on the display
		display.updateScorecard(TOTAL, playerIndex, scoreBoard[plr(playerIndex)][cgry(TOTAL)]);
	}
	
	
	
	
	/** Method that checks if a true or false element is contained in a 2D array of boolean type, returns true if the element exists in an array
	 * returns false if not. Input your array as an argument and an element whose presence you want to check for. e.g. if you 
	 * call:
	 * doesArrayContain({false,false}, true)
	 * it will return false because your argument array does not contain true
	 */
	private boolean doesArrayContain(boolean[][] array, boolean element) {
		
		for (int i = 0; i<nPlayers; i++){
			for (int j=0; j<TOTAL; j++){
				if (array[i][j]==element){
					return true;
				}
			}
		}
		return false;
	}
	
	
	
	
	/** Method that updates upper score, lower score, bonus (if any) for a player. Takes a player input as an argument */
	private void updateTotals (int playerIndex) {
		
		int upperScore = 0;
		int lowerScore = 0;
		int bonus = 0;
		
		// Add up all the points in the upper category and update the upper score on the internal board
		for (int i = cgry(ONES); i<= cgry(SIXES); i++){
			upperScore+=scoreBoard[plr(playerIndex)][i];
		}
		scoreBoard[plr(playerIndex)][cgry(UPPER_SCORE)] = upperScore;
		
		// Check if the player has enough points for upper bonus, if yes, give bonus points
		if (scoreBoard[plr(playerIndex)][cgry(UPPER_SCORE)]>=UPPER_SCORE_FOR_BONUS){
			bonus = BONUS_POINTS;
			scoreBoard[plr(playerIndex)][cgry(UPPER_BONUS)]=bonus;
		}
		
		
		// Add up all the points in the upper category and update the upper score on the internal board
		for (int i = cgry(THREE_OF_A_KIND); i<= cgry(CHANCE); i++){
			lowerScore+=scoreBoard[plr(playerIndex)][i];
		}
		scoreBoard[plr(playerIndex)][cgry(LOWER_SCORE)] = lowerScore;
		
		// Add up totals
		scoreBoard[plr(playerIndex)][cgry(TOTAL)] = upperScore + lowerScore + bonus;
		
	}
	
	
	
	
	/** Method that accepts an int[] array representing the dice and returns and int representing the 
	 *  the points a player gets with his/her dice for a selected category.*/
	private int countPoints(int[] dice, int category){
		int sum=0;
		
		// if the selected category is an upper category (ones, twos, threes, fours, fives, sixes)
		if (category>=ONES && category<=SIXES){
			for (int i=0; i<dice.length; i++){
				if (dice[i]==category){
					sum+=dice[i];
				}
			}	
		}
		
		// if the selected category is a lower category 
		// (three of a kind, four of a kind, small straight, large straight, yahtzee)
		if (category==THREE_OF_A_KIND){
			sum = threeOfaKind(dice);
		}
		
		if (category==FOUR_OF_A_KIND){
			sum = fourOfaKind(dice);
		}
		
		if (category==YAHTZEE){
			sum = yahtzee(dice);
		}
		
		if (category==FULL_HOUSE){
			sum = fullHouse(dice);
		}
		
		if (category==SMALL_STRAIGHT){
			sum = smallStraight(dice);
		}
		
		if (category==LARGE_STRAIGHT){
			sum = largeStraight(dice);
		}
		
		// if the selected category is Chance, just sum all dice
		if (category==CHANCE){
			for (int i=0; i<dice.length; i++){
				sum+=dice[i];
			}	
		}
		
		return sum;
	}
	
	
	
	
	/** Method that accepts an int[] array representing the player's thrown dice.
	 *  Returns an int representing the score if the dice shows three of a kind; else returns zero.*/
	private int threeOfaKind(int[] dice){
		
		//Initiate scoreMatrix where all dice are sorted.
		//Number shown on dice = scoreMatrix index.
		ArrayList<Integer>[]scoreMatrix = sortDice(dice);
		
		
		// Check if there is a three of a kind in our sorted array. 
		// If there is, return the points gotten by a three of a kind.
		// Otherwise return zero.	
		int result = 0;
		for (int i=1; i<scoreMatrix.length; i++){
			
			if (scoreMatrix[i].size() >= 3){
				for (int j=0; j<3; j++){
					result+=scoreMatrix[i].get(j);
				}
			return result;
			}
		}
		return 0;	
	}
	
	
	
	
	/** Method that accepts an int[] array representing the player's thrown dice.
	 *  Returns and int representing the score if the dice shows four of a kind; else returns zero.*/
	private int fourOfaKind(int[] dice){
		
		//Initiate scoreMatrix where all dice are sorted.
		//Number shown on dice = scoreMatrix index.
		ArrayList<Integer>[]scoreMatrix = sortDice(dice);
		
		// Check if there is a four of a kind in our sorted array. 
		// If there is, return the points gotten by a four of a kind.
		// Otherwise return zero.	
		int result = 0;
		for (int i=1; i<scoreMatrix.length; i++){
			if (scoreMatrix[i].size() >= 4){
				for (int j=0; j<4; j++){
					result+=scoreMatrix[i].get(j);
				}
			return result;
			}
		}
		return 0;	
	}
	
	
	
	
	/** Method that accepts an int[] array representing the player's thrown dice.
	 *  Returns and int representing the score if the dice shows a full house combination; else returns zero.*/
	private int fullHouse(int[] dice){
		
		//Initiate scoreMatrix where all dice are sorted.
		//Number shown on dice = scoreMatrix index.
		ArrayList<Integer>[]scoreMatrix = sortDice(dice);
		
		
		// Check if there is a full house in our sorted array. 
		// If there is, return the points gotten by a full house.
		// Otherwise return zero.	
		
		//Initialize an array of size 2 of ArrayLists
		ArrayList<Integer>[]fullHouseMatrix = new ArrayList[2];
		
		// Place the three of a kind part of full-house into the zeroth element of the full-house matrix
		// and place the two of a kind part of full house into the first element of the full house matrix
		for (int i=1; i<scoreMatrix.length; i++){
			if (scoreMatrix[i].size() == 3) {fullHouseMatrix[0] = scoreMatrix[i];}
			if (scoreMatrix[i].size() == 2) {fullHouseMatrix[1] = scoreMatrix[i];}	
		}
		
		// if any element of the full house matrix is null, then the dice has no full house, so return zero
		if (fullHouseMatrix[0]==null || fullHouseMatrix[1] == null){
			return 0;
		} else {
			return FULL_HOUSE_SCORE;
		}

	}
	
	
	
	
	/** Method that accepts an int[] array representing the player's thrown dice.
	 *  Returns and int representing the score if the dice shows a SMALL STRAIGHT combination; else returns zero.*/
	private int smallStraight(int[] dice){
		
		//Initiate scoreMatrix where all dice are sorted.
		//Number shown on dice = scoreMatrix index.
		ArrayList<Integer>[]scoreMatrix = sortDice(dice);
		
		
		// Check if there is a small straight in our sorted array. 
		// If there is, return the points gotten by a full house.
		// Otherwise return zero.	
		
		if(scoreMatrix[ONES].size()==1 && scoreMatrix[TWOS].size()==1 && scoreMatrix[THREES].size()==1
		&& scoreMatrix[FOURS].size()==1 && scoreMatrix[FIVES].size()==1 && scoreMatrix[SIXES].size()==0){
			return SMALL_STRAIGHT_SCORE;
		}
		return 0;
	}
	
	
	
	
	/** Method that accepts an int[] array representing the player's thrown dice.
	 *  Returns and int representing the score if the dice shows a LARGE STRAIGHT combination; else returns zero.*/
	private int largeStraight(int[] dice){
		
		//Initiate scoreMatrix where all dice are sorted.
		//Number shown on dice = scoreMatrix index.
		ArrayList<Integer>[]scoreMatrix = sortDice(dice);
		
		
		// Check if there is a small straight in our sorted array. 
		// If there is, return the points gotten by a full house.
		// Otherwise return zero.	
		
		if(scoreMatrix[ONES].size()==0 && scoreMatrix[TWOS].size()==1 && scoreMatrix[THREES].size()==1
		&& scoreMatrix[FOURS].size()==1 && scoreMatrix[FIVES].size()==1 && scoreMatrix[SIXES].size()==1){
			return LARGE_STRAIGHT_SCORE;
		}
		return 0;
	}
	

	
	
	/** Method that accepts an int[] array representing the player's thrown dice.
	 *  Returns and int representing the score if the dice shows yahtzee; else returns zero.*/
	private int yahtzee (int[] dice){
		//initiate an empty arraylist. Assign the first dice value to it.
		ArrayList<Integer> yahtzeeArray = new ArrayList<Integer>();
		yahtzeeArray.add(dice[0]);
		
		// if other dice are the same as first dice, add them to arraylist.
		for (int i=1; i<dice.length; i++){
			if(dice[i]==yahtzeeArray.get(0)){
				yahtzeeArray.add(dice[i]);
			}
		}
		
		// Yahtzee means all five dice are the same. So if there is yahtzee, length of the
		// initiated arraylist will be the same as the number of dice. If it is, return 50, else return 0.
		if (yahtzeeArray.size()==dice.length){
			return YAHTZEE_SCORE;
		}
		return 0;
	}
	
	
	
	
	/** Method that accepts an int[] type array (representing the five rolled dice.
	 *  Returns a 1x7 array. Each cell contains an arraylist representing dice of the same kind.
	 *  Zeroth element of an array is never used. it is always null!
	 *  index 1 of the output array is an arraylist containing all ones, index two - twos etc.
	 *  e.g. if the dice are 1,1,3,3,6 then the output will be:
	 *  [ (null); (1,1); (null); (3,3); (null); (null); (6)] 
	 * */
	private ArrayList<Integer>[] sortDice(int[] dice){
		
		//Initiate an Array of Arraylists. Element at index zero will not be used, that's why the length is seven.
		ArrayList<Integer>[]scoreMatrix = new ArrayList[7];
		
		
		
		// Initiate six different empty arraylists. 
		// There we will separately store ones, twos, threes, fours, fives and sixes 
		// of our rolled dice.
		ArrayList<Integer> numOfOnes = new ArrayList<Integer>();
		ArrayList<Integer> numOfTwos = new ArrayList<Integer>();
		ArrayList<Integer> numOfThrees = new ArrayList<Integer>();
		ArrayList<Integer> numOfFours = new ArrayList<Integer>();
		ArrayList<Integer> numOfFives = new ArrayList<Integer>();
		ArrayList<Integer> numOfSixes = new ArrayList<Integer>();
		
		
		// Sort ones, twos etc. into their respective arraylists.
		for (int i=0; i<dice.length; i++){
			if (dice[i]==ONES) {numOfOnes.add(dice[i]);}
			if (dice[i]==TWOS) {numOfTwos.add(dice[i]);}
			if (dice[i]==THREES) {numOfThrees.add(dice[i]);}
			if (dice[i]==FOURS) {numOfFours.add(dice[i]);}
			if (dice[i]==FIVES) {numOfFives.add(dice[i]);}
			if (dice[i]==SIXES) {numOfSixes.add(dice[i]);}
		}
		
		// Place the arraylists containing ones, twos etc. into an array of arraylists.
		// Using this array will help us easily check if there is a full house.
		scoreMatrix[ONES] = numOfOnes;
		scoreMatrix[TWOS] = numOfTwos;
		scoreMatrix[THREES] = numOfThrees;
		scoreMatrix[FOURS] = numOfFours;
		scoreMatrix[FIVES] = numOfFives;
		scoreMatrix[SIXES] = numOfSixes;
		
		return scoreMatrix;
	}
	
	
	
	
	/**	Method that takes in an array representing thrown dice as a parameter and an integer representing the category
	 * returns true if the dice contains the category, else returns false
	 */
	private boolean checkCategory(int[] dice, int category){
		
		//Initiate scoreMatrix where all dice are sorted.
		//Score matrix is an array of objects, and the objects are of type ArrayList<Integer>
		//Number shown on dice = scoreMatrix index.
		ArrayList<Integer>[]scoreMatrix = sortDice(dice);
		
		boolean result = false;
		
		if (category == ONES) {
			if (scoreMatrix[ONES]!=null){
				result = true;
			}
		}
		
		if (category == TWOS) {
			if (scoreMatrix[TWOS]!=null){
				result = true;
			}
		}
		
		if (category == THREES) {
			if (scoreMatrix[THREES]!=null){
				result = true;
			}
		}
		
		if (category == FOURS) {
			if (scoreMatrix[FOURS]!=null){
				result = true;
			}
		}
		
		if (category == FIVES) {
			if (scoreMatrix[FIVES]!=null){
				result = true;
			}
		}
		
		if (category == SIXES) {
			if (scoreMatrix[SIXES]!=null){
				result = true;
			}
		}
		
		if (category == THREE_OF_A_KIND) {
			for (int i=1; i<scoreMatrix.length; i++){
				if (scoreMatrix[i].size()>=3) {
					result = true;
				}
			}
		}
		
		if (category == FOUR_OF_A_KIND) {
			for (int i=1; i<scoreMatrix.length; i++){
				if (scoreMatrix[i].size()>=4) {
					result = true;
				}
			}
		}
		
		if (category == FULL_HOUSE) {
			for (int i=1; i<scoreMatrix.length; i++){
				if (scoreMatrix[i].size()==2) {
					for (int j=1; j<scoreMatrix.length; j++){
						if (scoreMatrix[j].size()==3){
							result = true;
						}
					}
				}
			}
		}
		
		if (category == SMALL_STRAIGHT) {
			result = true;
			for (int i=ONES; i<=FIVES; i++){
				if (scoreMatrix[i].size() !=1) {
					result = false;
				}
			}
		}
		
		if (category == LARGE_STRAIGHT) {
			result = true;
			for (int i=TWOS; i<=SIXES; i++){
				if (scoreMatrix[i].size() !=1) {
					result = false;
				}
			}
		}

		if (category == YAHTZEE) {
			for (int i=1; i<scoreMatrix.length; i++){
				if (scoreMatrix[i].size() !=5) {
					result = true;
				}
			}
		}
		
		if (category == CHANCE) {
			result = true;
		}
			
		return result;
			
	}
	
	
	
	
	/**	Method that creates a 2 dimensional array where all scores for players will be stored
	 */
	private void initTrackers(){
		// this score board will be used to track scores internally.
		// number of columns is equal to number of players.
		// number of rows is equal to number of scoring categories = 17 =TOTAL
		scoreBoard = new int[nPlayers][TOTAL];
		
		// the boolean board will be used to make sure that a player can select a certain category only once
		// all the values by default are false, after a category is used, the program assigns true
		// to the corresponding element of the array. When all the elements of the cuBoard are true, the game is finished
		cuBoard = new boolean[nPlayers][TOTAL];
		
		// assign the certain elements of the cuBoard as true.
		// we cannot select these categories anyway. they are Lower score , upper score, total and bonus categories.
		// we should assign their values as true because the program has to finish when all elements of this array are true.
		// by default the are initialized as false.
		for (int i=0; i<nPlayers; i++){
			cuBoard[i][UPPER_SCORE-1]=true;
			cuBoard[i][UPPER_BONUS-1]=true;
			cuBoard[i][LOWER_SCORE-1]=true;
			cuBoard[i][TOTAL-1]=true;
		}
		
	}
	
	
	
	
	/** Method takes in an array of numbers(representing a 5 dice roll) as an argument; returns an array with 
	 * new random numbers for unselected dice */
	private int[] rollDice(int[] roll){
		int [] diceRoll = roll;
		for (int i=0; i<N_DICE; i++){
			if (display.isDieSelected(i)){
				diceRoll[i] = rgen.nextInt(1,6);
			}
		}
		return diceRoll;	
	}
		
	
	
	
	/** Method takes in an array of numbers (representing  a 5 dice roll) as a parameter; returns an array with 
	 * 	new random numbers of all dice. Method used only for the first roll*/
	private int [] rollFirstDice(int[] roll){
		int[] diceRoll = roll;
		for (int i=0; i<N_DICE; i++){
			diceRoll[i] = rgen.nextInt(1,6);
		}
		return diceRoll;
	}
	
	
	
	
	/** Method accepts an int representing the player index as a parameter (e.g. 1 or 2 or 3 or MaxNumPlayers; but not 0)
	 * 	returns an int representing that player's column number in the scoreBoard and cuBoard array.
	 * 	method is used simply to avoid confusion from the shift between player numbers and column number indices.
	 * 	player 1 corresponds to column 0 etc. plr stands for player.
	 */
	private int plr(int playerNumber){
		return playerNumber-1;
	}
	
	
	
	
	/** Analogical to player(int playerNumber)
	 * 	Method accepts an int representing the category number as a parameter (e.g. ONES, TWOS, TOTAL etc; but not 0)
	 * 	returns an int representing that category's row number in the scoreBoard and cuBoard array.
	 * 	method is used simply to avoid confusion from the shift by -1 between category numbers and row number indices.
	 * 	e.g. category ONES corresponds to row 0 etc. cgry stands for category.
	 */
	private int cgry(int categoryNumber){
		return categoryNumber-1;
	}
	
	
	
	
/* Private instance variables */
	/** 2 dimensional array used to internally keep track of all scores */
	private int[][] scoreBoard;
	
	/** 2 dimensional array used to make sure same category is not used twice; cuBoard stands for category usage board */
	private boolean[][] cuBoard;
	
	/** integer number representing the number of players (note more than 4) */
	private int nPlayers;
	
	
	private String[] playerNames;
	private YahtzeeDisplay display;
	private RandomGenerator rgen = new RandomGenerator();

}
