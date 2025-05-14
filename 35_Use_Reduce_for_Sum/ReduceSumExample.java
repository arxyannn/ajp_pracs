// Use Reduce for Sum
// Use reduce() to calculate the sum of a list of integers.

import java.util.Arrays;
import java.util.List;

public class ReduceSumExample {
    public static void main(String[] args) {
        // List of integers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Use reduce to calculate the sum
        int sum = numbers.stream()
                         .reduce(0, (a, b) -> a + b);

        // Print the result
        System.out.println("Sum: " + sum);
    }
}
