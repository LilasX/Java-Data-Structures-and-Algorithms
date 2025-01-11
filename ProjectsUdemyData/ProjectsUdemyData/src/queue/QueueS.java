package queue;

import java.util.Stack;

// Queue using two stacks
public class QueueS 
{
	// created two stacks for the implementation of a queue
	private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    // QueueS constructor
    public QueueS() 
    {
    	// initiate each stack to a new stack
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    // return the first element entered, the front of the queue
    public int peek() 
    {
        return stack1.peek();
    }

    // verify if the queue is empty by checking if the first stack contains any elements
    public boolean isEmpty() 
    {
        return stack1.isEmpty();
    }
    
    // add an element at the end of our queue (FIFO)
    public void enqueue(int value)
    {
    	// before adding an element at the end of the queue
        while(!stack1.isEmpty())
        {
        	// move all elements in stack1 to stack2
            stack2.push(stack1.pop());
        }
        
        // add an element in the queue which will end up being at the bottom of the stack
        stack1.push(value);
        
        // by doing this process, the oldest element to the newest element added goes from top to bottom
        while(!stack2.isEmpty())
        {
            // move all the elements from stack2 back to stack1
            stack1.push(stack2.pop());
        }
    }
    
    // remove the first element of the queue
    public Integer dequeue()
    {
    	// if the queue is empty, then nothing to remove
        if(stack1.isEmpty())
        {
            return null;
        }
        
        // else return the top of the stack which is the oldest element entered in the queue
        return stack1.pop();
    }
}
