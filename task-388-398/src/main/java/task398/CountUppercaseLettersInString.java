package task398;

public class CountUppercaseLettersInString {
    void main(){
        System.out.println("Count a Character in a String");

        System.out.println("Hello: "+countUpper("hello"));

        System.out.println("JavaProgram : "+countUpper("JavaProgram"));

        System.out.println("ABC: "+countUpper("ABC"));

        System.out.println("lower: "+countUpper("lower"));

    }


    public static int countUpper(String word){
        if (word.isEmpty()) return 0;
        if (Character.isUpperCase(word.charAt(0))) return 1 + countUpper(word.substring(1));
        else return countUpper(word.substring(1));
    }
}
