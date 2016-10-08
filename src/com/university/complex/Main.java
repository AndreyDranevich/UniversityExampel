package com.university.complex;

/**
 * Created by Andrey on 07.10.2016.
 */
public class Main {
    public static void main(String[] args) {
        Complex a = new Complex(2, 0);
        Complex b = new Complex(3, 2);

        a.printAlg();
        b.printAlg();
        System.out.println("a+b");
        a.add(b);
        a.printAlg();
        a.printExp();
        a.printTrig();

        Complex c;
        System.out.println("a/b");
        c = a.div(a, b);
        c.printAlg();

    }
}
