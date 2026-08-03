package task368;

import java.util.Scanner;
import java.util.Stack;

public class NumberStackAnalyzer {
    //initialize scanner
    Scanner in = new Scanner(System.in);

    //declare required variables
    Stack<Integer> integerValues = new Stack<>();
    int size, choice, number;
    int sumOfNumbers, largestNumber, smallestNumber, evenCount, oddCount, positiveCout, negativeCount, zeroCount;
    float average;

    void main() {

        //Prompt the user to enter the number of actions
        System.out.print("Enter the number of values: ");
        size = in.nextInt();

        //validate input
        if (size <= 0) {
            System.out.println("Invalid number of values.");
        } else {
            //get input
            for (int i = 0; i < size; i++) {
                System.out.print((i + 1) + "- enter integer value: ");
                number = in.nextInt();
                integerValues.push(number); //add to stack
            }
        }

        //menu
        choice = 0;
        do {
            //print menu
            System.out.println("\n===== MENU =====");
            System.out.println("1. Add Number");
            System.out.println("2. Remove Top Number");
            System.out.println("3. View Top Number");
            System.out.println("4. Display All Number");
            System.out.println("5. Analyze Numbers");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = in.nextInt();

            switch (choice) {
                //add Number
                case 1:
                    addNumber();
                    break;

                //remove top Number
                case 2:
                    removeTopNumber();
                    break;

                //view top Number
                case 3:
                    viewTopNumber();
                    break;

                //search Number
                case 4:
                    displayAllNumbers();
                    break;

                //display all Number
                case 5:
                    analyzeNumbers();
                    break;

                //display statistics
                case 6:
                    System.out.println("\nGoodBye~");
                    break;

                //invalid choice
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 6);

        //close scanner
        in.close();
    }

    public void addNumber() {
        System.out.println("\nAdd Number -----");
        System.out.print("Enter integer value: ");
        number = in.nextInt(); //read from user
        integerValues.push(number); //add to stack
        System.out.println("Number added successfully.");
    }

    public void removeTopNumber() {
        System.out.println("\nRemove Top Number -----");
        if (integerValues.empty()) System.out.println("Stack is empty.");//if stack is empty
        else {
            number = integerValues.pop();
            System.out.println("Number removed successfully: [" + number + "]");
        }
    }

    public void viewTopNumber() {
        System.out.println("\nView Top Number -----");
        if (integerValues.empty()) System.out.println("Stack is empty.");//if stack is empty
        else {
            System.out.println("Top Number: [" + integerValues.peek() + "]");
        }
    }

    public void displayAllNumbers() {
        System.out.println("\nDisplay All Numbers -----");
        if (integerValues.empty()) System.out.println("Stack is empty.");//if stack is empty
        else {
            for (int i = 0; i < integerValues.size(); i++) { //display each name with index
                System.out.println((char)(i + 97) + ". number: " + integerValues.get(i));
            }
        }
    }

    public void analyzeNumbers() {
        System.out.println("\nAnalyze Numbers -----");

        //set start values
        sumOfNumbers = 0;
        largestNumber = integerValues.peek();
        smallestNumber = integerValues.peek();
        evenCount = 0;
        oddCount = 0;
        positiveCout = 0;
        negativeCount = 0;
        zeroCount = 0;

        //loop to update values
        for (int num:integerValues){
            sumOfNumbers+=num; //add number to total
            //update smallest and largest
            if (num>largestNumber)largestNumber=num;
            else if (num<smallestNumber)smallestNumber=num;
            //update counts
            if (num>0) positiveCout++;
            else if (num<0) negativeCount++;
            else zeroCount++;
            if (num%2==0) evenCount++;
            else oddCount++;
        }
        //calculate average
        average = (float) sumOfNumbers / integerValues.size();

        //display results
        System.out.println("Total number of elements: "+integerValues.size());
        System.out.println("Sum of all numbers: "+sumOfNumbers);
        System.out.println("Average of all numbers: "+average);
        System.out.println("Largest number: "+largestNumber);
        System.out.println("Smallest number: "+smallestNumber);
        System.out.println("Total even numbers: "+evenCount);
        System.out.println("Total odd numbers: "+oddCount);
        System.out.println("Total positive numbers: "+positiveCout);
        System.out.println("Total negative numbers: "+negativeCount);
        System.out.println("Total zeros: "+zeroCount);
    }
}
