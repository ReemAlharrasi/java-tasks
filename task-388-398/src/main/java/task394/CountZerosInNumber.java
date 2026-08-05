package task394;

public class CountZerosInNumber {
    void main() {
        System.out.println("Count Zeros In Number:");

        System.out.println("countZeros(1020) → " + countZeros(1020));
        System.out.println("countZeros(5000) → " + countZeros(5000));
        System.out.println("countZeros(123) → " + countZeros(123));
        System.out.println("countZeros(908070) → " + countZeros(908070));
    }

    public static int countZeros(int n) {
        if (n <= 0) return 0;
        if (n % 10 == 0) return 1 + countZeros(n / 10);
        else return countZeros(n / 10);
    }
}
