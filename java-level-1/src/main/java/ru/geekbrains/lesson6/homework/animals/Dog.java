package ru.geekbrains.lesson6.homework.animals;

public class Dog extends Animal {

    private static int counter;

    public Dog() {
        counter++;
    }

    public Dog(String name) {
        this();
        this.name = name;
    }

    @Override
    public void run(int length) {
        if (length > 500) length = 500;
        if (name == null || name.isEmpty()) {
            System.out.println("Собака пробежала " + length + " м.");
        } else {
            System.out.println(name + " пробежал " + length + " м.");
        }
    }

    @Override
    public void swim(int length) {
        if (length > 10) length = 10;
        if (name == null || name.isEmpty()) {
            System.out.println("Собака проплыла " + length + " м.");
        } else {
            System.out.println(name + " проплыл " + length + " м.");
        }
    }

    public static void printCounter() {
        System.out.println("Собак = " + counter);
    }
}
