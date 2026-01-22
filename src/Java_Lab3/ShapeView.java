package Java_Lab3;

public class ShapeView {
    public void printMessage(String msg) { System.out.println(msg); }

    public void printData(Shape[] shapes) {
        for (Shape s : shapes) System.out.println(s);
    }

    public void printMenu() {
        System.out.println("\n===== МЕНЮ =====");
        System.out.println("1 - Показати фігури");
        System.out.println("2 - Порахувати площі");
        System.out.println("3 - Сортування за площею");
        System.out.println("4 - Сортування за кольором");
        System.out.println("5 - Зберегти у файл");
        System.out.println("6 - Завантажити з файлу");
        System.out.println("0 - Вийти");
        System.out.print("Команда: ");
    }
}