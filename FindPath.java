package testAssignment;

import java.util.*;

/**
 * The class provides the solution of the task #2: 
 * 		Find the paths of minimum cost between pairs of cities 
 **/
public class FindPath {

	/* Variable numberOfCities contains the number of cities. */
	private static int numberOfCities;
	
	/* Matrix costs[][] contains transportation costs. */
	private static int[][] costs;
	
	/* Variable maxValue contains the biggest number for the matrix costs */
	private static int maxValue = 1000;

	/* Array cityNames[] stores names of the cities. */
	private static String[] cityNames;
	
	/* Matrix sourceDestination[][] stores names of the cities [NAME1 - source, NAME2 - destination] */
	private static String[][] sourceDestination;

	/* Method getCityIndexByName() returns the city index by the city name */
	public static int getCityIndexByName(String name) {

		/* The index of the city. */
		int index = -1;
		
		for (int i = 0; i < numberOfCities; i++) {
			
			/* If the given name is equal to one of the names in the array cityNames[],
			 * save its index. */
			if (cityNames[i].equals(name)) {
				index = i;
			}
		}
		
		return index;
	}

	/* Method findMinPath() returns the minimum cost of the path between 2 cities.
	 * from - source city index, to - destination city index. */
	public static int findMinPath(int from, int to) {

		/* The minimum cost past between cities.*/
		int result = -1;

		for (int i = 0; i < numberOfCities; i++) {
			for (int j = 0; j < numberOfCities; j++) {
				if ((i == from) && (j == to)) {
					result = costs[i][j];
				}
			}
		}

		return result;
	}
	
	/* Method floydWarshall() finds the minimum cost path between all cities in the matrix costs[][]. */
	public static void floydWarshall() {

		for (int k = 0; k < numberOfCities; k++) {
			for (int i = 0; i < numberOfCities; i++) {
				for (int j = 0; j < numberOfCities; j++) {
					if (costs[i][j] != 0) {
						if (costs[i][j] < costs[i][k] + costs[k][j]) {
							costs[i][j] = costs[i][j];
						} else {
							costs[i][j] = costs[i][k] + costs[k][j];
						}
					}

				}
			}
		}

	}

	/* Method fillCostsMatrix() fills the matrix costs[][] with data from cityIndexCost array. */
	public static void fillCostsMatrix(int sourceCityIndex, int[][] cityIndexCost, int numberOfNeighbours) {

		for (int i = 0; i < numberOfCities; i++) {
			for (int j = 0; j < numberOfCities; j++) {
				for (int k = 0; k < numberOfNeighbours; k++) {
					if (i == sourceCityIndex) {
						if (j == cityIndexCost[k][0] - 1)
							costs[i][j] = cityIndexCost[k][1];
					}
				}
			}
		}
	}

	/* Method createEmptyMatrix() creates matrix costs[][] and fills it with maxValues and zeros diagonally. */
	public static void createEmptyMatrix() {
		
		/* Create matrix costs[][]. */
		costs = new int[numberOfCities][numberOfCities];

		for (int i = 0; i < numberOfCities; i++) {
			for (int j = 0; j < numberOfCities; j++) {
				if (i != j) {
					costs[i][j] = maxValue;								// maxValues
				} else {
					costs[i][j] = 0;									// zeros diagonally
				}
			}
		}

	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		/* Read number of tests from console. */
		int numberOfTests;
		numberOfTests = in.nextInt();

		/* Read data from console for each test. */
		for (int testIndex = 0; testIndex < numberOfTests; testIndex++) {

			/* Read number of cities form console. */
			numberOfCities = in.nextInt();

			/* Create matrix to contain transportation costs. */
			createEmptyMatrix();

			/* Array cityNames contains the names of the cities. */
			cityNames = new String[numberOfCities];

			/* Number of neighbours. */
			int numberOfNeighbours;

			/* Read data for each city. */
			for (int i = 0; i < numberOfCities; i++) {

				/* Read city name from console. */
				cityNames[i] = in.next();

				/* Read number of neighbours from console. */
				numberOfNeighbours = in.nextInt();

				/*
				 * Matrix cityIndexCost contains index of a city connected to
				 * current city and the transportation cost.
				 */
				int[][] cityIndexCost = new int[numberOfNeighbours][2];
				
				for (int j = 0; j < numberOfNeighbours; j++) {
					for (int k = 0; k < 2; k++) {
						cityIndexCost[j][k] = in.nextInt();				// Read city index and cost
					}
				}

				/* Fill the matrix costs[][] with data from cityIndexCost array. */
				fillCostsMatrix(i, cityIndexCost, numberOfNeighbours);
			}

			/* Read number of paths to find. */
			int numberOfPathsToFind;
			numberOfPathsToFind = in.nextInt();

			/* Matrix sourceDestination stores names of the cities [NAME1 - source, NAME2 - destination]. */
			sourceDestination = new String[numberOfPathsToFind][2];

			for (int i = 0; i < numberOfPathsToFind; i++) {
				for (int j = 0; j < 2; j++) {
					sourceDestination[i][j] = in.next();				// Read city source and destination 
				}
			}

			/* Method floydWarshall() calculates minimum distances between cities. */
			floydWarshall();

			System.out.println();										// Empty line

			int src;													// Source city index
			int dest; 													// Destination city index
			int result;													// The cost of the minimum path
			
			for (int i = 0; i < numberOfPathsToFind; i++) {
				
				/* Find city index by the city name. */
				src = getCityIndexByName(sourceDestination[i][0]);
				dest = getCityIndexByName(sourceDestination[i][1]);
				
				/* Find the cost of the minimum path. */
				result = findMinPath(src, dest);

				/* Print result. */
				System.out.println("min path = " + result);
			}

		}

		in.close();
	}

}
