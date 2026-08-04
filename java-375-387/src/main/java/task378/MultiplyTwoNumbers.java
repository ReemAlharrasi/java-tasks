package task378;

public class MultiplyTwoNumbers {
    void main(){
        System.out.println("Multiply Two Numbers:");

        int result;

        result=multiply(3,4);
        System.out.println("3 x 4 = "+result);


        result=multiply(5,8);
        System.out.println("5 x 8 = "+result);
    }

    public static int multiply(int a,int b){
        if (b<=1) return a;
        return a + multiply(a,b-1);
    }
}
