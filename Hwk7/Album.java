import java.util.*;

public class Album {
	
	/**
	 * Constructor
	 */
	public Album(String albumName, String bandName){
		title = albumName;
		band = bandName;
	}
	
	public String getAlbumName(){
		return title;
	}
	
	public String getBandName(){
		return band;
	}
	
	public void addSong(Song song){
		songs.add(song);
	}
	
	public Iterator<Song> getSongs(){
		return songs.iterator();
	}
	
	public String toString(){
		return ("\"" +  title + "\" by: " + band);
	}
	
	
	
	
	// Instance variables
	private ArrayList<Song> songs = new ArrayList<Song>();
	private String title;
	private String band;

	
}
