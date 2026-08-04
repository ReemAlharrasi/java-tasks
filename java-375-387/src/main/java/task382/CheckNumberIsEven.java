package task382;

public class CheckNumberIsEven {
    void main(){
        System.out.println("Check if a Number is Even");

        boolean result;

        result=isEven(0);
        System.out.println("0 "+ result);

        result=isEven(7);
        System.out.println("7 "+result);

        result=isEven(100);
        System.out.println("100 "+result);

    }

    public static boolean isEven(int n){
        if (n==0) return true;
        else if (n==1) return false;
        return isEven(n-2);
    }
}
