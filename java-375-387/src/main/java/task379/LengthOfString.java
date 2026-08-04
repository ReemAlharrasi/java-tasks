package task379;

public class LengthOfString {
    void main(){
        int result;
        result=length("Hello");
        System.out.println(result);
        result=length("");
        System.out.println(result);
    }

    public static int length(String word){
        if (word.isEmpty()) return 0;
        return 1 + length(word.substring(1));
    }
}
