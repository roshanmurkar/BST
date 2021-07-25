package main;

import java.util.Scanner;

public class BSTMain {
	class Node { 
        int key; 
        Node left, right; 
   
        public Node(int data){ 
            key = data; 
            left = right = null; 
        } 
	}
        
	Node root; 
	//BSTMain constructor	
	BSTMain(){
		root = null;
	}

	int minValue(Node root)  { 
        //initially min_val = root
        int minValue = root.key; 
        //find min_val
        while (root.left != null)  { 
            minValue = root.left.key; 
            root = root.left; 
        } 
        return minValue; 
    } 
	
	void insert(int key)  { 
        root = insert_Recursive(root, key); 
    } 
	
	Node insert_Recursive(Node root, int key) { 
        //tree is empty
      if (root == null) { 
          root = new Node(key); 
          return root; 
      } 
      //traverse the tree
      if (key < root.key)     //insert in the left subtree
          root.left = insert_Recursive(root.left, key); 
      else if (key > root.key)    //insert in the right subtree
          root.right = insert_Recursive(root.right, key); 
        // return pointer
      return root; 
	} 
	
	void inorder() { 
        inorder_Recursive(root); 
    } 
   
    // recursively traverse the BST  
    void inorder_Recursive(Node root) { 
        if (root != null) { 
            inorder_Recursive(root.left); 
            System.out.print(root.key + " "); 
            inorder_Recursive(root.right); 
        } 
    } 
    
    boolean search(int key)  { 
        root = search_Recursive(root, key); 
        if (root!= null)
            return true;
        else
            return false;
    }
    
    Node search_Recursive(Node root, int key)  { 
        // Base Cases: root is null or key is present at root 
        if (root==null || root.key==key) 
            return root; 
        // val is greater than root's key 
        if (root.key > key) 
            return search_Recursive(root.left, key); 
        // val is less than root's key 
        return search_Recursive(root.right, key); 
    } 
	
	public static void main(String[] args) {
		BSTMain bst = new BSTMain();
		Scanner scan = new Scanner(System.in);
		int i=0;
		do {
			System.out.println("Enter 1 for add data");
			System.out.println("Enter 2 for search data");
			i = scan.nextInt();
			if(i == 1)
			{
				
				System.out.println("Enter the data to be insert");
				int x = scan.nextInt();
				bst.insert(x);
				System.out.println("The BST Created with input data(Left-root-right):");
		        bst.inorder();
		        System.out.println("\n");
		        i=0;
			}
			else if(i == 2)
			{
				System.out.println("Enter the data to be search");
				int x = scan.nextInt();
				boolean ret_val = bst.search(x);
				ret_val = bst.search(x);
		        System.out.println("Enter number is present this statment is:-"+ret_val);
		        i=0;
			}
		}while(i == 0);
        

	}
}
