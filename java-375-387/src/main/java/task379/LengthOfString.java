package task379;

public class LengthOfString {
    void main(){
        System.out.println("Length Of a String:");
        int result;
        result=length("Hello");
        System.out.println("Hello: "+result);
        result=length("");
        System.out.println(":"+result);
    }

    public static int length(String word){
        if (word.isEmpty()) return 0;
        return 1 + length(word.substring(1));
    }
}
