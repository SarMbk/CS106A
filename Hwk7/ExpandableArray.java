import java.util.ArrayList;
import java.util.Collections;

/**
* This class provides methods for working with an array that expands * to include any positive index value supplied by the caller.
*/
public class ExpandableArray {
		
/**
* Creates a new expandable array with no elements. */
   public ExpandableArray() {
	   expArray= new ArrayList<Object>();   
   }
   
   
/**
* Sets the element at the given index position to the specified.
* indexes start at 1!!! not at zero!!!
* value. If the internal array is not large enough to contain that
* element, the implementation expands the array to make room. */
   public void set(int index, Object value) {
	   
	   if (index<=expArray.size()-1){
		   expArray.set(index-1, value);
	   }
	   else{
		   int sizeDiff = index - expArray.size();
		   ArrayList<Object> addition = new ArrayList<Object>(Collections.nCopies(sizeDiff-1, 0));
		   expArray.addAll(addition);
		   expArray.add(value);
	   } 
   }
   
   
/**
* Returns the element at the specified index position, or null if
* no such element exists. Note that this method never throws an
* out-of-bounds exception; if the index is outside the bounds of * the array, the return value is simply null.
*/
   public Object get(int index) {
	   if(index>expArray.size()){
		   return null;
	   }
	   return expArray.get(index);
   } 
   
   
/**
 * @return Returns the ArrayList in a form of a string
 */
   public String toStr(){
	   String s="";
	   for(int i=0; i<expArray.size(); i++){
		   s+=(expArray.get(i)) + " ";
	   }
	   return s;
   }
   
   
   private ArrayList <Object> expArray;
}
