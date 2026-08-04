package task381;

public class PowerOf2Check {
    void main(){
        boolean result=isPowerOfTwo(14);
        System.out.println(result);

    }

    public static boolean isPowerOfTwo(int n){
        if (n==1) return true;
        else if (n==0 || n%2==1) return false;
        return isPowerOfTwo(n/2);
    }
}
