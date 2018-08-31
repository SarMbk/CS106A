
public class Point {
	
	public Point (int x, int y) {
		px=x;
		py=y;
	}
	
	public void move (int dx, int dy){
		px+=dx;
		py+=dy;
	}

	//Instance variables
	private int px;
	private int py;
}
