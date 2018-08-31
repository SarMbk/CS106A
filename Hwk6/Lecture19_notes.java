import java.util.*;
import acm.program.*;


public class Lecture19_notes extends ConsoleProgram {
	
	public void run(){
		
		// HASHMAPS
		
		// How to implement Hashmaps. You need to use java.util library
		
		// Here is an example of a dictionary. Maps words (keys) to definitions(values)
		Map<String, String> dictionary = new HashMap<String, String>();
		// You can use either:
		// Map<String, String> dictionary = new HashMap<String, String>();
		// or
		// HashMap<String, String> dictionary = new HashMap<String, String>();
		
		// Here is an example of a phonebook. Keys=names; values=phone numbers.
		// HashMaps can only map objects to objects. Cannot map primitive types!!!
		// Therefore we dont use int, but we use a wrapper class Integer.
		HashMap<String, Integer> phonebook = new HashMap<String, Integer>();
		
		
		// Putting/getting values into and from hashmap
		
		// example of putting a word(key) and its definition(value) into a dictionary
		dictionary.put("Arcane", "understood by few; mysterious or secret.");
		
		// returns definition of this word stored in dictionary; 
		// if key not contained in dictionary, returns null
		println(dictionary.get("Arcane")); 
		
		// example of putting/getting the phone numbers into/from phonebook
		phonebook.put("Saruar", 7717125);
		phonebook.put("Mama", 7245118);
		phonebook.put("Saida", 8307005);
		phonebook.put("Papa", 7330627);
		phonebook.put("Byrkymbai", 1234567);
		
		println(phonebook.get("Saruar"));
		println(phonebook.get("Mama"));
		
		
		// removing data from HashMaps
		phonebook.remove("Byrkymbai");
		
		// if you remove an item that is not in the Hashmap, it just does nothing. no errors no exception nothing.
		phonebook.remove("Byvshaya");
		
		// checking if a hashmap contains a certain key
		println(phonebook.containsKey("Saruar"));
		
		// getting hashmap size
		println(phonebook.size());
		
		
		
		// ITERATORS
		
		// Suppose you have an ArrayList of names
		ArrayList <String> names = new ArrayList <String>();
		names.add("Saruar");
		names.add("Saida");
		names.add("Sanjar");
		names.add("Akeda");
		names.add("Klara");
		names.add("Manarbek");
		
		// you want to iterate over it without using a for or a while loop
		// you create an iterator
		// should be of the same type as the object you're iterating over
		Iterator<String> it = names.iterator();
		
		while(it.hasNext()){
			println(it.next());
		}
		
		// how to iterate over hashmap keys
		// this returns a set of keys of a hashmap
		// phonebook.keySet();
		// so to iterate over a keyset we do this:
		println(" ");
		Iterator<String> itr = phonebook.keySet().iterator();
		while(itr.hasNext()){
			println(itr.next());
		}
		// note that hashmaps dont have any order
		
		
		
		// Here is an even shorter way to implement an iterator:
		println(" ");
		for(String name: phonebook.keySet()){
			println(name);
		}
		
		println(" ");
		for(String name:dictionary.keySet()){
			println(name);
		}
		
		
		
	
		
		
		
		
		
		
	}

}
