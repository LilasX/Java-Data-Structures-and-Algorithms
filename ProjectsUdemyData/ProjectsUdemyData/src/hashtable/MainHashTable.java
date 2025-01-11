package hashtable;

import java.util.*;

public class MainHashTable 
{
	// inefficient method to check if two arrays have an element in common O(n^2)
	public static boolean itemInCommonV1(int[] array1, int[] array2)
	{
		// iterate for all elements in array1
		for(int i : array1)
		{
			// iterate through array2 for each element of array1
			for(int j : array2)
			{
				// if an element in array1 is equal to an element in array2
				if(i == j)
				{
					// return true since we found a common element between the two arrays
					return true;
				}
			}
		}
		
		// else, we didn't find any element in common between the two arrays
		return false;
	}
	
	// check if two arrays have an element in common O(n)
	public static boolean itemInCommon(int[] array1, int[] array2)
	{
		// create a type of hash table to store elements of the first array
		HashMap<Integer, Boolean> myHashMap = new HashMap<>();
		
		// for each element in array1
		for(int i : array1)
		{
			// add the current element to the hash map paired with the boolean true
			myHashMap.put(i, true);
		}
			
		// for each element in array2
		for(int j : array2)
		{
			// if the current element is in the hash map, then the get method won't return null
			if(myHashMap.get(j) != null)
			{
				// return true since we found a value in array1 that matches the current value from array2
				return true;
			}
		}
			
		//else, we did not find any element in common between the two arrays
		return false;
	}
	
	// return a list of all duplicates found in an array of integers
	public static List<Integer> findDuplicates(int[] nums)
    {
		// map where the key is an integer in the integer array given and the value is the count of how many times we've seen the key
        HashMap <Integer, Integer> map = new HashMap<>();
        // list to put all the duplicates found
        List<Integer> list = new ArrayList<>();
        
        // for all integers in the integer array given
        for(int i : nums)
        {
        	// if we have already seen the integer (key) in a previous iteration of the loop
            if(map.containsKey(i))
            {
            	// update the value of the count by 1
                map.put(i, map.get(i) + 1);
            }
            // if we find a new integer from the integer array given
            else
            {
            	// add the new integer in the map with the count of 1 as we have seen it once
                map.put(i, 1);
            }
        }
        
        // for all unique integers found in the given integer array
        for(Integer j : map.keySet())
        {
        	// if the count is greater than 1
            if(map.get(j) > 1)
            {
            	// then there's a duplicate so we add the key to the list
                list.add(j);
            }
        }
        
        // return all unique duplicates found
        return list;
    }
	
	// find the first letter in a string that is not repeated in the string
	public static Character firstNonRepeatingChar(String s)
    {
		// map where we store the unique characters of the string paired with a boolean which check if we encounter it more than once
        HashMap<Character, Boolean> map = new HashMap<>();
        
        // check each character in the string
        for(int i = 0; i < s.length(); i++)
        {
        	// get the current character we're looking in the string
            char c = s.charAt(i);
            
            // if the character (key) already exists in the map
            if(map.containsKey(c))
            {
            	// then we change its value to true since it is repeating
                map.put(c, true);
            }
            // if it's a new character that isn't in the map yet
            else
            {
            	// add the character in the map paired with the boolean false since it has not been repeated in the string yet
                map.put(c, false);
            }
        }
        
        // iterate through the string again to find the first non repeating character
        for(int i = 0; i < s.length(); i++)
        {
        	// get the character we're looking in the string currently
            char ch = s.charAt(i);
            
            // if the current character is paired with the boolean false in the map
            if(map.get(ch) == false)
            {
            	// then it was not repeated in the string, return that character since it's the first character not repeating in the string that we found
                return ch;
            }
        }
        
        // else if all characters in the string have more than one occurrence in the string, then there's no character that is non repeating
        return null;
    }
	
	// return the list of strings grouped together if they have the same occurrences of characters regardless of the order
	public static List<List<String>> groupAnagrams(String[] strings)
    {
		// map where the key is the sorted list of characters of a string
		// paired with the list of strings from the String array given that can be created from the list of characters
        HashMap<List<Character>, List<String>> mapLists = new HashMap<>();
        
        // for all strings in the String array given
        for(String s : strings)
        {
        	// create a list of characters to store the characters of the current string
            List<Character> cList = new ArrayList<>();
            
            // iterate through the current string which is treated as an array of characters
            for(int i = 0; i < s.length(); i++)
            {
            	// store the current character we're looking in the string
                char c = s.charAt(i);
                // add the current character in the Character list
                cList.add(c);
            }
            
            // sort the Character list
            Collections.sort(cList);
            
            // create String list to add in the map as the value
            List<String> sList = new ArrayList<>();
            
            // if the Character list (key) already exists in the map
            if(mapLists.containsKey(cList))
            {
            	// get the String list from the map (value)
                sList = mapLists.get(cList);
                // add the current string into the String list
                sList.add(s);
                // then update the map String list (value) for the respective Character list (key)
                mapLists.put(cList, sList);
            }
            // else if it's a string that produced a different Character list
            else
            {
            	// add the string to the String list
                sList.add(s);
                // then add new Character list (key) and String list (value) in the map
                mapLists.put(cList, sList);
            }
        }
        
        // the list of list of strings is the list of all values in the map (String list)
        List<List<String>> list = new ArrayList<>(mapLists.values());
        
        // return the list of the groups of anagrams
        return list;
    }
	
	// returns the indices of two numbers in the array that add up to the target number
	public static int[] twoSum(int[] nums, int target)
    {
		// create a map where the key is a number in the array
		// and the value is its index in the array
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // iterate through the array
        for(int i = 0; i < nums.length; i++)
        {
        	// if the complement is found in the map (key)
            if(map.containsKey(target - nums[i]))
            {
            	// then return an array containing the index of the current number in the array and the index of the complement
                return new int[] {map.get(target - nums[i]), i};
            }
            
            // else add the number of the array and its index in the map
            map.put(nums[i], i);
        }
        
        // return an empty array if the sum (target) cannot be produced with the numbers in the array
        return new int[] {};
    }
	
	// find the subarray which contains the indices of the numbers in the array that add up to the target number
	public static int[] subarraySum(int[] nums, int target)
    {
		// create a map which stores the sum of subsequent numbers in the array as the key
		// and the index of the last number added to the sum as the value
        HashMap<Integer, Integer> map = new HashMap<>();
        // initiate the sum of the numbers we went through the array to 0
        int sum = 0;
        
        // put the default pair which is the sum starting at 0 as we haven't gotten through the array yet
        // and the index at -1 as we haven't considered the first number in the array into the sum which is at index 0
        map.put(0, -1);
        
        // iterate through the array starting from the first index 0
        for(int i = 0; i < nums.length; i++)
        {
        	// add the number in the current index to the sum
            sum += nums[i];
            
            // if the difference between the sum and target can be found in the map as the key (previous calculated sum)
            if(map.containsKey(sum-target))
            {
            	// return an array which contains the value (index) where the key is the difference and increment the index by 1
            	// and the other element in the array is the current index
                return new int[] {map.get(sum-target) + 1, i};
            }
            
            // else if the difference between the sum and target isn't found in the map as key, put the current sum and the current index in the map
            map.put(sum, i);
        }
        
        // if we didn't find a subarray which the numbers add up to the target, then return an empty array
        return new int[] {};
    }
	
	// returns an ArrayList which contains all the unique integers of a given List
	public static List<Integer> removeDuplicates(List<Integer> myList)
    {
		// create a set where we add all elements of the given list to the set
		// a set do not accept duplicates by default
        HashSet<Integer> set = new HashSet<>(myList);
        
        // return the set as an ArrayList
        return new ArrayList<>(set);
    }
	
	// check if the string doesn't have any duplicates
	public static boolean hasUniqueChars(String s)
    {
		// create a set of character
        HashSet<Character> set = new HashSet<>();
        
        // iterate through the string as if treated as an array of characters
        for(int i = 0; i < s.length(); i++)
        {
        	// get the current character of the string
            char c = s.charAt(i);
            
            // if we're unable to add the current character into the set (because the same character already exist in the set)
            if(!set.add(c))
            {
            	// return false, since it means there's a duplicate in the string
                return false;
            }
            // else if we can add the character in the set
            else
            {
            	// add the current character into the set
                set.add(c);
            }
        }
        
        // no duplicate has been found in the string
        return true;
    }
	
	// find a pair where each integer are from their respective array and adds up together to the target number
	public static List<int[]> findPairs(int[] arr1, int[] arr2, int target)
    {
		// create a set to convert the first array to a set
        HashSet<Integer> set = new HashSet<>();
        // the list that contains all pairs
        List<int[]> pairs = new ArrayList<>();
        
        // add all elements of the first array to the set (would also remove duplicates if there are any)
        for(int i : arr1)
        {
        	// add the integer into the set
            set.add(i);
        }
        
        // iterate through the second array
        for(int j : arr2)
        {
        	// if the complement (target number - an integer in the second array) can be found in the set
            if(set.contains(target - j))
            {
            	// then add the complement and the current integer from the second array to the list as a pair
                pairs.add(new int[] {target - j, j});
            }
        }
        
        // return the list of all pairs where each adds up to the target number
        return pairs;
    }
	
	// find the length of the longest consecutive sequence in an array
	public static int longestConsecutiveSequence(int[] nums)
    {
		// create a set to put all unique elements from the array
        HashSet<Integer> set = new HashSet<>();
        
        // iterate through the given array
        for(int i : nums)
        {
        	// add the elements of the given array to the set (removes duplicates as well)
            set.add(i);
        }
        
        // the current count of consecutive sequence
        int count = 0;
        // the longest consecutive sequence count
        int max = 0;
        
        // iterate through all elements in the set
        for(Integer j : set)
        {
        	// if the current integer is the first number of a sequence
            if(!set.contains(j - 1))
            {
            	// store the current integer
                int current = j;
                // the count is incremented by one since we started a sequence
                count = 1;
                
                // loop as long as there is a number that continues the sequence
                while(set.contains(current + 1))
                {
                	// set the current number to the next number in the sequence
                    current++;
                    // increment the count since the length of the sequence increased
                    count++;
                }
                
                // if the current length of the sequence is larger than the current longest streak
                if(count > max)
                {
                	// set the longest streak to the current length of the sequence found
                    max = count;
                }
            }
        }
        
        // return the length of the longest consecutive sequence
        return max;
    }
	
	/**
     * Test method for longestConsecutiveSequence.
     * @param title Title of the test
     * @param nums Input array
     * @param expected Expected result
     */
	// check if the method longestConsecutiveSequence is working properly
    private static void testLongestConsecutiveSequence(String title, int[] nums, int expected) 
    {
    	// print the type of sequence we're expecting
        System.out.println("Test: " + title);
        // print the elements of the array
        System.out.print("Testing array: ");
        for (int num : nums) 
        {
            System.out.print(num + " ");
        }
        System.out.println();
    
        // print the result of the method longestConsecutiveSequence
        int result = longestConsecutiveSequence(nums);
        // print the expected result which is the answer the method should arrive
        System.out.println("Expected longest streak: " + expected);
        // print what the method has found as answer
        System.out.println("Actual longest streak: " + result);
    
        // if the result of the method is the same as the answer we're expecting
        if (result == expected) 
        {
        	// then the method has passed the test
            System.out.println("PASS\n");
        } 
        // if the result of the method is different than the answer
        else 
        {
        	// then the method failed the test
            System.out.println("FAIL\n");
        }
    }
	
	public static void main(String[] args) 
	{
//		HashTable myHT = new HashTable();
//		
//		myHT.set("nails", 100);
//		myHT.set("tile", 50);
//		myHT.set("lumber", 80);
//		myHT.set("bolts", 200);
//		myHT.set("screws", 140);
//		
//		myHT.printTable();
//		
//		myHT.set("screws", 40);
//		
//		myHT.printTable();
		
//		System.out.println(myHT.get("nails"));
//		System.out.println(myHT.get("tile"));
//		System.out.println(myHT.get("lumber"));
//		System.out.println(myHT.get("bolts"));
//		System.out.println(myHT.get("screws"));
//		System.out.println(myHT.get("inexistent"));
//		
//		System.out.println(myHT.keys());
		
//		int[] array1 = {1, 3, 5};
//		int[] array2 = {2, 4, 5};
//		
//		System.out.println(itemInCommonV1(array1, array2));
//		System.out.println(itemInCommon(array1, array2));
		
//		int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
//	    List<Integer> duplicates = findDuplicates(nums);
//	    System.out.println(duplicates); 
//	      
//	    int[] nums1 = {1, 2, 3, 4, 5};
//	    List<Integer> duplicates1 = findDuplicates(nums1);
//	    System.out.println(duplicates1); 
//	      
//	    int[] nums2 = {3, 3, 3, 3, 3};
//	    List<Integer> duplicates2 = findDuplicates(nums2);
//	    System.out.println(duplicates2); 
//	      
//	    int[] nums3 = {-1, 0, 1, 0, -1, -1, 2, 2};
//	    List<Integer> duplicates3 = findDuplicates(nums3);
//	    System.out.println(duplicates3); 
//	      
//	    int[] nums4 = {};
//	    List<Integer> duplicates4 = findDuplicates(nums4);
//	    System.out.println(duplicates4); 
		
//		System.out.println(firstNonRepeatingChar("leetcode"));
//	    System.out.println(firstNonRepeatingChar("levels"));
//	    System.out.println(firstNonRepeatingChar("aabbcc"));
		
//		System.out.println("1st set:");
//	    System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
//
//	    System.out.println("\n2nd set:");
//	    System.out.println(groupAnagrams(new String[]{"abc", "cba", "bac", "foo", "bar"}));
//
//      System.out.println("\n3rd set:");
//      System.out.println(groupAnagrams(new String[]{"listen", "silent", "triangle", "integral", "garden", "ranged"}));
		
//		System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
//      System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
//      System.out.println(Arrays.toString(twoSum(new int[]{3, 3}, 6)));
//      System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5}, 10)));
//      System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5}, 7)));
//      System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5}, 3)));
//      System.out.println(Arrays.toString(twoSum(new int[]{}, 0)));
		
//		int[] nums1 = {1, 2, 3, 4, 5};
//      int target1 = 9;
//      int[] result1 = subarraySum(nums1, target1);
//      System.out.println("[" + result1[0] + ", " + result1[1] + "]");
//
//      int[] nums2 = {-1, 2, 3, -4, 5};
//      int target2 = 0;
//      int[] result2 = subarraySum(nums2, target2);
//      System.out.println("[" + result2[0] + ", " + result2[1] + "]");
//
//      int[] nums3 = {2, 3, 4, 5, 6};
//      int target3 = 3;
//      int[] result3 = subarraySum(nums3, target3);
//      System.out.println("[" + result3[0] + ", " + result3[1] + "]");
//
//      int[] nums4 = {};
//      int target4 = 0;
//      int[] result4 = subarraySum(nums4, target4);
//      System.out.println("[]");
		
//		List<Integer> myList = List.of(1, 2, 3, 4, 1, 2, 5, 6, 7, 3, 4, 8, 9, 5);
//      List<Integer> newList = removeDuplicates(myList);
//      System.out.println(newList);
		
//		System.out.println(hasUniqueChars("abcdefg")); // should return true
//      System.out.println(hasUniqueChars("hello")); // should return false
//      System.out.println(hasUniqueChars("")); // should return true
//      System.out.println(hasUniqueChars("0123456789")); // should return true
//      System.out.println(hasUniqueChars("abacadaeaf")); // should return false
		
//		int[] arr1 = {1, 2, 3, 4, 5};
//      int[] arr2 = {2, 4, 6, 8, 10};
//      int target = 7;
//
//      List<int[]> pairs = findPairs(arr1, arr2, target);
//      for (int[] pair : pairs) 
//      {
//          System.out.println(Arrays.toString(pair));
//      }
		
		testLongestConsecutiveSequence("Consecutive Integers", new int[] {1, 2, 3, 4, 5}, 5);
        testLongestConsecutiveSequence("No Sequence", new int[] {1, 3, 5, 7, 9}, 1);
        testLongestConsecutiveSequence("Duplicates", new int[] {1, 2, 2, 3, 4}, 4);
        testLongestConsecutiveSequence("Negative Numbers", new int[] {1, 0, -1, -2, -3}, 5);
        testLongestConsecutiveSequence("Empty Array", new int[] {}, 0);
        testLongestConsecutiveSequence("Multiple Sequences", new int[] {1, 2, 3, 10, 11, 12, 13}, 4);
        testLongestConsecutiveSequence("Unordered Elements", new int[] {5, 1, 3, 4, 2}, 5);
        testLongestConsecutiveSequence("Single Element", new int[] {1}, 1);
        testLongestConsecutiveSequence("All Identical Elements", new int[] {2, 2, 2, 2, 2}, 1);
	}

}
