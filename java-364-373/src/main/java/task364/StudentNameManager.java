package task364;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentNameManager {
    //initialize scanner
    Scanner in = new Scanner(System.in);

    //declare variables
    ArrayList<String> studentName = new ArrayList<String>();
    int size, index, choice, count = 1;
    String name, name2;
    boolean found;
    int longestNameIndex, shortestNameIndex, totalCharacters, startWithACount, endWithACount;
    float averageLength;
    char[] characters;

    void main() {
        //Prompt the user to enter the number of students
        System.out.print("enter the number of Students: ");
        size = in.nextInt();

        //validate input
        if (size <= 0) {
            System.out.println("Invalid number of students.");
        } else {
            //Use a for loop to read each student name
            while (studentName.size() < size) {
                addStudent();
            }

            //menu
            choice = 0;
            while (choice != 7) {
                //print menu
                System.out.println("\n===== MENU =====");
                System.out.println("1. Add Student Name");
                System.out.println("2. Search Student Name");
                System.out.println("3. Update Student Name");
                System.out.println("4. Display All Student Names");
                System.out.println("5. Analyze Names");
                System.out.println("6. Compare Two Names");
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
                        updateStudent();
                        break;

                    //remove student
                    case 4:
                        displayAllStudent();
                        break;

                    //display all records
                    case 5:
                        analyzeNames();
                        break;

                    //display statistics
                    case 6:
                        compareTwoNames();
                        break;

                    //exit
                    case 7:
                        System.out.println("GoodBye~");
                        break;

                    //invalid choice
                    default:
                        System.out.println("Invalid choice.");
                }
            }
        }
        //close scanner
        in.close();
    }

    public void addStudent() {
        System.out.print("\nAdd Student -----\nEnter student [" + count + "] name: ");
        name = in.next().strip().toLowerCase();
        //Check if the name already exists using equals
        found = false;
        for (String student : studentName) {
            if (student.equals(name)) {
                found = true;
                break;
            }
        }

        if (found) { //if name exists
            System.out.println("Student name already exists.");
        } else {
            System.out.println("Student added successfully.");
            studentName.add(name);
            count++; //update count
        }
    }

    public void searchStudent() {
        System.out.print("\nSearch Student -----\nEnter student name: ");
        name = in.next().strip().toLowerCase();
        //Check if the name already exists using equals
        for (String student : studentName) {
            if (student.equals(name)) {
                System.out.println("Student found.");
                return; //end function here if found
            }
        }
        System.out.println("Student not found.");
    }

    public void updateStudent() {
        System.out.print("\nUpdate Student Name -----\nEnter student name: ");
        name = in.next().strip().toLowerCase();
        //Check if the name already exists using equals
        index = studentName.indexOf(name);

        if (index != -1) { //-1 means not found
            System.out.print("Enter New Name: ");
            name2 = in.next().strip().toLowerCase();
            if (studentName.contains(name2)) {
                System.out.println("Student name already exists.");
            } else {
                studentName.set(index, name2); //update name
                System.out.println("Student name updated successfully.");
            }
        } else {
            System.out.println("Student not found."); //name is not found on the list
        }
    }

    public void displayAllStudent() {
        System.out.print("\nDisplay All Student Names -----");
        for (int i = 0; i < studentName.size(); i++) { //display each name with index
            System.out.println((i + 1) + ". " + studentName.get(i));
        }
    }

    public void analyzeNames() {
        //set start
        longestNameIndex = 0;
        shortestNameIndex = 0;
        totalCharacters = 0;
        startWithACount = 0;
        endWithACount = 0;

        //loop to update above values
        for (int i = 0; i < studentName.size(); i++) {
            characters=studentName.get(i).toCharArray();
            //check longest shortest
            if (characters.length>studentName.get(longestNameIndex).length()) longestNameIndex=i;
            else if (characters.length<studentName.get(shortestNameIndex).length()) shortestNameIndex=i;

            //update total characters
            totalCharacters+=characters.length;

            //update counts
            if (characters[0]=='a')startWithACount++;
            if (characters[characters.length-1]=='a')endWithACount++;
        }
        //calculate average
        averageLength = (float) totalCharacters / studentName.size();

        //display results
        System.out.println("Total number of students: "+studentName.size());
        System.out.println("Longest student name: "+studentName.get(longestNameIndex));
        System.out.println("Shortest student name: "+studentName.get(shortestNameIndex) );
        System.out.println("Total characters in all names: "+totalCharacters);
        System.out.println("Average name length: "+averageLength);
        System.out.println("Number of names starting with a: "+startWithACount);
        System.out.println("Number of names ending with a: "+endWithACount);
    }

    public void compareTwoNames() {
        System.out.print("\nCompare Two Names -----\nEnter student (1) name: ");
        name = in.next().strip().toLowerCase();
        System.out.print("Enter student (2) name: ");
        name2 = in.next().strip().toLowerCase();

        //compare and display results
        //1 equals()
        System.out.println("equals() result: "+name.equals(name2));
        System.out.println("equalsIgnoreCase() result: "+name.equalsIgnoreCase(name2));
        System.out.println("compareTo() result: "+name.compareTo(name2));
    }

}
