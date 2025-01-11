package doublylinkedlist;

public class DoublyLinkedList 
{
	// points the first node of the doubly linked list
	private Node head;
	// points the last node of the doubly linked list
	private Node tail;
	// the number of nodes in the doubly linked list
	private int length;
	
	// Nested class Node, component of linked list
	class Node
	{
		// the value that the node contains
		int value;
		// a pointer to the next node in the doubly linked list
		Node next;
		// a pointer to the previous node in the doubly linked list
		Node prev;
		
		// Node constructor
		Node(int value)
		{
			// the value of the Node is equal to the value given in the argument
			this.value = value;
		}
	}
	
	// Doubly Linked List constructor
	public DoublyLinkedList(int value)
	{
		Node newNode = new Node(value);
		head = newNode;
		tail = newNode;
		length = 1;
	}
	
	// Prints the LinkedList
		public void printList()
		{
			// temp points at the same node as head
			Node temp = head;
			// while temp points at a node (if temp.next = null, then loop stops)
			while(temp != null)
			{
				// prints the node that temp is currently pointing at
				System.out.println(temp.value);
				// set temp to point to the next node
				temp = temp.next;
			}
		}

		// prints the value of the node that head is currently pointing at
		public void getHead() 
		{
			System.out.println("Head: " + head.value);
		}

		// prints the value of the node that tail is currently pointing at
		public void getTail() 
		{
			System.out.println("Tail: " + tail.value);
		}

		// prints the length of the doubly linked list
		public void getLength() 
		{
			System.out.println("Length: " + length);
		}
		
		// add a node at the end of the doubly linked list
		public void append(int value)
		{
			// create a new node with the value of the argument
			Node newNode = new Node(value);
			
			// if the doubly linked list is empty, the new node will be the head and tail of the doubly linked list
			if(length == 0)
			{
				head = newNode;
				tail = newNode;
			}
			// if the doubly linked list isn't empty
			else
			{
				// make the last node attach itself to the new node
				tail.next = newNode;
				// make the new node attach itself to the previous node
				newNode.prev = tail;
				// make the new node the tail of the doubly linked list
				tail = newNode;
			}
			
			// increment the length since we added a new node to the doubly linked list
			length++;
		}
		
		// remove the last node of the doubly linked list
		public Node removeLast()
		{
			// if the doubly linked list is empty, then nothing to remove
			if(length == 0)
			{
				return null;
			}
						
			// create a pointer that points to the last node
			Node temp = tail;
			
			// if there's only one node in the doubly linked list
			if(length == 1)
			{
				// make head and tail null since list is now empty
				head = null;
				tail = null;
			}
			// else if there's more than one node in the doubly linked list
			else
			{
				// move tail to the previous node in the doubly linked list
				tail = tail.prev;
				// detach the last node to remove from the doubly linked list
				tail.next = null;
				temp.prev = null;
			}
			
			// decrement the length since we removed one node
			length--;
			
			// return the node we removed
			return temp;
		}
		
		// add a node from the beginning of the doubly linked list
		public void prepend(int value)
		{
			// create a new node to add
			Node newNode = new Node(value);
			
			// if the doubly linked list is empty
			if(length == 0)
			{
				// head and tail will point to the newly added node
				head = newNode;
				tail = newNode;
			}
			// if the doubly linked list is not empty
			else
			{
				// attach the new node to head
				newNode.next = head;
				// attach the head to the new node
				head.prev = newNode;
				// head becomes the new node
				head = newNode;
			}
			
			// increment length since we added a node
			length++;
		}
		
		// remove the first node of the doubly linked list
		public Node removeFirst()
		{
			// if the doubly linked list is empty, then nothing to remove
			if(length == 0)
			{
				return null;
			}
			
			// set temp to the first node
			Node temp = head;
			
			// if there's only one node in the doubly linked list
			if(length == 1)
			{
				// set head and tail to null since we're removing the last node in the doubly linked list
				head = null;
				tail = null;
			}
			// if the doubly linked list has more than one node
			else
			{
				// move head to the next node (second node)
				head = head.next;
				// detach current head from the first node since we'll remove it
				head.prev = null;
				// detach the node to be removed from the doubly linked list
				temp.next = null;
			}
			
			// decrement length since we removed a node
			length--;
			
			// return the node we just removed
			return temp;
		}
		
		// get a specific node from the doubly linked list
		public Node get(int index)
		{
			// if the index is out of bounds, nothing to get
			if(index < 0 || index >= length)
			{
				return null;
			}
			
			// set temp to the first node
			Node temp = head;
			
			// if the index is in the first half of the doubly linked list
			if(index < (length/2))
			{
				// move temp through the list until it reaches the node we're looking for
				for(int i = 0; i < index; i++)
				{
					temp = temp.next;
				}
			}
			// if the index is in the other half of the doubly linked list
			else
			{
				// set temp to the last node of the doubly linked list
				temp = tail;
				
				// move temp towards head until temp points to the node we're looking for
				for(int i = (length-1); i > index; i--)
				{
					temp = temp.prev;
				}
			}
			
			// return the node at the index specified
			return temp;
		}
		
		// change the value of a node in the doubly linked list
		public boolean set(int index, int value)
		{
			// set temp to the node at the index specified
			Node temp = get(index);
			
			// if temp is pointing at a node, then change the value of that node
			if(temp != null)
			{
				temp.value = value;
				return true;
			}
			
			// no node had their value changed
			return false;
		}
		
		// add a node in the doubly linked list at the specified index
		public boolean insert(int index, int value)
		{
			// if the index is out of bounds, no node is added
			if(index < 0 || index > length)
			{
				return false;
			}
			
			// if we're to add a node at the beginning of the doubly linked list
			if(index == 0)
			{
				// then use the method prepend to add a node at the beginning
				prepend(value);
				return true;
			}
			
			// if we're to add a node at the end of the doubly linked list
			if(index == length)
			{
				// then use the method append to add a node at the end
				append(value);
				return true;
			}
			
			// create a new node
			Node newNode = new Node(value);
			
			// create two pointers which point to the two nodes that will be before and after the node we insert respectively
			Node before = get(index-1);
			Node after = before.next;
			
			// attach the new node to its neighbor nodes
			newNode.prev = before;
			newNode.next = after;
			// detach the nodes before and after from each other and attach them to the new node
			before.next = newNode;
			after.prev = newNode;
			
			// increment length since we added a new node
			length++;
			
			// insert method succeeded
			return true;
		}
		
		// remove a node at a specified index
		public Node remove(int index)
		{
			// if the index is out of bounds, then nothing to remove
			if(index < 0 || index >= length)
			{
				return null;
			}
			
			// if it's the first node to be removed
			if(index == 0)
			{
				// then use the method removeFirst
				return removeFirst();
			}
			
			// if it's the last node to be removed
			if(index == (length-1))
			{
				// then use the method removeLast
				return removeLast();
			}
			
			// create temp pointer to point at the node to be removed
			Node temp = get(index);
			
			// attach the neighbor nodes to each other
			temp.next.prev = temp.prev;
			temp.prev.next = temp.next;
			// detach the node to be removed from its neighbors
			temp.prev = null;
			temp.next = null;
			
			// decrement length since we removed a node
			length--;
			
			// return the node we removed
			return temp;
		}
		
		// swap the values of the first node and the last node
		public void swapFirstLast()
		{
			// if the doubly linked list is empty or has only one node, nothing to swap
			if(length < 2)
			{
				return;
			}
			
			// save the head value to temp
			int temp = head.value;
			// head value becomes tail value
			head.value = tail.value;
			// tail value becomes temp value
			tail.value = temp;
		}
		
		// reverse the order of nodes of the doubly linked list
		public void reverse()
		{
			// if the doubly linked list is empty or has only one node, nothing to reverse
			if(length < 2)
			{
				return;
			}
			
			// the current node to swap its prev and next with each other
			Node a = head;
			// the node before the one that swaps its prev and next
			Node b = null;
			
			// iterates through the doubly linked list until all nodes has their prev and next swapped
			while(a != null)
			{
				// put pointer b to the node before the node which pointer a is
				b = a.prev;
				// set prev to the next node
				a.prev = a.next;
				// set next to the node before
				a.next = b;
				// after swapping the node's next and prev with each other, pass pointer a to the next node
				a = a.prev;
			}
			
			// swap head and tail with each other
			a = head;
			head = tail;
			tail = a;
		}
		
		// check if a doubly linked list is a palindrome
		public boolean isPalindrome()
	    {
			// if the doubly linked list is empty
	        if(length == 0)
	        {
	            return true;
	        }
	        
	        // two pointers that will check if the values are the same
	        Node a = head;
	        Node b = tail;
	        
	        // iterate until the pointers reach the middle of the doubly linked list
	        for(int i = 0; i < (length/2); i++)
	        {
	        	// if the value of a and b aren't equal
	            if(a.value != b.value)
	            {
	            	// then it's not a palindrome
	                return false;
	            }
	            
	            // move the pointers to the next nodes to check if they are equivalent
	            a = a.next;
	            b = b.prev;
	        }
	        
	        // the doubly linked list is a palindrome
	        return true;
	    }
		
		// swap adjacent pairs with each other
		// Ex.: <- 1 <-> 2 <-> 3 <-> 4 <-> 5 ->
		// Result : <- 2 <-> 1 <-> 4 <-> 3 <-> 5 ->
		public void swapPairs()
	    {
			// if the doubly linked list is empty or only has one node, then nothing to swap
	        if(length < 2)
	        {
	            return;
	        }
	        
	        // create dummy node to reposition the head after swapping all pairs
	        Node dummy = new Node(0);
	        // attach dummy to the head
	        dummy.next = head;
	        // pointer to mark node before the pairs to be swapped
	        Node b = dummy;
	        
	        // swap while head isn't null or head isn't the last node of the doubly linked list
	        while(head != null && head.next != null)
	            {
	        		// set pointer a after the current head
	                Node a = head.next;
	                
	                // swap current head and the node after which pointer a is
	                // attach the prev of head to the next node
	                head.prev = a;
	                // attach the prev of node a to the node before head which is node b
                    a.prev = b;
                    // attach the next of head to the node after node a
                    head.next = a.next;
                    // if there is a node after node a
                    if(head.next != null)
                    {
                    	// then attach the prev of that node to current head
                        head.next.prev = head;
                    }
                    // attach next of node a to the current head
                    a.next = head;
                    // attach the next of the node before head to node a
                    b.next = a;
	                
                    // set pointer b to the head
	                b = head;
	                // change current head to the node after node b
	                head = b.next;
	            }
	        
	        // set head to the first node after the dummy
	        head = dummy.next;
	        // detach prev of head as it is the first node of the doubly linked list
	        head.prev = null;
	        // detach dummy from the doubly linked list
	        dummy.next = null;
	    }
}
