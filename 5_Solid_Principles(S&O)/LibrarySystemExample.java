import java.util.*;

// Book class (only stores book info - SRP)
class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
}

// Repository class - manages list of books (SRP)
class BookRepository {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getAllBooks() {
        return books;
    }
}

// Formatter interface - allows different output styles (OCP)
interface BookFormatter {
    String format(Book book);
}

// Simple format implementation (OCP)
class SimpleFormatter implements BookFormatter {
    public String format(Book book) {
        return book.getTitle();
    }
}

// Detailed format implementation (OCP)
class DetailedFormatter implements BookFormatter {
    public String format(Book book) {
        return book.getTitle() + " by " + book.getAuthor();
    }
}

// BookPrinter - uses formatter (SRP + OCP)
class BookPrinter {
    private BookFormatter formatter;

    public BookPrinter(BookFormatter formatter) {
        this.formatter = formatter;
    }

    public void print(Book book) {
        System.out.println(formatter.format(book));
    }
}

// Main class
public class LibrarySystemExample {
    public static void main(String[] args) {
        BookRepository repo = new BookRepository();
        repo.addBook(new Book("The Hobbit", "J.R.R. Tolkien"));
        repo.addBook(new Book("1984", "George Orwell"));

        BookPrinter simplePrinter = new BookPrinter(new SimpleFormatter());
        BookPrinter detailedPrinter = new BookPrinter(new DetailedFormatter());

        for (Book book : repo.getAllBooks()) {
            simplePrinter.print(book);
            detailedPrinter.print(book);
        }
    }
}