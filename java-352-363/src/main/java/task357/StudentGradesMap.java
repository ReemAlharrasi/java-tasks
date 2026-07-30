package task357;

import java.util.HashMap;
import java.util.Scanner;

public class StudentGradesMap {
    //declare variables
    HashMap<Integer, Double> studentIdGrades = new HashMap<>();
    Scanner in = new Scanner(System.in);
    int size, id;
    double grade, totalGrades, average;
    String classification;
    //main function
    void main() {
        //Prompt the user to enter the number of students
        System.out.print("enter the number of Students: ");
        size = in.nextInt();

        //validate input
        if (size <= 0) {
            System.out.println("Invalid number of students.");
        } else {
            //if size is valid
            System.out.println("Input -----");
            for (int i = 0; i < size; i++) {
                //read id
                System.out.print(i + " - enter student id: ");
                id = in.nextInt();
                //add to set and ensure there is no duplicate
                if (studentIdGrades.containsKey(id)) {
                    System.out.println("Student ID already exists. Record not added..");
                } else {
                    System.out.print("    enter student grade: ");
                    grade = in.nextFloat();
                    while (grade>100 || grade<0){
                        System.out.print("    Invalid grade. enter student grade: ");
                        grade = in.nextFloat();
                    }
                }
                studentIdGrades.put(id, grade);
            }

            //update grade
            System.out.print("\nUpdate grade -----\nEnter student id: ");
            id = in.nextInt();
            if (!studentIdGrades.containsKey(id)) {
                System.out.println("Student ID not found.");
            } else {
                System.out.print("Enter student grade: ");
                grade = in.nextFloat();
                studentIdGrades.put(id, grade);
                System.out.println("Grade updated successfully.");
            }

            //calculate average and display it
            totalGrades = 0;
            for (int key : studentIdGrades.keySet()) {
                grade = studentIdGrades.get(key);
                totalGrades += grade;
            }
            average = (double) totalGrades / studentIdGrades.size();
            System.out.println("Average grade: "+average);

            //classify performance based on average grade
            if (average < 60) classification="Needs Improvement";
            else if (average <=84) classification="Good Performance";
            else classification="Excellent Performance";

            //display all results
            System.out.println("\nInformation -----\nTotal employee records entered: "+size);
            System.out.println("Total unique students records: "+studentIdGrades.size());
            System.out.println("All student  (ID=grade): "+studentIdGrades);
            System.out.println("Average grade: "+average);
            System.out.println("Class performance classification: "+classification);

        }

        //close scanner
        in.close();
    }
}
