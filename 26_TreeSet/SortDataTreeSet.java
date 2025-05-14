// Sort Data using TreeSet
// Insert names in TreeSet and show sorted order output.

import java.util.*;

public class SortDataTreeSet {
    public static void main(String[] args) {
        Set<String> names = new TreeSet<>();
        names.add("Zara");
        names.add("Adam");
        names.add("Mona");
        names.add("Bob");

        System.out.println("Sorted names: " + names);
    }
}
