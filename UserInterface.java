import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * ------------------------------------------------------------
 *  College Assignment: Calculator Application (User Interface)
 *  Author: Swastik Sharma
 *  Description:
 *      Provides a console-based user interface for interacting
 *      with the Calculator class. Demonstrates menu-driven
 *      programming, user input validation, and exception handling.
 * ------------------------------------------------------------
 */
public class UserInterface {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Calculator calculator = new Calculator();

    public static void main(String[] args) {
        mainMenu();
        scanner.close();
    }

    /** Displays the main menu and handles user input. */
    public static void mainMenu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n==============================");
            System.out.println("     Calculator Application    ");
            System.out.println("==============================");
            System.out.println("1. Add Numbers");
            System.out.println("2. Subtract Numbers");
            System.out.println("3. Multiply Numbers");
            System.out.println("4. Divide Numbers");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1 -> performAddition();
                    case 2 -> performSubtraction();
                    case 3 -> performMultiplication();
                    case 4 -> performDivision();
                    case 5 -> {
                        System.out.println("Thank you for using the calculator!");
                        exit = true;
                    }
                    default -> System.out.println("Invalid choice. Please select between 1 and 5.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.next(); // Clear invalid input
            }
        }
    }

    /** Handles addition using overloaded methods. */
    public static void performAddition() {
        System.out.print("Do you want to add (2) or (3) integers, or (d) for double values? ");
        try {
            String choice = scanner.next();
            if (choice.equalsIgnoreCase("2")) {
                System.out.print("Enter first integer: ");
                int a = scanner.nextInt();
                System.out.print("Enter second integer: ");
                int b = scanner.nextInt();
                System.out.println("Result: " + calculator.add(a, b));
            } else if (choice.equalsIgnoreCase("3")) {
                System.out.print("Enter first integer: ");
                int a = scanner.nextInt();
                System.out.print("Enter second integer: ");
                int b = scanner.nextInt();
                System.out.print("Enter third integer: ");
                int c = scanner.nextInt();
                System.out.println("Result: " + calculator.add(a, b, c));
            } else if (choice.equalsIgnoreCase("d")) {
                System.out.print("Enter first double: ");
                double a = scanner.nextDouble();
                System.out.print("Enter second double: ");
                double b = scanner.nextDouble();
                System.out.println("Result: " + calculator.add(a, b));
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter numbers only.");
            scanner.next();
        }
    }

    /** Performs subtraction. */
    public static void performSubtraction() {
        try {
            System.out.print("Enter first integer: ");
            int a = scanner.nextInt();
            System.out.print("Enter second integer: ");
            int b = scanner.nextInt();
            System.out.println("Result: " + calculator.subtract(a, b));
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter integers only.");
            scanner.next();
        }
    }

    /** Performs multiplication. */
    public static void performMultiplication() {
        try {
            System.out.print("Enter first double: ");
            double a = scanner.nextDouble();
            System.out.print("Enter second double: ");
            double b = scanner.nextDouble();
            System.out.println("Result: " + calculator.multiply(a, b));
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter numbers only.");
            scanner.next();
        }
    }

    /** Performs division with divide-by-zero handling. */
    public static void performDivision() {
        try {
            System.out.print("Enter the dividend (integer): ");
            int a = scanner.nextInt();
            System.out.print("Enter the divisor (integer): ");
            int b = scanner.nextInt();
            double result = calculator.divide(a, b);
            System.out.println("Result: " + result);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter integers only.");
            scanner.next();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
