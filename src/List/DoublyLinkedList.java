package List;

/**
 * Created by laura on 25.10.16.
 */
public class DoublyLinkedList<T> implements Listable<T> {


    private Node head;
    private Node tail;
    //private int size;

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
            tail = newNode;
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
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = null;
        newNode.prev = null;
        int previousIndex = index - 1;

        if (newNode == null) {
            throw new IllegalArgumentException("No data in Node. Node is null.");
        }
        if (index == 0) {
            addFirst(data);
        } else {
            int size = getSize();
            if (index > size - 1) {
                throw new IndexOutOfBoundsException("Index bigger than size!");
            } else {
                Node previousNode = head;
                Node temp;

                for (int i = 0; i < previousIndex; i++) {
                    previousNode = previousNode.next;
                }

                temp = previousNode.next;
                previousNode.next = newNode;
                newNode.next = temp;
                newNode.prev = previousNode;
                temp.prev = newNode;
            }
        }
    }

    @Override
    public void remove(int index) {
        int size = getSize();

        if (index > 0 || index < size) {

            if (index == 0) {
                head.next = head;

            } else if (index == size - 1) {
                tail = tail.prev;
                tail.next = null; //just to be sure

            } else if (index <= size / 2) { //index is in the first half of the list
                int previousIndex = index - 1;

                Node previousNode = head;
                Node nextNode = head;
                //move from head to tail with these two Nodes through the list to find the right spot
                for (int i = 0; i < previousIndex; i++) {
                    previousNode = previousNode.next;
                    nextNode = nextNode.next;
                }
                //move the next Node to its own spot (index + 1)
                nextNode = nextNode.next;
                nextNode = nextNode.next;
                //point with previous Node to the new next Node, mark the previous Node
                // and, as a result: forget about the Node to remove
                previousNode.next = nextNode;
                nextNode.prev = previousNode;

            } else if (index > size / 2) { //index is in the second half of the list

                int nextIndex = index + 1;

                Node previousNode = tail;
                Node nextNode = tail;
                //move from tail to head with these two Nodes through the list to find the right spot
                for (int i = size; i > nextIndex; i--) {
                    previousNode = previousNode.prev;
                    nextNode = nextNode.prev;
                }
                //move the previous Node to its own spot (index - 1)
                previousNode = previousNode.prev;
                previousNode = previousNode.prev;
                //point with previous Node to the new next Node, mark the previous Node
                // and, as a result: forget about the Node to remove
                previousNode.next = nextNode;
                nextNode.prev = previousNode;
            }
        } else {
            throw new IndexOutOfBoundsException("Index bigger or smaller than size!");
        }
    }


    @Override
    public T get(int index) {
        int size = getSize();

        if (index > 0 || index < size) {


        } else {
        throw new IndexOutOfBoundsException("Index bigger or smaller than size!");
    }
            return null;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
    }

    @Override
    public void printAll() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }

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
