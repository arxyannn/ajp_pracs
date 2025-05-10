import java.util.*;

public class RemoveDuplicatesHashSet {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Alice", "John", "Bob");
        Set<String> uniqueNames = new HashSet<>(names);

        System.out.println("Original names: " + names);
        System.out.println("Unique names: " + uniqueNames);
    }
}
