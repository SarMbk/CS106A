
/** 
 * This class helps keep track of the following information:
 * student name, student ID and the number of units a student earned.
 */

public class student {
	
	/**
	 * Creates a new object of class student with a new name and ID. Takes the following parameters:
	 * @param name student's name as a string type.
	 * @param id student's ID number as an int type.
	 * */
	public student (String name, int id ) {
		studentName = name;
		studentID = id;
	}
	
	
	/**
	 * Returns student name as a string type.
	 * @return the student name as a string type.
	 * */
	public String getName() {
		return studentName;
	}
	
	
	/**
	 * Returns student ID as an int type.
	 * @return the student ID number as an int type.
	 * */
	public int getID() {
		return studentID;
	}
	
	
	/**
	 * Returns the number of units a student has.
	 * @return the number of units a student has in total so far.
	 * */
	
	public double getUnits() {
		return unitsEarned;
	}
	
	
	/**
	 * Returns the student name and ID in a string form.
	 * @return the student's name and ID in a string form.
	 **/
	public String toString() {
		return studentName + " (#" + studentID + ")";
	}
	
	
	/**
	 * Sets the number of units a student has earned. 
	 * @param units the new number of units that you want to set a student to have.
	 * */
	public void setUnits(double units) {
		unitsEarned = units;
	}
	
	
	/**
	 * Adds a number of units to the number of units a student already has.
	 * @param addedUnits the number of units you want to add to what a student already has.
	 * */
	public void addUnits(double addedUnits){
		unitsEarned+=addedUnits;
	}
	
	
	/**
	 * Returns true if student has enough units to graduate.
	 * Returns false if student does not have enough units to graduate.
	 * @return true-if student has enough units to graduate; false-if not. 
	 * */
	public boolean hasEnoughUnits() {
		return (unitsEarned >= UNITS_TO_GRADUATE);
	}
	
	/*	Declaring constants */
	
	/** 
	 * The number of units required for graduation from Stanford
	 **/
	public static final double UNITS_TO_GRADUATE = 180.0;
	
	
	/*	Declaring private instance variables */
	private String studentName;
	private int studentID;
	private double unitsEarned;
	
	
}
