import acm.program.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Lecture21_notes extends ConsoleProgram {
	
	public void init(){
		
		hi = new JButton ("Hi");
		add(hi, SOUTH);
		
		add(new JLabel("   Enter Your Name:"), SOUTH);
		
		// interactive text fields
		tf = new JTextField(10);
		tf.addActionListener(this);
		add(tf, SOUTH);
		
		addActionListeners();
		
	}
	
	public void actionPerformed (ActionEvent e){
		if (e.getSource()==hi){
			println("HELLO");
		}
		
		if(e.getSource()==tf){
			println("Hello there, " + tf.getText() + "!");
		}
	}
	
	
	private JButton hi;
	private JTextField tf;
}
