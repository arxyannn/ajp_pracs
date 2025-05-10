import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Person {
    private String name;
    private int age;

    public void sayHello() {
        System.out.println("Hello!");
    }

    public int getAge() {
        return age;
    }
}

public class ReflectionExample {
    public static void main(String[] args) {
        try {
            // Get Class object
            Class<?> clazz = Person.class;

            // Print class name
            System.out.println("Class Name: " + clazz.getName());

            // Get and print fields
            Field[] fields = clazz.getDeclaredFields();
            System.out.println("\nFields:");
            for (Field field : fields) {
                System.out.println("- " + field.getName());
            }

            // Get and print methods
            Method[] methods = clazz.getDeclaredMethods();
            System.out.println("\nMethods:");
            for (Method method : methods) {
                System.out.println("- " + method.getName());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
