package ru.geekbrains.lesson4.homework;

public class LinkedQueue<T> {

    private MyLinkedList<T> list;

    public LinkedQueue() {
        list = new MyLinkedList<>();
    }

    public void insert(T item) {
        list.insertFirst(item);
    }

    public T remove() {
        return list.removeLast();
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int indexOf(T item) {
        return list.indexOf(item);
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
