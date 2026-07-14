package task326;

public class DigitFrequencyCounter {
    public void main() {
        //initialize variables
        int number = 122333;
        int targetDigit = 3;
        int num=number;
        int count=0;
        int digit;

        //loop to count how many times the target got repeated
        while (num>0){
            digit=num%10; //get rightmost digit
            if (digit==targetDigit) count++; //if target found then increment count by 1
            num/=10; //update number to get new digit
        }

        //display results
        System.out.println("Number: " + number);
        System.out.println("Target Digit: " + targetDigit);
        System.out.println("Frequency: " + count);
    }
}
