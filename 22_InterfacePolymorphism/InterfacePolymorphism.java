// Use Interface for Polymorphism
// Demonstrate how different implementations of an interface can be used interchangeably.

interface Drawable {
    void draw();
}

class Circle implements Drawable {
    public void draw() {
        System.out.println("Drawing Circle");
    }
}

class Rectangle implements Drawable {
    public void draw() {
        System.out.println("Drawing Rectangle");
    }
}

public class InterfacePolymorphism {
    public static void main(String[] args) {
        Drawable d1 = new Circle();
        Drawable d2 = new Rectangle();
        d1.draw();
        d2.draw();
    }
}
