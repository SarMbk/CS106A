
public class Song {
	
/**
 * Constructor
 * Note that the song and band name are immutable once the song is created
 */
	
	public Song(String songName, String bandName, double songPrice){
		title = songName;
		band = bandName;
		price = songPrice;
	}
	
	
// Methods	
	public String getSongName(){
		return title;
	}
	
	public String getBandName(){
		return band;
	}
	
	public double getPrice(){
		return price;
	}
	
	public void setPrice(double songPrice){
		price = songPrice;
	}
	
	public String toString(){
		return ("\"" + title + "\" by: " + band + "; costs: S" + price);
	}
	

	
// Instance variables
	
	private String title;
	private String band;
	private double price;
	
	
}
