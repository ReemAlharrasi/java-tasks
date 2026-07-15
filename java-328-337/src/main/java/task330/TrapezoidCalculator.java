package task330;

import java.util.Scanner;

public class TrapezoidCalculator {
    //initialize scanner to read from user
    Scanner input = new Scanner(System.in);

    void main() {
        //initialize variables
        float base1;
        float base2;
        float height;
        float leg1;
        float leg2;
        String classification;

        //get input from user
        System.out.println("-----Trapezoid Inputs-----");
        base1 = inputCheck("Enter the base1 of the Trapezoid: ");
        base2 = inputCheck("Enter the base1 of the Trapezoid: ");
        height = inputCheck("Enter the height of the Trapezoid: ");
        leg1 = inputCheck("Enter the leg1 length of the Trapezoid: ");
        leg2 = inputCheck("Enter the leg2 length of the Trapezoid: ");

        //Calculate area
        float area = ((base1 + base2) * height) / 2;

        //calculate circumference
        float perimeter = base1 + base2 + leg1 + leg2;

        //classify circle size
        if (perimeter < 30) classification = "Small Trapezoid";
        else if (perimeter <= 60) classification = "Medium Trapezoid";
        else classification = "Large Trapezoid";

        //display results
        System.out.println("\n-----Trapezoid Calculator-----");
        System.out.println("Bases: " + base1 + " , " + base2);
        System.out.println("Height: " + height);
        System.out.println("legs length: " + leg1 + " , " + leg2);
        System.out.println("-------------------\nArea: " + area);
        System.out.println("Circumference: " + perimeter);
        System.out.println("Classification: " + classification);

        //close scanner
        input.close();
    }

    public float inputCheck(String prompt) {
        //initialize variable and read user input
        System.out.print(prompt);
        float num = input.nextFloat();

        //validate radius input
        while (num <= 0) { //repeat while num is less than or equal to 0
            System.out.print("All values must be greater than zero.\n" + prompt);
            num = input.nextFloat();
        }
        return num;
    }
}
