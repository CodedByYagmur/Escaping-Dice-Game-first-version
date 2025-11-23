package demo2;
import java.util.Scanner;

class GuessTheDice {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int playAgain = 1;

        while (playAgain == 1) {

            System.out.println("You trapped... Guess that either you will escape or you will keep trapped.");
            System.out.println("*Rule: You escape only if the sum of the dice is > 8.*");
            System.out.println("Do you think you'll escape? (1 = Yes, 0 = No)");

            int guess = input.nextInt();

            int sum, dice1, dice2;

            // ---- CASE 1: USER THINKS THEY WILL ESCAPE ----
            if (guess == 1) {

                System.out.print("Guess at which attempt you'll escape (1-4): ");
                int attemptGuess = input.nextInt();

                int escapeAttempt = 0; 

                for (int Attempt = 1; Attempt <= 4; Attempt++) {

                    dice1 = (int)(Math.random() * 6) + 1;
                    dice2 = (int)(Math.random() * 6) + 1;
                    sum = dice1 + dice2;

                    System.out.printf("Attempt %d: rolled %d and %d. Sum = %d\n",
                                      Attempt, dice1, dice2, sum);

                    if (sum > 8) {
                        System.out.println("Sum is bigger than 8!");
                        escapeAttempt = Attempt;
                        break;
                    } 
                    else if (Attempt < 4) {
                        System.out.println("Still trapped...");
                    } 
                    else {
                        System.out.println("The sum was not bigger than 8.\nGAME OVER!!");
                    }
                }

                // Tahmin kontrolü
                if (escapeAttempt == attemptGuess && escapeAttempt != 0) {
                    System.out.println("YOU WIN!!! Your guess was correct!");
                } 
                else if (escapeAttempt != 0) {
                    System.out.println("You1r guess was wrong!");
                }
                else {
                    System.out.println("You LOST. TRY AGAIN!");
                }
            }

            // ---- CASE 2: USER THINKS THEY WILL NOT ESCAPE ----
            else if (guess == 0) {

                boolean escaped = false;

                for (int Attempt = 1; Attempt <= 4; Attempt++) {

                    dice1 = (int)(Math.random() * 6) + 1;
                    dice2 = (int)(Math.random() * 6) + 1;
                    sum = dice1 + dice2;

                    System.out.printf("Attempt %d: rolled %d and %d. Sum = %d\n",
                                      Attempt, dice1, dice2, sum);

                    if (sum > 8) {
                        System.out.println("Oh no! You escaped!");
                        escaped = true;
                        break;
                    } 
                    else if (Attempt < 4) {
                        System.out.println("Still trapped...");
                    }
                    else {
                        System.out.println("Still trapped... No escape!");
                    }
                }

                
                if (!escaped) {
                    System.out.println("Your guess was correct → YOU WIN!");
                } else {
                    System.out.println("Your guess was WRONG → YOU LOST!");
                }
            }

            // ---- ASK THE USER TO PLAY AGAIN? ----
            System.out.println("Do you want to play again? (1 = Yes, 0 = No)");
            playAgain = input.nextInt();

            System.out.println("-------------------------------------------------------");
        }

        System.out.println("Game closed. See you later :(");
    }
}


