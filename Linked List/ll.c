#include<stdio.h>
#include<stdlib.h>

struct Node
{
	int data;
	struct Node *next; // next
};
//typedef struct Node * NODEPTR;
struct Node * start=NULL;

struct Node * GetNode()
{
	return ( (struct Node *) malloc(sizeof(struct Node)));
}

char choice;

void CreateList();
int CountNodes();
void Insert();
void InsertBefore();
void InsertAfter();
void InsertAtPosition();
void Delete();
void DeleteByValue();
void DeleteAtPosition();
void Display();

int main()
{
    int ch;
    //printf("%d",sizeof(struct Node *));
	do
	{
		//clrscr();
		printf("\n\n********** CHOICES *********");
		printf("\n\n1 : CREATE LIST");
		printf("\n2 : INSERT A NODE");
		printf("\n3 : DELETE A NODE");
		printf("\n4 : DISPLAY LIST");
		printf("\n5 : EXIT");
		printf("\n\nENTER YOUR CHOICE : \t");
		scanf("%d",&ch);

		switch(ch)
		{
			case 1: // create list
			{
				CreateList();
				printf("\n\nNODES PRESENT : %d",CountNodes());
			}
			break;

			case 2: // insert node
			{
				Insert();
			}
			break;

			case 3: // delete node
			{
				Delete();
			}
			break;

			case 4: // display list
			{
				Display();
			}
			break;

			case 5: // exit
			break;

			default :
				printf("\n\nWRONG ENTRY ! TRY AGAIN ...");
		}
		//getch();
	}while(ch!=5);
}

void CreateList()
{
    struct Node *end=NULL;
    if(start!=NULL){
        printf("Already created list");
        return;
    }
    do{
        struct Node *I=GetNode();
        printf("Enter data to enter");
        scanf("%d",&I->data);
        I->next=NULL;
        if(start==NULL){
            start=I;
        }
        else{
            end->next=I;
        }
        end=I;
        printf("Want to continue? (y/n):");
        scanf("%c",&choice);
    }while(choice=='y');
}
void Insert()
{
	int ch;
	// we can check here - if the list is existing
	do
	{
		//clrscr();

		printf("\n\n******* INSERT OPTIONS *******");
		printf("\n\n1 : INSERT BEFORE A NODE");
		printf("\n2 : INSERT AFTER A NODE");
		printf("\n3 : INSERT AT A POSITION");
		printf("\n4 : DISPLAY");
		printf("\n5 : BACK TO MAIN MENU");
		printf("\n\nENTER YOUR CHOICE : \t");
		scanf("%d",&ch);

		switch(ch)
		{
			case 1: // INSERT BEFORE
			{
				InsertBefore();
			}
			break;

			case 2: // insert after a node
			{
				InsertAfter();
			}
			break;

			case 3: // insert at a position
			{
				InsertAtPosition();
			}
			break;

			case 4: // display list
			{
				Display();
			}
			break;

			case 5: // BACK TO MAIN MENU
			return;
			//break;

			default :
				printf("\n\nWRONG ENTRY ! TRY AGAIN ...");
		}
		//getch();
	}while(1);		//while(ch!=5);
}

void InsertBefore(){
    int val;
    struct Node *ptrBeforeVal, *ptrAtVal, *I;
    if(start==NULL){
        printf("LL empty");
        return;
    }

    printf("Enter the element before which node is to be added: ");
    scanf("%d",&val);

    ptrAtVal=start;
    while(ptrAtVal->data!=val || ptrAtVal!=NULL){
        ptrAtVal=ptrAtVal->next;
    }
    if(ptrAtVal==NULL){
        printf("Node not found");
        return;
    }

    I=GetNode();
    printf("Enter the value to be inserted:");
    scanf("%d",&I->data);

    if(ptrAtVal==start){
        I->next=start;
        start=I;
    }
    else{
        ptrBeforeVal=start;
        while(ptrBeforeVal->next != ptrAtVal){
            ptrBeforeVal=ptrBeforeVal->next;
        }
        I->next=ptrAtVal;
        ptrBeforeVal->next=I;
    }
}

void InsertAfter(){
    int val;
    struct Node *ptrAtVal, *I;
    if(start==NULL){
        printf("LL is empty");
        return;
    }

    printf("Enter the element before which node is to be added: ");
    scanf("%d",&val);

    ptrAtVal=start;
    while(ptrAtVal->data!=val || ptrAtVal!=NULL){
        ptrAtVal=ptrAtVal->next;
    }
    if(ptrAtVal==NULL){
        printf("Node not found");
        return;
    }

    I=GetNode();
    printf("Enter the value to be inserted:");
    scanf("%d",&I->data);

    I->next=ptrAtVal->next;
    ptrAtVal->next =I;
}

int CountNodes()
{
	struct Node * temp = start;
	int count = 0;
	if(temp == NULL)
	{
		printf("\n\nLIST IS EMPTY !!!");
		return 0;
	}
	while(temp != NULL)
	{
		temp = temp->next;
		count++;
	}
	return count;
}

void InsertAtPosition(){
    int pos, totalNodes ;
    struct Node *ptrBeforePos, *I;
    if(start==NULL){
        printf("LL is empty");
        return;
    }
    totalNodes=CountNodes();
    printf("total nodes is %d", totalNodes);
    printf("Enter value to enter at position between %d to %d", 1, totalNodes+1);
    scanf("%d",&pos);

    if(pos<1 || pos>totalNodes+1){
        printf("Invalid Nodes position");
        return;
    }
    I=GetNode();
    printf("Enter the value to be inserted:");
    scanf("%d",&I->data);

    if(pos==1){
        I->next=start;
        start=I;
        return;
    }
    
    ptrBeforePos=start;
    for(int i=0;i<pos-2;i++){
        ptrBeforePos= ptrBeforePos->next;
    }
    I->next=ptrBeforePos->next;
    ptrBeforePos->next=I;
}
void Delete()
{
	int ch;
	do
	{
		//clrscr();
		// we can check here - if list is existing
		printf("\n\n******* DELETE OPTIONS *******");
		printf("\n\n1 : DELETE NODE BY VALUE");
		printf("\n2 : DELETE NODE AT A POSITION");
		printf("\n3 : DISPLAY");
		printf("\n4 : BACK TO MAIN MENU");
		printf("\n\nENTER YOUR CHOICE : \t");
		scanf("%d",&ch);

		switch(ch)
		{
			case 1: // DELETE BY VALUE
			{
				DeleteByValue();
			}
			break;

			case 2: // delete node at a position
			{
				DeleteAtPosition();
			}
			break;

			case 3: //display
			{
				Display();
			}
			break;

			case 4: // BACK TO MAIN MENU
			return;
			//break;

			default :
				printf("\n\nWRONG ENTRY ! TRY AGAIN ...");
		}
		getchar();
	}while(1);		//while(ch!=4);

}
void DeleteByValue()
{
    int val;
    struct Node *ptrAtValue,*ptrBeforeValue;
    if(start==NULL){
        printf("LL is empty");
    } 
    printf("Enter the value to be deleted");
    scanf("%d",&val);

    ptrAtValue=start;
    while(ptrAtValue!=val && ptrAtValue!=NULL){
        ptrAtValue=ptrAtValue->next;
    }
    if(ptrAtValue==NULL){
        printf("Value not found in LL");
        return;
    }

    if(ptrAtValue==start){
        start=start->next;
    }
    else{
        ptrBeforeValue=start;
        while(ptrBeforeValue!=ptrAtValue)
            ptrBeforeValue=ptrBeforeValue->next;
        ptrBeforeValue->next=ptrAtValue->next;
    }
}

void DeleteAtPosition()
{
    int pos, totalNodes;
    struct Node *ptrBeforePos,*ptrAtPos;

}