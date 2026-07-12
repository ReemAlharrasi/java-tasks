public class RectangleCalculator {
    //attributes
    double length;
    double width;
    double area;
    double perimeter;
    //constructor
    public  RectangleCalculator(double l, double w){
        length=l;
        width=w;
    }

    //methods
    public void calculateArea(){
        area = length*width;
        System.out.println("The area of rectangle is = " + length + " * " + width + " = " + area);
    }

    public void calculatePerimeter(){
        perimeter= 2*length+2*width;
        System.out.println("The perimeter of rectangle is = 2 x " + length + " + 2 x " + width + " = " + perimeter);
    }
}
