package task313;

public class RectangleCalculator {
    public void main() {
        double length= 12.5;
        double width= 8.0;
        double area;
        double perimeter;

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
