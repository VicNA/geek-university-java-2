package ru.geekbrains.lesson1.homework.obstacles;

import ru.geekbrains.lesson1.homework.participants.Participants;

public class Track implements Obstacles {

    private int length;

    public Track(int length) {
        this.length = length;
    }

    @Override
    public void doIt(Participants p) {
        p.run(length);
    }
}
