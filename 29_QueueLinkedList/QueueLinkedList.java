// Implement a Queue with LinkedList
// Simulate a task queue with enqueue, dequeue operations using LinkedList.

import java.util.*;

public class QueueLinkedList {
    public static void main(String[] args) {
        Queue<String> taskQueue = new LinkedList<>();

        taskQueue.add("Task 1");
        taskQueue.add("Task 2");
        taskQueue.add("Task 3");

        System.out.println("Initial Queue: " + taskQueue);

        taskQueue.remove(); // dequeue
        System.out.println("After Dequeue: " + taskQueue);

        taskQueue.add("Task 4");
        System.out.println("After Adding Task 4: " + taskQueue);
    }
}
