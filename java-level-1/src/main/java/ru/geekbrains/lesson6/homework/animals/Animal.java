package ru.geekbrains.lesson6.homework.animals;

public abstract class Animal {

    String name;
    private static int counter;

    public Animal() {
        counter++;
    };

    public Animal(String name) {
        this();
        this.name = name;
    }

    public static void printCounter() {
        System.out.println("Животных = " + counter);
    }

    public abstract void run(int length);

    public abstract void swim(int length);
}
