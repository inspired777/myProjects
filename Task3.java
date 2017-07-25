package problems;

import java.util.*;

/**
 * Class solves the problem of finding the greatest common divisor among 4
 * integers.
 */

public class Task3 {

	/*  The number of values. */
	private static final int NUMBER_OF_INTEGERS = 4;
	
	/* The array to store values. */
	private static int[] A = new int[NUMBER_OF_INTEGERS];

	/* Constructor */
	public Task3(int[] array) {

		try {

			if ((array.length < NUMBER_OF_INTEGERS) || (array.length > NUMBER_OF_INTEGERS)) {
				throw new IllegalArgumentException(
						"The number of integers should be 4. Given number of integers = " + array.length);
			}			

			/*
			 * If the array contains negative values, they are turned into positive
			 * values.
			 */
			for (int i = 0; i < array.length; i++) {
				if (array[i] < 0) {
					array[i] = Math.abs(array[i]);
				}
				if (array[i] == Integer.MIN_VALUE) {
					throw new IllegalArgumentException("The value must be greater than " + Integer.MIN_VALUE);
				}
			}		
			
			Task3.A = array;
			
		} catch (NumberFormatException e) {
			throw new NumberFormatException("The wrong argument is given.");
		}
	}

	/* Method calculates the greatest common divisor among 4 integers. */
	public int getGCD() {

		/* Sort the array. */
		Arrays.sort(A);

		/* The minimum value of the array. */
		int result = A[0];
		for (int i = 0; i < A.length; i++) {
			if (A[i] != 0) {
				result = A[i];
				break;
			}
		}

		/* The algorithm for GCD */
			while (true) {
				int temp = result;
				for (int number : A) {					
					if (number == 0) {
						continue;
					}
					int tDiv = number / result;				
					if (!((tDiv > 0) && (number % result == 0)))
						result = number / (tDiv + 1);
				}
				if (temp == result)
					break;
			}

		return result;
	}

}
