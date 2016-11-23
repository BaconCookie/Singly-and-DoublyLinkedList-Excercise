package programm;
import Data.Student;
import List.Listable;
import List.SinglyLinkedList;

public class Main {

    public static void main(String[] args) {

        Student s1 = new Student("Zen", "Buddy", 666777, "Zen Buddhism", 8);
        Student s2 = new Student("Weizer", "Anna", 890066, "Mathematics", 0);
        Student s3 = new Student("Mueller", "Klaus", 334455, "Computer Science and NLP",  1);

        Listable<Student> list = new SinglyLinkedList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.printAll();
        System.out.println();

        Student s4 = new Student("Angela", "Moss", 111333, "Evil", 0);

        list.insertAt(2, s4);
        list.printAll();
    }
}
