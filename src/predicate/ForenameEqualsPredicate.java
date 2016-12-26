package predicate;

import data.Student;
/**
 * Created by laura on 26.12.16.
 */
public class ForenameEqualsPredicate implements Predicate<Student>{

    private String testValue;

    public ForenameEqualsPredicate(String testValue) {
        this.testValue = testValue;
    }

    @Override
    public boolean test(Student student) {
        return student.getPrename().equals(testValue);
    }
}