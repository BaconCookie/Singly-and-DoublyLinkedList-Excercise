package list;

import data.Student;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

/**
 * Created by laura on 25.12.16.
 */
public class SinglyLinkedListTest {

    private Student s1;
    private Student s2;
    private Student s3;
    private Student s4;
    private Student s5;
    private Student s6;
    private Student s7;
    private Student s8;
    private SinglyLinkedList<Student> singlyLinkedList;

    /**
     * A new singlyLinkedList is initialized and filled with Students s1, s2, s3, s4, s5, s6 and s7.
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

        singlyLinkedList = new SinglyLinkedList<>();

        singlyLinkedList.add(s1);
        singlyLinkedList.add(s2);
        singlyLinkedList.add(s3);
        singlyLinkedList.add(s4);
        singlyLinkedList.add(s5);
        singlyLinkedList.add(s6);
        singlyLinkedList.add(s7);
    }

    @Test
    public void testAddForEmptyList() throws Exception {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        Student studentTest = s1;
        int expectedSize = 1;
        Student expectedStudent = studentTest;

        singlyLinkedList.add(studentTest);

        assertEquals(expectedSize, singlyLinkedList.getSize());
        assertEquals(expectedStudent, singlyLinkedList.get(0));
    }

    @Test
    public void testAddForNonEmptyList() throws Exception {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();

        int expectedSize = 3;

        singlyLinkedList.add(s1);
        singlyLinkedList.add(s2);
        singlyLinkedList.add(s3);

        assertEquals(expectedSize, singlyLinkedList.getSize());
        assertEquals(s1, singlyLinkedList.get(0));
        assertEquals(s2, singlyLinkedList.get(1));
        assertEquals(s3, singlyLinkedList.get(2));
    }

    @Test
    public void testAddFirst() throws Exception {

        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        Student studentTest = s1;
        int expectedSize = 1;
        Student expectedStudent = studentTest;

        singlyLinkedList.addFirst(studentTest);

        assertEquals(expectedSize, singlyLinkedList.getSize());
        assertEquals(expectedStudent, singlyLinkedList.get(0));
    }

    @Test
    public void testInsertAtFirst() throws Exception {

        singlyLinkedList.insertAt(0, s8);

        assertEquals(s8, singlyLinkedList.get(0));

    }

    @Test
    public void testInsertAtNth() throws Exception {

        singlyLinkedList.insertAt(3, s8);

        assertEquals(s8, singlyLinkedList.get(3));

    }

    @Test
    public void testInsertAtLast() throws Exception {

        singlyLinkedList.insertAt(7, s8);

        assertEquals(s8, singlyLinkedList.get(7));
    }


    @Test
    public void testRemove() throws Exception {

        singlyLinkedList.remove(2);

        assertEquals(6, singlyLinkedList.getSize());
        assertEquals(s2, singlyLinkedList.get(1));
        assertEquals(s4, singlyLinkedList.get(2));
    }

    @Test
    public void testGetFirst() throws Exception {

        assertEquals(s1, singlyLinkedList.get(0));
    }

    @Test
    public void testGetNth() throws Exception {

        //test 3 examples from list
        assertEquals(s2, singlyLinkedList.get(1));
        assertEquals(s3, singlyLinkedList.get(2));
        assertEquals(s6, singlyLinkedList.get(5));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetOutOfUpperBound() throws Exception {

        int tooLargeIndex = 99;
        singlyLinkedList.get(tooLargeIndex);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetOutOfLowerBound() throws Exception {

        int tooSmallIndex = -1;
        singlyLinkedList.get(tooSmallIndex);
    }

    @Test
    public void testGetLast() throws Exception {

        assertEquals(s7, singlyLinkedList.get(6));
    }

    @Test
    public void testClear() throws Exception {

        singlyLinkedList.clear();

        assertEquals(0, singlyLinkedList.getSize());
    }

    @Test
    public void testGetSize() throws Exception {

        SinglyLinkedList<Student> singlyLinkedList = new SinglyLinkedList<>();

        int expectedSize = 4;

        singlyLinkedList.add(s1);
        singlyLinkedList.add(s2);
        singlyLinkedList.add(s3);
        singlyLinkedList.add(s4);

        assertEquals(expectedSize, singlyLinkedList.getSize());
    }

    @Test
    public void testPrintSize() throws Exception {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream out = System.out;
        System.setOut(new PrintStream(baos));
        baos.flush();
        singlyLinkedList.printSize();
        String s = baos.toString();
        System.setOut(out);

        String expectedSizeString = "The number of elements in this list is: 7\n";
        assertEquals(expectedSizeString, s);
    }


}

