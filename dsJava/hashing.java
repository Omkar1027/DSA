import java.util.*;

public class hashing {
    static int collision;
    static int n;
    static Integer[] arr;

    public static void insert( int ele){
        int index=ele%n;
        while(arr[index] != null){
            index++;
            if(index==n){
                index=0;
            }
        }
        arr[index]=ele;
    }

    public static void delete(int ele){
        int index=ele%n;
        while (arr[index] != null) {
            if (arr[index] == ele) {
                arr[index] = null;
                System.out.println("Element deleted: "+ele);
                return;
            }
            index++;
            if (index == n) {
                index = 0;
            }
        }
        System.out.println("Element not found.");
    }

    public static void search(int ele) {
        int index= ele%n;
        while (arr[index]!=null) {
            if (arr[index]==ele) {
                System.out.println("Element found at index "+index);
                return;
            }
            index++;
            if (index == n) {
                index = 0;
            }
        }
        System.out.println("Element not found.");
    }
    

    public static void main(String[] args) {
        Scanner ref = new Scanner(System.in);
        System.out.print("Enter number of elements in the array:");
        n=ref.nextInt();
        arr= new Integer[n];
        int choice=0;
        
        do{
            System.out.print("1: Insertion\n2: Deletion\n3:Search\n4:Exit\n");
            choice=ref.nextInt();

            switch(choice){
                case 1:
                System.out.print("Enter the element to insert: ");
                int ele=ref.nextInt();
                insert(ele);
                break;

                case 2:
                System.out.print("Enter the element to delete: ");
                ele=ref.nextInt();
                delete(ele);
                break;

                case 3:
                System.out.print("Enter the element to search: ");
                ele=ref.nextInt();
                search(ele);
                break;

                case 4:
                System.out.print("Exited");
                break;

                default:
                System.out.println("Invalid choice");
            }



        }while(choice!=4);

       

        ref.close();
    }
}
