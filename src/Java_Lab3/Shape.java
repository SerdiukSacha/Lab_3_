package Java_Lab3;

public abstract class Shape implements Drawable {
    protected String shapeColor;

    public Shape(String shapeColor) {
        this.shapeColor = shapeColor;
    }

    public abstract double calcArea();

    @Override
    public String toString() {
        return "color=" + shapeColor;
    }

    @Override
    public void draw() {
        System.out.println("Drawing: " + this.toString());
    }
}