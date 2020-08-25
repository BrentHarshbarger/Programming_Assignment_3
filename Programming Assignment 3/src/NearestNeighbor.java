import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Scanner;
import java.util.Arrays;
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

		// Print assignment information
		System.out.println("Programming Fundamentals");
		System.out.println("NAME: Brent Harshbarger");
		System.out.println("PROGRAMMING ASSIGNMENT 3");
		System.out.println();

		String trainPath = "iris-training-data.csv";
	
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

		BufferedReader reader = new BufferedReader(new FileReader(trainPath));
		while ((train = reader.readLine()) != null) {
			String[] row = train.split(",");
			
			for(String index:row) {
				System.out.printf("%-6s",index);
			
		
			}
					
			System.out.println("");
		}
			
		
	
		}

		
		
	
	
}
