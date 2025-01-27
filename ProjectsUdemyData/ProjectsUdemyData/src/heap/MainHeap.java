package heap;

import java.util.*;

public class MainHeap 
{
	// find the Kth smallest number in a given array
	public static int findKthSmallest(int[] nums, int k)
    {
		// using the properties of a max heap to find the smallest number
		// this will allow the max heap to only keep the smallest k elements
        Heap maxHeap = new Heap();
        
        // for each numbers in the given array
        for(int i : nums)
        {
        	// insert the number in the maxHeap then the largest number will be on top
            maxHeap.insert(i);
            
            // if the size of the max heap is greater than k
            if(maxHeap.getHeap().size() > k)
            {
            	// remove a value in the max heap (which will be the largest number)
                maxHeap.remove();
            }
        }
        
     // the root of the binary tree (max heap) will be returned which represents the Kth smallest number
        return maxHeap.remove();
    }
	
	// print the largest number seen until the current index of the array
	// Example : [1, 5, 2, 9, 3, 6, 8] -> [1, 5, 5, 9, 9, 9, 9]
	public static List<Integer> streamMax(int[] nums)
    {
		// create a max heap so we can keep track of the largest number (located at index 0 or root)
        Heap maxHeap = new Heap();
        // list to store the largest numbers seen 
        List<Integer> list = new ArrayList<>();
        
        // iterate through each integer of the given array
        for(int i : nums)
        {
        	// insert the integer from the array into the max heap
            maxHeap.insert(i);
            
            // add the current root of the binary tree (max heap) to the list
            // max heap is represented by an ArrayList so the value of the root of the binary tree (max heap) would be at index 0
            // which is also where the largest number is located in the max heap
            list.add(maxHeap.getHeap().get(0));
        }
        
        // return the list containing the running maximum of the input stream
        return list;
    }
	
	public static void main(String[] args) 
	{
//		Heap myHeap = new Heap();
//		myHeap.insert(99);
//		myHeap.insert(72);
//		myHeap.insert(61);
//		myHeap.insert(58);
//		
//		System.out.println(myHeap.getHeap());
//		
//		myHeap.insert(100);
//		System.out.println(myHeap.getHeap());
//		
//		myHeap.insert(75);
//		System.out.println(myHeap.getHeap());
		
//		Heap myHeap = new Heap();
//		myHeap.insert(95);
//		myHeap.insert(75);
//		myHeap.insert(80);
//		myHeap.insert(55);
//		myHeap.insert(60);
//		myHeap.insert(50);
//		myHeap.insert(65);
//		
//		System.out.println(myHeap.getHeap());
//		
//		myHeap.remove();
//		System.out.println(myHeap.getHeap());
//		
//		myHeap.remove();
//		System.out.println(myHeap.getHeap());
		
//		// Test case 1
//        int[] nums1 = {7, 10, 4, 3, 20, 15};
//        int k1 = 3;
//        System.out.println("Test case 1:");
//        System.out.println("Expected output: 7");
//        System.out.println("Actual output: " + findKthSmallest(nums1, k1));
//        System.out.println();
//
//        // Test case 2
//        int[] nums2 = {2, 1, 3, 5, 6, 4};
//        int k2 = 2;
//        System.out.println("Test case 2:");
//        System.out.println("Expected output: 2");
//        System.out.println("Actual output: " + findKthSmallest(nums2, k2));
//        System.out.println();
//
//        // Test case 3
//        int[] nums3 = {9, 3, 2, 11, 7, 10, 4, 5};
//        int k3 = 5;
//        System.out.println("Test case 3:");
//        System.out.println("Expected output: 7");
//        System.out.println("Actual output: " + findKthSmallest(nums3, k3));
//        System.out.println();
		
//		Heap myHeap = new Heap();
//		myHeap.insertMin(8);
//		myHeap.insertMin(15);
//		myHeap.insertMin(10);
//		myHeap.insertMin(16);
//		myHeap.insertMin(17);
//		myHeap.insertMin(23);
//		myHeap.insertMin(14);
//		myHeap.insertMin(21);
//		myHeap.insertMin(18);
//		myHeap.insertMin(25);
//		System.out.println(myHeap.getHeap());
//		myHeap.insertMin(9);
//		System.out.println(myHeap.getHeap());
//		myHeap.removeMin();
//		System.out.println(myHeap.getHeap());
		
//		Heap myHeap = new Heap();
//		myHeap.insertMin(4);
//		myHeap.insertMin(5);
//		myHeap.insertMin(6);
//		myHeap.insertMin(15);
//		myHeap.insertMin(9);
//		myHeap.insertMin(7);
//		myHeap.insertMin(20);
//		myHeap.insertMin(16);
//		myHeap.insertMin(25);
//		myHeap.insertMin(14);
//		myHeap.insertMin(12);
//		myHeap.insertMin(11);
//		myHeap.insertMin(8);
//		System.out.println(myHeap.getHeap());
//		myHeap.removeMin();
//		System.out.println(myHeap.getHeap());
//		myHeap.insertMin(3);;
//		System.out.println(myHeap.getHeap());
		
		Heap myHeap = new Heap();
		myHeap.insert(95);
		myHeap.insert(75);
		myHeap.insert(80);
		myHeap.insert(55);
		myHeap.insert(60);
		myHeap.insert(50);
		myHeap.insert(65);
//		myHeap.insertMin(95);
//		myHeap.insertMin(75);
//		myHeap.insertMin(80);
//		myHeap.insertMin(55);
//		myHeap.insertMin(60);
//		myHeap.insertMin(50);
//		myHeap.insertMin(65);
		System.out.println(myHeap.getHeap());
	}

}
