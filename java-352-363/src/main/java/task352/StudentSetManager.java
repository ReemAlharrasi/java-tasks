package task352;

import java.util.HashSet;
import java.util.Scanner;

public class StudentSetManager {
    //declare variables
    HashSet studentID = new HashSet();
    Scanner in = new Scanner(System.in);
    int size, id;
    String registeration;

    //main function
    void main() {
        //ask user for input
        System.out.print("enter the number of student IDs: ");
        size = in.nextInt();
        if (size <= 0) { //validate size
            System.out.print("Invalid number of students.");
        } else {
            //if size is valid
            for (int i = 0; i < size; i++) {
                //read id
                System.out.print("enter student ("+i+") ID: ");
                id = in.nextInt();
                //add to set and ensure there is no duplicate
                if (studentID.contains(id)){
                    System.out.println("Duplicate ID detected. ID was not added.");
                }else{
                    studentID.add(id);
                }
            }

            //classify registration
            if (studentID.size()<5)registeration="Small Registration";
            else if (studentID.size()<=10)registeration="Medium Registration";
            else registeration="Large Registration";

            //display results
            System.out.println("\nTotal IDs entered: "+size);
            System.out.println("Total unique student IDs: "+studentID.size());
            System.out.println("All unique student IDs: "+studentID);
            System.out.println("Registration classification: "+registeration);
        }
        //close scanner
        in.close();
    }
}
