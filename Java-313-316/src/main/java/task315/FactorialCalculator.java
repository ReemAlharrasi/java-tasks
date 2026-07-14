package task315;

public class FactorialCalculator {
    public void main() {
        //attributes
        int num=7;
        long factorial = 1;

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
