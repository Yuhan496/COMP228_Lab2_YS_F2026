package com.ys.lab2;

import java.math.BigDecimal;
import java.util.Scanner;

public class ExceptionHandling {

    public static BigDecimal getDecimalInput(Scanner scanner, String message) {

        while (true) {

            System.out.print(message);
            String input = scanner.nextLine();

            try {

                // Principal and rate must contain a decimal point
                if (!input.contains(".")) {
                    System.out.println("Please enter a decimal value.");
                    continue;
                }

                BigDecimal value = new BigDecimal(input);

                // Do not allow negative values
                if (value.compareTo(BigDecimal.ZERO) < 0) {
                    System.out.println("Negative values are not allowed.");
                    continue;
                }

                return value;

            } catch (NumberFormatException e) {

                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    public static int getTimeInput(Scanner scanner, String message) {

        while (true) {

            System.out.print(message);
            String input = scanner.nextLine();

            try {

                int time = Integer.parseInt(input);

                if (time < 0) {
                    System.out.println("Negative values are not allowed.");
                    continue;
                }

                return time;

            } catch (NumberFormatException e) {

                System.out.println("Invalid input. Please enter an integer.");
            }
        }
    }
}