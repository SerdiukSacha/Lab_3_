package Java_Lab3;

public class Circle extends Shape {
    private double radius;
    public Circle(String color, double r) {
        super(color); this.radius = r;
    }
    @Override public double calcArea() { return Math.PI * radius * radius; }
    @Override public String toString() {
        return "Circle [" + super.toString() + ", radius=" + radius + ", area=" + String.format("%.2f", calcArea()) + "]";
    }

    public double getRadius() {
        return radius;
    }
}