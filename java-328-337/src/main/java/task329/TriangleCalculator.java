package task329;

import java.util.Scanner;

public class TriangleCalculator {

    //initialize scanner to read from user
    Scanner input = new Scanner(System.in);

    void main() {
        //initialize variables
        float base;
        float height;
        float side1;
        float side2;
        float side3;
        String classification;

        //get input from user
        System.out.println("-----Triangle Inputs-----");
        base = inputCheck("Enter the base of the triangle: ");
        height = inputCheck("Enter the height of the triangle: ");
        side1 = inputCheck("Enter the side1 length of the triangle: ");
        side2 = inputCheck("Enter the side2 length of the triangle: ");
        side3 = inputCheck("Enter the side3 length of the triangle: ");

        //Calculate area
        float area = (base * height) / 2;

        //calculate circumference
        float perimeter = side1 + side2 + side3;

        //classify circle size
        if (side1 == side2 && side2 == side3) classification = " Equilateral Triangle";
        else if (side1 == side2 || side2 == side3 || side1 == side3) classification = " Isosceles Triangle";
        else classification = "Scalene Triangle";

        //display results
        System.out.println("\n-----Triangle Calculator-----");
        System.out.println("Base: " + base);
        System.out.println("Height: " + height);
        System.out.println("Sides length: " + side1 + " , " + side2 + " , " + side3);
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
