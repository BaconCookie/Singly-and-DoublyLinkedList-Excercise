package predicate;

import data.Student;

/**
 * Created by laura on 26.12.16.
 */
public class GenderEqualsPredicate implements  Predicate<Student>{

    private int testValue;

    public GenderEqualsPredicate(int testValue) {
        this.testValue = testValue;
    }

    @Override
    public boolean test(Student student) {
        return (student.getGender() == testValue);
    }
}