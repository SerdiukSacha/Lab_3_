packMain {
    public static void main(String[] args) {
        // Змінені параметри: інші кольори та розміри
        Shape[] shapes = {
                new Rectangle("White", 15, 3),
                new Circle("Purple", 8),
                new Triangle("Orange", 12, 4),
                new Circle("Pink", 2.5),
                new Rectangle("Black", 5, 5),
                new Triangle("Cyan", 9, 2),
                new Rectangle("Brown", 20, 10),
                new Circle("Gray", 4),
                new Triangle("Magenta", 15, 6),
                new Rectangle("Gold", 6, 2)
        };

        ShapeModel model = new ShapeModel(shapes);
        ShapeView view = new ShapeView();
        ShapeController controller = new ShapeController(model, view);

        controller.run();
    }
}