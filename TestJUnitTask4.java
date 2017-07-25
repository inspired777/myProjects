package problems;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Fibonacci 
 * Class tests the fourth task using JUnit
 */

public class TestJUnitTask4 {
	
	/* Method tests correct values */
	public void testValue(int result, int value) {
		assertEquals(result, new Task4().calcFibonacci(value));
	}
		
	@Rule
    public ExpectedException exception = ExpectedException.none();		
	
	/* Method tests incorrect values */
	public void testValueWithException(int value) {
		exception.expect(IllegalArgumentException.class);
		new Task4().calcFibonacci(value);
	}		
	
	@Test
	public void testAllCorrectValues() {	
		testValue(0, 0);
		testValue(1, 1);
		testValue(1, 2);
		testValue(2, 3);
		testValue(3, 4);
		testValue(5, 5);
		testValue(55, 10);
		testValue(610, 15);
		testValue(6765, 20);
		testValue(75025, 25);
		testValue(832040, 30);
		testValue(9227465, 35);
		testValue(102334155, 40);
		testValue(165580141, 41);
		testValue(701408733, 44);
		testValue(1134903170, 45);
		testValue(1836311903, 46);
	}
	
	@Test
	public void testAllIncorrectValues(){
		testValueWithException(47);			
		testValueWithException(48);	
		testValueWithException(49);	
		testValueWithException(50);
		testValueWithException(100);
		testValueWithException(1000);
		testValueWithException(10000);	
		testValueWithException(Integer.MAX_VALUE);
		testValueWithException(-1);		
		testValueWithException(-10);		
		testValueWithException(-15);		
		testValueWithException(-100);        
		testValueWithException(Integer.MIN_VALUE);		
	}
}
