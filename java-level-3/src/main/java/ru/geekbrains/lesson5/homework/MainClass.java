package ru.geekbrains.lesson5.homework;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Phaser;
import java.util.concurrent.Semaphore;

public class MainClass {

    public static final int CARS_COUNT = 4;

    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");

        Semaphore semaphore = new Semaphore(CARS_COUNT / 2);
//        CountDownLatch latch1 = new CountDownLatch(CARS_COUNT);
//        CountDownLatch latch2 = new CountDownLatch(CARS_COUNT);
//        CyclicBarrier barrier = new CyclicBarrier(CARS_COUNT);
        Phaser phaser = new Phaser();
        phaser.register();

        Race race = new Race(new Road(60), new Tunnel(semaphore), new Road(40));
        Car[] cars = new Car[CARS_COUNT];

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), phaser);
        }

        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }

//        try {
//            latch1.await();
            phaser.arriveAndAwaitAdvance();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        try {
//            latch2.await();
            phaser.arriveAndAwaitAdvance();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
            phaser.arriveAndDeregister();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
