package task396;

public class SumOfArrayElementsatEvenIndexes {
    void main() {
        System.out.println("Sum of Array Elements at Even Indexes");

        System.out.println("{10, 5, 20, 5, 30} : " + sumEvenIndex(new int[]{10, 5, 20, 5, 30}, 0));

        System.out.println("{1, 2, 3, 4}: " + sumEvenIndex(new int[]{1, 2, 3, 4}, 0));

        System.out.println("{7}: " + sumEvenIndex(new int[]{7}, 0));

        System.out.println("{2, 9}: " + sumEvenIndex(new int[]{2, 9}, 0));
    }

    public static int sumEvenIndex(int[] numbers, int index) {
        if (index == numbers.length) return 0; //done iterating
        if (index % 2 == 0) return numbers[index] + sumEvenIndex(numbers, index + 1);
        else return sumEvenIndex(numbers, index + 1);
    }

}
