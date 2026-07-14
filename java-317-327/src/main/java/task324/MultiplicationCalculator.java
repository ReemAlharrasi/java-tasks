package task324;

public class MultiplicationCalculator {
    public void main() {
        //initialize variables
        int start = 1;
        int end = 5;
        int result = 1;

        //loop through numbers from start to end
        for (int i = start; i <= end; i++) {
            result*=i; //multiply result by i
        }

        //display result
        System.out.println("Multiplication Result: " + result);
    }
}
