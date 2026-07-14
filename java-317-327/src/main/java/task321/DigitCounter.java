package task321;

public class DigitCounter {
    public void main() {
        //initialize variables
        int number = 123456;

        //display number
        System.out.println("Number: " + number);

        //loop to count digits
        int count = 0;
        while (number > 0) {
            count++; //increment count by 1
            number /= 10; //divide by 10 to get rid of rightmost digit
        }

        //display digit count

        System.out.println("Number of digits: " + count);
    }
}
