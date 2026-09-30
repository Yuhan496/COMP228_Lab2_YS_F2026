package com.ys.lab2;

import java.math.BigDecimal;
import java.util.Scanner;

public class MainDriver {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Create array for 5 Interest objects
        Interest[] interests = new Interest[5];

        // Create 5 objects
        for (int i = 0; i < interests.length; i++) {

            System.out.println("\nObject " + (i + 1));

            BigDecimal principal =
                    ExceptionHandling.getDecimalInput(
                            scanner, "Enter principal: ");

            BigDecimal rate =
                    ExceptionHandling.getDecimalInput(
                            scanner, "Enter interest rate: ");

            int time =
                    ExceptionHandling.getTimeInput(
                            scanner, "Enter time in years: ");

            interests[i] = new Interest(principal, rate, time);

            // BigDecimal calculations
            BigDecimal simpleInterest =
                    interests[i].calculateSimpleInterest(
                            principal, rate, time);

            BigDecimal compoundInterest =
                    interests[i].calculateCompoundInterest(
                            principal, rate, time);

            // Double calculations to demonstrate method overloading
            Double simpleInterestDouble =
                    interests[i].calculateSimpleInterest(
                            principal.doubleValue(),
                            rate.doubleValue(),
                            time);

            Double compoundInterestDouble =
                    interests[i].calculateCompoundInterest(
                            principal.doubleValue(),
                            rate.doubleValue(),
                            time);

            System.out.println("Simple Interest (BigDecimal): "
                    + simpleInterest);

            System.out.println("Compound Interest (BigDecimal): "
                    + compoundInterest);

            System.out.println("Simple Interest (Double): "
                    + simpleInterestDouble);

            System.out.println("Compound Interest (Double): "
                    + compoundInterestDouble);
        }

        scanner.close();
    }
}