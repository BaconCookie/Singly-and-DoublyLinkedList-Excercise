package controller;

import Prog1Tools.IOTools;
import comparator.Comparable;
import comparator.*;
import data.Student;
import list.DegreeProgram;
import list.DoublyLinkedList;
import list.Listable;
import list.SinglyLinkedList;
import list.sort.BubbleSort;
import list.sort.SelectionSort;
import list.sort.Sortable;

import static Prog1Tools.IOTools.readInteger;
import static Prog1Tools.IOTools.readString;

/**
 * Created by laura on 03.01.17.
 */
public class Controller {

    private int action;
    private int whichKindOfList;
    private Listable<Student> list;

    private Sortable<Student> sortable;
    private Comparable comparable = new DegreeProgramComparator();


    public Controller() {
    }

    public void runLists() {
        action = 1;
        while (action != 0) {
            chooseKindOfList();
            switch (action) {
                case 1:
                    list.addFirst(userInputStudent());
                    break;
                case 2:
                    list.add(userInputStudent());
                    break;
                case 3:
                    userInstertsAt();
                    break;
                case 4:
                    userRemovesAt();
                    break;
                case 5:
                    userPrintsStudent();
                    break;
                case 6:
                    list.printAll();
                    break;
                case 7:
                    list.printSize();
                    break;
                case 8: //search
                    break;
                case 9:
                    userSortsList();
                    list.printAll();
                    break;
                case 10:
                    list.clear();
                    break;
                case 0:
                    System.exit(0);
                    break;
            }
            showMenu();
        }
    }

    /**
     * Choose if the list will be a SinglyLinkedList or a DoublyLinkedList
     *
     * @return new list from the chosen kind
     */
    private Listable chooseKindOfList() {
        whichKindOfList = readInteger("Type a '1' for SinglyLinkedList, type a '2' for DoublyLinkedList: ");
        if (whichKindOfList == 1) {
            list = new SinglyLinkedList<>();
        }
        if (whichKindOfList == 2) {
            list = new DoublyLinkedList<>();
        } else {
            chooseKindOfList();
        }
        return list;
    }

    /**
     * Method which shows the user menu
     */
    private void showMenu() {
        System.out.println();
        System.out.println("--> Please pick one option: <--");
        System.out.println(" 1   Add a student as first element");
        System.out.println(" 2   Add a student as last element");
        System.out.println(" 3   Insert a student at a certain index in the list");
        System.out.println(" 4   Remove a student from the list");
        System.out.println(" 5   Print one single student");
        System.out.println(" 6   Print all students from the list");
        System.out.println(" 7   Print the size of the list");
        System.out.println(" 8   Search for a student");
        System.out.println(" 9   Sort the list");
        System.out.println(" 10  Clear the List");
        System.out.println(" 0   Exit");
        System.out.println("Your pick: ");
        action = IOTools.readInteger();
    }

    private Student userInputStudent() {
        String prename = readString("Prename of student: ");
        String surname = readString("Surname of student: ");
        int studentNumber = readInteger("Student Number of student: ");
        System.out.println("Pick the Degree Program: ");
        System.out.println("ALGORITHMS, COMPUTER_SCIENCE, GEEKY_STUFF, MATHEMATICS, PROGRAMMING");
        DegreeProgram degreeProgram = DegreeProgram.valueOf(readString("Your pick: "));
        int gender = readInteger("Gender (as integer) of student: ");
        ;

        Student student = new Student(prename, surname, studentNumber, degreeProgram, gender);
        return student;
    }

    private Listable userInstertsAt() {
        int index = readInteger("At which index (integer, list starts with 0) do you wish to insert?: ");
        list.insertAt(index, userInputStudent());
        return list;
    }

    private Listable userRemovesAt() {
        int index = readInteger("Which Student (index integer, list starts with 0) do you wish to remove?: ");
        list.remove(index);
        return list;
    }

    private void userPrintsStudent() {
        int index = readInteger("Which Student (index integer, list starts with 0) do you wish to print?: ");
        list.print(index);
    }

    private Listable userSortsList() {
        userChoosesSortable();

        list.sort(sortable, comparable);
        return list;
    }

    private Sortable userChoosesSortable() {
        int pickSortable = readInteger("For SelectionSort pick 1, for BubbleSort pick 2: ");
        if (pickSortable == 1) {
            sortable = new SelectionSort<>();
        }
        if (pickSortable == 2) {
            sortable = new BubbleSort<>();
        } else {
            userChoosesSortable();
        }
        return sortable;
    }

    private Comparable userChoosesComparable() {
        System.out.println("For comparison by Forename pick 1");
        System.out.println("by Surname pick 2");
        System.out.println("by Student Number pick 3");
        System.out.println("by Degree Program pick 4");
        System.out.println("by Gender pick 5");
        int pickComparable = readInteger("your pick: ");
        if (pickComparable == 1) {
            comparable = new ForenameComparator();
        }
        if (pickComparable == 2) {
            comparable = new SurnameComparator();
        }
        if (pickComparable == 3) {
            comparable = new StudentNumberComparator();
        }
        if (pickComparable == 4) {
            comparable = new DegreeProgramComparator();
        }
        if (pickComparable == 5) {
            comparable = new GenderComparator();
        } else {
            userChoosesComparable();
        }
        return comparable;
    }

}
