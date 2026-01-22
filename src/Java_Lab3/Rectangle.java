package Java_Lab3;

public class Rectangle extends Shape {
    private double width, height;
    public Rectangle(String color, double w, double h) {
        super(color); this.width = w; this.height = h;
    }
    @Override public double calcArea() { return width * height; }
    @Override public String toString() {
        return "Rectangle [" + super.toString() + ", width=" + width + ", height=" + height + ", area=" + calcArea() + "]";
    }
}