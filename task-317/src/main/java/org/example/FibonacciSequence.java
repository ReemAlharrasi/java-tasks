package org.example;

public class FibonacciSequence {
    //attributes
    int count;

    //constructor
    public FibonacciSequence(int seqLength){
        count =seqLength;
    }
    //methods
    public void main(){
        //display header and starting values
        System.out.println("----- Fibonacci Sequence -----");
        System.out.print(0 + "  ");
        System.out.print(1 + "  ");

        //initialize varaibles for loop
        int first=0;
        int second=1;
        int next;

        for (int i=2; i<count;i++){
            //calcaulate new item and display it
            next=first+second;
            System.out.print(next + "  ");

            //swap values
            first=second;
            second=next;
        }
    }
}
