import java.util.Scanner;
import java.util.Random;
public class NumberGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int score = 0;
        int round = 1;   
        char playAgain;

        do {
            if (round == 1) {
                System.out.println("Welcome to the Number Guessing Game!");
            } else {
                System.out.println("New Round Started");
            }

            int randomNumber = rand.nextInt(100) + 1;
            int attempts = 5;
            boolean guessedCorrectly = false;

            System.out.println("Guess the number between 1 and 100");
            System.out.println("You have only " + attempts + " attempts!");

            while (attempts > 0) {

                System.out.print("Enter your guess: ");
                int guess = sc.nextInt();

                if (guess == randomNumber) {
                    System.out.println("Correct! You guessed the number!");
                    guessedCorrectly = true;
                    score++;
                    break;
                } 
                else if (guess > randomNumber) {
                    System.out.println("Too high! Try again.");
                } 
                else {
                    System.out.println("Too low! Try again.");
                }

                attempts--;
                System.out.println("Attempts left: " + attempts);
            }

            if (!guessedCorrectly) {
                System.out.println("You lost this round!");
                System.out.println("The correct number was: " + randomNumber);
            }

            System.out.println("Your current score: " + score);

            System.out.print("Do you want to play again? (y/n): ");
            playAgain = sc.next().charAt(0);

            round++; 

        } while (playAgain == 'y' || playAgain == 'Y');

        System.out.println("Final Score: " + score);
        System.out.println("Thanks for playing!");

        sc.close();
    }
}