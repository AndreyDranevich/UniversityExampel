package com.university;

//Лабораторная работа 3.
//
//        Реализовать генератор чисел Фибоначчи:
//        Пользователь вводит x0, x1 и N кол-во чисел. Числа записать в массив, размерностью N.
//

import java.io.*;

/**
 * Created by Andrey on 19.09.2016.
 */

public class Fibonachi {
    private static int first;
    private static int second;
    private static int count;

    private static void fibonachi(double[] ma, int one, int two, int count) {
        ma[0] = one;
        ma[1] = two;
        for (int i = 2; i < count; i++)
            ma[i] = ma[i - 1] + ma[i - 2];
    }

    private static void print(double[] ma) {
        for (int i = 0; i < ma.length; i++) {
            System.out.print(ma[i] + " ");
        }
    }

    private static void read() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            print("Enter Xo");
            String sFirst = bufferedReader.readLine();
            first = Integer.parseInt(sFirst);

            print("Enter X1");
            String sSecond = bufferedReader.readLine();
            second = Integer.parseInt(sSecond);

            boolean a = true;
            do {
                print("Enter N");
                String sCount = bufferedReader.readLine();
                count = Integer.parseInt(sCount);
                if (count > 1)
                    a = false;
            } while (a);


        } catch (Exception e) {
            System.exit(-1);
        }

    }

    private static void print(String message) {
        System.out.println(message);
    }

    public static void main(String[] args) throws IOException {
        read();
        double[] numOfFibonachi = new double[count];
        fibonachi(numOfFibonachi, first, second, count);
        print(numOfFibonachi);
    }
}
