package ru.geekbrains.lesson8.homework;

import java.util.LinkedList;

public class ChainingHashMap<K, V> {
    private int capacity;
    private int size;
    private static final int DEFAULT_CAPACITY = 16;

    private LinkedList<Node>[] st;

    public ChainingHashMap(int capacity) {
        this.capacity = capacity;
        st = new LinkedList[capacity];
        for (int i = 0; i < st.length; i++) {
            st[i] = new LinkedList<>();
        }
    }

    public ChainingHashMap() {
        this(DEFAULT_CAPACITY);
    }

    private class Node {
        K key;
        V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
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

    public boolean contains(K key) {
        return get(key) != null;
    }

    private void checkKeyNotNull(K key) {
        if (key == null) {
            throw new IllegalArgumentException("key не должен быть null");
        }
    }

    public void put(K key, V value) {
        checkKeyNotNull(key);
        int i = hash(key);
        for (Node node : st[i]) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
        }
        st[i].addLast(new Node(key, value));
        size++;
    }

    public V get(K key){
        checkKeyNotNull(key);
        int i = hash(key);
        for (Node node : st[i]) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }
        return null;
    }

    public boolean remove(K key) {
        checkKeyNotNull(key);
        int i = hash(key);
        return st[i].removeIf(x-> x.key.equals(key));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < st.length; i++) {
            sb.append(i).append(". ");
            for (Node node : st[i]) {
                sb.append(node.key).append(" = ").append(node.value).append(", ");
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
