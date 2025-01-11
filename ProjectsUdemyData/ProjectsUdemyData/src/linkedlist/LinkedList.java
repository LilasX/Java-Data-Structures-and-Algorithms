package linkedlist;

import java.util.HashSet;

public class LinkedList 
{
	// Pointers which points to a node
	private Node head;
	private Node tail;
	// the length of the linked list
	private int length;
	
	// Nested class Node
	class Node 
	{
		 // the value that is contained in the node
		 int value;
		 // the pointer of the Node which is used to point to another
		 Node next;
		 
		 // Node constructor
		 Node(int value)
		 {
			 // the value of the node created will be equal to the value passed as parameter
			 this.value = value;
		 }
	}
	
	// LinkedList constructor
	public LinkedList(int value)
	{
		// newNode points to the new node created
		Node newNode = new Node(value);
		// head will point to the same thing as newNode
		head = newNode;
		// tail will point to the new node created
		tail = newNode;
		// started the linked list will only one item (node)
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
	public void printHead() 
	{
		System.out.println("Head: " + head.value);
	}

	// prints the value of the node that tail is currently pointing at
	public void printTail() 
	{
		System.out.println("Tail: " + tail.value);
	}

	// prints the length of the linked list
	public void printLength() 
	{
		System.out.println("Length: " + length);
	}
	
	// get the node that head is currently pointing at
	public Node getHead() 
	{
		return head;
	}

	// get the node that tail is currently pointing at
	public Node getTail() 
	{
		return tail;
	}

	// get the length of the linked list
	public int getLength() 
	{
		return length;
	}
	
	// add a node at the end of the linked list
	public void append (int value)
	{
		// create a new node to add to the end of the list
		Node newNode = new Node(value);
		
		// both head and tail are pointing at the new node created since linked list is empty
		if(length == 0)
		{
			head = newNode;
			tail = newNode;
		}
		// if the linked list isn't empty
		else
		{
			// make the node that tail is pointing to point to the new node created
			tail.next = newNode;
			// make tail point to the new node created
			tail = newNode;
		}
		// the length is incremented by 1 since a new node is added
		length++;
	}
	
	// remove the last node in the linked list
	public Node removeLast()
	{
		// if there's no node to remove, then return null
		if(length == 0)
		{
			return null;
		}
		
		// two pointers used to identify the node before the last node
		// both pointers start at the node where head is, then will be iterated through the linked list
		Node temp = head;
		Node pre = head;
		
		// loop until temp reach the last node
		while(temp.next != null)
		{
			// set pre pointer to the node where temp is pointing
			pre = temp;
			// set temp to point to the next node
			temp = temp.next;
		}
		
		// set tail to the node before the last node in the linked list
		tail = pre;
		// make the pointer of the node that tail is pointing to null so we detach the last node from the linked list
		tail.next = null;
		// decrement the length of the linked list since we removed a node
		length--;
		
		// if we removed the only node in the linked list
		if(length == 0)
		{
			// set head and tail to null which characterize an empty linked list
			head = null;
			tail = null;
		}
		
		// return the node we removed from the linked list
		return temp;
	}
	
	// add a node which will be the first node of the linked list
	public void prepend(int value)
	{
		// creates a new node to add
		Node newNode = new Node(value);
		
		// if the linked list was empty
		if(length == 0)
		{
			// head and tail will point to the new node created
			head = newNode;
			tail = newNode;
		}
		else
		{
			// the new node created will point to the node where the head is
			newNode.next = head;
			// the head will point to the new node created
			head = newNode;
		}
		// increment the length of the linked list as we added a new node
		length++;
	}
	
	// remove the first node of the linked list
	public Node removeFirst()
	{
		// if the linked list is empty
		if(length == 0)
		{
			return null;
		}
		
		// create a pointer temp to point to the node where head is
		Node temp = head;
		// make head point to the second node of the linked list
		head = head.next;
		// make the node where temp is to point to null which will detach the node from the linked list
		temp.next = null;
		// decrement the length of the linked list since we removed a node
		length--;
		
		// if the node we removed was the only node in the linked list
		if(length == 0)
		{
			// make tail point to null (head is already pointing to null because head was made to point to the next node previously (null in this case)
			tail = null;
		}
		
		// return the first node removed
		return temp;
	}
	
	// get the node at a specific index
	public Node get(int index)
	{
		// if the index is out of bounds of the linked list, return null
		if(index < 0 || index >= length)
		{
			return null;
		}
		
		// make temp point at the node which head is pointing at
		Node temp = head;
		// iterates temp through the linked list until the corresponding index
		// similar to iterating through an array to find the element at a specific index
		for(int i = 0; i < index; i++)
		{
			temp = temp.next;
		}
		
		// return the node that is at the corresponding index
		return temp;
	}
	
	// change the value of a node and check if it succeeded
	public boolean set(int index, int value)
	{
		// get the node at the index then
		// set temp to the node corresponding to the index
		Node temp = get(index);
		
		// if temp isn't null then temp is pointing at a node
		if(temp != null)
		{
			// change the value of the node that temp is pointing at
			temp.value = value;
			// return true since it succeeded
			return true;
		}
		
		// if it failed to set a value for a node
		return false;
	}
	
	// insert a node in the linked list
	public boolean insert(int index, int value)
	{
		// if the index is out of bounds, then return false
		if(index < 0 || index > length)
		{
			return false;
		}
		
		// if the index is 0, then we can use prepend method 
		// since it's adding a node at the beginning of the linked list
		if(index == 0)
		{
			prepend(value);
			return true;
		}
		
		// if the index is equal to the length, then we can use append method
		// since it's adding a node at the end of the linked list
		if(index == length)
		{
			append(value);
			return true;
		}
		
		// create a new node to add into the linked list
		Node newNode = new Node(value);
		// set temp to the node which will be the previous node of the node we want to insert
		Node temp = get(index-1);
		// set the pointer where the new node is to point to the node of the corresponding index
		newNode.next = temp.next;
		// set the pointer where temp is to point to the new node created
		temp.next = newNode;
		// increment the length since we added a new node to the linked list
		length++;
		// return true since it succeeded
		return true;
	}
	
	// remove a node from the linked list
	public Node remove(int index)
	{
		// if the index is out of bounds, then return null
		if(index < 0 || index >= length)
		{
			return null;
		}
		
		// if it's the first index, then we can use removeFirst() method
		if(index == 0)
		{
			return removeFirst();
		}
		
		// if it's the last node of the linked list, then we can use removeLast() method
		if(index == (length-1))
		{
			return removeLast();
		}
		
		// get the node before the node to be removed
		Node prev = get(index-1);
		// set temp to point to the node to be removed
		Node temp = prev.next;
		// make the prev node to point to the node after the temp node
		prev.next = temp.next;
		// detach the temp node from the linked list
		temp.next = null;
		// decrement the length since we remove a node from the linked list
		length--;
		
		// return the node we removed
		return temp;
	}
	
	// reverse the linked list
	public void reverse()
	{
		// switch head tp tail and tail to head
		Node temp = head;
		head = tail;
		tail = temp;
		
		// create pointers that points to the node before and after temp node
		Node after = temp.next;
		Node before = null;
		
		// iterates through the linked list to reverse each node's pointer to point the previous node instead of the node that comes after
		for(int i = 0; i < length; i++)
		{
			// set after to the node after temp node
			after = temp.next;
			// make the pointer of the temp node to point to the previous node
			temp.next = before;
			// set before to temp so that they point the same node
			before = temp;
			// temp points to the after node
			temp = after;
		}
	}
	
	// find the middle node using Floyd's Tortoise and Hare algorithm
	public Node findMiddleNode()
	{
		// two pointers which one moves as twice as the other, both start at head
		Node slow = head;
		Node fast = head;
		
		// if linked list is empty, then return null
		if(head == null)
		{
			return null;
		}
		
		// loop until fast reach the last node of the linked list and slow will point to the middle node
		while(fast.next != null)
		{
			// move fast to the next node 
			fast = fast.next;
			// move slow to the next node
			slow = slow.next;
			
			// make sure that fast can move to a node before moving fast
			if(fast.next != null)
			{
				fast = fast.next;
			}
		}
		
		// return slow which points to the middle node
		return slow;
	}
	
	// check if there's a loop in the linked list using Floyd's cycle-finding algorithm
	public boolean hasLoop()
    {
		// two pointers which fast moves twice as much as slow
        Node slow = head;
        Node fast = head;
        
        // if the linked list is empty, then there's no loop
        if(head == null)
        {
            return false;
        }
        
        // loop as long as fast didn't reach the last node
        while(fast.next != null)
        {
        	// move slow to the next node
            slow = slow.next;
            // move fast to the next node
            fast = fast.next;
            
            // if fast isn't at the last node yet, move fast to the next node
            // it's to prevent fast becoming null
            if(fast.next != null)
            {
                fast = fast.next;
            }
            
            // if fast and slow are pointing to the same node, 
            // that means fast caught up to slow which means there's a loop
            if(fast == slow)
            {
                return true;
            }
        }
        
        // no loop was found
        return false;
    }
	
	// find the Kth node from the end of the linked list
	public Node findKthFromEnd(int k)
    {
		// if the linked list is empty, return null
        if(head == null)
        {
            return null;
        }
        
        // if there's only one node in the linked list
        if(head.next == null)
        {
            return head;
        }
        
        // slow will point the Kth node
        Node slow = head;
        // fast will check whether we reach the end of the linked list
        Node fast = head;
        
        // iterate fast to check if Kth node is out of bounds
        for(int i = 1; i < k; i++)
        {
            fast = fast.next;
            
            // if fast is null, then it's out of bounds
            if(fast == null)
            {
                return null;
            }
        }
        
        // loop as long as fast isn't pointing at the last node of the linked list
        while(fast.next != null)
        {
        	// fast and slow moves to the next node respectively
            fast = fast.next;
            slow = slow.next;
        }
        
        // slow points at the Kth node
        return slow;
    }
	
	// rearrange the nodes from smaller than x to greater than x while keeping the order of the nodes in the linked list
	public void partitionList(int x)
    {
		// if the linked list is empty or if there's only one node
        if(head == null || head.next == null)
        {
            return;
        }
        
        // dummy node for values less than x
        // Dummy Lesser Node will also act as tail of this chain
        Node dLNode = new Node(0);
        // dummy node for values equal or greater than x
        // Dummy Equal/Greater Node will also act as tail of this chain
        Node dEGNode = new Node(0);
        
        // head pointer for chain of values less than x
        Node dLhead = dLNode;
        // head pointer for chain of values equal or greater than x
        Node dEGhead = dEGNode;
        
        // iterate through the linked list
        for(int i = 0; i < length; i++)
        {
        	// if the value of the current node is less than x
            if(head.value < x)
            {
            	// attach dLNode to the current head of the linked list
                dLNode.next = head;
                // move the head of the linked list to the next node
                head = head.next;
                // move dLNode pointer to the node we just attached to the chain
                dLNode = dLNode.next;
                // detach the dLNode from the linked list
                dLNode.next = null;
            }
            // if the value of the current node is equal to or greater than x
            else 
            {
            	// attach dEGNode to the current head of the linked list
                dEGNode.next = head;
                // move the head of the linked list to the next node
                head = head.next;
                // move dEGNode pointer to the node we just attached to the chain
                dEGNode = dEGNode.next;
                // detach the dEGNode from the linked list
                dEGNode.next = null;
            }
        }
        
        // if the chain for nodes with value less than x is not empty
        if(dLNode != dLhead)
        {
        	// set the head of the linked list directly to the node after the dummy node
            head = dLhead.next;
            // detach the dLhead from the chain
            dLhead.next = null;
            // attach the chain for nodes with value less than x 
            // to the other chain for nodes with values equal to or greater than x
            dLNode.next = dEGhead.next;
            // detach dEGhead from the newly formed linked list
            dEGhead.next = null;
        }
        // if we only have nodes with value equal to or greater than x
        else
        {
        	// set the head of the linked list directly to the node after the dummy node
            head = dEGhead.next;
            // detach the dummy node from the linked list
            dEGhead.next = null;
        }
        
    }
	
	// remove nodes that are of duplicate values
	public void removeDuplicates()
    {
		// if the linked list is empty or only have one node, there won't be any duplicates
        if(head == null || head == null)
        {
            return;
        }
        
        // using HashSet to have a time complexity of O(n)
        // HashSet can check for duplicates automatically
        // HashSet doesn't allow duplicates
        HashSet <Integer> set = new HashSet<>();
        
        // pointer to keep track of which node we're currently checking
        Node temp = head;
        // pointer to know which is the last node we decided to keep in the linked list
        Node keep = head;
        
        // loop as long as temp isn't null, iterates temp through the linked list
        while(temp != null)
        {
        	// return true if it succeeded adding the node's value into the list
        	// meaning the current value is not a duplicate and added in the set
            if(set.add(temp.value))
            {
            	// keep the current node in the linked list
                keep = temp;
                // move temp to the next node
                temp = temp.next;
            }
            // the current node is a duplicate value
            else
            {
            	// connect the last node we kept to the next node to check if duplicate
                keep.next = temp.next;
                // detach the duplicate node from the linked list
                temp.next = null;
                // set temp to the next node to check if duplicate
                temp = keep.next;
            }
        }
    }
    
	// convert the linked list containing a binary number to decimal value
	public int binaryToDecimal()
    {
		// pointer to iterate through the linked list
        Node temp = head;
        // the current decimal value starts at 0
        int num = 0;
        
        // loop as long as temp isn't null
        while (temp != null)
        {
        	// if the value of the current node isn't a binary digit (0 or 1), then return 0
            if(temp.value > 1)
            {
                return 0;
            }
            
            // formula to convert the binary number to decimal
            // Ex.: 1101
            // 0 * 2 + 1 = 1
            // 1 * 2 + 1 = 3
            // 3 * 2 + 0 = 6
            // 6 * 2 + 1 = 13 <- result
            num = num * 2 + temp.value;
            // pass temp to the next node
            temp = temp.next;
        }
        
        // return the decimal value of the binary number we just converted
        return num;
    }
	
	// reverse the linked list that the nodes between index m and n produce inclusively
	public void reverseBetween(int m, int n)
    {
		// if the linked list is empty
		// if endIndex (n) is larger than startIndex(m), the method wouldn't work
		// if m = n, then there's nothing to reverse since it's the same node
        if(head == null || m >= n)
        {
            return;
        }
        
        // create a dummy node to make it easier to put a pointer to the node before the node that is included to be reversed
        Node dummy = new Node(0);
        // connect the dummy node to the head of the linked list
        dummy.next = head;
        
        // put p to dummy node
        Node p = dummy;
        
        // move p until p is on the node before the m node
        for(int i = 0; i < m; i++)
        {
            p = p.next;
        }
        
        // put pointer start on the m node
        Node start = p.next;
        
        // iterate through the node between m and n inclusively
        // basically the node start (m) will be move one by one until it reached to the n index
        for(int i = 0; i < (n-m); i++)
        {
        	// put temp after the start node
            Node temp = start.next;
            // start will point to the node after temp
            start.next = temp.next;
            // temp will point to the node after p
            temp.next = p.next;
            // then p will point to temp
            p.next = temp;
        }
        
        // put back head to the first node after the dummy in case the head node was included in the reverse
        head = dummy.next;
        // detach the dummy from the linked list
        dummy.next = null;
    }
	
	// sort the values in the linked list in ascending order by bubble sort
	public void bubbleSort()
    {
		// if the list has less than 2 nodes
        if(length < 2)
        {
        	// then it's sorted by default
            return;
        }
        
        // pointer that marks the end of the sorted portion of the list and the start of the unsorted portion left in the list
        Node sortedUntil = null;
        
        // while sortedUntil is not pointing at the second element of the linked list
        while(sortedUntil != this.head.next)
        {
        	// set a pointer current to the head of the linked list
        	// this is where we start comparing the values of the current node and the next node
            Node current = head;
            
            // continue to swap until the pointer current reach the last node of the unsorted portion of the list
            while(current.next != sortedUntil)
            {
            	// if the value of the current node is larger than the value of the next node
                if(current.value > current.next.value)
                {
                	// swap the values of the current node and the next node with each other
                    int temp = current.value;
                    current.value = current.next.value;
                    current.next.value = temp;
                }
                
                // move the pointer current to the next node
                current = current.next;
            }
            
            // mark the current node as sorted 
            sortedUntil = current;
        }
    }
	
	// sort the values in the linked list in ascending order by selection sort
	public void selectionSort()
    {
		// if the list has less than 2 nodes
        if(length < 2)
        {
        	// then it's sorted by default
            return;
        }
        
        // set a pointer current to the head of the linked list
        // this is where we start sorting to put the smallest value in the current node
        Node current = head;
        
        // continue sorting until the last node of the linked list
        while(current.next != null)
        {
        	// assume the node with the smallest value is the current node
            Node smallest = current;
            // pointer to find the smallest value in the unsorted portion of the list
            Node innerCurrent = current.next;
            
            // continue to find the smallest value until innerCurrent passed through all the nodes of the unsorted portion of the list
            while(innerCurrent != null)
            {
            	// if innerCurrent found a smaller value than the value of the node that smallest is pointing to
                if(innerCurrent.value < smallest.value)
                {
                	// then update the smallest value found to the value of innerCurrent node
                    smallest = innerCurrent;
                }
                
                // move innerCurrent to the next node
                innerCurrent = innerCurrent.next;
            }
            
            // if the smallest value found isn't the value of the current node
            if(smallest != current)
            {
            	// swap the values of the current node and the node that smallest is pointing to with each other
                int temp = current.value;
                current.value = smallest.value;
                smallest.value = temp;
            }
            
            // move current to the next node to be sorted
            current = current.next;
        }
    }
	
	// sort the values in the linked list in ascending order by insertion sort
	public void insertionSort()
    {
		// if the list has less than 2 nodes
        if(length < 2)
        {
        	// then it's sorted by default
            return;
        }
        
        // pointer to the head of the sorted list where it points to the smallest value
        Node sortedListHead = head;
        // pointer to the start of the unsorted portion of the linked list (nodes before this pointer is sorted)
        Node unsortedListHead = head.next;
        
        // continue to sort until all nodes have been sorted
        while(unsortedListHead != null)
        {
        	// if the value of the unsorted head is smaller than the value of the sorted head
            if(unsortedListHead.value < sortedListHead.value)
            {
            	// make the head (used as the end of the sorted portion) point to the next node to be sorted after
                head.next = unsortedListHead.next;
                // make the unsorted head (current node being processed) point to the sorted head 
                unsortedListHead.next = sortedListHead;
                // make the current node be the new sorted head
                sortedListHead = unsortedListHead;
            }
            // else if the current node will not become the new sorted head
            else
            {
            	// create a search pointer and make it point to the start of the sorted portion of the linked list
                Node searchPointer = sortedListHead;
                
                // iterate through the sorted portion of the linked list as long as
                // the next node of searchPointer is smaller than the value of the unsorted head (to put the current node in the sorted portion properly)
                // and that the next node is not the unsorted head (to avoid looking through the values of the nodes in the unsorted portion)
                while(searchPointer.next.value < unsortedListHead.value && searchPointer.next != unsortedListHead)
                {
                	// move the searchPointer to the next node
                    searchPointer = searchPointer.next;
                }
                
                // make head point to the next node to sort after processing the current node
                head.next = unsortedListHead.next;
                // make the current node point to the node after the searchPointer node 
                unsortedListHead.next = searchPointer.next;
                // make the searchPointer point the current node which is now in the sorted portion of the linked list
                searchPointer.next = unsortedListHead;
                
                // if the head is pointing the unsorted head 
                // it happens when the node to be sorted happens to be already sorted 
                if(head.next == unsortedListHead)
                {
                	// move the head to the unsorted head node
                    head = unsortedListHead;
                }
            }
            
            // move the unsorted head to the node after the head since we finished sorting the current node
            unsortedListHead = head.next;
        }
        
        // update the tail of the linked list by making it point to the current head (which was used to represent the end of the sorted portion of the list)
        tail = head;
        // update the head of the linked list by making it point to the sorted head
        head = sortedListHead;
    }
	
	// merge the linked list with another and sort the merged list assuming each linked list was sorted in ascending order prior to this merge
	public void merge(LinkedList otherList)
    {
		// create a pointer otherHead to point to the node of the head of the other list
        Node otherHead = otherList.getHead();
        // create a dummy node to facilitate the merge of the lists
        Node dummy = new Node(0);
        // create a pointer current which will traverse the merged list
        Node current = dummy;
        
        // continue merging and sorting at the same time while either linked list has nodes left
        while(head != null && otherHead != null)
        {
        	// if the value of the head is smaller than the value of the head of the other linked list
            if(head.value < otherHead.value)
            {
            	// then append the head to the merged list
                current.next = head;
                // move the head to the next node of the linked list
                head = head.next;
            }
            // it the value of the head isn't smaller than the value of the head of the other linked list
            else
            {
            	// then append the head of the other linked list to the merged list
                current.next = otherHead;
                // move the head of the other linked list to the next node of the other linked list
                otherHead = otherHead.next;
            }
            
            // move current to the next node of the merged list
            current = current.next;
        }
        
        // if the linked list is not empty
        if(head != null)
        {
        	// then append the head of the linked list which completes the merge of the lists
        	current.next = head;
        }
        // else if the other linked list is not empty
        else
        {
        	// then append the head of the other linked list which completes the merge of the lists
        	current.next = otherHead;
        	// update the tail by making the tail point to the tail of the other linked list
        	tail = otherList.getTail();
        }
        
        // move head to the second node since the first node is the dummy node
        head = dummy.next;
        // detach the dummy node from the merged linked list
        dummy.next = null;
        // update the length of the linked list by adding the length of the other linked list to its length
        length += otherList.length;
    }
}
