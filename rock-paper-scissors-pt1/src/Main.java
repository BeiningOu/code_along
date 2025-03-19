import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    //        Rules of the Game
//        rock beats scissors
//        paper beats rock
//        scissors beats paper
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String userChoice;
        System.out.println("Please select your move [rock, paper or scissors]:");
        userChoice = console.nextLine();

        int random = (int) Math.floor(Math.random() * 3);
        String computerChoice = null;

        switch (random) {
            case 0:
                computerChoice = "rock";
                break;
            case 1:
                computerChoice = "paper";
                break;
            case 2:
                computerChoice = "scissors";
                break;
            default:
                break;

        }
        System.out.println(computerChoice);

        if (computerChoice.equalsIgnoreCase(userChoice)) {
            System.out.printf("You both picked %s， it's a tie!%n",
                    userChoice);
        } else if (computerChoice.equalsIgnoreCase("rock") && userChoice.equalsIgnoreCase("paper")) {
            System.out.printf("The computer picked %s and you picked %s - you win! %n", computerChoice, userChoice);
        } else if (computerChoice.equalsIgnoreCase("paper") && userChoice.equalsIgnoreCase("scissors")) {
            System.out.printf("The computer picked %s and you picked %s - you win! %n", computerChoice, userChoice);
        } else if (computerChoice.equalsIgnoreCase("scissors") && userChoice.equalsIgnoreCase("rock")) {
            System.out.printf("The computer picked %s and you picked %s - you win! %n", computerChoice, userChoice);
        } else {
            System.out.printf("The computer picked %s and you picked %s - Computer win! %n", computerChoice, userChoice);
        }


    }
}
