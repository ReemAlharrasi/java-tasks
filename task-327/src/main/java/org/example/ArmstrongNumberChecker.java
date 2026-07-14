package org.example;

import java.lang.Math;

public class ArmstrongNumberChecker {
    public void main(int number) {
        //initialize variables
        int num = number;
        int digit;
        int sum = 0;
        int count = (num + "").length();

        //loop to get each digit and add it to sum
        while (num > 0) {
            digit = num % 10; //get rightmost digit
            sum += Math.pow(digit, count);
            num /= 10; //update number to get new digit
        }

        //compare sum to number to know if it is an armstrong number and display results
        System.out.println("Number: " + number);
        if (sum == number) System.out.println("The number is an Armstrong number.");
        else System.out.println("The number is NOT an Armstrong number.");
    }
}
