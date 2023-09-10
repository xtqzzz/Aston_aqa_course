package HomeWork2;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = {
                new Circle(5, "red", "black"),
                new Rectangle(3, 4, "green", "white"),
                new Triangle(3, 4, 5, "blue", "yellow")
        };

        for (Shape shape : shapes) {
            System.out.println("Площадь фигуры: " + shape.getArea());
            System.out.println("Периметр фигуры: " + shape.getPerimeter());
            System.out.println("Цвет заливки фигуры: " + shape.getFillColor());
            System.out.println("Цвет границы фигуры: " + shape.getBorderColor());
            System.out.println();
        }
    }
}

