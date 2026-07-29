package task357;

import java.util.HashMap;
import java.util.Scanner;

public class StudentGradesMap {
    //declare variables
    HashMap<Integer, Double> studentIdGrades=new HashMap<>();
    Scanner in = new Scanner(System.in);
    int size,id;
    double grade;

    //main function
    void main(){
        //Prompt the user to enter the number of students
        System.out.print("enter the number of employees: ");
        size = in.nextInt();

        //validate input
        if (size <= 0){
            System.out.println("Invalid number of students.");
        }
        else{
            //if size is valid
            System.out.println("Input -----");
            for (int i = 0; i < size; i++) {
                //read id
                System.out.print(i+" - enter student id: ");
                id = in.nextInt();
                //add to set and ensure there is no duplicate
                if (studentIdGrades.containsKey(id)){
                    System.out.println("Student ID already exists. Record not added..");
                }else{
                    System.out.print("    enter student grade: ");
                    grade = in.nextFloat();
                    studentIdGrades.put(id,grade);
                }
            }


        }

        //close scanner
        in.close();
    }
}
