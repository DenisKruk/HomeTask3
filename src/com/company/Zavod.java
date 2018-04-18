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

        int goodsForFirstShop = getGoodsForShop(1);
        goodsCount -= goodsForFirstShop;
        int goodsForSecondShop = getGoodsForShop(2);
        goodsCount -= goodsForSecondShop;
        int goodsForThirdShop = getGoodsForShop(3);
        goodsCount -= goodsForThirdShop;


        earnedMoney += sellGoods(goodsForFirstShop, 1);
        earnedMoney += sellGoods(goodsForSecondShop, 2);
        earnedMoney += sellGoods(goodsForThirdShop, 3);


        int soldGoods = producedGoods - goodsCount;
        printReport(soldGoods, earnedMoney);
    }

    private static void printReport(int soldGoods, int earnedMoney) {
        System.out.println("Завод продал "+soldGoods+" по цене "+earnedMoney+", средняя цена за штуку: "+(double)earnedMoney/soldGoods);
    }

    private static int sellGoods(int goodsForFirstShop, int shopNumber) {
        int result=0;
        switch (shopNumber){
            case 1:
                result=c1;
                System.out.println("Магазин номер "+shopNumber+" купил "+goodsForFirstShop+" товаров по цене "+c1+" . " +
                        "\nСредняя цена = "+(double)c1/goodsForFirstShop);
                break;
            case 2:
                result=c2;
                System.out.println("Магазин номер "+shopNumber+" купил "+k2+" товаров по цене "+c2+" . " +
                        "\nСредняя цена = "+(double)c2/k2);
                break;
            case 3:
                result=c3;
                System.out.println("Магазин номер "+shopNumber+" купил "+k3+" товаров по цене "+c3+" . " +
                        "\nСредняя цена = "+(double)c3/k3);
                break;
        }
        return  result;
    }

    private static int getGoodsForShop(int shopNumber) {
        int result=0;
        switch (shopNumber) {
            case 1:
                result = k1;
                break;
            case 2:
                if(k2<produceGoods()-k1){
                    result = k2;
                }
                else{
                    result=produceGoods()-k1;
                }
                break;
            case 3:
                if(k3<(produceGoods()-k1)-k2){
                    result = k3;
                }
                else {
                    result = produceGoods()-k1-k2;
                }
                break;
        }
        return result;
    }


    private static int produceGoods() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите число произведенного товара до "+pMax);
        int result;
        try {
            result = scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(" Вы ввели не числою");
            return produceGoods();
        }
        if (result>pMax){
            System.out.println("Число больше "+pMax);
            return produceGoods();
        }
        System.out.println("Завод выпустил " + result + " продукции");
        return result;

    }
}
