/*
 * This is an example of how to use classes in a program. This program demonstrates the use of student.java class
 * */

import acm.program.*;


public class UseStudent extends ConsoleProgram {
	
	public void run() {
		student sarStudent = new student("Sar", 910931);
		println(sarStudent.getUnits());
		sarStudent.setUnits(150);
		println(sarStudent.toString());
		println(sarStudent.getID());
		println(sarStudent.getName());
		sarStudent.addUnits(40);
		println(sarStudent.getUnits());	
		println(sarStudent.hasEnoughUnits());
		
		
		froshStudent fresher = new froshStudent("Fresh Frank", 10001);
		println(fresher.toString());
	}

}
