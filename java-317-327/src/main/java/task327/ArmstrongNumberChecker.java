package task327;

public class ArmstrongNumberChecker {
    public void main() {
        //initialize variables
        int number=153;
        int digit;
        int sum = 0;
        int count = (number + "").length();

        //loop to get each digit and add it to sum
        int num = number;
        while (num > 0) {
            digit = num % 10; //get rightmost digit
            sum += Math.pow(digit, count);
            num /= 10; //update number to get new digit
        }

        //compare sum to number to know if it is an armstrong number and display results
        System.out.println("Number: " + number);
        if (sum == number) System.out.println("The number is an Armstrong number.");
        else System.out.println("The number is NOT an Armstrong number.");
    }
}
