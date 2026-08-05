package task392;

public class RemoveCharacterfromString {
    void main() {
        System.out.println("Remove a Character from a String");
        String result;
        result = removeCh("banana", 'a');
        System.out.println("banana and 'a' : " + result);

        result = removeCh("hello", 'l');
        System.out.println("hello and 'l': " + result);

        result = removeCh("mississippi", 's');
        System.out.println("mississippi and 's': " + result);

        result = removeCh("abc", 'z');
        System.out.println("abc and 'z': " + result);
    }

    public static String removeCh(String word, char c) {
        if (word.isEmpty()) return "";
        if (word.charAt(0) == c) return  removeCh(word.substring(1), c);
        else return word.charAt(0) + removeCh(word.substring(1), c);
    }
}
