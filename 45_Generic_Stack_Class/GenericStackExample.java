import java.util.ArrayList;
import java.util.EmptyStackException;

class Stack<T> {
    private ArrayList<T> elements = new ArrayList<>();

    // Push an element onto the stack
    public void push(T item) {
        elements.add(item);
    }

    // Pop the top element
    public T pop() {
        if (elements.isEmpty()) {
            throw new EmptyStackException(); // error handling
        }
        return elements.remove(elements.size() - 1);
    }

    // Peek at the top element
    public T peek() {
        if (elements.isEmpty()) {
            throw new EmptyStackException(); // error handling
        }
        return elements.get(elements.size() - 1);
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return elements.isEmpty();
    }
}

// Test class
public class GenericStackExample {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        stack.push("A");
        stack.push("B");
        stack.push("C");

        System.out.println("Top element: " + stack.peek()); // C
        System.out.println("Popped: " + stack.pop());       // C
        System.out.println("Popped: " + stack.pop());       // B
        System.out.println("Is stack empty? " + stack.isEmpty()); // false
    }
}
