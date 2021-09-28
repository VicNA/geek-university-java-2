package ru.geekbrains.lesson6.homework;

import java.util.NoSuchElementException;

public class MyTreeMap<K extends Comparable<K>, V> {

    private class Node {
        K key;
        V value;
        Node left;
        Node right;
        int size;
        int height;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            size = 1;
            height = 0;
        }
    }


    private Node root;

    public boolean contains(K key) {
        return get(key) != null;
    }

    public V get(K key) {
        return get(root, key);
    }

    private V get(Node node, K key) {
        isKeyNotNull(key);

        if (node == null) return null;

        int cmp = key.compareTo(node.key);

        if (cmp == 0) return node.value;
        if (cmp < 0) return get(node.left, key);
        return get(node.right, key);
    }

    public void put(K key, V value) {
        isKeyNotNull(key);

        if (value == null) return;

        root = put(root, key, value);
    }

    private Node put(Node node, K key, V value) {
        if (node == null) return new Node(key, value);

        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            node.value = value;
        } else if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else {
            node.right = put(node.right, key, value);
        }

        node.size = size(node.left) + size(node.right) + 1;

        node.height = height(node);

        return node;
    }

    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 0;

        if (node.left == null) return node.right.height + 1;
        if (node.right == null) return node.left.height + 1;
        return Math.max(node.left.height, node.right.height) + 1;
    }

    public boolean isBalance() {
        return isBalance(root);
    }

    private boolean isBalance(Node node) {
        if (node == null) return true;
        if (node.left == null && node.right == null) return true;

        return Math.abs(height(node.left) - height(node.right)) <= 1
                && isBalance(node.left) && isBalance(node.right);
    }

    public K minKey() {
        return min(root).key;
    }

    private Node min(Node node) {
        if (node.left == null) return node;
        return min(node.left);
    }

    public void deleteMin() {
        if (isEmpty()) throw new NoSuchElementException();
        root = deleteMin(root);
    }

    private Node deleteMin(Node node) {
        if (node.left == null) return node.right;

        node.left = deleteMin(node.left);
        node.size = size(node.left) + size(node.right) + 1;

        node.height = height(node);
        return node;
    }

    public void delete(K key) {
        isKeyNotNull(key);
        root = delete(root, key);
    }

    private Node delete(Node node, K key) {
        if (node == null) return null;

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = delete(node.left, key);
        } else if (cmp > 0) {
            node.right = delete(node.right, key);
        } else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            Node temp = node;
            node = min(node.right);
            node.right = deleteMin(temp.right);
            node.left = temp.left;
        }

        node.size = size(node.left) + size(node.right) + 1;
        node.height = height(node);
        return node;
    }

    private boolean isKeyNotNull(K key) {
        if (key == null) throw new IllegalArgumentException("Ключ не может быть пустым");

        return true;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) return 0;

        return node.size;
    }

    @Override
    public String toString() {
        return toString(root);
    }

    private String toString(Node node) {
        if (node == null) return "";

        return toString(node.left) + " "
                + node.key + " = " + node.value + " "
                + toString(node.right);
    }
}
