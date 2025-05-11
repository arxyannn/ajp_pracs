public class GenericBox<T> {
    private T content;

    public void setContent(T content) {
        this.content = content;
    }

    public T getContent() {
        return content;
    }

    public void displayContent() {
        System.out.println("Box contains: " + content);
    }

    public static void main(String[] args) {
        GenericBox<String> stringBox = new GenericBox<>();
        stringBox.setContent("Hello Generics");
        stringBox.displayContent();

        GenericBox<Integer> intBox = new GenericBox<>();
        intBox.setContent(42);
        intBox.displayContent();
    }
}
