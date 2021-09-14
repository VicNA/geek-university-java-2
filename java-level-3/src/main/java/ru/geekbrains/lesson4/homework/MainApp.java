package ru.geekbrains.lesson4.homework;

public class MainApp {

    final Object monitor = new Object();
    private volatile char letter = 'A';
    private int counter = 5;

    public static void main(String[] args) {
        MainApp app = new MainApp();

        new Thread(() -> app.printLetter('A', 'B')).start();
        new Thread(() -> app.printLetter('B', 'C')).start();
        new Thread(() -> app.printLetter('C', 'A')).start();
    }

    public void printLetter(char let1, char let2) {
        synchronized (monitor) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (letter != let1) {
                        monitor.wait();
                    }
                    System.out.print(letter);
                    letter = let2;
                    monitor.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
