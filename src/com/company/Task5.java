package com.company;

import java.util.Scanner;

public class Task5 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите минимум");
        int minimum = getNumberFromUser(scanner);
        System.out.println("Введите максимум");
        int maximum = getNumberFromUser(scanner);
        int numberFromRange1 = getIntUserInputFromRange(scanner, minimum, maximum);
        printInfoAboutNumbersRange(numberFromRange1);
        int numberFromRange2 = getIntUserInputFromRange(scanner, minimum, maximum);
        printInfoAboutNumbersRange(numberFromRange2);
        System.out.printf("Сумма чисел %d и %d = %d", numberFromRange1, numberFromRange2, numberFromRange1 + numberFromRange2);
    }

    private static void printInfoAboutNumbersRange(int numberFromRange1) {
        if (numberFromRange1 < 0) {
            System.out.printf("%d отрицательное число \n", numberFromRange1);
        } else if (numberFromRange1 > 0 && numberFromRange1 < 100) {
            System.out.printf("%d число от 0 до 100 \n", numberFromRange1);
        } else if (numberFromRange1 > 100 && numberFromRange1 < 1000) {
            System.out.printf("%d число от 100 до 1000 \n", numberFromRange1);
        } else if (numberFromRange1 > 1000 && numberFromRange1 < 10000) {
            System.out.printf("%d число от 1000 до 10000 \n", numberFromRange1);
        } else {
            System.out.println("очень большое число");
        }
    }

    private static int getIntUserInputFromRange(Scanner scanner, int minimum, int maximum) {
        int numberFromRange1 = 0;
        while (true) {
            System.out.printf("введите число от %d до %d \n", minimum, maximum);
            try {
                String stringNumber = scanner.next();
                numberFromRange1 = Integer.valueOf(stringNumber);
            } catch (NumberFormatException e) {
                System.out.println("вы ввели не число");
                continue;
            }
            if (numberFromRange1 < minimum || numberFromRange1 > maximum) {
                System.out.printf("вы ввели число не от %d до %d \n", minimum, maximum);
                continue;
            }
            break;
        }
        return numberFromRange1;
    }


    private static int getNumberFromUser(Scanner scanner) {
        int minimun;
        while (true) {
            System.out.println("введите число");
            try {
                String stringNumber = scanner.next();
                minimun = Integer.valueOf(stringNumber);
            } catch (NumberFormatException e) {
                System.out.println("вы ввели не число");
                continue;
            }
            break;
        }
        return minimun;
    }
}




