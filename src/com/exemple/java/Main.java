package com.exemple.java;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        welcome();
        try (Scanner scanner = new Scanner(System.in)) { // Ensure Scanner is closed automatically
            while (true) {
                printMenu();
                int choice = getUserChoice(scanner);

                if (choice == 5) {
                    System.out.println("\nThank you for using the Calculator. Goodbye!");
                    break;
                }

                if (choice < 1 || choice > 5) {
                    System.out.println("❌ Invalid option! Please select a valid choice.");
                    continue;
                }

                double num1 = getNumber(scanner, "Enter first number: ");
                double num2 = getNumber(scanner, "Enter second number: ");
                double result = performOperation(choice, num1, num2);

                if (!Double.isNaN(result)) {
                    System.out.println("The result is: " + result);
                }
            }
        }
    }

    private static void welcome() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("                Welcome To Calculator");
        System.out.println("=".repeat(50));
    }

    private static void printMenu() {
        System.out.println("\n");
        System.out.println("1. Add ");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");
        System.out.println("5. Exit");
        System.out.println("=".repeat(50));
    }

    private static int getUserChoice(Scanner scanner) {
        System.out.print("Choose an option: ");
        while (!scanner.hasNextInt()) { // Validate user input as integer
            System.out.println("❌ Invalid input! Please enter a number between 1 and 5.");
            scanner.next(); // Clear invalid input
            System.out.print("Choose an option: ");
        }
        return scanner.nextInt();
    }

    private static double getNumber(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                return scanner.nextDouble();
            } else {
                System.out.println("❌ Invalid input! Please enter a valid number.");
                scanner.next(); // Clear invalid input
            }
        }
    }

    private static double performOperation(int choice, double num1, double num2) {
        return switch (choice) {
            case 1 -> add(num1, num2);
            case 2 -> subtract(num1, num2);
            case 3 -> multiply(num1, num2);
            case 4 -> divide(num1, num2);
            default -> Double.NaN; // This should never happen due to earlier validation
        };
    }

    // Calculator operations
    private static double add(double a, double b) {
        return a + b;
    }

    private static double subtract(double a, double b) {
        return a - b;
    }

    private static double multiply(double a, double b) {
        return a * b;
    }

    private static double divide(double a, double b) {
        if (b == 0) {
            System.out.println("❌ Error: Division by zero is not allowed!");
            return Double.NaN;
        }
        return a / b;
    }
}
