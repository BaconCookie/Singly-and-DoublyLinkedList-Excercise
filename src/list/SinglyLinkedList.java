package list;

import comparator.Comparable;
import list.search.Searchable;
import list.sort.Sortable;
import predicate.Predicate;

/**
 * Created by laura on 25.10.16.
 */
public class SinglyLinkedList<T> implements Listable<T> {

    private Node head;
    private static final int LOWER_INDEX_BOUNDARY = 0;


    private class Node {
        T data;
        Node next;
    }


    /**
     * Method to add an element to the list
     * (at the end if there are elements present)
     *
     * @param data data content of the new element
     */
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

        if (getSize() == 0) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
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
        int previousIndex = index - 1;

        if (index == 0) {
            addFirst(data);
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
                // Update link of the "previous" node, to point to the new node.
                // Update link of the new node, to point to the "next" node.
                temp = previousNode.next;
                previousNode.next = newNode;
                newNode.next = temp;
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
        if (index == 0) {
            head = head.next;
        } else {
            int upperIndexBoundary = getUpperIndexBoundary();

            if (index < LOWER_INDEX_BOUNDARY || index > upperIndexBoundary) {
                throw new IndexOutOfBoundsException();
            } else {
                int previousIndex = index - 1;
                Node previousNode = head;
                Node nextNode = head;

                for (int i = 0; i < previousIndex; i++) {
                    previousNode = previousNode.next;
                    nextNode = nextNode.next;
                }
                //move the next Node to its own spot (index + 1)
                nextNode = nextNode.next;
                nextNode = nextNode.next;
                //point with previous Node to the new next Node and, as a result;
                // forget about the Node to remove
                previousNode.next = nextNode;
            }
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
        int lowerIndexBoundary = 0;

        T data = null;

        if (index < lowerIndexBoundary || index > upperIndexBoundary) {
            throw new IndexOutOfBoundsException();
        } else {
            int count = 0;
            Node searchNode = head;
            while (searchNode != null) {
                if (count == index) {
                    data = searchNode.data;
                }
                count++;
                searchNode = searchNode.next;
            }
            return data;
        }
    }


    /**
     * Method which seems to clear the list by pointing the head to null and thus making all listed element unreachable
     */
    @Override
    public void clear() {
        head = null;
    }

    /**
     * Method which prints one element of the list
     *
     * @param index index of element to print
     */
    @Override
    public void print(int index) {
        int upperIndexBoundary = getUpperIndexBoundary();
        int lowerIndexBoundary = 0;

        if (index < lowerIndexBoundary || index > upperIndexBoundary) {
            throw new IndexOutOfBoundsException();
        } else {
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
    public void printSize() {
        System.out.println("The number of elements in this list is: " + getSize());
    }

    private int getUpperIndexBoundary() {
        return getSize() - 1;
    }

    @Override
    public T search(Searchable<T> searchable, Predicate<T> predicate) {
        return searchable.search(this, predicate);
    }

    @Override
    public void sort(Sortable<T> sortable, Comparable<T> comparable) {
        sortable.sort(this, comparable);
    }
}

