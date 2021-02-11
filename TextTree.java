package lists;

import java.io.PrintWriter;

/**
   This class implements a binary search tree.
 */



public class TextTree 
{
	
	
	private class Node
	{
	   private String word;
	   private int num;
	   private Node left, right;

	   // Constructor for leaf nodes.
	   Node(String word)
	   {
	       this.word = word;
	       num = 1;
	       left = null;
	       right = null;
	   }

	   // Constructor for non-leaf nodes.
	   Node(int val, Node leftChild, Node rightChild)
	   {
	       this.word =word;
	       num = 1;
	       left = leftChild;
	       right = rightChild;
	   }
	}
	private Node root;
    
    // Check if the binary tree is empty.
    public boolean isEmpty()
    {
        return root == null;
    }   
    private class RemovalResult
    {
        Node node;    // Removed node
        Node tree;    // Remaining tree

        RemovalResult(Node node, Node tree)
        {
            this.node = node;
            this.tree = tree;
        }
    }
    
    

    public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	/**
       The public add method adds a value to the tree by 
       calling a private add method and passing it the 
       root of the tree.     
       @param x The value to add to the tree.
       @return true.
     */
    public boolean add(String x)
    {
        root = add(x, root);
        return true;
    }

    /**
       The contains method checks to see if a value is 
       in the binary tree.     
       @param x The value to check for.
       @return true if x is in the tree, false otherwise.
     */
    public boolean contains(String x)
    {
        // Call the private recursive method.
        return contains(x, root);
    }
   
    
    
    
    public static void inorder(Node btree)
    {
        if (btree != null)
        {
            inorder(btree.left);
            System.out.print(btree.word + ": " + btree.num + "\n");
            inorder(btree.right);
        }
    }
   
    
    public static int inorderSearch(Node btree, String search)
    {
    	int num;
        if (btree != null)
        {
        	if(btree.word.equalsIgnoreCase(search)) {
        		return btree.num;
        	}else if (search.compareToIgnoreCase(btree.word) <0) {
        		return inorderSearch(btree.left, search);
        	}else {
        		return inorderSearch(btree.right, search);
        	}
        }
        else {
        	return 0;
        }
    }
    public static void inorderWrite(Node btree, PrintWriter out)
    {
    	
        if (btree != null)
        {
            inorderWrite(btree.left, out);
            out.println(btree.word + ": " + btree.num + "\n");
            inorderWrite(btree.right, out);
        }
    }
    
    public static void postorder(Node btree)
    {
        if (btree != null)
        {
          postorder(btree.left);
          postorder(btree.right);
          // root last
          System.out.print(btree.word + ": " + btree.num + "\n");
        }
      }

    
    public static void preorder(Node btree)
    {
       if (btree != null)
       {
          // root first
           System.out.print(btree.word + ": " + btree.num + "\n");
          preorder(btree.left);
          preorder(btree.right);
        }
    }

    
    
    
    
    /**
       The add method adds a value to the search tree.     
       @x the value to add.
       @param bstree The root of the binary search tree.
       @return The root of the resulting binary search tree.
     */
    private Node add(String x, Node bstree)
    {
        if (bstree == null)
        {
            return new Node(x);
        }
        // bstree is not null. 
        if ( x.equalsIgnoreCase(bstree.word) ) {
        	bstree.num = bstree.num +1;
        }
        else if (x.compareToIgnoreCase(bstree.word)<0)
        {
            // Add x to the left subtree and replace 
            // the current left subtree with the result.
            bstree.left = add(x, bstree.left);
        } else if (x.compareToIgnoreCase( bstree.word) >0)
        {
            // Add x to the right subtree.
            bstree.right = add(x, bstree.right);
        }
        
        return bstree;
    }

    /**
       The method contains checks whether an item is in 
       a binary search tree.     
       @param x The item to check for.
       @param bstree The binary tree to look in.
       @return true if found, false otherwise.
     */
    private boolean contains(String x, Node bstree)
    {
        if (bstree == null)
        {
            return false;
        }
        if (x.equalsIgnoreCase( bstree.word))
        {
            return true;
        }
        if (x.compareToIgnoreCase( bstree.word) <0)
        {
            // Recursively look in left subtree.
            return contains(x, bstree.left);
        } else
        {
            // Recursively look in right subtree.
            return contains(x, bstree.right);
        }
    }

    /**
       The remove method removes a value from the 
       binary search tree.     
       @param x The value to remove.
       @returns true if x was removed, false if x not found.
     */
    public boolean remove(String x)
    {
        RemovalResult result = remove(root, x);
        if (result == null)
        {
            return false;
        } else
        {
            root = result.tree;
            return true;
        }
    }

    /**
       This remove method removes a value a from a 
       binary search tree and returns the removed node 
       and the remaining tree wrapped in a RemovalResult object.
      
       @param bstree The binary search tree.
       @param x The value to be removed.
       @return null if x is not found in bTree.
     */
    private RemovalResult remove(Node bstree, String x)
    {
        if (bstree == null)
        {
            return null;
        }
        if (x.compareToIgnoreCase( bstree.word) <0)
        {
            // Remove x from the left subtree.
            RemovalResult result = remove(bstree.left, x);
            if (result == null)
            {
                return null;
            }
            bstree.left = result.tree;
            result.tree = bstree;
            return result;
        }
        if (x.compareToIgnoreCase( bstree.word) >0)
        {
            // Remove x from the right subtree.
            RemovalResult result = remove(bstree.right, x);
            if (result == null)
            {
                return null;
            }
            bstree.right = result.tree;
            result.tree = bstree;
            return result;
        }
        // x is in this root node.      
        // Is it a leaf? 
        if (bstree.right == null && bstree.left == null)
        {
            return new RemovalResult(bstree, null);
        }

        // Does the node have two children?
        if (bstree.right != null && bstree.left != null)
        {
            // Remove largest node in left subtree and 
            // make it the root of the remaining tree.
            RemovalResult remResult = removeLargest(bstree.left);
            Node newRoot = remResult.node;
            newRoot.left = remResult.tree;
            newRoot.right = bstree.right;

            // Prepare the result to be returned.
            bstree.left = null;
            bstree.right = null;
            return new RemovalResult(bstree, newRoot);
        }
        // The node has one child
        Node node = bstree;
        Node tree;
        if (bstree.left != null)
        {
            tree = bstree.left;
        } else
        {
            tree = bstree.right;
        }
        node.left = null;
        node.right = null;
        return new RemovalResult(node, tree);
    }

    /**
       The removeLargest method removes the largest node
       from a binary search tree.
       @param bTree: The binary search tree.
       @return The result of removing the largest node.
     */
    private RemovalResult removeLargest(Node bTree)
    {
        if (bTree == null)
        {
            return null;
        }
        if (bTree.right == null)
        {
            // Root is the largest node
            Node tree = bTree.left;
            bTree.left = null;
            return new RemovalResult(bTree, tree);
        } else
        {
            // Remove the largest node from the right subtree.
            RemovalResult remResult
                    = removeLargest(bTree.right);
            bTree.right = remResult.tree;
            remResult.tree = bTree;
            return remResult;
        }
    }
}
