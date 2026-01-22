package Java_Lab3;
import java.util.Arrays;
import java.util.Comparator;

public class ShapeModel {
    private Shape[] shapes;

    public ShapeModel(Shape[] shapes) {
        this.shapes = shapes;
    }

    public Shape[] getShapes() {
        return shapes;
    }

    public double getTotalArea() {
        double sum = 0;
        for (Shape s : shapes) sum += s.calcArea();
        return sum;
    }

    public double getTotalAreaByType(Class<?> type) {
        double sum = 0;
        for (Shape s : shapes) {
            if (type.isInstance(s)) sum += s.calcArea();
        }
        return sum;
    }

    public void sortByArea() {
        Arrays.sort(shapes, (s1, s2) -> Double.compare(s1.calcArea(), s2.calcArea()));
    }

    public void sortByColor() {
        Arrays.sort(shapes, Comparator.comparing(s -> s.shapeColor));
    }
}