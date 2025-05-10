interface Walkable {
    void walk();
}

abstract class Mammal {
    abstract void eat();

    void sleep() {
        System.out.println("Mammal sleeps");
    }
}

class Human extends Mammal implements Walkable {
    public void walk() {
        System.out.println("Human walks on two legs");
    }

    void eat() {
        System.out.println("Human eats food");
    }
}

public class AbstractClassInterface{
    public static void main(String[] args) {
        Human h = new Human();
        h.walk();
        h.eat();
        h.sleep();
    }
}
 