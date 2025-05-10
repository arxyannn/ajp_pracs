import java.util.*;

public class StudentGradesHashMap {
    public static void main(String[] args) {
        HashMap<Integer, String> grades = new HashMap<>();
        grades.put(101, "A");
        grades.put(102, "B+");
        grades.put(103, "A-");

        System.out.println("Grades: ");
        for (Map.Entry<Integer, String> entry : grades.entrySet()) {
            System.out.println("Roll No: " + entry.getKey() + " - Grade: " + entry.getValue());
        }
    }
}
