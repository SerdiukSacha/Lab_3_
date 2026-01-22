package Java_Lab3;

public class Triangle extends Shape {
    private double base, height;
    public Triangle(String color, double b, double h) {
        super(color); this.base = b; this.height = h;
    }
    @Override public double calcArea() { return 0.5 * base * height; }
    @Override public String toString() {
        return "Triangle [" + super.toString() + ", base=" + base + ", height=" + height + ", area=" + calcArea() + "]";
    }

    public double getBase() {
        return base;
    }

    public double getHeight() {
        return height;
    }
}