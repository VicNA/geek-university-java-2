package lesson4;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> mll = new MyLinkedList<>();

        mll.insertFirst(5);
        mll.insertFirst(15);
        mll.insertFirst(25);
        mll.insertFirst(35);

//        System.out.println(mll.removeFirst());

        System.out.println(mll);

        mll.insertLast(2);
        mll.insertLast(22);

        System.out.println(mll);

        mll.insert(2, 777);
        System.out.println(mll);
//        System.out.println(mll.removeFirst());
//        System.out.println(mll);
//        System.out.println(mll.removeLast());
//        System.out.println(mll);

        mll.insert(2, 111);
        mll.insert(2, 22);
        System.out.println(mll);
//
        System.out.println(mll.remove(22));
        System.out.println(mll);

        for (Integer x : mll) {
            System.out.println(x);
        }
    }
}
