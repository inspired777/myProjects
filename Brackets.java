package testAssignment;

import java.util.Scanner;

/**
 * The class provides the solution of the task #1: 
 * 		Find the number of the correct bracket expressions 
 * 		that contain N opening and N closing brackets.
 */
public class Brackets {

	/*
	 * Method countBrackets() returns the number of correct bracket expressions
	 * by the given number n of brackets.
	 * Catalan number is used.
	 */
	public static long countBrackets(int n) {

		if (n == 0) {
			return n;
		} else if (n > 14) {
			System.out.println("n > 14");
			return n;
		} else {
			
			/* Calculate factorial of n */
			long factN = findFactorial(n);
			
			/* Variable result contains the number of correct bracket expressions. */
			long result = 0;
			
			/* Variable prod contains the product of numbers. */
			long prod = 1;

			for (int i = n + 2; i <= 2 * n; i++) {
				prod *= i;					// Calculate product
			}
			
			result = prod / factN;

			return result;
		}
	}

	/* Method findFactorial() calculates the factorial of the given number n. */
	public static long findFactorial(long n) {
		if (n == 0) {
			return n;
		} else if (n == 1) {
			return n;
		} else {
			return n * findFactorial(n - 1);
		}
	}

	public static void main(String[] args) {
		System.out.println("Write n (between 0 and 14):");

		/* Read number of opening and closing brackets from console. */
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();

		/* Print the number of correct bracket expressions. */
		System.out.println(countBrackets(n));

	}

}
