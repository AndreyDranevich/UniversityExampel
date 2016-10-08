package com.university;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.*;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Andrey on 17.09.2016.
 */

/*
Напишите программу, которая
считывает с клавиатуры три целых числа (пользователь может вводить  любое количество любых символов)
и выводит на экран(9 б. -  поддержка ввода чисел в двоичной системе):
их среднее арифметическое;
максимальное из введенных чисел;
минимальное их введенных чисел (K)
генерирует массив из не менее, чем 100 чисел, заполненных случайными целыми числами на интервале [0;K]
(K = результат полученный в пункте 1.с).
подсчитайте количество простых чисел и чисел, кратных 3;
отсортируйте массив (10 б.  - более 2 видов сортировки на выбор).

(+/.[0-9]/])

*/

public class Numbers {

    public static void read(String string, int[] numbers) {
        Pattern p = Pattern.compile("[0-9]+");
        Matcher m = p.matcher(string);
        int i = 0;
        String[] sNumbers = new String[3];

        try {
            while (m.find()) {
                sNumbers[i++] = m.group();
                if (i == 3)
                    continue;
            }
        } catch (Exception e) {
            System.out.println("");
        }

        try {
            numbers[0] = Integer.parseInt(sNumbers[0]);
            numbers[1] = Integer.parseInt(sNumbers[1]);
            numbers[2] = Integer.parseInt(sNumbers[2]);
        } catch (Exception e) {
            System.out.println("ERROR!");
            System.exit(-1);
        }
    }

    public static void print(String message) {
        System.out.println(message);
    }

    public static double average(int a, int b, int c) {
        return (a + b + c) / 3;
    }

    public static int max(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }

    public static int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

    public static void randMassive(int[] ma, int min, int massiveSize) {

        Random rnd = new Random(System.currentTimeMillis());
        int simpleCount = 0;
        int multiple3 = 0;
        int count = 0;

        for (int i = 0; i < massiveSize; i++) {
            ma[i] = rnd.nextInt(min + 1);
            if (ma[i] % 3 == 0)
                multiple3++;
            for (int k = 1; k < ma[i]; k++)
                if (ma[i] % k == 0)
                    count++;
            if (count <= 2)
                simpleCount++;
            count = 0;
        }

        System.out.println("Random massive:");
        for (int j = 1; j <= massiveSize; j++) {
            System.out.print(ma[j] + " ");
            if (j % 50 == 0)
                System.out.println();
        }

        System.out.println("Simple numbers: " + simpleCount);
        System.out.println("Numbers multiple 3: " + multiple3);


    }

    public static void bubbleSort(int[] ma) {
        for (int i = 0; i < ma.length; i++) {
            for (int j = 0; j < i; j++) {
                if (ma[i] < ma[j]) {
                    int temp = ma[i];
                    ma[i] = ma[j];
                    ma[j] = temp;
                }
            }

        }

    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int min_i = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    min_i = j;
                }
            }
            if (i != min_i) {
                int tmp = arr[i];
                arr[i] = arr[min_i];
                arr[min_i] = tmp;
            }
        }
    }

    public static void monitor(int[] ma, int count) {
        for (int j = 1; j <= count; j++) {
            System.out.print(ma[j] + " ");
            if (j % 50 == 0)
                System.out.println();
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Input three numbers:");
        String string = bufferedReader.readLine();
        int[] numbers = new int[3];

        read(string, numbers);
        print("Average: " + average(numbers[0], numbers[1], numbers[2]));
        print("Max: " + max(numbers[0], numbers[1], numbers[2]));
        print("Min: " + min(numbers[0], numbers[1], numbers[2]));

        int massiveSize = 100;
        int[] randMa = new int[massiveSize + 1];

        randMassive(randMa, min(numbers[0], numbers[1], numbers[2]), massiveSize);
        print("Sort massive:");
        bubbleSort(randMa);
        monitor(randMa, massiveSize);

    }
}
