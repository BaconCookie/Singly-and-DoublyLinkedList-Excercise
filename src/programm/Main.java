package programm;
import data.Student;
import list.DegreeProgram;
import list.DoublyLinkedList;
import list.Listable;
import list.SinglyLinkedList;

public class Main {

    public static void main(String[] args) {

        Student s1 = new Student("Zen", "Buddy", 666777, DegreeProgram.GEEKY_STUFF, 8);
        Student s2 = new Student("Wei", "Anna", 890066, DegreeProgram.MATHEMATICS, 0);
        Student s3 = new Student("Mueller", "Klaus", 334455, DegreeProgram.COMPUTER_SCIENCE,  1);
        Student s4 = new Student("Angela", "Moss", 111333, DegreeProgram.PROGRAMMING, 0);


        Listable<Student> list = new DoublyLinkedList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        list.printAll();
        System.out.println();

        Student s5 = new Student("Scientist", "Mad", 123456, DegreeProgram.ALGORITHMS,  1);


        list.insertAt(2, s5);
        list.printAll();
        System.out.println();

        list.remove(1);
        list.printAll();
        list.printSize();
    }
}
