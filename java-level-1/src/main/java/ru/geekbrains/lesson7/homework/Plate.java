package ru.geekbrains.lesson7.homework;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public boolean decreaseFood(int n) {
        if (food > n) {
            food -= n;
            return true;
        }
        return false;
    }

    public void increaseFood(int n) {
        food += n;
    }

    public void info() {
        System.out.println("plate: " + food);
    }
}
