import java.util.*;

// Base class
abstract class Shape {
    abstract double getArea();
}

// Subclass 1: Circle
class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }
}

// Subclass 2: Rectangle
class Rectangle extends Shape {
    private double width, height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }
}

// Generic method using bounded type parameter
public class ShapeAreaCalculator {

    public static double calculateTotalArea(List<? extends Shape> shapes) {
        double total = 0;
        for (Shape shape : shapes) {
            total += shape.getArea();
        }
        return total;
    }

    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle(2));
        shapes.add(new Rectangle(3, 4));

        double totalArea = calculateTotalArea(shapes);
        System.out.println("Total Area: " + totalArea);
    }
}
