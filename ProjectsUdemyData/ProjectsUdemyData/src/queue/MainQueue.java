package queue;

public class MainQueue 
{

	public static void main(String[] args) 
	{
//		Queue myQueue = new Queue(1);
//		myQueue.getFirst();
//		myQueue.getLast();
//		myQueue.getLength();
//		myQueue.printQueue();
		
		Queue myQueue = new Queue(1);
		myQueue.enqueue(2);
		
		myQueue.printQueue();
		System.out.println();
		
		// (2) Items - Returns 1 Node
		System.out.println(myQueue.dequeue().value);
		// (1) Items - Returns 2 Node
		System.out.println(myQueue.dequeue().value);
		// (0) Items - Returns null
		System.out.println(myQueue.dequeue());
	}
}
