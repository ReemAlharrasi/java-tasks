package task397;

public class ConvertNumberToBinary {
    void main() {
        System.out.println("Convert a Number to Binary (String)");

        System.out.println("toBinary(2) → " + toBinary(2));

        System.out.println("oBinary(5) → " + toBinary(5));

        System.out.println("oBinary(10) → " + toBinary(10));

        System.out.println("oBinary(1) → " + toBinary(1));

    }

    public static String toBinary(int number) {
        if (number <= 0) return "";
        if (number % 2 == 1) return toBinary(number / 2) + "1";
        else return toBinary(number / 2) + "0";
    }
}
