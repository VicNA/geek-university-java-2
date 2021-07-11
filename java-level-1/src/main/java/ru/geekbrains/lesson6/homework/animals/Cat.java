package ru.geekbrains.lesson6.homework.animals;

public class Cat extends Animal {

    private static int counter;

    public Cat() {
        counter++;
    }

    public Cat(String name) {
        this();
        this.name = name;
    }

    @Override
    public void run(int length) {
        if (length > 200) length = 200;
        if (name == null || name.isEmpty()) {
            System.out.println("Кот пробежал " + length + " м.");
        } else {
            System.out.println(name + " пробежал " + length + " м.");
        }
    }

    @Override
    public void swim(int length) {
        if (name == null || name.isEmpty()) {
            System.out.println("Кот не умеет плавать");
        } else {
            System.out.println(name + " не умеет плавать");
        }
    }

    public static void printCounter() {
        System.out.println("Котов = " + counter);
    }
}
