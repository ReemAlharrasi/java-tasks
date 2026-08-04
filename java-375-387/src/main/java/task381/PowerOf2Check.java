package task381;

public class PowerOf2Check {
    void main(){
        System.out.println("Power of 2 Check:");
        boolean result;

        result=isPowerOfTwo(14);
        System.out.println("14: "+ result);


        result=isPowerOfTwo(32);
        System.out.println("32: "+ result);

    }

    public static boolean isPowerOfTwo(int n){
        if (n==1) return true;
        else if (n==0 || n%2==1) return false;
        return isPowerOfTwo(n/2);
    }
}
