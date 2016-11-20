package List;

import javax.xml.soap.Node;

/**
 * Created by laura on 25.10.16.
 */
public class SinglyLinkedList<T> implements Listable<T> {

    private Node head;

    private class Node {
        T data;
        Node next;
    }

    @Override
    public void add(T data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = null;

        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
        }

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
        head = null;
    }

    @Override
    public void printAll() {
        Node temp = head;
            while (temp != null){
                System.out.println(temp.data);
                temp = temp.next;
            }
        }

    @Override
    public int getSize() {
        return 0;
    }
}
