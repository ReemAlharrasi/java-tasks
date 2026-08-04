package task378;

public class MultiplyTwoNumbers {
    void main(){
        int result=multiply(3,4);
        System.out.println(result);
    }

    public static int multiply(int a,int b){
        if (b<=1) return a;
        return a + multiply(a,b-1);
    }
}
