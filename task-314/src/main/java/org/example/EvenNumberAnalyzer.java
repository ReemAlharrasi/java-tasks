package org.example;

public class EvenNumberAnalyzer {
    //Attributes
    int limit = 20;
    int count = 0;
    int sum = 0;

    //constructor
    public EvenNumberAnalyzer(int fromOneUpTo) {
        limit = fromOneUpTo;
    }

    //methods
    public void analyze() {
        System.out.println("----- Even numbers From 1 to "+limit+" -----");
        //loop to go through numbers
        for (int i = 1; i <= limit; i++) {
            if (i % 2 == 0) {
                System.out.print(i + "  ");
                count += 1;
                sum += i;
            }
        }

        //display results
        System.out.println("\n----- Analyzer Results -----");
        System.out.println("Total count of even numbers: " + count);
        System.out.println("Total sum of even numbers: " + sum);
    }
}
