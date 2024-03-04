import java.util.Random;
import java.util.Scanner;

public class Ass02_Craps {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rnd = new Random();

        boolean continuePlaying = true;

        while (continuePlaying) {
            int die1 = rnd.nextInt(6) + 1;
            int die2 = rnd.nextInt(6) + 1;
            int crapsRoll = die1 + die2;

            System.out.println("Rolling the dice...");
            System.out.println("Die 1: " + die1);
            System.out.println("Die 2: " + die2);
            System.out.println("Sum: " + crapsRoll);

            if (crapsRoll == 2 || crapsRoll == 3 || crapsRoll == 12) {
                System.out.println("Craps! You lose!");
            } else if (crapsRoll == 7 || crapsRoll == 11) {
                System.out.println("Natural! You win!");
            } else {
                System.out.println("Point is set to: " + crapsRoll);
                System.out.println("Trying for point...");

                boolean continueRolling = true;
                while (continueRolling) {
                    int newDie1 = rnd.nextInt(6) + 1;
                    int newDie2 = rnd.nextInt(6) + 1;
                    int newRoll = newDie1 + newDie2;

                    System.out.println("Rolling the dice again...");
                    System.out.println("Die 1: " + newDie1);
                    System.out.println("Die 2: " + newDie2);
                    System.out.println("Sum: " + newRoll);

                    if (newRoll == crapsRoll) {
                        System.out.println("Made point! You win!");
                        continueRolling = false;
                    } else if (newRoll == 7) {
                        System.out.println("Got a seven! You lose!");
                        continueRolling = false;
                    } else {
                        System.out.println("Trying for point...");
                    }
                }
            }

            System.out.println("Do you want to play again? (yes/no)");
            String playAgain = scanner.nextLine().toLowerCase();
            if (!playAgain.equals("yes")) {
                continuePlaying = false;
            }
        }
    }
}
