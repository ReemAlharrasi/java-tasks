package task360;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class CourseEnrollmentSystem {
    //declare variables
    HashSet<Integer> studentIDs = new HashSet<Integer>();
    HashMap<Integer, String> studentCourses = new HashMap<Integer, String>();
    Scanner in = new Scanner(System.in);

    int size, id;
    String course, classification;

    void main() {
        //Prompt the user to enter the number of students
        System.out.print("Enter the number of Students: ");
        size = in.nextInt();

        //validate input
        if (size <= 0) {
            System.out.println("Invalid number of students.");
        } else {
            //if size is valid: prompt user to enter student ID and course
            System.out.println("Input -----");
            for (int i = 0; i < size; i++) {

                //read student ID
                System.out.print(i + " - enter Student ID: ");
                id = in.nextInt();

                //check for duplicate ID
                if (studentIDs.contains(id)) {
                    System.out.println("Student ID already exists. Record not added.");
                } else {
                    //read course name
                    System.out.print("    enter Course name: ");
                    course = in.next();

                    //add student record
                    studentIDs.add(id);
                    studentCourses.put(id, course);
                }
            }

            //prompt user to update a student's course
            System.out.print("\nUpdate Course -----\nEnter Student ID: ");
            id = in.nextInt();

            //check if student exists
            if (studentCourses.containsKey(id)) {
                System.out.print("Enter new Course name: ");
                course = in.next();

                //update course
                studentCourses.replace(id, course);
                System.out.println("Course updated successfully.");
            } else {
                System.out.println("Student ID not found.");
            }

            //classify enrollment size
            if (studentIDs.size() < 5) classification = "Small Enrollment";
            else if (studentIDs.size() <= 15) classification = "Medium Enrollment";
            else classification = "Large Enrollment";

            //display all results
            System.out.println("\nInformation -----");
            System.out.println("Total student records entered: " + size);
            System.out.println("Total unique students: " + studentIDs.size());
            System.out.println("All Student IDs: " + studentIDs);
            System.out.println("All Students (ID=Course): " + studentCourses);
            System.out.println("Enrollment classification: " + classification);
        }

        //close scanner
        in.close();
    }
}