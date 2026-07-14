package org.example;

public class PalindromeChecker {
    //attributes
    int originalNumber;
    int reversedNumber;
    int digit;

    //constructor
    public PalindromeChecker(int num) {
        originalNumber = num;
    }

    //methods
    public void main() {
        //reverse number
        int number = originalNumber;
        while (number != 0) {
            digit = number % 10; //extract rightmost digit
            reversedNumber = reversedNumber * 10 + digit; //create space and add digit to reversed number
            number /= 10; //update number
        }

        //display numbers
        System.out.println("Original number: " + originalNumber);
        System.out.println("Reversed number: " + reversedNumber);

        //check if number is the same if reversed
        //and display results
        if (originalNumber == reversedNumber) {
            System.out.println("The number is a palindrome.");
        } else {
            System.out.println("The number is NOT a palindrome.");
        }

    }
}
