
import acm.program.*;

public class myProgram extends ConsoleProgram {
	
	public void run(){
		Point p1 = new Point (1,1);
		Point p2 = new Point (4,5);
		
		p2.move(1, 1);
		
		line ln = new line (p1, p2);
		
		p2=p1;
		
		p2.move(1, 1);
		print (p1);
		
	}

}
