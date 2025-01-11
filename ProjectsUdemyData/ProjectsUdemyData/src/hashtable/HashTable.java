package hashtable;

import java.util.ArrayList;

public class HashTable 
{
	// fewer collisions if our address space has a prime number of addresses
	private int size = 7;
	// array of pointers that contains nodes
	private Node[] dataMap;
	
	// Nested class Node
	class Node
	{
		// the key access a value in the HashTable
		String key;
		// the value of the node
		int value;
		// the pointer that points to the next node of the current node
		Node next;
		
		// Node constructor
		Node(String key, int value)
		{
			// set the key to the string specified in the argument
			this.key = key;
			// set the value of the node created to the one specified in the argument
			this.value = value;
		}
	}
	
	// HashTable constructor
	public HashTable()
	{
		// initialize the array to the size specified
		dataMap = new Node[size];
	}
	
	// method to print the HashTable
	public void printTable()
	{
		// iterate through the hash table until the end
		for(int i = 0; i < dataMap.length; i++)
		{
			// print the current index/address
			System.out.println(i + ": ");
			// create pointer temp to iterate through the elements in the specified address
			Node temp = dataMap[i];
			// loop while there are elements in the current address to print
			while(temp != null)
			{
				// print the element in the current address
				System.out.println(" (" + temp.key + " = " + temp.value + ")");
				// move the pointer temp to the next element in the current address
				temp = temp.next;
			}
		}
	}
	
	// method that determines the address of the element depending on the key
	private int hash(String key)
	{
		// the value that will be returned from this function
		int hash = 0;
		// get the string as an array of characters
		char[] keyChars = key.toCharArray();
		
		// iterate through the array of char
		for(int i = 0; i < keyChars.length; i++)
		{
			// save the ascii value of the char at the current index of the array
			int asciiValue = keyChars[i];
			// process to hash the key
			// just 23 because it's a prime number so it makes the number more random (it can be any number)
			// modulo the length of the hash table so it's within range
			hash = (hash + asciiValue * 23) % dataMap.length;
		}
		
		// returns a number that will alway be in range, in our case it's from 0 to 6
		return hash;
	}
	
	// put the element into our hash table
	public void set(String key, int value)
	{
		// the index is determined by the hash method
		int index = hash(key);
		// create a new node storing the key and value specified in the arguments
		Node newNode = new Node(key, value);
		
		// if there's no element in the current index of the hash table
		if(dataMap[index] == null)
		{
			// dataMap is an array of pointers
			// pointer at the current index points to the new node created
			dataMap[index] = newNode;
		}
		// if there's already an element in the current index of the hash table
		else
		{
			// basically set temp to the head of the linked list in the current index
			Node temp = dataMap[index];
			
			// if the first existing node has the same key as the new node's key
			if(temp.key.equals(key))
			{
				// update the value of the existing node
				temp.value += value;
				// exit method
				return;
			}
			
			// iterate through the linked list in the current index until the last element
			while(temp.next != null)
			{
				// set temp to the next node
				temp = temp.next;
				
				// if the existing node has the same key as the new node's key
				if(temp.key.equals(key))
				{
					// update the value of the existing node
					temp.value += value;
					// exit method
					return;
				}
			}
			
			// add the new node created at the end of the linked list in the current index
			temp.next = newNode;
		}
	}
	
	// returns the value associated with the key
	public int get(String key)
	{
		// the index is determined by the hash method
		int index = hash(key);
		// temp points to the head of the linked list at the index specified
		Node temp = dataMap[index];
		
		// loop while temp is pointing at a node
		while(temp != null)
		{
			// if temp is pointing at a node with the key we're looking for
			if(temp.key == key)
			{
				// return that node's value
				return temp.value;
			}
			
			//else, move the pointer temp to the next node in that index
			temp = temp.next;
		}
		
		// if we didn't find a node with the key we're looking for, return value 0
		return 0;
	}
	
	// get all the keys in the hash table
	public ArrayList<String> keys()
	{
		// create an ArrayList to store all keys
		ArrayList<String> allKeys = new ArrayList<>();
		
		// iterate through the hash table until the end
		for(int i = 0; i < dataMap.length; i++)
		{
			// create pointer to iterate through the linked list in the current index
			Node temp = dataMap[i];
			
			// loop while temp is pointing at a node
			while(temp != null)
			{
				// add the keys of all nodes that temp pointed at
				allKeys.add(temp.key);
				// move temp to the next node
				temp = temp.next;
			}
		}
		
		// return the ArrayList which contains all keys of the hash table
		return allKeys;
	}
}
