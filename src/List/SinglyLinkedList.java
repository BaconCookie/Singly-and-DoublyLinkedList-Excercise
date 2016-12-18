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


    /**
     * Method to add an element to the List
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
        if (newNode == null) {
            throw new IllegalArgumentException("New Node is null!");
        }
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
            head.next = head;
        } else {
            int size = getSize();
            if (index > size - 1 || index < 0) {
                throw new IndexOutOfBoundsException("Index bigger or smaller than size!");
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
        int size = getSize();
        T data = null;

        if (index > 0 || index < size) {
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

        } else {
            throw new IndexOutOfBoundsException("Index bigger or smaller than size!");
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
     * Method which prints the number of elements
     */
    @Override
    public void printSize(){
        System.out.println("The number of elements in this list is: " + getSize());
    }
}

