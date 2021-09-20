package ru.geekbrains.lesson4.homework;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedQueue<Integer> queue = new LinkedQueue<>();

        queue.insert(5);
        queue.insert(15);
        queue.insert(15);
        queue.insert(35);

        System.out.println(queue);
        System.out.println(queue.indexOf(15) + "\n");

        System.out.println(queue.remove());
        System.out.println(queue.remove());

        System.out.println(queue);

        System.out.println(queue.indexOf(5));
    }
}
