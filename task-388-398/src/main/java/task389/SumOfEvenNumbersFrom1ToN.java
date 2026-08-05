package task389;

public class SumOfEvenNumbersFrom1ToN {

    void main() {
        System.out.println("Sum of Even Numbers from 1 to N");

        System.out.println("2: " + sumEven(2));

        System.out.println("6: " + sumEven(6));

        System.out.println("10: " + sumEven(10));

        System.out.println("1: " + sumEven(1));
    }

    public static int sumEven(int n) {
        if (n <= 1) return 0; //base case
        if (n % 2 == 0) return n + sumEven(n - 1); //recursive call
        else return sumEven(n - 1);

    }
}
