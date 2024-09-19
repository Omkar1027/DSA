#include <ctype.h>
#include <stdio.h>
#include <string.h>
#include <math.h>

int stackIndex = -1;

void print_array(char arr[], int array_index) {
    for (int i = 0; i < array_index; i++) {
        printf("\narr[%d] = %c ", i, arr[i]);
    }
}

void push(char stack[], char store) {
    stack[++stackIndex] = store;
}

int pop(char stack[]) {
    return stack[stackIndex--];
}

void postfixEvaluation(char postfix[]) {
    char stack[100];
    int len = strlen(postfix);

    for (int i = 0; i < len; i++) {
        char ichar = postfix[i];
        if (isdigit(ichar)) {
            push(stack, ichar - '0');
        } else {
            int r = pop(stack);
            int l = pop(stack);
            switch (ichar) {
                case '^':
                    push(stack, pow(l,r));
                    break;
                case '+':
                    push(stack, l + r);
                    break;
                case '-':
                    push(stack, l - r);
                    break;
                case '*':
                    push(stack, l * r);
                    break;
                case '/':
                    push(stack, l / r);
                    break;
            }
        }
    }
    int result = pop(stack);
    printf("%d", result);
}

int main() {
    char postfix[100];

    printf("Enter the infix expression: ");
    scanf("%s", postfix);

    postfixEvaluation(postfix);
    return 0;
}

