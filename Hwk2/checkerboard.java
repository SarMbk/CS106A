import acm.graphics.*;
import acm.program.*;
import java.awt.*;


public class checkerboard extends GraphicsProgram {
	
	private static final int NROWS = 12;
	private static final int NCOLS = 12;
	
	public void run () {
		int sqSize = getHeight()/NROWS;
		
		for (int i=0; i<NROWS; i++) {
			for(int j=0; j<NCOLS; j++){
				int x = i*sqSize;
				int y = j*sqSize;
				GRect square = new GRect(x,y,sqSize,sqSize);
				square.setFilled((i+j)%2!=0);
				add(square);
			}		
		}
	}
}
