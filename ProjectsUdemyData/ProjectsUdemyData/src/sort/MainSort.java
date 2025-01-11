package sort;

import java.util.Arrays;

public class MainSort 
{
	// sort by comparing and swapping elements next to each other until the array is sorted in ascending order
	public static void bubbleSort(int[] array)
	{
		// start sorting the elements by pushing the largest element not sorted yet to the end of the array
		for(int i = array.length - 1; i > 0; i--)
		{
			// start sorting from the beginning of the array to compare and swap adjacent elements that are not sorted yet
			for(int j = 0; j < i; j++)
			{
				// if the current element is larger than the element in the next index
				if(array[j] > array[j + 1])
				{
					// swap the two elements with each other
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
	}
		
	// sort by finding the index with the minimum value and swapping it with the current index being processed until the array is sorted in ascending order
	public static void selectionSort(int[] array)
	{
		// start sorting from the beginning of the array to check if the current index is the index with the minimum value that has not been sorted yet
		for(int i = 0; i < array.length; i++)
		{
			// assume the current index to be the index with the minimum value
			int minIndex = i;
			
			// find the index with the minimum value in the remaining unsorted portion of the array
			for(int j = i + 1; j < array.length; j++)
			{
				// if the value in the current index is smaller than the value in the given minimum index
				if(array[j] < array[minIndex])
				{
					// set the minimum index to be the current index
					minIndex = j;
				}
			}
			
			// if the current index being processed is not already the index with the minimum value 
			if(i != minIndex)
			{
				// then swap the current index with the index containing the minimum value found
				int temp = array[i];
				array[i] = array[minIndex];
				array[minIndex] = temp;
			}
		}
	}
	
	// sort by repeatedly taking each element and inserting into its correct position in the sorted portion of the array
	public static void insertionSort(int[] array)
	{
		// start sorting the array from the second element of the array
		for(int i = 1; i < array.length; i++)
		{
			// store the value of the current index into temp
			int temp = array[i];
			// start comparing from the adjacent index before the current index
			int j = i - 1;

			// if there's an index before the current index and the value of the current index is smaller than the value in the previous index
			// need to check if j is positive first since there's no such a thing as a negative index in Java
			while(j > -1 && temp < array[j])
			{
				// the current index will store the value of the previous index
				array[j + 1] = array[j];
				// the previous index will store the value of the current index being processed
				array[j] = temp;
				// move to the previous element to compare its value with the value of the current index being processed
				j--;
			}
		}
	}
	
	// merge two sorted arrays into one sorted array
	public static int[] merge(int[] array1, int[] array2)
	{
		// create the array that will merge the first and second array into one sorted array together
		int[] combined = new int[array1.length + array2.length];
		// the index of the combined array where we'll start inserting the values
		int index = 0;
		// the index of the first array where we'll start comparing its value to the value of the second array at index j
		int i = 0;
		// the index of the second array where we'll start comparing its value to the value of the first array at index i
		int j = 0;
		
		// continue comparing the values of both arrays with each other and inserting into the combined array until we passed through all the values of one of the arrays
		while(i < array1.length && j < array2.length)
		{
			// if the current value in array1 is smaller than the current value in array2
			if(array1[i] < array2[j])
			{
				// insert the current value in array1 to the current index processed in the combined array
				combined[index] = array1[i];
				// move to the next index in combined array to be processed
				index++;
				// move to the next index in array1 to compare its value with the current value of array2
				i++;
			}
			else
			{
				// insert the current value in array2 to the current index processed in the combined array
				combined[index] = array2[j];
				// move to the next index in combined array to be processed
				index++;
				// move to the next index in array2 to compare its value with the current value of array1
				j++;
			}
		}
		
		// insert the rest of the values in array1 into the combined array if we didn't passed through all its values yet
		while(i < array1.length)
		{
			// insert the current value in array1 to the current index processed in the combined array
			combined[index] = array1[i];
			// move to the next index in combined array to be processed
			index++;
			// move to the next index in array1 to be inserted into the combined array
			i++;
		}
		
		// insert the rest of the values in array2 into the combined array if we didn't passed through all its values yet
		while(j < array2.length)
		{
			// insert the current value in array2 to the current index processed in the combined array
			combined[index] = array2[j];
			// move to the next index in combined array to be processed
			index++;
			// move to the next index in array2 to be inserted into the combined array
			j++;
		}
		
		// the two sorted arrays are merged into one sorted array
		return combined;
	}
	
	// sort by repeatedly dividing the array into two arrays and merge the divided arrays into sorted arrays until it becomes one sorted array
	public static int[] mergeSort(int[] array)
	{
		// base case, if the length of the array is 1
		if(array.length == 1)
		{
			// we cannot divide the array into two arrays anymore
			return array;
		}
		
		// calculate the middle index where we divide the array into two arrays
		int midIndex = array.length/2;
		// the left array of the original divided array starts from index 0 to the index before the middle index calculated
		int[] left = mergeSort(Arrays.copyOfRange(array, 0, midIndex));
		// the right array of the original divided array starts from the middle index to the last index of the array
		int[] right = mergeSort(Arrays.copyOfRange(array, midIndex, array.length));
		
		// merged two sorted arrays into one sorted array
		return merge(left, right);
	}
	
	// swap two values with each other in a given array
	public static void swap(int[] array, int firstIndex, int secondIndex)
	{
		// store the value of the first index
		int temp = array[firstIndex];
		// replace the value of the first index by the value of the second value
		array[firstIndex] = array[secondIndex];
		// replace the value of the second index by the value stored in temp
		array[secondIndex] = temp;
	}
	
	// helper method to sort by choosing a pivot number which every other number in the array will be compared 
	// and place them in the right half of the array they belong to respectively
	private static int pivot(int[] array, int pivotIndex, int endIndex)
	{
		// swapIndex starts at the index of the pivot
		int swapIndex = pivotIndex;
		
		// traverse through the given array, to place each value to the right half of the array they belong to
		// putting numbers smaller than the pivot in the left half and number larger than the pivot in the right half
		// where the pivot number will be at the center of those halves in the end
		for(int i = pivotIndex + 1; i <= endIndex; i++)
		{
			// if the value of the current index is smaller than the value of the pivot
			if(array[i] < array[pivotIndex])
			{
				// move swapIndex to the next cell of the array
				swapIndex++;
				// then swap the values of the swapIndex and the current index with each other
				swap(array, swapIndex, i);
			}
		}
		
		// swap the values of the pivot and swapIndex which the pivot index is sorted in the array
		swap(array, pivotIndex, swapIndex);
		
		// return the index of the sorted value in this instance
		return swapIndex;
	}
	
	// sort by partitioning an array around a pivot, then recursively sorting the sub-arrays.
	public static void quickSortHelper(int[] array, int left, int right)
	{
		// if the array has at least 2 elements
		if(left < right)
		{
			// get the index of the pivot which will be sorted in the array
			int pivotIndex = pivot(array, left, right);
			
			// sort recursively the left sub-array excluding the value at the pivot index which is already sorted
			quickSortHelper(array, left, pivotIndex - 1);
			// sort recursively the right sub-array excluding the value at the pivot index which is already sorted
			quickSortHelper(array, pivotIndex + 1, right);
		}
	}
	
	// sort the array by calling the method quickSortHelper
	public static void quickSort(int[] array)
	{
		// sort the given array by quick sort
		quickSortHelper(array, 0, array.length - 1);
	}
	
	public static void main(String[] args) 
	{
//		int[] arr = {4, 2, 6, 5, 1, 3};
//		
//		bubbleSort(arr);
//		System.out.println(Arrays.toString(arr));
		
//		int[] arr = {4, 2, 6, 5, 1, 3};
//		
//		selectionSort(arr);
//		System.out.println(Arrays.toString(arr));
		
//		int[] arr = {4, 2, 6, 5, 1, 3};
//		
//		insertionSort(arr);
//		System.out.println(Arrays.toString(arr));
		
//		int[] array1 = {1, 3, 7, 8};
//		int[] array2 = {2, 4, 5, 6};
//		
//		System.out.println(Arrays.toString(merge(array1, array2)));
		
//		int[] originalArray = {3, 1, 4, 2};
//		int[] sortedArray = mergeSort(originalArray);
//		
//		System.out.println("\nOriginal Array: " + Arrays.toString(originalArray));
//		System.out.println("\nSorted Array: " + Arrays.toString(sortedArray));
		
//		int[] myArray = {4, 6, 1, 7, 3, 2, 5};
//		
//		int returnedIndex = pivot(myArray, 0, 6);
//		
//		System.out.println("Returned Index: " + returnedIndex);
//		System.out.println(Arrays.toString(myArray));
		
		int[] myArray = {4, 6, 1, 7, 3, 2, 5};
		
		quickSort(myArray);
				
		System.out.println(Arrays.toString(myArray));
	}

}
