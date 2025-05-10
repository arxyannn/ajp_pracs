import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelStreamComparison {
    public static void main(String[] args) {
        // Generate a list of 10 million integers
        List<Integer> numbers = IntStream.rangeClosed(1, 10_000_000)
                                         .boxed()
                                         .collect(Collectors.toList());

        // Process using normal stream
        long startTime = System.currentTimeMillis();
        long normalSum = numbers.stream()
                                .mapToLong(i -> i * 2)
                                .sum();
        long endTime = System.currentTimeMillis();
        System.out.println("Normal Stream Time: " + (endTime - startTime) + " ms");
        System.out.println("Sum (Normal): " + normalSum);

        // Process using parallel stream
        startTime = System.currentTimeMillis();
        long parallelSum = numbers.parallelStream()
                                  .mapToLong(i -> i * 2)
                                  .sum();
        endTime = System.currentTimeMillis();
        System.out.println("Parallel Stream Time: " + (endTime - startTime) + " ms");
        System.out.println("Sum (Parallel): " + parallelSum);
    }
}
