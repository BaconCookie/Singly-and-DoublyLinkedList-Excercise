package List;

/**
 * Created by laura on 25.10.16.
 */
public class DoublyLinkedList<T> implements Listable<T> {


    private Node head;
    private Node tail;

    private class Node {
        T data;
        Node prev;
        Node next;
    }

    @Override
    public void add(T data) {

    }

    @Override
    public void insertAt(int index, T data) {

    }

    @Override
    public void remove(int index) {

    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public void printAll() {

    }

    @Override
    public int getSize() {
        return 0;
    }
}
