package stack;

public class Stack 
{
	// represent the last element entered in the stack (LIFO)
	private Node top;
	// length, the number of elements in the stack
	private int height;
	
	// Nested class Node since the stack is represented using a linked list
	class Node
	{
		// the value that the node contains
		int value;
		// a pointer to the next node in the linked list
		Node next;
		
		// Node constructor
		Node(int value)
		{
			// the value of the Node is equal to the value given in the argument
			this.value = value;
		}
	}
	
	// Stack constructor
	public Stack(int value)
	{
		Node newNode = new Node(value);
		top = newNode;
		height = 1;
	}
	
	// prints the stack
	public void printStack()
	{
		// starts by the top
		Node temp = top;
		
		// iterates through the stack until there's no more elements to print
		while(temp != null)
		{
			System.out.println(temp.value);
			temp = temp.next;
		}
	}
	
	// prints the element at the top of the stack
	public void getTop()
	{
		System.out.println("Top: " + top.value);
	}
	
	// prints the number of elements in the stack
	public void getHeight()
	{
		System.out.println("Height: " + height);
	}
	
	// add a new element into the stack
	public void push(int value)
	{
		// create a new element to add into the stack
		Node newNode = new Node(value);
		
		// if the stack was empty
		if(height == 0)
		{
			// assign top to the new element added
			top = newNode;
		}
		// if the stack has elements in it
		else
		{
			// attach the new element to the top of the stack
			newNode.next = top;
			// then assign the top to the new element added
			top = newNode;
		}
		
		// increment height since we added a new element into the stack
		height++;
	}
	
	// remove an element from the stack
	public Node pop()
	{
		// if the stack is empty, then nothing to remove
		if(height == 0)
		{
			return null;
		}
		
		// set a pointer temp to the top
		Node temp = top;
		// move top to the next element in the stack
		top = top.next;
		// detach the element to be removed from the stack
		temp.next = null;
		// decrement height since we removed an element
		height--;
		
		// remove element which temp is pointing at
		return temp;
	}
}
