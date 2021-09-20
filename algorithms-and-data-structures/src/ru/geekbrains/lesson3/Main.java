package ru.geekbrains.lesson3;

public class Main {
    public static void main(String[] args) {
//        MyStack<Integer> myStack = new MyStack<>();
//
//        myStack.push(5);
//        myStack.push(2);
//        myStack.push(9);
//        myStack.push(1);
//        myStack.push(4);
//
//        for (int i = 0; i < 5; i++) {
//            System.out.println(myStack.pop());
//        }

//        Expression e = new Expression("()+{}+[{}]");
//        System.out.println(e.checkBracket());


//        MyQueue<Integer> queue = new MyQueue<>();
//
//        queue.insert(3);
//        queue.insert(2);
//        queue.insert(7);
//        queue.insert(4);
//
//        for (int i = 0; i < 4; i++) {
//            System.out.println(queue.remove());
//        }

        MyPriorityQueue<Integer> mpq = new MyPriorityQueue<>();

        mpq.insert(5);
        mpq.insert(2);
        mpq.insert(20);
        mpq.insert(21);
        mpq.insert(4);

        for (int i = 0; i < 5; i++) {
            System.out.println(mpq.remove());
        }
    }
}
