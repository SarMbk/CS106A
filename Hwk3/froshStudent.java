/**
 * This is a demonstration of how to implement and create subclasses.
 * In particular, froshStudent is a subclass of student.
 * @author Sar
 */


public class froshStudent extends student {
	
	public froshStudent(String name, int id) {
		super(name, id);
	}
	
	
	public String toString() {
		/*
		 * NOTE: student name and ID are private instance variables. You cannot get to them directly. Even in a sublclass!
		 * You can only get them through getter methods defined in the superclass.
		 */
		return "Frosh: " + getName() + " (#" + getID() + ")";
	}

}
