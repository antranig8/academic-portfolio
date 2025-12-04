# ESP Game - CMSC 203 Project 1

This was the first project meant to help us get assimilated with Java. Its a simple commmand line game where the user tries to guess a randomly selected color from a list. It demonstrates simple file I/O, loops, conditionals, and basic user interaction.

## The Project structure

### src/
Contains the Java source code for the ESP Game.
### data/
Contains the input file required by the program (colors.txt)
### dist/ 
Contains the compiled version of the program in two forms:
- **ESPGameCL.jar** — the runnable JAR exported from Eclipse  
- **ESPGame.exe** — the Windows executable created using Launch4j  
Both require the 'colors.txt' to be in the same folder when run.
The game also generates a 'ESPGameResults.txt' file that has an output summary of everything input, and game results.
