// Use Interface with Default Method
// Create an interface with a default greeting method and override it in the implementing class.

interface Greeting {
    default void sayHello() {
        System.out.println("Hello from default method!");
    }
}

class EnglishGreeting implements Greeting {
    @Override
    public void sayHello() {
        System.out.println("Hello from EnglishGreeting!");
    }
}


public class DefaultGreeting {
    public static void main(String[] args) {
        Greeting greeting = new EnglishGreeting();
        greeting.sayHello();
    }
}
