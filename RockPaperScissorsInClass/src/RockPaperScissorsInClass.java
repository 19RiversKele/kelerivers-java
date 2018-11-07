/*
***************************************
* Kele Rivers                         *
* AP CS A                             *
* Period 1                            *
* November 7, 2018                    *
* Rock Paper Scissors lab             *
***************************************
*/


import java.util.Scanner;

public class RockPaperScissorsInClass {
//These variables are for the scoreboard, not final so they can be updated
    public static int WINS = 0;
    public static int TIES = 0;
    public static int LOSSES = 0;


    public static void main(String[] args) {
     //Sets up username
        Scanner userName = new Scanner(System.in);
        System.out.print("Enter a username: ");
        String playerID = userName.next();
        System.out.println("Welcome " + playerID);
     //Determines if you want to play a game in the first place
        System.out.println("Would you like to play a game? " + playerID + " Yes or no?");
        Scanner playGame = new Scanner(System.in);
        String playAGame = playGame.next();
        playAGame = playAGame.toLowerCase();

        while (playAGame.equals("yes")) {
         //Resets the scoreboard at the beginning of a game
            WINS = 0;
            TIES = 0;
            LOSSES = 0;
         //Sets number of rounds to determine a game
            System.out.println("How many rounds would you like to play? 3 or 5?");
            Scanner numberOfRounds = new Scanner(System.in);
            int numOfRounds = numberOfRounds.nextInt();
         //Runs each round for the game
            int roundNumber = 0;
            while (roundNumber < numOfRounds) {
             //Tells user what they picked
                String userWeapon = userChoice();
                System.out.println("User picked " + userWeapon);
             //Tells user what the computer picked
                String computerChoice = getComputerChoice();
                System.out.println("Computer picked " + computerChoice);
             //Compares choices and tells user who won
                String roundResult = (getResults(userWeapon, computerChoice));
                System.out.println(roundResult);
             //Round does not count if tie
                if (roundResult.equals("TIED GAME") || roundResult.equals("---ERROR DETERMINING WINNER---")) {
                    roundNumber--;
                }

             //New round
                roundNumber++;
            }
           //Scoreboard
            System.out.println("********************************");
            if (WINS > LOSSES) {
                System.out.println("USER HAS WON THE GAME!");
            } else {
                System.out.println("COMPUTER HAS WON THE GAME!");
            }
            System.out.println("Rounds won by user: " + WINS);
            System.out.println("Rounds won by computer: " + LOSSES);
            System.out.println("Rounds tied: " + TIES);
            System.out.println("********************************\n");
         //Asks user if they would like to play again, if yes sets up a new game
            System.out.println("Would you like to play again? Yes or no?");
            playAGame = playGame.next();
            playAGame = playAGame.toLowerCase();

        }

        System.out.println("Thank you for playing!");

    }
   //Prepares user choice
    public static String userChoice() {
        System.out.println("What do you choose? Rock, paper, or scissors?   :   ");
        Scanner cInput = new Scanner(System.in);
        String userWeapon = cInput.next();
        userWeapon = userWeapon.toLowerCase();
        return(userWeapon);
    }
   //Generates and prepares computerChoice
    public static String getComputerChoice() {
        double computerChoiceGenerator = Math.floor(Math.random() * 3);
        if (computerChoiceGenerator == 0.0) {
            String computerWeapon = "rock";
            return(computerWeapon);
        } else if (computerChoiceGenerator == 1.0) {
            String computerWeapon = "paper";
            return(computerWeapon);
        } else {
            String computerWeapon = "scissors";
            return(computerWeapon);
        }
    }

   //Compares userChoice and computerChoice to determine the winner
    public static String getResults(String userChoice, String computerChoice) {
        if (computerChoice.equals(userChoice)) {
            TIES++;
            return("TIED GAME");
        } else if (userChoice.equals("rock") && computerChoice.equals("paper")) {
            LOSSES++;
            return("COMPUTER WINS!");
        } else if (userChoice.equals("rock") && computerChoice.equals("scissors")) {
            WINS++;
            return("USER WINS!");
        } else if (userChoice.equals("paper") && computerChoice.equals("scissors")) {
            LOSSES++;
            return("COMPUTER WINS!");
        } else if (userChoice.equals("paper") && computerChoice.equals("rock")) {
            WINS++;
            return("USER WINS!");
        } else if (userChoice.equals("scissors") && computerChoice.equals("rock")) {
            LOSSES++;
            return("COMPUTER WINS!");
        } else if (userChoice.equals("scissors") && computerChoice.equals("paper")) {
            WINS++;
            return("USER WINS!");
        } else {
            return("---ERROR DETERMINING WINNER---");
        }
    }
}
