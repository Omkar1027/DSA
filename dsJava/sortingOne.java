import java.util.Scanner;

public class sortingOne{

    static int n;
    static int[] arr = new int[500];
    static int[] arrTemp = new int[500];

    

    //SELECTION
    public static void selection(int[] arr){

        int p=0,x=0;

        System.out.print("\nUNSORTED ARRAY:\n");
        System.out.print("[");
        for(p=0;p<n-1;p++){
            System.out.printf("%d, ",arr[p]);
        }
        System.out.printf("%d]\n\n",arr[p]);


        for(int i=0;i<n-x-1;i++){

            int largestIndex=0;

            for(int j=0;j<n-i;j++){
                if(arr[j]>=arr[largestIndex]){
                    largestIndex=j;
                }
            }
            int temp = arr[n-i-1];
            arr[n-i-1]=arr[largestIndex];
            arr[largestIndex]=temp;
        }
          
        System.out.print("SORTED ARRAY:\n");
        System.out.print("[");
        for(p=0;p<n-1;p++){
            System.out.printf("%d, ",arr[p]);
        }
        System.out.printf("%d]\n\n",arr[p]);

    }

    //INSERTION
    public static void insertion(int[] arr){

        int p=0;

        System.out.print("\nUNSORTED ARRAY:\n");
        System.out.print("[");
        for(p=0;p<n-1;p++){
            System.out.printf("%d, ",arr[p]);
        }
        System.out.printf("%d]\n\n",arr[p]);


        for(int i=1;i<n;i++){
            for(int j=i;j>0;j--){
                if(arr[j]<arr[j-1]){
                    int temp= arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                }
                else break;
            }
        }
          
        System.out.print("SORTED ARRAY:\n");
        System.out.print("[");
        for(p=0;p<n-1;p++){
            System.out.printf("%d, ",arr[p]);
        }
        System.out.printf("%d]\n\n",arr[p]);

    }

    // MERGE SORT
    public static void mergeSort(int[] arr ,int i,int j){
        int mid;
    
        if(i<j){
            mid=(i+j)/2;
            mergeSort(arr,i,mid);
            mergeSort(arr,mid+1,j);
            merge(arr,i,mid,j);
        }
    }
    
    public static void merge(int[] arr, int left, int mid, int right) {
        int[] aux = new int[500];
    
        int i = left, j = mid + 1, k = 0;
    
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                aux[k++] = arr[i++];
            } else {
                aux[k++] = arr[j++];
            }
        }
    
        while (i <= mid) {
            aux[k++] = arr[i++];
        }
    
        while (j <= right) {
            aux[k++] = arr[j++];
        }
    
        for (i = left, k = 0; i <= right; i++, k++) {
            arr[i] = aux[k];
        }
    }
    
    



    public static void main(String[] args) {
        
        
        int choice=0;
        Scanner ref=new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        n=ref.nextInt();


        for(int i=0;i<n;i++){
            System.out.print("Enter arr["+i+"]: ");
            arr[i]=ref.nextInt();
        }

        for(int i=0;i<n;i++){
            arrTemp[i]=arr[i];
        }

        
        do{
            System.out.println("1. Selection Sort \n2. Insertion Sort \n3. Merge Sort\n4. To Exit");
        System.out.println("Enter the choice");
        choice=ref.nextInt();
        if(choice!=4){
            for(int i=0;i<n;i++){
                arr[i]=arrTemp[i];
            }
        }

        switch (choice) {
            case 1:
                selection(arr);
                break;

            case 2:
                insertion(arr);
                break;

            case 3:
                int p=0;
                System.out.print("\nUNSORTED ARRAY:\n");
                System.out.print("[");
                for(p=0;p<n-1;p++){
                    System.out.printf("%d, ",arr[p]);
                }
                System.out.printf("%d]\n\n",arr[p]);

                mergeSort(arr, 0, n-1);

                System.out.print("SORTED ARRAY:\n");
                System.out.print("[");
                for(p=0;p<n-1;p++){
                    System.out.printf("%d, ",arr[p]);
                }
                System.out.printf("%d]\n\n",arr[p]);

                
                break;

            case 4:
                
                break;
        
            default:
                break;
            }
        }while(choice!=4);
    }
}