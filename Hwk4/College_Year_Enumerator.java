import acm.program.*;

public class College_Year_Enumerator extends ConsoleProgram {
	
	private static final int FRESHMAN = 1;
	private static final int SOPHOMORE = 2;
	private static final int JUNIOR = 3;
	private static final int SENIOR = 4;
	
	
	
	public void run() 	{
		int year = readInt("What year are you in? Enter an integer value for year (enter zero to exit): ");
			
			switch (year){
				case FRESHMAN: 
					println("You are a freshman");
					break;
				case SOPHOMORE:
					println("You are a sophomore");
					break;
				case JUNIOR:
					println("You are a junior");
					break;
				case SENIOR:
					println("You are a senior");
					break;
				case 0:
					println("Bye");
					break;	
			}
			
			if (year>SENIOR){
				println("You're either grad or your're in school for too long. You better make bank when you're done");
			}	
		
	}
}
			
