package problems;

/**
 * Class solves the problem of finding the day of the week by the day of the week of the new year.
 * */

public class Task5 {
	
	private static final int DAYS_IN_WEEK = 7; 		// the number of days of the week
	private static final int MONTHS_IN_YEAR = 12; 	// the number of months in a year
	private static final int MAX_DAYS_IN_A_MONTH = 31; // the maximum number of days in a month
	
	private static int newYearWeekDay;				// the number of day of the week of the new year
	private static int currentMonth;				// the number of the current month
	private static int currentDay;					// the number of the current day

	public Task5(int nyWeekDay, int currMonth, int currDay) {
		
		try {
			
			/* If the number of the day of the week of the new year is less than 1 or 
			 * greater than the number of days in a week, the method throws IllegalArgumentException. */
			if ((nyWeekDay < 1) || (nyWeekDay > DAYS_IN_WEEK)) {
				throw new IllegalArgumentException(
						"Week day must be >= 1 and <= 7. Given day of the week = " + nyWeekDay);
			}
			
			/* If the number of the current month is less than 1 or greater than the number of months in a year,
			 * the method throws IllegalArgumentException. */
			if ((currMonth < 1) || (currMonth > MONTHS_IN_YEAR)) {
				throw new IllegalArgumentException("Month must be >= 1 and <= 12. Given month = " + currMonth);
			}
			
			/* If the current day is less than 1 or greater than the number of days in particular month,
			 * the method throws IllegalArgumentException. */
			if ((currDay < 1) || (currDay > getDaysInMonth(currMonth))) {
				throw new IllegalArgumentException(
						"The day must be >= 1 and <= " + getDaysInMonth(currMonth) + ". Given day = " + currDay);
			}
			
			newYearWeekDay = nyWeekDay;
			currentMonth = currMonth;
			currentDay = currDay;
			
		} catch (NumberFormatException e) {
			throw new NumberFormatException("The wrong argument is given.");
		}
	}
	
	/* Method returns the number of days in the given month. */
	public static int getDaysInMonth(int currentMonth) {

		int result = -1;

		switch (currentMonth) {
		case 1:				// January
			result = MAX_DAYS_IN_A_MONTH;
			break;
		case 2:				// February
			result = 28;
			break;
		case 3:				// March
			result = MAX_DAYS_IN_A_MONTH;
			break;
		case 4:				// April
			result = 30;
			break;
		case 5:				// May
			result = MAX_DAYS_IN_A_MONTH;
			break;
		case 6:				// June
			result = 30;
			break;
		case 7:				// July
			result = MAX_DAYS_IN_A_MONTH;
			break;
		case 8:				// August
			result = MAX_DAYS_IN_A_MONTH;
			break;
		case 9:				// September
			result = 30;
			break;
		case 10:			// October
			result = MAX_DAYS_IN_A_MONTH;
			break;
		case 11:			// November
			result = 30;
			break;
		case 12:			// December
			result = MAX_DAYS_IN_A_MONTH;
			break;
		}

		return result;
	}

	/* Method prints the result of the program. */
	public static void printResult(int dayOfTheWeek) {
		
		/* If the number of the current day of the week is less than 1 or greater than 7,
		 * the method throws IllegalArgumentException. */
		if (dayOfTheWeek < 1 || dayOfTheWeek > DAYS_IN_WEEK) {
			throw new IllegalArgumentException("Day of the week must be >=1 and <= 7");
		}
		
		switch (dayOfTheWeek) {
		case 1:
			System.out.println("Monday");
			break;
		case 2:
			System.out.println("Tuesday");
			break;
		case 3:
			System.out.println("Wednesday");
			break;
		case 4:
			System.out.println("Thursday");
			break;
		case 5:
			System.out.println("Friday");
			break;
		case 6:
			System.out.println("Saturday");
			break;
		case 7:
			System.out.println("Sunday");
			break;
		}
	}

	/* Method returns the day of the week given the day of the week of the new year, 
	 * current month number and current day. */
	public int getDayOfTheWeek() {

		/* Calculate the number of days from the new year to the current day. */
		int numberOfDays = currentDay - 1;
		for (int i = 1; i < currentMonth; i++) {
			numberOfDays += getDaysInMonth(i);
		}

		/* Calculate the number of the day of the week. */
		int result = numberOfDays % DAYS_IN_WEEK + newYearWeekDay;

		if (result > DAYS_IN_WEEK) {
			result = result % DAYS_IN_WEEK;
		}
		
		return result;
	}


}
