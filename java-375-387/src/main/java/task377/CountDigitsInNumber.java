package task377;

public class CountDigitsInNumber {
    void main(){
        System.out.println("Count Digits In Number:");

        int result=countDigits(999999);
        System.out.println("999999: "+result);

    }

    public static int countDigits(int n){
        if (n<=0) return 0;
        return 1 + countDigits(n/10);
    }
}
