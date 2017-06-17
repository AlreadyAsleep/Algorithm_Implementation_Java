/*
This class is an implementation of a common quicksort algorith that can be found at
<link>
https://www.tutorialspoint.com/data_structures_algorithms/quick_sort_algorithm.htm
</link>
*/
public class QuickSort
{
	/*
	@param a : int[] - the array to be sorted
	@requires <pre><@code>a.length > 0 </pre>
	@ensures the array will be sorted and stored in its original place on the Heap
	*/
	public static void quicksort(int[] a)
	{
		 quicksort(a, 0, a.length - 1);
	}

	private static void quicksort(int[] a, int left, int right)
	{
		
		if(right - left <= 0)//base case
		{
			return;
		}
		else
		{
			int pivot = a[right];
			int partition = partition(a, left, right, pivot);
			quicksort(a, left, partition - 1);
			quicksort(a, partition + 1, right);
		}
	}

	public static int partition(int[] a, int left, int right, int pivot)
	{
		
		int leftPointer = left;
		int rightPointer = right - 1;

		while(true)
		{
			while(a[leftPointer] < pivot)
			{
				leftPointer++;
			}
			while(rightPointer > 0 && a[rightPointer] > pivot)
			{
				rightPointer--;
			}
			if(leftPointer < rightPointer)
			{
				int temp = a[rightPointer];
				a[rightPointer] = a[leftPointer];
				a[leftPointer] = temp;
			}
			else
				break;
		}

		int temp1 = a[right];
		a[right] = a[leftPointer];
		a[leftPointer] = temp1;
		return leftPointer;
	}

	public static void main(String[] args)
	{
		int[] a = new int[args.length];
		for(int i = 0; i < args.length; i++)
		{
			a[i] = Integer.parseInt(args[i]);
		}
		quicksort(a);
		for(int i = 0; i < a.length; i++)
		{
			System.out.print(a[i] + " ");
		}
	}
}