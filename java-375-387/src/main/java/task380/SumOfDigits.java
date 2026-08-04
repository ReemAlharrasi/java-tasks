package task380;

public class SumOfDigits {
    void main(){
        System.out.println("Sum of Digits:");

        int result;

        result=sumDigits(123);
        System.out.println("123 : "+result);

        result=sumDigits(4021);
        System.out.println("4021 : "+result);

    }

    public static int sumDigits(int n){
        if (n<=0) return 0;
        return (n%10) + sumDigits(n/10);
    }
}
