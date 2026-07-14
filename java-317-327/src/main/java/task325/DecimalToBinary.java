package task325;

public class DecimalToBinary {
    public void main() {
        //initialize variables
        int decimalnumber = 25;
        String binary = "";
        int remainder;

        //loop to get each binary digit
        int number=decimalnumber;
        while (number > 0) {
            remainder = number % 2; //calculate division remainder
            if (remainder == 0) binary += "0"; //if remainder is 0 then add 0 to binary string
            else binary += "1"; //else add 1 to binary string

            number /= 2; //update number
        }

        //display results
        System.out.println("Decimal Number: " + decimalnumber);
        System.out.println("Binary  Number: " + binary);

    }
}
