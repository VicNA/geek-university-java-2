package ru.geekbrains.lesson8.homework;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        ChainingHashMap<Integer, String> map = new ChainingHashMap<>(7);
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        map.put(6, "six");
        map.put(7, "seven");
        map.put(8, "eight");
        map.put(9, "nine");
        map.put(10, "ten");
        System.out.println(map);

        map.remove(3);
        System.out.println(map);
    }
}
