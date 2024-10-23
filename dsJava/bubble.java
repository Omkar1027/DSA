public class bubble {
    public static void bubble(int[] arr,int n){
        int exchanged=1;

        for(int i=0;i<n-1 && exchanged==1;i++){
            
            exchanged=0;
            for(int j=0;j<n-i-1;j++){
                
                if(arr[j]>arr[j+1]){
                    exchanged=1;
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }

        for(int i=0;i<n;i++){
            System.out.printf("%d ",arr[i]);
        }
    }
}
