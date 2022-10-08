/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: (Create a code that asks the user to guess a randomly generated integer that is between 1 and 100)
 * Due: 10/08/2022
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Duga Gang
*/

package rng;
import java.util.Random;
import java.util.Scanner;
public class RandomNumberGuesser {
	public static void main(String[] args) {
	System.out.println("This application generates a random integer between 1 and 100\n"
			+ "and asks the user to guess repeatedly until they guess correctly\n");
	String answer; // answer must be declared outside of the do while loop to be able to be used in the while condition
	do {
	int randInt = RNG.rand(); // generates the random integer and initializes it to randInt

	System.out.println("Enter your first guess: ");
	Scanner keyboard = new Scanner(System.in);
	int guess = keyboard.nextInt();
	boolean correct = false;
	int previousHigh = 100, previousLow = 1;
	
	
	while (!correct) { //use exclamation mark instead of correct == false
		 
		if (RNG.getCount() == 6) {
			System.out.println("You have exceeded maximum number of guesses. Try again");
			RNG.resetCount();
			keyboard.close();
			System.exit(0);
		}
		if (guess + 1 > randInt) {
			RNG.inputValidation(guess-1, previousLow, previousHigh);
			if(guess > previousLow && guess < previousHigh) {
			System.out.println("Your guess is too high");
			System.out.println("Number of guesses: " + RNG.getCount());
			previousHigh = guess;
			System.out.println("Enter your next guess between " +previousLow + " and " +previousHigh);
			}
			guess = keyboard.nextInt();
		}
		else if (guess + 1 < randInt) {
			RNG.inputValidation(guess+1, previousLow, previousHigh);
			if(guess + 1 > previousLow && guess + 1 < previousHigh) {
			System.out.println("Your guess is too low");
			System.out.println("Number of guesses: " + RNG.getCount());
			previousLow = guess;
			System.out.println("Enter your next guess between " +previousLow + " and " +previousHigh);
			}
			guess = keyboard.nextInt();
		}
		else {
			System.out.println("Congratulations, you guesssed correctly!");
			correct = true;
			RNG.resetCount();
		}
		
	  }
	System.out.println("Try again? (Yes or No)");
	answer = keyboard.next();
		
	} while(answer.equalsIgnoreCase("Yes"));
	
	System.out.println("Thank you for playing");
	System.out.println("Programmer name: Duga Gang");

  }
	
		
}

