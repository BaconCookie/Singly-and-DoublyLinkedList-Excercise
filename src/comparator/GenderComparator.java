package comparator;

import data.Student;

/**
 * Created by laura on 26.12.16.
 */
public class GenderComparator implements Comparable<Student> {

    @Override
    public int compare(Student student1, Student student2) {
        return student1.getGender() - student2.getGender();
    }
}

