package comparator;

import data.Student;

/**
 * Created by laura on 18.12.16.
 */

public class ForenameComparator implements Comparable<Student> {
    @Override
    public int compare(Student student1, Student student2) {
        if (student1.getPrename() == null && student2.getPrename() == null) {
            return 0;
        } else if (student2.getPrename() == null) { //student2 is null, so smaller
            return -1;
        } else if (student1.getPrename() == null) { //student1 is null, so smaller
            return 1;
        } else {
            return student1.getPrename().compareTo(student2.getPrename()); //compareTo Method compares two strings and returns an int
        }
    }
}
