package Java_Lab3;

public class ShapeView {
    public void printMessage(String msg) { System.out.println(msg); }

    public void printData(Shape[] shapes) {
        for (Shape s : shapes) System.out.println(s);
    }
}