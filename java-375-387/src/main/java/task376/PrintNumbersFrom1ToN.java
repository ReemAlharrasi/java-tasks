package task376;

public class PrintNumbersFrom1ToN {
    void main() {
        System.out.println("Print Numbers From 1 To N\nn=5 >"); //print count up
        printUp(5);
    }

    //recursive function
    public static void printUp(int n) {
        if (n <= 0) return; //base case
        printUp(n - 1); //recursive call
        System.out.println(n); //print count up

    }

}
