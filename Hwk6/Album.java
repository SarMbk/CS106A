
// This is how you create a class
// If you want to have objects of this class which will contain multiple types of data


public class Album {
	
	
	// This is how you construct a class.
	// We say we will have objects of class album, which will have inside of them
	// a string containing alum name
	// a string containing band name
	// a string saying the number of CDs in stock
	// all the variables that you want to have inside a class you declare as private instance variables!
	// hence they are called instance variables because for each instance of the album object it will create its own variables
	public Album(String album, String band, int stock) {
		albumName = album;
		bandName = band;
		numStock = stock;
	}
	
	// These are the methods that yoy can perform on objects of type Album
	// e.g. if you have an object of type Album called alb
	// if you type alb.getAlbumName() it will return a string "Meteora" (by linkinPark)
	public String getAlbumName() {return albumName;}
	
	public String getBandName() {return bandName;}
	
	public int getNumStock() {return numStock;}
	
	public String toString(){return("\"" + albumName + "\" by " + bandName + ": " + numStock + " in stock");}
	
	
	
	private String albumName;
	private String bandName;
	private int numStock;

}
