package org.example;

public class NumberReversal {
    //attributes
    int number;
    int reversedNumber;
    int digit;

    //constructor
    public NumberReversal(int num){
        number=num;
    }
    //methods
    public void main(){
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
