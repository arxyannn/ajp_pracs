import java.util.*;

class Student {
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return id + " - " + name;
    }
}

public class CRUDArray {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();

        // Create
        students.add(new Student(1, "Alice"));
        students.add(new Student(2, "Bob"));

        // Read
        for (Student s : students) {
            System.out.println(s);
        }

        // Update
        students.get(0).name = "Alicia";

        // Delete
        students.remove(1);

        System.out.println("After Update/Delete:");
        for (Student s : students) {
            System.out.println(s);
        }
    }
}
