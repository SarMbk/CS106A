import acm.program.*;
import acm.graphics.*;


public class GImageExample extends GraphicsProgram {
	
	public void run () {
		// this is how you add an image to a graphics program
		// you place a jpg or gif file into the folder named images inside the class directory
		GImage image = new GImage("img1.jpg");	//	make sure to use double quotes
		image.scale (0.2,1);					//	this is how to scale an image
		add(image,0,0);
	}

}
