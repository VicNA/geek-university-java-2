package ru.geekbrains.lesson3.homework;

import java.util.Arrays;
import java.util.EmptyStackException;

public class MyStack<T> {
    private T[] list;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MyStack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
        list = (T[]) new Object[capacity];
    }

    public MyStack() {
        this(DEFAULT_CAPACITY);
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list[size - 1];
    }

    public void push(T item) {
        if (isFull()) {
            // расширение массива
            grow();
        }
        list[size++] = item;
    }

    public T pop() {
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
}
