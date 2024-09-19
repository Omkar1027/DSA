#include <stdio.h>
# define MAX 100
int rear=-1;
void print_queue(int queue[]){
if (rear==-1) {
printf("Queue is empty\n");
return;
}
for(int i=0;i<=rear;i++){
printf("%d -> ",queue[i]);
}
printf("NULL\n");
}
int push(int queue[]){
if (rear == MAX - 1) {
printf("Queue overflow\n");
return 0;
}
rear++;
printf("Enter element to push in queue: ");
scanf("%d",&queue[rear]);
}
void pop(int queue[]){
if(rear>-1){
for(int i=0;i<rear;i++){
queue[i]=queue[i+1];
}
rear--;
}
else printf("Queue is empty\n");

}
int main(){
int queue[MAX],choice;
while(choice!=4){
printf("Press 1 to push, 2 to pop, 3 to print queue, 4 to exit:");

scanf("%d", &choice);
switch (choice) {
case 1:
push(queue);
break;
case 2:
pop(queue);
break;
case 3:
print_queue(queue);
break;
case 4:
break;
default:
printf("Invalid");
}
}
}