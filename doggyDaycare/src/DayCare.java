import java.util.Scanner;

public class DayCare {
    /* Doggy Daycare
     * on start up we should be able to input the number of daycare spots available
     * we should be able to check a dog into our daycare
     * we should be able to check a dog out of our daycare
     * we should be able to view all dogs in our care
     * we should be able to exit our program
     */

    // Variables
    static Scanner console = new Scanner(System.in);
    static String[] daycareSpaces;
    static int capacity;

    // Main method
    public static void main(String[] args) {
        startUp();
        menu();
    }

    // Methods
    public static void startUp() {
        System.out.println("Welcome to the Doggy Daycare");
        System.out.println("Please Enter the number of spaces available for today: ");
        capacity = Integer.parseInt(console.nextLine());
        daycareSpaces = new String[capacity];
    }

    public static void menu() {
        boolean exit = false;
        do {
            System.out.println("What would you like to do?");
            System.out.println("1. Check a dog into daycare");
            System.out.println("2. Check a dog out of daycare");
            System.out.println("3. View all dogs in our care");
            System.out.println("4. Exit");
            System.out.print("Please enter your choice: ");
            int choice = Integer.parseInt(console.nextLine());

            switch (choice) {
                case 1:
                    checkInDog();
                    break;
                case 2:
                    checkOutDog();
                    break;
                case 3:
                    viewAllDogs();
                    break;
                case 4:
                    System.out.println("\nThank you for visiting the doggie daycare. Have a nice day!");
                    exit = true;
                    break;
                default:
                    System.out.println("That is not a valid choice, please try again.");
            }
        } while (!exit);
    }

    // Check in a dog
    public static void checkInDog() {
        System.out.print("\nWho is the good dog visiting us today?: ");
        String dogName = console.nextLine();
        for (int i = 0; i < daycareSpaces.length; i++) {
            if (daycareSpaces[i] == null) {
                daycareSpaces[i] = dogName;
                System.out.println("\n" + dogName + " has been checked in to the daycare!");
                return;
            }
        }
        System.out.println("\nSorry, there is no space available today. We are fully booked!");
    }

    // Check out a dog
    public static void checkOutDog() {
        System.out.print("\nWhat is the name of the dog you are picking up?: ");
        String dogName = console.nextLine();
        for (int i = 0; i < daycareSpaces.length; i++) {
            if (daycareSpaces[i] != null && daycareSpaces[i].equalsIgnoreCase(dogName)) {
                daycareSpaces[i] = null;
                System.out.println("\n" + dogName + " has successfully been picked up by its owner.");
                return;
            }
        }
        System.out.println("\nSorry, we can't find your dog. It doesn't seem to be checked into our daycare today.");
    }

    // View all dogs in our care
    public static void viewAllDogs() {
        System.out.println("\nCurrent Dogs in Our Care: ");
        for (int i = 0; i < daycareSpaces.length; i++) {
            if (daycareSpaces[i] != null) {
                System.out.println(daycareSpaces[i]);
            }
        }
    }
}