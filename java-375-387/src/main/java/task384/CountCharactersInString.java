package task384;

public class CountCharactersInString {
    void main(){
        System.out.println("Count a Character in a String");
        int result;
        result=countChar("banana",'a');
        System.out.println("banana and 'a' : "+result);

        result=countChar("hello",'l');
        System.out.println("hello and 'l': "+result);

        result=countChar("apple",'z');
        System.out.println("apple and 'z': "+result);

        result=countChar("mississippi",'s');
        System.out.println("mississippi and 's': "+result);
    }

    public static int countChar(String word,char c){
        if (word.isEmpty()) return 0;
        if (word.charAt(0)==c) return 1 + countChar(word.substring(1),c);
        else return countChar(word.substring(1), c);
    }
}
