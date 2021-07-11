package ru.geekbrains.lesson5.homework;

import java.util.Arrays;

public class MainApp {

    final static int SIZE = 10_000_000;
    final static int HALF = SIZE / 2;

    public static void main(String[] args) throws InterruptedException {
        firstMethod();
        secondMethod();
    }

    public static void firstMethod() {
        float[] arr = new float[SIZE];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1f;
        }

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("One thread time: " + (System.currentTimeMillis() - startTime) + " ms.");
//        System.out.println(Arrays.toString(arr));
    }

    public static void secondMethod() throws InterruptedException {
        float[] arr = new float[SIZE];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1f;
        }

        long startTime = System.currentTimeMillis();

        float[] leftArr = new float[HALF];
        float[] rightArr = new float[HALF];

        System.arraycopy(arr, 0, leftArr, 0, leftArr.length);
        System.arraycopy(arr, leftArr.length, rightArr, 0, rightArr.length);

        Thread thread1 = new  Thread(() -> {
            for (int i = 0; i < leftArr.length; i++) {
                leftArr[i] = (float) (leftArr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });

        Thread thread2 = new  Thread(() -> {
            int j;
            for (int i = 0; i < rightArr.length; i++) {
                j = i + HALF;
                rightArr[i] = (float) (rightArr[i] * Math.sin(0.2f + j / 5) * Math.cos(0.2f + j / 5) * Math.cos(0.4f + j / 2));
            }
        });

        thread1.start();
        thread2.start();

        float[] newArr = new float[SIZE];

        thread1.join();
        System.arraycopy(leftArr, 0, newArr, 0, leftArr.length);
        thread2.join();
        System.arraycopy(rightArr, 0, newArr, leftArr.length, rightArr.length);

        System.out.println("Two thread time: " + (System.currentTimeMillis() - startTime) + " ms.");
//        System.out.println(Arrays.toString(newArr));
    }
}
