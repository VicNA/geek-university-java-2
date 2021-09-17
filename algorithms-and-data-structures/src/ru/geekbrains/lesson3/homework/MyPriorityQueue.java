package ru.geekbrains.lesson3.homework;

import java.util.Arrays;
import java.util.EmptyStackException;

public class MyPriorityQueue<T extends Comparable<T>> {
    private T[] list;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MyPriorityQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
        list = (T[]) new Comparable[capacity];
    }

    public MyPriorityQueue() {
        this(DEFAULT_CAPACITY);
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list[size - 1];
    }

    public void insert(T item) {
        if (isFull()) {
            // расширение массива
            grow();
        }
        list[size++] = item;
        int i = size - 1;
        while (i > 0 && list[i].compareTo(list[i - 1]) > 0) {
            swap(i, i - 1);
            i--;
        }
    }

    public T remove() {
        T temp = peek();
        list[size--] = null;
        return temp;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == list.length;
    }

    private T[] grow(int minCapacity) {
        int newCapacity = list.length + (minCapacity / 2);
        return Arrays.copyOf(list, newCapacity);
    }

    private void grow() {
        list =  grow(size + 1);
    }

    private void reCapacity(int newSize) {
        T[] temp = (T[]) new Object[newSize];
        System.arraycopy(list, 0, temp, 0, size);
        list = temp;
    }

    private void swap(int index1, int index2) {
        T temp = list[index1];
        list[index1] = list[index2];
        list[index2] = temp;
    }
}
