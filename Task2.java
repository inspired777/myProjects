package problems;

/**
 * Class solves the problem of finding the flat position by its number.
 * */

public class Task2 {
	
	private static int floors;		// the number of floors
	private static int flats;		// the number of flats
	private static int flatNumber;	// the flat number
	
	private static int entrNumber;	// the entrance number
	private static int resultFloor;	// the floor number

	/* Method returns the entrance number */
	public int getEntrNumber() {
		return entrNumber;
	}
	
	/* Method returns the floor number */
	public int getResultFloor() {
		return resultFloor;
	}
 	
	/* Constructor */
	public Task2(int floors, int flats, int flatNumber) {
		
		try {
			
		/* If the number of the floors is less than 0,
		 * the method throws IllegalArgumentException. */
		if(floors <= 0) {
			throw new IllegalArgumentException("The number of floors cannot be less than 0. Floors = " + floors);
		}
		
		/* If the number of flats on the floor is less than 0,
		 * the method throws IllegalArgumentException. */
		if (flats <= 0) {
			throw new IllegalArgumentException(
					"The number of flats cannot be negative or less than 0. Flats = " + flats);
		}		
		
		/* If the flat number is less than 0,
		 * the method throws IllegalArgumentException. */
		if(flatNumber <= 0) {
			throw new IllegalArgumentException("The number of the flat is less than 0. Flat number = " + flatNumber);
		}
				
		if (floors > 46000) {
			throw new IllegalArgumentException(
					"The number of floors should be less than 46000. "
					+ "Given number of floors = " + floors);
		}
				
		if (flats > 46000) {
			throw new IllegalArgumentException(
					"The number of flats should be less than 46000. "
					+ "Given number of flats = " + flats);
		}		
		
			Task2.floors = floors;
			Task2.flats = flats;
			Task2.flatNumber = flatNumber;
		
		} catch (NumberFormatException e) {
			throw new NumberFormatException("The wrong argument is given.");
		}
		
	}
	
	/* Method calculates the floor and the entrance by the given flat number. */
	public Task2 countFloorsAndEntr() {		
				
		/* Calculate the entrance number. */
		entrNumber = flatNumber / (floors * flats);

		/* If the given flat number is greater than the number of flats in the current entrance, 
		 * then this flat is in the next entrance. */
		if (flatNumber % (floors * flats) > 0) {
			entrNumber++;
		}

		/* Calculate the floor number. */
		resultFloor = (flatNumber % (floors * flats)) / flats;
		
		/* If the given flat number is greater than the number of flats on the current floor,
		 * then this flat is on the next floor. */
		if ((flatNumber % (floors * flats)) % flats > 0) {
			resultFloor++;
		} else if (resultFloor == 0) {
			
			/* If the given flat number is equal to the number of flats on the current floor,
			 * then the flat is on the current floor. */
			resultFloor = floors;
		}
		
		/* Print the result of the program. */
		System.out.println(flatNumber + ": " + resultFloor + " floor, " + entrNumber + " entrance");
		
		Task2 t2 = new Task2(floors, flats, flatNumber);
		return t2;
	}


}
