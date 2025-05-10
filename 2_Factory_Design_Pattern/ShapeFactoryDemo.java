// File: ShapeFactoryDemo.java

interface Shape {
    void draw();
}

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Circle.");
    }
}

class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Square.");
    }
}

class ShapeFactory {
    public Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }

        switch (shapeType.toLowerCase()) {
            case "circle":
                return new Circle();
            case "square":
                return new Square();
            default:
                System.out.println("Unknown shape type: " + shapeType);
                return null;
        }
    }
}

public class ShapeFactoryDemo {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        Shape shape1 = shapeFactory.getShape("circle");
        if (shape1 != null) shape1.draw();

        Shape shape2 = shapeFactory.getShape("square");
        if (shape2 != null) shape2.draw();

        Shape shape3 = shapeFactory.getShape("triangle");
        if (shape3 != null) shape3.draw(); // Should print error for unknown shape
    }
}
