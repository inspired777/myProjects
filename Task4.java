package problems;

import java.util.*;

/**
 * Class solves the problem of calculating Fibonacci number.
 * */

public class Task4 {

	/* Constants */
	private static final int ZERO = 0;
	private static final int ONE = 1;
	private static final int TWO = 2;
	private static final int LIMIT = 46;
	
	/* Method calculates Fibonacci number. */
	public int calcFibonacci(int number) {
	
		try {
			
			if(number < ZERO) {
				throw new IllegalArgumentException("n should be greater than 0. n = " + number);
			}
			
			if(number > LIMIT) {
				throw new IllegalArgumentException(
						"Cannot calculate Fibonacci number of n > 46. n = " + number);
			}
			
		} catch(InputMismatchException e) {
			throw new InputMismatchException("The wrong argument is given.");
		}	
				
		if ((number == ONE) || (number == ZERO)) {
			return number;
		} else {
			return calcFibonacci(number - ONE) + calcFibonacci(number - TWO);
		}
	}


}
