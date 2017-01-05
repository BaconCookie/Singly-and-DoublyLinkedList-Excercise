package comparator;

import data.Student;

import list.DegreeProgram;

/**
 * Created by laura on 26.12.16.
 */
public class DegreeProgramComparator implements Comparable<Student>{

    @Override
    public int compare(Student student1, Student student2) {
       return student1.getDegreeProgram().ordinal() - student2.getDegreeProgram().ordinal();
    }
}