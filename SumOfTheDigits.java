package testAssignment;

import java.util.Scanner;

/**
 * The class provides the solution of the task #3: 
 * 		Find the sum of the digits in the number
 **/
public class SumOfTheDigits {

	/* Create the array result[] to store the result of factorial calculation */
	private static int[] result = new int[500];
	
	/* Variable result_size contains the actual quantity of numbers stored in the result[] */
	private static int result_size;	

	/*
	 * Method findFactorial() calculates factorial of a given integer 
	 *  */
	public static void findFactorial (int number) {
		
		/* The first element of the array result[] is set to 1 (the first number in factorial series) */
		result[0] = 1;
		
		/* Array result[] now contains one number*/
		result_size = 1;
		
		for (int i = 2; i <= number; i++) {
			multiply(i);							// Applying multiplication to every i (until i equals number)
		}		
	}
	
	/*
	 * Method multiply() finds the product of integers.
	 * Each cell of the array result[] contains a digit (0...9).
	 * The result of the multiplication is stored in the array result[] backwards
	 * */
	public static void multiply(int x) {
		int carry = 0;								// Stores a mathematical carry
		int product;								// Stores a product of integers
		
		/* Long Multiplication */
		for (int i = 0; i < result_size; i++) {
			product = result[i] * x + carry;
			result[i] = product % 10;
			carry = product / 10;
		}
		
		/* If carry is greater than 0, it is saved in the next cell of the array result[]*/
		while (carry != 0) {
			result[result_size] = carry % 10;
			carry = carry / 10;
			result_size++;							// result[] contains more digits
		}
	}
	
	/*
	 * Method findSum() returns the sum of integers in the array result[]
	 * */	
	public static int findSum() {
		int sum = 0;								// Stores a sum of digits in the number
		
		/* Calculate sum */
		for (int i = result_size - 1; i >= 0; i--) {
			sum += result[i];
		}
		
		return sum;
	}	
	
	public static void main(String[] args) {		
		System.out.println("Give a number greater than 0:");		
		
		/* Read an integer from console */
		Scanner sc = new Scanner(System.in);		
		int number = sc.nextInt();
		sc.close();

		findFactorial(number);						// Find factorial of the given number

		System.out.println("Sum = " + findSum());	// Print sum of digits on the factorial		
	}
}



