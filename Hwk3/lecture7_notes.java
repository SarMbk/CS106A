import acm.program.*;
import java.lang.Math.*;	//	mathematical functions library

//	loop and a half!
public class lecture7_notes extends ConsoleProgram {
	
	private static final int SENTINEL=0;
	
	private double feetToIn (double ft) {
		double in = ft*12;
		return in;
	}
	
	public void run() {
		
		println(feetToIn(12));
		
		int total = 0;
		
		//	it is generally a bad style to have many break statements inside one loop
		//	ok to use one break condition
		while (true) {
			int val = readInt("Enter val: ");	
			//	its ok to re-declare a variable in a loop over and over again
			//	dont need to worry about efficiency
			
			if (val==SENTINEL) break;
			total+=val;
		}
		println("TOTAL: "+total);
		
		double x = 9;
		double y = Math.sqrt(x);
		double z = Math.pow(x, y);
		println("x="+ x + " y="+y + " z="+z);
		//	methods are for information hidin
		//	we want to sometimes make programs a black box design
		
		//	METHOD JARGON
		/*
		 * receiver.name(arguments)
		 * using a method is called "calling" or "invoking" a method
		 * arguments are also called parameters
		 * 
		 * creating a method:
		 * define the following:
		 * visibility type name (parameters) {
		 * 	body
		 * 	return xxx;
		 * }
		 * visibility: private or public
		 * type: the type of object the method returns, int double void bool etc
		 * 
		 * a method that returns a bool is called a predicate method
		 * 
		 */
	}
}