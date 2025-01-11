package binarysearchtree;

import java.util.*;

public class BinarySearchTree 
{
	// root of the binary search tree
	// public root so we can access it from other classes
	Node root;
	
	// Nested class Node
	class Node
	{
		// value of the node
		int value;
		// pointer to the left child of the node
		Node left;
		// pointer to the right child of the node
		Node right;
		
		// Node constructor
		Node(int value)
		{
			// the value of the node will be the value given in the argument
			this.value = value;
		}
	}
	
	// inserting a node in the binary search tree
	public boolean insert(int value)
	{
		// create a new node with the given value in the argument
		Node newNode = new Node(value);
		
		// if the binary search tree is empty
		if(root == null)
		{
			// make the new node the root of the tree
			root = newNode;
			// we succeeded adding a node into the binary search tree
			return true;
		}

		// create pointer temp at the root
		Node temp = root;
		
		// loop until a return statement (until a node is inserted in the tree)
		while(true)
		{
			// if there's a node of the same value as the new node
			if(newNode.value == temp.value)
			{
				// duplicates are generally not allowed in a binary search tree
				return false;
			}
			
			// if the value of the new node is smaller than the value of the node that temp is pointing at
			if(newNode.value < temp.value)
			{
				// if temp node has no left child
				if(temp.left == null)
				{
					// then insert the new node to be the left child of temp node
					temp.left = newNode;
					// successfully inserted the new node in the tree
					return true;
				}
				
				// else if temp node has a left child already
				// then move pointer temp to point to be the left child of the current node temp was pointing at
				temp = temp.left;
			}
			// else if the value of the new node is greater than the value of the node that temp is pointing at
			else
			{
				// if temp node has no right child
				if(temp.right == null)
				{
					// then insert the new node to be the right child of temp node
					temp.right = newNode;
					// successfully inserted the new node in the tree
					return true;
				}
				
				// else if temp node has a right child already
				// then move pointer temp to point to be the right child of the current node temp was pointing at
				temp = temp.right;
			}
		}
	}
	
	// check if the binary search tree contains a node with the value given in the argument
	public boolean contains(int value)
    {
		// create a pointer temp to point to the root node
        Node temp = root;
        
        // loop as long as temp finds a node with the value or until temp finished traversed the tree
        while(temp != null)
        {
        	// if the value of the current node (temp) is what we're looking for
            if(value == temp.value)
            {
            	// then the tree contains the value
                return true;
            }
            
            // if the value we're looking for is smaller than the value of the current node (temp)
            if(value < temp.value)
            {
            	// then move temp to the left child to compare its value next 
                temp = temp.left;
            }
         // else if the value we're looking for is larger than the value of the current node (temp)
            else
            {
            	// then move temp to the right child to compare its value next
                temp = temp.right;
            }
        }
        
        // pointer temp traversed the tree and didn't find a node with the value we're looking for
        return false;
    }
	
	// checks if the binary search tree contains the value we're looking for
	// sets a pointer current to the root
	private boolean rContains(Node current, int value)
    {
		// if the binary search tree is empty
        if(current == null)
        {
        	// then there's no node to check 
            return false;
        }
        
        // if we find a node with the value we're looking for
        if(current.value == value)
        {
        	// then the tree contains the value we're looking for
            return true;
        }
        
        
        // if the value we're looking for is smaller than the value of the current node
        if(value < current.value)
        {
        	// then calls the method again but sets the pointer current to the left child of the current node
            return rContains(current.left, value);
        }
        // else if the value we're looking for is larger than the value of the current node
        else 
        {
        	// then calls the method again but sets the pointer current to the right child of the current node
            return rContains(current.right, value);
        }
    }
	
	// method overloading, check if the binary search tree contains the value given in the argument
	public boolean rContains(int value)
	{
		// traverse the tree from the root to the bottom of the tree
		return rContains(root, value);
	}
	
	// insert a node in a binary search tree recursively
	private Node rInsert(Node current, int value)
    {
		// if the pointer current is null
        if(current == null)
        {
        	// pop the node out of the call stack (ends instance)
            return new Node(value);
        }
        
        // if the value is smaller than the value of the current node
        if(value < current.value)
        {
        	// then the left child of the current node will be the node returned by recalling the method 
        	// where the pointer current will be on the left child of the current node
            current.left = rInsert(current.left, value);
        }
        // else if the value is larger than the value of the current node
        else if(value > current.value)
        {
        	// then it will be the value of the right child unless there's already a right child
        	// then recall the method but with the pointer current on the right child of the current node
            current.right = rInsert(current.right, value);
        }
        
        // pop out the current node (current instance of the method) from the call stack
        // if it's not pointing at the root, then it will point to the previous instance which would be the parent node of the current node
        return current;
    }
	
	// method overloading, insert a node in a binary search tree 
	public void rInsert(int value)
	{
		// if the binary search tree is empty
		if(root == null)
		{
			// make the new node to be the root of the tree
			root = new Node(value);
		}
		
		// call the method to insert a node in a binary search tree
		// node returned from this method will be pop out of the call stack
		rInsert(root, value);
	}
	
	// find the minimum value of the binary search tree
	// helper method for deleteNode method
	public int minValue(Node current)
    {
		// while there is a existing left child
        while(current.left != null)
        {
        	// move the pointer current to that left child
            current = current.left;
        }
        
        // return the value of the node where pointer current is
        return current.value;
    }
	
	// remove a node from the binary search tree and making sure the binary search tree is valid after
	private Node deleteNode(Node current, int value)
    {
		// the pointer current is null
        if(current == null)
        {
        	// then nothing to remove or already removed
            return null;
        }
        
        // if the value is smaller than the value of the current node
        if(value < current.value)
        {
        	// then compare the value with the value of the left child of the current node
        	// by setting the current pointer to the left child and recalling the method
            current.left = deleteNode(current.left, value);
        }
        // else if the value is larger than the value of the current node
        else if(value > current.value)
        {
        	// then compare the value with the value of the right child of the current node
        	// by setting the current pointer to the right child and recalling the method
            current.right = deleteNode(current.right, value);
        }
        // else if we find a node with the value we're looking for to delete
        else
        {
        	// if it's a leaf node
            if(current.left == null && current.right == null)
            {
            	// then return null to the method that called above (current.left or current.right) if that's the case
            	// or remove the node by making it null
                return null;
            }
            // if the current node only has a right child
            else if(current.left == null)
            {
            	// make the current node to be the right child
            	// and it will remove the current node from the tree since nothing is pointing at it
                current = current.right;
            }
            // if the current node only has a left child
            else if(current.right == null)
            {
            	// make the current node to be the left child
            	// and it will remove the current node from the tree since nothing it pointing at it
                current = current.left;
            }
            // if the current node to be removed has both left and right children
            else
            {
            	// check the minimum value from the right child of the current node
            	// since the value that needs to replace the value of the current node needs to be larger than the values on the left side of the current node
            	// and it needs to be smaller than the values on the right side of the current node
                int subTree = minValue(current.right);
                // replace the value of the current node with the minimum value found on the right subtree of the current node (which will delete the value we wanted to remove from the tree)
                current.value = subTree;
                // delete the node in the right subtree of the current node with the minimum value found previously
                current.right = deleteNode(current.right, subTree);
            }
        }
        
        // return the current node, pops out of the call stack
        // then the parent node of the current node will be the active instance of the call stack
        return current;
    }
	
	// method overloading, remove a node from the binary search tree
	public void deleteNode(int value)
	{
		// starting from the root, find the node to delete then remove it from the binary tree
		root = deleteNode(root, value);
	}
	
	// divide the sorted array into sub-array and place its elements so that the binary search tree is valid
	private Node sortedArrayToBST(int[] nums, int left, int right)
    {
		// if the sub-array is empty
        if(left > right)
        {
        	// no node to create since there's no value in the sub-array
            return null;
        }
        
        // determine the index of the middle element of the current sub-array
        int mid = left + (right - left) / 2;
        
        // create a new node with the value of the middle element of the current sub-array
        Node node = new Node(nums[mid]);
        
        // determine the left child of the current node
        // left is the left end of the current sub-array
        // right is the value of the middle index minus 1 of the current sub-array
        node.left = sortedArrayToBST(nums, left, mid - 1);
        // determine the right child of the current node
        // left is the value of the middle index plus 1 of the current sub-array
        // right is the right end of the current sub-array
        node.right = sortedArrayToBST(nums, mid + 1, right);
        
        // pop the current node out of the call stack
        // finished analyzing and inserting its right and left children respectively
        return node;
    }
	
	// convert a sorted array to a binary search tree
	public void sortedArrayToBST(int[] nums)
	{
		// starts constructing the binary search tree from the root
		this.root = sortedArrayToBST(nums, 0, nums.length - 1);
	}
	
	// invert or mirror a binary tree from the root
	private Node invertTree(Node node)
    {
		// if there's no node
        if(node == null)
        {
        	// then nothing to invert
            return null;
        }
        
        // if it is not a leaf node
        if(node.left != null || node.right != null)
        {
        	// create pointer temp to store the left child
            Node temp = node.left;
            // the left child will be the right child of the current node
            node.left = node.right;
            // the right child will be the left child of the current node
            node.right = temp;
            
            // the left child will have the subtree of the right child of the current node
            // by inverting the subtree of the left child of the current node
            node.left = invertTree(node.left);
            // the right child will have the subtree of the left child of the current node
            // by inverting the subtree of the right child of the current node
            node.right = invertTree(node.right);
        }
        
        // pop the current node from the call stack
        // go back to the previous instance of the call stack which will be the parent node (unless current node is leaf node or root)
        return node;
    }
	
	// invert or mirror the binary search tree
	public void invert()
	{
		// returns the root along with the mirrored version of the binary tree
		root = invertTree(root);
	}
	
	// Traverse the binary tree by Breadth First Search (Level Order Traversal)
	// Basically read the values of the tree from left to right and from the root to the bottom
	public ArrayList<Integer> BFS()
	{
		// create a pointer currentNode to point at the root
		Node currentNode = root;
		// create a queue to store the nodes which their values will be store in an ArrayList
		Queue<Node> queue = new LinkedList<>();
		// create an ArrayList to store the values of the nodes that are removed from the queue
		ArrayList<Integer> results = new ArrayList<>();
		// add the root node to the queue
		queue.add(currentNode);

		// loop as long as the queue isn't empty
		while(queue.size() > 0)
		{
			// remove a node from the queue
			currentNode = queue.remove();
			// add the value of the node which was removed from the queue
			results.add(currentNode.value);

			// if the node has a left child
			if(currentNode.left != null)
			{
				// add the left child into the queue
				queue.add(currentNode.left);
			}
			
			// if the node has a right child
			if(currentNode.right != null)
			{
				// add the right child into the queue
				queue.add(currentNode.right);
			}
		}
		
		// return the ArrayList which stores all the values of a level order traversal of the binary search tree
		return results;
	}
	
	// Traverse the binary search tree by Depth First Search - PreOrder
	// Basically read the value of the root then read the values of the left subtree and end it with the right subtree
	public ArrayList<Integer> DFSPreOrder()
	{
		// create an ArrayList to store the values of the nodes
		ArrayList<Integer> results = new ArrayList<>();
		
		// workaround to put a method inside a method since Java doesn't allow that
		class Traverse
		{
			// the method created which is literally the constructor of the class Traverse
			Traverse(Node currentNode)
			{
				// add the value of the current node to the ArrayList results
				results.add(currentNode.value);
				
				// if there is a left child
				if(currentNode.left != null)
				{
					// call the method (constructor) for the left child
					// we need to traverse the left subtree recursively
					new Traverse(currentNode.left);
				}
				
				// if there is a right child
				if(currentNode.right != null)
				{
					// call the method (constructor) for the right child
					// after the traversing the left subtree, we need to traverse the right subtree recursively
					new Traverse(currentNode.right);
				}
			}
		}
		
		// we start the traversal from the root
		new Traverse(root);
		
		// return the ArrayList with the PreOrder traversal results
		return results;
	}
	
	// Traverse the binary search tree by Depth First Search - PostOrder
	// Basically read the values of the left subtree then the right subtree and end it with the root
	public ArrayList<Integer> DFSPostOrder()
	{
		// create an ArrayList to store the values of the nodes
		ArrayList<Integer> results = new ArrayList<>();
		
		// workaround to put a method inside a method since Java doesn't allow that
		class Traverse
		{
			// the method created which is literally the constructor of the class Traverse
			Traverse(Node currentNode)
			{
				// if there is a left child
				if(currentNode.left != null)
				{
					// call the method (constructor) for the left child
					// we need to traverse the left subtree recursively
					new Traverse(currentNode.left);
				}
				
				// if there is a right child
				if(currentNode.right != null)
				{
					// call the method (constructor) for the right child
					// after the traversing the left subtree, we need to traverse the right subtree recursively
					new Traverse(currentNode.right);
				}
				
				// after both subtrees are traversed, add the value of the current node to the ArrayList results 
				results.add(currentNode.value);
			}
		}
		
		// we start the traversal from the root
		new Traverse(root);
		
		// return the ArrayList with the PostOrder traversal results
		return results;
	}
	
	// Traverse the binary search tree by Depth First Search - InOrder
	// Basically read the left subtree then the root and end it with the right subtree (in numerical order)
	public ArrayList<Integer> DFSInOrder()
	{
		// create an ArrayList to store the values of the nodes
		ArrayList<Integer> results = new ArrayList<>();
		
		// workaround to put a method inside a method since Java doesn't allow that
		class Traverse
		{
			// the method created which is literally the constructor of the class Traverse
			Traverse(Node currentNode)
			{
				// if there is a left child
				if(currentNode.left != null)
				{
					// call the method (constructor) for the left child
					// we need to traverse the left subtree recursively
					new Traverse(currentNode.left);
				}
				
				// after the left subtree is traversed, add the value of the current node to the ArrayList results 
				results.add(currentNode.value);
				
				// if there is a right child
				if(currentNode.right != null)
				{
					// call the method (constructor) for the right child
					// after the traversing the left subtree, we need to traverse the right subtree recursively
					new Traverse(currentNode.right);
				}
			}
		}
				
		// we start the traversal from the root
		new Traverse(root);
		
		// return the ArrayList with the InOrder traversal results
		return results;
	}
	
	// Traverse the binary search tree recursively by Depth First Search - PreOrder
	// Basically read the value of the root then read the values of the left subtree and end it with the right subtree
	private void rDFSPreOrderHelper(Node currentNode, ArrayList<Integer> results)
	{
		// if there is no node
		if (currentNode == null)
		{
			// nothing to traverse
			return;
		}
		 
		// add the value of the current node into the ArrayList results
	    results.add(currentNode.value);
	    // traverse left subtree
	    rDFSPreOrderHelper(currentNode.left, results);
	    // traverse right subtree
	    rDFSPreOrderHelper(currentNode.right, results);
	}
	
	// Traverse the binary search tree recursively by Depth First Search - PreOrder
	// Basically read the value of the root then read the values of the left subtree and end it with the right subtree
	public ArrayList<Integer> rDFSPreOrder()
	{
		// create an ArrayList to store the values of the nodes
		ArrayList<Integer> results = new ArrayList<>();
		// we start the traversal from the root and store the results into the created ArrayList results
	    rDFSPreOrderHelper(root, results);
	    
	    // return the ArrayList with the PreOrder traversal results
	    return results;
	}
	
	// Traverse the binary search tree recursively by Depth First Search - PostOrder
	// Basically read the values of the left subtree then the right subtree and end it with the root
	private void rDFSPostOrderHelper(Node currentNode, ArrayList<Integer> results)
	{
		// if there is no node
		if (currentNode == null)
		{
			// nothing to traverse
			return;
		}
		
		// traverse left subtree
	    rDFSPostOrderHelper(currentNode.left, results);
	    // traverse right subtree
	    rDFSPostOrderHelper(currentNode.right, results);
	    // add the value of the current node into the ArrayList results
	    results.add(currentNode.value);
	}
	
	// Traverse the binary search tree recursively by Depth First Search - PostOrder
	// Basically read the values of the left subtree then the right subtree and end it with the root
	public ArrayList<Integer> rDFSPostOrder()
	{
		// create an ArrayList to store the values of the nodes
		ArrayList<Integer> results = new ArrayList<>();
		// we start the traversal from the root and store the results into the created ArrayList results
	    rDFSPostOrderHelper(root, results);
	    
	    // return the ArrayList with the PostOrder traversal results
	    return results;
	}
	
	// Traverse the binary search tree recursively by Depth First Search - InOrder
	// Basically read the left subtree then the root and end it with the right subtree (in numerical order)
	private void rDFSInOrderHelper(Node currentNode, ArrayList<Integer> results)
	{
		// if there is no node
		if (currentNode == null) 
		{
			// nothing to traverse
			return;
		}
		 
		// traverse left subtree
	    rDFSInOrderHelper(currentNode.left, results);
	    // add the value of the current node into the ArrayList results
	    results.add(currentNode.value);
	    // traverse right subtree
	    rDFSInOrderHelper(currentNode.right, results);
	}
	
	// Traverse the binary search tree recursively by Depth First Search - InOrder
	// Basically read the left subtree then the root and end it with the right subtree (in numerical order)
	public ArrayList<Integer> rDFSInOrder()
	{
		// create an ArrayList to store the values of the nodes
		ArrayList<Integer> results = new ArrayList<>();
		// we start the traversal from the root and store the results into the created ArrayList results
	    rDFSInOrderHelper(root, results);
	    
	    // return the ArrayList with the InOrder traversal results
	    return results;
	}
	
	// check if the binary search tree is valid with in-order traversal
	public boolean isValidBST()
    {
		// create an ArrayList to store the results of the in-order traversal
        ArrayList<Integer> results = DFSInOrder();
        
        // iterate through the ArrayList results starting from the second index (to be able to compare to a previous index)
        for(int i = 1; i < results.size(); i++)
        {
        	// if the value of the previous index is larger than or equal to the value of the current index
            if(results.get(i - 1) >= results.get(i))
            {
            	// then the binary search tree is not valid
                return false;
            }
        }
        
        // the binary search tree is valid
        return true;
    }
	
	// find the Kth smallest value in the binary search tree
	public Integer kthSmallest(int k)
    {
		// create a stack to store nodes to be processed 
		// it is similar to the call stack used in recursive in-order traversal
        Stack<Node> stack = new Stack<>();
        // create a pointer current at the root of the binary search tree
        Node current = this.root;
        
        // loop until current traversed all nodes in the tree
        // or until the stack is empty
        while(current != null || !stack.isEmpty())
        {
        	// repeat until current is pointing at a node in the tree
            while(current != null)
            {
            	// push the current node onto the stack
                stack.push(current);
                // move pointer current to the left child of the current node
                current = current.left;
            }
            
            // move the pointer current to the node that has been popped from the stack
            current = stack.pop();
            // decrement k by 1 after each node processed from the stack
            k--;
            
            // if k reached 0
            if(k == 0)
            {
            	// then the value of the current node is the Kth smallest value we're looking for
                return current.value;
            }
            
            // else if k is not equal to 0, move current to the right child of the current node
            current = current.right;
        }
        
        // the integer k is larger than the number of nodes in the tree
        return null;
    }
}