
import acm.program.*;
import java.util.*;


public class FlyTunes extends ConsoleProgram {


	public void run(){
		
		while (true){
			int selection = getSelection();
			if (selection == QUIT) break;
			
			switch (selection){
			case LIST_SONGS:
				listSongs();
				break;
			case LIST_ALBUMS:
				listAlbums();
				break;
			case  ADD_SONG:
				addSong();
				break;
			case ADD_ALBUM:
				addAlbum();
				break;
			case LIST_SONGS_ON_ALBUM:
				listSongsOnAlbum();
				break;
			case UPDATE_SONG_PRICE:
				updateSongPrice();
				break;
			default:
				println("Invalid Selection");
				break;
			}
		}
	}
	
	
		
	private int getSelection(){
		println(" ");
		println("Please enter your selection (0 to quit)");
		println("1. List all songs");
		println("2. List all albums");
		println("3. Add a song");
		println("4. Add an album");
		println("5. List songs on an album");
		println("6. Update song price");
		int choice = readInt("Selection: ");
		return choice;
	}
	
	
	private void listSongs(){
		println("All songs carried by the store: ");
		for(int i=0; i<songs.size(); i++){
			println(songs.get(i).toString());
		}	
	}
	
	
	private void listAlbums(){
		println("All albums carried by the store: ");
		Iterator<String> albumsIt = albums.keySet().iterator();
		while (albumsIt.hasNext()){
			println (albums.get(albumsIt.next().toString()));
		}		
	}
	
	
	private int findSong(String name, String band){
		int index = -1;
		for (int i = 0; i<songs.size(); i++){
			if(songs.get(i).getSongName().equals(name)
					&& songs.get(i).getBandName().equals(band)){
				index = i;
				break;
			}
		}
		return index;
	}
	
	
	private Song addSong(){
		String name = readLine("Enter song name (enter to quit): ");
		if (name.equals("")) {return null;}
		
		String band = readLine("Enter band name: ");
		int songIndex = findSong(name, band);
		
		if (songIndex!=-1){
			println("That song is already in the store.");
			return songs.get(songIndex);
		} else {
			double price = readDouble("Price :");
			Song song = new Song (name, band, price);
			songs.add(song);
			println("New song added to the store.");
			return song;
		}	
	}
	
	
	private void addAlbum(){
		String name = readLine("Enter album name: ");
		
		if (albums.containsKey(name)){
			println("That album is already in the store.");
		} else {
			String band = readLine("Enter band name: ");
			Album album = new Album(name, band);
			albums.put(name, album);
		
			while (true){
				Song song = addSong();
				if (song==null)break;
				album.addSong(song);
			}
			println ("New album added to the store.");
		}
	}
	
	
	
	private void updateSongPrice(){
		String name = readLine("Song name: ");
		String band = readLine("Band name: ");
		
		int songIndex = findSong(name, band);
		if (songIndex == -1){
			println("That song is not in the store.");
		} else {
			double price = readDouble("Enter new price: ");
			songs.get(songIndex).setPrice(price);
			println("Price for the song \""+ name + " has been updated");
		}	
	}
	
	
	
	private void listSongsOnAlbum(){
		String name = readLine("Album name: ");
		if(albums.containsKey(name)){
			Iterator <Song> it = albums.get(name).getSongs();
			while (it.hasNext()){
				Song song = it.next();
				println(song.toString());
			}	
		} else {
			println("No album by that name in the store.");
		}	
	}
	
	
	
	
	
	// Constants
	private static final int QUIT 					= 0;
	private static final int LIST_SONGS				= 1;
	private static final int LIST_ALBUMS 			= 2;
	private static final int ADD_SONG 				= 3;
	private static final int ADD_ALBUM 				= 4;
	private static final int LIST_SONGS_ON_ALBUM 	= 5;
	private static final int UPDATE_SONG_PRICE 		= 6;


	
	// Private instance variables
	private HashMap <String, Album> albums = new HashMap<String, Album>();
	private ArrayList<Song> songs = new ArrayList<Song>();
	
				
			
			
			
			
		
	
	
}
