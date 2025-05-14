// Write a Generic Swap Method
// Create a method that swaps two elements of any type (e.g., integers, strings).

public class GenericSwap {
    public static <T> void swap(T[] array, int index1, int index2) {
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void main(String[] args) {
        String[] words = {"Apple", "Banana"};
        swap(words, 0, 1);
        System.out.println("Swapped Strings: " + words[0] + ", " + words[1]);

        Integer[] numbers = {10, 20};
        swap(numbers, 0, 1);
        System.out.println("Swapped Integers: " + numbers[0] + ", " + numbers[1]);
    }
}
 
