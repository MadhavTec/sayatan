/**
 * 
 */
package com.puzzle;

/**
 * @author Sayantan Saha
 *
 */
public class LargestSubset {

	static long[] maxSubsetSum(int[] k) {

		long[] result = new long[k.length];
		int count = 0;
		for (int i : k) {

			long sum = 0;

			Double temp = Math.sqrt(Double.parseDouble(String.valueOf(i)));

			for (int j = 1; j <= temp.intValue(); j++)

			{

				if (i % j == 0)

				{

					if (j == (i / j))

						sum += j;

					else

						sum += (j + i / j);

				}

			}

			result[count] = sum;
			count++;

		}

		return result;
	}

	public static void main(String[] args) {

		int[] k = { 2, 4 };
		long[] r = LargestSubset.maxSubsetSum(k);
		for (long l : r) {

			System.out.println(l);
		}
	}
}
