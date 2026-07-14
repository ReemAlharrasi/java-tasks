package task314;

public class EvenNumberAnalyzer {
    public void main() {
        //variables
        int limit = 20;
        int count = 0;
        int sum = 0;

        System.out.println("----- Even numbers From 1 to "+limit+" -----");
        //loop to go through numbers
        for (int i = 1; i <= limit; i++) {
            if (i % 2 == 0) { // if i is even
                System.out.print(i + "  ");
                count += 1; //increment count by 1
                sum += i; //add i to sum
            }
        }

        //display results
        System.out.println("\n----- Analyzer Results -----"); // \n means go to next line
        System.out.println("Total count of even numbers: " + count);
        System.out.println("Total sum of even numbers: " + sum);
    }
}
