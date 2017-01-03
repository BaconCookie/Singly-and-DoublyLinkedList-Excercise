package comparator;

import data.Student;
import list.DegreeProgram;

import static org.junit.Assert.*;

/**
 * Created by laura on 03.01.17.
 */
public class SurnameComparatorTest {

    @org.junit.Test
    public void compareSame() throws Exception {
        Student s1 = new Student("Zen", "Buddy", 666777, DegreeProgram.GEEKY_STUFF, 8);
        Student s2 = new Student("Zen", "Buddy", 666777, DegreeProgram.GEEKY_STUFF, 8);

        Comparable comparable = new SurnameComparator();

        int expected = 0;

        assertEquals(expected, comparable.compare(s1, s2));

    }

    @org.junit.Test
    public void compareDifferent() throws Exception {
        Student s1 = new Student("Zen", "Buddy", 666777, DegreeProgram.GEEKY_STUFF, 8);
        Student s2 = new Student("Anna", "Wei", 890066, DegreeProgram.MATHEMATICS, 0);

        Comparable comparable = new SurnameComparator();

        comparable.compare(s1, s2);
    }
}