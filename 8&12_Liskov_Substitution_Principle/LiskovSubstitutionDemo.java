// File: LiskovSubstitutionDemo.java

// Shape interface defining behavior
interface Shape {
    int getArea();
}

// Rectangle implements Shape
class Rectangle implements Shape {
    protected int width;
    protected int height;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public int getArea() {
        return width * height;
    }
}

// Square also implements Shape independently
class Square implements Shape {
    private int side;

    public void setSide(int side) {
        this.side = side;
    }

    @Override
    public int getArea() {
        return side * side;
    }
}

// Test LSP
public class LiskovSubstitutionDemo {
    public static void printArea(Shape shape) {
        System.out.println("Area: " + shape.getArea());
    }

    public static void main(String[] args) {
        Rectangle rect = new Rectangle();
        rect.setWidth(5);
        rect.setHeight(10);

        Square square = new Square();
        square.setSide(7);

        // Substituting both into method expecting Shape — valid under LSP
        printArea(rect);   // Output: Area: 50
        printArea(square); // Output: Area: 49
    }
}
