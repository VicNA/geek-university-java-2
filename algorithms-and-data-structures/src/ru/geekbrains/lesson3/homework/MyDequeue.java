package ru.geekbrains.lesson3.homework;

public class MyDequeue<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private T[] list;
    private int begin;
    private int end;
    private int size;

    public MyDequeue() {
        this(DEFAULT_CAPACITY);
    }

    public MyDequeue(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("capacity: " + capacity);

        list = (T[]) new Object[capacity];
    }

    public void insertLeft(T item) {
        if (isFull()) {
            //Расширение массива***
            grow();
        }
        size++;
        list[end] = item;
        end = nextIndex(end);
    }

    public void insertRight(T item) {
        if (isFull()) {
            //Расширение массива***
            grow();
        }
        size++;
        begin = prevtIndex(begin);
        list[begin] = item;
    }

    public T removeRight() {
        if (isEmpty()) {
            throw new RuntimeException("Dequeue isEmpty");
        }

        T temp = list[begin];
        size--;
        list[begin] = null;
        begin = nextIndex(begin);
        return temp;
    }

    public T removeLeft() {
        if (isEmpty()) {
            throw new RuntimeException("Queue isEmpty");
        }

        end = prevtIndex(end);
        T temp = list[end];
        size--;
        list[end] = null;
        return temp;
    }

    private int nextIndex(int index) {
        return (index + 1) % list.length;
    }

    private int prevtIndex(int index) {
        return (list.length + index - 1) % list.length;
    }

    private void grow() {
        list = grow(size + 1);
    }

    private T[] grow(int minCapacity) {
        int newCapacity = list.length + (minCapacity / 2);
        T[] temp = (T[]) new Object[newCapacity];
        int beginCount = list.length - begin;
        System.arraycopy(list, begin, temp, 0, beginCount);
        System.arraycopy(list, 0, temp, beginCount, begin);
        begin = 0;
        end = list.length;
        return temp;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < list.length; i++) {
            sb.append(list[i]).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length()).append("]");
        return sb.toString();
    }

    public boolean isFull() {
        return size == list.length;
    }
}
