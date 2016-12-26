package list;

import data.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

/**
 * Created by laura on 25.12.16.
 */
public class DoublyLinkedListTest {

    private Student s1;
    private Student s2;
    private Student s3;
    private Student s4;
    private Student s5;
    private Student s6;
    private Student s7;
    private Student s8;
    private DoublyLinkedList<Student> doublyLinkedList;

    /**
     * A new doublyLinkedList is initialized and filled with Students s1, s2, s3, s4, s5, s6 and s7.
     * Student s8 is an extra Student, for example to test the insertAt method.
     */
    @Before
    public void setUp() throws Exception {

        s1 = new Student("Zen", "Buddy", 666777, DegreeProgram.GEEKY_STUFF, 8);
        s2 = new Student("Anna", "Wei", 890066, DegreeProgram.MATHEMATICS, 0);
        s3 = new Student("Klaus", "Mueller", 334455, DegreeProgram.COMPUTER_SCIENCE, 1);
        s4 = new Student("Angela", "Moss", 111333, DegreeProgram.PROGRAMMING, 0);
        s5 = new Student("Tobi", "Rose", 789543, DegreeProgram.PROGRAMMING, 1);
        s6 = new Student("Peter", "Jan-Hans-Frederik", 123678, DegreeProgram.GEEKY_STUFF, 1);
        s7 = new Student("John", "Blue", 432675, DegreeProgram.ALGORITHMS, 1);
        s8 = new Student("Freddy", "X", 114589, DegreeProgram.COMPUTER_SCIENCE, 1);

        doublyLinkedList = new DoublyLinkedList<>();

        doublyLinkedList.add(s1);
        doublyLinkedList.add(s2);
        doublyLinkedList.add(s3);
        doublyLinkedList.add(s4);
        doublyLinkedList.add(s5);
        doublyLinkedList.add(s6);
        doublyLinkedList.add(s7);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testAddForEmptyList() throws Exception {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        Student studentTest = s1;
        int expectedSize = 1;
        Student expectedStudent = studentTest;

        doublyLinkedList.add(studentTest);

        assertEquals(expectedSize, doublyLinkedList.getSize());
        assertEquals(expectedStudent, doublyLinkedList.get(0));
    }

    @Test
    public void testAddForNonEmptyList() throws Exception {
        DoublyLinkedList<Student> doublyLinkedList = new DoublyLinkedList<>();

        int expectedSize = 3;

        doublyLinkedList.add(s1);
        doublyLinkedList.add(s2);
        doublyLinkedList.add(s3);

        assertEquals(expectedSize, doublyLinkedList.getSize());
        assertEquals(s1, doublyLinkedList.get(0));
        assertEquals(s2, doublyLinkedList.get(1));
        assertEquals(s3, doublyLinkedList.get(2));
    }

    @Test
    public void testAddFirst() throws Exception {

        DoublyLinkedList<Student> doublyLinkedList = new DoublyLinkedList<>();
        Student studentTest = s1;
        int expectedSize = 1;
        Student expectedStudent = studentTest;

        doublyLinkedList.addFirst(studentTest);

        assertEquals(expectedSize, doublyLinkedList.getSize());
        assertEquals(expectedStudent, doublyLinkedList.get(0));

        /*
        DoublyLinkedList expectedList = mock(DoublyLinkedList.class);
        when(expectedList.getSize()).thenReturn(1);
        when(expectedList.get(0)).thenReturn(studentTest);
        */
    }

    @Test
    public void testInsertAtFirst() throws Exception {

        doublyLinkedList.insertAt(0, s8);

        assertEquals(s8, doublyLinkedList.get(0));

    }

    @Test
    public void testInsertAtNth() throws Exception {

        doublyLinkedList.insertAt(3, s8);

        assertEquals(s8, doublyLinkedList.get(3));

    }

    @Test
    public void testInsertAtLast() throws Exception {

        doublyLinkedList.insertAt(7, s8);

        assertEquals(s8, doublyLinkedList.get(7));
    }

    @Test
    public void remove() throws Exception {

        doublyLinkedList.remove(2);

        assertEquals(6, doublyLinkedList.getSize());
        assertEquals(s2, doublyLinkedList.get(1));
        assertEquals(s4, doublyLinkedList.get(2));
    }

    @Test
    public void testGetFirst() throws Exception {

        assertEquals(s1, doublyLinkedList.get(0));
    }

    @Test
    public void testGetNth() throws Exception {

        assertEquals(s2, doublyLinkedList.get(1));
        assertEquals(s3, doublyLinkedList.get(2));
        assertEquals(s6, doublyLinkedList.get(5));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetOutOfUpperBound() throws Exception {

        int tooLargeIndex = 99;
        doublyLinkedList.get(tooLargeIndex);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetOutOfLowerBound() throws Exception {

        int tooSmallIndex = -1;
        doublyLinkedList.get(tooSmallIndex);
    }

    @Test
    public void testGetLast() throws Exception {

        assertEquals(s7, doublyLinkedList.get(6));
    }

    @Test
    public void testClear() throws Exception {

        doublyLinkedList.clear();

        assertEquals(0, doublyLinkedList.getSize());
    }

    @Test
    public void print() throws Exception {

    }

    @Test
    public void printAll() throws Exception {

    }

    @Test
    public void testGetSize() throws Exception {

        DoublyLinkedList<Student> doublyLinkedList = new DoublyLinkedList<>();

        int expectedSize = 4;

        doublyLinkedList.add(s1);
        doublyLinkedList.add(s2);
        doublyLinkedList.add(s3);
        doublyLinkedList.add(s4);

        assertEquals(expectedSize, doublyLinkedList.getSize());
    }

    @Test
    public void testPrintSize() throws Exception {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream out = System.out;
        System.setOut(new PrintStream(baos));
        baos.flush();
        doublyLinkedList.printSize();
        String s = baos.toString();
        System.setOut(out);

        String expectedSizeString = "The number of elements in this list is: 7\n";
        assertEquals(expectedSizeString, s);
    }

    @Test
    public void search() throws Exception {

    }

    @Test
    public void sort() throws Exception {

    }

}