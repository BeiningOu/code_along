import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Game {
    static Scanner console = new Scanner(System.in);

    //        Rules of the Game
//        rock beats scissors
//        paper beats rock
//        scissors beats paper
    public static void main(String[] args) {
        boolean exit = false;
        do {
            int userMove = getUserChoice();
            int computerMove = computerChoice();
            String userChoice = generateMove(userMove);
            String computerChoice = generateMove(computerMove);
            determineWinner(computerChoice,userChoice);
            exit = playAgain();
        } while(!exit);


    } //end of the main method

    //refactor
    public static int getUserChoice() {
        boolean validChoice = false;
        int userChoice = -1;

        do {
            System.out.println("Please select your move [rock, paper or scissors]:");
            System.out.println("0.Rock");
            System.out.println("1.Paper");
            System.out.println("2.Scissors");
            String userInput = console.nextLine();

            //userChoice = Integer.parseInt(console.nextLine());
            if (userInput.equalsIgnoreCase("0") || userInput.equalsIgnoreCase("1") ||
                    userInput.equalsIgnoreCase("2")) {
                validChoice = true;
                userChoice = Integer.parseInt(userInput);
            } else {
                System.out.println("Error: invalid input");
            }
        } while (!validChoice);
        return userChoice;
    }

    //grab teh computer choice
    public static int computerChoice() {
        int random = (int) Math.floor(Math.random() * 3);
        return random;
    }

    //generate a move
    public static String generateMove(int playerChoice) {
        String move;

        switch (playerChoice) {
            case 0:
                move = "rock";
                break;
            case 1:
                move = "paper";
                break;
            case 2:
                move = "scissors";
                break;
            default:
                move = null;
                break;
        }
        return move;
    }
    //determine a winner


    public static void determineWinner(String userOneChoice, String userTwoChoice) {
        String graphic = "L O A D I N G";

        for (int i = 0; i < graphic.length(); i++) {
            System.out.println(graphic.charAt(i));
        }

        if (userOneChoice.equalsIgnoreCase(userTwoChoice)) {
            System.out.printf("You both picked %s， it's a tie!%n",
                    userOneChoice);
        } else if (userOneChoice.equalsIgnoreCase("rock") && userTwoChoice.equalsIgnoreCase("paper")) {
            System.out.printf("The computer picked %s and you picked %s - you win! %n", userOneChoice, userTwoChoice);
        } else if (userOneChoice.equalsIgnoreCase("paper") && userTwoChoice.equalsIgnoreCase("scissors")) {
            System.out.printf("The computer picked %s and you picked %s - you win! %n", userOneChoice, userTwoChoice);
        } else if (userOneChoice.equalsIgnoreCase("scissors") && userTwoChoice.equalsIgnoreCase("rock")) {
            System.out.printf("The computer picked %s and you picked %s - you win! %n", userOneChoice, userTwoChoice);
        } else {
            System.out.printf("The computer picked %s and you picked %s - Computer win! %n", userOneChoice, userTwoChoice);
        }

    }


    // play again

    public static boolean playAgain() {
        System.out.println("One more game?[y/n]:");
        String playAgain = console.nextLine();
        if (playAgain.equalsIgnoreCase("n")) {
            System.out.println("Thanks for playing, bye!");
            return true;
        } else {
            return false;
        }
    }
}
