import acm.graphics.*;
import acm.program.*;
import java.awt.*;

//Hello World Program
public class HelloWorld extends GraphicsProgram {
	
	public void run() {
		GLabel label = new GLabel ("Hello World", 100, 75);
		label.setFont("TimesNewRoman-36");
		label.setColor(Color.BLACK);
		add(label);
		
	}
}