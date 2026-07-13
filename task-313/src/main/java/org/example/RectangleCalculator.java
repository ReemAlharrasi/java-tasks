package org.example;

public class RectangleCalculator {
    //attributes
    double length;
    double width;
    double area;
    double perimeter;

    //constructor
    public RectangleCalculator(double l, double w) {
        length = l;
        width = w;
    }

    //methods
    //Calculate the area and display it
    public void calculateArea() {
        area = length * width;
        System.out.println("The area of rectangle is = " + length + " * " + width + " = " + area);
    }

    //Calculate the perimeter and display it
    public void calculatePerimeter() {
        perimeter = 2 * length + 2 * width; //perimeter equation
        System.out.println("The perimeter of rectangle is = 2 x " + length + " + 2 x " + width + " = " + perimeter);
    }
}
