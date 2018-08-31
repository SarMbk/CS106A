/*
 * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */

//import acm.graphics.*;
import acm.program.*;
import acm.util.*;


public class Hangman extends ConsoleProgram {
	
	
	
	//=============== DEFINING CONSTANTS =====================//
	
	private static final int INITIAL_LIVES = 8;

	
	
	//=============== INITIATING CANVAS =====================//

	 public void init() {
         canvas = new HangmanCanvas();
         add(canvas);
}
	
	 
	
	//=============== RUN METHOD ============================//	
	
    public void run() {
    	
    	
    	// This flag helps monitor if user wants to play again
    	playAgainFlag = 'Y';
    	
    	// Print Welcome statement
    	println("Welcome to Hangman");
    	
    	while (playAgainFlag == 'Y'){
    		
    		println(" ");
    		
    		// When you start a new word your all your lives are always renewed and list of wrong guesses is reset
        	lives = INITIAL_LIVES;
        	wrongGuesses="WRONG GUESSES: ";
        	
    		// Generate a word to guess
        	String wordToGuess = GenerateNewWord(rgen.nextInt(0,secretWord.getWordCount()-1));
        	
        	// Make a line of dashes representing the hidden word
        	dashes = makeDashesFromWord(wordToGuess);
        	
        	// Prints word to guess in the console
        	// COMMENT THE LINE BELOW TO NOT SHOW THE SECRET WORD DURING GAMEPLAY
        	println(wordToGuess);
        	
        	// Reset canvas
        	canvas.reset();

        	
    		while(lives>0 && !isWordGuessed(dashes)) {	
    		
    			// Let user know how many lives are left
    			println("You have " + lives + " lives left.");
    		
    			// Print a line of dashes representing the hidden word
    			println(dashes);
    			
    			// Displays letters of the word as the user guesses it
            	canvas.displayWord(dashes);
    			
    			// Prompt user to guess a letter;
    			String guessLetter = inputLetter();
    		
    			// If guess contained in word then show letters, else take away one life
    			showLettersOrTakeLife(guessLetter, wordToGuess);

    		} // this closes the while(lives>0 && !isWordGuessed(dashes)) loop
    		
    		// This line is needed to take care of the OBOB when using this command in the while loop
        	canvas.displayWord(dashes);
    		
        	
    		// If user guessed the word, ask if he wants to play again
    		ifGuessedAskToPlayAgain();

    		
    		// If user used up all lives, ask if user wants to play again
    		ifOutOfLivesAskToPlayAgain();
    		
    		
    	} // this closes the while(playAgain =='Y') loop
    	
    	
    	if (playAgainFlag!='Y') {
        	println("Thank you for playing! Bye!");
    	}	
    
    	
	}
     
    
    
  //=============== DEFINING PRIVATE METHODS =====================//
    
    // If user used up all lives, ask if user wants to play again
    private void ifOutOfLivesAskToPlayAgain(){
    	if (lives==0) {
    		String s = readLine ("You ran out of lives. Do you want to play again? Enter Y to play again, enter any character to exit: ");
			playAgainFlag = Character.toUpperCase(s.charAt(0));
    	}	
    }
    
    
    
    
    // If word is guessed, ask if user wants to play again
    private void ifGuessedAskToPlayAgain(){
    	if (isWordGuessed(dashes)){
			println(dashes);
			String s = readLine ("You guessed the word. Do you want to play again? Enter Y to play again, enter any character to exit: ");
			playAgainFlag = Character.toUpperCase(s.charAt(0));	
		}
    }
    

    

    // If guess contained in word then show letters
	// else take away one life and display wrong guesses on canvas
    private void showLettersOrTakeLife(String guessLetter, String wordToGuess){
    	if (isLetterInWord(guessLetter, wordToGuess)){
			dashes = showLetters(guessLetter, wordToGuess, dashes);
		}
		else {
			// take away one life and add a bodypart to canvas correspondingly
			lives-=1;
			canvas.addBodyPart(lives);
			
			// Note wrong guesses and display them on canvas
			noteWrongGuesses(guessLetter);
			println(wrongGuesses);
			canvas.noteIncorrectGuess(wrongGuesses);
		}
    }

    
    
    
    // Adds a wrong guessed letter to the list. Ensures repeatedly entered wrong guesses are not shown on canvas.
    private void noteWrongGuesses(String guessLetter) {
    	if (!isLetterInWord(guessLetter, wrongGuesses )){
    		wrongGuesses += Character.toUpperCase(guessLetter.charAt(0)) + " ";
    	}
    }
    
    
    
    
    //Prompt user to enter a guess letter
    private String inputLetter(){
    	//Loop ensures the user inputs one letter
		String guessLetter = readLine ("Your Guess: ");
		while (guessLetter.length()!=1){
			println("You should only enter one letter at a time.");
			guessLetter = readLine ("Your guess: ");		
		}
		return guessLetter;
    }
    
    
    
    
    //Returns true if a word is completely guessed
    private boolean isWordGuessed(String lettersAndDashes){
    	for (int i=0; i<lettersAndDashes.length(); i++){
    		if(lettersAndDashes.charAt(i)=='-'){
    			return false;
    		}
    	}
    	return true;
    }
    
    
    
    
    // Returns true if a guessLetter is contained in a word, otherwise returns false
    private boolean isLetterInWord(String guessLetter, String word){
    	for (int i=0; i<word.length(); i++){
    		if(word.charAt(i)==Character.toUpperCase(guessLetter.charAt(0))){
    			return true;
    		}
    	}
    	return false;
    }
    
    
    
    
    // Accepts string object of a word as input and returns a string containing series of dashes representing a hidden word
    private String makeDashesFromWord(String word){
    	String dashes = "";
    	for (int i=0; i<word.length(); i++) {
    		dashes+="-";
    	}
    	return dashes;
    }
    
    
    
    
    // Accepts a guess letter, secret word and a line of dashes representing a hidden word
    // shows more letters if a guess letter is contained in a word
    // otherwise does nothing and returns the same series of dashes an letters that were given to it as input
    private String showLetters (String guessLetter, String word, String dashes){
    	String new_dashes="";
    	for (int i = 0; i<word.length(); i++) {
    		if (word.charAt(i)==Character.toUpperCase(guessLetter.charAt(0))) {
    			new_dashes+=word.charAt(i);
    		}
    		else {
    			new_dashes+=dashes.charAt(i);
    		}
    	}
    	dashes = new_dashes;
    	return dashes;
    }
    
    
    
    
    // Method for picking a new word from the Hangman lexicon
    private String GenerateNewWord(int random) {
    	String word = secretWord.getWord(random);
    	return word;
    }
    
    
    
    
    //=============== DEFINING INSTANCE VARIABLES =====================//
    
    // this initiates an instance variable of class HangmanCanvas
    private HangmanCanvas canvas;
    
    // this flag helps monitor if user wants to play again
    private char playAgainFlag;
    
    // Instance variable that will contain a string of dashes and letters as you guess the word
    private String dashes;
    
    // Variable to keep count of how many lives are left
    private int lives;
    
    // instance variable for generating random index
    private RandomGenerator rgen = RandomGenerator.getInstance();
    
    // instance variable for a random secret word
    //private HangmanLexicon secretWord = new HangmanLexicon();
    
    // instance variable for noting incorrect guesses;
    private String wrongGuesses;
    
    // Object of class HangmanLexicon to generate random words;
    private HangmanLexicon secretWord = new HangmanLexicon();

}
