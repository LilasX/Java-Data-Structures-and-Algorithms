package queue;

public class Queue 
{
	// the first element in the queue
	private Node first;
	// the last element in the queue
	private Node last;
	// the number of elements in the queue
	private int length;
	
	// Nested class Node since the Queue is represented by a linked list
	class Node
	{
		// value of the Node
		int value;
		// pointer to the next node
		Node next;
		
		// Node constructor
		Node(int value)
		{
			// the value of the node is the value entered as argument
			this.value = value;
		}
	}
	
	// Queue constructor
	public Queue(int value)
	{
		Node newNode = new Node(value);
		first = newNode;
		last = newNode;
		length = 1;
	}
	
	// prints the queue
	public void printQueue()
	{
		// pointer starts at the first element
		Node temp = first;
		
		// iterate temp through queue until there's no element in the queue
		while(temp != null)
		{
			// prints the element where temp is
			System.out.println(temp.value);
			// pass temp to the next element to print
			temp = temp.next;
		}	
	}
	
	// prints the first element of the queue
	public void getFirst()
	{
		System.out.println("First: " + first.value);
	}
	
	// prints the last element of the queue
	public void getLast()
	{
		System.out.println("Last: " + last.value);
	}
	
	// prints the length of the queue
	public void getLength()
	{
		System.out.println("Length: " + length);
	}
	
	// add an element to the queue from the end of the queue
	public void enqueue(int value)
	{
		// create a new element to add to the queue
		Node newNode = new Node(value);
		
		// if the queue is empty
		if(length == 0)
		{
			// first and last will point to the new node created
			first = newNode;
			last = newNode;
		}
		// if there are elements in the queue
		else
		{
			// attach the new node to the end of the queue
			last.next = newNode;
			// make last point to the new node created
			last = newNode;
		}
		
		// increment length since we added a new element in the queue
		length++;
	}
	
	// remove an element from the queue from the first element
	public Node dequeue()
	{
		// if the queue is empty, then nothing to remove
		if(length == 0)
		{
			return null;
		}
		
		// make temp point to the first element since it's the element to be removed
		Node temp = first;
		
		// if there's only one element in the queue
		if(length == 1)
		{
			// first and last will be null since queue is empty
			first = null;
			last = null;
		}
		// if the queue has more than one element 
		else
		{
			// move first to the next element
			first = first.next;
			// detach the element to be removed from the the queue
			temp.next = null;
		}
		
		// decrement length since we removed an element
		length--;
		
		// remove the element where temp is
		return temp;
	}
}
