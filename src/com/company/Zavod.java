package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Zavod {
    public static int pMax = 90;
    public static int shopNumber;
    public static int k1 = 25;
    public static int c1 = 5000;
    public static int k2 = 30;
    public static int c2 = 5500;
    public static int k3 = 35;
    public static int c3 = 4500;


    public static void main(String[] args) {
        int earnedMoney = 0;
        int producedGoods = produceGoods();
        int goodsCount = producedGoods;

        int goodsForFirstShop = getGoodsForShop(1, goodsCount);
        goodsCount -= goodsForFirstShop;
        int goodsForSecondShop = getGoodsForShop(2, goodsCount);
        goodsCount -= goodsForSecondShop;
        int goodsForThirdShop = getGoodsForShop(3, goodsCount);
        goodsCount -= goodsForThirdShop;


        earnedMoney += sellGoods(goodsForFirstShop, 1);
        earnedMoney += sellGoods(goodsForSecondShop, 2);
        earnedMoney += sellGoods(goodsForThirdShop, 3);


        int soldGoods = producedGoods - goodsCount;
        printReport(soldGoods, earnedMoney);
    }

    private static void printReport(int soldGoods, int earnedMoney) {
        System.out.println("Завод продал " + soldGoods + " по цене " + earnedMoney + ", средняя цена за штуку: " + (double) earnedMoney / soldGoods);
    }

    private static int sellGoods(int a, int shopNumber) {
        int result = 0;
        switch (shopNumber) {
            case 1:
                result = c1;
                System.out.println("Магазин номер " + shopNumber + " купил " + a + " товаров по цене " + ((double) c1 / k1) * a + " . " +
                        "\nСредняя цена = " + (double) c1 / k1);
                break;
            case 2:
                result = c2;
                System.out.println("Магазин номер " + shopNumber + " купил " + a + " товаров по цене " + ((double) c2 / k2) * a + " . " +
                        "\nСредняя цена = " + (double) c2 / k2);
                break;
            case 3:
                result = c3;
                System.out.println("Магазин номер " + shopNumber + " купил " + a + " товаров по цене " + ((double) c3 / k3) * a + " . " +
                        "\nСредняя цена = " + (double) c3 / k3);
                break;
        }
        return result;
    }

    private static int getGoodsForShop(int shopNumber, int goodCounts) {
        int result = 0;
        switch (shopNumber) {
            case 1:
                if (k1 < goodCounts) {
                    result = k1;
                } else if (goodCounts <= 0) {
                    result = 0;
                    break;
                } else {
                    result = goodCounts;
                }
                break;
            case 2:
                if (k2 < goodCounts) {
                    result = k2;
                } else if (goodCounts <= 0) {
                    result = 0;
                    break;
                } else {
                    result = goodCounts;
                }
                break;
            case 3:
                if (k3 < goodCounts) {
                    result = k3;
                } else if (goodCounts <= 0) {
                    result = 0;
                    break;
                } else {
                    result = goodCounts;
                }
                break;
        }
        return result;
    }


    private static int produceGoods() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите число произведенного товара до " + pMax);
        int result;
        try {
            result = scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(" Вы ввели не числою");
            return produceGoods();
        }
        if (result > pMax) {
            System.out.println("Число больше " + pMax);
            return produceGoods();
        }
        System.out.println("Завод выпустил " + result + " продукции");
        return result;

    }
}
