package problems;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * GCD 
 * Class tests the third task using JUnit
 */

public class TestJUnitTask3 {
	
	/* Method tests correct values */
	public void testCorrectValues(int result, int[] numbers) {
		assertEquals(result, new Task3(numbers).getGCD());
	}	
	
	@Test
	public void testAllCorrectValues() {		
		testCorrectValues(0, new int[] { 0, 0, 0, 0 });
		testCorrectValues(2, new int[] { 2, 2, 2, 2 });
		testCorrectValues(2, new int[] { -2, -2, -2, -2 });
		testCorrectValues(1, new int[] { -4, -3, 2, 0 });
		testCorrectValues(1, new int[] { -1, 2, -3, 4 });
		testCorrectValues(1, new int[] { -1, -2, -3, -4 });
		testCorrectValues(Integer.MAX_VALUE,
				new int[] { Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE });
		testCorrectValues(1, new int[] { 1, Integer.MAX_VALUE, 1, 1 });
		testCorrectValues(1, new int[] { Integer.MAX_VALUE, Integer.MAX_VALUE, 3, 4 });
		testCorrectValues(1, new int[] { Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 4 });
		testCorrectValues(1,
				new int[] { Integer.MAX_VALUE / 2, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE });
		testCorrectValues(1,
				new int[] { Integer.MAX_VALUE / 2, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE });
		testCorrectValues(1,
				new int[] { Integer.MAX_VALUE / 2, Integer.MAX_VALUE / 2, Integer.MAX_VALUE / 2, Integer.MAX_VALUE });
		testCorrectValues(1, new int[] { Integer.MIN_VALUE + 1, Integer.MIN_VALUE + 2, Integer.MIN_VALUE + 3,
				Integer.MIN_VALUE + 4 });
		testCorrectValues(1, new int[] { 39141, 61425, 81904, 37575 });
		
	}

	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	/* Method tests incorrect values */
	public void testValuesWithExceptions(int[] numbers) {
		exception.expect(IllegalArgumentException.class);
		new Task3(numbers);
	}
	
	@Test
	public void testAllIncorrectValues() {
		testValuesWithExceptions(new int[] { 1, 2, 3, 4, 5, 6 });
		testValuesWithExceptions(new int[] { 2, 4, 6 });
		testValuesWithExceptions(new int[] {});
		testValuesWithExceptions(new int[] { Integer.MIN_VALUE, 2, 3, 4 });
		testValuesWithExceptions(
				new int[] { Integer.MIN_VALUE / 2, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE });
		testValuesWithExceptions(new int[] { Integer.MIN_VALUE / 2, 2, Integer.MIN_VALUE, 4 });
		testValuesWithExceptions(new int[] { 2, 3, 4, Integer.MIN_VALUE });
		
	}
}
