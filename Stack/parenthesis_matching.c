#include <stdio.h>
#include <string.h>
#define Max 100

char arr[Max];
int array_index=0;


void push( char store){
    arr[array_index]=store;
    array_index++;
} 

void pop(){
    arr[array_index]=0;
    array_index--;
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
    if(array_index==0 && didPop!=0){
        printf("All parenthesis are matched\n");
    }
    else{
        printf("Parenthesis are not matched.\n");
    }
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