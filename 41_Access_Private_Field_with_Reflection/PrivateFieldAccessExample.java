import java.lang.reflect.Field;

class Employee {
    private String name = "John Doe";

    public void printName() {
        System.out.println("Name: " + name);
    }
}

public class PrivateFieldAccessExample {
    public static void main(String[] args) {
        try {
            // Create an instance of Employee
            Employee emp = new Employee();

            // Get the Class object
            Class<?> clazz = emp.getClass();

            // Access the private field 'name'
            Field nameField = clazz.getDeclaredField("name");

            // Make the private field accessible
            nameField.setAccessible(true);

            // Print the original value
            System.out.println("Original name: " + nameField.get(emp));

            // Modify the private field value
            nameField.set(emp, "Alice Smith");

            // Print the modified value using reflection
            System.out.println("Modified name (via reflection): " + nameField.get(emp));

            // Also use the method to print the name
            emp.printName();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
