package ru.geekbrains.lesson1.homework;

import ru.geekbrains.lesson1.homework.task3.Apple;
import ru.geekbrains.lesson1.homework.task3.Box;
import ru.geekbrains.lesson1.homework.task3.Orange;

import java.util.ArrayList;
import java.util.Arrays;

public class MainApp {

    public static void main(String[] args) {

//      Задание 1
        System.out.println("Задание 1:");
        Integer[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(Arrays.toString(numbers));

        swap(numbers, 4, 9);
        System.out.println(Arrays.toString(numbers));

//      Задание 2
        System.out.println("\nЗадание 2:");
        ArrayList<?> list = getArrList(numbers);
        System.out.println("list - это " + list.getClass().getSimpleName());
        System.out.println(getArrList(numbers));

//      Задание 3
        System.out.println("\nЗадание 3:");
        Box<Apple> boxApple1 = new Box<>(new Apple(), 6);
        Box<Apple> boxApple2 = new Box<>(new Apple(), 5);
        Box<Orange> boxOrange1 = new Box<>(new Orange(), 4);

        System.out.println(boxApple1.compare(boxApple2));
        System.out.println(boxApple1.compare(boxOrange1));

        Box<Orange> boxOrange2 = new Box<>(new Orange());
        boxOrange1.shift(boxOrange2);
        System.out.println("boxOrange1 = " + boxOrange1.getCount() + ", boxOrange2 = " + boxOrange2.getCount());
    }

    private static void swap(Object[] arr, int i, int j) {
        Object tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static ArrayList getArrList(Object[] arr) {
        return new ArrayList(Arrays.asList(arr));
    }
}
