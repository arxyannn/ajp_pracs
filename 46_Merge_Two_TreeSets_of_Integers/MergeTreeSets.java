import java.util.TreeSet;

public class MergeTreeSets {

    // Method to merge two TreeSets
    public static TreeSet<Integer> mergeSets(TreeSet<Integer> set1, TreeSet<Integer> set2) {
        TreeSet<Integer> merged = new TreeSet<>(set1); // Copy first set
        merged.addAll(set2); // Add second set (duplicates automatically ignored)
        return merged;
    }

    public static void main(String[] args) {
        TreeSet<Integer> set1 = new TreeSet<>();
        set1.add(1);
        set1.add(3);
        set1.add(5);

        TreeSet<Integer> set2 = new TreeSet<>();
        set2.add(2);
        set2.add(3);
        set2.add(4);

        TreeSet<Integer> mergedSet = mergeSets(set1, set2);

        System.out.println("Merged TreeSet: " + mergedSet); // Output: [1, 2, 3, 4, 5]
    }
}