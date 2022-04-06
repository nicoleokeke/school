import java.util.Scanner;
import java.util.Random;

public class Game {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Welcome to Rock, Paper, and Scissors!\n");
            while (true) {

                System.out.print("Please choose R for Rock, P for Paper, or S for Scissors or quit:  ");
                String userChoice = sc.nextLine();

                if (userChoice.equals("quit")) {
                    break;
                }

                if (!userChoice.equals("R") && !userChoice.equals("P") && !userChoice.equals("S")
                        && !userChoice.equals("r") && !userChoice.equals("p") && !userChoice.equals("s")) {
                    System.out.println("That is not a valid move!");
                } else {

                    // Computer choice
                    Random rand = new Random();
                    int num = rand.nextInt(3);

                    String computerChoice = "";
                    if (num == 0) {
                        computerChoice = "R";
                    } else if (num == 1) {
                        computerChoice = "P";
                    } else if (num == 2) {
                        computerChoice = "S";
                    }

                    // Print the computer choice
                    if (computerChoice.equals("S")) {
                        System.out.println("The computer chose scissors.");
                    }

                    else if (computerChoice.equals("R")) {
                        System.out.println("The computer chose rock.");
                    }

                    else if (computerChoice.equals("P")) {
                        System.out.println("The computer chose paper.");
                    }

                    int userScore = 0;
                    int computerScore = 0;
                    // Determine a winner
                    if ((userChoice.equals("R") || userChoice.equals("r")) && computerChoice.equals("S")) {
                        System.out.println("The user won!");
                        userScore++;
                    }

                    else if ((userChoice.equals("P") || userChoice.equals("p")) && computerChoice.equals("R")) {
                        System.out.println("The user won!");
                        userScore++;
                    }

                    else if ((userChoice.equals("S") || userChoice.equals("s")) && computerChoice.equals("P")) {
                        System.out.println("The user won!");
                        userScore++;
                    }

                    else if ((userChoice.equals("S") || userChoice.equals("s")) && computerChoice.equals("R")) {
                        System.out.println("The computer won!");
                        computerScore++;
                    }

                    else if ((userChoice.equals("R") || userChoice.equals("r")) && computerChoice.equals("P")) {
                        System.out.println("The computer won!");
                        computerScore++;
                    }

                    else if ((userChoice.equals("P") || userChoice.equals("p")) && computerChoice.equals("S")) {
                        System.out.println("The computer won!");
                        computerScore++;
                    }

                    else if (userChoice.equals(computerChoice)) {
                        System.out.println("Tie!");
                    }
                    int totaluserScore = 0;
                    int totalcomputerScore = 0;
                    totaluserScore += userScore;
                    totalcomputerScore += computerScore;
                    System.out.println("The scores for this round are: \n" + "User: " + totaluserScore + "\n"
                            + "Computer" + totalcomputerScore + "\n");

                }

            }
        }

        System.out.println("Thank you for playing!");
    }
}
