package problems;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Calendar 
 * Class tests the fifth task using JUnit
 */

public class TestJUnitTask5 {
	
	/* Method tests correct values */
	public void testCorrectVals(int result, int newYearWeekDay, int currentMonth, int currentDay) {
		assertEquals(result, new Task5(newYearWeekDay, currentMonth, currentDay).getDayOfTheWeek());
	}
	
	@Test
	public void testAllCorrectValues() {
		testCorrectVals(4, 3, 7, 17);
		testCorrectVals(2, 7, 7, 18);
		testCorrectVals(1, 1, 1, 1);
		testCorrectVals(2, 2, 1, 1);
		testCorrectVals(3, 7, 2, 1);
		testCorrectVals(3, 7, 3, 1);
		testCorrectVals(6, 7, 4, 1);
		testCorrectVals(1, 7, 5, 1);
		testCorrectVals(4, 7, 6, 1);
		testCorrectVals(6, 7, 7, 1);
		testCorrectVals(2, 7, 8, 1);
		testCorrectVals(5, 7, 9, 1);
		testCorrectVals(7, 7, 10, 1);
		testCorrectVals(3, 7, 11, 1);
		testCorrectVals(5, 7, 12, 1);
		testCorrectVals(7, 7, 12, 31);		
	}
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	/* Method tests incorrect values */
	public void testValuesWithExceptions(int newYearWeekDay, int currentMonth, int currentDay) {
		exception.expect(IllegalArgumentException.class);
		new Task5(newYearWeekDay, currentMonth, currentDay);
	}

	@Test
	public void testAllIncorrectValues() {	
		testValuesWithExceptions(0, 12, 31);
		testValuesWithExceptions(7, 0, 31);
		testValuesWithExceptions(7, 2, 0);
		testValuesWithExceptions(8, 12, 31);
		testValuesWithExceptions(7, 13, 31);
		testValuesWithExceptions(7, 2, 29);
		testValuesWithExceptions(-3, 7, 17);
		testValuesWithExceptions(3, -7, 17);
		testValuesWithExceptions(3, 7, -17);
		testValuesWithExceptions(Integer.MIN_VALUE, 7, 17);
		testValuesWithExceptions(3, Integer.MIN_VALUE, 17);
		testValuesWithExceptions(3, 7, Integer.MIN_VALUE);
		testValuesWithExceptions(Integer.MAX_VALUE, 7, 17);
		testValuesWithExceptions(3, Integer.MAX_VALUE, 17);
		testValuesWithExceptions(3, 7, Integer.MAX_VALUE);		
	}
}
