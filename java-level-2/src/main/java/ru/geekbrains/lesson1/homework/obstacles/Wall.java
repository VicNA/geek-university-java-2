package ru.geekbrains.lesson1.homework.obstacles;

import ru.geekbrains.lesson1.homework.participants.Participants;

public class Wall implements Obstacles {

    private double height;

    public Wall(double height) {
        this.height = height;
    }

    @Override
    public void doIt(Participants p) {
        p.jump(height);
    }
}
