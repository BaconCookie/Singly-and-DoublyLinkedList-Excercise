package programm;
import Data.Student;
import List.Listable;
import List.SinglyLinkedList;

public class Main {

    public static void main(String[] args) {

        Student s1 = new Student("Zen", "Buddy", 666777, 1);
        Student s2 = new Student("Weizer", "Anna", 890066, 0);
        Student s3 = new Student("Mueller", "Klaus", 334455, 1);

        Listable<Student> list = new SinglyLinkedList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.printAll();
    }
}
