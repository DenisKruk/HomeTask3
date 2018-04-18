package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int min = 10;
        int max = 99;
        int two = getNum(min, max);
        maxOfTwq(two);
        int min1 = 1000;
        int max1 = 9999;
        int four = getNum(min1, max1);
        numsOfFour(four);
        int gramm = getNum1();
        kgFromGramm(gramm);
        int first = getNum1();
        int second = getNum1();
        rateFirstAndSecond(first, second);
        int a = getNum1();
        int b = getNum1();
        int c = getNum1();
        fourmula(a, b, c);
    }

    private static void fourmula(int a, int b, int c) {
        double result = (a + b - ((double) c / a)) + c * a * a - (a + b);
        System.out.println(result);
    }

    private static void rateFirstAndSecond(int first, int second) {
        if (first > second) {
            System.out.println("Число " + first + " больше числа " + second);
        } else if (first < second) {
            System.out.println("Число " + first + " меньше числа " + second);
        }
        if (first == second) {
            System.out.println("Выведенные числа равны");
        }

    }

    private static int getNum1() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите число");
        int result;
        try {
            result = scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(" Вы ввели не числою");
            return getNum1();
        }

        return result;

    }

    private static void kgFromGramm(int gramm) {
        System.out.println(gramm + " грамм это " + (double) gramm / 1000 + " килограмм");
    }

    private static void numsOfFour(int four) {
        System.out.println("число " + four + ", \nпервый разряд: " + ((four % 1000) % 100) % 10 + ", \nвторой разряд: "
                + ((four % 1000) % 100) / 10 + ", \nтретий разряд: " + (four % 1000) / 100 + ", \nчетвертый разряд: " + four / 1000);
    }

    private static void maxOfTwq(int two) {
        int a = two / 10;
        int b = two % 10;
        if (a > b) {
            System.out.println("Цифра " + a + " большая, цифра " + b + " меньшая");
        } else if (a < b) {
            System.out.println("Цифра " + b + " большая, цифра " + a + " меньшая");
        } else if (a == b) {
            System.out.println("Цифра " + a + " равна цифре " + b);
        }
    }

    private static int getNum(int min, int max) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите число от " + min + " до " + max);
        int result;
        try {
            result = scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(" Вы ввели не числою");
            return getNum(min, max);
        }
        if (result < min || result > max) {
            System.out.println("Число не от " + min + " до " + max);
            return getNum(min, max);
        }
        return result;

    }
}
