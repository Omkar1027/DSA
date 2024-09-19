//MAXIMUN ELEMENTS

/*int* getMax(int operations_count, char** operations, int* result_count) {
    int top=-1,n1=0,n2=0,result_index=0;
    int myStack[operations_count+10];
    
    int* results= malloc(operations_count * sizeof(int));
    
    for(int x=0;x<operations_count;x++){
        if (sscanf(operations[x], "%d %d", &n1, &n2) < 1) {
            continue; 
        }
        if(n1==2&& top!=-1){
            top--;
        }else if(n1==3 && top!=-1){
            results[result_index++]=myStack[top];    
        }else if(n1==1){
            myStack[++top]=n2;  
        }
    }
    *result_count=result_index;
    return results;
}*/

