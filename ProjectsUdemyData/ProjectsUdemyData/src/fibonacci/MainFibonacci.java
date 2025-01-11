package fibonacci;

public class MainFibonacci 
{
	// counter to keep track of how many method calls we have
	static int counter = 0;
	
	// find the Fibonacci number from the given position n in the Fibonacci sequence
	// method is O(2^n)
	public static int fib(int n)
	{
		// increment every time we call this method
		counter++;
		
		// base case, if the position is 0 or 1
		if(n == 0 || n == 1)
		{
			// then the Fibonacci number will also be 0 or 1 in the sequence respectively
			return n;
		}
		
		// find the Fibonacci number in the position n 
		// by adding the Fibonacco number from the previous position
		// with the Fibonacci number before the previous position
		return fib(n - 1) + fib(n - 2);
	}
	
	// create an array where all cells are initialized to null to store previous results of the method fibMemo
	static Integer[] memo = new Integer[100];
	// counter to keep track of how many method calls we have
	static int counterMemo = 0;
	
	// find the Fibonacci number from the given position n in the Fibonacci sequence with memoization
	// method is O(2n - 1) = O(n)
	public static int fibMemo(int n)
	{
		// increment every time we call this method
		counterMemo++;
		
		// if there's already a result found previously from this method for this n position
		if(memo[n] != null)
		{
			// return that Fibonacci number found previously, it's an O(1) operation
			return memo[n];
		}
		
		// base case, if the position is 0 or 1
		// the Fibonacci number found for these positions won't be stored into the memo array
		if(n == 0 || n == 1)
		{
			// then the Fibonacci number will also be 0 or 1 in the sequence respectively
			return n;
		}
		
		// store the new Fibonacci number found in the sequence in the memo array
		memo[n] = fibMemo(n - 1) + fibMemo(n - 2);
		
		// return the Fibonacci number found for this n position
		return memo[n];
	}
	
	// counter to keep track of how many times we calculated the Fibonacci number at their respective position until we reach the one we're looking for
	static int counterIterative = 0;
	
	// bottom up approach, O(n - 1) = O(n)
	// // find the Fibonacci number from the given position n in the Fibonacci sequence iteratively
	public static int fibIterative(int n)
	{
		
		// create an array which each index corresponds to the position of the Fibonacci number we're looking for
		// this is used to store all the numbers in the Fibonacci sequence until the one we're looking for
		int[] fibList = new int[n + 1];
		
		// populate the first two cells in the fibList array since they are the base cases
		fibList[0] = 0;
		fibList[1] = 1;
				
		// find the Fibonacci number for each position in the array starting from the second index 
		// where we start calculating the Fibonacci number for each index in the array representing the position of the Fibonacci numbers
		for(int i = 2; i <= n; i++)
		{
			// increment every time we calculate a Fibonacci number and insert it into the array
			counterIterative++;
			
			// formula to find the Fibonacci number for the current index (position)
			fibList[i] = fibList[i - 1] + fibList[i - 2];
		}
		
		// return the Fibonacci number at position n
		return fibList[n];
	}
	
	public static void main(String[] args) 
	{
		int n = 7;
		
		System.out.println("\nFibonacci of " + n + " = " + fib(n));
		System.out.println("\nCounter: " + counter);
		
		System.out.println("\nFibonacci of " + n + " = " + fibMemo(n));
		System.out.println("\nCounter: " + counterMemo);
		
		System.out.println("\nFibonacci of " + n + " = " + fibIterative(n));
		System.out.println("\nCounter: " + counterIterative);
	}

}
