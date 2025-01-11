package linkedlist;

public class MainLinkedList 
{

	public static void main(String[] args) 
	{
		//myLinkedList will point to the new LinkedList created
//		LinkedList myLinkedList = new LinkedList(1);
//		
//		myLinkedList.append(2);
		
//		myLinkedList.printHead();
//		myLinkedList.printTail();
//		myLinkedList.printLength();
//			
//		myLinkedList.printList();
		
//		// (2) Items - Returns 2 Node
//		System.out.println(myLinkedList.removeLast().value);
//		// (1) Items - Returns 1 Node
//		System.out.println(myLinkedList.removeLast().value);
//		// (0) Items - Returns null
//		System.out.println(myLinkedList.removeLast());
		
//		LinkedList myLinkedList = new LinkedList(2);
//		myLinkedList.append(3);
//		
//		myLinkedList.prepend(1);
//		
//		myLinkedList.printList();
		
//		LinkedList myLinkedList = new LinkedList(1);
//		myLinkedList.append(2);
//		
//		// (2) Items - Returns 1 Node
//		System.out.println(myLinkedList.removeFirst().value);
//		// (1) Items - Returns 2 Node
//		System.out.println(myLinkedList.removeFirst().value);
//		// (0) Items - Returns null
//		System.out.println(myLinkedList.removeFirst());
		
//		LinkedList myLinkedList = new LinkedList(0);
//		myLinkedList.append(1);
//		myLinkedList.append(2);
//		myLinkedList.append(3);
//		
//		System.out.println(myLinkedList.get(2).value + "\n");
//		
//		myLinkedList.printList();
		
//		LinkedList myLinkedList = new LinkedList(11);
//		myLinkedList.append(3);
//		myLinkedList.append(23);
//		myLinkedList.append(7);
//		
//		myLinkedList.printList();
//		System.out.println();
//		
//		myLinkedList.set(1, 4);
//		myLinkedList.printList();
		
//		LinkedList myLinkedList = new LinkedList(0);
//		myLinkedList.append(2);
//		
//		myLinkedList.printList();
//		System.out.println();
//		
//		myLinkedList.insert(1, 1);
//		myLinkedList.printList();
		
//		LinkedList myLinkedList = new LinkedList(11);
//		myLinkedList.append(3);
//		myLinkedList.append(23);
//		myLinkedList.append(7);
//		
//		myLinkedList.printList();
//		System.out.println();
//		
//		myLinkedList.remove(2);
//		myLinkedList.printList();
		
//		LinkedList myLinkedList = new LinkedList(1);
//		myLinkedList.append(2);
//		myLinkedList.append(3);
//		myLinkedList.append(4);
//		
//		myLinkedList.printList();
//		System.out.println();
//		
//		myLinkedList.reverse();
//		myLinkedList.printList();
		
//		// Create a linked list with values 1, 2, 3, 4, and 5
//      LinkedList myLinkedList = new LinkedList(1);
//      myLinkedList.append(2);
//      myLinkedList.append(3);
//      myLinkedList.append(4);
//      myLinkedList.append(5);
//
//      System.out.println("Original linked list: ");
//      myLinkedList.printList();
//
//      // Reverse a sublist within the linked list
//      myLinkedList.reverseBetween(1, 3);
//      System.out.println("\nReversed sublist (1, 3): ");
//      myLinkedList.printList();
//      myLinkedList.reverseBetween(1, 3);
//
//      // Reverse another sublist within the linked list
//      myLinkedList.reverseBetween(0, 4);
//      System.out.println("\nReversed entire linked list: ");
//      myLinkedList.printList();
//      myLinkedList.reverseBetween(0, 4);
//        
//      // Reverse a sublist of length 1 within the linked list
//      myLinkedList.reverseBetween(2, 2);
//      System.out.println("\nReversed sublist of length 1 (2, 2): ");
//      myLinkedList.printList();
//
//      // Reverse an empty linked list
//      LinkedList emptyList = new LinkedList(0);
//      emptyList.removeLast();
//      emptyList.reverseBetween(0, 0);
//      System.out.println("\nReversed empty linked list: ");
//      emptyList.printList();
		
		LinkedList l1 = new LinkedList(1);
        l1.append(3);
        l1.append(5);
        l1.append(7);
        
        LinkedList l2 = new LinkedList(2);
        l2.append(4);
        l2.append(6);
        l2.append(8);
        
        l1.merge(l2);

        l1.printList();
	}

}
