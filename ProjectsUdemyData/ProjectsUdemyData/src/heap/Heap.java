package heap;

import java.util.*;

public class Heap 
{
	// the heap is a list that is actually representing a binary tree
	private List<Integer> heap;
	
	// Heap constructor
	public Heap()
	{
		// representing the heap as an ArrayList
		this.heap = new ArrayList<>();
	}
	
	// return a copy of the heap
	public List<Integer> getHeap()
	{
		return new ArrayList<>(heap);
	}
	
	// find the left child of a given index where the parent is
	private int leftChild(int index)
	{
		// multiplying the parent index by 2 and add 1 will give the index of the left child
		return 2 * index + 1;
	}
	
	// find the right child of a given index where the parent is
	private int rightChild(int index)
	{
		// multiplying the parent index by 2 and add 2 will give the index of the right child
		return 2 * index + 2;
	}
	
	// find the parent of a given index where a child is
	private int parent(int index)
	{
		// it's an integer division so if we divide an odd number by 2
		// the result will be converted to the resulting integer regardless of the decimal part
		return (index - 1) / 2;
	}
	
	// swapping two nodes in the binary tree or two values in the ArrayList
	private void swap(int index1, int index2)
	{
		// store the value of the first index into temp
		int temp = heap.get(index1);
		// set the value of the first index to the value of the second index
		heap.set(index1, heap.get(index2));
		// set the value of the second index to the value of temp
		heap.set(index2, temp);
	}
	
	// insert a new node into the binary tree (max heap)
	public void insert(int value)
	{
		// adding a value in the heap is the same as inserting a value from the end of the array
		heap.add(value);
		
		// pointer pointing at the index of the value we just added
		// the heap is always a complete binary tree so the new value added will always be at the end of the heap
		int current = heap.size() - 1;
		
		// loop as long as current (pointing an index) is larger than 0 
		// since at 0, we're at the beginning of the ArrayList which is equivalent to the root of the binary tree
		// and the value where current points to is larger than the value of its parent
		while(current > 0 && heap.get(current) > heap.get(parent(current)))
		{
			// swap the value at current with the value of its parent
			swap(current, parent(current));
			// update current so it points to the index of the value we just inserted in the max heap
			current = parent(current);
		}
	}
	
	// compare the value at the given index to its children so it goes down the binary tree to be placed properly in the max heap
	private void sinkDown(int index)
	{
		// create a pointer maxIndex pointing to the same node as index
		int maxIndex = index;
		
		// loop until all values are placed properly in the heap
		while(true)
		{
			// store the indices of the children of the current node that maxIndex is pointing
			int leftIndex = leftChild(index);
			int rightIndex = rightChild(index);
			
			// if there is a left child for the current node and the value of the left child is larger than the value of maxIndex
			if(leftIndex < heap.size() && heap.get(leftIndex) > heap.get(maxIndex))
			{
				// set maxIndex to value of the left child
				maxIndex = leftIndex;
			}
			
			// if there is a right child for the current node and the value of the right child is larger than the value of maxIndex
			if(rightIndex < heap.size() && heap.get(rightIndex) > heap.get(maxIndex))
			{
				// set maxIndex to value of the right child
				maxIndex = rightIndex;
			}
			
			// if the value of the current maxIndex is not equal to the value of index
			if(maxIndex != index)
			{
				// then a child of the node at index has a larger value than the parent node itself, so we swap them
				swap(index, maxIndex);
				// set index to the same node as maxIndex
				index = maxIndex;
			}
			// if maxIndex and index are pointing to the same node
			else
			{
				// then we don't need to sink down any further and we have a valid heap
				return;
			}
		}
	}
	
	// remove a value in the max heap which is removing the root of the binary tree (removing a value from the beginning of the ArrayList)
	public Integer remove()
	{
		// if the heap is empty
		if(heap.size() == 0)
		{
			// nothing to remove
			return null;
		}
		
		// if there's only one element in the heap
		if(heap.size() == 1)
		{
			// remove the element in the first index of the ArrayList
			return heap.remove(0);
		}
		
		// store the value to be removed into maxValue
		int maxValue = heap.get(0);
		
		// remove the last element of the heap and make it the root of the binary tree
		heap.set(0, heap.remove(heap.size() - 1));
		
		// update the heap so that the value that became root is placed correctly in the heap
		// and the rest of the nodes are also placed properly
		sinkDown(0);
		
		// remove a value from the heap
		return maxValue;
	}
	
	// adding a node in the binary tree (min heap)
	public void insertMin(int value)
    {
		// add the value into the binary tree (represented as ArrayList)
        heap.add(value);
        
        // current points to the last index of the ArrayList
        int current = heap.size() - 1;
        
        // while current is not at the first index of the ArrayList (root of binary tree)
        // and that the parent of current node has a smaller value than the current node
        while(current > 0 && heap.get(current) < heap.get(parent(current)))
        {
        	// swap the nodes with each other
            swap(current, parent(current));
            // set the pointer current to the parent node (which is the original node that current was pointing to)
            current = parent(current);
        }
    }
	
	// rearrange the binary tree by comparing the current node to its children
	// so it goes down the binary tree so that the min heap is valid
	public void sinkDownMin(int index)
    {
		// assuming the given index contains the minimum value
        int minIndex = index;
        
        // loop until we rearranged the binary tree so that the min heap is valid
        while(true)
        {
        	// set leftIndex as the index of the left child of the current index
            int leftIndex = leftChild(index);
            // set rightIndex as the index of the right child of the current index
            int rightIndex = rightChild(index);
            
            // if left child of the current node (index) exists and its value is smaller than the current value at minIndex
            if(leftIndex < heap.size() && heap.get(leftIndex) < heap.get(minIndex))
            {
            	// set minIndex to the left child's index
                minIndex = leftIndex;
            }
            
            // if the right child of the current node (index) exists and its value is smaller than the current value at minIndex
            if(rightIndex < heap.size() && heap.get(rightIndex) < heap.get(minIndex))
            {
            	// set minIndex to the right child's index
                minIndex = rightIndex;
            }
            
            // if minIndex and index are not pointing to the same node in the binary tree (min heap)
            if(minIndex != index)
            {
            	// then swap the values of the nodes at minIndex and index with each other
                swap(index, minIndex);
                // set the current index to minIndex
                index = minIndex;
            }
            // if index and minIndex are pointing to the same node
            else
            {
            	// the heap is valid and no node needs to be sinked down
                return;
            }
        }
    }
	
	// remove a node (root) from the binary tree (min Heap)
	public Integer removeMin()
    {
		// if the heap is empty
        if(heap.size() == 0)
        {
        	// nothing to remove
            return null;
        }
        
        // if there's only the root in the binary tree
        if(heap.size() == 1)
        {
        	// remove the node (root) which is at the first index of the ArrayList
            return heap.remove(0);
        }
        
        // store the value of the first index into minValue
        int minValue = heap.get(0);
        
        // remove the value of the last index and put it to the first index of the ArrayList
        heap.set(0, heap.remove(heap.size() - 1));
        
        // rearrange the binary tree so it is complete and it starts from the smallest value to larger value (from root to its children)
        sinkDownMin(0);
        
        // remove the value we stored into minValue from the min heap
        return minValue;
    }
}
