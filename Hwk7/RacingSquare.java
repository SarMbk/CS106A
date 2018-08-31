import acm.graphics.*;
import acm.util.RandomGenerator;

import java.awt.*;


public class RacingSquare extends GRect implements Runnable {
	
	public RacingSquare(int index, boolean[] finished){
		super(SIZE,SIZE);
		setFilled(true);
		myIndex=index;
		finishers=finished;
	}
	
	
	public void run(){
		
		
		finishers[myIndex]=false;
		for (int i=0; i<100; i++) {
			pause(rgen.nextInt(100,200));
			move(STEP,0);
		}
		
		int count =0;
		for (int i=0; i<finishers.length; i++){
			if(finishers[i]){
				count++;
			}
		}
		
		finishers[myIndex]=true;
		if(count==0){
			setColor(Color.RED);
		}
		
	}

	
	private static final double STEP=5;
	private static final double SIZE=20;

	
	
	private RandomGenerator rgen = new RandomGenerator();
	private int myIndex;
	private boolean[] finishers;
	

}
