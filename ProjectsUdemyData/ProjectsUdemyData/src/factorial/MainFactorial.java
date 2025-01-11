package factorial;

public class MainFactorial 
{

	// factorial method n!
	public static int factorial(int n)
	{
		// if the parameter's value is 1
		if(n == 1)
		{
			// then return 1
			return 1;
		}
		
		// multiply current n by the method itself until the given n is 1
		return n * factorial(n-1);
	}
	
	public static void main(String[] args) 
	{
		int f = factorial(4);
		
		System.out.println(f);
	}

}
