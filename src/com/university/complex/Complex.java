package com.university.complex;

import java.math.*;

/**
 * Created by Andrey on 02.10.2016.
 */

public class Complex {
    private final int FIVE = 5;

    private double real;
    private double imaginaries;

    Complex() { }

    Complex(double real, double imaginaries) {
        this.real = real;
        this.imaginaries = imaginaries;
    }

    public void printAlg() {
        BigDecimal bReal = round(real, FIVE);
        if (imaginaries == 0) {
            System.out.println(bReal);
        } else {
            BigDecimal bImag = round(imaginaries, FIVE);
            System.out.println(bReal + " + " + "i*" + bImag);
        }
    }

    private double getModul() {
        return Math.sqrt(Math.pow(real, 2) + Math.pow(imaginaries, 2));
    }

    private double getFi() {
        return Math.atan(imaginaries / real);
    }

    private void getDual() {
        imaginaries = -imaginaries;
    }

    private BigDecimal round(double number, int precision) {
        BigDecimal cpyNumber = new BigDecimal(number);
        MathContext mathPrecision = new MathContext(precision);
        return cpyNumber.round(mathPrecision);
    }

    public void printTrig() {
        BigDecimal modul = round(getModul(), FIVE);
        BigDecimal fi = round(getFi(), FIVE);
        System.out.println("Trig form:");
        System.out.println(modul + "(cos(" + fi + ") + i*sin(" + fi + "))");
    }

    public void printExp() {
        BigDecimal modul = round(getModul(), FIVE);
        BigDecimal fi = round(getFi(), FIVE);
        System.out.println("Exp form:");
        System.out.println(modul + "*E^(i*" + fi + ")");
    }

    public Complex add(Complex one, Complex two) {
        Complex temp = new Complex();
        temp.imaginaries = one.imaginaries + two.imaginaries;
        temp.real = one.real + two.real;
        return temp;
    }

    public void add(Complex one) {
        real += one.real;
        imaginaries += one.imaginaries;
    }

    public Complex sub(Complex one, Complex two) {
        Complex temp = new Complex();
        temp.imaginaries = one.imaginaries - two.imaginaries;
        temp.real = one.real - two.real;
        return temp;
    }

    public void sub(Complex one) {
        real -= one.real;
        imaginaries -= one.imaginaries;
    }

    public void mul(Complex one) {
        double copyReal = real;
        double copyImag = imaginaries;
        real = one.real * copyReal - one.imaginaries * copyImag;
        imaginaries = one.real * copyImag + one.imaginaries * copyReal;
    }

    public Complex mul(Complex one, Complex two) {
        Complex temp = new Complex();
        temp.real = one.real * two.real - one.imaginaries * two.imaginaries;
        temp.imaginaries = one.imaginaries * two.real + one.real * two.imaginaries;
        return temp;
    }

    public void div(Complex one) {
        one.getDual();
        this.mul(one);
        double a = Math.pow(one.real, 2) + Math.pow(one.imaginaries, 2);
        real /= a;
        imaginaries /= a;
    }

    public Complex div(Complex one, Complex two) {
        Complex temp = new Complex();
        two.getDual();
        temp = temp.mul(one, two);
        double a = Math.pow(two.real, 2) + Math.pow(two.imaginaries, 2);
        temp.real /= a;
        temp.imaginaries /= a;
        return temp;
    }

}
