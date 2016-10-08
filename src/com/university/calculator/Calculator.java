package com.university.calculator;

import java.io.*;


/*
  Created by Andrey on 03.09.2016.
*/


public class Calculator {
    private static double Calculate(double first, double second, String operation) {

        switch (operation) {
            case "+":
                return (first + second);
            case "-":
                return (first - second);
            case "*":
                return (first * second);
            case "/": {
                if (second != 0)
                    return (first / second);
                else return -1;
            }
            case "%":
                return (first % second);
            case "log":
                return Math.log10(first);
            case "ln":
                return Math.log(first);
            case "abs":
                return Math.abs(first);
            case "^":
                return Math.pow(first, second);
            default:
                System.out.println("Unknown operation");
                return -1;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome");
        System.out.println("If you want calculate log, ln or abs, write random number in second operator");

        System.out.println("Enter the first number");
        String sFirst = bufferedReader.readLine();

        System.out.println("Enter the operation");
        String operation = bufferedReader.readLine();

        System.out.println("Enter the second number");
        String sSecond = bufferedReader.readLine();

        double first;
        double second;

        try {
            first = Double.parseDouble(sFirst);
            second = Double.parseDouble(sSecond);
        } catch (Exception e) {
            System.out.println("ERROR!");
            return;
        }
        System.out.println("Result: " + Calculate(first, second, operation));

    }


}
