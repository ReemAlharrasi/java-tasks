package task385;

public class SumOfArray {
    void main() {
        System.out.println("Sum of an Array");

        int result;
        result = sumArray(new int[]{1, 2, 3}, 0);
        System.out.println("{1, 2, 3} : " + result);

        result = sumArray(new int[]{10, 20, 30, 40}, 0);
        System.out.println("{10,20,30,40}: " + result);

        result = sumArray(new int[]{5}, 0);
        System.out.println("{5}: " + result);

        result = sumArray(new int[]{}, 0);
        System.out.println("{}: " + result);
    }

    public static int sumArray(int[] numbers, int index) {
        if (index == numbers.length) return 0; //done iterating
        return numbers[index] + sumArray(numbers, index + 1);
    }
}
