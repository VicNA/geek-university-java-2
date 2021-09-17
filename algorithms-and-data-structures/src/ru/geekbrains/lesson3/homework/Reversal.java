package ru.geekbrains.lesson3.homework;

public class Reversal {
    final String line;

    public Reversal(String line) {
        this.line = line;
    }

    public String coup() {
        MyDequeue<Character> dequeue = new MyDequeue<>(line.length());
        for (int i = 0; i < line.length(); i++) {
            dequeue.insertLeft(line.charAt(i));
        }

        StringBuilder sb = new StringBuilder(line.length());
        for (int i = 0; i < line.length(); i++) {
            sb.append(dequeue.removeLeft());
        }

        return sb.toString();
    }
}
