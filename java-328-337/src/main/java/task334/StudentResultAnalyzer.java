package task334;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentResultAnalyzer {
    void main() {
        //declare required variables
        String name = "Reem";
        ArrayList<Float> marks = new ArrayList<Float>();
        float mark;
        int markCount = 5;
        float totalMarks;
        float average;
        char grade;
        String perfromence;

        //Initialize scanner object
        Scanner in = new Scanner(System.in);

        //prompt user to enter grades and validate them
        System.out.println("-----Inputs-----");
        for (int i = 0; i < markCount; i++) {
            System.out.println("Enter mark " + (i+1) + " : ");
            mark = in.nextFloat();
            //validate input
            while (!validateMarks(mark)) {
                System.out.println("Invalid mark.\nEnter mark " + (i+1) + " : ");
                mark = in.nextFloat();
            }
            marks.add(mark);
        }
        //call function to calculate total
        totalMarks = calculateTotal(marks);

        //call function to calculate average
        average = calculateAverage(totalMarks, markCount);

        //call function to get garde based on mark
        grade = calculateGrade(average);

        //call function to get performance statement
        perfromence = checkPerformance(grade);

        //generate student report: display all information
        displayReport(name, marks,totalMarks,markCount, average,grade, perfromence);
    }

    public boolean validateMarks(float marks) {
        //condition that returns truw if marks are in the correct range
        return (marks >= 0 && marks <= 100) ? true : false;
    }

    public float calculateTotal(ArrayList<Float> allMarks) {
        Float marksSum = 0F;
        //loop to add each mark to the sum
        for (Float mark : allMarks) {
            marksSum += mark;
        }
        return marksSum;
    }

    //function to calculate average
    public float calculateAverage(float total, int count) {
        return total / count;
    }

    //function to determine grade based ob mark
    public char calculateGrade(Float averageMark) {
        char grade; // character
        if (averageMark >= 90) grade = 'A';
        else if (averageMark >= 80) grade = 'B';
        else if (averageMark >= 70) grade = 'C';
        else if (averageMark >= 60) grade = 'D';
        else grade = 'F';
        return grade;
    }

    //function to give statement based on grade
    public String checkPerformance(char grade) {
        //variable to store perfomence status and return it
        String status = switch (grade) {
            case 'A' -> "Excellent";
            case 'B' -> "Good";
            case 'C' -> "Satisfactory";
            case 'D' -> "Needs Improvement";
            case 'F' -> "Fail";
            default -> "InComplete";
        };

        return status;
    }

    //function to display all student information
    public void displayReport(String name, ArrayList<Float> marks,Float total,Integer count, Float average,char grade, String status ) {
        System.out.println("----- Student Results Analyzer -----");
        System.out.println("Name: "+name);
        System.out.println("Number of subject: "+count);
        System.out.println("Total marks: "+total);
        System.out.println("Average: "+average);
        System.out.println("Grade: "+grade);
        System.out.println("Performance tatus: "+status);

    }

}
