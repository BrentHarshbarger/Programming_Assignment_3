import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Scanner;


public class NearestNeighbor {

	/*-----------------------------------------------------------------------------------------------------------
	/ Brent Harshbarger
	/ August 16, 2020
	/ Programming Fundamentals
	/ Summer 2020
	/ Programming Assignment 3 (Machine Learning)
	/ 
	-------------------------------------------------------------------------------------------------------------*/

	/*------------------------------------------------------------------------------------------------------------
	 * This is a simple machine learning program that uses the Nearest Neighbor algorithm. 
	 * There are two data sets. One training and one testing. 
	 * The final goal is to determine the accuracy of the prediction between training and test data
	 -------------------------------------------------------------------------------------------------------------*/

	public static void main(String[] args) throws NumberFormatException, IOException {

		// Print assignment information
		System.out.println("Programming Fundamentals");
		System.out.println("NAME: Brent Harshbarger");
		System.out.println("PROGRAMMING ASSIGNMENT 3");
		System.out.println();

		String trainPath = "iris-training-data.csv";
		String testPath = "iris-testing-data.csv";

		String test = "";
		String train = "";
		String userInput = "";

		// Ask user for to enter file names for the training and test
		Scanner scan = new Scanner(System.in);

		// Asking for the training file name and assigning it to String variable train
		System.out.print("Enter the name of the training file: ");
		userInput = scan.nextLine();

		System.out.print("Enter the name of the training file: ");
		userInput = scan.nextLine();

		scan.close();

		System.out.println("EX#: \t TRUE LABEL, \t PREDICITED LABEL ");

		// Create arrays for data
		double sepals[][] = new double[75][2];
		double petals[][] = new double[75][2];
		String className[] = new String[75];

		// Get the training data from the file
		BufferedReader reader = new BufferedReader(new FileReader(trainPath));

		// Declare variable s for parsing the array
		String line;
		int ndx = 0;

		// Parsing and processing the arrays
		while (null != (line = reader.readLine())) {
			String[] ar = line.split(",");

			sepals[ndx][0] = Double.parseDouble(ar[0]);
			sepals[ndx][1] = Double.parseDouble(ar[1]);

			petals[ndx][0] = Double.parseDouble(ar[2]);
			petals[ndx][1] = Double.parseDouble(ar[3]);

			className[ndx] = ar[4];

			++ndx;

		}

		// Declare counter variable
		int correct = 0;

		// Read in the testing file and parse the data
		BufferedReader testingReader = new BufferedReader(new FileReader(testPath));
		while (null != (line = testingReader.readLine())) {
			String[] ar = line.split(",");
			double sepalLength = Double.parseDouble(ar[0]);
			double sepalWidth = Double.parseDouble(ar[1]);
			double petalLength = Double.parseDouble(ar[2]);
			double petalWidth = Double.parseDouble(ar[3]);
			String testClassName = ar[4];

			// Pass data to the findNearest method
			int nearest = findNearest(sepalLength, sepalWidth, petalLength, petalWidth, sepals, petals);

			if (testClassName.equals(className[nearest])) {
				++correct;

			}
		}

		// Calculates the accuracy and prints it out
		double pct = (double) correct / 75.0;

		System.out.println("ACCURACY: " + pct * 100.0);

	}

	// Calculate the distance using the Euclidean distance formula
	private static double distanceCalc(double sltest, double swtest, double pltest, final double pwtest, double sltrain,
			double swtrain, double pltrain, double pwtrain) {

		double total = Math.pow((sltrain - sltest), 2) + Math.pow((swtrain - swtest), 2)
				+ Math.pow((pltrain - pltest), 2) + Math.pow((pwtrain - pwtest), 2);

		return Math.sqrt(total);
	}

	// Find the order of the nearest or closest distance
	private static int findNearest(double sepalLength, double sepalWidth, double petalLength, double petalWidth,
			double[][] sepals, double[][] petals) {

		double nearestDistance = Double.MAX_VALUE;
		int nearestIndex = -1;

		for (int i = 0; i < 75; ++i) {
			double distance = distanceCalc(sepalLength, sepalWidth, petalLength, petalWidth, sepals[i][0], sepals[i][1],
					petals[i][0], petals[i][1]);

			if (distance < nearestDistance) {
				nearestDistance = distance;
				nearestIndex = i;

			}
		}

		return nearestIndex;
	}
}
