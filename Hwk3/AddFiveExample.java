import acm.program.*;

public class AddFiveExample extends ConsoleProgram {
	
	public void run() {
		int x=3;
		println(addFive(x));
	}
	
	private int addFive(int x) {
		return (x+5);
	}

}
