/*	This is a bouncing ball graphic program.	
*/

import acm.program.*;
import acm.graphics.*;
//import java.awt.event.*;



public class BouncingBall extends GraphicsProgram {
	
	
	
	//DECLARE STATIC VARIABLES:
	private static final double V_X0 = 2;		//	constant horizontal speed.
	private static final double V_Y0 = 0;		//	initial speed in Y direction.
												//	declared as a static variable to make it easy to change.
	private static final double X_0 = 10;		//	initial x coordinate of ball.
	private static final double Y_0 = 50;		//	initial y coordinate of ball.
	private static final double G = 1;			//	constant gravity acceleration in the y direction.
	private static final double D = 70;			//	constant ball diameter.
	private static final double C = 0.9;		//	damping coefficient C. Every time the ball bounces it rebounds with 90%
												//	of its vertical speed.
	private static final int STD_PAUSE = 50;	//	standard pause between actions.


	
	
	
	
	public void run() {
		
		//	Define variable for initial vertical speed of ball.
		//	Horizontal speed is always the same and is defined in constants.
		double v_y = V_Y0;
		
		
		
		//	Define ball location and geometry.
		
		//	We created a class GFace and replaced the ball with it
		GFace ball = new GFace (D,D);
		ball.setLocation(X_0, Y_0);
		//ball.setFilled(true);
		add(ball);

		
		
		//	Define ball movement.	
		while (true) {
			
			
			//	while it's not close enough to the bottom as to go "below ground" after the next move:
			while (!tooCloseToGnd(ball, v_y)) {
				ball.move(V_X0, v_y);
				v_y+=G;
				pause(STD_PAUSE);
			}
			
			
			//	If the ball is close enough to the ground that it will move "below ground" after the next move:
			if (tooCloseToGnd(ball, v_y)) {
				reducedMove(ball, v_y);
			}
			
			
			//	If the ball touched the ground:
			if (didHitGround(ball)) {
				v_y*=-C;
				v_y+=G;
				pause(STD_PAUSE);
			}
		}
	}
	
	
	
	
	
	//	DEFINING PRIVATE METHODS:
	
	//	Define method for checking whether the next incremental move will render the ball "below ground".
	private boolean tooCloseToGnd(GObject object, double v_y) {
		double bottomBallY = object.getY()+D;
		if(bottomBallY+v_y>=getHeight()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	
	//	Define method for a reduced move, so that when the ball is too close to the ground it will be moved just the
	//	right distance to touch the bottom of screen. The reduction in speed will be compensated by 
	//	the proportional reduction in pause interval.
	private void reducedMove(GObject object, double v_y) {
		double bottomBallY = object.getY()+D;
		double reduced_v_y = getHeight()-bottomBallY;
		double reduced_v_x = V_X0*reduced_v_y/v_y;
		object.move(reduced_v_x, reduced_v_y);
		//pause(STD_PAUSE*reduced_v_y/v_y);
	}
	
	
	
	// Define method for checking if ball hit bottom of graphics window
	private boolean didHitGround(GObject object) {
		double bottomBallY = object.getY()+D;
		if (bottomBallY==getHeight()){
			return true;
		}
		else {
			return false;
		}
	}	
	
}
