import java.util.*;

public class chainHashing {
    static int n;
    static LinkedList<Integer>[] arr;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Scanner ref = new Scanner(System.in);
        System.out.print("Enter number of elements in the array: ");
        n = ref.nextInt();
        arr = new LinkedList[n];

        // Initialize each index with an empty LinkedList
        for (int i = 0; i < n; i++) {
            arr[i] = new LinkedList<>();
        }

        int choice = 0;

        do {
            System.out.print("1: Insertion\n2: Deletion\n3: Search\n4: Exit\n");
            choice = ref.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the element to insert: ");
                    int ele = ref.nextInt();
                    insert(ele);
                    break;
                case 2:
                    System.out.print("Enter the element to delete: ");
                    ele = ref.nextInt();
                    delete(ele);
                    break;
                case 3:
                    System.out.print("Enter the element to search: ");
                    ele = ref.nextInt();
                    search(ele);
                    break;
                case 4:
                    System.out.println("Exited");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 4);

        ref.close();
    }

    public static void insert(int ele) {
        int index = ele % n;
        if (!arr[index].contains(ele)) {
            arr[index].add(ele);
        }
    }

    public static void delete(int ele) {
        int index = ele % n;
        if (arr[index].remove((Integer) ele)) {
            System.out.println("Element deleted: " + ele);
        } else {
            System.out.println("Element not found.");
        }
    }

    public static void search(int ele) {
        int index = ele % n;
        if (arr[index].contains(ele)) {
            System.out.println("Element found at index " + index);
        } else {
            System.out.println("Element not found.");
        }
    }
}
