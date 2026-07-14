package org.example;

public class Main {
    static void main() {
        //initialize variables
        int start = 1;
        int end = 10;

        // create object
        EvenOddCounter counter = new EvenOddCounter();

        //call method
        counter.main(start, end);
    }
}
