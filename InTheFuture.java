/**
 * 
 */
package com.puzzle;

/**
 * @author Sayantan Saha
 *
 */
public class InTheFuture {

	static int minNum(int A, int K, int P) {

		int days = 1;
		if (K <= A) {
			return -1;
		} 
		
		
		else {
			int probSolvedByA = P;
			int probSolvedByK = 0;
			for (;;) {
				probSolvedByA += A;
				probSolvedByK += K;
				if (probSolvedByK > probSolvedByA) {
					break;
				}
				days++;
			}
		}
		return days;
	}

	public static void main(String[] args) {

		System.out.println(InTheFuture.minNum(100, 100, 0));
	}
}
