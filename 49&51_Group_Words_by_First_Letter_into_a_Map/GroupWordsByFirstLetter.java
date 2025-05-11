import java.util.*;
import java.util.stream.*;

public class GroupWordsByFirstLetter {

    public static void main(String[] args) {
        // Input array of words
        String[] words = {
            "apple", "banana", "apricot", "blueberry", "avocado",
            "cherry", "carrot", "cranberry", "almond", "date"
        };

        // ✅ Use streams to group and sort
        Map<Character, List<String>> groupedWords = Arrays.stream(words)
            .collect(Collectors.groupingBy(
                word -> Character.toLowerCase(word.charAt(0)), // group key
                Collectors.collectingAndThen(
                    Collectors.toList(),
                    list -> {
                        list.sort(String::compareToIgnoreCase); // sort group
                        return list;
                    }
                )
            ));

        // ✅ Print the result
        System.out.println("Grouped and Sorted Words:");
        groupedWords.forEach((letter, wordList) -> {
            System.out.println(letter + ": " + wordList);
        });
    }
}
