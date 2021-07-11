package ru.geekbrains.lesson1.homework;

public class HomeApp {
    
    public static void main(String[] args) {
        printTreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
    }

    public static void printTreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public static void checkSumSign() {
        int a = (int) (Math.random() * 10 * 2 - 10);
        int b = (int) (Math.random() * 10 * 2 - 10);

        if ((a + b) >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void printColor() {
        int value = (int) (Math.random() * 200 * 2 - 200);

        if (value <= 0) {
            System.out.println("Красный");
        } else if (value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers() {
        int a = (int) (Math.random() * 10 * 2 - 10);
        int b = (int) (Math.random() * 10 * 2 - 10);

        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

}
