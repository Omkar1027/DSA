import java.util.Scanner;

public class sortingTwo {

    static int n;
    static int[] arr = new int[500];
    static int[] arrTemp = new int[500];

    // QUICK SORT
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    // HEAP SORT
    public static void heapSort(int[] arr, int n) {
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    public static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest])
            largest = left;

        if (right < n && arr[right] > arr[largest])
            largest = right;

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }

    // BUCKET SORT
    public static void bucketSort(int[] arr, int n) {
        int maxVal = findMax(arr, n);
        int[] bucket = new int[maxVal + 1];

        for (int i = 0; i < n; i++) {
            bucket[arr[i]]++;
        }

        int index = 0;
        for (int i = 0; i < bucket.length; i++) {
            while (bucket[i] > 0) {
                arr[index++] = i;
                bucket[i]--;
            }
        }
    }

    public static int findMax(int[] arr, int n) {
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int choice = 0;
        Scanner ref = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        n = ref.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter arr[" + i + "]: ");
            arr[i] = ref.nextInt();
        }

        for (int i = 0; i < n; i++) {
            arrTemp[i] = arr[i];
        }

        do {
            System.out.println("1. Quick Sort \n2. Heap Sort \n3. Bucket Sort\n4. To Exit");
            System.out.println("Enter the choice");
            choice = ref.nextInt();
            if (choice != 4) {
                for (int i = 0; i < n; i++) {
                    arr[i] = arrTemp[i];
                }
            }

            switch (choice) {
                case 1:
                    quickSort(arr, 0, n - 1);
                    displayArray("Quick Sort", arr);
                    break;

                case 2:
                    heapSort(arr, n);
                    displayArray("Heap Sort", arr);
                    break;

                case 3:
                    bucketSort(arr, n);
                    displayArray("Bucket Sort", arr);
                    break;

                case 4:
                    break;

                default:
                    break;
            }
        } while (choice != 4);
    }

    public static void displayArray(String sortType, int[] arr) {
        int p;
        System.out.print("\nUNSORTED ARRAY:\n[");
        for (p = 0; p < n - 1; p++) {
            System.out.printf("%d, ", arrTemp[p]);
        }
        System.out.printf("%d]\n", arrTemp[p]);

        System.out.print("SORTED ARRAY (" + sortType + "):\n[");
        for (p = 0; p < n - 1; p++) {
            System.out.printf("%d, ", arr[p]);
        }
        System.out.printf("%d]\n", arr[p]);
    }
}
