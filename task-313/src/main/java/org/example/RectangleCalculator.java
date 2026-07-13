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
    public void main() {
        System.out.println("----- Rectangle -----");
        //print rectangle information
        System.out.println("length: "+length);
        System.out.println("width: "+width);

        //Calculate the area and display it
        System.out.println("----- Calculations -----");
        area = length * width;
        System.out.println("The area of rectangle is = " + length + " * " + width + " = " + area);

        //Calculate the perimeter and display it
        perimeter = 2 * length + 2 * width; //perimeter equation
        System.out.println("The perimeter of rectangle is = 2 x " + length + " + 2 x " + width + " = " + perimeter);
    }
}
