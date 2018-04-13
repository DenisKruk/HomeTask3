package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int a, b;
        a = getNum();
        b = getNum();
        boolean first = true;
        boolean second = false;
        arithmetic(a,b);
        binary(a,b);
        logical(first, second);
        condition(first);
        condition(second);
        ternary(first,a,b);
        ternary(second,a,b);
    }

    private static void ternary(boolean first, int a, int b) {

        int trueNum;
        trueNum= first ? a:b;
        System.out.println(trueNum);
    }

    private static void condition(boolean first) {

        if (first == true) {
            System.out.println("Правда");
        } else {
            System.out.println("Ложь");
        }
        if (first != true) {
            System.out.println("Правда");
        } else {
            System.out.println("Ложь");
        }
    }

    private static void logical(boolean first, boolean second) {
      boolean c;
        c = first & second;
        System.out.println(c);

        c = first && second;
        System.out.println(c);

        c = first | second;
        System.out.println(c);

        c = first || second;
        System.out.println(c);

        c = first != false;
        System.out.println(c);

        c = second != true;
        System.out.println(c);
    }


    private static void binary(int a, int b) {

        System.out.println("И бинарный " + (a & b));
        System.out.println("Или бинарный " + (a | b));
        System.out.println("XOR бинарный " + (a ^ b));
        System.out.println("Сдвиг влево бинарный " + (a << b));
        System.out.println("Сдвиг вправо бинарный " + (a >> b));
    }

    private static void arithmetic(int a, int b) {

        System.out.println("сумма введенных чисел равна " + (a + b));
        System.out.println("Разница вветенных чисел равна " + (a - b));
        System.out.println("Произведение введенных чисел равно " + (a * b));
        System.out.println("Частное введенных чисел равно " + ((double) a / b));

    }

    private static int getNum() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите число");
        int result;
        try {
            result = scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(" Вы ввели не число");
            return getNum();
        }
        return result;

    }
}
