package doublylinkedlist;

public class MainDoublyLinkedList 
{

	public static void main(String[] args) 
	{
//		DoublyLinkedList myDLL = new DoublyLinkedList(7);
//		
//		myDLL.getHead();
//		myDLL.getTail();
//		myDLL.getLength();
//		myDLL.printList();
		
//		DoublyLinkedList myDLL = new DoublyLinkedList(1);
//		myDLL.append(2);
//	
//		// (2) Items - Returns 2 Node
//		System.out.println(myDLL.removeLast().value);
//		// (1) Item - Returns 1 Node
//		System.out.println(myDLL.removeLast().value);
//		// (0) Item - Returns null
//		System.out.println(myDLL.removeLast());
		
//		DoublyLinkedList myDLL = new DoublyLinkedList(3);
//		myDLL.prepend(2);
//		myDLL.prepend(1);
//		myDLL.printList();
		
//		DoublyLinkedList myDLL = new DoublyLinkedList(1);
//		myDLL.append(2);
//		// (2) Items - Returns 1 Node
//		System.out.println(myDLL.removeFirst().value);
//		// (1) Item - Returns 2 Node
//		System.out.println(myDLL.removeFirst().value);
//		// (0) Item - Returns null
//		System.out.println(myDLL.removeFirst());
		
//		DoublyLinkedList myDLL = new DoublyLinkedList(0);
//		myDLL.append(1);
//		myDLL.append(2);
//		myDLL.append(3);
//		
//		System.out.println(myDLL.get(1).value);
//		System.out.println(myDLL.get(2).value + "\n");
//		
//		myDLL.printList();
		
//		DoublyLinkedList myDLL = new DoublyLinkedList(0);
//		myDLL.append(1);
//		myDLL.append(2);
//		myDLL.append(3);
//		myDLL.printList();
//		System.out.println();
//		
//		myDLL.set(3, 4);
//		myDLL.printList();
		
//		DoublyLinkedList myDLL = new DoublyLinkedList(1);
//		myDLL.append(3);
//		myDLL.insert(1, 2);
//		myDLL.printList();
		
//		DoublyLinkedList myDLL = new DoublyLinkedList(0);
//		myDLL.append(1);
//		myDLL.append(2);
//		
//		myDLL.remove(1);
//		myDLL.printList();
		
//		DoublyLinkedList myDLL = new DoublyLinkedList(1);
//        myDLL.append(2);
//        myDLL.append(3);
//        myDLL.append(4);
//        myDLL.append(5);
//        
//        System.out.println("DLL before reverse:");
//        myDLL.printList();
//        
//        myDLL.reverse();
//        
//        System.out.println("\nDLL after reverse:");
//        myDLL.printList();
		
		 DoublyLinkedList myDll = new DoublyLinkedList(1);
	        myDll.append(2);
	        myDll.append(3);
	        myDll.append(4);
	        myDll.append(5);

	        System.out.println("myDll before swapPairs:");
	        myDll.printList();

	        myDll.swapPairs();

	        System.out.println("\nmyDll after swapPairs:");
	        myDll.printList();

	}

}
