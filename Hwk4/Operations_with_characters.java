import acm.program.*;

public class Operations_with_characters extends ConsoleProgram {
	
	public void run () {
		
		String S1= readLine ("enter a number you want to insert commas in: ");
		println (addCommasToNumericStrings(S1));
		
		
		S1=readLine("enter a string you want to remove occurences from: ");
		char yourChar = 'a';
		println(removeAllOccurrences(S1, yourChar));
		
		
		
		String s = readLine();
		char ch = s.charAt(1);
		println(ch);
		
		println(toLower('X'));
		
		printUpperAlphabet();
		
		//static method as part of Character class
		char x = Character.toUpperCase('a');
		println(x);
		
		//more static methods in character class
		println (Character.isDigit(x));
		println (Character.isLetter(x));
		println (Character.isLetterOrDigit(x));
		println (Character.isLowerCase(x));
		println (Character.isUpperCase(x));
		println (Character.isWhitespace(x));
		
		
		//strings
		String str1 = readLine();
		str1 = str1.toUpperCase();
		println(str1);
		
		//methods on strings
		println(str1.length());
		println(str1.charAt(1));
		println(str1.substring(1, 3));
		println(str1.substring(1));
		
		String str2 = readLine();
		String str3 = readLine();
		if (str2.equals(str3)){
			println("You typed " + str2 + " twice!");
		}
		else{
			println(str3.compareTo(str2));
		}
		
		println(str3.indexOf('e'));
		println(str3.indexOf("lo"));
		
		String str4 = readLine();
		String result = "";
		for (int i=0; i<
				str4.length(); i++) {
			result+= Character.toUpperCase(str4.charAt(i));
		}
		println(result);
		
		
		//reverse a string
		println(" ");
		String a = readLine();
		result = "";
		for (int i = a.length()-1; i>=0; i--) {
			result+=a.charAt(i);
		}
		println(result);
		
		
		println (isPalindrome("racecat"));
		
		
		
	}
	
	private String reverseString (String s) {
		String result="";
		for (int i = s.length()-1; i>=0; i--) {
			result+=s.charAt(i);
		}
		return result;
		
	}	
	
	private char toLower(char ch) {
		if (ch>='A' && ch<='Z') {
			return (char)(ch - 'A' + 'a');	
		} 
		else {
			return ch;
		}
	}
	
	private void printUpperAlphabet() {
		for (char ch = 'A' ; ch<='Z' ; ch++) {
			println(ch);
		}
	}
	
	private boolean isPalindrome (String s) {
		for (int i=0; i<s.length()/2; i++) {
			if (s.charAt(i)!=s.charAt(s.length()-1-i)) {
				return false;
			}
		}	
		return true;
	}
	
	
	private String addCommasToNumericStrings(String s) {
		String result="";
		int count = 0;
		for (int i=s.length()-1; i>=0; i--) {
			count++;
			result+=s.charAt(i);
			if (count%3==0 && i!=0) {
				result+=',';
			}	
		}	
		return reverseString (result);
	}
	
	
	public String removeAllOccurrences(String s, char ch) {
		String result = "";
		for (int i=0; i<s.length(); i++){
			if (s.charAt(i)!=ch){
				result+=s.charAt(i);
			}
		}
		return result;
	}
	
}
