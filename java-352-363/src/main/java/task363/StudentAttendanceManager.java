package task363;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentAttendanceManager {

    //declare variables
    HashMap<Integer, Integer> studentAttendance = new HashMap<Integer, Integer>();
    Scanner in = new Scanner(System.in);

    int size, id, attendanceDays, choice;

    int totalAttendance, highestAttendance, lowestAttendance;
    int highestStudent, lowestStudent;
    double averageAttendance;

    void main() {

        //prompt user to enter number of students
        System.out.print("Enter the number of Students: ");
        size = in.nextInt();

        //validate input
        if (size <= 0) {
            System.out.println("Invalid number of students.");
        } else {

            //read student records
            System.out.println("Input -----");
            for (int i = 0; i < size; i++) {

                //read student ID
                System.out.print(i + " - Enter Student ID: ");
                id = in.nextInt();

                //check duplicate student ID
                if (studentAttendance.containsKey(id)) {
                    System.out.println("Student ID already exists. Record not added.");
                } else {

                    //read attendance days
                    System.out.print("    Enter Attendance Days: ");
                    attendanceDays = in.nextInt();

                    //store student record
                    studentAttendance.put(id, attendanceDays);
                }
            }

            //menu
            choice = 0;
            do {
                System.out.println("\n===== MENU =====");
                System.out.println("1. Add Student Record");
                System.out.println("2. Search Student Attendance");
                System.out.println("3. Update Attendance");
                System.out.println("4. Remove Student Record");
                System.out.println("5. Display All Attendance Records");
                System.out.println("6. Display Attendance Statistics");
                System.out.println("7. Exit");
                System.out.print("Enter choice: ");
                choice = in.nextInt();

                switch (choice) {

                    //add student
                    case 1:
                        addStudent();
                        break;

                    //search student
                    case 2:
                        searchStudent();
                        break;

                    //update attendance
                    case 3:
                        updateAttendance();
                        break;

                    //remove student
                    case 4:
                        removeStudent();
                        break;

                    //display all records
                    case 5:
                        displayStudents();
                        break;

                    //display statistics
                    case 6:
                        displayStatistics();
                        break;

                    //exit
                    case 7:
                        System.out.println("GoodBye~");
                        break;

                    //invalid choice
                    default:
                        System.out.println("Invalid choice.");
                }

            } while (choice != 7);

            //display final summary
            System.out.println("\nFinal Attendance Summary -----");
            displayStudents();
            displayStatistics();
        }

        //close scanner
        in.close();
    }

    public void addStudent() {

        //ask for student ID
        System.out.print("Enter Student ID: ");
        id = in.nextInt();

        //check duplicate student ID
        if (studentAttendance.containsKey(id)) {
            System.out.println("Student ID already exists.");
        } else {

            //read attendance days
            System.out.print("Enter Attendance Days: ");
            attendanceDays = in.nextInt();

            //store student
            studentAttendance.put(id, attendanceDays);
            System.out.println("Student added successfully.");
        }
    }

    public void searchStudent() {

        //ask for student ID
        System.out.print("Enter Student ID: ");
        id = in.nextInt();

        //check if student exists
        if (studentAttendance.containsKey(id)) {
            System.out.println("Attendance Days: " + studentAttendance.get(id));
        } else {
            System.out.println("Student not found.");
        }
    }

    public void updateAttendance() {

        //ask for student ID
        System.out.print("Enter Student ID: ");
        id = in.nextInt();

        //check if student exists
        if (studentAttendance.containsKey(id)) {

            //read new attendance
            System.out.print("Enter New Attendance Days: ");
            attendanceDays = in.nextInt();

            //update attendance
            studentAttendance.replace(id, attendanceDays);
            System.out.println("Attendance updated successfully.");

        } else {
            System.out.println("Student not found.");
        }
    }

    public void removeStudent() {

        //ask for student ID
        System.out.print("Enter Student ID: ");
        id = in.nextInt();

        //check if student exists
        if (studentAttendance.containsKey(id)) {

            //remove student
            studentAttendance.remove(id);
            System.out.println("Student removed successfully.");

        } else {
            System.out.println("Student not found.");
        }
    }

    public void displayStudents() {

        //display students in ascending order
        ArrayList<Integer> ids = new ArrayList<Integer>(studentAttendance.keySet());
        Collections.sort(ids);

        System.out.println("\nAttendance Records -----");
        System.out.printf("%-18s | %-18s\n", "Student ID", "Attendance Days");
        System.out.println("_".repeat(45));

        for (int studentId : ids) {
            System.out.printf("%-18d | %-18d\n", studentId, studentAttendance.get(studentId));
        }
    }

    public void displayStatistics() {

        //check if there are student records
        if (studentAttendance.size() == 0) {
            System.out.println("No student records available.");
            return;
        }

        //set starting values
        totalAttendance = 0;
        highestAttendance = -1;
        lowestAttendance = Integer.MAX_VALUE;
        highestStudent = 0;
        lowestStudent = 0;

        //calculate statistics using entrySet()
        for (Map.Entry<Integer, Integer> record : studentAttendance.entrySet()) {

            id = record.getKey();
            attendanceDays = record.getValue();

            totalAttendance += attendanceDays;

            if (attendanceDays > highestAttendance) {
                highestAttendance = attendanceDays;
                highestStudent = id;
            }

            if (attendanceDays < lowestAttendance) {
                lowestAttendance = attendanceDays;
                lowestStudent = id;
            }
        }

        averageAttendance = (double) totalAttendance / studentAttendance.size();

        //display statistics
        System.out.println("\nAttendance Statistics -----");
        System.out.println("Total Students: " + studentAttendance.size());
        System.out.println("Total Attendance Days: " + totalAttendance);
        System.out.println("Average Attendance: " + averageAttendance);
        System.out.println("Student with Highest Attendance: " + highestStudent);
        System.out.println("Student with Lowest Attendance: " + lowestStudent);
    }
}