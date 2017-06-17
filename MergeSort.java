/*
This class is an implementation of the MergeSort algorithm found @
<link>https://www.tutorialspoint.com/data_structures_algorithms/merge_sort_algorithm
</link>
@author BenHeil
@since 06172017
*/

public class MergeSort
{
	/*
	@param arr: int[] - the array to be sorted
	@return int[] - the sorted array
	@requires - <pre><@code>arr.length > 0 && arr[arr_i] < Integer.MAX_VALUE
									&& arr[arr_i] > Integer.MIN_VALUE
									</@code></pre>
	@enusres - the returned array will be sorted with a max time complexity of O(nlogn)
	*/
	public static int[] mergesort(int[] arr)
	{
		if(arr.length < 2)
			return arr;
		boolean even = (arr.length) % 2 == 0;

		int[] arr1 = new int[arr.length / 2];
		int[] arr2 = new int[arr.length - arr.length / 2];

		for(int i = 0; i < arr.length / 2; i++)
		{
			arr1[i] = arr[i];
			arr2[i] = arr[i + arr.length / 2];
		} 
		if(!even)
			arr2[arr2.length - 1] = arr[arr.length - 1];

		arr1 = mergesort(arr1);
		arr2 = mergesort(arr2);

		return merge(arr1, arr2);
	}

	public static int[] merge(int[] arr1, int[] arr2)
	{
		int[] arr = new int[arr1.length + arr2.length];

		int arr1_i = 0, arr2_i = 0, arr_i = 0;

		while(arr1_i < arr1.length && arr2_i < arr2.length)
		{
			if(arr1[arr1_i] > arr2[arr2_i])
			{
				arr[arr_i] = arr2[arr2_i];
				arr2_i++;
			}
			else
			{
				arr[arr_i] = arr1[arr1_i];
				arr1_i++;
			}
			arr_i++;
		}

		while(arr1_i < arr1.length)
		{
			arr[arr_i] = arr1[arr1_i];
			arr1_i++;
			arr_i++;
		}

		while(arr2_i < arr2.length)
		{
			arr[arr_i] = arr2[arr2_i];
			arr2_i++;
			arr_i++;
		}
		return arr;

	}

	public static void main(String[] args)
	{
		int[] a = new int[args.length];
		for(int i = 0; i < args.length; i++)
		{
			a[i] = Integer.parseInt(args[i]);
		}
		a = mergesort(a);
		for(int i = 0; i < a.length; i++)
		{
			System.out.print(a[i] + " ");
		}
	}
}	