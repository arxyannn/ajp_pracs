//Apply Dependency Inversion Principle
//Demonstrate loose coupling by injecting service objects through constructors or interfaces.

// Abstraction
interface NotificationService {
    void sendNotification(String message);
}

// Low-level module: Email
class EmailService implements NotificationService {
    public void sendNotification(String message) {
        System.out.println("Sending Email: " + message);
    }
}

// Low-level module: SMS
class SMSService implements NotificationService {
    public void sendNotification(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

// High-level module that depends on the abstraction
class LibraryManager {
    private NotificationService notificationService;

    // Constructor Injection (DIP in action)
    public LibraryManager(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void notifyUser(String message) {
        notificationService.sendNotification(message);
    }
}

// Main class to test
public class DependencyInversionExample {
    public static void main(String[] args) {
        // Use Email
        NotificationService email = new EmailService();
        LibraryManager manager1 = new LibraryManager(email);
        manager1.notifyUser("Your book is due tomorrow.");

        // Use SMS
        NotificationService sms = new SMSService();
        LibraryManager manager2 = new LibraryManager(sms);
        manager2.notifyUser("Your reserved book is now available.");
    }
}
