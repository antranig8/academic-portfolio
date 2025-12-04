/*
 * Class: CMSC203 CRN: 40438
 * Instructor: Dr. Grinberg
 * Description: First project for a randomized ESP guesser.
 * Due: 06/16/25
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Antranig Tatarian
*/
package ESPGame;

import java.util.Random;
import java.util.Scanner;
import java.io.*;

public class ESPGame 
{
	public static void main(String[] args) throws IOException
	{
		// Create Randomizer
		Random randomizer = new Random();
		// Create Keyboard Scanner
		Scanner keyboard = new Scanner(System.in);
		// Create output file
		PrintWriter outputFile = new PrintWriter("EspGameResults.txt");
		// Variables
		String restartOption = null;
		String fileName;
		final int ROUNDS = 3;
		int colorLimit = 0;
		int numCorrect = 0;
		// do-while loop for the game
		do {
			// Greeting and getting information
			System.out.println("Welcome to the ESP Game!");
			
			System.out.println("Please Enter your full name: ");
			String name = keyboard.nextLine();
			
			System.out.println("Please Enter your user name: ");
			String username = keyboard.nextLine();
			
			System.out.println("Describe yourself: ");
			String description = keyboard.nextLine();
			
			System.out.println("Enter due date: ");
			String dueDate = keyboard.nextLine();
			
			System.out.println("Enter current date: ");
			String currentDate = keyboard.nextLine();
				
			System.out.println("Lets get started!");
			// Choices
			System.out.println("Please Choose one of the following options:");
			System.out.println("1: Display First 16 Colors");
			System.out.println("2: Display First 10 Colors");
			System.out.println("3: Display First 5 Colors");
			System.out.println("4: Exit the program\n");
			// Ask for choice
			System.out.print("Enter choice: ");
			int choice = keyboard.nextInt();
			//clear whatever was typed
			keyboard.nextLine();
			// Switch for the options
			switch(choice) 
			{
			case 1:
				colorLimit = 16;
				break;
			case 2:
				colorLimit = 10;
				break;
			case 3:
				colorLimit = 5;
				break;
			case 4:
				System.out.println("Thank you for playing!");
				keyboard.close();
				outputFile.close();
				break;
				// input validator
			default:
				System.out.println("Invalid choice, please try again.");
				continue;
			}
			
			// After choice was made
			System.out.println("Please enter the file name (colors.txt): ");
			fileName = keyboard.nextLine();
			// open file create scanner
			File inputFile = new File(fileName);
			Scanner InputfileScanner = new Scanner(inputFile);
			System.out.println("\n\nThese are the colors you can choose from.");
			int count = 0;
			while (InputfileScanner.hasNextLine() && count < colorLimit)
			{
				count++;
				System.out.println(count+": "+InputfileScanner.nextLine());
			}
			// Close input file to reset the reading point
			InputfileScanner.close();
			// Start the guessing game
			for (int round = 1; round <= ROUNDS; round++)
			{
				// Randomized pick
				int randomColor = randomizer.nextInt(colorLimit) + 1;
				// Re open the input file to pick a random color
				Scanner colorPicker = new Scanner(inputFile);
				String selectedColor = " ";
				int currentLine = 1;
				// While loop to go through each line and find color
				while (colorPicker.hasNextLine()) 
				  {
	                    String pickedColor = colorPicker.nextLine();
	                    if (currentLine == randomColor) 
	                    {
	                        selectedColor = pickedColor;
	                        break;
	                    }
	                    currentLine++;
	                }
				// close the color selector
				colorPicker.close();
				// Guessing text
				System.out.println("\t Round " + round);
				System.out.println("I'm thinking of a color from the list above");
				System.out.println("Which color is it?");
				System.out.print("Guess (color name): ");
				String guess = keyboard.nextLine();
				System.out.println("I was thinkig of "+selectedColor);
				// Check if guess was correct
				if (guess.equalsIgnoreCase(selectedColor))
					numCorrect++;
			}
			// Once rounds are finished
			outputFile.println("Game Over");
			outputFile.println("You guessed "+numCorrect+" out of 3 colors correctly.");
			// all gathered info
			outputFile.println("Name:"+name);
			outputFile.println("Username:"+username);
			outputFile.println("Description:"+description);
			outputFile.println("Due Date:"+dueDate);
			outputFile.println("Current Date:"+currentDate);	
			//Show user the options to play again
			System.out.println("Would you like to play again?");
			System.out.println("Please enter either (yes/no): ");
			restartOption = keyboard.nextLine();
			
		} while (restartOption.equalsIgnoreCase("yes"));
		System.out.println("Thanks for playing!");
		
		// Close output file
		outputFile.close();
	}

}
