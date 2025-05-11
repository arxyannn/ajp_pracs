// Reader-specific interface
interface IReader {
    void readPost(String post);
}

// Writer-specific interface
interface IWriter {
    void writePost(String content);
    void editPost(int postId, String newContent);
}

// Admin-specific interface
interface IAdmin {
    void blockPost(int postId);
    void editPost(int postId, String newContent);
}

// Reader only reads
class Reader implements IReader {
    public void readPost(String post) {
        System.out.println("Reader is reading post: " + post);
    }
}

// Writer can write and edit
class Writer implements IReader, IWriter {
    public void readPost(String post) {
        System.out.println("Writer is reading post: " + post);
    }

    public void writePost(String content) {
        System.out.println("Writer wrote: " + content);
    }

    public void editPost(int postId, String newContent) {
        System.out.println("Writer edited post " + postId + " to: " + newContent);
    }
}

// Admin can read, edit, and block
class Admin implements IReader, IAdmin {
    public void readPost(String post) {
        System.out.println("Admin is reading post: " + post);
    }

    public void blockPost(int postId) {
        System.out.println("Admin blocked post ID: " + postId);
    }

    public void editPost(int postId, String newContent) {
        System.out.println("Admin edited post " + postId + " to: " + newContent);
    }
}

// Main test program
public class BlogUserSystem {
    public static void main(String[] args) {
        Reader reader = new Reader();
        reader.readPost("SOLID Principles in Java");

        Writer writer = new Writer();
        writer.readPost("Design Patterns");
        writer.writePost("Observer Pattern Explained");
        writer.editPost(101, "Updated Observer Pattern");

        Admin admin = new Admin();
        admin.readPost("Security in Web Apps");
        admin.editPost(102, "Updated Security Post");
        admin.blockPost(102);
    }
}
