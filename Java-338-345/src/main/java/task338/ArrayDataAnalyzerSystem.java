package task338;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayDataAnalyzerSystem {
    //initialize required variables
    ArrayList<Integer> numbers = new ArrayList<Integer>();
    ArrayList<Integer> numbersReversed;
    ArrayList<Integer> numbersSorted;

    int total;
    float average;
    int largest;
    int smallest;

    int positiveCount;
    int negativeCount;
    int zeroCount;
    int evenCount;
    int oddCount;

    int num;
    int index;
    int repeat;

    //initialize scanner to read input
    Scanner in = new Scanner(System.in);

    void main() {
        //add numbers to arraylist
        numbers.add(45);
        numbers.add(12);
        numbers.add(-5);
        numbers.add(90);
        numbers.add(33);
        numbers.add(12);
        numbers.add(0);
        numbers.add(67);
        numbers.add(-20);
        numbers.add(88);
        numbers.add(45);
        numbers.add(100);
        numbers.add(7);
        numbers.add(-3);
        numbers.add(55);

        //call functions
        displayArray();

        arrayStatistics();

        numberClassification();

        searchSystem();

        updateArray();

        reverseArray();

        sortAndCompare();
    }

    //function to Display Array Information
    public void displayArray() {

        //display header, size, first and last element
        System.out.println("\n----- Numbers information -----");
        System.out.println("Total number of elements: " + numbers.size());
        System.out.println("First element: " + numbers.get(0));
        System.out.println("Last element: " + numbers.get(numbers.size() - 1));

        //display each number with its index
        System.out.println("\nNumbers -----");
        for (int i = 0; i < numbers.size(); i++) {
            System.out.println("Index " + i + " = " + numbers.get(i));//print number
        }

    }

    //function to display array statics
    public void arrayStatistics() {
        //set total to 0 as a start
        total = 0;

        //assume largest and smallest are the first element on the list
        largest = numbers.get(0);
        smallest = numbers.get(0);

        //loop through numbers to update above variables
        for (int i = 0; i < numbers.size(); i++) {
            total += numbers.get(i);
            if (numbers.get(i) > largest) largest = numbers.get(i);
            else if (numbers.get(i) < smallest) smallest = numbers.get(i);
        }

        //calculate average
        average = (float) total / numbers.size();
        //display header and information
        System.out.println("\n----- Numbers Statistics -----");
        System.out.println("Sum of all numbers: " + total);
        System.out.println("Average value: " + average);
        System.out.println("Largest number: " + largest);
        System.out.println("Smallest number: " + smallest);
    }

    public void numberClassification() {
        //set variables to 0 at first
        positiveCount = 0;
        negativeCount = 0;
        zeroCount = 0;
        evenCount = 0;
        oddCount = 0;

        //loop through numbers to update above variables
        for (int i = 0; i < numbers.size(); i++) {
            //update positive, negative, and zero counts
            if (numbers.get(i) > 0) positiveCount++;
            else if (numbers.get(i) < 0) negativeCount++;
            else zeroCount++;
            //update even and odd counts
            if (numbers.get(i) % 2 == 0) evenCount++;
            else oddCount++;
        }

        //display results
        System.out.println("\n----- Numbers Classification -----");
        System.out.println("Count of positive numbers: " + positiveCount);
        System.out.println("Count of negative numbers: " + negativeCount);
        System.out.println("Count of zero values: " + zeroCount);
        System.out.println("Count of even numbers: " + evenCount);
        System.out.println("Count of odd numbers: " + oddCount);
    }

    public void searchSystem() {
        System.out.println("\n----- Search System -----");

        //ask user for input
        System.out.print("Enter a number: ");
        num = in.nextInt();

        //check if number exists
        index = numbers.indexOf(num);
        if (index != -1) {
            System.out.println("First index: " + index);
            //how many times it repeated
            for (int i = 0; i < numbers.size(); i++) {
                if (numbers.get(i).equals(num)) {
                    repeat++;
                }
            }

            //display result
            System.out.println("Occurrences: " + repeat);

        } else {
            System.out.println("Number not found!");
        }
    }

    //function to update values
    public void updateArray() {
        System.out.println("\n----- Update Array Values -----");

        //ask user for input
        System.out.print("Enter an index number: ");
        index = in.nextInt();
        System.out.print("Enter the new value: ");
        num = in.nextInt();

        //update value
        if (index < numbers.size()) {
            numbers.set(index, num);
            System.out.println("updated list: " + numbers.toString());
        } else {
            System.out.println("Index out of range");
        }

    }

    //function to reverse array
    public void reverseArray() {
        System.out.println("\n----- Reverse Array -----");
        numbersReversed = new ArrayList<Integer>();
        //loop numbers from last to first and add to reversedlist
        for (int i = numbers.size() - 1; i >= 0; i--) {
            numbersReversed.add(numbers.get(i));
        }

        //display results
        System.out.println("original: " + numbers.toString());
        System.out.println("Reverse: " + numbersReversed.toString());
    }

    //function to sort and compare
    public void sortAndCompare(){
        System.out.println("\n----- Sorting and Comparison -----");
        numbersSorted = new ArrayList<Integer>(numbers); //copied numbers to this new array
        for (int i=0;i<numbersSorted.size();i++){
            for (int j=i+1;j<numbersSorted.size();j++){
                //compare and swap if smaller
                if (numbersSorted.get(i)>numbersSorted.get(j)){
                    //swap
                    num=numbersSorted.get(i);
                    numbersSorted.set(i,numbersSorted.get(j));
                    numbersSorted.set(j,num);
                }
            }
        }
        //print results
        //display results
        System.out.println("original: " + numbers.toString());
        System.out.println("Sorted: " + numbersSorted.toString());
    }
}
