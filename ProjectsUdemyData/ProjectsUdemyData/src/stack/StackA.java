package stack;

import java.util.ArrayList;

// Stack using ArrayList
public class StackA<T>
{
	// stack which stores multiple data types
	// by using a generic parameter type <T>
	// it can hold any data types such as Integers, Characters, etc.
	private ArrayList<T> stackList = new ArrayList<>();  
    
	// get the stack
    public ArrayList<T> getStackList() 
    {
        return stackList;
    }
    
    // print the stack
    public void printStack() 
    {
    	// Iterate from the end to the beginning of the ArrayList
    	// since we're imitating a stack, it's LIFO
        for (int i = stackList.size()-1; i >= 0; i--) 
        {
            System.out.println(stackList.get(i));
        }
    }
    
    // check if stack is empty
    public boolean isEmpty() 
    {
        return stackList.size() == 0;
    }
    
    // return top element
    public T peek() 
    {
    	// if the stack is empty, the top is null
        if (isEmpty()) 
        {
            return null;
        } 
        // if the stack is not empty, the top is the last element entered in the stack
        else 
        {
            return stackList.get(stackList.size() - 1);
        }
    }
    
    // return the size of the stack
    public int size() 
    {
        return stackList.size();
    }
    
    // add an element into the stack
    public void push(T e)
    {
    	// add an element at the end of the ArrayList
    	stackList.add(e);
    }
    
    // remove the top element of the stack
    public T pop()
    {
    	// if the stack is empty, then nothing to remove
    	if(stackList.isEmpty())
    	{
    		return null;
    	}
    	
    	// if the stack is not empty, then remove the element at the last index of the ArrayList
    	return stackList.remove(stackList.size()-1);
    }
}
