package org.example;

public class Main {
    public static void main(String[] args) {
        //declare initial values
        double length = 12.5;
        double width = 8.0;

        //create object from the class calculatePerimeter
        RectangleCalculator rectangle = new RectangleCalculator(length, width);

        //call the object methods
        rectangle.main();
    }
}

