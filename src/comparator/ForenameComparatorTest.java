package comparator;

import data.Student;
import list.DegreeProgram;

import static org.junit.Assert.*;

/**
 * Created by laura on 23.12.16.
 */
public class ForenameComparatorTest {
    @org.junit.Before
    public void setUp() throws Exception {

    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @org.junit.Test
    public void compareSame() throws Exception {
        Student s1 = new Student("Zen", "Buddy", 666777, DegreeProgram.GEEKY_STUFF, 8);
        Student s2 = new Student("Zen", "Buddy", 666777, DegreeProgram.GEEKY_STUFF, 8);

        Comparable comparable = new ForenameComparator();

        int expected = 0;

        assertEquals(expected, comparable.compare(s1, s2));

    }

    @org.junit.Test
    public void compareDifferent() throws Exception {
        Student s1 = new Student("Zen", "Buddy", 666777, DegreeProgram.GEEKY_STUFF, 8);
        Student s2 = new Student("Anna", "Wei", 890066, DegreeProgram.MATHEMATICS, 0);
    }
}