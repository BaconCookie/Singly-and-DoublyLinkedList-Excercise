package controller;

import Prog1Tools.IOTools;
import comparator.Comparable;
import comparator.*;
import data.Student;
import list.DegreeProgram;
import list.DoublyLinkedList;
import list.Listable;
import list.SinglyLinkedList;
import list.search.LinearSearch;
import list.search.Searchable;
import list.sort.BubbleSort;
import list.sort.SelectionSort;
import list.sort.Sortable;
import predicate.*;

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
    private Comparable comparable;

    private Searchable searchable;
    private Predicate predicate;


    public Controller() {
    }

    public void runLists() {
        action = 100;
        chooseKindOfList();
        while (action != 0) {
            switch (action) {
                case 1:
                    list.addFirst(userInputStudent());
                    break;
                case 2:
                    list.add(userInputStudent());
                    break;
                case 3:
                    userInsertsAt();
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
                case 8:
                    userSearchesInList();
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
        } else if (whichKindOfList == 2) {
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

    /**
     * Method to make it possible for the user to put in a student
     *
     * @return student which corresponds with the user input
     */
    private Student userInputStudent() {
        String forename = pickName("Forename of student: ");
        String surname = pickName("Surname of student: ");
        int studentNumber = pickStudentNumber("Student Number of student: ");
        DegreeProgram degreeProgram = pickDegreeProgram();
        int gender = pickGender("Gender (as integer) of student: ");

        Student student = new Student(forename, surname, studentNumber, degreeProgram, gender);
        return student;
    }

    private String pickName(String s) {
        return readString(s);
    }

    private int pickStudentNumber(String s) {
        return readInteger(s);
    }

    /**
     * Method which takes care of the Degree Program input
     * reads input as string, which is being converted to enum (if available)
     *
     * @return degreeProgram which is available and typed in command line
     */
    private DegreeProgram pickDegreeProgram() {
        try {
            System.out.println("Pick the Degree Program: ");
            System.out.println("ALGORITHMS, COMPUTER_SCIENCE, GEEKY_STUFF, MATHEMATICS, PROGRAMMING");
            DegreeProgram degreeProgram = DegreeProgram.valueOf(pickName("Your pick: ").toUpperCase());
            return degreeProgram;
        } catch (IllegalArgumentException exception) {
            return pickDegreeProgram();
        }
    }

    private int pickGender(String s) {
        return readInteger(s);
    }

    private Listable userInsertsAt() {
        try {
            int index = readInteger("At which index (integer, list starts with 0) do you wish to insert?: ");
            list.insertAt(index, userInputStudent());
            return list;
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("Index out of bounds, try again!");
            return userInsertsAt();
        }
    }

    private Listable userRemovesAt() {
        try {
            int index = readInteger("Which Student (index integer, list starts with 0) do you wish to remove?: ");
            list.remove(index);
            return list;
        } catch (IndexOutOfBoundsException exception) {
            System.out.println("Index out of bounds, try again!");
            return userRemovesAt();
        }
    }

    private void userPrintsStudent() {
        try {
            int index = readInteger("Which Student (index integer, list starts with 0) do you wish to print?: ");
            list.print(index);
        } catch (IndexOutOfBoundsException exception) {
            System.out.println("Index out of bounds, try again!");
            userPrintsStudent();
        }
    }

    private void userSearchesInList() {
        try {
            Searchable searchable = new LinearSearch();
            userChoosesPredicate();
            Student student = list.search(searchable, predicate);
            System.out.println(student);
        } catch (Exception exception) {
            System.out.println("Oops! Something went wrong!");
        }
    }

    private Predicate userChoosesPredicate() {
        System.out.println("For searching by Forename:       pick 1");
        System.out.println("              by Surname:        pick 2");
        System.out.println("              by Student Number: pick 3");
        System.out.println("              by Degree Program: pick 4");
        System.out.println("              by Gender:         pick 5");
        int pickPredicate = readInteger("your pick: ");

        if (pickPredicate == 1) {
            predicate = new ForenameEqualsPredicate(pickName("Forename of student: "));
        } else if (pickPredicate == 2) {
            predicate = new SurnameEqualsPredicate(pickName("Surname of student: "));
        } else if (pickPredicate == 3) {
            predicate = new StudentNumberEqualsPredicate(pickStudentNumber("Student Number of student: "));
        } else if (pickPredicate == 4) {
            predicate = new DegreeProgramEqualsPredicate(pickDegreeProgram());
        } else if (pickPredicate == 5) {
            predicate = new GenderEqualsPredicate(pickGender("Gender (as integer) of student: "));
        } else {
            userChoosesPredicate();
        }
        return predicate;
    }

    private Listable userSortsList() {
        try {
            userChoosesSortable();
            userChoosesComparable();
            list.sort(sortable, comparable);
            return list;
        } catch (Exception exception) {
            System.out.println("Oops! Something went wrong! Try again.");
            return userSortsList();
        }
    }

    private Sortable userChoosesSortable() {
        int pickSortable = readInteger("For SelectionSort pick 1, for BubbleSort pick 2: ");
        if (pickSortable == 1) {
            sortable = new SelectionSort<>();
        } else if (pickSortable == 2) {
            sortable = new BubbleSort<>();
        } else {
            userChoosesSortable();
        }
        return sortable;
    }

    private Comparable userChoosesComparable() {
        System.out.println("For comparison by Forename:        pick 1");
        System.out.println("by                Surname:         pick 2");
        System.out.println("by                Student Number:  pick 3");
        System.out.println("by                Degree Program:  pick 4");
        System.out.println("by                Gender:          pick 5");
        int pickComparable = readInteger("your pick: ");
        if (pickComparable == 1) {
            comparable = new ForenameComparator();
        } else if (pickComparable == 2) {
            comparable = new SurnameComparator();
        } else if (pickComparable == 3) {
            comparable = new StudentNumberComparator();
        } else if (pickComparable == 4) {
            comparable = new DegreeProgramComparator();
        } else if (pickComparable == 5) {
            comparable = new GenderComparator();
        } else {
            userChoosesComparable();
        }
        return comparable;
    }

}
