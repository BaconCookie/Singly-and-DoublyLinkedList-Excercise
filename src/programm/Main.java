package programm;
import Data.Student;
import List.DegreeProgram;
import List.Listable;
import List.SinglyLinkedList;

public class Main {

    public static void main(String[] args) {

        Student s1 = new Student("Zen", "Buddy", 666777, DegreeProgram.GEEKY_STUFF, 8);
        Student s2 = new Student("Wei", "Anna", 890066, DegreeProgram.MATHEMATICS, 0);
        Student s3 = new Student("Mueller", "Klaus", 334455, DegreeProgram.COMPUTER_SCIENCE,  1);

        Listable<Student> list = new SinglyLinkedList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.printAll();
        System.out.println();

        Student s4 = new Student("Angela", "Moss", 111333, DegreeProgram.PROGRAMMING, 0);

        list.insertAt(2, s4);
        list.printAll();
        System.out.println();

        list.remove(1);
        list.printAll();
    }
}
