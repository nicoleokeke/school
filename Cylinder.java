public class Cylinder extends Shape {
    // to represent the radius and height of the cylinder in feet
    private double radius;
    private double height;
    //----------------------------------
    //  Constructor: Sets up the cylinder.
    //----------------------------------

    public Cylinder(double h, double r)
    {
        super("Cylinder");
        height = h;
        radius = r;
    }
    //-----------------------------------------
    //  Returns the surface area of the cylinder.
    //-----------------------------------------

    public double area()
    {
        return Math.PI * radius * radius * height;
    }

    //-----------------------------------
    //  Returns the cylinder as a String.
    //-----------------------------------

    public String toString()
    {
        return super.toString() + " of height " + height + " and radius " + radius;
    }
}


