/*
This class is an implementation of a common Binary Search algorithm
that theoretically has a runtime complexity of O(nlogn)
*/
public class BinarySearch{

	/*
	@param a : int[] - the array to be searched
	@param low : int - the lower bound index of the search
	@param high : int - the upper bound index of the search
	@param key : int - the key to be found
	@return int - the index of the key in the array
	@requires - <pre>the array passed must be sorted 
		<@code> a.length > 0 && low < a.length && low > 0
					&& high < a.length && high > 0
					&& low < high </@code>
	@enures - the index of the key will be found or (-1) returned otherwise

	*/
	public int search(int[] a, int low, int high, int key)
	{
		if(low > high)
			return -1;
		int midIndex = (low + high) / 2;
		if(a[midIndex] == key)
			return midIndex;
		else if(key > a[midIndex])
			return search(a, midIndex + 1, high, key);
		else
			return search(a, low, midIndex - 1, key);
	}
	
	public static void main(String[] args)
	{
		BinarySearch bS = new BinarySearch();
		int[] arr = new int[args.length - 1];
		int key = Integer.parseInt(args[0]);
		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = Integer.parseInt(args[i+1]);
		}
		int answer = bS.search(arr, 0, arr.length - 1, key);
		if(answer > 0)
			System.out.println("Key " + key + " is the " +  ((int)answer + 1) + "th term in the array" );
		else
			System.out.println("Key " + key + " is not in the array");
	}
	
	
}