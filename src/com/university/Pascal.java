package com.university;

import java.io.*;

/**
 * Created by Andrey on 19.09.2016.
 */

//        Рассчитать треугольник Паскаля.
//        Треугольник Паскаля – бесконечная таблица биномиальных коэффициентов, имеющая треугольную форму.
//        В этом треугольнике на вершине и по бокам стоят единицы. Каждое число равно сумме
//        двух расположенных над ним чисел.
//        1
//        11
//        121
//        1331
//        14641


public class Pascal {
    private static int number;

    public static void triangleOfPascal(int count) {
        System.out.println("Pascal's triangle: ");
        for (int n = 0; n < count; n++) {
            int Cn = 1;
            System.out.print(Cn);
            for (int k = 1; k <= n; k++) {
                Cn *= (n - k + 1);
                Cn /= k;
                System.out.print(" ");
                System.out.print(Cn);
            }
            System.out.println();
        }
    }

    private static void read() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter N");
        try {
            String sNumber = bufferedReader.readLine();
            number = Integer.parseInt(sNumber);
        } catch (Exception e) {
            System.exit(-1);
        }
    }

    public static void main(String[] args) throws IOException {
        read();
        triangleOfPascal(number);
    }
}
