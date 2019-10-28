abstract class Shape
{
    abstract void numberOfSides();
}
class Trapezoid extends Shape
{
    void numberOfSides()
    {
        System.out.println(" Trapezoidal has four sides");
    }
}
class Triangle extends Shape
{
    void numberOfSides()
    {
        System.out.println("Triangle has three sides");
    }
}
class Hexagon extends Shape
{
    void numberOfSides()
    {
        System.out.println("Hexagon has six sides");
    }
}
class ShapeDemo
{
    public static void main(String args[ ])
    {
        Trapezoid t=new Trapezoid();
        Triangle r=new Triangle();
        Hexagon h=new Hexagon();
        Shape s;
        s=t;
        s.numberOfSides();
        s=r;
        s.numberOfSides();
        s=h;
        s.numberOfSides();
    }
}