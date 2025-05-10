import java.util.Scanner;

// Furniture Interface
interface Furniture {
    void create();
}

// Concrete Furniture Classes
class Chair implements Furniture {
    public void create() {
        System.out.println("Chair created.");
    }
}

class Table implements Furniture {
    public void create() {
        System.out.println("Table created.");
    }
}

class Sofa implements Furniture {
    public void create() {
        System.out.println("Sofa created.");
    }
}

// Factory Class
class FurnitureFactory {
    public static Furniture getFurniture(String type) {
        switch (type.toLowerCase()) {
            case "chair": return new Chair();
            case "table": return new Table();
            case "sofa": return new Sofa();
            default: throw new IllegalArgumentException("Unknown furniture type: " + type);
        }
    }
}

// Main class
public class FurnitureFactoryDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter furniture type (Chair/Table/Sofa): ");
        String input = scanner.nextLine();

        try {
            Furniture furniture = FurnitureFactory.getFurniture(input);
            furniture.create();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}
