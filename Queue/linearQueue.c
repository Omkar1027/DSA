#include <stdio.h>
#define MAX 5

int front = -1;
int rear = -1;
int my_c_queue[MAX];

void enqueue(int ele) {
    if(rear==MAX-1){
        printf("Queue is full");
        return;
    }
    if(front==-1 && rear==-1){
        front++;
    }
    my_c_queue[++rear]=ele;
}

void dequeue(){
    if(front==-1){
        printf("Queue is empty");
        return;
    }
    if(front==rear){
        front=rear=-1;
        return;
    }
    front++;
}

void print_queue(){
    if(front==-1){
        printf("Queue is empty\n");
        return;
    }
    int i=0;
    for(i=front;i<=rear;i++){
        printf("%d -> ", my_c_queue[i]);
    }
    if(i>rear) printf("Null");
}

int main() {
    int choice = 0, ele;
    while (choice != 4) {
        printf("\nPress 1 to push, 2 to pop, 3 to print queue, 4 to exit: ");
        scanf("%d", &choice);
        switch (choice) {
            case 1:
                printf("Enter element to push in circular queue: ");
                scanf("%d", &ele);
                enqueue(ele);
                break;
            case 2:
                dequeue();
                break;
            case 3:
                print_queue();
                break;
            case 4:
                break;
            default:
                printf("Invalid choice\n");
        }
    }
    return 0;
}
