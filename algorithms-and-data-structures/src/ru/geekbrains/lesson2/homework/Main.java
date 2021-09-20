package ru.geekbrains.lesson2.homework;

import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {

        int n = 100_000;
        MyArrayList<Integer> arr1 = new MyArrayList<>(n);
        MyArrayList<Integer> arr2 = new MyArrayList<>(n);
        MyArrayList<Integer> arr3 = new MyArrayList<>(n);

        Random random = new Random();
        for (int i = 0; i < n; i++) {
            arr1.add(random.nextInt(n));
            arr2.add(random.nextInt(n));
            arr3.add(random.nextInt(n));
        }

        System.out.println("arr1 = " + arr1.toString(10));

        Instant start = Instant.now();
        arr1.selectionSort();
        Instant end = Instant.now();
        System.out.println("selectionSort: " + Duration.between(start, end).toSeconds() + " секунд");

        System.out.println("arr2 = " + arr2.toString(10));

        start = Instant.now();
        arr2.insertionSort();
        end = Instant.now();
        System.out.println("insertionSort: " + Duration.between(start, end).toSeconds() + " секунд");

        System.out.println("arr3 = " + arr3.toString(10));

        start = Instant.now();
        arr3.bubbleSort();
        end = Instant.now();
        System.out.println("bubbleSort: " + Duration.between(start, end).toSeconds() + " секунд");
    }
}
