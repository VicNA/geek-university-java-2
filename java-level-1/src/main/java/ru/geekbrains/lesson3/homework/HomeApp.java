package ru.geekbrains.lesson3.homework;

import java.util.Arrays;

public class HomeApp {

    public static void main(String[] args) {
        invertArray();
        fillArray();
        multiplyArray();
        fillDiagonal();
        System.out.println("5) fillArray:\n" + Arrays.toString(fillArray(7, 8)));
        findMaxAndMinNumber();
        System.out.println("7) checkBalance:\n" + checkBalance(1, 1, 1, 3, 1));
        shiftArray(new int[] {3, 5, 6, 1}, -5);
    }

    public static void invertArray() {
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
//            Без условия:
//            arr[i] = Math.abs(arr[i] - 1);
        }
        System.out.println("1) invertArray:\n" + Arrays.toString(arr));
    }

    public static void fillArray() {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        System.out.println("2) fillArray:\n" + Arrays.toString(arr));
    }

    public static void multiplyArray() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) arr[i] *= 2;
        }
        System.out.println("3) multiplyArray:\n" + Arrays.toString(arr));
    }

    public static void fillDiagonal() {
        int count = 5;
        int[][] arr = new int[count][count];

        System.out.println("4) fillDiagonal:");
        for (int i = 0; i < count; i++) {
            arr[i][i] = 1;
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    public static int[] fillArray(int len, int initialValue) {
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = initialValue;
        }
        return arr;
    }

    public static void findMaxAndMinNumber() {
        int[] arr = new int[20];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
            if (arr[i] < min) min = arr[i];
        }

        System.out.println("6) findMaxAndMinNumber:\n" + Arrays.toString(arr));
        System.out.println("max = " + max);
        System.out.println("min = " + min);
    }

    public static boolean checkBalance(int...arr) {
        int leftSum = 0, rightSum = 0;
        int rightCount = arr.length;

        for (int i = 0; i < rightCount; i++) {
            leftSum += arr[i];
            for (int j = rightCount - 1; j > i && rightSum < leftSum; j--) {
                rightSum += arr[j];
                rightCount = j;
            }
        }
        return leftSum == rightSum;
    }

    public static void shiftArray(int[] arr, int n) {
        int tmp;
        int counter = n % arr.length;
        if (n > 0) {
            while (counter-- > 0) {
                tmp = arr[arr.length - 1];
                for (int i = arr.length - 1; i > 0; i--) {
                    arr[i] = arr[i - 1];
                }
                arr[0] = tmp;
            }
        } else {
            while (counter++ < 0) {
                tmp = arr[0];
                for (int i = 0; i < arr.length - 1; i++) {
                    arr[i] = arr[i + 1];
                }
                arr[arr.length - 1] = tmp;
            }
        }
        System.out.println("8) shiftArray:\n" + Arrays.toString(arr));
    }
}
