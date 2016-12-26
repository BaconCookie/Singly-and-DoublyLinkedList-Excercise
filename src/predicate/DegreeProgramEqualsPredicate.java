package predicate;

import data.Student;
import list.DegreeProgram;

/**
 * Created by laura on 26.12.16.
 */
public class DegreeProgramEqualsPredicate implements Predicate<Student>{

    private DegreeProgram testValue;

    public DegreeProgramEqualsPredicate(DegreeProgram testValue) {
        this.testValue = testValue;
    }

    @Override
    public boolean test(Student student) {
        return student.getDegreeProgram().equals(testValue);
    }
}
