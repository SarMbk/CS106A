import acm.program.*;
import acm.graphics.*;

import java.awt.event.ActionEvent;

import javax.swing.*;


public class ThreadsExample extends GraphicsProgram {
	
	public void run(){
		racers = new RacingSquare[NUM_RACERS];
		finished = new boolean [NUM_RACERS];
		threads = new Thread[NUM_RACERS];
		
		// FINISH LINE
		add(new GLine(510,0,510,400));
		
		add(new JButton("Start"), SOUTH);
		addActionListeners();
		
		
			
		}
	
	public void actionPerformed(ActionEvent e){
		String cmd = e.getActionCommand();
		
		if(cmd.equals("Start")){
			
			for (int i=0; i<NUM_RACERS; i++){
				
				if (racers[i]!=null){
					remove(racers[i]);
				}
				
				racers[i]=new RacingSquare(i, finished);
				add(racers[i], 10, 10+ 40*i);
				
				threads[i] = new Thread(racers[i]);
				threads[i].start();
				
			}
		}
	}
	
	
	private static final int NUM_RACERS = 10;
	
	private RacingSquare[] racers;
	private boolean[] finished;
	private Thread[] threads;
	

}
