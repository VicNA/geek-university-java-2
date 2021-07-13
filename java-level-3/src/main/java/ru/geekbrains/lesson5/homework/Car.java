package ru.geekbrains.lesson5.homework;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable {

    private static int CARS_COUNT;

    static {
        CARS_COUNT = 0;
    }

    private Race race;
    private CountDownLatch latch1;
    private CountDownLatch latch2;
    private CyclicBarrier barrier;

    private int speed;
    private String name;
    private static boolean winner;

    public Car(Race race, int speed, CountDownLatch latch1, CyclicBarrier barrier, CountDownLatch latch2) {
        this.race = race;
        this.speed = speed;
        this.latch1 = latch1;
        this.latch2 = latch2;
        this.barrier = barrier;

        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            latch1.countDown();
            barrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        if (!winner) {
            winner = true;
            System.out.println(this.name + " - WIN");
        }
        latch2.countDown();
    }
}