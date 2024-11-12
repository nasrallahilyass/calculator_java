package com.exemple.java;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        displayWelcomeMessage();
        Scanner sc = new Scanner(System.in);

        double num1 = getNumberInput(sc, "Please enter the first number: ");

        String operation = getOperationInput(sc);

        double num2 = getNumberInput(sc, "Please enter the second number: ");

        double result = calculateResult(num1, num2, operation);

        if(!Double.isNaN(result)) {
            System.out.println(formatEquation(num1, num2, operation) + result);
        }

    }

    public static void displayWelcomeMessage() {
        System.out.println("########################");
        System.out.println("Welcome To Calculator: ");
        System.out.println("########################");
    }

    public static double getNumberInput(Scanner sc, String prompt) {
        System.out.print(prompt);
        return sc.nextDouble();
    }

    public static String getOperationInput(Scanner sc) {
        System.out.println("Operation should be only: +, -, *, /");
        System.out.print("Choose the operation: ");
        return sc.next();
    }

    public static double calculateResult(double num1, double num2, String operation) {
        return switch (operation) {
            case "+" -> Sum(num1, num2);
            case "-" -> Sub(num1, num2);
            case "*" -> Mul(num1, num2);
            case "/" -> Div(num1, num2);
            default -> {
                System.out.println("Invalid operation");
                yield Double.NaN;
            }
        };
    }

    public static double Sum(double a, double b) {
        return a + b;
    }

    public static double Sub(double a, double b) {
        return a - b;
    }

    public static double Mul(double a, double b) {
        return a * b;
    }

    public static double Div(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Division by zero is not allowed.");
            return Double.NaN;
        }
        return a / b;
    }

    public static String formatEquation(double num1, double num2, String operation) {
        return (num1 + " " + operation + " " + num2 + " " + " = ");
    }
}