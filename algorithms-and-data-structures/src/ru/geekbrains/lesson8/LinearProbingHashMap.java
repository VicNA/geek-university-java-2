package ru.geekbrains.lesson8;

import java.util.Arrays;

public class LinearProbingHashMap<K, V> {
    private int capacity;
    private int size;

    private K[] keys;
    private V[] values;

    public LinearProbingHashMap(int capacity) {
        this.capacity = capacity;
        keys = (K[]) new Object[capacity];
        values = (V[]) new Object[capacity];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % capacity;
    }

    private int hash2(K key) {
        return 7 - (key.hashCode() & 0x7fffffff) % 7;
    }

    public boolean contains(K key) {
        return false;//get(key) != null;
    }

    private void checkKeyNotNull(K key) {
        if (key == null) {
            throw new IllegalArgumentException("key не должен быть null");
        }
    }

    public void put(K key, V value) {
        checkKeyNotNull(key);
        if (size >= capacity - 1) {
            throw new RuntimeException("Массив переполнен");
        }
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % capacity) {
            if (keys[i].equals(key)) {
                values[i] = value;
                return;
            }
        }
        keys[i] = key;
        values[i] = value;
        size++;
    }

    public V get(K key) {
        checkKeyNotNull(key);
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % capacity) {
            if (keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return Arrays.toString(keys);
    }
}
