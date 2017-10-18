/**
 * 
 */
package com.puzzle;

/**
 * @author ss85783
 *
 */
public class ConsecutiveSum {

	static int consecutive(long num) {
		long sum = 0;
		int count = 0;
		long size;
		if (num % 2 != 0) {
			size = num / 2 + 1;
		} else {
			size = num / 2;
		}
		for (int i = 1; i <= size; i++) {
			for (int j = i; j <= size; j++) {
				sum = sum + j;
				if (sum == num) {
					sum = 0;
					count++;
					break;
				} else if (sum > num) {
					sum = 0;
					break;
				}
			}
		}
		System.out.println(count);
		return count;

	}

	public static void main(String[] args) {

		ConsecutiveSum.consecutive(10);
	}
}
