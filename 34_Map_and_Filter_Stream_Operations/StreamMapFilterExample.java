import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMapFilterExample {
    public static void main(String[] args) {
        // List of names
        List<String> names = Arrays.asList("Alice", "Bob", "Anna", "David", "Alex", "Charlie");

        // Filter names starting with 'A' and convert them to uppercase
        List<String> filteredAndUppercaseNames = names.stream()
                .filter(name -> name.startsWith("A")) // Filter names starting with 'A'
                .map(String::toUpperCase) // Convert to uppercase
                .collect(Collectors.toList()); // Collect the result into a list

        // Print the final list
        filteredAndUppercaseNames.forEach(System.out::println);
    }
}
