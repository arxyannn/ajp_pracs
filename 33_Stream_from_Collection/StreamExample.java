import java.util.Arrays;
import java.util.List;

public class StreamExample {
    public static void main(String[] args) {
        // List of integers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        // Convert list to stream and print each element
        numbers.stream().forEach(System.out::println);
    }
}
