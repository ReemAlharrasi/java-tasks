package task386;

import java.util.Arrays;

public class FindMaximumInArray {
    void main() {
        System.out.println("Find the Maximum in an Array");

        int result;

        result = findMax(new int[]{3, 7, 2, 9, 4}, 0, 0);
        System.out.println("{[3, 7, 2, 9, 4]} : " + result);

        result = findMax(new int[]{1, 1, 1}, 0, 0);
        System.out.println("{1, 1, 1}: " + result);

        result = findMax(new int[]{-5, -2, -8}, 0, 0);
        System.out.println("{-5, -2, -8}: " + result);

        result = findMax(new int[]{42}, 0, 0);
        System.out.println("{42}: " + result);
    }

    public static int findMax(int[] numbers, int currentIndex, int maxIndex) {
        if (numbers.length==currentIndex) return numbers[maxIndex];

        //update max: compare max with current index
        if (numbers[currentIndex]>numbers[maxIndex])maxIndex=currentIndex;

        //recursive call
        return findMax(numbers,currentIndex+1, maxIndex);
    }
}
