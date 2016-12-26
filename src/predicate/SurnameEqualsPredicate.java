package predicate;

import data.Student;

/**
 * Created by laura on 26.12.16.
 */

public class SurnameEqualsPredicate implements Predicate<Student> {
    private String testValue;

    public SurnameEqualsPredicate(String testValue) {
        this.testValue = testValue;
    }

    @Override
    public boolean test(Student student) {
        return student.getSurname().equals(testValue);
    }
}

