import acm.program.*;
import acm.util.*;


public class SimpleRandom extends ConsoleProgram {

	private RandomGenerator rgen = RandomGenerator.getInstance();
	
	
	public void run () {
		int dieRoll = rgen.nextInt(1,6);
		println("You rolled: " + dieRoll);
	}
}


