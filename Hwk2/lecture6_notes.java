import acm.program.*;

public class lecture6_notes extends ConsoleProgram {
	
	public void run() {
		//addTwoDoubles();
		//addTwoInts();
		//divOrMultDoubleByInt();
		//integerDivisionCaution();
		
		//Casting Variables
		println("Temporary Casting");
		int x=7;
		double y = x/2; //will give 3.0
		println("x=7; x/2="+y);	
		y = (double)x/2;
		println("x=7; (double)x/2="+y); // will give 3.5; we just casted x to be a double just for this operation
		
		for (int i=0; i<=10; i++) {
			println(i);
		}
		
		//Incrementation
		x=120;
		x+=1;
		println (x);
		x++;
		println (x);
		x=x-1;
		x-=1;
		x--;
		println (x);
		x*=2;
		println (x);
		x/=2;
		println(x);
		double f=2*PI;
		println(f);
		
		//Booleans
		boolean p;
		p=3.0>5;
		boolean q=3<5;
		print(p+" "); print(q); println(" ");
		print(!p+" "); print(!q); println(" ");
		print(p&&q); print(" "); print(p||q); println(" "); 
	}

	
	//Constants
	private static final double PI=3.14;		//Good practice to have constants declared in all upperrcase;
	
	
	private void addTwoDoubles() {
		println("adding two doubles");
		double x = readDouble("Enter a double value for x: ");
		double y = readDouble("Enter a double value for y: ");
		double sum = x+y;
		println("the sum of doubles is: " + x + "+" + y + "=" + sum);
		println(" ");
	}
	
	
	private void addTwoInts() {
		println("adding two ints");
		int x = readInt("Enter an int value for x: ");
		int y = readInt("Enter an int value for y: ");
		int sum = x+y;
		println("the sum of integers is: " + x + "+" + y + "=" + sum);
		println(" ");
	}
	
	
	private void divOrMultDoubleByInt() {
		println("divide double by int");
		double x = readDouble("Enter a y double: ");
		int y = readInt("Enter an x int: ");
		double a = x/y;
		double b = x*y;
		println("x/y = " + a);
		println("x*y = " + b);
		println(" ");
		/* any operation between double and int results in a double	
		 * unless you cast the result into a type you want
		 */
	}
	
	private void integerDivisionCaution() {
		println("int 5/ int 2 = double 2.0 ???");
		int x = readInt("Enter x=5: ");
		int y = readInt("Enter y=2: ");
		double a = x/y;
		println("x/y = " + a);
		println(" ");
		/*	Double a=5/2=2.0 not 2.5!!!
		 */
	}
}