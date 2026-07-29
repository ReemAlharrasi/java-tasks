package task356;

import java.util.HashMap;
import java.util.Scanner;

public class EmployeeDirectoryMap  {
    //declare variables
    HashMap<Integer, String> employeeIDs = new HashMap<>();
    Scanner in = new Scanner(System.in);
    int size,id;
    String name,searchResult,classification;

    //main function
    void main(){
        //Prompt the user to enter the number of cities
        System.out.print("enter the number of employees: ");
        size = in.nextInt();

        //validate input
        if (size <= 0){
            System.out.println("Invalid number of employees.");
        }
        else{
            //if size is valid
            System.out.println("Input -----");
            for (int i = 0; i < size; i++) {
                //read id
                System.out.print("enter employee ("+i+") id: ");
                id = in.nextInt();
                //add to set and ensure there is no duplicate
                if (employeeIDs.containsKey(id)){
                    System.out.println("Employee ID already exists. Duplicate entries are not allowed.");
                }else{
                    System.out.print("enter employee ("+i+") name: ");
                    name = in.next();
                    employeeIDs.put(id,name);
                }
            }

            //prompt the user to enter an employee id to search for
            System.out.print("\nSearch -----\nenter employee id: ");
            id = in.nextInt();
            if (employeeIDs.containsKey(id)){
                searchResult="Employee Found: ["+employeeIDs.get(id)+"]";
            }else{
                searchResult="Employee ID not found.";
            }

            //classify size of company
            if (employeeIDs.size()<5)classification="Small Company";
            else if (employeeIDs.size()<=10)classification="Medium Company";
            else classification="Large Company";

            //display results
            System.out.println("\nInformation -----\nTotal employee records entered: "+size);
            System.out.println("Total unique employees: "+employeeIDs.size());
            System.out.println("All employees (ID=name): "+employeeIDs);
            System.out.println("Search result for ("+id+"): "+searchResult);
            System.out.println("Course catalog classification: "+classification);
        }
        //close scanner
        in.close();
    }
}
