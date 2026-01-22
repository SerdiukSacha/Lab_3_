package Java_Lab3;

public class ShapeController {
    private ShapeModel model;
    private ShapeView view;

    public ShapeController(ShapeModel model, ShapeView view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        view.printMessage("--- Початковий набір даних ---");
        view.printData(model.getShapes());

        view.printMessage("\nЗагальна площа всіх фігур: " + String.format("%.2f", model.getTotalArea()));
        view.printMessage("Загальна площа Прямокутників: " + String.format("%.2f", model.getTotalAreaByType(Rectangle.class)));
        view.printMessage("Загальна площа Трикутників: " + String.format("%.2f", model.getTotalAreaByType(Triangle.class)));
        view.printMessage("Загальна площа Кіл: " + String.format("%.2f", model.getTotalAreaByType(Circle.class)));

        view.printMessage("\n--- Сортування за площею ---");
        model.sortByArea();
        view.printData(model.getShapes());

        view.printMessage("\n--- Сортування за кольором ---");
        model.sortByColor();
        view.printData(model.getShapes());
    }
}