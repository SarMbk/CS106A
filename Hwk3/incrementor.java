/*	The incrementor class keeps track of the counter which is set to 
 * 	some starting value and then incremented every time 
 * 	the user asks for a new value. 
*/

public class incrementor {
	
	/*Create incrementor with starting value of 1*/
	public incrementor() {
		counter = 1;
	}
	
	/*Create incrementor with a given starting value */
	public incrementor(int startValue) {
		counter = startValue;
	}
	
	/*Define a method for incrementing */
	public int nextValue() {
		int temp = counter;
		counter++;
		return temp;
	}
	
	/* Private instance variable 
	 * You can define it as a static variable (aka class variable) by typing this:
	 * private static counter.
	 * If you define a static variable, all objects of class incrementor will refer to this variable even if
	 * they are different objects.
	 * Its a good style to use static variables for constants such as pi or e.
	 */
	private int counter;
	
	
	
}
