package Java_Lab3;

import java.util.Scanner;

public class ShapeController {
    private ShapeModel model;
    private ShapeView view;

    public ShapeController(ShapeModel model, ShapeView view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            view.printMenu();
            String cmd = sc.nextLine().trim();

            switch (cmd) {
                case "1" -> {
                    view.printMessage("--- Поточний набір фігур ---");
                    view.printData(model.getShapes());
                }
                case "2" -> {
                    view.printMessage("\nЗагальна площа всіх фігур: " + String.format("%.2f", model.getTotalArea()));
                    view.printMessage("Загальна площа Прямокутників: " + String.format("%.2f", model.getTotalAreaByType(Rectangle.class)));
                    view.printMessage("Загальна площа Трикутників: " + String.format("%.2f", model.getTotalAreaByType(Triangle.class)));
                    view.printMessage("Загальна площа Кіл: " + String.format("%.2f", model.getTotalAreaByType(Circle.class)));
                }
                case "3" -> {
                    model.sortByArea();
                    view.printMessage("--- Сортування за площею ---");
                    view.printData(model.getShapes());
                }
                case "4" -> {
                    model.sortByColor();
                    view.printMessage("--- Сортування за кольором ---");
                    view.printData(model.getShapes());
                }
                case "5" -> { // SAVE
                    view.printMessage("Введіть шлях до файлу для збереження (наприклад shapes.txt): ");
                    String path = sc.nextLine().trim();
                    try {
                        model.saveToFile(path);
                        view.printMessage("Збережено у файл: " + path);
                    } catch (Exception e) {
                        view.printMessage("Помилка збереження: " + e.getMessage());
                    }
                }
                case "6" -> { // LOAD
                    view.printMessage("Введіть шлях до файлу для читання (наприклад shapes.txt): ");
                    String path = sc.nextLine().trim();
                    try {
                        model.loadFromFile(path);
                        view.printMessage("Завантажено з файлу: " + path);
                        view.printMessage("--- Новий набір фігур ---");
                        view.printData(model.getShapes());
                    } catch (Exception e) {
                        view.printMessage("Помилка читання: " + e.getMessage());
                    }
                }
                case "0" -> {
                    view.printMessage("Вихід...");
                    return;
                }
                default -> view.printMessage("Невідома команда. Спробуйте ще раз.");
            }
        }
    }
}
