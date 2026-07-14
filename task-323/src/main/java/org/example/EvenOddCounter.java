package org.example;

public class EvenOddCounter {
    //method
    public void main(int start, int end) {
        //initialize variables
        int evenCount = 0;
        int oddCount = 0;

        //loop through numbers from start to end
        for (int i = start; i <= end; i++) {
            if (i % 2 == 0) evenCount++; //if even add 1 to evenCount
            else oddCount++; //else add 1 to oddCount
        }

        //display results
        System.out.println("Even Numbers Count: " + evenCount);
        System.out.println("Odd Numbers Count: " + oddCount);

    }
}
