package comparator;

import data.Student;

/**
 * Created by laura on 20.12.16.
 */
public class StudentNumberComparator implements Comparable<Student> {
    @Override
    public int compare(Student student1, Student student2) {
        System.out.println(student1.getStudentNumber() + " " + student2.getStudentNumber());
        int comp = Integer.compare(student1.getStudentNumber(), student2.getStudentNumber());
        return comp;
        //return student1.getStudentNumber() - student2.getStudentNumber();
    }
}