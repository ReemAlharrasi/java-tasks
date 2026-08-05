package task390;

public class CountOccurrencesOfDigitInNumber {
    void main(){
        System.out.println("Count Occurrences of a Digit in a Number:");

        System.out.println("countDigit(2222, 2): "+countDigit(2222,2));

        System.out.println("countDigit(12321, 1): "+countDigit(12321,1));

        System.out.println("countDigit(5050, 0): "+countDigit(5050,0));

        System.out.println("countDigit(789, 6): "+countDigit(789,6));

    }

    public static int countDigit(int number,int digit){
        if (number<=0) return 0;

        if (number%10==digit) return 1 + countDigit(number/10,digit);
        else return countDigit(number/10,digit);
    }
}
