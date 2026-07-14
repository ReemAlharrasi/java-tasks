package org.example;

public class DigitFrequencyCounter {
    public void main(int number, int targetDigit) {
        //initialize variables
        int num=number;
        int count=0;
        int digit;

        //loop to count how many times the target got repeated
        while (num>0){
            digit=num%10; //get rightmost digit
            if (digit==targetDigit) count++; //if target found then increment count by 1
            num/=10; //update number to get new digit
        }

        //display results
        System.out.println("Number: " + number);
        System.out.println("Target Digit: " + targetDigit);
        System.out.println("Frequency: " + count);
    }
}
