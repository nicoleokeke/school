public abstract class Shape {
    private String shape_Name;

    // create an abstract method to calculate the area of the shape

    public Shape (String m){
        shape_Name = m;
    }
    public abstract double area();

    // use a toString to return the name of the shape

    public String toString(){
        return shape_Name;
    }
}
