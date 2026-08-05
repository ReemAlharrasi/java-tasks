package task395;

public class CheckIfStringContainsCharacter {
    void main(){
        System.out.println("Count a Character in a String");

        System.out.println("hello and 'l': "+contains("hello",'l'));

        System.out.println("world and 'z' : "+contains("world",'z'));

        System.out.println("java and 'a': "+contains("java",'a'));

        System.out.println(" and 'x': "+contains("",'x'));
    }

    public static boolean contains(String word,char c){
        if (word.isEmpty()) return false;
        if (word.charAt(0)==c) return true;
        else return contains(word.substring(1), c);
    }
}
