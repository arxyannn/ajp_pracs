class Animal {
    public Animal() {
        System.out.println("Animal object created!");
    }

    public void speak() {
        System.out.println("The animal makes a sound.");
    }
}

public class DynamicObjectCreationExample {
    public static void main(String[] args) {
        try {
            // Load the class dynamically using its fully qualified name
            Class<?> clazz = Class.forName("Animal");

            // Create an instance using the default constructor
            Object obj = clazz.getDeclaredConstructor().newInstance();

            // Cast to specific type if needed
            if (obj instanceof Animal) {
                Animal animal = (Animal) obj;
                animal.speak();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
