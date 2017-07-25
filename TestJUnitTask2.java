package problems;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * flat number Class tests the second task using JUnit
 */

public class TestJUnitTask2 {
	
	/* Method tests correct values */
	public void testCorrectValues(int resultFloor, int entrNumber, int floors, int flats, int flatNumber) {

		assertArrayEquals(new int[] { resultFloor, entrNumber },
				new int[] { new Task2(floors, flats, flatNumber).countFloorsAndEntr().getResultFloor(),
						new Task2(floors, flats, flatNumber).countFloorsAndEntr().getEntrNumber() });
	}

	@Test
	public void testAllCorrectValues() {
		testCorrectValues(1, 1, 1, 1, 1);
		testCorrectValues(1, 1, 100, 100, 100);
		testCorrectValues(2, 1, 4, 3, 6);
		testCorrectValues(3, 1, 4, 3, 7);
		testCorrectValues(3, 1, 4, 3, 9);
		testCorrectValues(4, 1, 4, 3, 10);
		testCorrectValues(4, 1, 4, 3, 12);
		testCorrectValues(1, 2, 4, 3, 13);
		testCorrectValues(9, 1, 9, 400, 3600);
		testCorrectValues(3, 1, 9, 4, 12);
		testCorrectValues(4, 1, 9, 4, 13);
		testCorrectValues(4, 1, 9, 4, 16);
		testCorrectValues(5, 1, 9, 4, 17);
		testCorrectValues(5, 1, 9, 4, 20);
		testCorrectValues(6, 1, 9, 4, 21);
		testCorrectValues(6, 1, 9, 4, 24);
		testCorrectValues(7, 1, 9, 4, 25);
		testCorrectValues(7, 1, 9, 4, 28);
		testCorrectValues(8, 1, 9, 4, 29);
		testCorrectValues(8, 1, 9, 4, 32);
		testCorrectValues(9, 1, 9, 4, 33);
		testCorrectValues(9, 1, 9, 4, 35);
		testCorrectValues(9, 1, 9, 4, 36);
		testCorrectValues(1, 2, 9, 4, 37);
		testCorrectValues(1, 2, 9, 4, 40);
		testCorrectValues(2, 1, 100, 6, 8);
		testCorrectValues(2, 1, 58, 4, 5);
		testCorrectValues(9007, 2, 45276, 39561, Integer.MAX_VALUE);
		testCorrectValues(685, 2, 46000, 46000, Integer.MAX_VALUE);
		testCorrectValues(46000, 1, 46000, 1, 46000);
		testCorrectValues(1, Integer.MAX_VALUE, 1, 1, Integer.MAX_VALUE);
	}

	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	/* Method tests incorrect values */
	public void testValuesWithExceptions(int floors, int flats, int flatNumber) {
		exception.expect(IllegalArgumentException.class);
		new Task2(floors, flats, flatNumber);
	}

	@Test
	public void testAllIncorrectValues() {
		testValuesWithExceptions(0, 412, 571);
		testValuesWithExceptions(45, 0, 571);
		testValuesWithExceptions(45, 74, 0);
		testValuesWithExceptions(Integer.MAX_VALUE, 700, 997516);
		testValuesWithExceptions(74668, Integer.MAX_VALUE, 7845689);
		testValuesWithExceptions(452686, 954461, Integer.MAX_VALUE);
		testValuesWithExceptions(Integer.MIN_VALUE, 447, 874);
		testValuesWithExceptions(746, Integer.MIN_VALUE, 874);
		testValuesWithExceptions(746, 754, Integer.MIN_VALUE);
		testValuesWithExceptions(-7, -36, 38);
		testValuesWithExceptions(7, -36, -38);
		testValuesWithExceptions(7, 36, -38);
		testValuesWithExceptions(-9, -4, -17);
		testValuesWithExceptions(-9, -4, -20);
		testValuesWithExceptions(-9, -4, -21);
		testValuesWithExceptions(9, -4, -24);
		testValuesWithExceptions(9, -4, -25);
		testValuesWithExceptions(9, 4, -28);
		testValuesWithExceptions(9, 4, -29);
	}

}
