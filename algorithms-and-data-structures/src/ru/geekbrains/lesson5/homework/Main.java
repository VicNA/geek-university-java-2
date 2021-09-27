package ru.geekbrains.lesson5.homework;

public class Main {

    public static void main(String[] args) {
//      Задание 1
        System.out.println(" 2 ^  3 = " + pow(2, 3));
        System.out.println(" 2 ^  0 = " + pow(2, 0));
        System.out.println(" 5 ^  2 = " + pow(5, 2));
        System.out.println("-5 ^  3 = " + pow(-5, 3));
        System.out.println("-4 ^  2 = " + pow(-4, 2));
        System.out.println(" 6 ^ -1 = " + pow(6, -1));
        System.out.println(" 3 ^ -3 = " + pow(3, -3));
        System.out.println("10 ^ -3 = " + pow(10, -3));

//      Задание 2
        Item[] items = {
                new Item(3000, 4),
                new Item(2000, 3),
                new Item(1500, 1)
//                new Item(7, 8),
//                new Item(6, 9)
        };

        Backpack backpack = new Backpack(items);
        int backpackWeight = 4;
        System.out.println("\nСтоимось рюкзака: " + backpack.findBestSum(items.length - 1, backpackWeight));
    }

    public static int pow(int value, int pow) {
        if (value == 0 && pow <= 0) throw new ArithmeticException();
        if (pow == 0) return 1;
        if (pow < 0) return pow(value, ++pow) * (1 / value);
        return pow(value, --pow) * value;
    }
}
