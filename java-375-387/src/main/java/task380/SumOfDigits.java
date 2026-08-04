package task380;

public class SumOfDigits {
    void main(){
        int result=sumDigits(4021);
        System.out.println(result);

    }

    public static int sumDigits(int n){
        if (n<=0) return 0;
        return (n%10) + sumDigits(n/10);
    }
}
