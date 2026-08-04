package task383;

public class CheckPalindrome {
    void main(){
        boolean result;
        result=isPalindrome("level");
        System.out.println("level: "+result);

        result=isPalindrome("hello");
        System.out.println("hello: "+result);

        result=isPalindrome("a");
        System.out.println("a: "+result);
    }

    public static boolean isPalindrome(String word){
        if (word.length()<=1) return true;
        char a=word.charAt(0);
        char b=word.charAt(word.length()-1);
        return a==b && isPalindrome(word.substring(1,word.length()-1));
    }
}
