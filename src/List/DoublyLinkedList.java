package List;

/**
 * Created by laura on 25.10.16.
 */
public class DoublyLinkedList<T> implements Listable<T> {


    private Node head;
    private Node tail;
    private int size;

    private class Node {
        T data;
        Node prev;
        Node next;
    }


    /**
     * Method to add an Node to the List
     * (at the end if there are elements present).
     *
     * @param data data content of the Node
     */
    @Override
    public void add(T data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = null;
        newNode.prev = null;

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }


    /**
     * Method to add an Node before the first Node.
     *
     * @param data data content of the new Node
     */
    @Override
    public void addFirst(T data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = null;
        newNode.prev = null;

        if (newNode == null) {
            throw new IllegalArgumentException("New Node is null!");
        }
        head = newNode;
        tail = newNode;
        newNode.next = null;
        newNode.prev = null;
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


    //Same as in SinglyLinkedList
    @Override
    public int getSize() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}
