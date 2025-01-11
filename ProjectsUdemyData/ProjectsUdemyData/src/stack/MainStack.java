package stack;

public class MainStack 
{
	// method to reverse a string in a stack using ArrayList
	public static String reverseString(String s)
	{
		// initialize a stack of characters
		StackA<Character> myStack = new StackA<>();
		// initialize an empty string
		String temp = "";
		
		// push each character of the given string in the argument into the stack
		for(int i = 0; i < s.length(); i++)
		{
			// push the character at the specified index (considering the string as an array) into the stack
			myStack.push(s.charAt(i));
		}
		
		// as long as the stack isn't empty
		while(!myStack.isEmpty())
		{
			// pop a character and concatenates it in our string temp
		    temp += myStack.pop();
		}
		
		// return the reversed string
		return temp;
	}
	
	// method to check if every open parenthesis has a closing parenthesis
	public static boolean isBalancedParentheses(String s)
	{
		// initialize a stack of characters
		StackA<Character> myStack = new StackA<>();
				
		// for each character c in the string array
		for(char c : s.toCharArray())
		{
			// if we encounter an open parenthesis in the string s
			if(c == '(')
			{
				// then we push it into the stack
				myStack.push(c);
			}
			// else if the character c is a closing parenthesis
			else if(c == ')')
			{
				// if the stack is empty, it means there's more closing parentheses than opening parentheses encountered in the string s
				if(myStack.isEmpty())
				{
					return false;
				}
				// if the stack isn't empty, then pop an opening parenthesis as it matched a closing one
				myStack.pop();
			}
		}
		
		// if the stack is empty at this point, then we matched all opening parentheses to closing ones
		// else, it means that there were more opening parentheses than closing ones
		return myStack.isEmpty();
	}
	
	// complementary method to check if isBalancedParentheses is working properly
	 public static void testAndPrint(String testStr, boolean expected) 
	 {
	        // Run the test and store the result
	        boolean result = isBalancedParentheses(testStr);
	        
	        // Print the test string, expected result, and actual result
	        System.out.println("Test String: " + testStr);
	        System.out.println("EXPECTED: " + expected);
	        System.out.println("RESULT: " + result);
	        
	        // Check if the test passed or failed
	        if (result == expected) 
	        {
	            System.out.println("STATUS: PASS");
	        } 
	        else 
	        {
	            System.out.println("STATUS: FAIL");
	        }
	        
	        // Print a separator for better readability
	        System.out.println("--------------");
	    }

	// method to sort the elements in a stack in O(n^2)
	public static void sortStack(StackA<Integer> s)
	{
		// create another stack which will help us sort
		StackA <Integer> orderedStack = new StackA<>();
		
		// move all elements to the other stack in a reversed order
		while(!s.isEmpty())
		{
			// create a variable temp to hold an element from the original stack
			int temp = s.pop();
			
			// if the other stack isn't empty then compare temp to the top element of the other stack
			// if the top of the other stack is larger than temp
			while(!orderedStack.isEmpty() && orderedStack.peek() > temp)
			{
				// push the top element of the other stack to the original stack
				s.push(orderedStack.pop());
			}
			
			// else, push temp to the other stack
			orderedStack.push(temp);
		}
		
		// put back all the ordered elements (reverse order) from the other stack into the original stack
		while(!orderedStack.isEmpty())
		{
			// push the top of the other stack into the original stack until it's empty
			s.push(orderedStack.pop());
		}
	}
	 
	public static void main(String[] args) 
	{
//		Stack myStack = new Stack(4);
//		myStack.getTop();
//		myStack.getHeight();
//		myStack.printStack();
		
//		Stack myStack = new Stack(1);
//		myStack.push(2);
//		myStack.push(3);
//		myStack.push(4);
//		myStack.printStack();
//		System.out.println();
//		
//		myStack.pop();
//		myStack.printStack();
		
//		String myString = "hello";
//        String reversedString = reverseString(myString);
//        System.out.println(reversedString);
		
//		testAndPrint("()", true);
//        testAndPrint("()()", true);
//        testAndPrint("(())", true);
//        testAndPrint("()()()", true);
//        testAndPrint("(()())", true);
//        testAndPrint(")()(", false);
//        testAndPrint(")(", false);
//        testAndPrint("(()", false);
//        testAndPrint("))", false);
//        testAndPrint("(", false);
//        testAndPrint(")", false);
		
		StackA<Integer> stack = new StackA<>();
		stack.push(4);
        stack.push(1);
        stack.push(5);
        stack.push(2);
        stack.push(3);

        System.out.println("Before sorting:");
        stack.printStack();

        sortStack(stack);

        System.out.println("\nAfter sorting:");
        stack.printStack();

	}

}
