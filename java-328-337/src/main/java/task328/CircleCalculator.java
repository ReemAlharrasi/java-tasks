package task328;

import java.util.Scanner;

public class CircleCalculator {
    void main() {
        //initialize scanner to read from user
        Scanner input = new Scanner(System.in);

        //initialize variables
        float pi = 3.14F;
        float radius;
        String classification;

        //get input from user
        System.out.print("Enter the radius of the circle: ");
        radius = input.nextFloat();

        //validate radius input
        while (radius <= 0) {
            System.out.print("\nInvalid radius. Radius must be greater than zero.\nEnter thr radius of the circle: ");
            radius = input.nextFloat();
        }

        //Calculate area
        float area = pi * radius * radius;

        //calculate circumference
        float circumference = 2 * pi * radius;

        //classify circle size
        if (radius > 15) classification = "Large Circle";
        else if (radius >= 5) classification = "Medium Circle";
        else classification = "Small Circle";

        //display results
        System.out.println("\n----- Circle Calculator-----");
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + area);
        System.out.println("Circumference: " + circumference);
        System.out.println("Classification: " + classification);

        //close scanner
        input.close();
    }
}
