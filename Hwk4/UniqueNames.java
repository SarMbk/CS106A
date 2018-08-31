import acm.program.*;
import java.util.*;



public class UniqueNames extends ConsoleProgram {
	
	public void run(){
		
		ArrayList<String> names  = getNameInput();
		println(" ");
		
		println("Of all the names entered, the unique names are: ");
		printArrayList(getUniqueStrings(names));
		
	}

	
	
	// Method for prompting the user to enter names, returns an array list with entered names
	private ArrayList<String> getNameInput(){
		ArrayList<String> nameArray = new ArrayList<String>();
		while (true){
			String name = readLine("Enter a name and hit enter; enter a blank line to finish input: ");
			if (name.equals("")) break;
			nameArray.add(name.toUpperCase());
		}
		return nameArray;
	}
	
	
	
	private ArrayList<String> getUniqueStrings(ArrayList<String> nameList){
		ArrayList<String> uniqNameList = new ArrayList<String>();
		for (int i=0; i<nameList.size(); i++){
			String name = nameList.get(i);
			if(!uniqNameList.contains(name)){
				uniqNameList.add(name);
			}
		}
		return uniqNameList;
	}
	
	
	
	//Method for printing ArrayList; every element on a new line
	private void printArrayList(ArrayList list){
		for (int i=0; i<list.size();i++){
			println(list.get(i));
		}
	}
	
	
	
	
	
}
