package task388;

public class ReverseString {
    void main() {
        System.out.println("Print a String in Reverse (One Character at a Time)");
        System.out.println("\ncat:");
        printReverse("cat");
        System.out.println("\nhello");
        printReverse("hello");

    }

    public static void printReverse(String word) {
        if (word.isEmpty()) return;
        printReverse(word.substring(1));
        System.out.println(word.charAt(0));
    }
}
