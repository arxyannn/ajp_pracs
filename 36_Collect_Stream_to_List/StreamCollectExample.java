import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamCollectExample {
    public static void main(String[] args) {
        // List of strings
        List<String> names = Arrays.asList("alice", "bob", "charlie", "david", "eve");

        // Convert list to stream, modify (convert to uppercase), and collect back into a list
        List<String> modifiedNames = names.stream()
                                          .map(String::toUpperCase)  // Convert each name to uppercase
                                          .collect(Collectors.toList());  // Collect into a list

        // Print the modified list
        System.out.println(modifiedNames);
    }
}
