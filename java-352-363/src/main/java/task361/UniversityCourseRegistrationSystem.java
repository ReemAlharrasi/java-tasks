package task361;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class UniversityCourseRegistrationSystem {
    //declare variables
    HashSet<Integer> studentIDs = new HashSet<Integer>();
    HashMap<Integer, HashSet<String>> studentCourses = new HashMap<Integer, HashSet<String>>();
    Scanner in = new Scanner(System.in);

    int size, id, courseCount, choice;
    String course;
    HashSet<String> courses;

    int totalCourses, maxCourses, minCourses, highestStudent, lowestStudent, courseNum;
    double average;

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
                System.out.print(i + " - enter Student ID: ");
                id = in.nextInt();

                //check duplicate student ID
                if (studentIDs.contains(id)) {
                    System.out.println("Student ID already exists. Record skipped.");
                } else {

                    //add student ID
                    studentIDs.add(id);

                    //create set for courses
                    courses = new HashSet<String>();

                    //read number of courses
                    System.out.print("    Enter number of courses: ");
                    courseCount = in.nextInt();

                    while (courseCount>6){ //max is 6 courses
                        System.out.print("    Invalid (max=6). Enter number of courses: ");
                        courseCount = in.nextInt();
                    }

                    //read all courses
                    for (int j = 0; j < courseCount; j++) {
                        System.out.print("    Enter course " + (j + 1) + ": ");
                        course = in.next();

                        if (courses.contains(course)) {
                            System.out.println("    Duplicate course not added.");
                        } else {
                            courses.add(course);
                        }
                    }

                    //store student courses
                    studentCourses.put(id, courses);
                }
            }

            //menu
            choice = 0;
            while (choice != 6) {
                System.out.println("\n===== MENU =====");
                System.out.println("1. Search Student");
                System.out.println("2. Add Course to Student");
                System.out.println("3. Remove Course from Student");
                System.out.println("4. Display All Students");
                System.out.println("5. Display Registration Statistics");
                System.out.println("6. Exit");
                System.out.print("Enter choice: ");
                choice = in.nextInt();

                switch (choice) {
                    //search student
                    case 1:
                        searchStudent();
                        break;
                    //add course
                    case 2:
                        addCourse();
                        break;
                    //remove course
                    case 3:
                        removeCourse();
                        break;
                    //display all students
                    case 4:
                        displayStudents();
                        break;
                    //display statistics
                    case 5:
                        displayStats();
                        break;
                    //exit
                    case 6:
                        System.out.println("GoodBye~");
                        break;
                    //invalid choice
                    default:
                        System.out.println("Invalid choice.");
                }

            }

            //display final summary
            System.out.println("\nFinal Registration Summary -----");

            ArrayList<Integer> ids = new ArrayList<Integer>(studentIDs);
            Collections.sort(ids); //bonus : display in ascending order

            System.out.println("\nAll Students-----");
            System.out.printf("%-18s | %-18s", "Student ID\n", "Registered Courses");
            System.out.println("_".repeat(50));
            for (int studentId : ids) {
                System.out.printf("%-18d | %-18s\n", studentId, studentCourses.get(studentId));
            }
            displayStats();
        }

        //close scanner
        in.close();
    }

    public void searchStudent() {
        System.out.print("Enter Student ID: ");
        id = in.nextInt();

        //check if student id exists
        if (studentCourses.containsKey(id)) {
            System.out.println("Registered Courses: " + studentCourses.get(id));
        } else {
            System.out.println("Student not found.");
        }
    }

    public void addCourse() {
        //ask for id
        System.out.print("Enter Student ID: ");
        id = in.nextInt();

        //check if id exists
        if (studentCourses.containsKey(id)) {
            courses = studentCourses.get(id);
            //check if there are 6 or more courses
            if (courses.size() >= 6) {
                System.out.println("Student cannot register for more than 6 courses.");
            } else {
                //ask for course name
                System.out.print("Enter Course name: ");
                course = in.next();

                //check that course have not been added before
                if (courses.contains(course)) {
                    System.out.println("Course already registered.");
                } else {
                    courses.add(course);
                    studentCourses.replace(id, courses);
                    System.out.println("Course added successfully.");
                }
            }

        } else {
            System.out.println("Student not found.");
        }
    }

    public void removeCourse() {
        System.out.print("Enter Student ID: ");
        id = in.nextInt();

        if (studentCourses.containsKey(id)) {//ask for course name if id exists
            courses = studentCourses.get(id);
            System.out.print("Enter Course name: ");
            course = in.next();

            if (courses.contains(course)) { //if course exists
                courses.remove(course);
                studentCourses.replace(id, courses);
                System.out.println("Course removed successfully.");
            } else {
                System.out.println("Course not found.");
            }

        } else {
            System.out.println("Student not found.");
        }
    }

    public void displayStudents() {
        //display in ascending order
        ArrayList<Integer> ids = new ArrayList<Integer>(studentIDs);
        Collections.sort(ids);

        System.out.println("\nAll Students -----");
        System.out.printf("%-18s | %-18s", "Student ID\n", "Registered Courses");
        System.out.println("_".repeat(50));
        for (int studentId : ids) {
            System.out.printf("%-18d | %-18s\n", studentId, studentCourses.get(studentId));
        }
    }

    public void displayStats() {
        //set start values
        totalCourses = 0;
        maxCourses = -1;
        minCourses = 7; //maximum number of courses allowed is 6
        highestStudent = 0;
        lowestStudent = 0;

        //loop to update above vvalues
        for (int sid : studentCourses.keySet()) { //loop through keys
            courseNum = studentCourses.get(sid).size();
            totalCourses += courseNum;
            if (courseNum > maxCourses) { //update maximun
                maxCourses = courseNum;
                highestStudent = sid;
            }
            if (courseNum < minCourses) { //update minimum
                minCourses = courseNum;
                lowestStudent = sid;
            }
        }

        average = (double) totalCourses / studentIDs.size();

        System.out.println("\nRegistration Statistics -----");
        System.out.println("Total Students: " + studentIDs.size());
        System.out.println("Total Course Registrations: " + totalCourses);
        System.out.println("Student with highest courses: " + highestStudent);
        System.out.println("Student with lowest courses: " + lowestStudent);
        System.out.println("Average courses per student: " + average);

    }
}