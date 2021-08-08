package ru.geekbrains.lesson1.homework.task3;

import java.util.ArrayList;

public class Box<T extends Fruit> {

    private T fruit;
    private ArrayList<T> list = new ArrayList<>();

    public Box(T fruit) {
        this.fruit = fruit;
    }

    public Box(T fruit, int count) {
        this(fruit);
        for (int i = 0; i < count; i++) {
            list.add(fruit);
        }
    }

    public void add(T fruit) {
        list.add(fruit);
    }

    public int getCount() {
        return list.size();
    }

    public float getWeight() {
        return fruit.getWeight() * list.size();
    }

    public boolean compare(Box<?> box) {
        return Math.abs(getWeight() - box.getWeight()) < 0.00001;
    }

    public void shift(Box<T> box) {
        for (int i = 0; i < list.size(); i++) {
            box.add(list.get(i));
        }
        list.removeAll(list);
    }
}
