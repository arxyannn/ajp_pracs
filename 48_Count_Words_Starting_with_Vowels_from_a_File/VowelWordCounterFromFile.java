import java.io.*;
import java.util.*;

public class VowelWordCounterFromFile {

    public static boolean startsWithVowel(String word) {
        if (word.isEmpty()) return false;
        char firstChar = Character.toLowerCase(word.charAt(0));
        return firstChar == 'a' || firstChar == 'e' || firstChar == 'i' ||
               firstChar == 'o' || firstChar == 'u';
    }

    public static int countVowelWords(List<String> words) {
        int count = 0;
        for (String word : words) {
            if (startsWithVowel(word)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        List<String> words = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File("words.txt"))) {
            while (scanner.hasNext()) {
                words.add(scanner.next());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            return;
        }

        int result = countVowelWords(words);
        System.out.println("Words starting with vowels: " + result);
    }
}
