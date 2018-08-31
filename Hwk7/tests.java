import acm.program.*;
import java.util.ArrayList;

public class tests extends ConsoleProgram{
    
	public void run(){
        
		ExpandableArray example = new ExpandableArray();
		example.set(1,1);
		example.set(2, 2);
		example.set(4, 4);
		example.set(10, 10);
		example.set(5, 5);
		example.set(15, "fifteen");
		
		
		println(example.get(16));
		
		println(example.toStr());
		
		
		
		
		
		
		
		
		
		
		/*
		//First ArrayList
        ArrayList<String> arraylist1=new ArrayList<String>();
        arraylist1.add("AL1: E1");
        arraylist1.add("AL1: E2");
        arraylist1.add("AL1: E3");

        //Second ArrayList
        ArrayList<String> arraylist2=new ArrayList<String>();
        arraylist2.add("AL2: E1");
        arraylist2.add("AL2: E2");
        arraylist2.add("AL2: E3");

        //New ArrayList
        ArrayList<String> al= new ArrayList<String>();
        //al.addAll(arraylist1);
        arraylist1.addAll(arraylist2);

        //Displaying elements of the joined ArrayList
        for(String temp: arraylist1){
            println(temp);
        }
        */
	}
    
}