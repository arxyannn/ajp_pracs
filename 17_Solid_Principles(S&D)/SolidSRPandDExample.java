// S: Handles only book data
class Book {
    private String title;

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

// D: Abstraction for notifications
interface NotificationService {
    void notifyUser(String message);
}

// D: Email service (depends on abstraction)
class EmailService implements NotificationService {
    public void notifyUser(String message) {
        System.out.println("Email sent: " + message);
    }
}

// S + D: Manages borrowing and uses NotificationService (SRP + DIP)
class LibraryManager {
    private NotificationService notificationService;

    public LibraryManager(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void borrowBook(Book book) {
        // SRP: Logic only for borrowing
        System.out.println("Borrowed book: " + book.getTitle());
        notificationService.notifyUser("You borrowed the book - " + book.getTitle());
    }
}

// Main class to test
public class SolidSRPandDExample {
    public static void main(String[] args) {
        Book book = new Book("Clean Code");
        NotificationService emailService = new EmailService();
        LibraryManager manager = new LibraryManager(emailService);

        manager.borrowBook(book);
    }
}
