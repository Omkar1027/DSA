import java.util.Scanner;
public class expression {
static class Node {
Node lchild;
char data;
Node rchild;
public Node(char data) {
this.data = data;
lchild = rchild = null;
}
}
static int stackIndex = -1;
static int preference(char c) {
if (c == '^') return 3;
else if (c == '*' || c == '/') return 2;
else if (c == '+' || c == '-') return 1;
else return -1;
}
static char raiseTo(char c) {
if (c == '^') return 'R';
return 'L';
}
static void push(char[] stack, char store) {
stack[++stackIndex] = store;
}
static char pop(char[] stack) {
if (stackIndex >= 0)
return stack[stackIndex--];
return '\0';
}
static String reverse(String exp) {
StringBuilder result = new StringBuilder(exp.length());
for (int i = exp.length() - 1; i >= 0; i--) {
char ch = exp.charAt(i);
if (ch == '(') {
result.append(')');
} else if (ch == ')') {
result.append('(');
} else {
result.append(ch);
}
}
return result.toString();
}
static String iToP(String infix) {
char[] prefix = new char[100];
char[] stack = new char[100];
int prefixInd = 0;
infix = reverse(infix);
stack[++stackIndex] = '(';
infix += ')';
int len = infix.length();
for (int i = 0; i < len; i++) {
char ichar = infix.charAt(i);
if ((ichar >= '0' && ichar <= '9') || (ichar >= 'a' && ichar
<= 'z') || (ichar >= 'A' && ichar <= 'Z')) {
prefix[prefixInd++] = ichar;
} else if (ichar == '(') {
push(stack, ichar);
} else if (ichar == ')') {
while (stackIndex > -1 && stack[stackIndex] != '(') {
prefix[prefixInd++] = pop(stack);
}
stackIndex--;
} else {
while (stackIndex > -1 && (preference(ichar) <
preference(stack[stackIndex]) ||
(preference(ichar) ==
preference(stack[stackIndex]) && raiseTo(ichar) == 'L'))) {
prefix[prefixInd++] = pop(stack);
}
push(stack, ichar);
}
}
prefix[prefixInd] = '\0';
String result = new String(prefix).trim();
return reverse(result);
}
static Node constructTree(String prefix) {
int[] index = {0};
return constructTreeUtil(prefix, index);
}
static Node constructTreeUtil(String prefix, int[] index) {
if (index[0] >= prefix.length()) return null;
char current = prefix.charAt(index[0]);
index[0]++;
Node node = new Node(current);
if (preference(current) != -1) {
node.lchild = constructTreeUtil(prefix, index);
node.rchild = constructTreeUtil(prefix, index);
}
return node;
}
static void PrintTree(Node x, int i) {
int j;
if (x == null)
return;
PrintTree(x.rchild, i + 1);
for (j = 0; j < i; j++)
System.out.print("\t");
System.out.println(x.data);
System.out.println("\n\n");
PrintTree(x.lchild, i + 1);
}
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
System.out.print("Enter an infix expression: ");
String infix = sc.next();
String prefix = iToP(infix);
System.out.println("Prefix expression: " + prefix);
Node root = constructTree(prefix);
System.out.print("Expression tree:\n");
PrintTree(root, 0);
}
}
