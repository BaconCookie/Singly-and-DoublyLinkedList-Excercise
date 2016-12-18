package list;

import comparator.Comparable;
import list.search.Searchable;
import list.sort.Sortable;

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

    /**
     * Method to add an element to the list
     * (at the end if there are elements present).
     *
     * @param data data content of the element
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
     * Method to add an element as the first element
     *
     * @param data data from element that is being added
     */
    @Override
    public void addFirst(T data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = null;
        newNode.prev = null;

        head = newNode;
        tail = newNode;
        newNode.next = null;
        newNode.prev = null;
    }

    /**
     * Method which inserts a new element to a list
     *
     * @param index where new element is placed in a list
     * @param data  which belong to the element to insert
     */
    @Override
    public void insertAt(int index, T data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = null;
        newNode.prev = null;
        int previousIndex = index - 1;

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

    /**
     * Method which removes an element from a list
     *
     * @param index of element to remove
     */
    @Override
    public void remove(int index) {
        int size = getSize();

        if (index > 0 || index < size) {

            if (index == 0) {
                head.next = head;

            } else if (index == size - 1) {
                tail = tail.prev;
                tail.next = null; //just to be sure

            } else if (index < size / 2) { //index is in the first half of the list
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

            } else if (index >= size / 2) { //index is in the second half of the list

                int nextIndex = index + 1;

                Node previousNode = tail;
                Node nextNode = tail;
                //move from tail to head with these two Nodes through the list to find the right spot
                for (int i = size - 1; i > nextIndex; i--) {
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


    /**
     * Method which gets the data from a specific element
     *
     * @param index of element to get
     * @return data of element to get
     */
    @Override
    public T get(int index) {
        int size = getSize();
        T data = null;

        if (index > 0 || index < size) {

            if (index == 0) {
                data = head.data;

            } else if (index == size - 1) {
                data = tail.data;

            } else if (index < size / 2) { //index is in the first half of the list
                Node searchNode = head;

                //move from head to tail with these two Nodes through the list to find the right spot
                for (int i = 0; i <= index; i++) {
                    searchNode = searchNode.next;
                }
                data = searchNode.data;

            } else if (index >= size / 2) { //index is in the first half of the list
                Node searchNode = tail;

                //move from head to tail with these two Nodes through the list to find the right spot
                for (int i = size - 1; i >= index; i--) {
                    searchNode = searchNode.prev;
                }
                data = searchNode.data;
            }

            return data;

        } else {
            throw new IndexOutOfBoundsException("Index bigger or smaller than size!");
        }
    }

    /**
     * Method which seems to clear the list by pointing the head and tail to null and thus making all listed element unreachable
     */
    @Override
    public void clear() {
        head = null;
        tail = null;
    }

    /**
     * Method which prints one element of the list
     *
     * @param index index of element to print
     */
    @Override
    public void print(int index) {
        System.out.println(get(index));
    }

    /**
     * Method to print all elements of a list
     */
    @Override
    public void printAll() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }


    /**
     * Method which gets the size of a list
     *
     * @return int number of elements in a list
     */
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

    /**
     * Method which prints the number of elements from a list
     */
    @Override
    public void printSize(){
        System.out.println("The number of elements in this list is: " + getSize());
    }

    @Override
    public T search(Searchable<T> searchable, Comparable<T> comparable) {
        return null;
    }

    @Override
    public void sort(Sortable<T> sortable, Comparable<T> comparable) {

    }
}
