package com.university.complex;

/**
 * Created by Andrey on 07.10.2016.
 */
public class Main {
    public static void main(String[] args) {
        Complex a = new Complex(2, 4);
        Complex b = new Complex(3, 2);
        a.printAlg();
        b.printAlg();
        a.div(b);
        a.printAlg();
        a.printExp();
        a.printTrig();

        Complex c = new Complex();
        c = a.div(a,b);
        c.printAlg();
    }
}
