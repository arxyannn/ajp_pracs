import java.util.*;
import java.util.stream.*;

class Item {
    String name;
    String category;
    double price;

    Item(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }
}

class Order {
    String customerName;
    List<Item> items;

    Order(String customerName, List<Item> items) {
        this.customerName = customerName;
        this.items = items;
    }
}

public class CustomerOrderSimulator {

    public static void main(String[] args) {
        // Sample items
        Item tv = new Item("TV", "Electronics", 400.0);
        Item laptop = new Item("Laptop", "Electronics", 800.0);
        Item bread = new Item("Bread", "Groceries", 2.5);
        Item milk = new Item("Milk", "Groceries", 1.5);
        Item phone = new Item("Phone", "Electronics", 300.0);
        Item apple = new Item("Apple", "Groceries", 0.75);

        // Sample orders
        Order order1 = new Order("Alice", Arrays.asList(tv, bread, milk));
        Order order2 = new Order("Bob", Arrays.asList(laptop, apple));
        Order order3 = new Order("Charlie", Arrays.asList(phone, bread));

        List<Order> orders = Arrays.asList(order1, order2, order3);

        // Flatten all items and group by category to sum prices
        Map<String, Double> totalSalesByCategory = orders.stream()
            .flatMap(order -> order.items.stream())
            .collect(Collectors.groupingBy(
                item -> item.category,
                Collectors.summingDouble(item -> item.price)
            ));

        // Display the result
        System.out.println("Total Sales by Category:");
        totalSalesByCategory.forEach((category, total) -> {
            System.out.printf("- %s: $%.2f\n", category, total);
        });
    }
}