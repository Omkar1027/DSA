import java.util.*;

public class binarySearch {
   
    public static void BinarySearch(int[] arr,int ele){
        int l=0, h=arr.length,mid=(0+h)/2;

        while(l!=h){
            if(arr[mid]==ele){
                System.out.println("Found at index: "+mid);
                return;
            }
            else if(ele<arr[mid]){
                h=mid-1;
                mid=(l+h)/2;
            }
            else if(ele>arr[mid]){
                l=mid+1;
                mid=(l+h)/2;
            }
            else{
                System.out.println("Element not found");
                return;
            }

        }

    }

    public static void main(String[] args) {
        Scanner ref = new Scanner(System.in);
        System.out.println("Enter the number of elements: ");
        int n=ref.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            System.out.print("arr["+i+"]: ");
            arr[i]=ref.nextInt();
        }
        for(int i=0;i<n-1;i++){
            int maxIndex=0;
            for(int j=0;j<n-i;j++){
                if(arr[j]>=arr[maxIndex]) maxIndex=j;
            }
            int temp=arr[n-i-1];
            arr[n-i-1]=arr[maxIndex];
            arr[maxIndex]=temp;
        }
        
        System.out.println("Enter the element to find: ");
        int ele=ref.nextInt();

       
        BinarySearch(arr,ele);
        ref.close();
    }
}

