package task322;

import java.util.ArrayList;

public class LargestNumberFinder {
    public void main() {
        //initialize variables and arraylist
        int number;
        int largest;
        ArrayList<Integer> numberList = new ArrayList<Integer>();

        //add numbers to numberList
        numberList.add(10);
        numberList.add(43);
        numberList.add(32);
        numberList.add(89);
        numberList.add(64);
        numberList.add(59);

        //display header
        System.out.println("----- find largest number -----");

        //assume first numer is the largest
        largest = numberList.get(0);


        //Loop and compare to find actual largest
        for (Integer num : numberList) {
            if (num > largest) {
                largest = num; //update with new largest
            }
            //display number
            System.out.print(num + "  ");
        }
        //display the largest
        System.out.println("\nLargest Number: "+ largest);

    }
}
