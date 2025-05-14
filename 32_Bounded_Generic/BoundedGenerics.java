// Bounded Generics Example
// Create a generic method to print numeric values only using bounded type parameters.

public  class BoundedGenerics {
    public static <T extends Number> void printDoubleValue(T number) {
        double value = number.doubleValue();
        System.out.println("Double value: " + value);
    }

    public static void main(String[] args) {
        printDoubleValue(10);          // Integer
        printDoubleValue(15.5f);       // Float
        printDoubleValue(42.42);       // Double

    }
}

