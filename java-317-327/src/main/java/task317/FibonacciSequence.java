package task317;

public class FibonacciSequence {


    public void main(){
        //initialize variables
        int count=15;

        //display header and starting values
        System.out.println("----- Fibonacci Sequence -----");
        System.out.print(0 + "  ");
        System.out.print(1 + "  ");

        //initialize variables for loop
        int first=0;
        int second=1;
        int next;

        for (int i=2; i<count;i++){
            //calculate new item and display it
            next=first+second;
            System.out.print(next + "  ");

            //swap values
            first=second;
            second=next;
        }
    }
}
