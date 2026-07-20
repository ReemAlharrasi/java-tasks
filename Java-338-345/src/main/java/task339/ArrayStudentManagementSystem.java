package task339;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayStudentManagementSystem {
    //initialize required variables
    ArrayList<String> studentNames = new ArrayList<String>();
    ArrayList<String> studentNamesSorted;
    String name;
    int index;
    int total;

    char firstLetter1;
    char firstLetter2;
    int code;

    //initialize scanner to read input
    Scanner in = new Scanner(System.in);

    //main
    void main() {
        //add names to student list
        studentNames.add("Reem");
        studentNames.add("Salwa");
        studentNames.add("Salima");
        studentNames.add("Jokha");
        studentNames.add("Shadha");
        studentNames.add("Intisar");
        studentNames.add("Mayyada");
        studentNames.add("Reem");
        studentNames.add("Taqwa");
        studentNames.add("Hidaya");

        //call functions
        //display students
        displayStudentInformation();

        //add student at the end of the list
        System.out.println("\n-----  Add New Student to the end of the list-----");
        System.out.print("Enter student name: ");
        name = in.next();
        addNewStudent(name);

        //add student at specific index
        System.out.println("\n-----  Add New Student at specific index -----");
        System.out.print("Enter student name: ");
        name = in.next();
        System.out.print("Enter index: ");
        index = in.nextInt();
        addNewStudent(name, index);

        //update student name
        updateStudent();

        //search a student
        searchStudent();

        //remove a student by name
        System.out.println("\n----- Remove Student System by name -----");
        System.out.print("Enter student name: ");
        name = in.next();
        removeStudent(name);

        //remove a student by index
        System.out.println("\n----- Remove Student System by index -----");
        System.out.print("Enter index: ");
        index = in.nextInt();
        removeStudent(index);

        //analysis
        studentAnalysis();

        //sorting list alphabetically
        sortingStudent();
    }

    //function to display all students
    public void displayStudentInformation() {
        System.out.println("\n----- Students information -----");
        System.out.println("Total number of Students: " + studentNames.size());

        //display each number with its index
        System.out.println("\nStudents -----");
        for (int i = 0; i < studentNames.size(); i++) {
            System.out.println("Student " + i + " = " + studentNames.get(i));//print number
        }
    }

    //two functions to add new student
    public void addNewStudent(String student) {
        studentNames.add(student);
        System.out.println("Updated list: " + studentNames.toString());
    }

    public void addNewStudent(String student, int i) { //overloading
        if (i < studentNames.size()) {
            studentNames.add(i, student);
            System.out.println("Updated list: " + studentNames.toString());
        } else System.out.println("index out of range");
    }

    //function to update student information
    public void updateStudent() {
        System.out.println("\n----- Update Student -----");
        System.out.print("Enter index: ");
        index = in.nextInt();
        if (index < studentNames.size()) {
            System.out.print("Enter new name: ");
            name = in.next();
            studentNames.set(index, name);
            System.out.println("Updated list: " + studentNames.toString());
        } else {
            System.out.println("index out of range");
        }
    }

    //function to search a student in the arraylist
    public void searchStudent() {
        System.out.println("\n----- Search Student System -----");
        System.out.print("Enter student name: ");
        name = in.next();
        index = studentNames.indexOf(name);
        if (index != -1) System.out.println("Student found at index " + index);
        else System.out.println("Student not found");
    }

    //functions to remove a student
    //by name
    public void removeStudent(String n) {
        if (studentNames.contains(n)) {
            studentNames.remove(n);
            System.out.println("Updated list: " + studentNames.toString());
        } else {
            System.out.println("Student not found");
        }
    }

    //by index
    public void removeStudent(int i) {
        if (i < studentNames.size()) {
            studentNames.remove(i);
            System.out.println("Updated list: " + studentNames.toString());
        } else {
            System.out.println("Index out of range");
        }
    }

    //function to analyze list
    public void studentAnalysis() {
        System.out.println("\n----- Student Analysis -----");
        total = studentNames.size();
        if (total == 0) System.out.println("List is empty");
        System.out.println("First student: " + studentNames.get(0));
        System.out.println("Last student: " + studentNames.get(total - 1));
    }

    //function to sort list
    public void sortingStudent() {
        System.out.println("\n----- Sorting alphabetically -----");

        //copy array
        studentNamesSorted = new ArrayList<String>(studentNames);

        for (int i = 0; i < studentNamesSorted.size(); i++) {
            for (int j = i + 1; j < studentNamesSorted.size(); j++) {

                //get the first character of two items to compare
                firstLetter1 = studentNamesSorted.get(i).charAt(0);
                firstLetter2 = studentNamesSorted.get(j).charAt(0);

                //compare and swap if smaller
                if ((int) firstLetter1 > (int) firstLetter2) {
                    //swap
                    name = studentNamesSorted.get(i);
                    studentNamesSorted.set(i, studentNamesSorted.get(j));
                    studentNamesSorted.set(j, name);
                }
            }
        }

        //display results
        System.out.println("original list: " + studentNames.toString());
        System.out.println("Sorted list: " + studentNamesSorted.toString());
    }
}
