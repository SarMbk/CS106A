import acm.gui.*;
import acm.program.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class GridLayoutExample extends Program{
	
	public void init(){
		
		setLayout(new TableLayout(2,3));
		//setLayout(new GridLayout(2,3));
		add(new JButton ("Button 1"));
		add(new JButton ("Button 2"));
		add(new JButton ("Button 3"));
		add(new JButton ("Button 4"));
		add(new JButton ("Button 5"));
		add(new JButton ("Button 6"));
		
		
		addActionListeners();

	}

	
	public void actionPerformed (ActionEvent e){

	}
	
	
}

