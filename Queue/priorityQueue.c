#include <stdio.h>
#define MAX 100

int front = -1;
int rear = -1;
int myQueue[MAX];
int priority[MAX];

int isEmpty() {
    return front == -1 || front > rear;
}

void enqueue(int value, int pr) {
    if ((rear + 1) % MAX == front) {
        printf("Queue overflow\n");
        return;
    }
    if (front == -1) {
        front = 0;
    }
    rear = (rear + 1) % MAX;
    myQueue[rear] = value;
    priority[rear] = pr;
}

int peek() {
    int p = priority[front];  
    int index = front;
    for (int i = front; i <= rear; i++) {
        if (p < priority[i]) {
            p = priority[i];
            index = i;
        }
    }
    return index;
}

void dequeue() {
    if (isEmpty()) {
        printf("Queue is empty\n");
        return;
    }
    int index = peek();
    for (int i = index; i < rear; i++) {
        myQueue[i] = myQueue[i + 1];
        priority[i] = priority[i + 1];
    }
    rear--;
    if (isEmpty()) {
        front = -1;
        rear = -1;
    }
}

void printQueue() {

    if (isEmpty()) {
        printf("Queue is empty.\n");
        return;
    }

    printf("Queue elements and their priorities:\n");
    for (int i = front; i <= rear; i++) {
        printf("Element: %d, Priority: %d\n", myQueue[i], priority[i]);
    }
}

int main() {
    int choice = 0, value, pr;
    while (choice != 5) {
        printf("Press 1 to enqueue, 2 to dequeue, 3 to peek, 4 to print queue, 5 to exit: ");
        scanf("%d", &choice);
        switch (choice) {
            case 1:
                printf("Enter value to enqueue: ");
                scanf("%d", &value);
                printf("Enter priority: ");
                scanf("%d", &pr);
                enqueue(value, pr);
                break;
            case 2:
                dequeue();
                break;
            case 3:
                if (isEmpty()) {
                    printf("Queue is empty\n");
                } else {
                    int index = peek();
                    printf("Element with highest priority: %d (Priority: %d)\n", myQueue[index], priority[index]);
                }
                break;
            case 4:
                printQueue();
                break;
            case 5:
                break;
            default:
                printf("Invalid choice\n");
        }
    }
    return 0;
}
