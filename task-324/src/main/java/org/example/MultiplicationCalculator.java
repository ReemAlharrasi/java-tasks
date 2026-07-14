package org.example;

public class MultiplicationCalculator {
    public void main(int start, int end) {
        //initialize variables
        int result = 1;

        //loop through numbers from start to end
        for (int i = start; i <= end; i++) {
            result*=i; //multiply result by i
        }

        //display result
        System.out.println("Multiplication Result: " + result);
    }
}
