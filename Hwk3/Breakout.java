/*
 * File: Breakout.java
 * -------------------
 * Name:
 * Section Leader:
 * 
 * This file will eventually implement the game of Breakout.
 */



/////////////		IMPORTING NECESSARY LIBRARIES		///////////////
import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Breakout extends GraphicsProgram {
	
	
	
/////////////		DEFINING STATIC VARIABLES			///////////////

/** Width and height of application window in pixels */
	public static final int APPLICATION_WIDTH = 400;
	public static final int APPLICATION_HEIGHT = 600;

/** Dimensions of game board (usually the same) */
	private static final int WIDTH = APPLICATION_WIDTH;
	private static final int HEIGHT = APPLICATION_HEIGHT;

/** Dimensions of the paddle */
	private static final int PADDLE_WIDTH = 100;
	private static final int PADDLE_HEIGHT = 10;

/** Offset of the paddle up from the bottom */
	private static final int PADDLE_Y_OFFSET = 30;
	
/** Y coordinate of the top of paddle */
	private static final int Y_PADDLE = HEIGHT - PADDLE_Y_OFFSET - PADDLE_HEIGHT;

/** Number of bricks per row */
	private static final int NBRICKS_PER_ROW = 10;

/** Number of rows of bricks */
	private static final int NBRICK_ROWS = 10;

/** Separation between bricks */
	private static final int BRICK_SEP = 4;

/** Width of a brick */
	private static final int BRICK_WIDTH =
	  (WIDTH - (NBRICKS_PER_ROW-1) * BRICK_SEP) / NBRICKS_PER_ROW;

/** Height of a brick */
	private static final int BRICK_HEIGHT = 16;

/** Radius of the ball in pixels */
	private static final int BALL_RADIUS = 5;

/** Offset of the top brick row from the top */
	private static final int BRICK_Y_OFFSET = 70;

/** Number of turns */
	private static final int NTURNS = 3;
	
/** Standard pause duration */
	private static final int STD_PAUSE = 4;
	
/** Velocity of ball */
	private static final int VELOCITY = 1;
	
/** PI */
	private static final double PI = 3.14;

	

/////////////		RUN METHOD			///////////////
	
/** Runs the Breakout program. */
	public void run() {
		drawBricks();
		paddleAdd();
		addMouseListeners();
		throwBall();
	}
	
	
	
/////////////     DEFINING PRIVATE METHODS     ///////////////
	
	/*	LOGIC OF IMPLEMENTATION SEQUENCE:
	 * 	1. Draw bricks
	 * 	2. Draw paddle
	 * 	3. Make paddle move with mouse
	 * 	4. Add ball and project it at a random angle
	 * 		4.1. Inside method 4, define a method bounceBall() for bouncing the ball of bricks and edges and removing bricks
	 * 				All other methods are defined to help implement method 4.1.
	 * */
	
	
	
	//	Method for drawing bricks
	private void drawBricks() {
		double x = BRICK_SEP/2;
		int y = BRICK_Y_OFFSET;
		for (int i = 1; i <= NBRICKS_PER_ROW; i++) {
			for (int j = 1; j <= NBRICK_ROWS; j++) {
				GRect brick = new GRect (x, y, BRICK_WIDTH, BRICK_HEIGHT);
				brick.setFilled(true);
				if (j==1 || j==2) {
					brick.setColor(Color.RED);
					brick.setFillColor(Color.RED);
				}
				if (j==3 || j==4) {
					brick.setColor(Color.ORANGE);
					brick.setFillColor(Color.ORANGE);
				}
				if (j==5 || j==6) {
					brick.setColor(Color.MAGENTA);
					brick.setFillColor(Color.MAGENTA);
				}
				if (j==7 || j==8) {
					brick.setColor(Color.GREEN);
					brick.setFillColor(Color.GREEN);
				}
				if (j==9 || j==10) {
					brick.setColor(Color.CYAN);
					brick.setFillColor(Color.CYAN);
				}
				add(brick);
				y+=BRICK_HEIGHT+BRICK_SEP;
			} // this closes the inner loop i.e. the j loop
			y = BRICK_Y_OFFSET;
			x += BRICK_WIDTH+BRICK_SEP;
		} // this closes the outer loop i.e. the i loop
	} // this closes the scope of the drawBricks() method
	
	
	
	//	Method for drawing the paddle
	private void paddleAdd() {
		int y = HEIGHT - PADDLE_Y_OFFSET - PADDLE_HEIGHT;
		int x = (WIDTH - PADDLE_WIDTH)/2;
		
		paddle.setLocation(x,y);
		paddle.setFilled(true);
		add(paddle);
	}
	
	
	
	//	Method for moving the paddle with mouse
	public void mouseMoved (MouseEvent e) {
		double lastX = paddle.getX();
		// if it goes is within screen:
		if (e.getX() + PADDLE_WIDTH < WIDTH && e.getX() >0) {
			paddle.move(e.getX() - lastX, 0);
			lastX = e.getX();	
		}
	}
	
	
	
	//	Method for adding the ball, projecting it at a random angle and ensuring proper trajectory thereafter
	private void throwBall () {
		ball.setLocation(WIDTH/2-BALL_RADIUS, HEIGHT/2);
		ball.setFilled(true);
		add(ball);
		
		int angle = rgen.nextInt(30,150);
		double v_y = VELOCITY*Math.sin(angle*PI/180);
		double v_x = VELOCITY*Math.cos(angle*PI/180);
		
		bounceBall(v_x, v_y);
	}
	
	
	
	//	Method for bouncing ball off walls / paddle / ceiling / bricks
	private void bounceBall(double v_x, double v_y) {
		while (numBricks>0) {
			
			if (!tooCloseLeft(v_x)  &&  !tooCloseRight(v_x)) {
				ball.move(v_x, v_y);
				pause(STD_PAUSE);
			}
			
			if (tooCloseLeft(v_x)) {
				reducedMoveLeft(v_x, v_y);
				v_x*=-1;
				pause(STD_PAUSE);
				ball.move(v_x, v_y);
			}
			
			if (tooCloseRight (v_x)) {
				reducedMoveRight (v_x, v_y);
				v_x*=-1;
				pause(STD_PAUSE);
				ball.move(v_x, v_y);
			}
			
			if (tooClosePaddle(v_x, v_y)) {
				reducedMovePaddle(v_x, v_y);
				v_y*=-1;
				pause(STD_PAUSE);
				ball.move(v_x, v_y);
			}
			
			if (tooCloseCeiling(v_y)){
				reducedMoveCeiling(v_x, v_y);
				v_y*=-1;
				pause(STD_PAUSE);
				ball.move(v_x, v_y);
			}
			
			if (tooCloseBrickAbove(v_x, v_y)) {
				reducedMoveBrickAbove(v_x, v_y);
				v_y*=-1;
				pause(STD_PAUSE);
				ball.move(v_x, v_y);
			}
			
			if(tooCloseBrickLeft(v_x, v_y)) {
				reducedMoveBrickLeft(v_x, v_y);
				v_x*=-1;
				pause(STD_PAUSE);
				ball.move(v_x, v_y);
			}
			
			if(tooCloseBrickRight(v_x, v_y)) {
				reducedMoveBrickRight(v_x, v_y);
				v_x*=-1;
				pause(STD_PAUSE);
				ball.move(v_x, v_y);
			}
			
			if (tooCloseBrickBelow(v_x, v_y)) {
				reducedMoveBrickBelow(v_x, v_y);
				v_y*=-1;
				pause(STD_PAUSE);
				ball.move(v_x, v_y);	
			}
			
			if (didFall()){
				remainingTurns-=1;
				if (remainingTurns>0) {
					pause(1000);
					throwBall();
				}
				else {
					remove(ball);
				}
			} // this closes the if(didFall()) conditional
				
		} // this closes the while(numBricks>0) loop
		
	} // this closes scope of the bounceBall() method
	
	
	
	//	Method for checking if ball will hit the left wall after the next move;
	private boolean tooCloseLeft(double v_x) {
		double leftBallX = ball.getX();
		return (leftBallX+v_x<=0);
	}
	
	
	
	//	Method for checking if ball will hit the right wall after next move;
	private boolean tooCloseRight(double v_x) {
		double rightBallX = ball.getX() + 2*BALL_RADIUS;
		return (rightBallX+v_x>=WIDTH);
	}
	
	
	
	//	Method for checking if the ball will hit the paddle at the next move
	private boolean tooClosePaddle (double v_x, double v_y) {
		double paddleLeftX = paddle.getX();
		double paddleRightX = paddle.getX()+PADDLE_WIDTH;
		double bottomBallX = ball.getX()+BALL_RADIUS;
		double bottomBallY = ball.getY() + 2*BALL_RADIUS;
		return (paddleLeftX <= bottomBallX && bottomBallX <= paddleRightX && (bottomBallY+v_y)>=Y_PADDLE);
	}
	
	
	
	//	Method for checking if the ball will hit the ceiling at the next move
	private boolean tooCloseCeiling (double v_y) {
		double topBallY = ball.getY();
		return (topBallY + v_y <=0);
	}
	
	
	
	//	Method for checking if the ball will hit the brick from BELOW after the next move
	private boolean tooCloseBrickAbove (double v_x, double v_y) {
		double topBallY = ball.getY();
		double topBallX = ball.getX()+BALL_RADIUS;
		/*Will return true if there is an element in the path of ball other than the ball itself*/
		return (getElementAt(topBallX+v_x, topBallY+v_y)!=null && getElementAt(topBallX+v_x, topBallY+v_y)!=ball);
	}
	
	
	
	//	Method for checking if the ball will hit the brick from ABOVE after the next move
	private boolean tooCloseBrickBelow (double v_x, double v_y) {
		double bottomBallY = ball.getY()+ 2*BALL_RADIUS;
		double bottomBallX = ball.getX()+BALL_RADIUS;
		/*Will return true if there is an element in the path of ball other than the ball itself*/
		return (getElementAt(bottomBallX+v_x, bottomBallY+v_y)!=null && getElementAt(bottomBallX+v_x, bottomBallY+v_y)!=ball);
	}
	
	
	
	//	Method for checking if the ball will hit the brick from the RIGHT after the next move
	//	i.e. brick is to the LEFT of ball, ball will hit brick from RIGHT side
	private boolean tooCloseBrickLeft (double v_x, double v_y) {
		double leftBallX = ball.getX();
		double leftBallY = ball.getY() + BALL_RADIUS;
		return (getElementAt(leftBallX+v_x, leftBallY+v_y)!=null && getElementAt(leftBallX+v_x, leftBallY+v_y)!=ball);
	}
	
	
	
	//	Method for checking if the ball will hit the brick from the LEFT after the next move
	//	i.e. brick is to the RIGHT of ball, ball will hit brick from LEFT side
	private boolean tooCloseBrickRight (double v_x, double v_y) {
		double rightBallX = ball.getX() + 2*BALL_RADIUS;
		double rightBallY = ball.getY() + BALL_RADIUS;
		return (getElementAt(rightBallX+v_x, rightBallY+v_y)!=null && getElementAt(rightBallX+v_x, rightBallY+v_y)!=ball);
	}
	
	
	
	//	Method for checking if the ball fell though to the bottom;
	private boolean didFall() {
		return (ball.getY() > HEIGHT);
	}
	
	
	
	//	Method for reducing the move of ball if it is too close to the left side;
	private void reducedMoveLeft(double v_x, double v_y) {
		double leftBallX = ball.getX();
		double reduced_v_x = -leftBallX;
		double reduced_v_y = v_y*reduced_v_x/v_x;
		ball.move(reduced_v_x, reduced_v_y);
	}
	
	
	
	//	Method for reducing the move of ball if it is too close to the right side;
	private void reducedMoveRight(double v_x, double v_y) {
		double rightBallX = ball.getX() + 2*BALL_RADIUS;
		double reduced_v_x = WIDTH -rightBallX;
		double reduced_v_y = v_y*reduced_v_x/v_x;
		ball.move(reduced_v_x, reduced_v_y);
	}
	
	
	
	//	Method for reducing ball move if it's too close to paddle;
	private void reducedMovePaddle(double v_x, double v_y) {
		double bottomBallY = ball.getY() + 2*BALL_RADIUS;
		double reduced_v_y = bottomBallY - Y_PADDLE;
		double reduced_v_x = v_x*reduced_v_y/v_y;
		ball.move(reduced_v_x, reduced_v_y);
	}
	
	
	
	//	Method for reducing ball move if it's too close to ceiling;
	private void reducedMoveCeiling (double v_x, double v_y) {
		double reduced_v_y = -ball.getY();
		double reduced_v_x = v_x*reduced_v_y/v_y;
		ball.move(reduced_v_x, reduced_v_y);
	}
	
	
	
	//	Method for reducing ball move if it's too close to brick ABOVE;
	//	This method also removes the brick after collision from BELOW
	private void reducedMoveBrickAbove (double v_x, double v_y) {
		double topBallY = ball.getY();
		double topBallX = ball.getX()+BALL_RADIUS;
		//	no need for a conditional as the ball will never hit the paddle from below
		GObject brick = getElementAt(topBallX+v_x, topBallY+v_y);
		double bottomBrickY = brick.getY()+BRICK_HEIGHT;
		double reduced_v_y = bottomBrickY - topBallY;
		double reduced_v_x = v_x*reduced_v_y/v_y;
		ball.move(reduced_v_x, reduced_v_y);
		remove(brick);
		numBricks-=1;
	}
	
	
	
	//	Method for reducing ball move if it's too close to brick BELOW;
	//	This method also removes the brick after collision from ABOVE
	private void reducedMoveBrickBelow (double v_x, double v_y) {
		double bottomBallY = ball.getY() + 2 * BALL_RADIUS;
		double bottomBallX = ball.getX()+BALL_RADIUS;
		//	The conditional ensures that only bricks and not the paddle disappear after collision
		if (getElementAt(bottomBallX+v_x, bottomBallY+v_y)!=paddle){
			GObject brick = getElementAt(bottomBallX+v_x, bottomBallY+v_y);
			double topBrickY = brick.getY();
			double reduced_v_y = bottomBallY - topBrickY;
			double reduced_v_x = v_x*reduced_v_y/v_y;
			ball.move(reduced_v_x, reduced_v_y);
			remove(brick);
			numBricks-=1;
			}	
	}
	
	
	
	//	Method for reducing the ball move if it's about to hit a brick from RIGHT
	//	i.e. brick is to the LEFT of ball, ball will hit brick from RIGHT side
	//	this method also removes the brick after collision.
	private void reducedMoveBrickLeft (double v_x, double v_y) {
		double leftBallX = ball.getX();
		double leftBallY = ball.getY() + BALL_RADIUS;
		//	The conditional ensures that only bricks and not the paddle disappear after collision
		if (getElementAt(leftBallX+v_x, leftBallY+v_y)!=paddle){
			GObject brick = getElementAt(leftBallX+v_x, leftBallY+v_y);
			double rightBrickX = brick.getX() + BRICK_WIDTH;
			double reduced_v_x = rightBrickX - leftBallX;
			double reduced_v_y = v_y * reduced_v_x / v_x;
			ball.move(reduced_v_x, reduced_v_y);
			remove(brick);
			numBricks-=1;
		}	
	}
	
	
	
	//	Method for reducing the ball move if it's about to hit a brick from LEFT
	//	i.e. brick is to the RIGHT of ball, ball will hit brick from LEFT side
	//	this method also removes the brick after collision.
	private void reducedMoveBrickRight (double v_x, double v_y) {
		double rightBallX = ball.getX() + 2 * BALL_RADIUS;
		double rightBallY = ball.getY() + BALL_RADIUS;
		//	The conditional ensures that only bricks and not the paddle disappear after collision
		if (getElementAt(rightBallX+v_x, rightBallY+v_y)!=paddle){
			GObject brick = getElementAt(rightBallX+v_x, rightBallY+v_y);
			double leftBrickX = brick.getX();
			double reduced_v_x = leftBrickX - rightBallX;
			double reduced_v_y = v_y * reduced_v_x / v_x;
			ball.move(reduced_v_x, reduced_v_y);
			remove(brick);
			numBricks-=1;
		}
	}
	
	
	
/////////////     DEFINING PRIVATE VARIABLES     ///////////////
	
	//	Declare graphical objects:
	private GRect paddle = new GRect (PADDLE_WIDTH, PADDLE_HEIGHT);
	private GOval ball = new GOval (2*BALL_RADIUS, 2*BALL_RADIUS);
	
	
	//	Random number generator for random angle of ball trajectory at start
	private RandomGenerator rgen = RandomGenerator.getInstance();
	
	
	//	Declare a number of bricks variable to track how many bricks left on screen
	private int numBricks = NBRICKS_PER_ROW * NBRICK_ROWS;
	private int remainingTurns = NTURNS;	
	
	
	
}
