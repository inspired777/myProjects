package problems;

/**
 * Class solves the problem of swapping two integers without the third variable.
 *    
 */

public class Task1 {
	private static int x;			// the first value
	private static int y;			// the second value
	
	/* Constructor */
	public Task1(int oldx, int oldy) {
		
		Task1.x = oldx;
		Task1.y = oldy;
	}
	
	/* Method returns x */
	public int getX() {
		return x;
	}
	
	/* Method returns y */
	public int getY() {		
		return y;
	}
		
	/* Method swaps values of x and y. */
	public Task1 swapValues() {
		
		x = x + y;
		y = x - y;
		x = x - y;

		return new Task1(x, y);
	}


}

