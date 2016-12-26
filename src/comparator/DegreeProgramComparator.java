package comparator;

import data.Student;

import list.DegreeProgram;

/**
 * Created by laura on 26.12.16.
 */
public class DegreeProgramComparator implements Comparable<Student>{

    @Override
    public int compare(Student student1, Student student2) {
        if (student1.getDegreeProgram() == null && student2.getDegreeProgram() == null) {
            return 0;
        } else if (student2.getDegreeProgram() == null) {
            return -1;
        } else if (student1.getDegreeProgram() == null) {
            return 1;
        } else {
            return student1.getDegreeProgram().compareTo(student2.getDegreeProgram());
        }
    }
}