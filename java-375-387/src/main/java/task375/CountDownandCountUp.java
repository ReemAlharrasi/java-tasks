package task375;

public class CountDownandCountUp {
    void main(){
        countDownUp(4);
    }

    public static void countDownUp(int n){
        System.out.println(n); //print count down
        if (n<=1) return; //base case
        countDownUp(n-1); //recursive call
        System.out.println(n); //print count up

    }
}
