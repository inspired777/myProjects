package problems;

import static org.junit.Assert.*;
import org.junit.Test;

/** 
 * swap
 * Class tests the first task using JUnit 
 *	
 */

public class TestJUnit {
	
	/* Method tests correct values */
	public void testCorrectValues(int x, int y) {
		assertArrayEquals(new int[] {y, x}, new int[] {
				new Task1(x, y).swapValues().getX(),
				new Task1(x, y).swapValues().getY()
		});
	}

	@Test
	public void testAllCorrectValues() {	
		testCorrectValues(0, 0);
		testCorrectValues(0, 1);
		testCorrectValues(1, 0);
		testCorrectValues(0, -1);
		testCorrectValues(-1, 0);
		testCorrectValues(1, 1);
		testCorrectValues(-1, -1);
		testCorrectValues(Integer.MAX_VALUE, 0);
		testCorrectValues(0, Integer.MAX_VALUE);
		testCorrectValues(Integer.MIN_VALUE, 0);
		testCorrectValues(0, Integer.MIN_VALUE);
		testCorrectValues(Integer.MAX_VALUE, Integer.MIN_VALUE);
		testCorrectValues(Integer.MIN_VALUE, Integer.MAX_VALUE);
		testCorrectValues(Integer.MAX_VALUE, Integer.MAX_VALUE);
		testCorrectValues(Integer.MIN_VALUE, Integer.MIN_VALUE);
		testCorrectValues(Integer.MIN_VALUE / 2, Integer.MAX_VALUE);
		testCorrectValues(Integer.MAX_VALUE, Integer.MIN_VALUE / 2);
		testCorrectValues(Integer.MAX_VALUE / 2, Integer.MIN_VALUE);
		testCorrectValues(Integer.MIN_VALUE, Integer.MAX_VALUE / 2);
		testCorrectValues(Integer.MIN_VALUE / 2, Integer.MIN_VALUE);
		testCorrectValues(Integer.MIN_VALUE, Integer.MIN_VALUE / 2);
		testCorrectValues(Integer.MAX_VALUE / 2, Integer.MAX_VALUE);
		testCorrectValues(Integer.MAX_VALUE, Integer.MAX_VALUE / 2);
		testCorrectValues(Integer.MAX_VALUE / 2, Integer.MAX_VALUE / 2);
		testCorrectValues(Integer.MIN_VALUE / 2, Integer.MIN_VALUE / 2);
		testCorrectValues(Integer.MAX_VALUE / 2, Integer.MIN_VALUE / 2);
		testCorrectValues(Integer.MIN_VALUE / 2, Integer.MAX_VALUE / 2);
	}

}