import acm.program.*;
import acm.util.*;
import acm.graphics.*;
import acm.gui.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

import javax.swing.*;


public class MusicShop extends Program {
	
	public void init(){
		label = new JLabel ("Album Name: ");
		albumName = new JTextField (20);
		add(label, SOUTH);
		add(albumName, SOUTH);
		
		canvas = new MusicShopDisplay();
		add(canvas);
		
		loadInventory();
		
		addActionListeners();
		albumName.addActionListener(this);	
	}
	
	
	
	
	private void loadInventory(){
		try {
			BufferedReader rd = new BufferedReader(new FileReader("musicdata.txt"));
			while(true){
				String line = rd.readLine();
				if (line == null) {break;}
				Album album = parseLine(line);
				inventory.put(album.getAlbumName(), album);	
			}
			rd.close();	
		} catch (IOException ex) {
			throw new ErrorException(ex);
		}	
	}
	
	
	
	
	private Album parseLine(String line) {
		int albumNameStart = line.indexOf("[")+1;
		int albumNameEnd = line.indexOf("]");
		String albumName = line.substring(albumNameStart, albumNameEnd);
		
		
		int bandNameStart = line.indexOf("[", albumNameEnd +1) + 1;
		int bandNameEnd = line.indexOf("]", albumNameEnd +1);
		String bandName = line.substring(bandNameStart, bandNameEnd);
		
		int numStockedStart = line.indexOf(" ", bandNameEnd+1)+1;
		int numStocked = Integer.parseInt(line.substring(numStockedStart));
		
		return (new Album(albumName, bandName, numStocked));	
	}
	
	
	
	
	public void actionPerformed(ActionEvent e){
		if (e.getSource() == albumName){
			canvas.displayInventory(inventory.get(albumName.getText()));
		}
	}
	
	
	private JLabel label;
	private JTextField albumName;
	private MusicShopDisplay canvas;
	private HashMap<String, Album> inventory = new HashMap<String, Album>();

}
