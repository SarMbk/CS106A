import acm.program.*;
import acm.util.*;


public class example extends ConsoleProgram {
	
	//	convention: constants are declared at top
	private static final int NUM_SIDES = 6;
	
	

	
	public void run(){
		int numDice = readInt("Enter the number of dice: ");
		int maxRoll = numDice*NUM_SIDES;
		int numRolls = 0;
		
		//	this is to make sure it gives u the same set of random numbers every time
		//	useful for debugging
		rgen.setSeed(1);
		
		while(true) {
			int roll = rollDice(numDice);
			numRolls++;
			if (roll == maxRoll) {break;}
			println("Roll: "+roll);
		}		
		println ("You rolled " + maxRoll + " after " + numRolls + " rolls");		
	}
	
	
	
	private int rollDice (int numDice){
		int total = 0;		
		for (int i=0; i<numDice; i++){
			total+=rgen.nextInt(1,NUM_SIDES); 
		}
		return total;
	}

	
	//	convention: Instance variables declared at bottom
	private RandomGenerator rgen = RandomGenerator.getInstance();
	
}
