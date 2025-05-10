import java.util.ArrayList;
import java.util.Scanner;

// Book class
class Book {
    private String title;
    private String author;
    private String isbn;

    // Constructor
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    // Getters
    public String getISBN() {
        return isbn;
    }

    public String toString() {
        return "Title: " + title + ", Author: " + author + ", ISBN: " + isbn;
    }
}

// Library Manager class
public class LibraryManager {
    private ArrayList<Book> collection = new ArrayList<>();

    // Add a book
    public void addBook(Book book) {
        collection.add(book);
        System.out.println("Book added successfully.");
    }

    // Remove a book by ISBN
    public void removeBook(String isbn) {
        boolean removed = collection.removeIf(book -> book.getISBN().equals(isbn));
        if (removed) {
            System.out.println("Book with ISBN " + isbn + " removed.");
        } else {
            System.out.println("Book not found.");
        }
    }

    // Display all books
    public void displayBooks() {
        if (collection.isEmpty()) {
            System.out.println("Library is empty.");
        } else {
            System.out.println("Library Collection:");
            for (Book book : collection) {
                System.out.println(book);
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        LibraryManager manager = new LibraryManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Menu:");
            System.out.println("1. Add Book\n2. Remove Book by ISBN\n3. Display All Books\n4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // clear newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();
                    manager.addBook(new Book(title, author, isbn));
                    break;
                case 2:
                    System.out.print("Enter ISBN to remove: ");
                    String removeISBN = scanner.nextLine();
                    manager.removeBook(removeISBN);
                    break;
                case 3:
                    manager.displayBooks();
                    break;
                case 4:
                    System.out.println("Exiting Library Manager.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
