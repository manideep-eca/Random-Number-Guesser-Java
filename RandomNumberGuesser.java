import java.util.Random;
import java.util.Scanner;

public class RandomNumberGuesser {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1;
        int upperBound = 100;
        int numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        int userGuess = 0;
        int attempts = 0;

        System.out.println("Welcome to the Random Number Guesser!");
        System.out.println("I'm thinking of a number between " + lowerBound + " and " + upperBound + ".");
        System.out.println("Can you guess what it is?");

        while (userGuess != numberToGuess) {
            System.out.print("Enter your guess: ");
            
            // Handle invalid input
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between " + lowerBound + " and " + upperBound + ".");
                scanner.next(); // clear invalid input
            }

            userGuess = scanner.nextInt();
            attempts++;

            if (userGuess < lowerBound || userGuess > upperBound) {
                System.out.println("Out of bounds! Please try again.");
            } else if (userGuess < numberToGuess) {
                System.out.println("Too low. Try again.");
            } else if (userGuess > numberToGuess) {
                System.out.println("Too high. Try again.");
            } else {
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
            }
        }

        scanner.close();
    }
}
