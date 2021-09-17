package lesson4;

public class LinkedStack<T> {
    private MyLinkedList<T> list;

    public LinkedStack() {
        list = new MyLinkedList<>();
    }

    public void push(T item) {
        list.insertFirst(item);
    }

    public T pop() {
        return list.removeFirst();
    }

    public T peek() {
        return list.getFirst();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }
}
