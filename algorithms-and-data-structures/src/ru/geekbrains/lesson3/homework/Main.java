package ru.geekbrains.lesson3.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
//      Проверка MyDequeue
        MyDequeue<Integer> dequeue = new MyDequeue<>(3);

        dequeue.insertLeft(1);
        System.out.println(dequeue.toString());
        dequeue.insertLeft(2);
        System.out.println(dequeue.toString());
        dequeue.insertLeft(3);
        System.out.println(dequeue.toString());
        dequeue.insertLeft(4);
        System.out.println(dequeue.toString());

        dequeue.insertRight(5);
        System.out.println(dequeue.toString());
        dequeue.insertRight(6);
        System.out.println(dequeue.toString());
        dequeue.insertRight(7);
        System.out.println(dequeue.toString());
        dequeue.insertRight(8);
        System.out.println(dequeue.toString());
//
//        for (int i = 0; i < 5; i++) {
//            System.out.println(dequeue.removeRight());
//        }
//        for (int i = 0; i < 4; i++) {
//            System.out.println(dequeue.removeLeft());
//        }

//      Если не трудно, продемонстрируйте наглядно, пожалуйста, движение ссылок с сохранение в переменную
//      А то временами путаюсь, когда ссылка сохраняется с указанием на свободную ячейку, а когда на занятую

//      Задание 2. переворот вводимой строки

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        Reversal reversal = null;
//        try {
//            reversal = new Reversal(br.readLine());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        String reverseString = reversal.coup();
//        System.out.println(reverseString);
    }
}
