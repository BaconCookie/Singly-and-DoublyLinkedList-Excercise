package comparator;

import data.Student;

/**
 * Created by laura on 26.12.16.
 */
public class SurnameComparator implements Comparable<Student> {
    @Override
    public int compare(Student student1, Student student2) {
        if (student1.getSurname() == null && student2.getSurname() == null) {
            return 0;
        } else if (student2.getSurname() == null) { //student2 is null, so smaller
            return -1;
        } else if (student1.getSurname() == null) { //student1 is null, so smaller
            return 1;
        } else {
            return student1.getSurname().compareTo(student2.getSurname()); //compareTo Method compares two strings and returns an int

        }
    }
}
