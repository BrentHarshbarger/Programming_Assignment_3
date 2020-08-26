import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Scanner;

public class NearestNeighbor {

	public static void main(String[] args) throws IOException {
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
		 * The program breaks up the test and training attributes into their own 2D array
		 * The program also stores each test and training class into their on 1D array
		 *  
		 * 
		 * 
		 -------------------------------------------------------------------------------------------------------------*/

		// Print assignment information
		System.out.println("Programming Fundamentals");
		System.out.println("NAME: Brent Harshbarger");
		System.out.println("PROGRAMMING ASSIGNMENT 3");
		System.out.println();

		String[][] trainingTable = new String[75][5];
		String[][] testingTable = new String[75][5];

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

		// Reading data from training file
		BufferedReader reader = new BufferedReader(new FileReader(trainPath));

		int tRow = 0;
		int tColumn = 0;
		// While reads rows and for statement reads columns
		while ((train = reader.readLine()) != null) {
			String[] row = train.split(",");
			tColumn = 0;

			// Test for data import is as expected
			for (String cell : row) {
				trainingTable[tRow][tColumn] = cell;
				tColumn++;

				System.out.printf("%-6s", cell);

			}
			tRow++;

			System.out.println("");

		}

		BufferedReader reader2 = new BufferedReader(new FileReader(testPath));

		int testRow = 0;
		int testColumn = 0;

		while ((test = reader2.readLine()) != null) {
			String[] row = test.split(",");
			testColumn = 0;
			// Test for data import is as expected
			for (String cell : row) {
				testingTable[testRow][testColumn] = cell;
				tColumn++;

				System.out.printf("%-6s", cell);

			}
			testRow++;

			System.out.println("");

		}

		reader.close();
		reader2.close();

	}

	public double void arrayFeeder(String testingTable[][], String trainingTable[][]) {
		
		int count = 0;
		while (count < 75) {
			
			for(int x =0; x < 75; x++) {
				testingTable[][] //iterate row of testing table
						for (int y = 0; y<5; y++) { //iterate columns
														
							sltest = column[0];
							swtest = column[1];
							pltest = column[2];
							pwtest = column[3];
							
						}
			}
			for(int x =0; x < 75; x++) {
				trainingTable[][] //iterate row of training table
						for (int y = 0; y<5; y++) { //iterate columns
														
							sltrain = column[0];
							swtrain = column[1];
							pltrain = column[2];
							pwtrain = column[3];
							
		
			
		}
		
				count++;
				distanceCalc(sltest, swtest, pltest, pwtest, sltrain, swtrain, pltrain, pwtrain);
	}

	// This method takes takes in the test data and the training data and determines
	// the distance
	// between the training and test data. This smaller the distance the closer the
	// match.
	public static double distanceCalc(double sltest, double swtest, double pltest, double pwtest, double sltrain,
			double swtrain, double pltrain, double pwtrain) {

		double slength = sltest - sltrain;
		slength = slength * slength;

		double swidth = swtest - swtrain;
		swidth = swidth * swidth;

		double plength = pltest - pltrain;
		plength = plength * plength;

		double pwidth = pwtest - pwtrain;
		pwidth = pwidth * pwidth;

		double dist = Math.sqrt(slength + swidth + plength + pwidth);

		return dist;
	}

	// This method takes the total number that are correct match divided
	// by the total tested
	public static double accuracy(double correct, double totaltest) {

		double acc = correct / totaltest;

		return acc;
	}

	public class IrisSetosa {

	}

	public class IrisVericolour {

	}

	public class IrisVirginica {

	}

}
