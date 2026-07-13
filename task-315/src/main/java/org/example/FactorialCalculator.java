package org.example;

public class FactorialCalculator {
    //attributes
    int num;
    long factorial = 1;

    //constructor
    public FactorialCalculator(int number) {
        num = number;
    }

    //methods
    public void main() {
        //calculate factorial
        int i = 1;
        while (i <= num) {
            factorial *= i; //factorial = factorial * i;
            i++;
        }

        //display results
        System.out.println("Factorial of Number " + num + " is " + factorial);
    }
}
