package ru.geekbrains.lesson1.homework.participants;

public class Robot implements Participants {

    private String name;
    private int limitRun;
    private double limitJump;
    private boolean result;

    public Robot(String name, int limitRun, double limitJump) {
        this.name = name;
        this.limitRun = limitRun;
        this.limitJump = limitJump;
    }

    @Override
    public boolean getResult() {
        return result;
    }

    @Override
    public void jump(double height) {
        result = limitJump >= height;
        if (limitJump >= height) {
            System.out.println(name + " перепрыгнул стенку");
        } else {
            System.out.println(name + " не смог перепрыгнуть стенку");
        }
    }

    @Override
    public void run(int length) {
        result = limitRun >= length;
        if (limitRun >= length) {
            System.out.println(name + " пробежал беговую дорожку");
        } else {
            System.out.println(name + " не смог пробежать беговую дорожку");
        }
    }
}
