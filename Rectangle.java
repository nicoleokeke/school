//*****************************************
//  Rectangle.java
//
//  Represents a rectangle.
//****************************************
public class Rectangle extends Shape {
    private double length, width; // used to represent the length and width of the rectangle in feet

    //----------------------------------
    //  Constructor: Sets up the rectangle.
    //----------------------------------

    public Rectangle(double l, double w)
    {
        super("Rectangle");
        length = l;
        width = w;
    }
    //-----------------------------------------
    //  Returns the surface area of the rectangle.
    //-----------------------------------------

    public double area()
    {
        return length * width;
    }

    //-----------------------------------
    //  Returns the rectangle as a String.
    //-----------------------------------

    public String toString()
    {
        return super.toString() + " of length " + length + " and width " + width;
    }
}
