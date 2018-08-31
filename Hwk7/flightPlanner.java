
import acm.program.*;
import acm.util.ErrorException;

import java.io.*;
import java.util.*;


public class flightPlanner extends ConsoleProgram {
	
	public void run(){
				
		//Open the text file and read the data
		readFlightData();		
		
		println("Welcome to Flight Planner!\n");
		
		// Print available cities:
		println("Here is a list of all available cities in our database:");
		printAllCities();
		
		println("\nLet's plan a round trip route!\n");
		
		// Get the starting city and add it into the route ArrayList
		String nextDest = getNextDest();
		route.add(nextDest);
			
		
		while (true){
			
			// Print the available direct flights from the last entered destination
			printDirectFlights(nextDest);
			
			// Ask for next destination
			nextDest = getNextDest();
			
			// If there are no direct flights to next destination, ask again. Keep asking till the available direct
			// flight destination is entered
			while (!checkDirectFlight(nextDest)){
				println ("There is no direct flight to that destination from " + route.get(route.size()-1) + 
						". Please try another destination");
				nextDest = getNextDest();
			}
			
			// Add destination to route
			route.add(nextDest);
			
			// if last entered destination is same as starting city; beak out of the loop
			if (route.size()>1 && nextDest.equals(route.get(0))){
				break;
			}
			
		}
		
		// print route
		println("The route you have chosen is: ");
		printRoute();
		
		
				
		
	}
	
	
	// PRIVATE METHODS
	
	// checks of the there are available direct flights to a given city
	// input: next destination city
	private boolean checkDirectFlight(String city){
		String currCity = route.get(route.size()-1);
		boolean flag = flightData.get(currCity).contains(city);
		return flag;
	}
	
	
	
	// Asks the user to input his starting city or next destination, makes sure it only takes in the city that's in the database
	// and that there is a direct flight to that place
	private String getNextDest(){
		String city;
		if (route.size()>=1){
			city = readLine("Where do you want to fly from " + route.get(route.size()-1) + "? ");
		}
		else {
			city = readLine("Enter the starting city: ");
		}
		while (!flightData.containsKey(city)){
			city = readLine("There is no such city in our database, please enter another city: ");
		}
		return city;
	}
	
	// prints the final round trip route chosen by user
	private void printRoute(){
		String s="";
		for (int i=0; i<route.size(); i++){
			if (i<route.size()-1){
				s+=route.get(i) + " -> ";	
			}
			else {
				s+=route.get(i);
			}
		}
		println(s);
	}
	
	
	// Prints the list of available direct flight destinations from a city.
	// Input: city you are departing from
	private void printDirectFlights(String departFrom){
		println("\nFrom " + departFrom + " you can fly directly to: ");
		for (int i=0; i<flightData.get(departFrom).size(); i++){
			println(flightData.get(departFrom).get(i));
		}
	}
	
	
	// Reads the text file and adds strings representing all cities to the ArrayList
	private void readFlightData(){
		String filename = "flights.txt";
			try {
				BufferedReader rd = new BufferedReader(new FileReader(filename));
				
				// Go through the file once and add all the starting cities to the all cities ArrayList
				while(true){
					String line = rd.readLine();
					if (line == null) {break;}
					String city = getCity(line);
					String dest = getDest(line);

					if (city!=null && !flightData.containsKey(city)){
						ArrayList<String> allDest = new ArrayList<String>();
						flightData.put(city, allDest);
						flightData.get(city).add(dest);
					}
					
					if(city!=null && !flightData.get(city).contains(dest)){
						flightData.get(city).add(dest);
					}
				}	
				
				rd.close();	
			} catch (IOException ex) {
				throw new ErrorException(ex);
			}	
	}
	
	
	
	// Accepts a String type line from a text document and extracts all the cities in there
	private String getCity(String line){
		if (line.contains("-")){
			String city = line.substring(0, line.indexOf("-")-1);
			return city;
		}
		return null;
	}
	
	
	// Method used inside getFlightData, takes in a line and returns a string representing a direct flight destination
	private String getDest(String line){
		if (line.contains(">")){
			String dest = line.substring(line.indexOf(">")+2);
			return dest;
		}
		return null;
	}
	
	
	// Prints all the cities there are in the database
	private void printAllCities(){
		Iterator<String> itr = flightData.keySet().iterator();
		while(itr.hasNext()){
			println(itr.next());
		}
	}
	
	

	
	
	
	

	
	// PRIVATE INSTANCE VARIABLES
	private HashMap <String, ArrayList<String>> flightData = new HashMap <String, ArrayList<String>>();
	private ArrayList<String> route = new ArrayList<String>();

}
