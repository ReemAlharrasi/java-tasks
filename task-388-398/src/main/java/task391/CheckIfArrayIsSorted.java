package task391;

public class CheckIfArrayIsSorted {
    void main() {
        System.out.println("Check if an Array is Sorted");

        System.out.println("{1, 2, 3, 4} : " + isSorted(new int[]{1, 2, 3, 4}, 0));

        System.out.println("{1, 5, 2, 8}: " + isSorted(new int[]{1, 5, 2, 8}, 0));

        System.out.println("{10, 20, 30}: " + isSorted(new int[]{10, 20, 30}, 0));

        System.out.println("{3, 3, 3}: " + isSorted(new int[]{3, 3, 3}, 0));
    }

    public static boolean isSorted(int[] numbers, int index) {
        if (index == numbers.length-1) return true; //done iterating
        if (numbers[index]<=numbers[index+1]) return isSorted(numbers, index + 1);
        else return false;
    }
}
