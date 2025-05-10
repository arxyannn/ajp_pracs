import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Student {
    private String name;
    private int rollNo;

    public void study() {
        System.out.println("Studying...");
    }

    public String getName() {
        return name;
    }
}

public class ReflectionInspector {
    public static void main(String[] args) {
        try {
            // Get the Class object for Student
            Class<?> clazz = Student.class;

            // Print class name
            System.out.println("Class Name: " + clazz.getName());

            // Get and print declared fields
            Field[] fields = clazz.getDeclaredFields();
            System.out.println("\nFields:");
            for (Field field : fields) {
                System.out.println("- " + field.getName());
            }

            // Get and print declared methods
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

