package Java_Lab3;
import java.util.Arrays;
import java.util.Comparator;
import java.io.*;
import java.nio.charset.StandardCharsets;

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

    public void saveToFile(String filePath) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(filePath), StandardCharsets.UTF_8))) {

            for (Shape s : shapes) {
                bw.write(serializeShape(s));
                bw.newLine();
            }
        }
    }

    public void loadFromFile(String filePath) throws IOException {
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8))) {

            java.util.ArrayList<Shape> list = new java.util.ArrayList<>();
            String line;

            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;
                list.add(parseShape(line));
            }

            this.shapes = list.toArray(new Shape[0]);
        }
    }

    private String serializeShape(Shape s) {
        if (s instanceof Rectangle r) {
            return "Rectangle;" + r.shapeColor + ";" + r.getWidth() + ";" + r.getHeight();
        }
        if (s instanceof Circle c) {
            return "Circle;" + c.shapeColor + ";" + c.getRadius();
        }
        if (s instanceof Triangle t) {
            return "Triangle;" + t.shapeColor + ";" + t.getBase() + ";" + t.getHeight();
        }
        throw new IllegalArgumentException("Невідомий тип фігури: " + s.getClass().getName());
    }

    private Shape parseShape(String line) {
        // приймаємо і ';' і ',' як розділювач (на всяк випадок)
        String[] parts = line.split("[;,]");
        if (parts.length < 3) {
            throw new IllegalArgumentException("Некоректний рядок: " + line);
        }

        String type = parts[0].trim();
        String color = parts[1].trim();

        try {
            return switch (type) {
                case "Rectangle" -> {
                    if (parts.length != 4) throw new IllegalArgumentException("Rectangle має 4 поля: " + line);
                    double w = Double.parseDouble(parts[2].trim());
                    double h = Double.parseDouble(parts[3].trim());
                    yield new Rectangle(color, w, h);
                }
                case "Circle" -> {
                    if (parts.length != 3) throw new IllegalArgumentException("Circle має 3 поля: " + line);
                    double r = Double.parseDouble(parts[2].trim());
                    yield new Circle(color, r);
                }
                case "Triangle" -> {
                    if (parts.length != 4) throw new IllegalArgumentException("Triangle має 4 поля: " + line);
                    double b = Double.parseDouble(parts[2].trim());
                    double h = Double.parseDouble(parts[3].trim());
                    yield new Triangle(color, b, h);
                }
                default -> throw new IllegalArgumentException("Невідомий тип: " + type + " у рядку: " + line);
            };
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Некоректні числа у рядку: " + line, ex);
        }
    }

}