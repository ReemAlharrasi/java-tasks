package task332;

import java.util.ArrayList;

public class NumberListStatistics {
    void main() {
        //create numbers list
        ArrayList<Integer> numbers = new ArrayList<Integer>();

        //add 20 values to numbers list
        numbers.add(12);
        numbers.add(-52);
        numbers.add(16);
        numbers.add(-63);
        numbers.add(42);
        numbers.add(67);
        numbers.add(36);
        numbers.add(-26);
        numbers.add(99);
        numbers.add(-78);
        numbers.add(0);
        numbers.add(-92);
        numbers.add(9);
        numbers.add(-634);
        numbers.add(88);
        numbers.add(-36);
        numbers.add(13);
        numbers.add(-35);
        numbers.add(66);
        numbers.add(-1);

        //initialize variables
        Integer sumOfNumbers = 0;
        Integer evenCount = 0;
        Integer oddCount = 0;
        Integer positiveCount = 0;
        Integer negativeCount = 0;
        float average;
        //assume largest and smallest are the first item in list
        Integer largestNumber = numbers.get(0);
        Integer smallestNumber = numbers.get(0);

        //loop through the list to extract needed values
        for (Integer num : numbers) {
            sumOfNumbers += num;
            //check even odd
            if (num % 2 == 0) evenCount++;
            else oddCount++;
            //check for positive negative
            if (num > 0) positiveCount++;
            else if (num < 0) negativeCount++;
            //check largest
            if (num > largestNumber) largestNumber = num;
            //check smallest
            if (num < smallestNumber) smallestNumber = num;
        }

        //calculate average
        average = (float) sumOfNumbers / numbers.size();

        //loop to display all numbers
        System.out.println("-----Numbers List-----");
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i) + "    ");
            if (i % 5 == 4) System.out.println();
        }
        System.out.println("----------------------");

        //display results
        System.out.println("Sum of numbers: " + sumOfNumbers);
        System.out.println("Average value: " + average);
        System.out.println("Largest number: " + largestNumber);
        System.out.println("Smallest number: " + smallestNumber);
        System.out.println("Count of even numbers: " + evenCount);
        System.out.println("Count of odd numbers: " + oddCount);
        System.out.println("Count of positive numbers: " + positiveCount);
        System.out.println("Count of negative numbers: " + negativeCount);


    }
}
