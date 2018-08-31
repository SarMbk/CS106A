
import acm.program.*;
import java.awt.*;

public class fibonacci extends ConsoleProgram {
	
	//	Set the maximum value of fibonacci term as a constant value
	private static final int MAXTERM = 10000;
	private static final int F0 = 0;	//	first fib. term
	private static final int F1 = 1;	//	secons fib. term
	
	
	public void run() {
		int Fn = F1; 
		int Fprev = F0;
		int buffer;
		println(F0);
		println(F1);
		
		while((Fprev+Fn) < MAXTERM) {
			buffer = Fn;
			Fn = Fprev + Fn;
			Fprev = buffer;
			println(Fn);
		}	
	}
}
