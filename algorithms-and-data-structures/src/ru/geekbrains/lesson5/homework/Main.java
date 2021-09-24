package ru.geekbrains.lesson5.homework;

public class Main {
    static int[] values = new int[]{3000, 2000, 1500};
    static int[] weights = new int[]{1, 2, 3, 4};
    static int W = 4;

    public static void main(String[] args) {
//      Задание 1
        System.out.println(pow(5, 10));

//      Задание 2
        System.out.println(knapsack(values.length -1, W));
    }

    public static int pow(int num, int powNum) {
        if (powNum == 1) return num;
        return pow(num, powNum - 1) * num;
    }

    public static int knapsack(int i, int W) {
        if (i < 0) return 0;
        if (weights[i] > W) {
            return knapsack(i - 1, W);
        } else {
            return Math.max(knapsack(i - 1, W), knapsack(i - 1, W - weights[i]) + values[i]);
        }
    }
}
