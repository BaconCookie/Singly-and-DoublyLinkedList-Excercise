package comparator;

import data.Student;

/**
 * Created by laura on 20.12.16.
 */
public class StudentNumberComparator implements Comparable<Student> {
    @Override
    public int compare(Student student1, Student student2) {
        return student1.getStudentNumber() - student2.getStudentNumber();
    }
}