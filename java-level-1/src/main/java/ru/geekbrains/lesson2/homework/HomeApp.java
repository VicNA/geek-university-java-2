package ru.geekbrains.lesson2.homework;

public class HomeApp {

    public static void main(String[] args) {
        System.out.println(within10and20(10, 10));
        isPositiveOrNegative(-1);
        System.out.println(isNegative(-1));
        printWordLines("Geekbrains", 4);
        System.out.println(isLeapYear(1600));
    }

    public static boolean within10and20(int x1, int x2) {
        int sum = x1 + x2;
        return sum > 10 && sum <= 20;
    }

    public static void isPositiveOrNegative(int x) {
        if (x >= 0) {
            System.out.println("Положительное");
        } else {
            System.out.println("Отрицательное");
        }
    }

    public static boolean isNegative(int x) {
        return x < 0;
    }

    public static void printWordLines(String word, int line) {
        for (int i = 0; i < line; i++) {
            System.out.println(word);
        }
    }

    public static boolean isLeapYear(int year) {
        if (year % 4 > 0) return false;
        if (year % 100 == 0 && year % 400 > 0) return false;
        return true;
    }

}
