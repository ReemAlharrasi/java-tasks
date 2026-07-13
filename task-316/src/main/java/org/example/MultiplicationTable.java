package org.example;

public class MultiplicationTable {
    //attributes
    int base;
    int result;

    //constructor
    public MultiplicationTable(int baseInput) {
        base = baseInput;
    }

    //methods
    public void main() {
        System.out.println("----- Multiplication table of " + base+ " -----");
        for (int i = 1; i <= 10; i++) { // loop from 1 to 10 inclusive
            result = base * i; 
            System.out.println(base + " x " + i + " = " + result); //print result
        }

    }
}
