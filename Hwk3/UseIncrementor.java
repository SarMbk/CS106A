/*	This program provides an example of using external classes.
 * 	This particular program uses the class called incrementor.java
 * 
 */



import acm.program.*;


public class UseIncrementor extends ConsoleProgram {
	
	public void run () {
		setFont("Times New Roman-20");
		
		incrementor count1 = new incrementor();		//	starts at 1
		incrementor count2 = new incrementor(1000);	//	starts at 1000;
		
		println("Five values for count 1: ");
		countFiveTimes(count1);
		
		println("Five values for count 2: ");
		countFiveTimes(count2);
		
		println("Another five values for count 1: ");
		countFiveTimes(count1);	
	}

	private void countFiveTimes(incrementor count) {
		for (int i=0; i<5; i++) {
			println(count.nextValue());	
		}
	}
	
}
