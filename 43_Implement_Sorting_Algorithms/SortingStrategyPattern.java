import java.util.Arrays;

// Strategy Interface
interface SortStrategy {
    void sort(int[] arr);
}

// Concrete Strategy: Bubble Sort
class BubbleSort implements SortStrategy {
    public void sort(int[] arr) {
        System.out.println("Using Bubble Sort...");
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
    }
}

// Concrete Strategy: Quick Sort
class QuickSort implements SortStrategy {
    public void sort(int[] arr) {
        System.out.println("Using Quick Sort...");
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); 
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
            }
        }
        int temp = arr[i+1]; arr[i+1] = arr[high]; arr[high] = temp;
        return i + 1;
    }
}

// Concrete Strategy: Merge Sort
class MergeSort implements SortStrategy {
    public void sort(int[] arr) {
        System.out.println("Using Merge Sort...");
        mergeSort(arr, 0, arr.length - 1);
    }

    private void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1, right);

            merge(arr, left, mid, right);
        }
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1, n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) L[i] = arr[left + i];
        for (int j = 0; j < n2; j++) R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2)
            arr[k++] = (L[i] <= R[j]) ? L[i++] : R[j++];

        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }
}

// Context Class
class SortContext {
    private SortStrategy strategy;

    public void setSortStrategy(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public void executeSort(int[] arr) {
        if (strategy != null) {
            strategy.sort(arr);
            System.out.println("Sorted Array: " + Arrays.toString(arr));
        } else {
            System.out.println("No sorting strategy selected.");
        }
    }
}

// Main Class
public class SortingStrategyPattern {
    public static void main(String[] args) {
        int[] data = { 64, 34, 25, 12, 22, 11, 90 };
        
        SortContext context = new SortContext();

        // Bubble Sort
        context.setSortStrategy(new BubbleSort());
        context.executeSort(Arrays.copyOf(data, data.length));

        // Quick Sort
        context.setSortStrategy(new QuickSort());
        context.executeSort(Arrays.copyOf(data, data.length));

        // Merge Sort
        context.setSortStrategy(new MergeSort());
        context.executeSort(Arrays.copyOf(data, data.length));
    }
}
