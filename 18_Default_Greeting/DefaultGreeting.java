
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
