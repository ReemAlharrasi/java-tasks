package task372;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class StudentRegistrationManager {
    //initialize scanner
    Scanner in = new Scanner(System.in);

    //declare required variables
    Queue<String> waitingStudents = new LinkedList<>();
    Stack<String> registeredStudents = new Stack<>();
    int size, choice;
    String name;

    //main function
    void main() {
        //Prompt the user to enter the number of students
        System.out.print("Enter the number of students waiting for registration: ");
        size = in.nextInt();

        //validate input
        if (size <= 0) {
            System.out.println("Invalid number of students.");
        } else {
            //get input
            for (int i = 0; i < size; i++) {
                System.out.print((i + 1) + "- Enter student name: ");
                name = in.next();
                waitingStudents.add(name); //add student to queue
            }

            //menu
            choice = 0;
            do {
                //print menu
                System.out.println("\n===== MENU =====");
                System.out.println("1. Add Student to Queue");
                System.out.println("2. Process Student Registration");
                System.out.println("3. View Next Student");
                System.out.println("4. Undo Last Registration");
                System.out.println("5. Search Student");
                System.out.println("6. Display Waiting Students");
                System.out.println("7. Display Registered Students");
                System.out.println("8. Display Statistics");
                System.out.println("9. Exit");
                System.out.print("Enter choice: ");
                choice = in.nextInt();

                switch (choice) {
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        processStudentRegistration();
                        break;
                    case 3:
                        viewNextStudent();
                        break;
                    case 4:
                        undoLastRegistration();
                        break;
                    case 5:
                        searchStudent();
                        break;
                    case 6:
                        displayWaitingStudents();
                        break;
                    case 7:
                        displayRegisteredStudents();
                        break;
                    case 8:
                        displayStatistics();
                        break;
                    case 9:
                        System.out.println("\nGoodBye~");
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }

            } while (choice != 9);
        }

        //close scanner
        in.close();
    }

    //Add Student
    public void addStudent() {
        System.out.println("\nAdd Student -----");
        System.out.print("Enter student name: ");
        name = in.next();
        waitingStudents.add(name); //add student to queue
        System.out.println("Student added to registration queue successfully.");
    }

    //Process Student Registration
    public void processStudentRegistration() {
        System.out.println("\nProcess Student Registration -----");

        if (waitingStudents.isEmpty()) {
            System.out.println("No students waiting for registration.");
        } else {
            name = waitingStudents.remove(); //remove from queue
            registeredStudents.push(name); //add to stack
            System.out.println("Student registration completed.");
        }
    }

    //View Next Student
    public void viewNextStudent() {
        System.out.println("\nView Next Student -----");

        if (waitingStudents.isEmpty()) {
            System.out.println("No students in the queue.");
        } else {
            System.out.println("Next student: [" + waitingStudents.element() + "]");
        }
    }

    //Undo Last Registration
    public void undoLastRegistration() {
        System.out.println("\nUndo Last Registration -----");

        if (registeredStudents.isEmpty()) {
            System.out.println("No registrations to undo.");
        } else {
            name = registeredStudents.pop(); //remove last registered student
            waitingStudents.add(name); //return name to queue
            System.out.println("Removed student: [" + name + "]");
        }
    }

    //Search Student
    public void searchStudent() {
        System.out.println("\nSearch Student -----");
        System.out.print("Enter student name: ");
        name = in.next();

        if (waitingStudents.contains(name)) {
            System.out.println("Student is waiting for registration.");
        } else if (registeredStudents.search(name) != -1) {
            System.out.println("Student is already registered.");
        } else {
            System.out.println("Student not found.");
        }
    }

    //Display Waiting Students
    public void displayWaitingStudents() {
        System.out.println("\nDisplay Waiting Students -----");

        if (waitingStudents.isEmpty()) {
            System.out.println("No waiting students.");
        } else {
            int i = 1;
            for (String student : waitingStudents) {
                System.out.println(i + "- " + student);
                i++;
            }
        }
    }

    //Display Registered Students
    public void displayRegisteredStudents() {
        System.out.println("\nDisplay Registered Students -----");

        if (registeredStudents.isEmpty()) {
            System.out.println("No registered students.");
        } else {
            int i = 1;
            for (String student : registeredStudents) {
                System.out.println(i + "- " + student);
                i++;
            }
        }
    }

    //Display Statistics
    public void displayStatistics() {
        System.out.println("\nDisplay Statistics -----");

        System.out.println("Total waiting students: " + waitingStudents.size());
        System.out.println("Total registered students: " + registeredStudents.size());

        if (waitingStudents.isEmpty()) {
            System.out.println("Next student waiting: None");
        } else {
            System.out.println("Next student waiting: " + waitingStudents.element());
        }

        if (registeredStudents.isEmpty()) {
            System.out.println("Last registered student: None");
        } else {
            System.out.println("Last registered student: " + registeredStudents.peek());
        }

        System.out.println("Queue is empty? " + waitingStudents.isEmpty());
        System.out.println("Stack is empty? " + registeredStudents.isEmpty());
    }
}