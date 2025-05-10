
abstract class Animal {
    Animal() {
        System.out.println("Animal constructor called");
    }

    abstract void sound();
}

class Dog extends Animal {
    Dog() {
        System.out.println("Dog constructor called");
    }

    void sound() {
        System.out.println("Bark");
    }
}

public class AbstractClass {
    public static void main(String[] args) {
        Animal dog = new Dog();
        dog.sound();
    }
}
 