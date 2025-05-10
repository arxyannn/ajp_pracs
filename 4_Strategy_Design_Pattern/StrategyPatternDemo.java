// File: StrategyPatternDemo.java

interface SortStrategy {
    void sort(int[] arr);
}

class BubbleSort implements SortStrategy {
    @Override
    public void sort(int[] arr) {
        System.out.println("Using Bubble Sort:");
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}

class QuickSort implements SortStrategy {
    @Override
    public void sort(int[] arr) {
        System.out.println("Using Quick Sort:");
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                // swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // swap pivot
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}

class SortContext {
    private SortStrategy strategy;

    public void setStrategy(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public void executeSort(int[] arr) {
        if (strategy != null) {
            strategy.sort(arr);
        } else {
            System.out.println("No sorting strategy set.");
        }
    }

    public void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

public class StrategyPatternDemo {
    public static void main(String[] args) {
        SortContext context = new SortContext();
        int[] data1 = {5, 2, 9, 1, 5, 6};
        int[] data2 = data1.clone();

        // Use Bubble Sort
        context.setStrategy(new BubbleSort());
        context.executeSort(data1);
        context.printArray(data1);

        // Use Quick Sort
        context.setStrategy(new QuickSort());
        context.executeSort(data2);
        context.printArray(data2);
    }
}
