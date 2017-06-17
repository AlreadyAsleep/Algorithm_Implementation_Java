import java.util.*;
/*
This class is designed to solve a two-dimensional Knapsack problem
where items are put into a Knapsack which have a value and weight
the algorithm seeks to return the optimal combination of items 
*/
public class Knapsack
{
	/*
	 @param v: int[] - The values of each item
	 @param w: int[] - The weight of each item
	 @param n: int - number of items
	 @param W: int - The max wieght of the Knapsack
	 @requires <pre><@code> v.length == w.length && n > 0 && W > 0</@code></pre>
	 */
	public void computeKnapsack(int[] v, int[] w, int n, int W)
	{
		int[][] V = new int[n + 1][W + 1];
		boolean[][] keep = new boolean[n + 1][W + 1];
		for(int i = 0; i < V[0].length; i++)
		{
			V[0][i] = 0;
		}
		for(int i = 1; i < V.length; i++)
		{
			for(int j = 1; j < V[i].length; j++)
			{
				if((w[i - 1] <= j) && (v[i - 1] + V[i - 1][j - w[i - 1]] > V[i - 1][j - 1]))
				{
					V[i][j] = v[i - 1] + V[i - 1][j - w[i - 1]];
					keep[i ][j ] = true;
				}
				else
				{
					V[i][j] = V[i - 1][j];
					keep[i ][j ] = false;
				}
			}
		}
		int k = W;
		System.out.print("Items: ");
		for(int i = n; i > 0; i--)
		{
			if(keep[i][k])
			{
				System.out.print(i + " ");
				k = k - w[i - 1];
			}
		}
		System.out.println("\nValue: " +  V[n][W]);
	}
	
	public static void main(String[] args)
	{
		Scanner stdin = new Scanner(System.in);
		System.out.println("Enter number of items followed by each value");
		int n = stdin.nextInt();
		int[] v = new int[n];
		for(int i = 0; i < n; i++)
		{
			v[i] = stdin.nextInt();
		}
		System.out.println("Enter the wieghts for each value");
		int[] w = new int[n];
		for(int i = 0; i < n; i++)
		{
			w[i] = stdin.nextInt();
		}
		System.out.println("Enter the max weight of the knapsack");
		int W = stdin.nextInt();
		Knapsack ksack = new Knapsack();
		ksack.computeKnapsack(v, w, n, W);
	}
	/*Discussion*
	The dynamic programming algorithm is more efficient for this problem than 
	recursion/divide&conquer because it does not exhaust every solution
	as the brute-force solution would. It prunes data similar to the way the
	Traveling Salesman algorithm does using DFS and thus reduces runtime and 
	unneccessary caching.


	*/
}
