import java.util.*;

// 1. Order class (SRP)
class Order {
    private List<String> items = new ArrayList<>();
    private List<Double> prices = new ArrayList<>();

    public void addItem(String item, double price) {
        items.add(item);
        prices.add(price);
    }

    public List<String> getItems() {
        return items;
    }

    public double getTotalPrice() {
        return prices.stream().mapToDouble(Double::doubleValue).sum();
    }
}

// 2. Viewer Interface (OCP, DIP)
interface OrderViewer {
    void view(Order order);
}

// 3. Console viewer (initial)
class ConsoleOrderViewer implements OrderViewer {
    public void view(Order order) {
        System.out.println("Viewing Order:");
        for (String item : order.getItems()) {
            System.out.println("- " + item);
        }
    }
}

// 4. Email viewer (extended requirement)
class EmailOrderViewer implements OrderViewer {
    public void view(Order order) {
        System.out.println("Sending order via Email...");
        System.out.println("Items:");
        for (String item : order.getItems()) {
            System.out.println("- " + item);
        }
        System.out.println("Total: $" + order.getTotalPrice());
        System.out.println("Email sent successfully (simulated).");
    }
}

// 5. Service class using dependency injection (DIP)
class OrderService {
    private OrderViewer viewer;

    public OrderService(OrderViewer viewer) {
        this.viewer = viewer;
    }

    public void processOrder(Order order) {
        viewer.view(order);
    }
}

// 6. Main class
public class FoodDeliveryApp {
    public static void main(String[] args) {
        Order order = new Order();
        order.addItem("Burger", 5.99);
        order.addItem("Fries", 2.49);
        order.addItem("Soda", 1.50);

        // View using console (initial)
        OrderService service1 = new OrderService(new ConsoleOrderViewer());
        service1.processOrder(order);

        System.out.println("\n--- After Requirement Change ---\n");

        // View using email (extended requirement)
        OrderService service2 = new OrderService(new EmailOrderViewer());
        service2.processOrder(order);
    }
}