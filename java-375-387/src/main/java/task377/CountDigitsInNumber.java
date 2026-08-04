package task377;

public class CountDigitsInNumber {
    void main(){
        int result=countDigits(999999);
        System.out.println(result);

    }

    public static int countDigits(int n){
        if (n<=0) return 0;
        return 1 + countDigits(n/10);
    }
}
