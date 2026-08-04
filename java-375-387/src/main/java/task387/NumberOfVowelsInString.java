package task387;

public class NumberOfVowelsInString {
    void main(){
        System.out.println("Number of Vowels in a String");
        int result;
        result=countVowels("hello".toLowerCase());
        System.out.println("hello: "+result);

        result=countVowels("programming".toLowerCase());
        System.out.println("programming: "+result);

        result=countVowels("sky".toLowerCase());
        System.out.println("sky: "+result);

        result=countVowels("aeiou".toLowerCase());
        System.out.println("aeiou: "+result);
    }

    public static int countVowels(String word){
        if (word.isEmpty()) return 0;
        if (word.charAt(0)=='a' || word.charAt(0)=='e'|| word.charAt(0)=='i' || word.charAt(0)=='o'|| word.charAt(0)=='u') return 1 + countVowels(word.substring(1));
        else return countVowels(word.substring(1));
    }
}
