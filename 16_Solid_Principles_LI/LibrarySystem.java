public class LibrarySystem {
    // Book class (SRP)
    static class Book {
        private String title;
        private String author;
        private String isbn;

        public Book(String title, String author, String isbn) {
            this.title = title;
            this.author = author;
            this.isbn = isbn;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        public String getIsbn() {
            return isbn;
        }
    }

    // Interfaces (ISP)
    interface Borrowable {
        void borrow();
        void returnItem();
    }

    interface Readable {
        void readSample();
    }

    // Abstract Class (OCP)
    static abstract class LibraryItem {
        protected Book book;

        public LibraryItem(Book book) {
            this.book = book;
        }

        public abstract void displayDetails();
    }

    // Concrete Class (LSP)
    static class LibraryBook extends LibraryItem implements Borrowable, Readable {
        public LibraryBook(Book book) {
            super(book);
        }

        @Override
        public void borrow() {
            System.out.println(book.getTitle() + " has been borrowed.");
        }

        @Override
        public void returnItem() {
            System.out.println(book.getTitle() + " has been returned.");
        }

        @Override
        public void readSample() {
            System.out.println("Reading sample of: " + book.getTitle());
        }

        @Override
        public void displayDetails() {
            System.out.println("Book: " + book.getTitle() + " by " + book.getAuthor());
        }
    }

    // Main method (DIP)
    public static void main(String[] args) {
        Book book1 = new Book("Harry Potter", "J.K. Rowling", "9780132350884");
        LibraryItem item = new LibraryBook(book1);

        item.displayDetails();

        if (item instanceof Borrowable) {
            ((Borrowable) item).borrow();
            ((Borrowable) item).returnItem();
        }

        if (item instanceof Readable) {
            ((Readable) item).readSample();
        }
    }
}
