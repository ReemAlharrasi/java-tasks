package org.example;

public class FibonacciSequence {
    //attributes
    int length;

    //constructor
    public FibonacciSequence(int seqLength){
        length =seqLength;
    }
    //methods
    public void main(){
        //display header and starting values
        System.out.println("----- Fibonacci Sequence -----");
        System.out.print(0 + "  ");
        System.out.print(1 + "  ");

        //initialize varaibles for loop
        int prev1=0;
        int prev2=1;
        int temp;
        
        for (int i=2; i<length;i++){
            //calcaulate new item and display it
            temp=prev1+prev2;
            System.out.print(temp + "  ");

            //swap values
            prev1=prev2;
            prev2=temp;
        }
    }
}
