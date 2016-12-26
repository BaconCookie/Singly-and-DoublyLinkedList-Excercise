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
    private static final int LOWER_INDEX_BOUNDARY = 0;

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
        if (head == null) {
            addFirst(data);
        } else {
            Node newNode = new Node();
            newNode.data = data;

            Node lastNode = tail;
            lastNode.next = newNode;
            newNode.prev = lastNode;
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
            Node oldHead = this.head;
            this.head = newNode;
            newNode.next = oldHead;
            oldHead.prev = newNode;
        } else {
            int size = getSize();
            if (index > size) {
                throw new IndexOutOfBoundsException("Index bigger than size!");
            }
            if (index == size) {
                add(data);
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
        int upperIndexBoundary = getUpperIndexBoundary();

        if (index < LOWER_INDEX_BOUNDARY || index > upperIndexBoundary) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            head = head.next;

        } else if (index == upperIndexBoundary) {
            tail = tail.prev;
            tail.next = null; //just to be sure

        } else {
            Node nodeToRemove = naiveBinarySearch(index);
            Node previousNode = nodeToRemove.prev;
            Node nextNode = nodeToRemove.next;
            previousNode.next = nextNode;
            nextNode.prev = previousNode;
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
        int upperIndexBoundary = getUpperIndexBoundary();

        T data;

        if (index < LOWER_INDEX_BOUNDARY || index > upperIndexBoundary) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            data = head.data;

        } else if (index == upperIndexBoundary) {
            data = tail.data;

        } else {
            data = naiveBinarySearch(index).data;
        }

        return data;
    }

    private Node naiveBinarySearch(int index) {
        int upperIndexBoundary = getUpperIndexBoundary();
        Node searchNode;
        if (index < (upperIndexBoundary / 2)) { //index is in the first half of the list
            searchNode = head;

            //move from head to tail with these two Nodes through the list to find the right spot
            for (int i = 0; i < index; i++) {
                searchNode = searchNode.next;
            }

        } else { //index is in the first half of the list
            searchNode = tail;

            //move from head to tail with these two Nodes through the list to find the right spot
            for (int i = upperIndexBoundary; i > index; i--) {
                searchNode = searchNode.prev;
            }
        }
        return searchNode;
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

    private int getUpperIndexBoundary() {
        return getSize() - 1;
    }

    /**
     * Method which prints the number of elements from a list
     */
    @Override
    public void printSize() {
        System.out.println("The number of elements in this list is: " + getSize());
    }

    @Override
    public T search(Searchable<T> searchable, Comparable<T> comparable) {
        return searchable.search(this, comparable);
    }

    @Override
    public void sort(Sortable<T> sortable, Comparable<T> comparable) {
        sortable.sort(this, comparable);
    }
}
