#include <stdio.h>
#include <string.h>

int stackIndex = -1;

int preference(char c) {
    if (c == '^') return 3;
    else if (c == '*' || c == '/') return 2;
    else if (c == '+' || c == '-') return 1;
    else return -1;
}

void push(char stack[], char store) {
    stack[++stackIndex] = store;
}

char pop(char stack[]) {
    if (stackIndex >= 0)
        return stack[stackIndex--];
    return '\0'; // Return null character if stack is empty
}

void iToP(char infix[]) {
    char postfix[100], stack[100], temp;
    int postfixInd = 0, len;

    stack[++stackIndex] = '(';
    len = strlen(infix);
    infix[len++] = ')';
    infix[len] = '\0';

    for (int i = 0; i < len; i++) {
        char ichar = infix[i];

        if ((ichar >= '0' && ichar <= '9') || (ichar >= 'a' && ichar <= 'z') || (ichar >= 'A' && ichar <= 'Z')) {
            postfix[postfixInd++] = ichar;
        } 

        else if (ichar == '(') {
            push(stack, ichar);
        } 

        else if (ichar == ')') {

            while (stackIndex > -1 && stack[stackIndex] != '(') {
                temp = pop(stack);
                postfix[postfixInd++] = temp;
            }
            stackIndex--; // Pop the '(' from the stack
        } 

        else {

            while (stackIndex > -1 && (preference(ichar) <= preference(stack[stackIndex]) && ichar != '^')) {
                temp = pop(stack);
                postfix[postfixInd++] = temp;
            }
            push(stack, ichar);
        }
    }

    postfix[postfixInd] = '\0';

    if (stackIndex == -1) {
        printf("Postfix expression: %s\n", postfix);
    } else {
        printf("Invalid infix expression\n");
    }
}

int main() {
    char infix[100];

    printf("Enter the infix expression: ");
    scanf("%s", infix);

    iToP(infix);
    return 0;
}
