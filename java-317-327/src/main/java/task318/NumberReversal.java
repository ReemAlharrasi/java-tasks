package task318;

public class NumberReversal {
    public void main(){
        //initialize variables
        int number=12345;
        int reversedNumber=0;
        int digit;

        //print input number
        System.out.println("Number : "+ number);

        //loop to reverse number
        while (number!=0) {
            digit=number%10; //extract rightmost digit
            reversedNumber=reversedNumber*10+digit; //create space and add digit to reversed number
            number/=10; //update number
        }

        //display reversed number
        System.out.println("Reversed number : "+ reversedNumber);
    }
}
