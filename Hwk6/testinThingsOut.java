import acm.program.*;
import acm.util.*;
import acm.graphics.*;
import acm.gui.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class testinThingsOut extends ConsoleProgram {
	
	public void run(){
		String str = "Saruar 0 1 2 3 4 5 6 111";
		//int num = Integer.parseInt(str);
		//println(num);
		
		String nums = str.substring(str.indexOf(" ")+1);
		Scanner scanner = new Scanner(nums);
		ArrayList<Integer> list = new ArrayList<Integer>();
		while (scanner.hasNextInt()) {
		    list.add(scanner.nextInt());
		}
		
		println(Arrays.toString(list.toArray()));
		println(str.indexOf(" "));
		
		String name = str.substring(0, str.indexOf(" "));
		println(name);
		
		println(nums);
		
		println(list.get(7));
		println(list.size());
		
		String random = "Who will get a job at Google? Answer: ";
		random+=name;
		println(random);
		
		
		
	}

}
