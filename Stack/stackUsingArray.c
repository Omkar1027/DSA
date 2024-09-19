#include <stdio.h>
int arrayIndex=0;
void printArray(int arr[], int arrayIndex){
for(int i=0;i<arrayIndex;i++){
printf("arr[%d]=%d \n",i,arr[i]);
}
}
void push(int arr[]){
printf("Enter element to push: ");
scanf("%d",&arr[arrayIndex]);
arrayIndex++;
}
void pop(int arr[]){
arr[arrayIndex]=0;
arrayIndex--;
}

int main(){
int arr[10] ={},choice=0;
while(choice!=4){
printf("\nPress 1 to push, 2 to pop, 3 to print array, 4 to exit :");
scanf("%d", &choice);
switch (choice) {
case 1:
push(arr);
break;
case 2:
pop(arr);

break;
case 3:
printArray(arr, arrayIndex);
break;
case 4:
printf("Exited the loop.");
break;
default:
printf("Invalid");
}
}
return 0;
}
