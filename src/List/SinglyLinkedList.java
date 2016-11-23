package List;

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
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }



    // Such an insert can be done in two steps:
    // Update link of the "previous" node, to point to the new node.
    // Update link of the new node, to point to the "next" node.
    @Override
    public void insertAt(int index, T data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = null;
        int previousIndex = index - 1;

        if (newNode == null) {
            throw new IllegalArgumentException("No data in Node. Node is null.");
        }
        if (index == 0) {
            addFirst(newNode);
        }
        else {
            int size = getSize();
            if (index > size - 1) {
                throw new IndexOutOfBoundsException("Index bigger than size!");
            } else {
                Node findPreviousNode = head;
                Node temp;

                for (int i = 0; i < previousIndex; i++) {
                    findPreviousNode = findPreviousNode.next;
                }

                temp = findPreviousNode.next;
                findPreviousNode.next = newNode;
                newNode.next = temp;
            }
        }
    }

    public void addFirst(Node newNode) {
        if (newNode == null) {
            throw new IllegalArgumentException("New Npode is null!");
        }
        newNode.next = head;
        head = newNode;
    }


    @Override
    public void remove(int index) {

    }

    @Override
    public T get(int index) {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            if (count == index) {
                return temp.data;
            }
            count++;
            temp = temp.next;
        }
        return null;
    }

    @Override
    public void clear() {
        head = null;
    }

    @Override
    public void printAll() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

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

