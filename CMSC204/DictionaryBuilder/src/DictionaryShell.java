/**
 * Command line integration for DictionaryBuilder
 */
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class DictionaryShell {
	public static void main(String[] args) {
		// setup dictionary
		DictionaryBuilder dictionary = null;
		// check if any file was provided
			if(args.length == 0) {
				System.out.println("No command-line-arguments provided.");
				// in case of no arguments provided initilaize an empty directory
				dictionary = new DictionaryBuilder(1);
			}
			else {
				System.out.println("command-line-arguments: ");
				for(int index = 0; index < args.length; index++) {
					System.out.println("args["+index+"]: -"+args[index]);
				}
				// try to load a file from the argument provided
				try {
					dictionary = new DictionaryBuilder(args[0]);
					// if not found print excpetion
				} catch(FileNotFoundException e) {
					System.out.println("File not found: "+ args[0]);
					System.out.println("Starting with empty dictionary.");
					dictionary = new DictionaryBuilder(1);
				}
			}
		// Start of the program
		System.out.println("\nWelcome to the Dictionary Builder Command Line Interface.");
		System.out.println("Available commands: add <word>, delete <word>, search <word>, list, stats, exit");
		// create a scanner 
		try(Scanner input = new Scanner(System.in)){
		// start getting input
		while(true) {
			System.out.print("> ");
			// if input doesnt have another line stop the program
			if(!input.hasNextLine()) {
				break;
			}
			// otherwise take next line and trim it
			String line = input.nextLine().trim();
			// if the line was empty it'll just continue to ask for input
			if(line.isEmpty()) {
				continue;
			}
			System.out.println();
			// seperate command and arg
			String command;
			String arg = null;
			// start parsing 
			int spaceIndex = line.indexOf(' ');
			// if no space found then its only a command
			if(spaceIndex == -1) {
				command = line.toLowerCase();
			} 
			// if there was a space get the command and argument
			else {
				command = line.substring(0, spaceIndex).toLowerCase();
				arg = line.substring(spaceIndex+1).trim();			
				}
			// create a switch for all the commands
			switch(command) {
				// if command was add
				case "add":
					// for null or empty argument
					if(arg == null || arg.isEmpty()) {
						System.out.println("Incorrect Usage: add <word>");
						break;
					}
					// otherwise run command
					dictionary.addWord(arg);
					System.out.println("\""+arg+"\" was added to the dictionary.");
					break;
				// if command was delete
				case "delete":
					// for null or empty argument
					if(arg == null || arg.isEmpty()) {
						System.out.println("Incorrect Usage: delete <word>");
						break;
					}
					// otherwise run command
					try {
						dictionary.removeWord(arg);
						System.out.println("\""+arg+"\" was deleted from the dictionary.");
					} catch(DictionaryEntryNotFoundException e) {
						System.out.println("\""+arg+"\" was not found");
					}
					break;
				// if command was search
				case "search":
					// for null or empty argument
					if(arg == null || arg.isEmpty()) {
						System.out.println("Incorrect Usage: search <word>");
						break;
					}
					// otherwise run command
					int frequency = dictionary.getFrequency(arg);
					if(frequency > 0) {
						System.out.println("\""+arg+"\" found with frequency: "+frequency);
					} else {
						System.out.println("\""+arg+"\" was not found");
					}
					break;
				// if command was list
				case "list":
					List<String> words = dictionary.getAllWords();
					// check if dictionary is empty
					if(words.isEmpty()) {
						System.out.println("Dictionary is empty.");
					}
					else {
						for(String word : words) {
							System.out.println(word);
						}
					}
					break;
				// if command was stats
				case "stats":
					System.out.println("Total words: " + dictionary.getTotalWords());
					System.out.println("Total unique words: " + dictionary.getUniqueWords());
					// print with 2 decimals
					System.out.printf("Estimated load factor: %.2f%n", dictionary.estimatedLoadFactor());
					break;
				// if command was exit
				case "exit":
					System.out.println("Exiting the Dictionary Builder Command Line Interface...");
					input.close();
					return;
				// if it was none of the above commands
				default:
					System.out.println("Invalid command input.");
					System.out.println("Available commands: add <word>, delete <word>, search <word>, list, stats, exit");
				}
			}
			// if any unknown error occurs
			} catch(Exception e) {
			System.out.println("An unknown error occurred: " + e.getMessage());
		}
	}
}
