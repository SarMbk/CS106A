
import acm.program.*;
import java.util.*;

public class Lecture13_notes extends ConsoleProgram {
	
	public void run () {
		
		String s = readLine();
		println("Number of uppercase letters: " + countUpperCase(s));
		println("Your required letters were replaced: " + replaceOccurrence(s, "loves", "beats") + "\n\n");	
		
		
		while (true) {
			s = readLine("Enter line to \"stanfordize\": ");
			if (s.equals("")) {break;}
			println("At Stanford we say: " + stanfordize(s));		
		}
		println("Thank you for visiting Stanford\n\n");
		
		
		//	String tokenizer
		s = readLine("enter line to tokenize: ");
		println("tokens in this line are: ");
		printTokens(s);
		println("\n\n");
		
		
		
		// Caesar cypher
		s = readLine("Enter text to cypher: ");
		String scypher = caesarCypher(s,35);
		println("Caesar cypher: " + scypher);
		println("Caesar decypher: " + caesarCypher(scypher,-35));
		
		println("\n\n");
		
	}
	
	
	
	private int countUpperCase (String s) {
		int n = 0;
		for (int i=0; i<s.length(); i++) {
			if (Character.isUpperCase(s.charAt(i))) {
				n++;
			}
		}
		return n;
	}
	
	
	
	private String replaceOccurrence(String s, String original, String replacement) {
		int startIndex = s.indexOf(original);
		if (startIndex!=-1) {
			s=s.substring(0, startIndex) + replacement + s.substring(startIndex+original.length(), s.length());
		}
		return s;	
	}
	
	
	private String stanfordize(String s) {
		s = replaceOccurrence(s, "florence moors", "flomo");
		s = replaceOccurrence(s, "memorial church", "memchu");
		s = replaceOccurrence(s, "computer science", "CS");
		s = replaceOccurrence(s, "well", "badass");
		return s;
	}
	
	
	private void printTokens(String str) {
		StringTokenizer tokenizer = new StringTokenizer (str, ", ");
		for (int count = 0; tokenizer.hasMoreTokens(); count++) {
			println("Token #" + count + ": " + tokenizer.nextToken()) ;
			}
		}
	
	
	
	private String caesarCypher2 (String s, int key) {
		String cypher = "";
		char marker;
		
		for (int i=0; i< s.length(); i++) {
		
			// If it's an upper-case letter
			if(Character.isUpperCase(s.charAt(i))) {
				if (key>=0) {marker = 'A';} else {marker = 'Z';}
				cypher += (char)((s.charAt(i) - marker + key%26)%26 + marker);
			}
			
			
			// If it's a lower-case letter
			if(Character.isLowerCase(s.charAt(i))) {
				if (key>=0) {marker = 'a';} else {marker = 'z';}
					cypher += (char)((s.charAt(i) - marker + key%26)%26 + marker);				
			}
			
			
			//If it's not a letter
			if (!Character.isLetter(s.charAt(i))) {
				cypher+=s.charAt(i);
			}
			
		}
		
		return cypher;
		
	}
	
	
	
	private String caesarCypher (String s, int key) {
		String cypher = "";
		char marker;
		for (int i=0; i< s.length(); i++) {	
			
			//If it's not a letter
			if (!Character.isLetter(s.charAt(i))) {
				cypher+=s.charAt(i);
			}
			
			if(Character.isUpperCase(s.charAt(i))) {
				if (key>=0) {marker = 'A';} else {marker = 'Z';}
				cypher += (char)((s.charAt(i) - marker + key%26)%26 + marker);
			}
			
			if(Character.isLowerCase(s.charAt(i))) {
				if (key>=0) {marker = 'a';} else {marker = 'z';}
				cypher += (char)((s.charAt(i) - marker + key%26)%26 + marker);
			}	
		}
		return cypher;
	}
	
	
}


