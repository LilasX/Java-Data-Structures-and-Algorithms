package array;

import java.util.*;

public class MainArray 
{
	// remove a given value from the array by shifting the other elements to the front of the array and modifying its length
	// the elements after the length of the array aren't considered
	public static int removeElement(int[] nums, int val) 
    {
		// the number of times we have seen the value to be removed in the array
        int count = 0;
        
        // iterate through the array
        for(int i = 0; i < nums.length; i++)
        {
        	// if the value at the current index is not the value to be removed
            if(nums[i] != val)
            {
            	// then from the current index, shift to the front of the array by the number of times we currently saw the value to be removed
            	// and copy the value into the index found by shifting from the current index
                nums[i - count] = nums[i];
            }
            // if the value at the current index is the value to be removed
            else
            {
            	// increment each time the value to be removed has been found in the array
                count++;
            }
        }
        
        // the new length will be the original length of the array minus the number of times the value to be removed appeared in the array
        return nums.length - count;
    }
	
	// find the maximum and minimum value of an array
	public static int[] findMaxMin(int[] myList)
    {
		// set minimum and maximum value to the first value of the array
        int min = myList[0];
        int max = myList[0];
        
        // iterate through the array
        for(int num : myList)
        {
        	// if the current number is smaller than the current min
            if(num < min)
            {
            	// then set min to the current number
                min = num;
            }
            // else if the current number is larger than the current max
            else if(num > max)
            {
            	// then set max to the current number
                max = num;
            }
        }
        
        // put the max found in the first index and min found in the second index of the new array created to return
        return new int[] {max, min};
    }
	
	// find the longest string in a given String array
	public static String findLongestString(String[] stringList)
    {
		// initialize the longest string as an empty string (length 0)
        String longest = "";
        
        // iterate through the array
        for(String s : stringList)
        {
        	// if the length of the current string is longer than the current longest string
            if(s.length() > longest.length())
            {
            	// then make the current string the longest string found in the array
                longest = s;
            }
        }
        
        // return the longest string found in the array
        return longest;
    }
	
	// remove the duplicates by shifting the unique elements to the front of the array and modifying its length
	// the elements beyond the new length are not considered
	public static int removeDuplicates(int[] nums)
    {
		// if the array is empty
        if(nums.length == 0)
        {
        	// then the length is 0
            return 0;
        }
        
        // represent the index with the current unique value to be compared
        int current = 0;
        
        // iterate through the array
        for(int i = 0; i < nums.length; i++)
        {
        	// if the value of the index is different than the value of the current index with the unique value
            if(nums[i] != nums[current])
            {
            	// move current to the next cell to modify the value to the one at the index
                current++;
                // set the value of the current index to the value at the index
                nums[current] = nums[i];
            }
        }
        
        // return the new length which is the value of current 
        // (which represented the current index to modify in the array to a unique value) plus one
        // since the indices start from zero to the length of the array minus one
        return current + 1;
    }
	
	// find the maximum profit given an array representing prices of a given stock on different days
	// need to consider that we must buy a stock before selling it to make profit
	public static int maxProfit(int[] prices)
    {
		// if the array is empty
        if(prices.length == 0)
        {
        	// then nothing to buy and sell, so no profit
            return 0;
        }
        
        // assume the price of the first day to be the minimum price encountered
        int min = prices[0];
        // the max profit is zero as we haven't started buying and selling
        int max = 0;
        
        // iterate through the array of prices
        for(int price : prices)
        {
        	// if the current price is smaller than the minimum price we encountered
            if(price < min)
            {
            	// then the minimum price encountered is the current price
                min = price;
            }
            
            // calculate the profit made by subtracting the current price with the minimum price encountered previously
            int profit = price - min;
            
            // if the current profit calculated is larger than the maximum profit made previously
            if(profit > max)
            {
            	// then the maximum profit made is the current profit calculated
                max = profit;
            }
        }
        
        // return the maximum profit calculated
        return max;
    }
	
	// rotate the array by shifting the values by k position to the right
	public static void rotate(int[] nums, int k)
    {
		// update the shifting value to a value within the valid index range of the array
        k = k % nums.length;
        
        // if the shifting value ends up being 0
        if(k == 0)
        {
        	// then there's no need to rotate 
        	// since rotating the array by shifting k times will result into the original array
            return;
        }
        
        // create a reference to the last index of the array
        int lastIndex = nums.length - 1;
        
        // go through half of the array to reverse the whole array
        for(int i = 0; i < nums.length/2; i++)
        {
        	// swap the values from the values at the ends of the array to the values in the middle of the array
            int temp = nums[i];
            nums[i] = nums[lastIndex - i];
            nums[lastIndex - i] = temp;
        }
        
        // reverse back the first k elements of the array
        for(int j = 0; j < k/2; j++)
        {
        	// swap the values
            int temp = nums[j];
            nums[j] = nums[k - 1 - j];
            nums[k - 1 - j] = temp;
        }
        
        // reverse back the rest of the array
        for(int m = 0; m < (nums.length - k)/2; m++)
        {
        	// swap the values
            int temp = nums[m + k];
            nums[m + k] = nums[lastIndex - m];
            nums[lastIndex - m] = temp;
        }
    }
	
	// find the maximum sum that the values in a contiguous sub-array can produce from this array 
	public static Integer maxSubarray(int[] nums)
    {
		// if the array is empty
        if(nums.length == 0)
        {
        	// then no maximum sum to return, not even zero since the array can contain negative values and zeroes
            return null;
        }
        
        // initialize the current sum to zero
        int sum = 0;
        // initialize the current maximum sum to the first element of the array
        int max = nums[0];
        
        // iterate through the array
        for(int i = 0; i < nums.length; i++)
        {
        	// add the current value to the current sum
            sum = sum + nums[i];
            
            // if the current sum is larger than the current maximum sum
            if(sum > max)
            {
            	// the maximum sum becomes the current sum
                max = sum;
            }
            
            // if the current number is larger than the maximum sum
            if(nums[i] > max)
            {
            	// start a new sub-array, the sum restarts from the current value
                sum = nums[i];
                // the current maximum sum becomes the current value
                max = sum;
            }
        }
        
        // return the maximum sum found
        return max;
    }
	
	public static void main(String[] args) 
	{
//		// Test case 1
//        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        int val1 = 1;
//        int newLength1 = removeElement(nums1, val1);
//        System.out.println("Test case 1: Modified array: " +
//                           Arrays.toString(Arrays.copyOfRange(nums1, 0, newLength1)) +
//                           "\nNew length: " + newLength1);
//                           
//        // Test case 2
//        int[] nums2 = {1, 2, 3, 4, 5, 6};
//        int val2 = 6;
//        int newLength2 = removeElement(nums2, val2);
//        System.out.println("Test case 2: Modified array: " +
//                           Arrays.toString(Arrays.copyOfRange(nums2, 0, newLength2)) +
//                           "\nNew length: " + newLength2);
//                           
//        // Test case 3
//        int[] nums3 = {-1, -2, -3, -4, -5};
//        int val3 = -1;
//        int newLength3 = removeElement(nums3, val3);
//        System.out.println("Test case 3: Modified array: " +
//                           Arrays.toString(Arrays.copyOfRange(nums3, 0, newLength3)) +
//                           "\nNew length: " + newLength3);
//    
//        // Test case 4
//        int[] nums4 = {};
//        int val4 = 1;
//        int newLength4 = removeElement(nums4, val4);
//        System.out.println("Test case 4: Modified array: " +
//                           Arrays.toString(Arrays.copyOfRange(nums4, 0, newLength4)) +
//                           "\nNew length: " + newLength4);
//    
//        // Test case 5
//        int[] nums5 = {1, 1, 1, 1, 1};
//        int val5 = 1;
//        int newLength5 = removeElement(nums5, val5);
//        System.out.println("Test case 5: Modified array: " +
//                           Arrays.toString(Arrays.copyOfRange(nums5, 0, newLength5)) +
//                           "\nNew length: " + newLength5);
		
//		int[] myList1 = {5, 3, 8, 1, 6, 9};
//        int[] result1 = findMaxMin(myList1);
//        System.out.println("Test case 1: MaxMin: " + Arrays.toString(result1)); // prints "[9, 1]"
//
//        int[] myList2 = {-5, -3, -8, -1, -6, -9};
//        int[] result2 = findMaxMin(myList2);
//        System.out.println("Test case 2: MaxMin: " + Arrays.toString(result2)); // prints "[-1, -9]"
//
//        int[] myList3 = {0, 0, 0, 0, 0};
//        int[] result3 = findMaxMin(myList3);
//        System.out.println("Test case 3: MaxMin: " + Arrays.toString(result3)); // prints "[0, 0]"
//
//        int[] myList4 = {100, 200, 300, 400, 500};
//        int[] result4 = findMaxMin(myList4);
//        System.out.println("Test case 4: MaxMin: " + Arrays.toString(result4)); // prints "[500, 100]"
		
//		String[] stringList1 = {"apple", "banana", "kiwi", "pear"};
//        String longest1 = findLongestString(stringList1);
//        System.out.println("Test case 1: Longest string: " + longest1);  // prints "banana"
//        
//        String[] stringList2 = {"cat", "giraffe", "elephant", "hippopotamus"};
//        String longest2 = findLongestString(stringList2);
//        System.out.println("Test case 2: Longest string: " + longest2);  // prints "hippopotamus"
//
//        String[] stringList3 = {"sun", "moon", "planet", "universe"};
//        String longest3 = findLongestString(stringList3);
//        System.out.println("Test case 3: Longest string: " + longest3);  // prints "universe"
//        
//        String[] stringList4 = {"java", "python", "javascript", "c"};
//        String longest4 = findLongestString(stringList4);
//        System.out.println("Test case 4: Longest string: " + longest4);  // prints "javascript"
//
//        String[] stringList5 = {"", "a", "aa", "aaa"};
//        String longest5 = findLongestString(stringList5);
//        System.out.println("Test case 5: Longest string: " + longest5);  // prints "aaa"
		
//		int[] nums1 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
//        int newLength1 = removeDuplicates(nums1);
//        System.out.println("Test case 1: New length: " + newLength1);
//        System.out.println("Test case 1: Unique values in list: " + Arrays.toString(Arrays.copyOfRange(nums1, 0, newLength1)));
//
//        int[] nums2 = {1, 1, 2};
//        int newLength2 = removeDuplicates(nums2);
//        System.out.println("Test case 2: New length: " + newLength2);
//        System.out.println("Test case 2: Unique values in list: " + Arrays.toString(Arrays.copyOfRange(nums2, 0, newLength2)));
//
//        int[] nums3 = {-1, 0, 0, 0, 3, 3};
//        int newLength3 = removeDuplicates(nums3);
//        System.out.println("Test case 3: New length: " + newLength3);
//        System.out.println("Test case 3: Unique values in list: " + Arrays.toString(Arrays.copyOfRange(nums3, 0, newLength3)));
//
//        int[] nums4 = {};
//        int newLength4 = removeDuplicates(nums4);
//        System.out.println("Test case 4: New length: " + newLength4);
//        System.out.println("Test case 4: Unique values in list: " + Arrays.toString(Arrays.copyOfRange(nums4, 0, newLength4)));
//
//        int[] nums5 = {1, 1, 1, 1, 1};
//        int newLength5 = removeDuplicates(nums5);
//        System.out.println("Test case 5: New length: " + newLength5);
//        System.out.println("Test case 5: Unique values in list: " + Arrays.toString(Arrays.copyOfRange(nums5, 0, newLength5)));
		
//		int[] prices1 = {7, 1, 5, 3, 6, 4};
//        int profit1 = maxProfit(prices1);
//        System.out.println("Test case 1: Maximum profit: " + profit1); // prints "Maximum profit: 5"
//        
//        int[] prices2 = {7, 6, 5, 4, 3, 2, 1};
//        int profit2 = maxProfit(prices2);
//        System.out.println("Test case 2: Maximum profit: " + profit2); // prints "Maximum profit: 0"
//
//        int[] prices3 = {1, 2, 3, 4, 5, 6, 7};
//        int profit3 = maxProfit(prices3);
//        System.out.println("Test case 3: Maximum profit: " + profit3); // prints "Maximum profit: 6"
//
//        int[] prices4 = {3, 2, 6, 5, 0, 3};
//        int profit4 = maxProfit(prices4);
//        System.out.println("Test case 4: Maximum profit: " + profit4); // prints "Maximum profit: 4"
//
//        int[] prices5 = {2, 4, 1};
//        int profit5 = maxProfit(prices5);
//        System.out.println("Test case 5: Maximum profit: " + profit5); // prints "Maximum profit: 2"
		
//		int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
//        int k1 = 3;
//        rotate(nums1, k1);
//        System.out.println("Test case 1: Rotated array: " + Arrays.toString(nums1));  // prints "Rotated array: [5, 6, 7, 1, 2, 3, 4]"
//
//        int[] nums2 = {-1, -100, 3, 99};
//        int k2 = 2;
//        rotate(nums2, k2);
//        System.out.println("Test case 2: Rotated array: " + Arrays.toString(nums2));  // prints "Rotated array: [3, 99, -1, -100]"
//
//        int[] nums3 = {1, 2};
//        int k3 = 3;
//        rotate(nums3, k3);
//        System.out.println("Test case 3: Rotated array: " + Arrays.toString(nums3));  // prints "Rotated array: [2, 1]"
//
//        int[] nums4 = {1};
//        int k4 = 0;
//        rotate(nums4, k4);
//        System.out.println("Test case 4: Rotated array: " + Arrays.toString(nums4));  // prints "Rotated array: [1]"
//
//        int[] nums5 = {1, 2, 3, 4, 5, 6};
//        int k5 = 6;
//        rotate(nums5, k5);
//        System.out.println("Test case 5: Rotated array: " + Arrays.toString(nums5));  // prints "Rotated array: [1, 2, 3, 4, 5, 6]"
		
		// Example 1: Simple case with positive and negative numbers
        int[] inputCase1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result1 = maxSubarray(inputCase1);
        System.out.println("Example 1: Input: " + Arrays.toString(inputCase1) + "\nResult: " + result1);  

        // Example 2: Case with a negative number in the middle
        int[] inputCase2 = {1, 2, 3, -4, 5, 6};
        int result2 = maxSubarray(inputCase2);
        System.out.println("Example 2: Input: " + Arrays.toString(inputCase2) + "\nResult: " + result2); 

        // Example 3: Case with all negative numbers
        int[] inputCase3 = {-1, -2, -3, -4, -5};
        int result3 = maxSubarray(inputCase3);
        System.out.println("Example 3: Input: " + Arrays.toString(inputCase3) + "\nResult: " + result3); 

        // Example 4: Case with all positive numbers
        int[] inputCase4 = {1, 2, 3, 4, 5};
        int result4 = maxSubarray(inputCase4);
        System.out.println("Example 4: Input: " + Arrays.toString(inputCase4) + "\nResult: " + result4); 

        // Example 5: Case with alternating positive and negative numbers
        int[] inputCase5 = {1, -1, 1, -1, 1};
        int result5 = maxSubarray(inputCase5);
        System.out.println("Example 5: Input: " + Arrays.toString(inputCase5) + "\nResult: " + result5); 
    }

}
