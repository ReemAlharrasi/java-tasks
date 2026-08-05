package task393;

public class RaiseNumberToPower {
    void main(){
        System.out.println(" Raise a Number to a Power:");

        System.out.println("power(2, 10)  = "+power(2,10));

        System.out.println("power(3, 4)  = "+power(3,4));

        System.out.println("power(5, 3)  = "+power(5,3));

        System.out.println("power(2, 0)  = "+power(2,0));
    }

    public static int power(int b,int n){
        if (n==0) return 1;
        if (n<=1) return b;
        return b * power(b,n-1);
    }
}
