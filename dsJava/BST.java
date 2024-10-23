import java.util.*;

public class BST {
    
    static class Node {
        Node lchild;
        int data;
        Node rchild;

        public Node(int data) {
            this.data = data;
            lchild = rchild = null;
        }
    }

    Node root = new Node(0);
    int height;

    void insertTree(int ele){
        Node p,q;
	    p= new Node(ele);
	    p.lchild = p.rchild = null;
	    if(root == null){
            root=p;
        }
	    else{
            q=root;
        }
        q= new Node(root.data);
        while(true){
            if (p.data<=q.data){
				if (q.lchild==null)
				{
					q.lchild=p;
					break;
				}
				else
					q=q.lchild;
            }
			else {
				if (q.rchild==null)
				{
					q.rchild=p;
					break;
				}
				else
					q=q.rchild;
            }
        }
    }

    boolean search( Node p, int val){ // Call search(root, val)
        if(p==null)
            return false;
        if(p.data==val)
            return true;

        if(val<p.data){
            if(p.lchild==null)
                return false;
            return(search(p.lchild,val));
        }
        else{
            if(p.rchild==null)
                return false;
            return(search(p.rchild,val));
        }
    }

    void PrintTree (Node root, int i){
        int j;
        if(root==null)
            return;
        PrintTree(root.rchild,i+1);
        for(j=0;j<i;j++)
            System.out.println("\t");
        System.out.println(root.data);
        System.out.println("\n\n");
        PrintTree(root.lchild,i+1);
    }

    Node  parent( Node p){
        Node q;
        if(p==root)
            return null;
        q=root;
        while(q!=null)
        {
            if(q.lchild==p||q.rchild==p)
                return q;
            if(p.data <= q.data)
                q=q.lchild;
            else 	
                q=q.rchild;
        }
        return q; 
    }

    boolean isleft( Node p){
        Node q=parent(p);
        if(q==null)
            return false;
        if(q.lchild==p)
            return true;
        return false;
    }

    boolean isright( Node p){
        Node q=parent(p);
        if(q==null)
            return false;
        if(q.rchild==p)
            return true;
        return false;
    }




    boolean delete( Node root, int x){ //Call delete(root, val)
        Node p;
        if(root==null)
        {
            System.out.println ("The tree is empty\n");
            return false;
        }
        p=root;
        while(p!=null && p.data !=x) 
            if (x<=p.data)
                p=p.lchild;
            else
                p=p.rchild;
        if(p==null)
        {
            System.out.println("Element not found\n");
            return false;
        }

        if(p.lchild==null && p.rchild==null){ // Node to be deleted is Leaf
            if(parent(p)==null)	// it is the only Node
            {
                root=null;
                return true;
            }
            if(isleft(p))
            {
                parent(p).lchild=null;
                return true;
            }
            else
            {
                parent(p).rchild=null;
                return true;
            }
        }
        else if(p.lchild!=null) // Replace with Inorder Predecessor value, delete that node
        {
            int val;
            Node ptr = findmax(p.lchild);
            val = ptr.data;
            delete(p,ptr.data);
            p.data=val;
        }
        else if(p==root) // Delete root which does not have a left child
        {
            root=p.rchild;
        }
        else
        {
            if(isleft(p))
                parent(p).lchild=p.rchild;
            else
                parent(p).rchild=p.rchild;
        }
        return true;
    }

    void inOrder( Node p){
        if(p==null)
            return;
        inOrder(p.lchild);
        System.out.println(p.data);
        inOrder(p.rchild);
    }

    void preOrder( Node p){
        if(p==null)
            return;
        System.out.println(p.data);
        preOrder(p.lchild);
        preOrder(p.rchild);
    }

    void postOrder( Node p){
        if(p==null)
            return;
        postOrder(p.lchild);
        postOrder(p.rchild);
        System.out.println(p.data);
    }

    Node  findmax( Node p){
        if(p==null)
            return p;
        if(p.rchild==null)
            return p;
        return(findmax(p.rchild));
    }

    Node  findmin( Node p){
        if(p==null)
            return p;
        if(p.lchild==null)
            return p;
        return(findmax(p.lchild));
    }

    void findheight( Node p, int i){
        if(p==null){
            if(height<i)
                height=i;
            return;
        }
        findheight(p.lchild,i+1);
        findheight(p.rchild,i+1);
    }

    Node findPredecessor(Node p) {
        if (p == null) return null;

        if (p.lchild != null) {
            return findmax(p.lchild);
        }
        Node temp = root;
        Node predecessor = null;

        while (temp != null) {
            if (p.data > temp.data) {
                predecessor = temp;
                temp = temp.rchild;
            } else {
                temp = temp.lchild;
            }
        }
        return predecessor;
    }

    Node findSuccessor(Node p) {
        if (p == null) return null;

        if (p.rchild != null) {
            return findmin(p.rchild);
        }

        Node temp = root;
        Node successor = null;

        while (temp != null) {
            if (p.data < temp.data) {
                successor = temp;
                temp = temp.lchild;
            } else {
                temp = temp.rchild;
            }
        }
        return successor;
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BST tree = new BST();
        
        int c, ele;
        BST.Node node = null;

        do {
            System.out.println("\n\n***BST***");
            System.out.println("1: Insert a Node");
            System.out.println("2: Delete a Node");
            System.out.println("3: Search a Node");
            System.out.println("4: Display The Tree");
            System.out.println("5: In-order Traversal");
            System.out.println("6: Pre-order Traversal");
            System.out.println("7: Post-order Traversal");
            System.out.println("8: Find Successor");
            System.out.println("9: Find Predecessor");
            System.out.println("10: Find Height");
            System.out.println("11: Find Minimum");
            System.out.println("12: Find Maximum");
            System.out.println("13: Exit");
            System.out.print("Enter the choice: ");
            
            c = sc.nextInt();

            switch (c) {
                case 1:
                    System.out.print("Enter element to insert: ");
                    ele = sc.nextInt();
                    tree.insertTree(ele);
                    System.out.println("Node inserted");
                    break;

                case 2: // Delete a Node
                    System.out.print("Enter element to delete: ");
                    ele = sc.nextInt();
                    if (tree.delete(tree.root, ele))
                        System.out.println("Node deleted");
                    else
                        System.out.println("Node not found");
                    break;

                case 3: 
                    System.out.print("Enter element to search: ");
                    ele = sc.nextInt();
                    if (tree.search(tree.root, ele))
                        System.out.println("Node found.");
                    else
                        System.out.println("Node not found.");
                    break;

                case 4:
                    tree.PrintTree(tree.root, 0);
                    break;

                case 5: 
                    tree.inOrder(tree.root);
                    break;

                case 6:
                    tree.preOrder(tree.root);
                    break;

                case 7:
                    tree.postOrder(tree.root);
                    break;

                case 8:
                    System.out.print("Enter node value to find successor: ");
                    ele = sc.nextInt();
                    node = tree.findSuccessor(new BST.Node(ele));
                    if (node != null)
                        System.out.println("Successor: " + node.data);
                    else
                        System.out.println("No Successor found.");
                    break;

                case 9:
                    System.out.print("Enter node value to find predecessor: ");
                    ele = sc.nextInt();
                    node = tree.findPredecessor(new BST.Node(ele));
                    if (node != null)
                        System.out.println("Predecessor: " + node.data);
                    else
                        System.out.println("No Predecessor found.");
                    break;

                case 10: 
                    tree.height = 0;
                    tree.findheight(tree.root, 1);
                    System.out.println("Height of the tree: " + tree.height);
                    break;

                case 11: 
                    node = tree.findmin(tree.root);
                    if (node != null)
                        System.out.println("Minimum value: " + node.data);
                    break;

                case 12: 
                    node = tree.findmax(tree.root);
                    if (node != null)
                        System.out.println("Maximum value: " + node.data);
                    break;

                case 13:
                    System.out.println("Saionara");
                    break;

                default:
                    System.out.println("Invalid choice");
                    break;
            }
        } while (c != 13);

    }

}
