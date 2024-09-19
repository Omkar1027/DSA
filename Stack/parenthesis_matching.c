#include <stdio.h>
#include <string.h>
#define Max 100

char arr[Max];
int array_index=-1;


void push( char store){
    arr[array_index]=store;
    array_index++;
} 

void pop() {
    if (array_index > -1) {  // Check to ensure you're not popping from an empty stack
        arr[array_index]=0;
        array_index--;  // Decrement the index when popping
    } else {
        printf("Stack underflow.\n");
    }
}

void parenthesis_matching(char str[]){
    int string_len=strlen(str);
    int didPop=0;

    for(int i=0; i<string_len; i++){
        if(str[i]=='['||str[i]=='{'||str[i]=='('||str[i]=='<'){
            push(str[i]);
            didPop++;
        }
        else if(str[i]==']'||str[i]=='}'||str[i]==')'||str[i]=='>'){
            if((arr[array_index-1]=='('&&str[i]==')') || (arr[array_index-1]=='{'&&str[i]=='}') || (arr[array_index-1]=='['&&str[i]==']') || (arr[array_index-1]=='<'&&str[i]=='>')){
                pop();
            }
        }
    }
    if(array_index==-1 && didPop!=0){
        printf("All parenthesis are MATCHED\n");
    }
    else{
        printf("Parenthesis are NOT matched.\n");
    }
    for(int i=array_index;i>-1;i--){
        arr[i]=0;
    }
    array_index=-1;
    didPop=0;
}

int main(){
    char str[100];
    while(1){
    printf("Enter the brackets: ");
    scanf("%s", &str);

    parenthesis_matching(str);

    }
    return 0;
}
